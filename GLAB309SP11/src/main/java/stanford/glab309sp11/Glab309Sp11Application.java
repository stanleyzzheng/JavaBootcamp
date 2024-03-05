package stanford.glab309sp11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Glab309Sp11Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(Glab309Sp11Application.class, args);

        // get the bean from spring container
        Coach theCoach = context.getBean(Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call method to get daily fortune
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }

//    public static void main(String[] args) {
//        SpringApplication.run(Glab309Sp11Application.class, args);
//    }


}
