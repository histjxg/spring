package org.springframework.orm;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.config.AppConfig;
import org.springframework.orm.dao.IndexDao;


public class MyApplication {
	public static void main(String[] args) {
		//第一种方式ClassPathXmlApplicationContext
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("classpath*:application.xml");
//		Person person = context.getBean("person", Person.class);
//		System.out.println(person.getName());
		//第二种方式 基于注解配置上下文
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		//register的主要作用是将AppConfig类注册到bean工厂中。 即是到目前为止，bean工厂中已经有了7个beanDefinition
		ac.register(AppConfig.class);
		ac.refresh();

		IndexDao indexDao = ac.getBean(IndexDao.class);
		System.out.println(indexDao);
		indexDao.query();
	}


}
//./gradlew :spring-demo:compileTestJava
