package com.salahhaddara.miniecommercespringboot.config;

import com.salahhaddara.miniecommercespringboot.entity.Product;
import com.salahhaddara.miniecommercespringboot.entity.User;
import com.salahhaddara.miniecommercespringboot.repository.ProductRepository;
import com.salahhaddara.miniecommercespringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create admin user if not exists
        if (!userRepository.existsByEmail("admin@example.com")) {
            User admin = new User();
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(User.Role.ADMIN);
            userRepository.save(admin);
            System.out.println("Admin user created: admin@example.com / admin123");
        }

        // Create sample products if none exist
        if (productRepository.count() == 0) {
            createSampleProducts();
            System.out.println("Sample products created");
        }
    }

    private void createSampleProducts() {
        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setPrice(new BigDecimal("999.99"));
        product1.setStock(10);
        product1.setDescription("High-performance laptop for work and gaming");
        product1.setImageUrl("https://example.com/laptop.jpg");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Smartphone");
        product2.setPrice(new BigDecimal("699.99"));
        product2.setStock(25);
        product2.setDescription("Latest smartphone with advanced features");
        product2.setImageUrl("https://example.com/smartphone.jpg");
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setName("Headphones");
        product3.setPrice(new BigDecimal("199.99"));
        product3.setStock(3); // Low stock
        product3.setDescription("Wireless noise-cancelling headphones");
        product3.setImageUrl("https://example.com/headphones.jpg");
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setName("Tablet");
        product4.setPrice(new BigDecimal("499.99"));
        product4.setStock(0); // Out of stock
        product4.setDescription("10-inch tablet for entertainment and productivity");
        product4.setImageUrl("https://example.com/tablet.jpg");
        productRepository.save(product4);

        Product product5 = new Product();
        product5.setName("Smart Watch");
        product5.setPrice(new BigDecimal("299.99"));
        product5.setStock(15);
        product5.setDescription("Fitness tracking smartwatch with health monitoring");
        product5.setImageUrl("https://example.com/smartwatch.jpg");
        productRepository.save(product5);
    }
}
