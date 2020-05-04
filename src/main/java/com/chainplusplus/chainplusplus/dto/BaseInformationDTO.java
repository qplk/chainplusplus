package com.chainplusplus.chainplusplus.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseInformationDTO {

    private String disease;
    private int age;
    private String gender;
}
