package com.backend.a3BE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.a3BE.model.SurveyForm;
import com.backend.a3BE.service.SurveyService;

/**
 * Added annotations to avoid CORs error
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    
    /**
     * Controller to fetch all survey records
     */
    @GetMapping(value = "/findAll")
    public  ResponseEntity<List<SurveyForm>> findAll() {
        return ResponseEntity.ok(surveyService.allSurveys());
    }

    /**
     * Controller to add the survey form to the database
     * @param resource
     * @return the
     */
    @PostMapping(value = "/saveSurvey")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SurveyForm> create(@RequestBody SurveyForm resource) {
    	System.out.println(resource);
        return  ResponseEntity.ok(surveyService.saveSurvey(resource));
    }
    
    
    /**
     * Controller to edit/update the survey
     * @param resource
     * @param id
     * @return
     */
    @PutMapping(value = "/editSurvey/{id}")
    public ResponseEntity<SurveyForm> updateRequest(@RequestBody SurveyForm resource, @PathVariable Long id) {
    	System.out.println(resource);
    	
        return  ResponseEntity.ok(surveyService.updateSurvey(resource, id));
    }
    
    /**
     * Controller to delete the survey
     * @param id
     */
    @DeleteMapping(value = "/deleteSurvey/{id}")
    public void deleteSurvey(@PathVariable Long id) {
    	System.out.println(id);
    	
       surveyService.deleteSurvey(id);
    }

    

}
