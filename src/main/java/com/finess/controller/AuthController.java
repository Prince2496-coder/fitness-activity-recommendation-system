package com.finess.controller;

import com.finess.Security.JwtUtils;
import com.finess.dto.LoginRequest;
import com.finess.dto.LoginResponse;
import com.finess.dto.RegisterRequest;
import com.finess.dto.UserResponse;
import com.finess.model.User;
import com.finess.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userservice;
   private final JwtUtils jwtUtils;

    @PostMapping ("/register")
        public ResponseEntity<UserResponse> register(@Valid  @RequestBody RegisterRequest request){
          return ResponseEntity.ok(userservice.register(request));
        }

        @PostMapping("/Login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
try{
            User user = userservice.authenticated(request);
            String token = jwtUtils.generateJwtToken(user.getId(),user.getRole().name());
            return ResponseEntity.ok(new LoginResponse(token , userservice.mappedtoResponse(user)))
                    ;
        }catch (Exception e){
    e.printStackTrace();
return  ResponseEntity.status(401).build();
        }

}}