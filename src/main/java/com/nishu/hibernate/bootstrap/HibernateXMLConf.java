package com.nishu.hibernate.bootstrap;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource({ "classpath:hibernate5Config.xml" })
public class HibernateXMLConf {

}
