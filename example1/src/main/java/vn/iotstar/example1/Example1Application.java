package vn.iotstar.example1;
import org.springframework.boot.*; import org.springframework.boot.autoconfigure.SpringBootApplication; import org.springframework.context.annotation.Bean; import org.springframework.security.crypto.password.PasswordEncoder;
import vn.iotstar.example1.entity.*; import vn.iotstar.example1.repository.*;
@SpringBootApplication public class Example1Application {
 public static void main(String[] args){SpringApplication.run(Example1Application.class,args);}
 @Bean CommandLineRunner init(RoleRepository rr, UserRepository ur, PasswordEncoder pe){return a->{
  Role admin=rr.findByName("ADMIN").orElseGet(()->rr.save(new Role(null,"ADMIN")));
  if(!ur.existsByEmailIgnoreCase("admin@hcmute.edu.vn")) ur.save(new User(null,"admin@hcmute.edu.vn",pe.encode("123456"),"System Administrator",true,admin));
 };}
}
