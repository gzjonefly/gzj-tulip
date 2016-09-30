/**
 *
 */
package com.gzj.tulip.jade.plugin.sql.dialect.mysql;

import com.gzj.tulip.jade.plugin.sql.dialect.ISQLGenerator;
import com.gzj.tulip.jade.plugin.sql.mapper.*;
import com.gzj.tulip.jade.plugin.sql.util.PlumUtils;
import com.gzj.tulip.jade.statement.StatementRuntime;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author Alan.Geng[gengzhi718@gmail.com]
 */
public class InsertGenerator implements ISQLGenerator<OperationMapper> {

    /* (non-Javadoc)
     * @see com.cainiao.depot.project.biz.common.jade.dialect.ISQLGenerator#generate(com.cainiao.depot.project.biz.common.jade.mapper.IOperationMapper)
     */
    @Override
    public String generate(OperationMapper operationMapper, StatementRuntime runtime) {
        if (!operationMapper.getName().equals(IOperationMapper.OPERATION_INSERT)) {
            throw new IllegalArgumentException("Operation mapper must be a insert.");
        }

        List<IParameterMapper> parameters = operationMapper.getParameters();

        if (CollectionUtils.isEmpty(parameters)) {
            throw new IllegalArgumentException("Insert operation must have parameters.");
        }

        IEntityMapper targetEntityMapper = operationMapper.getTargetEntityMapper();

        IParameterMapper entityParam = parameters.get(0);

        String sqlStr = runtime.getSQL();
        if (!PlumUtils.isBlank(sqlStr) && sqlStr.contains("{table_columns}")) {//替换列名逻辑（批量insert）
            sqlStr = sqlStr.replace("{table_name}", targetEntityMapper.getName());
            List<IParameterMapper> expandParams = ((IExpandableParameterMapper) entityParam).expand();
            StringBuilder columns = new StringBuilder();//存储列名

            StringBuilder values = new StringBuilder("#for(variant in ");
            values.append(":");
            values.append(entityParam.getName());
            values.append(")");
            values.append("{ ");
            values.append("(");

            for (IParameterMapper param : expandParams) {
                //如果需要过滤空值
                if (param.isIgnoreNull()) {
                    Map<String, Object> paramValueMap = runtime.getParameters();
                    Object obj = paramValueMap.get(entityParam.getName());
                    Field field = param.getColumnMapper().getOriginal();
                    try {
                        Object o;
                        if (obj instanceof List) {
                            o = field.get(((List) obj).get(0));
                        } else {
                            o = field.get(obj);
                        }

                        if (o == null) {
                            continue;
                        }
                    } catch (IllegalAccessException e) {
                        throw new IllegalArgumentException("Cannot get field value \"" + operationMapper.getTargetEntityMapper().getOriginal().getSimpleName() + "." + field.getName() + "\".", e);
                    }
                }

                columns.append(param.getColumnMapper().getName());
                columns.append(",");

                values.append(":");
                values.append("variant");
                values.append(".");
                values.append(param.getColumnMapper().getOriginalName());
                values.append(",");
            }
            columns.setLength(columns.length() - 1);
            values.setLength(values.length() - 1);
            values.append("), }");
            sqlStr = sqlStr.replace("{table_columns}", columns.toString());
            sqlStr = sqlStr.replace("{table_values}", values.toString());

            return sqlStr.toString();
        } else if (entityParam instanceof IExpandableParameterMapper) {//单个insert逻辑
            List<IParameterMapper> expandParams = ((IExpandableParameterMapper) entityParam).expand();
            StringBuilder sql = new StringBuilder("INSERT INTO ");
            StringBuilder values = new StringBuilder();
            sql.append(targetEntityMapper.getName());
            sql.append("(");

            for (IParameterMapper param : expandParams) {
                //add by guozijan 2016-09-28 start
                //如果需要过滤空值
                if (param.isIgnoreNull()) {
                    Map<String, Object> paramValueMap = runtime.getParameters();
                    Object obj = paramValueMap.get(entityParam.getName());
                    Field field = param.getColumnMapper().getOriginal();
                    try {
                        Object o = field.get(obj);
                        if (o == null) {
                            continue;
                        }
                    } catch (IllegalAccessException e) {
                        throw new IllegalArgumentException("Cannot get field value \"" + operationMapper.getTargetEntityMapper().getOriginal().getSimpleName() + "." + field.getName() + "\".", e);
                    }
                }
                //add by guozijan 2016-09-28 end

                sql.append(param.getColumnMapper().getName());
                sql.append(",");

                values.append(":");
                values.append(entityParam.getName());
                values.append(".");
                values.append(param.getColumnMapper().getOriginalName());
                values.append(",");
            }
            sql.setLength(sql.length() - 1);
            values.setLength(values.length() - 1);

            sql.append(")VALUES(");
            sql.append(values.toString());
            sql.append(")");

            return sql.toString();
        } else {
            throw new IllegalArgumentException("Parameter \"" + entityParam.getOriginalName() + "\" cannot expend.");
        }
    }

}
