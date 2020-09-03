<<<<<<< HEAD
package springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@Configuration+ @EnableAutoConfiguration + @ComponentScan 
@MapperScan("springboot.dao")
//冯德智修改1
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
=======
package springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@Configuration+ @EnableAutoConfiguration + @ComponentScan 
@MapperScan("springboot.dao")
//冯德智修改1
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
>>>>>>> tijioa
