package com.gzj.tulip.jade.context.spring;

import java.util.Map;

import com.gzj.tulip.jade.dataaccess.DataSourceFactory;
import com.gzj.tulip.jade.dataaccess.DataSourceHolder;
import com.gzj.tulip.jade.statement.StatementMetaData;

import org.springframework.beans.factory.ListableBeanFactory;

/**
 * 
 * @author 王志亮 [qieqie.wang@gmail.com]
 * 
 */
public class SpringDataSourceFactoryDelegate implements DataSourceFactory {

    private ListableBeanFactory beanFactory;

    private DataSourceFactory dataSourceFactory;

    public SpringDataSourceFactoryDelegate(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public DataSourceHolder getHolder(StatementMetaData metaData, Map<String, Object> runtimeProperties) {
        if (dataSourceFactory == null) {
            ListableBeanFactory beanFactory = this.beanFactory;
            if (beanFactory != null) {
                if (beanFactory.containsBeanDefinition("jade.dataSourceFactory")) {
                    dataSourceFactory = (DataSourceFactory) beanFactory.getBean(
                            "jade.dataSourceFactory", DataSourceFactory.class);
                } else {
                    dataSourceFactory = new SpringDataSourceFactory(beanFactory);
                }
                this.beanFactory = null;
            }
        }
        return dataSourceFactory.getHolder(metaData, runtimeProperties);
    }

}
