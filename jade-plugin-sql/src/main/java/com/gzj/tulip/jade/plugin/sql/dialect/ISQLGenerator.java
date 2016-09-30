/**
 * 
 */
package com.gzj.tulip.jade.plugin.sql.dialect;

import com.gzj.tulip.jade.statement.StatementRuntime;
import com.gzj.tulip.jade.plugin.sql.mapper.IOperationMapper;

/**
 * 查询语句生成器
 * @author Alan.Geng[gengzhi718@gmail.com]
 */
public interface ISQLGenerator<T extends IOperationMapper> {

	/**
	 * 将某种操作生成SQL
	 * @param operationMapper
	 * @param runtime
	 * @return
	 */
	String generate(T operationMapper, StatementRuntime runtime);
	
}
