/**
 * 
 */
package com.gzj.tulip.jade.plugin.sql.dialect;

import java.util.HashMap;
import java.util.Map;

import com.gzj.tulip.jade.plugin.sql.dialect.mysql.InsertGenerator;
import com.gzj.tulip.jade.plugin.sql.dialect.mysql.UpdateGenerator;
import com.gzj.tulip.jade.statement.StatementRuntime;
import com.gzj.tulip.jade.plugin.sql.dialect.mysql.DeleteGenerator;
import com.gzj.tulip.jade.plugin.sql.dialect.mysql.SelectGenerator;
import com.gzj.tulip.jade.plugin.sql.mapper.IOperationMapper;

/**
 * MySQL方言
 * @author Alan.Geng[gengzhi718@gmail.com]
 */
public class MySQLDialect implements IDialect {
	
	private Map<String, ISQLGenerator<? extends IOperationMapper>> generators;
	
	public MySQLDialect() {
		generators = new HashMap<String, ISQLGenerator<? extends IOperationMapper>>();
		generators.put(IOperationMapper.OPERATION_SELECT, new SelectGenerator());
		generators.put(IOperationMapper.OPERATION_INSERT, new InsertGenerator());
		generators.put(IOperationMapper.OPERATION_UPDATE, new UpdateGenerator());
		generators.put(IOperationMapper.OPERATION_DELETE, new DeleteGenerator());
	}

	/* (non-Javadoc)
	 * @see com.cainiao.depot.project.biz.common.jade.dialect.IDialect#translate(com.cainiao.depot.project.biz.common.jade.mapper.IOperationMapper)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T extends IOperationMapper> String translate(T operation, StatementRuntime runtime) {
		ISQLGenerator<T> gen = (ISQLGenerator<T>) generators.get(operation.getName());
		if(gen != null) {
			return gen.generate(operation, runtime);
		}
		return null;
	}

}
