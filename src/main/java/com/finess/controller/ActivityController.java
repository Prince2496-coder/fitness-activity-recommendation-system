package com.finess.controller;

import com.finess.dto.RequestActivity;
import com.finess.dto.ResponseActivity;
import com.finess.model.Activity;
import com.finess.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Activity")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ResponseActivity> createactivity(@RequestBody RequestActivity request){
        return  ResponseEntity.ok(activityService.createactivity(request));

    }

    @GetMapping
    public ResponseEntity<List<ResponseActivity>> activitylist(@RequestHeader(name = "xx-header-id") String UserID){
        return ResponseEntity.ok(activityService.trialactivity(UserID));
    }


}
