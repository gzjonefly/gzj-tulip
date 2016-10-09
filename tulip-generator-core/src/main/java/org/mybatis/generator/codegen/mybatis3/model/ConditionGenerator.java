package org.mybatis.generator.codegen.mybatis3.model;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.AbstractJavaGenerator;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

import java.util.ArrayList;
import java.util.List;

import static org.mybatis.generator.internal.util.JavaBeansUtil.getGetterMethodName;
import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * @author guozijian
 * @date 2016/10/9 10:05
 */
public class ConditionGenerator extends AbstractJavaGenerator {
    public ConditionGenerator() {
        super();
    }

    @Override
    public List<CompilationUnit> getCompilationUnits() {
        FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
        progressCallback.startTask(getString(
                "Progress.6", table.toString())); //$NON-NLS-1$
        CommentGenerator commentGenerator = context.getCommentGenerator();

        FullyQualifiedJavaType type = new FullyQualifiedJavaType(
                introspectedTable.getConditionType());
        TopLevelClass topLevelClass = new TopLevelClass(type);

        topLevelClass.setSuperClass("AbstractConditions");//add by guozijian
        topLevelClass.addImportedType("com.gzj.tulip.jade.plugin.sql.sqlconditions.AbstractConditions");

        topLevelClass.addImportedType(FullyQualifiedJavaType
                .getNewListInstance());
        topLevelClass.addImportedType(FullyQualifiedJavaType
                .getNewArrayListInstance());

        topLevelClass.setVisibility(JavaVisibility.PUBLIC);
        commentGenerator.addJavaFileComment(topLevelClass);

        // add default constructor
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setConstructor(true);
        method.setName(type.getShortName());
        method.addBodyLine("oredCriteria = new ArrayList<GeneratedCriteria>();"); //$NON-NLS-1$

        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("or"); //$NON-NLS-1$
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
        method.addBodyLine("Criteria criteria = createCriteriaInternal();"); //$NON-NLS-1$
        method.addBodyLine("oredCriteria.add(criteria);"); //$NON-NLS-1$
        method.addBodyLine("return criteria;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("createCriteria"); //$NON-NLS-1$
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
        method.addBodyLine("Criteria criteria = createCriteriaInternal();"); //$NON-NLS-1$
        method.addBodyLine("if (oredCriteria.size() == 0) {"); //$NON-NLS-1$
        method.addBodyLine("oredCriteria.add(criteria);"); //$NON-NLS-1$
        method.addBodyLine("}"); //$NON-NLS-1$
        method.addBodyLine("return criteria;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setName("createCriteriaInternal"); //$NON-NLS-1$
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
        method.addBodyLine("Criteria criteria = new Criteria();"); //$NON-NLS-1$
        method.addBodyLine("return criteria;"); //$NON-NLS-1$
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        // now generate the inner class that holds the AND conditions
        topLevelClass
                .addInnerClass(getGeneratedCriteriaInnerClass(topLevelClass));

        //topLevelClass.addInnerClass(getCriteriaInnerClass());

        //topLevelClass.addInnerClass(getCriterionInnerClass());

        List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
        if (context.getPlugins().modelExampleClassGenerated(
                topLevelClass, introspectedTable)) {
            answer.add(topLevelClass);
        }
        return answer;
    }

    private InnerClass getCriterionInnerClass() {
        Field field;
        Method method;

        InnerClass answer = new InnerClass(new FullyQualifiedJavaType(
                "Criterion")); //$NON-NLS-1$
        answer.setVisibility(JavaVisibility.PUBLIC);
        answer.setStatic(true);
        context.getCommentGenerator().addClassComment(answer,
                introspectedTable);

        field = new Field();
        field.setName("condition"); //$NON-NLS-1$
        field.setType(FullyQualifiedJavaType.getStringInstance());
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field();
        field.setName("value"); //$NON-NLS-1$
        field.setType(FullyQualifiedJavaType.getObjectInstance());
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field();
        field.setName("secondValue"); //$NON-NLS-1$
        field.setType(FullyQualifiedJavaType.getObjectInstance());
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field();
        field.setName("noValue"); //$NON-NLS-1$
        field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field();
        field.setName("singleValue"); //$NON-NLS-1$
        field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field();
        field.setName("betweenValue"); //$NON-NLS-1$
        field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field();
        field.setName("listValue"); //$NON-NLS-1$
        field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        field = new Field();
        field.setName("typeHandler"); //$NON-NLS-1$
        field.setType(FullyQualifiedJavaType.getStringInstance());
        field.setVisibility(JavaVisibility.PRIVATE);
        answer.addField(field);
        answer.addMethod(getGetter(field));

        method = new Method();
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setName("Criterion"); //$NON-NLS-1$
        method.setConstructor(true);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addBodyLine("super();"); //$NON-NLS-1$
        method.addBodyLine("this.condition = condition;"); //$NON-NLS-1$
        method.addBodyLine("this.typeHandler = null;"); //$NON-NLS-1$
        method.addBodyLine("this.noValue = true;"); //$NON-NLS-1$
        answer.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setName("Criterion"); //$NON-NLS-1$
        method.setConstructor(true);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "typeHandler")); //$NON-NLS-1$
        method.addBodyLine("super();"); //$NON-NLS-1$
        method.addBodyLine("this.condition = condition;"); //$NON-NLS-1$
        method.addBodyLine("this.value = value;"); //$NON-NLS-1$
        method.addBodyLine("this.typeHandler = typeHandler;"); //$NON-NLS-1$
        method.addBodyLine("if (value instanceof List<?>) {"); //$NON-NLS-1$
        method.addBodyLine("this.listValue = true;"); //$NON-NLS-1$
        method.addBodyLine("} else {"); //$NON-NLS-1$
        method.addBodyLine("this.singleValue = true;"); //$NON-NLS-1$
        method.addBodyLine("}"); //$NON-NLS-1$
        answer.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setName("Criterion"); //$NON-NLS-1$
        method.setConstructor(true);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value")); //$NON-NLS-1$
        method.addBodyLine("this(condition, value, null);"); //$NON-NLS-1$
        answer.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setName("Criterion"); //$NON-NLS-1$
        method.setConstructor(true);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "secondValue")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "typeHandler")); //$NON-NLS-1$
        method.addBodyLine("super();"); //$NON-NLS-1$
        method.addBodyLine("this.condition = condition;"); //$NON-NLS-1$
        method.addBodyLine("this.value = value;"); //$NON-NLS-1$
        method.addBodyLine("this.secondValue = secondValue;"); //$NON-NLS-1$
        method.addBodyLine("this.typeHandler = typeHandler;"); //$NON-NLS-1$
        method.addBodyLine("this.betweenValue = true;"); //$NON-NLS-1$
        answer.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setName("Criterion"); //$NON-NLS-1$
        method.setConstructor(true);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "secondValue")); //$NON-NLS-1$
        method.addBodyLine("this(condition, value, secondValue, null);"); //$NON-NLS-1$
        answer.addMethod(method);

        return answer;
    }

    private InnerClass getCriteriaInnerClass() {
        Method method;

        InnerClass answer = new InnerClass(FullyQualifiedJavaType
                .getCriteriaInstance());

        answer.setVisibility(JavaVisibility.PUBLIC);
        answer.setStatic(true);
        answer.setSuperClass(FullyQualifiedJavaType
                .getGeneratedCriteriaInstance());

        context.getCommentGenerator().addClassComment(answer,
                introspectedTable, true);

        method = new Method();
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setName("Criteria"); //$NON-NLS-1$
        method.setConstructor(true);
        method.addBodyLine("super();"); //$NON-NLS-1$
        answer.addMethod(method);

        return answer;
    }

    private InnerClass getGeneratedCriteriaInnerClass(
            TopLevelClass topLevelClass) {
        Method method;

        InnerClass answer = new InnerClass(FullyQualifiedJavaType
                .getCriteriaInstance());

        answer.setSuperClass("GeneratedCriteria");
        answer.setVisibility(JavaVisibility.PUBLIC);
        answer.setStatic(true);
        context.getCommentGenerator().addClassComment(answer,
                introspectedTable);

        method = new Method();
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setName("Criteria"); //$NON-NLS-1$
        method.setConstructor(true);
        method.addBodyLine("super();"); //$NON-NLS-1$
        answer.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("startAndBracket"); //$NON-NLS-1$
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
        method.addBodyLine("addCriterion(\"connect_symbol\", \" and ( \");"); //$NON-NLS-1$
        method.addBodyLine("return (Criteria) this;"); //$NON-NLS-1$
        answer.addMethod(method);

        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("endBracket"); //$NON-NLS-1$
        method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
        method.addBodyLine("addCriterion(\"connect_symbol\", \" ) \");"); //$NON-NLS-1$
        method.addBodyLine("return (Criteria) this;"); //$NON-NLS-1$
        answer.addMethod(method);

        List<String> criteriaLists = new ArrayList<String>();
        criteriaLists.add("criteria"); //$NON-NLS-1$

        for (IntrospectedColumn introspectedColumn : introspectedTable
                .getNonBLOBColumns()) {
            if (stringHasValue(introspectedColumn
                    .getTypeHandler())) {
                String name = addtypeHandledObjectsAndMethods(
                        introspectedColumn, method, answer);
                criteriaLists.add(name);
            }
        }

        for (IntrospectedColumn introspectedColumn : introspectedTable
                .getNonBLOBColumns()) {
            topLevelClass.addImportedType(introspectedColumn
                    .getFullyQualifiedJavaType());

            // here we need to add the individual methods for setting the
            // conditions for a field
            answer.addMethod(getSetNullMethod(introspectedColumn));
            answer.addMethod(getSetNotNullMethod(introspectedColumn));
            answer.addMethod(getSetEqualMethod(introspectedColumn));
            answer.addMethod(getSetNotEqualMethod(introspectedColumn));
            answer.addMethod(getSetGreaterThanMethod(introspectedColumn));
            answer
                    .addMethod(getSetGreaterThenOrEqualMethod(introspectedColumn));
            answer.addMethod(getSetLessThanMethod(introspectedColumn));
            answer.addMethod(getSetLessThanOrEqualMethod(introspectedColumn));

            if (introspectedColumn.isJdbcCharacterColumn()) {
                answer.addMethod(getSetLikeMethod(introspectedColumn));
                answer.addMethod(getSetNotLikeMethod(introspectedColumn));
            }

            answer.addMethod(getSetInOrNotInMethod(introspectedColumn, true));
            answer.addMethod(getSetInOrNotInMethod(introspectedColumn, false));
            answer.addMethod(getSetBetweenOrNotBetweenMethod(
                    introspectedColumn, true));
            answer.addMethod(getSetBetweenOrNotBetweenMethod(
                    introspectedColumn, false));
        }

        return answer;
    }

    private List<Method> getSetNullMethod(IntrospectedColumn introspectedColumn) {
        return getNoValueMethod(introspectedColumn, "IsNull", "is null"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private List<Method> getSetNotNullMethod(IntrospectedColumn introspectedColumn) {
        return getNoValueMethod(introspectedColumn, "IsNotNull", "is not null"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private List<Method> getSetEqualMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "EqualTo", "="); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private List<Method> getSetNotEqualMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "NotEqualTo", "<>"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private List<Method> getSetGreaterThanMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "GreaterThan", ">"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private List<Method> getSetGreaterThenOrEqualMethod(
            IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn,
                "GreaterThanOrEqualTo", ">="); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private List<Method> getSetLessThanMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "LessThan", "<"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private List<Method> getSetLessThanOrEqualMethod(
            IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn,
                "LessThanOrEqualTo", "<="); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private List<Method> getSetLikeMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "Like", "like"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private List<Method> getSetNotLikeMethod(IntrospectedColumn introspectedColumn) {
        return getSingleValueMethod(introspectedColumn, "NotLike", "not like"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private List<Method> getSingleValueMethod(IntrospectedColumn introspectedColumn,
                                              String nameFragment, String operator) {
        String arr[] = {"and", "or"};
        List<Method> methods = new ArrayList<Method>();
        for (int i = 0; i < arr.length; i++) {
            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            method.addParameter(new Parameter(introspectedColumn
                    .getFullyQualifiedJavaType(), "value")); //$NON-NLS-1$
            StringBuilder sb = new StringBuilder();
            sb.append(introspectedColumn.getJavaProperty());
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            sb.insert(0, arr[i]); //$NON-NLS-1$
            sb.append(nameFragment);
            method.setName(sb.toString());
            method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
            sb.setLength(0);

            if (introspectedColumn.isJDBCDateColumn()) {
                sb.append("addCriterionForJDBCDate(\""); //$NON-NLS-1$
            } else if (introspectedColumn.isJDBCTimeColumn()) {
                sb.append("addCriterionForJDBCTime(\""); //$NON-NLS-1$
            } else if (stringHasValue(introspectedColumn
                    .getTypeHandler())) {
                sb.append("add"); //$NON-NLS-1$
                sb.append(introspectedColumn.getJavaProperty());
                sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
                sb.append("Criterion(\""); //$NON-NLS-1$
            } else {
                sb.append("addCriterion(\""); //$NON-NLS-1$
            }

            sb.append(MyBatis3FormattingUtilities
                    .getAliasedActualColumnName(introspectedColumn));
            sb.append(' ');
            sb.append(operator);
            sb.append("\", "); //$NON-NLS-1$
            sb.append("value"); //$NON-NLS-1$
            sb.append(", \""); //$NON-NLS-1$
            sb.append(introspectedColumn.getJavaProperty());
            sb.append("\");"); //$NON-NLS-1$
            method.addBodyLine(sb.toString());
            method.addBodyLine("return (Criteria) this;"); //$NON-NLS-1$

            methods.add(method);
        }

        return methods;
    }

    /**
     * Generates methods that set between and not between conditions
     *
     * @param introspectedColumn
     * @param betweenMethod
     * @return a generated method for the between or not between method
     */
    private List<Method> getSetBetweenOrNotBetweenMethod(
            IntrospectedColumn introspectedColumn, boolean betweenMethod) {
        String arr[] = {"and", "or"};
        List<Method> methods = new ArrayList<Method>();
        for (int i = 0; i < arr.length; i++) {
            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            FullyQualifiedJavaType type = introspectedColumn
                    .getFullyQualifiedJavaType();

            method.addParameter(new Parameter(type, "value1")); //$NON-NLS-1$
            method.addParameter(new Parameter(type, "value2")); //$NON-NLS-1$
            StringBuilder sb = new StringBuilder();
            sb.append(introspectedColumn.getJavaProperty());
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            sb.insert(0, arr[i]); //$NON-NLS-1$
            if (betweenMethod) {
                sb.append("Between"); //$NON-NLS-1$
            } else {
                sb.append("NotBetween"); //$NON-NLS-1$
            }
            method.setName(sb.toString());
            method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
            sb.setLength(0);

            if (introspectedColumn.isJDBCDateColumn()) {
                sb.append("addCriterionForJDBCDate(\""); //$NON-NLS-1$
            } else if (introspectedColumn.isJDBCTimeColumn()) {
                sb.append("addCriterionForJDBCTime(\""); //$NON-NLS-1$
            } else if (stringHasValue(introspectedColumn
                    .getTypeHandler())) {
                sb.append("add"); //$NON-NLS-1$
                sb.append(introspectedColumn.getJavaProperty());
                sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
                sb.append("Criterion(\""); //$NON-NLS-1$
            } else {
                sb.append("addCriterion(\""); //$NON-NLS-1$
            }

            sb.append(MyBatis3FormattingUtilities
                    .getAliasedActualColumnName(introspectedColumn));
            if (betweenMethod) {
                sb.append(" between"); //$NON-NLS-1$
            } else {
                sb.append(" not between"); //$NON-NLS-1$
            }
            sb.append("\", "); //$NON-NLS-1$
            sb.append("value1, value2"); //$NON-NLS-1$
            sb.append(", \""); //$NON-NLS-1$
            sb.append(introspectedColumn.getJavaProperty());
            sb.append("\");"); //$NON-NLS-1$
            method.addBodyLine(sb.toString());
            method.addBodyLine("return (Criteria) this;"); //$NON-NLS-1$

            methods.add(method);
        }

        return methods;
    }

    /**
     * @param introspectedColumn
     * @param inMethod           if true generates an "in" method, else generates a "not in"
     *                           method
     * @return a generated method for the in or not in method
     */
    private List<Method> getSetInOrNotInMethod(IntrospectedColumn introspectedColumn,
                                               boolean inMethod) {
        String arr[] = {"and", "or"};
        List<Method> methods = new ArrayList<Method>();
        for (int i = 0; i < arr.length; i++) {
            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            FullyQualifiedJavaType type = FullyQualifiedJavaType
                    .getNewListInstance();
            if (introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
                type.addTypeArgument(introspectedColumn.getFullyQualifiedJavaType()
                        .getPrimitiveTypeWrapper());
            } else {
                type
                        .addTypeArgument(introspectedColumn
                                .getFullyQualifiedJavaType());
            }

            method.addParameter(new Parameter(type, "values")); //$NON-NLS-1$
            StringBuilder sb = new StringBuilder();
            sb.append(introspectedColumn.getJavaProperty());
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            sb.insert(0, arr[i]); //$NON-NLS-1$
            if (inMethod) {
                sb.append("In"); //$NON-NLS-1$
            } else {
                sb.append("NotIn"); //$NON-NLS-1$
            }
            method.setName(sb.toString());
            method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
            sb.setLength(0);

            if (introspectedColumn.isJDBCDateColumn()) {
                sb.append("addCriterionForJDBCDate(\""); //$NON-NLS-1$
            } else if (introspectedColumn.isJDBCTimeColumn()) {
                sb.append("addCriterionForJDBCTime(\""); //$NON-NLS-1$
            } else if (stringHasValue(introspectedColumn
                    .getTypeHandler())) {
                sb.append("add"); //$NON-NLS-1$
                sb.append(introspectedColumn.getJavaProperty());
                sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
                sb.append("Criterion(\""); //$NON-NLS-1$
            } else {
                sb.append("addCriterion(\""); //$NON-NLS-1$
            }

            sb.append(MyBatis3FormattingUtilities
                    .getAliasedActualColumnName(introspectedColumn));
            if (inMethod) {
                sb.append(" in"); //$NON-NLS-1$
            } else {
                sb.append(" not in"); //$NON-NLS-1$
            }
            sb.append("\", values, \""); //$NON-NLS-1$
            sb.append(introspectedColumn.getJavaProperty());
            sb.append("\");"); //$NON-NLS-1$
            method.addBodyLine(sb.toString());
            method.addBodyLine("return (Criteria) this;"); //$NON-NLS-1$

            methods.add(method);
        }

        return methods;
    }

    private List<Method> getNoValueMethod(IntrospectedColumn introspectedColumn,
                                          String nameFragment, String operator) {
        String arr[] = {"and", "or"};
        List<Method> methods = new ArrayList<Method>();
        for (int i = 0; i < arr.length; i++) {
            Method method = new Method();
            method.setVisibility(JavaVisibility.PUBLIC);
            StringBuilder sb = new StringBuilder();
            sb.append(introspectedColumn.getJavaProperty());
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            sb.insert(0, arr[i]); //$NON-NLS-1$
            sb.append(nameFragment);
            method.setName(sb.toString());
            method.setReturnType(FullyQualifiedJavaType.getCriteriaInstance());
            sb.setLength(0);
            sb.append("addCriterion(\""); //$NON-NLS-1$
            sb.append(MyBatis3FormattingUtilities
                    .getAliasedActualColumnName(introspectedColumn));
            sb.append(' ');
            sb.append(operator);
            sb.append("\");"); //$NON-NLS-1$
            method.addBodyLine(sb.toString());
            method.addBodyLine("return (Criteria) this;"); //$NON-NLS-1$

            methods.add(method);
        }

        return methods;
    }

    /**
     * This method adds all the extra methods and fields required to support a
     * user defined type handler on some column.
     *
     * @param introspectedColumn
     * @param constructor
     * @param innerClass
     * @return the name of the List added to the class by this method
     */
    private String addtypeHandledObjectsAndMethods(
            IntrospectedColumn introspectedColumn, Method constructor,
            InnerClass innerClass) {
        String answer;
        StringBuilder sb = new StringBuilder();

        // add new private field and public accessor in the class
        sb.setLength(0);
        sb.append(introspectedColumn.getJavaProperty());
        sb.append("Criteria"); //$NON-NLS-1$
        answer = sb.toString();

        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType("java.util.List<Criterion>")); //$NON-NLS-1$
        field.setName(answer);
        innerClass.addField(field);

        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(field.getType());
        method.setName(getGetterMethodName(field.getName(), field
                .getType()));
        sb.insert(0, "return "); //$NON-NLS-1$
        sb.append(';');
        method.addBodyLine(sb.toString());
        innerClass.addMethod(method);

        // add constructor initialization
        sb.setLength(0);
        sb.append(field.getName());
        sb.append(" = new ArrayList<Criterion>();"); //$NON-NLS-1$;
        constructor.addBodyLine(sb.toString());

        // now add the methods for simplifying the individual field set methods
        method = new Method();
        method.setVisibility(JavaVisibility.PROTECTED);
        sb.setLength(0);
        sb.append("add"); //$NON-NLS-1$
        sb.append(introspectedColumn.getJavaProperty());
        sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
        sb.append("Criterion"); //$NON-NLS-1$

        method.setName(sb.toString());
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getObjectInstance(), "value")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "property")); //$NON-NLS-1$
        method.addBodyLine("if (value == null) {"); //$NON-NLS-1$
        method
                .addBodyLine("throw new RuntimeException(\"Value for \" + property + \" cannot be null\");"); //$NON-NLS-1$
        method.addBodyLine("}"); //$NON-NLS-1$

        method.addBodyLine(
                String.format("%s.add(new Criterion(condition, value, \"%s\"));", //$NON-NLS-1$
                        field.getName(), introspectedColumn.getTypeHandler()));
        method.addBodyLine("allCriteria = null;"); //$NON-NLS-1$
        innerClass.addMethod(method);

        sb.setLength(0);
        sb.append("add"); //$NON-NLS-1$
        sb.append(introspectedColumn.getJavaProperty());
        sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
        sb.append("Criterion"); //$NON-NLS-1$

        method = new Method();
        method.setVisibility(JavaVisibility.PROTECTED);
        method.setName(sb.toString());
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "condition")); //$NON-NLS-1$
        method.addParameter(new Parameter(introspectedColumn
                .getFullyQualifiedJavaType(), "value1")); //$NON-NLS-1$
        method.addParameter(new Parameter(introspectedColumn
                .getFullyQualifiedJavaType(), "value2")); //$NON-NLS-1$
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getStringInstance(), "property")); //$NON-NLS-1$
        if (!introspectedColumn.getFullyQualifiedJavaType().isPrimitive()) {
            method.addBodyLine("if (value1 == null || value2 == null) {"); //$NON-NLS-1$
            method
                    .addBodyLine("throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");"); //$NON-NLS-1$
            method.addBodyLine("}"); //$NON-NLS-1$
        }

        method.addBodyLine(
                String.format("%s.add(new Criterion(condition, value1, value2, \"%s\"));", //$NON-NLS-1$
                        field.getName(), introspectedColumn.getTypeHandler()));

        method.addBodyLine("allCriteria = null;"); //$NON-NLS-1$
        innerClass.addMethod(method);

        return answer;
    }
}
