package com.hengfeihu;

import com.hengfeihu.config.EbeanFactoryConfig;
import com.hengfeihu.properties.DataSourcePropertie;
import io.ebean.EbeanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * springboot启动
 * Created by hengfeihu on 2017/10/12.
 */
@SpringBootApplication
public class SpringBootWebApplication {

    @Autowired
    private DataSourcePropertie dataSourcePropertie;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootWebApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Bean
    public EbeanServer initEbeanServer() {
        try {
            EbeanFactoryConfig ebeanFactoryConfig = new EbeanFactoryConfig(dataSourcePropertie);
            return ebeanFactoryConfig.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
