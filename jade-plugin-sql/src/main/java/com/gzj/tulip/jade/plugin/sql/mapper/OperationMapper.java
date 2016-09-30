/**
 *
 */
package com.gzj.tulip.jade.plugin.sql.mapper;

import com.gzj.tulip.jade.annotation.SQLParam;
import com.gzj.tulip.jade.plugin.sql.GenericDAO;
import com.gzj.tulip.jade.plugin.sql.annotations.IgnoreNull;
import com.gzj.tulip.jade.plugin.sql.Plum;
import com.gzj.tulip.jade.statement.StatementMetaData;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Alan.Geng[gengzhi718@gmail.com]
 */
public class OperationMapper extends AbstractMapper<StatementMetaData> implements IOperationMapper {

    private IEntityMapper targetEntityMapper;

    private List<IParameterMapper> parameters;

    private EntityMapperManager entityMapperManager;

    private Class<?> entityType;

    private Class<?> primaryKeyType;

    private Class<?> conditionsType;

    private IgnoreNull ignoreNull;

    public static final List<IParameterMapper> NO_PARAMETER = Collections.unmodifiableList(new ArrayList<IParameterMapper>());

    public OperationMapper(StatementMetaData original) {
        super(original);
    }

    @Override
    public IEntityMapper getTargetEntityMapper() {
        return targetEntityMapper;
    }

    @Override
    protected void doMap() {
        ignoreNull = original.getAnnotation(IgnoreNull.class);
        mapGenericEntityType();
        mapTargetEntityMapper();
        mapParameters();
    }

    protected void mapGenericEntityType() {
        entityType = original.getDAOMetaData().resolveTypeVariable(GenericDAO.class, "E");
        primaryKeyType = original.getDAOMetaData().resolveTypeVariable(GenericDAO.class, "ID");
        conditionsType = original.getDAOMetaData().resolveTypeVariable(GenericDAO.class, "CONDITIONS");
        if (entityType == null) {
            throw new MappingException("Cannot find the generic type.");
        }
    }

    protected void mapTargetEntityMapper() {
        targetEntityMapper = entityMapperManager.createGet((Class<?>) entityType);
    }

    protected void mapParameters() {
        Method method = original.getMethod();
        Type[] parameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        if (parameterTypes == null
                || parameterTypes.length == 0) {
            parameters = NO_PARAMETER;

            if ((getName() == OPERATION_INSERT
                    || getName() == OPERATION_DELETE
                    || getName() == OPERATION_UPDATE)
                    && parameters == NO_PARAMETER) {
                // 写操作必须存在参数
                throw new MappingException("The insert operation must has least 1 parameters.");
            }

            return;
        }

        parameters = new ArrayList<IParameterMapper>(parameterAnnotations.length);

        for (int i = 0; i < parameterAnnotations.length; i++) {
            // TODO: 是否要进行参数类型检查？
            IParameterMapper parameterMapper = createParameterMapper(resolveParameterType(parameterTypes[i]), parameterAnnotations[i], i);
            if (parameterMapper != null) {
                parameters.add(parameterMapper);
            }
        }
    }

    protected Class<?> resolveParameterType(Type type) {
        if (type instanceof Class) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType
                && ((ParameterizedType) type).getRawType() instanceof Class
                && Collection.class.isAssignableFrom((Class<?>) ((ParameterizedType) type).getRawType())) {

            // GenericDAO中的集合泛型参数
            return resolveParameterType(((ParameterizedType) type).getActualTypeArguments()[0]);
        } else if (type instanceof TypeVariable) {

            // GenericDAO中的非集合泛型参数，或许是主键或许是实体。
            GenericDeclaration genericDeclaration = ((TypeVariable<?>) type).getGenericDeclaration();
            if (genericDeclaration == GenericDAO.class) {
                Type[] bounds = ((TypeVariable<?>) type).getBounds();

                if (bounds[0] == Object.class) {
                    String name = ((TypeVariable<?>) type).getName();
                    if ("E".equals(name)) {
                        return entityType;
                    } else if ("ID".equals(name)) {
                        return primaryKeyType;
                    } else if ("CONDITIONS".equals(name)) {
                        return conditionsType;
                    } else {
                        throw new MappingException("Unknown type variable \"" + type + "\".");
                    }
                } else {
                    return resolveParameterType(bounds[0]);
                }
            } else {
                throw new MappingException("Unsupported generic declaration \"" + genericDeclaration + "\".");
            }
        }
        throw new MappingException("Unknown type \"" + type + "\".");
    }

    protected Type[] getCollectionTypeBounds(Class<?> collectionType) {
        TypeVariable<?>[] typeParameters = collectionType.getTypeParameters();
        if (typeParameters.length == 0) {
            throw new MappingException("The generic type of collection must be specified.");
        }
        TypeVariable<?> typeVariable = collectionType.getTypeParameters()[0];
        return typeVariable.getBounds();
    }

    protected IParameterMapper createParameterMapper(Class<?> type, Annotation[] annotations, int index) {
        SQLParam sp = null;

        if (annotations != null && annotations.length > 0) {
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(SQLParam.class)) {
                    sp = (SQLParam) annotation;
                    break;
                }
            }
        }

        IParameterMapper param = null;
        if (isExpandableParameterType(type)) {
            param = new ExpandableParameterMapper(this, sp, (Class<?>) type);
            ((ExpandableParameterMapper) param).setEntityMapperManager(entityMapperManager);
        } else {
            param = new ParameterMapper(this, sp, type, annotations);
        }
        param.map();

        return param;
    }

    protected boolean isExpandableParameterType(Class<?> type) {
        if (entityType.isAssignableFrom(type)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean containsParameter() {
        return parameters != NO_PARAMETER;
    }

    @Override
    protected String generateOriginalName() {
        return original.getMethod().getName();
    }

    @Override
    public String generateName(String source) {
        for (int i = 0; i < OPERATION_PREFIX.length; i++) {
            String[] prefixs = OPERATION_PREFIX[i];
            for (int j = 0; j < prefixs.length; j++) {
                if (source.startsWith(prefixs[j])) {
                    return OPERATION_KEYS[i];
                }
            }
        }
        throw new MappingException("Unsupported method \"" + source + "\".");
    }

    public void setEntityMapperManager(EntityMapperManager entityMapperManager) {
        this.entityMapperManager = entityMapperManager;
    }

    @Override
    public List<IParameterMapper> getParameters() {
        return parameters;
    }

    public Class<?> getPrimaryKeyType() {
        return primaryKeyType;
    }

    public Class<?> getEntityType() {
        return entityType;
    }

    public Class<?> getConditionsType() {
        return conditionsType;
    }

    @Override
    public boolean isIgnoreNull() {
        //change by guozijan 2016-09-28
        return ignoreNull == null ? Plum.DEFAULT_IGNORE_NULL : ignoreNull.value();
    }

    @Override
    public IgnoreNull getIgnoreNull() {
        return ignoreNull;
    }

}
