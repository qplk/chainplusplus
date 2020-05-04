package com.chainplusplus.chainplusplus.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Optional;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityDTO {

    public ActivityDTO(String activity, Integer frequency, String dimension) {
        this.activity = activity;
        this.frequency = Optional.ofNullable(frequency).orElse(0);
        this.dimension = Optional.ofNullable(dimension).orElse("");
    }

    private String activity;
    private Integer frequency;
    private String dimension;
}
