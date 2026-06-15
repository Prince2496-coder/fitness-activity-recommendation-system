package com.finess.dto;

import com.finess.model.Activity_Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequestActivity {
    private String UserID;
    private Activity_Type activityType;
    private Map<String,Object> additionalmatrics;
    private Integer duration;
    private Integer CaloriesBurened;
    private LocalDateTime Startedat;
}
