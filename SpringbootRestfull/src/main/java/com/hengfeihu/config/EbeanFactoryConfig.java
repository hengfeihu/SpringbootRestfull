package com.hengfeihu.config;

import com.hengfeihu.properties.DataSourcePropertie;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.apache.log4j.Logger;
import org.avaje.datasource.DataSourceConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by hengfeihu on 2017/10/12.
 */
@Component
public class EbeanFactoryConfig implements FactoryBean<EbeanServer> {
    private Logger logger = Logger.getLogger(EbeanFactoryConfig.class);

    private DataSourcePropertie dataSourcePropertie;

    public EbeanFactoryConfig(DataSourcePropertie dataSourcePropertie) {
        this.dataSourcePropertie = dataSourcePropertie;
    }

    @Override
    public EbeanServer getObject() throws Exception {
        ServerConfig config = new ServerConfig();
        try {
            logger.info("####################[url:" + dataSourcePropertie.getUrl() + "]####################");
            logger.info("####################[username:" + dataSourcePropertie.getUsername() + "]####################");
            logger.info("####################[password:" + dataSourcePropertie.getPassword() + "]####################");
            config.setName("db");
            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            dataSourceConfig.setDriver(dataSourcePropertie.getDriverClassName());
            dataSourceConfig.setUrl(dataSourcePropertie.getUrl());
            dataSourceConfig.setUsername(dataSourcePropertie.getUsername());
            dataSourceConfig.setPassword(dataSourcePropertie.getPassword());
            dataSourceConfig.setMaxConnections(10);
            config.setDataSourceConfig(dataSourceConfig);
            config.setDefaultServer(true);
            config.setRegister(true);
            config.setDdlGenerate(true);
            config.setDdlRun(true);
            config.addPackage("com.hengfeihu.models");
            logger.info("####################[The database is connected]####################");
        } catch (Exception e) {
            logger.info("####################[Database connection failed]####################");
        }
        return EbeanServerFactory.create(config);
    }

    @Override
    public Class<?> getObjectType() {
        return EbeanServer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
