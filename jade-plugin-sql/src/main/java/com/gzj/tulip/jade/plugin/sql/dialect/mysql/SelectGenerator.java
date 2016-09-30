/**
 *
 */
package com.gzj.tulip.jade.plugin.sql.dialect.mysql;

import com.gzj.tulip.jade.plugin.sql.mapper.ConditionalOperationMapper;
import com.gzj.tulip.jade.plugin.sql.mapper.IColumnMapper;
import com.gzj.tulip.jade.plugin.sql.mapper.IParameterMapper;
import com.gzj.tulip.jade.plugin.sql.sqlconditions.AbstractConditions;
import com.gzj.tulip.jade.plugin.sql.util.PlumUtils;
import com.gzj.tulip.jade.statement.StatementRuntime;
import com.gzj.tulip.jade.plugin.sql.Order;
import com.gzj.tulip.jade.plugin.sql.Order.Direction;
import com.gzj.tulip.jade.plugin.sql.Order.Group;
import com.gzj.tulip.jade.plugin.sql.mapper.IEntityMapper;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alan.Geng[gengzhi718@gmail.com]
 */
public class SelectGenerator extends ConditionalGenerator {

    private static final Map<Direction, String> DIRECTIONS;

    static {
        Map<Direction, String> directions = new HashMap<Order.Direction, String>(2);
        directions.put(Direction.ASC, "ASC");
        directions.put(Direction.DESC, "DESC");

        DIRECTIONS = Collections.unmodifiableMap(directions);
    }

    @Override
    protected void beforeApplyConditions(ConditionalOperationMapper operationMapper, StatementRuntime runtime, StringBuilder sql) {
        super.beforeApplyConditions(operationMapper, runtime, sql);
        if (sql.toString().contains("count(*)")) {
            return;
        }
        IEntityMapper targetEntityMapper = operationMapper.getTargetEntityMapper();
        List<IColumnMapper> columns = targetEntityMapper.getColumns();

        sql.append(operationMapper.getName());
        sql.append(" ");

        DISTINCT(operationMapper, runtime, sql);

        for (IColumnMapper col : columns) {
            String name = col.getName();
            sql.append(name);
            sql.append(",");
        }

        sql.setLength(sql.length() - 1);
        sql.append(" FROM ");
        sql.append(targetEntityMapper.getName());
    }

    @Override
    protected void afterApplyConditions(ConditionalOperationMapper operationMapper, StatementRuntime runtime, StringBuilder sql) {
        super.afterApplyConditions(operationMapper, runtime, sql);
        //applyOrderBy(operationMapper, runtime, sql);
        ORDERBY(operationMapper, runtime, sql);
        applyRange(operationMapper, runtime, sql);
    }

    @Deprecated//暂时废弃，此方法不实用（无法解决多个排序字段的排序问题），也不是特别方便
    protected void applyOrderBy(ConditionalOperationMapper operationMapper, StatementRuntime runtime, StringBuilder sql) {
        if (operationMapper.containsOrder()) {
            IEntityMapper targetEntityMapper = operationMapper.getTargetEntityMapper();

            Order order = null;
            Integer orderParameterIndex = operationMapper.getOrderParameterIndex();

            if (orderParameterIndex == -1) {
                order = targetEntityMapper.getDefaultOrder();
            } else {
                Object value = runtime.getParameters().get(":" + (operationMapper.getOrderParameterIndex() + 1));
                order = (Order) value;
            }

            sql.append(" ORDER BY ");

            List<Group> groups = order.getGroups();

            if (groups.size() > 0) {
                for (Group group : groups) {
                    String[] fields = group.getFields();

                    for (String field : fields) {
                        IColumnMapper col = targetEntityMapper.getColumnMapperByFieldName(field);

                        if (col != null) {

                            sql.append(col.getName());
                            sql.append(" ");
                            sql.append(DIRECTIONS.get(group.getDirection()));
                            sql.append(",");
                        } else {
                            throw new IllegalArgumentException("Cannot find column by field name \"" + field + "\".");
                        }
                    }
                }

                sql.setLength(sql.length() - 1);
            }
        }
    }

    protected void applyRange(ConditionalOperationMapper operationMapper, StatementRuntime runtime, StringBuilder sql) {
        Map<String, Object> parameters = runtime.getParameters();

        Number offset = null;
        Number limit = null;

        if (operationMapper.containsOffset()) {
            offset = (Number) parameters.get(":" + (operationMapper.getOffsetParameterIndex() + 1));
        }

        if (operationMapper.containsLimit()) {
            limit = (Number) parameters.get(":" + (operationMapper.getLimitParameterIndex() + 1));
        }

        if (limit == null && offset == null) {
            return;
        }

        sql.append(" LIMIT :__offset, :__limit");

        if (limit != null && offset != null) {
            parameters.put("__offset", offset);
            parameters.put("__limit", limit);
        } else if (offset != null) {
            parameters.put("__offset", offset);
            parameters.put("__limit", -1);
        } else if (limit != null && limit.longValue() >= 0) {
            parameters.put("__offset", 0);
            parameters.put("__limit", limit);
        }
    }

    protected void DISTINCT(ConditionalOperationMapper operationMapper, StatementRuntime runtime, StringBuilder sql) {
        IParameterMapper param = operationMapper.getParameters().get(0);
        Object obj = runtime.getParameters().get(param.getName());
        if (obj instanceof AbstractConditions) {//如果是通用条件
            AbstractConditions conditions = (AbstractConditions) obj;
            if (conditions.isDistinct()) {
                sql.append(" DISTINCT ");
            }
        }
    }

    protected void ORDERBY(ConditionalOperationMapper operationMapper, StatementRuntime runtime, StringBuilder sql) {
        IParameterMapper param = operationMapper.getParameters().get(0);
        Object obj = runtime.getParameters().get(param.getName());
        if (obj instanceof AbstractConditions) {//如果是通用条件
            AbstractConditions conditions = (AbstractConditions) obj;
            if (!PlumUtils.isBlank(conditions.getOrderByClause())) {
                sql.append(" ORDER BY " + conditions.getOrderByClause() + " ");
            }
        }
    }
}
