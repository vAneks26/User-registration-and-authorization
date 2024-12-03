package org.example.zacodirartem2.service;

import lombok.AllArgsConstructor;
import org.example.zacodirartem2.entity.UserEntity;
import org.example.zacodirartem2.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    UserRepo userRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder(){return new BCryptPasswordEncoder();}

    public void save(UserEntity userEntity) {
        userEntity.setPassword(bCryptPasswordEncoder().encode(userEntity.getPassword()));
        userRepo.save(userEntity);
    }
    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }

    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }

}
