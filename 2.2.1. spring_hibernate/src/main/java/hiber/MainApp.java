package hiber;

import hiber.config.AppConfig;
import hiber.model.*;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Golf", 1)));
        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Passat", 2)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Plaid", 3)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("M", 4)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Axela", 5)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
        Object user = userService.getUserByCar("Golf", 1);
        System.out.println(user.toString());
        context.close();
    }
}
