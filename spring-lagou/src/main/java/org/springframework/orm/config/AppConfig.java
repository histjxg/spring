package org.springframework.orm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.configdao.ConfigDao2;
import org.springframework.orm.dao.IndexDao;
//import org.springframework.orm.dao.IndexDao;

@ComponentScan("org.springframework.orm.configdao")
@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class AppConfig {
	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;

	@Bean
	public IndexDao configDao1(){   //自己写一个configDao1类即可
		return new IndexDao();
	}

	@Bean
	public ConfigDao2 configDao2(){   //自己写一个configDao2类即可
		configDao1();
		System.out.println("姓名+密码"+username+password);
		return new ConfigDao2();
	}


}
