/**
 *
 */
package com.gzj.tulip.jade.plugin.sql.dialect.mysql;

import com.gzj.tulip.jade.plugin.sql.Plum.Operator;
import com.gzj.tulip.jade.plugin.sql.dialect.ISQLGenerator;
import com.gzj.tulip.jade.plugin.sql.mapper.ConditionalOperationMapper;
import com.gzj.tulip.jade.plugin.sql.mapper.IColumnMapper;
import com.gzj.tulip.jade.plugin.sql.mapper.IParameterMapper;
import com.gzj.tulip.jade.plugin.sql.sqlconditions.AbstractConditions;
import com.gzj.tulip.jade.plugin.sql.util.PlumUtils;
import com.gzj.tulip.jade.statement.StatementRuntime;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alan.Geng[gengzhi718@gmail.com]
 */
public abstract class ConditionalGenerator implements ISQLGenerator<ConditionalOperationMapper> {

    private static final Map<Operator, String> OPERATORS;

    static {
        Map<Operator, String> operators = new HashMap<Operator, String>(Operator.values().length);
        operators.put(Operator.EQ, " = ");
        operators.put(Operator.NE, " != ");
        operators.put(Operator.GE, " >= ");
        operators.put(Operator.GT, " > ");
        operators.put(Operator.LE, " <= ");
        operators.put(Operator.LT, " < ");
        operators.put(Operator.LIKE, " LIKE ");
        operators.put(Operator.IN, " IN ");

        OPERATORS = Collections.unmodifiableMap(operators);
    }

    @Override
    public String generate(ConditionalOperationMapper operationMapper, StatementRuntime runtime) {
        StringBuilder sql = new StringBuilder();
        if (!PlumUtils.isBlank(runtime.getSQL())) {
            sql = new StringBuilder(runtime.getSQL());
        }
        beforeApplyConditions(operationMapper, runtime, sql);
        applyConditions(operationMapper, runtime, sql);
        afterApplyConditions(operationMapper, runtime, sql);
        return sql.toString();
    }

    protected void applyConditions(ConditionalOperationMapper operationMapper, StatementRuntime runtime, StringBuilder sql) {
        if (operationMapper.isPrimaryKeyMode()) {
            sql.append(" WHERE ");
            List<IColumnMapper> primaryKey = operationMapper.getTargetEntityMapper().getPrimaryKey();

            for (int i = 0; i < primaryKey.size(); i++) {
                IColumnMapper col = primaryKey.get(i);
                if (i > 0) {
                    sql.append(" AND ");
                }

                sql.append(col.getName());
                sql.append(" = ");
                sql.append(":");

                // TODO:当实体为符合主键并且参数列表中的顺序与实体中字段顺序不一致，则会发生错误。
                sql.append(i + 1);
            }
        } else if (operationMapper.isComplexMode()) {
            List<IParameterMapper> parameters = operationMapper.getParameters();
            if (PlumUtils.isNotEmpty(parameters)) {
                int i = operationMapper.getWhereAt();
                if (i < 0) {
                    // 无任何参数被标记为Where，则视为所有参数都是Where条件。
                    i = 0;
                }

                String and = "";
                for (; i < parameters.size(); i++) {
                    IParameterMapper param = parameters.get(i);
                    Object obj = runtime.getParameters().get(param.getName());
                    if (obj instanceof AbstractConditions) {//如果是通用条件
                        applyWhere((AbstractConditions) obj, sql, param);
                    } else {
                        String condition = generateCondition(operationMapper, param, runtime, i);

                        if (condition != null) {
                            if (and.length() == 0) {
                                sql.append(" WHERE ");
                            }
                            sql.append(and);
                            sql.append(condition);
                            and = " AND ";
                        }
                    }
                }
            }
        } else {
            throw new UnsupportedOperationException("Unknown condition mode.");
        }
    }

    protected String generateCondition(ConditionalOperationMapper operationMapper, IParameterMapper param, StatementRuntime runtime, int index) {
        Operator op = param.getOperator();

        if (!OPERATORS.containsKey(op)) {
            return null;
        }

        Object value = runtime.getParameters().get(":" + (index + 1));
        boolean nullValue = value == null;
        boolean ignoreNull = param.isIgnoreNull();

        if ((ignoreNull
                && nullValue)
                || (nullValue
                && op == Operator.IN)) {
            // When parameter value is null and operator is "in", or ignore null value.
            return null;
        }

        StringBuilder sql = new StringBuilder();

        sql.append(param.getName());

        if (op != Operator.LIKE
                && op != Operator.EQ
                && op != Operator.IN) {
            // Multiple parameter value at the same column.(e.g. age >= 15 AND age < 22)
            // In "Jade" framework, Parameter value appears first will be overwritten when the same name in annotation "SQLParam".
            sql.append(OPERATORS.get(op));
            sql.append(":");
            sql.append(index + 1);
        } else {
            if (nullValue
                    && op == Operator.EQ) {
                sql.append(" is null ");
            } else {
                // Normally, the "like", "in" or "=" condition only once at the same column.
                sql.append(OPERATORS.get(op));
                if (op == Operator.IN) {
                    sql.append("(");
                }
                sql.append(":");
                sql.append(param.getOriginalName());
                if (op == Operator.IN) {
                    sql.append(")");
                }
            }
        }

        return sql.toString();
    }

    /**
     * 解析where条件
     *
     * @param conditions
     * @param sql
     * @param param
     */
    protected void applyWhere(AbstractConditions conditions, StringBuilder sql, IParameterMapper param) {
        if (conditions == null) {
            return;
        }

        sql.append(" WHERE ");

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;

        parmPhrase1 = "%s #(:" + param.getName() + ".oredCriteria[%d].allCriteria[%d].value)";
        parmPhrase1_th = "%s #(:" + param.getName() + ".oredCriteria[%d].allCriteria[%d].value,typeHandler=%s)";
        parmPhrase2 = "%s #(:" + param.getName() + ".oredCriteria[%d].allCriteria[%d].value) and #(:" + param.getName() + ".oredCriteria[%d].criteria[%d].secondValue)";
        parmPhrase2_th = "%s #(:" + param.getName() + ".oredCriteria[%d].allCriteria[%d].value,typeHandler=%s) and #(:" + param.getName() + ".oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s)";
        parmPhrase3 = "#(:" + param.getName() + ".oredCriteria[%d].allCriteria[%d].value[%d])";
        parmPhrase3_th = "#(:" + param.getName() + ".oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s)";

        StringBuilder sb = new StringBuilder();
        List<AbstractConditions.GeneratedCriteria> oredCriteria = conditions.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            AbstractConditions.GeneratedCriteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<AbstractConditions.Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    AbstractConditions.Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else if ("connect_symbol".equals(criterion.getConnectSymbol())) {//括号
                        firstCriterion = true;
                    } else {
                        sb.append(" " + criterion.getConnectSymbol() + " ");
                    }

                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0) {
            sql.append(sb.toString());
        }
    }

    protected void beforeApplyConditions(ConditionalOperationMapper operationMapper, StatementRuntime runtime, StringBuilder sql) {

    }

    protected void afterApplyConditions(ConditionalOperationMapper operationMapper, StatementRuntime runtime, StringBuilder sql) {

    }

}
