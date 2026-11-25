package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloBeanSpringTest{
	@Autowired
	Hello hello;
	
	@Autowired
	@Qualifier("helloCons")
	Hello hello2;
	
	@Resource(name = "helloCons")
	Hello hello3;
	
	@Test @Disabled
	void helloBean() {
		assertEquals("Hello 스프링", hello.sayHello());
		assertEquals("Hello 생성자", hello2.sayHello());
		assertEquals("Hello 생성자", hello3.sayHello());
		hello2.print();
	}
	
	@Test
	void list() {
		for(String value:hello2.getNames()) {
			System.out.println(value);
		}
		
		assertEquals(4, hello2.getNames().size());
		assertEquals("스프링프레임워크", hello2.getNames().get(0));
		
	}
	
}