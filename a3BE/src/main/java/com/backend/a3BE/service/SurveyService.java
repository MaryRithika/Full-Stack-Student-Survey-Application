package com.backend.a3BE.service;

import java.util.List;

import com.backend.a3BE.model.SurveyForm;


/**
 * Service interface to define all the methods
 */
public interface SurveyService {
	List<SurveyForm> allSurveys();

    public SurveyForm saveSurvey(SurveyForm survey);
    
    public SurveyForm updateSurvey(SurveyForm survey, Long id);
    
    public void deleteSurvey(Long id);

}
