/**
 *
 */
package com.gzj.tulip.jade.plugin.sql.mapper;

import com.gzj.tulip.jade.plugin.sql.annotations.IgnoreNull;
import com.gzj.tulip.jade.statement.StatementMetaData;

import java.util.List;

/**
 * @author Alan.Geng[gengzhi718@gmail.com]
 */
public interface IOperationMapper extends IMapper<StatementMetaData> {

    public static final String OPERATION_SELECT = "SELECT";
    public static final String OPERATION_INSERT = "INSERT";
    public static final String OPERATION_DELETE = "DELETE";
    public static final String OPERATION_UPDATE = "UPDATE";

    static final String[] OPERATION_KEYS = {
            OPERATION_SELECT,
            OPERATION_INSERT,
            OPERATION_DELETE,
            OPERATION_UPDATE
    };

    static final String OPERATION_PREFIX[][] = {
        /* [0][] = SELECT */ {"get", "select", "find", "query", "count"},
		/* [1][] = INSERT */ {"save", "insert"},
		/* [2][] = DELETE */ {"delete", "remove"},
		/* [3][] = UPDATE */ {"update", "modify"}
    };

    IEntityMapper getTargetEntityMapper();

    List<IParameterMapper> getParameters();

    boolean containsParameter();

    void setEntityMapperManager(EntityMapperManager entityMapperManager);

    boolean isIgnoreNull();

    IgnoreNull getIgnoreNull();

}
