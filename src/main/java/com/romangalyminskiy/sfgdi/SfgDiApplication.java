package com.romangalyminskiy.sfgdi;

import com.romangalyminskiy.sfgdi.config.SfgConfiguration;
import com.romangalyminskiy.sfgdi.datasource.FakeDataSource;
import com.romangalyminskiy.sfgdi.services.PrototypeBean;
import com.romangalyminskiy.sfgdi.services.SingletonBean;
import org.springframework.context.annotation.ComponentScan;
import other.ConstructorInjectedController;
import com.romangalyminskiy.sfgdi.controllers.I18nController;
import com.romangalyminskiy.sfgdi.controllers.MyController;
import other.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@ComponentScan(basePackages = {"com.romangalyminskiy.sfgdi", "other"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");
		System.out.println(controller.sayHello());

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		SingletonBean sb1 = (SingletonBean) ctx.getBean("singletonBean");
		System.out.println(sb1.getMyScope());
		SingletonBean sb2 = (SingletonBean) ctx.getBean("singletonBean");
		System.out.println(sb2.getMyScope());
		PrototypeBean pb1 = (PrototypeBean) ctx.getBean("prototypeBean");
		System.out.println(pb1.getMyScope());
		PrototypeBean pb2 = (PrototypeBean) ctx.getBean("prototypeBean");
		System.out.println(pb2.getMyScope());

		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean("fakeDataSource");
		System.out.println(fakeDataSource.getUrl());
		System.out.println(fakeDataSource.getUser());
		System.out.println(fakeDataSource.getPassword());

		SfgConfiguration sfgConfiguration = (SfgConfiguration) ctx.getBean("sfgConfiguration");
		System.out.println(sfgConfiguration.getUrl());
		System.out.println(sfgConfiguration.getUser());
		System.out.println(sfgConfiguration.getPassword());
	}
}
