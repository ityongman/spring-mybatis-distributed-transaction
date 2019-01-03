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

import tk.mybatis.mapper.common.MySqlMapper;

@Configuration
@MapperScan(basePackages="com.ityongman.mapper", markerInterface=MySqlMapper.class, sqlSessionFactoryRef="systemSessionFactory")
public class SystemSqlSessionDataSourceConfig {
	@Autowired
	@Qualifier("systemDataSource")
	private DataSource ds ;
	
	@Bean
	public SqlSessionFactory systemSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean() ;
		factoryBean.setDataSource(ds);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver() ;
		
		factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		
		return factoryBean.getObject() ;
	}
	
	@Bean
	public SqlSessionTemplate systemSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(systemSessionFactory());
		
		return template;
	}
}
