package com.alexandre.webService.config;

import com.alexandre.webService.entities.Category;
import com.alexandre.webService.entities.Order;
import com.alexandre.webService.entities.Product;
import com.alexandre.webService.entities.User;
import com.alexandre.webService.entities.enums.OrderStatus;
import com.alexandre.webService.repositories.CategoryRepository;
import com.alexandre.webService.repositories.OrderRepository;
import com.alexandre.webService.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat = new Category(null, "Electronics");
        Category cat_2 = new Category(null, "Books");
        Category cat_3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat, cat_2, cat_3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u = new User(null, "James", "james@gmail.com", "jamie123", "42668964925");
        User u_2 = new User(null, "Cersei", "bitch@gmail.com", "bitch123", "42218961963");

        Order order = new Order(null, Instant.parse("2024-11-21T20:53:07Z"), u, OrderStatus.PAID);
        Order order_2 = new Order(null, Instant.parse("2024-11-20T21:53:07Z"), u_2, OrderStatus.WAITING_PAYMENT);
        Order order_3 = new Order(null, Instant.parse("2024-11-15T10:53:07Z"), u, OrderStatus.WAITING_PAYMENT);

        userRepository.saveAll(Arrays.asList(u, u_2));
        orderRepository.saveAll(Arrays.asList(order, order_2, order_3));
    }
}
