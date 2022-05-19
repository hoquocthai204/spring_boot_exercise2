package net.sparkminds.user;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExecise2Application {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringExecise2Application.class, args);
		
//		Brand brand = new Brand();
//		brand.setCreatedDate(new SimpleDateFormat("dd/MM/yyyy").parse("2/1/2021"));
//		System.out.println(brand.getCreatedDate());
	}
}
