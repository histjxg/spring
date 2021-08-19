package org.springframework.orm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.configdao.ConfigDao2;
import org.springframework.orm.dao.IndexDao;

@ComponentScan("org.springframework.orm.configdao")
@Configuration
public class AppConfig {
	@Bean
	public IndexDao configDao1(){   //自己写一个configDao1类即可
		return new IndexDao();
	}

	@Bean
	public ConfigDao2 configDao2(){   //自己写一个configDao2类即可
		configDao1();
		return new ConfigDao2();
	}




}
