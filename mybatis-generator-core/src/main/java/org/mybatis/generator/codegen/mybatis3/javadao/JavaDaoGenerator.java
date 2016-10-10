package org.mybatis.generator.codegen.mybatis3.javadao;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.AbstractXmlGenerator;
import org.mybatis.generator.config.PropertyRegistry;

import java.util.ArrayList;
import java.util.List;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * @author guozijian
 * @date 2016/10/9 15:18
 */
public class JavaDaoGenerator extends AbstractJavaClientGenerator {

    public JavaDaoGenerator() {
        super(true);
    }

    public JavaDaoGenerator(boolean requiresMatchedXMLGenerator) {
        super(requiresMatchedXMLGenerator);
    }

    /**
     * This method returns an instance of the XML generator associated
     * with this client generator.
     *
     * @return the matched XML generator.  May return null if no
     * XML is required by this generator
     */
    @Override
    public AbstractXmlGenerator getMatchedXMLGenerator() {
        return null;
    }

    @Override
    public List<CompilationUnit> getCompilationUnits() {
        FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
        progressCallback.startTask(getString(
                "Progress.50", table.toString())); //$NON-NLS-1$
        CommentGenerator commentGenerator = context.getCommentGenerator();

        FullyQualifiedJavaType type = new FullyQualifiedJavaType(
                introspectedTable.getDAOInterfaceType());//change by guozijian

        Interface interfaze = new Interface(type);
        interfaze.setVisibility(JavaVisibility.PUBLIC);

        interfaze.addAnnotation("@DAO");

        interfaze.addSuperInterface(new FullyQualifiedJavaType("GenericDAO<" + table.getDomainObjectName() + "DO, " + introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType().getShortName() + ", " + table.getDomainObjectName() + "Conditions>"));

        interfaze.addImportedType(new FullyQualifiedJavaType("com.gzj.tulip.jade.annotation.DAO"));
        interfaze.addImportedType(new FullyQualifiedJavaType("com.gzj.tulip.jade.plugin.sql.GenericDAO"));
        FullyQualifiedJavaType conditionType = new FullyQualifiedJavaType(
                introspectedTable.getConditionType());
        interfaze.addImportedType(conditionType);
        if (introspectedTable.getRules().generateRecordWithBLOBsClass()) {
            interfaze.addImportedType(new FullyQualifiedJavaType(introspectedTable
                    .getRecordWithBLOBsType() + "DO"));
        } else {
            // the blob fields must be rolled up into the base class
            interfaze.addImportedType(new FullyQualifiedJavaType(introspectedTable
                    .getBaseRecordType() + "DO"));
        }


        commentGenerator.addJavaFileComment(interfaze);

        String rootInterface = introspectedTable
                .getTableConfigurationProperty(PropertyRegistry.ANY_ROOT_INTERFACE);
        if (!stringHasValue(rootInterface)) {
            rootInterface = context.getJavaClientGeneratorConfiguration()
                    .getProperty(PropertyRegistry.ANY_ROOT_INTERFACE);
        }

        if (stringHasValue(rootInterface)) {
            FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(
                    rootInterface);
            interfaze.addSuperInterface(fqjt);
            interfaze.addImportedType(fqjt);
        }

        List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
        if (context.getPlugins().clientGenerated(interfaze, null,
                introspectedTable)) {
            answer.add(interfaze);
        }

        return answer;
    }
}
