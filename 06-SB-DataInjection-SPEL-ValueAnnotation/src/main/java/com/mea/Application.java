package com.mea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.mea.sbeans.HotelMenu;
import com.mea.sbeans.Hotelinfo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		HotelMenu menu = ctx.getBean("menu",HotelMenu.class);
		System.out.println(menu);
		Hotelinfo hotelinfo = ctx.getBean("hotel",Hotelinfo.class);
		System.out.println(hotelinfo);
		
		System.out.println("------------------------------------------------");
		Environment env = ctx.getEnvironment();
		System.out.println(env.getProperty("os.name"));
		System.out.println(env.getProperty("hotel.name"));
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
