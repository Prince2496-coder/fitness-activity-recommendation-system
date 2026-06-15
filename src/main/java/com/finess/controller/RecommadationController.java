package com.finess.controller;

import com.finess.dto.requestrecommadation;
import com.finess.model.Recommadation;
import com.finess.service.RecommadationService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommadation")
public class RecommadationController {
    private final RecommadationService recommadationservice;

    @PostMapping("/generate")
    public ResponseEntity<Recommadation> generateRecommadation(@RequestBody requestrecommadation request){
        return ResponseEntity.ok(recommadationservice.generate(request));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommadation>> UserRecommadation(@PathVariable("userId") String userId){
        return ResponseEntity.ok(recommadationservice.UserRecommadation(userId));
    }
    @GetMapping("/activity/{activityId}")
    public ResponseEntity< List<Recommadation>> ActivityRecommadation(@PathVariable("activityId") String activityId){
        return ResponseEntity.ok(recommadationservice.ActivityRecommadation(activityId));
    }

}

