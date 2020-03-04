package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.company")
@EnableJpaRepositories(basePackages = "com.company.repository")
@EntityScan(basePackages = "com.sfl.entity")
public class ChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class);
    }


  /*  @Bean
    public CommandLineRunner demoData(UserRepository repo) {
        return args -> {

            User user = new User();
            user.setEmail("sevak28@mail.ru");
            user.setPassword(new BCryptPasswordEncoder().encode("123"));
            Set<Role> roles = new HashSet<>();
            Role role = new Role();
            role.setRole(ERole.ROLE_ADMIN);
            roles.add(role);
            user.setRoles(roles);
            repo.save(user);

            User user1 = new User();
            user1.setEmail("test@mail.ru");
            user1.setPassword(new BCryptPasswordEncoder().encode("123"));
            Set<Role> roles1 = new HashSet<>();
            Role role1 = new Role();
            role1.setRole(ERole.ROLE_USER);
            roles1.add(role1);
            user1.setRoles(roles1);
            repo.save(user1);
        };
    }*/
}
