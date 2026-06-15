package com.finess.service;

import com.finess.dto.requestrecommadation;
import com.finess.model.Activity;
import com.finess.model.Recommadation;
import com.finess.model.User;
import com.finess.repo.ActivityRepository;
import com.finess.repo.RecommadationRepository;
import com.finess.repo.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommadationService {
    private final RecommadationRepository recommadationrepository;
    private final ActivityRepository activityrepository;
    private final UserRepository userrepository;


    public Recommadation generate(requestrecommadation request) {
        User user =  userrepository.findById(request.getUserId().getId())
                .orElseThrow(() -> new RuntimeException("User not found" + request.getUserId()));
        Activity activity =   activityrepository.findById(request.getActivityId().getId())
                .orElseThrow(() -> new RuntimeException("Activity not found" + request.getActivityId()));
        Recommadation recommadation = Recommadation.builder()
                .user(user)
        .activity(activity)
        .improvements(request.getImprovements())
                .safety(request.getSafety())
                .suggestions(request.getSuggestions())
                .build();
        return recommadationrepository.save(recommadation);
    }



    public List<Recommadation> UserRecommadation(String userId) {

        return recommadationrepository.findByUserId(userId);
    }

    public List<Recommadation> ActivityRecommadation(String activityId) {
        return recommadationrepository.findByActivityId(activityId);
    }
}
