package com.chainplusplus.chainplusplus.controller;

import com.chainplusplus.chainplusplus.dto.ActivityDTO;
import com.chainplusplus.chainplusplus.dto.BaseInformationDTO;
import com.chainplusplus.chainplusplus.service.ProcessingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
public class MainController {

    @Autowired
    private ProcessingService processingService;

    @CrossOrigin
    @PostMapping(value = "/baseInformation")
    public Map<String, List<String>> baseInformation(@RequestBody BaseInformationDTO baseInformationDTO) {
        return processingService.generateProfile(baseInformationDTO);
    }

    @CrossOrigin
    @PostMapping(value = "/details/{disease}")
    public Set<ActivityDTO> necessaryActivities(@PathVariable String disease,
                                                @RequestBody Map<String, String> answerMap) {

        Set<ActivityDTO> activityDTOS = processingService.generateSchedule(answerMap, disease);
        return activityDTOS;
    }
}
