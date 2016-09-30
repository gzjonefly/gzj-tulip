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
package com.gzj.tulip.jade.dataaccess.datasource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.sql.DataSource;

import com.gzj.tulip.jade.dataaccess.DataSourceHolder;
import com.gzj.tulip.jade.dataaccess.DataSourceFactory;
import com.gzj.tulip.jade.statement.StatementMetaData;

/**
 * 从预设的一系列的DataSource随机提供一个
 * 
 * @author 王志亮 [qieqie.wang@gmail.com]
 * 
 */
public class RandomDataSourceFactory implements DataSourceFactory {

    private Random random = new Random();

    private List<DataSourceHolder> dataSources = Collections.emptyList();

    public RandomDataSourceFactory() {
    }

    public void addDataSource(DataSource dataSource) {
        if (this.dataSources.size() == 0) {
            this.dataSources = new ArrayList<DataSourceHolder>(dataSources);
        }
        this.dataSources.add(new DataSourceHolder(dataSource));
    }

    public RandomDataSourceFactory(List<DataSource> dataSources) {
        this.setDataSources(dataSources);
    }

    public void setDataSources(List<DataSource> dataSources) {
        this.dataSources = new ArrayList<DataSourceHolder>(dataSources.size());
        for (DataSource dataSource : dataSources) {
            this.dataSources.add(new DataSourceHolder(dataSource));
        }
    }

    @Override
    public DataSourceHolder getHolder(StatementMetaData metaData,
            Map<String, Object> runtimeProperties) {
        if (dataSources.size() == 0) {
            return null;
        }
        int index = random.nextInt(dataSources.size()); // 0.. size
        return dataSources.get(index);
    }

}
