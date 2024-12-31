package tn.esprit.mokhlesbenna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class MokhlesBennaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MokhlesBennaApplication.class, args);
    }

}
