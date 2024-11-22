package com.alexandre.webService.config;

import com.alexandre.webService.entities.Category;
import com.alexandre.webService.entities.Order;
import com.alexandre.webService.entities.User;
import com.alexandre.webService.entities.enums.OrderStatus;
import com.alexandre.webService.repositories.CategoryRepository;
import com.alexandre.webService.repositories.OrderRepository;
import com.alexandre.webService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat = new Category(null, "Electronics");
        Category cat_2 = new Category(null, "Books");
        Category cat_3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat, cat_2, cat_3));

        User u = new User(null, "James", "james@gmail.com", "jamie123", "42668964925");
        User u_2 = new User(null, "Cersei", "bitch@gmail.com", "bitch123", "42218961963");

        Order order = new Order(null, Instant.parse("2024-11-21T20:53:07Z"), u, OrderStatus.PAID);
        Order order_2 = new Order(null, Instant.parse("2024-11-20T21:53:07Z"), u_2, OrderStatus.WAITING_PAYMENT);
        Order order_3 = new Order(null, Instant.parse("2024-11-15T10:53:07Z"), u, OrderStatus.WAITING_PAYMENT);

        userRepository.saveAll(Arrays.asList(u, u_2));

        orderRepository.saveAll(Arrays.asList(order, order_2, order_3));
    }
}
