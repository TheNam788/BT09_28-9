package vn.iotstar.example1.controller; import lombok.RequiredArgsConstructor; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import vn.iotstar.example1.entity.*; import vn.iotstar.example1.repository.*;
@Controller @RequiredArgsConstructor public class AuthController { private final RoleRepository roleRepo; private final UserRepository userRepo; private final PasswordEncoder passwordEncoder;
 @GetMapping("/login") String login(){return "auth/login";}
 @GetMapping("/register") String register(){return "auth/register";}
 @PostMapping("/register") String createAccount(@RequestParam String fullName,@RequestParam String email,@RequestParam String password,@RequestParam String confirmPassword,Model model){
  if(userRepo.existsByEmailIgnoreCase(email)){model.addAttribute("error","Email đã được sử dụng."); return "auth/register";}
  if(!password.equals(confirmPassword)){model.addAttribute("error","Mật khẩu xác nhận không khớp."); return "auth/register";}
  Role userRole=roleRepo.findByName("USER").orElseGet(()->roleRepo.save(new Role(null,"USER")));
  userRepo.save(new User(null,email,passwordEncoder.encode(password),fullName,true,userRole));
  return "redirect:/login?registered=true";
 }
 @GetMapping("/forgot-password") String forgotPassword(){return "auth/forgot-password";}
 @PostMapping("/forgot-password") String resetPassword(@RequestParam String email,@RequestParam String password,@RequestParam String confirmPassword,Model model){
  if(!password.equals(confirmPassword)){model.addAttribute("error","Mật khẩu xác nhận không khớp."); return "auth/forgot-password";}
  User user=userRepo.findByEmailIgnoreCase(email).orElse(null);
  if(user==null){model.addAttribute("error","Không tìm thấy tài khoản với email này."); return "auth/forgot-password";}
  user.setPassword(passwordEncoder.encode(password)); userRepo.save(user);
  return "redirect:/login?reset=true";
 }
 @GetMapping("/") String home(){return "home";} }
