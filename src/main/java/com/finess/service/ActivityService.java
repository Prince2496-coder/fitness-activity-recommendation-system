package com.finess.service;

import com.finess.dto.RequestActivity;
import com.finess.dto.ResponseActivity;
import com.finess.model.Activity;
import com.finess.model.User;
import com.finess.repo.ActivityRepository;
import com.finess.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    public ResponseActivity createactivity(RequestActivity request) {

        User user = userRepository.findById(request.getUserID())
                .orElseThrow(() -> new RuntimeException("User not found" + request.getUserID()));
        Activity activity = Activity.builder()
                .user(user)
                .activityType(request.getActivityType())
                .CaloriesBurened(request.getCaloriesBurened())
                .duration(request.getDuration())
                .additionalmatrics(request.getAdditionalmatrics())
                .Startedat(request.getStartedat())
                .build();
           Activity savedactivity = activityRepository.save(activity);
       return mappedtoResponse(savedactivity);
    }

    private ResponseActivity mappedtoResponse(Activity savedactivity) {
        ResponseActivity response = new ResponseActivity();
        response.setId(savedactivity.getId());
        response.setActivityType(savedactivity.getActivityType());
        response.setAdditionalmatrics(savedactivity.getAdditionalmatrics());
        response.setDuration(savedactivity.getDuration());
        response.setCreatedat(savedactivity.getCreatedat());
        response.setUpdatedat(savedactivity.getUpdatedat());
        response.setStartedat(savedactivity.getStartedat());
        response.setUserID(savedactivity.getUser().getId());
        response.setCaloriesBurened(savedactivity.getCaloriesBurened());
        return response;
    }

    public List<ResponseActivity> trialactivity(String userID) {

        List<Activity> AL = activityRepository.findByUserId(userID);
     return AL.stream()
             .map(this::mappedtoResponse)
             .collect(Collectors.toList());
    }
}
