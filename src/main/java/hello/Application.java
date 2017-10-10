
package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Application {

    public static void main(String[] args) {
        // Launch the application
        final ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        final ProducerService producerService = context.getBean(ProducerService.class);
//        producerService.produce(20);

    }

}
