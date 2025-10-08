
package es.back.odontologia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@ComponentScan(basePackages = "es.logicacenter.notificador")
@EnableScheduling
public class NotificadorApp {

	public static void main(String[] args) {
		SpringApplication.run(NotificadorApp.class, args);
		// cambio
	}

}
