/*
 * Copyright 2009-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License i distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gzj.tulip.jade.context.application;

import java.lang.reflect.Proxy;

import javax.sql.DataSource;

import com.gzj.tulip.jade.context.JadeInvocationHandler;
import com.gzj.tulip.jade.dataaccess.DataAccessFactoryAdapter;
import com.gzj.tulip.jade.dataaccess.datasource.SimpleDataSourceFactory;
import com.gzj.tulip.jade.rowmapper.DefaultRowMapperFactory;
import com.gzj.tulip.jade.rowmapper.RowMapperFactory;
import com.gzj.tulip.jade.statement.DAOMetaData;
import com.gzj.tulip.jade.statement.DefaultInterpreterFactory;
import org.springframework.util.ClassUtils;

import com.gzj.tulip.jade.dataaccess.DataSourceFactory;
import com.gzj.tulip.jade.statement.DAOConfig;
import com.gzj.tulip.jade.statement.Interpreter;
import com.gzj.tulip.jade.statement.StatementWrapperProvider;
import com.gzj.tulip.jade.statement.cached.CacheProvider;

/**
 * 
 * @author 王志亮 [qieqie.wang@gmail.com]
 * 
 */
//BUG: @SQL中的 :1.create_date应该抛出错误而非返回null
public class JadeFactory {

    private RowMapperFactory rowMapperFactory = new DefaultRowMapperFactory();

    private DefaultInterpreterFactory interpreterFactory = new DefaultInterpreterFactory();

    private DataAccessFactoryAdapter dataAccessFactory;

    private CacheProvider cacheProvider;

    // 可选的
    private StatementWrapperProvider statementWrapperProvider;

    public JadeFactory() {
    }

    public JadeFactory(DataSource defaultDataSource) {
        setDataSourceFactory(new SimpleDataSourceFactory(defaultDataSource));
    }

    public JadeFactory(DataSourceFactory dataSourceFactory) {
        setDataSourceFactory(dataSourceFactory);
    }

    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataAccessFactory = new DataAccessFactoryAdapter(dataSourceFactory);
    }

    public void setCacheProvider(CacheProvider cacheProvider) {
        this.cacheProvider = cacheProvider;
    }

    public DataSourceFactory getDataSourceFactory() {
        if (this.dataAccessFactory == null) {
            return null;
        }
        return this.dataAccessFactory.getDataSourceFactory();
    }

    public void setRowMapperFactory(RowMapperFactory rowMapperFactory) {
        this.rowMapperFactory = rowMapperFactory;
    }

    public StatementWrapperProvider getStatementWrapperProvider() {
        return statementWrapperProvider;
    }

    public void setStatementWrapperProvider(StatementWrapperProvider statementWrapperProvider) {
        this.statementWrapperProvider = statementWrapperProvider;
    }

    public void addInterpreter(Interpreter... interpreters) {
        for (Interpreter interpreter : interpreters) {
            interpreterFactory.addInterpreter(interpreter);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T create(Class<?> daoClass) {
        try {
            DAOConfig config = new DAOConfig(dataAccessFactory, rowMapperFactory,
                interpreterFactory, cacheProvider, statementWrapperProvider);
            DAOMetaData daoMetaData = new DAOMetaData(daoClass, config);
            JadeInvocationHandler handler = new JadeInvocationHandler(daoMetaData);
            ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
            return (T) Proxy.newProxyInstance(classLoader, new Class[] { daoClass }, handler);
        } catch (RuntimeException e) {
            throw new IllegalStateException("failed to create bean for " + daoClass.getName(), e);
        }
    }
}
