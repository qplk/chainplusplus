package com.chainplusplus.chainplusplus.service;

import com.chainplusplus.chainplusplus.dto.ActivityDTO;
import com.chainplusplus.chainplusplus.dto.BaseInformationDTO;
import com.chainplusplus.chainplusplus.repository.ActivityRepository;
import com.chainplusplus.chainplusplus.repository.AnswerRepository;
import com.chainplusplus.chainplusplus.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class ProcessingService {

    private final SymptomRepository symptomRepository;
    private final AnswerRepository answerRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public ProcessingService(SymptomRepository symptomRepository,
                             AnswerRepository answerRepository,
                             ActivityRepository activityRepository) {
        this.symptomRepository = symptomRepository;
        this.answerRepository = answerRepository;
        this.activityRepository = activityRepository;
    }

    public Map<String, List<String>> generateProfile(BaseInformationDTO baseInformation) {
        Map<String, List<String>> profileMap = new HashMap<>();

        List<String> allSymptomsByDisease = symptomRepository.findAllSymptomsByDisease(baseInformation.getDisease());
        allSymptomsByDisease.forEach(symptom -> profileMap.put(symptom, answerRepository.findAllAnswersForSymptom(symptom)));

        return profileMap;
    }

    public Set<ActivityDTO> generateSchedule(Map<String, String> answerMap, String disease) {
        Set<ActivityDTO> allNecessaryActivities = new HashSet<>();

        Iterator<Map.Entry<String, String>> iterator = answerMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            List<ActivityDTO> allActivitiesByAnswer = activityRepository.findAllActivitiesByAnswer(next.getValue());
            if (CollectionUtils.isEmpty(allActivitiesByAnswer)) {
                allActivitiesByAnswer = activityRepository.findAllActivitiesBySymptom(next.getKey());
            }
            allNecessaryActivities.addAll(allActivitiesByAnswer);
        }
        return allNecessaryActivities;
    }
}
