package com.nishu.db.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import com.nishu.db.DBConnection;

@Configuration
@PropertySources({
	@PropertySource("classpath:db.properties"),
	@PropertySource(value="classpath:root.properties", ignoreResourceNotFound = true)
})
public class DBConfiguration {

	@Autowired
    Environment env;
	
	@Value("Default DBConfiguration")
	private String defaultName;


	@Value("${APP_NAME_NOT_FOUND:Default}")
	private String defaultAppName;

	@Value("${java.home}")
	private String javaHome;

	@Value("${HOME}")
	private String homeDir;
	
	
	@Bean
    public DBConnection getDBConnection() {
		System.out.println("Getting DBConnection Bean for App: "+env.getProperty("APP_NAME")+"\n"
				+ "JAVA HOME :"+javaHome+"\n"
				+ "HOME DIR :"+homeDir+"\n"
				+ "Default App Name :"+defaultAppName);
		DBConnection dbConnection = new DBConnection(env.getProperty("DB_DRIVER_CLASS"), env.getProperty("DB_URL"), env.getProperty("DB_USERNAME"), env.getProperty("DB_PASSWORD").toCharArray());
        return dbConnection;
    }
	
}
