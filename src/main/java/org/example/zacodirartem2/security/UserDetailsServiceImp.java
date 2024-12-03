package org.example.zacodirartem2.security;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.zacodirartem2.entity.UserEntity;
import org.example.zacodirartem2.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {
    UserRepo userRepo;

    @Override
    @Transactional
    public UserDetailsImp loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("нет email юзера"+username+"в бд"));
        return UserDetailsImp.fromUser(userEntity);
    }
}
