package com.backend.a3BE.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.a3BE.model.SurveyForm;

/**
 * Repository class to work with data
 */
@Repository
public interface SurveyRepository extends JpaRepository<SurveyForm, Long>{
	
	Optional<SurveyForm> findById(Long id);
	
	SurveyForm findByEmail(String email);
	
	
	

}
