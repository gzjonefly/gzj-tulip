/**
 * 
 */
package com.gzj.tulip.jade.plugin.sql.dialect.mysql;

import com.gzj.tulip.jade.plugin.sql.mapper.ConditionalOperationMapper;
import com.gzj.tulip.jade.statement.StatementRuntime;

/**
 * @author Alan.Geng[gengzhi718@gmail.com]
 *
 */
public class DeleteGenerator extends ConditionalGenerator {

	@Override
	protected void beforeApplyConditions(
			ConditionalOperationMapper operationMapper,
			StatementRuntime runtime, StringBuilder sql) {
		super.beforeApplyConditions(operationMapper, runtime, sql);
		
		sql.append("DELETE FROM ");
		sql.append(operationMapper.getTargetEntityMapper().getName());
	}

}
