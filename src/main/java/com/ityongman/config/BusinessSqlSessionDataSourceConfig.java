package com.ityongman.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.ityongman.util.BaseMapper;

@Configuration
@MapperScan(basePackages="com.ityongman.mapper", markerInterface=BaseMapper.class, sqlSessionFactoryRef="businessSessionFactory")
public class BusinessSqlSessionDataSourceConfig {
	@Autowired()
	@Qualifier("businessDataSource")
	private DataSource ds ;
	
	@Bean
	public SqlSessionFactory businessSessionFactory() throws Exception {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		factoryBean.setDataSource(ds);
		factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		
		return factoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate businessSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(businessSessionFactory());
		
		return template; 
	}
}

