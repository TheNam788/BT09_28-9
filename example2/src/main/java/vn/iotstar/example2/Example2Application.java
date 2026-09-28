package vn.iotstar.example2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import vn.iotstar.example2.entity.Role;
import vn.iotstar.example2.entity.User;
import vn.iotstar.example2.repository.RoleRepository;
import vn.iotstar.example2.repository.UserRepository;

@SpringBootApplication
public class Example2Application {

    public static void main(String[] args) {
        SpringApplication.run(Example2Application.class, args);
    }

    @Bean
    CommandLineRunner init(RoleRepository rr, UserRepository ur, PasswordEncoder pe) {
        return args -> {
            Role role = rr.findByName("ROLE_USER")
                    .orElseGet(() -> rr.save(Role.builder()
                            .name("ROLE_USER")
                            .build()));

            if (ur.findByUsername("ntn").isEmpty()) {
                ur.save(User.builder()
                        .username("ntn")
                        .email("ntn@gmail.com")
                        .password(pe.encode("123456"))
                        .fullName("Nguyễn Thế Nam")
                        .images("/images/user.svg")
                        .enabled(true)
                        .role(role)
                        .build());
            }
        };
    }
}
