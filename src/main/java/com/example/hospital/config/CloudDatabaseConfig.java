package com.example.hospital.config;


import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zaxxer.hikari.HikariDataSource;


@Configuration
@Profile("cf")
public class CloudDatabaseConfig {

    @Bean
    public DataSource dataSource() throws Exception {

        JSONObject obj = new JSONObject(System.getenv("VCAP_SERVICES"));
        System.out.println(obj.toString());
        JSONArray arr = obj.getJSONArray("hana");
        String url = arr.getJSONObject(0).getJSONObject("credentials").getString("url");
        String user = arr.getJSONObject(0).getJSONObject("credentials").getString("user");
        String password = arr.getJSONObject(0).getJSONObject("credentials").getString("password");
        String schema = arr.getJSONObject(0).getJSONObject("credentials").getString("schema");
//        HikariDataSource hdb = new HikariDataSource();
//        hdb.setJdbcUrl(url);
//        hdb.setUsername(user);
//        hdb.setPassword(password);
//        hdb.setSchema(schema);
//        return hdb;
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .driverClassName(com.sap.db.jdbc.Driver.class.getName())
                .url(url)
                .username(user)
                .password(password)
                .build();

    }
}