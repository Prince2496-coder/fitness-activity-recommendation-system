package com.finess.service;

import com.finess.dto.LoginRequest;
import com.finess.dto.RegisterRequest;
import com.finess.dto.UserResponse;
import com.finess.model.User;
import com.finess.model.UserRole;
import com.finess.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserResponse register(RegisterRequest request) {
        UserRole role = request.getRole() !=null ? request.getRole() : UserRole.USER;
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(role)
                .build();
         User savedUser= userRepository.save(user);
        return mappedtoResponse(savedUser);
    }

    public UserResponse mappedtoResponse(User savedUser) {
        UserResponse response = new UserResponse();
                response.setId(savedUser.getId());
                response.setPassword(savedUser.getPassword());
                response.setFirstName(savedUser.getFirstName());
                response.setLastName(savedUser.getLastName());
                response.setEmail(savedUser.getEmail());
                response.setCreatedat(savedUser.getCreatedat());
                response.setUpdatedat(savedUser.getUpdatedat());
                response.setRole(savedUser.getRole());
                   return  response;
        }
        public User authenticated(LoginRequest request){
            User user = userRepository.findByEmail(request.getEmail());
            if(user==null){
               throw new RuntimeException("Invalid Credentials");
            }
            if (!passwordEncoder.matches(request.getPassword(),user.getPassword())) {
                throw new RuntimeException("Invalid Credentials");
            }
            return user;
        }
    }
