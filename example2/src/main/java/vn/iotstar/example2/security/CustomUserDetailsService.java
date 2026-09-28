package vn.iotstar.example2.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.iotstar.example2.entity.User;
import vn.iotstar.example2.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    public UserDetails loadUserByUsername(String login) {
        User user = repo.findByUsernameOrEmail(login, login)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy username/email: " + login));

        return new CustomUserDetails(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getFullName(),
                user.getImages(),
                user.getRole().getName(),
                user.isEnabled());
    }
}
