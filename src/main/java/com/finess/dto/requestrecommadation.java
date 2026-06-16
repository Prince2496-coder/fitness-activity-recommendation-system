package com.finess.dto;

import com.finess.model.Activity;
import com.finess.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data@NoArgsConstructor@AllArgsConstructor
public class requestrecommadation {

    private User userId;

    private Activity  activityId;

    private List<String> suggestions;

    private List<String> improvements;

    private List<String> safety;

}
