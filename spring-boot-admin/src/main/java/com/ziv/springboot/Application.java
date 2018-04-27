package com.ziv.springboot;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
@MapperScan("com.ziv.springboot")
public class Application extends SpringBootServletInitializer{

	private static Logger logger = Logger.getLogger(Application.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("SpringBoot Start Success");
	}
	
	@Bean
	public EmbeddedServletContainerFactory containerFactory(){
		TomcatEmbeddedServletContainerFactory containerFactory = new TomcatEmbeddedServletContainerFactory();
		containerFactory.setContextPath("/springboot");
		containerFactory.setPort(8088);
		containerFactory.setSessionTimeout(30*60*1000);
		return containerFactory;
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource(){
		return new org.apache.tomcat.jdbc.pool.DataSource();
	}
	
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml")); 
		return sessionFactoryBean.getObject();
	}

}
