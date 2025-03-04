import { Component, OnInit } from '@angular/core';
import { SurveyService } from '../survey.service';
import { SurveyForm } from '../models/survey-form';
import { Router } from '@angular/router';

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrl: './survey.component.css'
})
export class SurveyComponent implements OnInit {
onCancel() {
  this.router.navigate(['']);
}


  survey: SurveyForm = new SurveyForm();
  interested: string[] = ['Friends', 'Television', 'Internet', 'Other'];

  likedMost = [
    { label: 'Students', checked: false },
    { label: 'Location', checked: false },
    { label: 'Campus', checked: false },
    { label: 'Atmosphere', checked: false },
    { label: 'Dorm rooms', checked: false },
    { label: 'Sports', checked: false }
  ];


  selectedOptions: {[key: string]: boolean} = {};
  likelihoodValues = [ 'Very Likely', 'Likely', 'Not Likely'];
  likelihood: string = '';
 
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  constructor(private surveyService:SurveyService, private router: Router) { }

  //Create a survey
  saveSurvey(){
    this.surveyService.createSurvey(this.survey).subscribe( data =>{
      console.log(data);
      this.goToSurveyList();
    },
    error => console.log(error));
  }

  goToSurveyList(){
    this.router.navigate(['/view-surveys']);
  }

  validatePhoneNumber() {
    console.log(this.survey.telephoneNumber);
    
    const phoneNumberPattern = /^\d{10}$/;
    if (phoneNumberPattern.test(this.survey.telephoneNumber)) {
      return null;
    } else {
      return { invalidPhoneNumber: true };
    }
  }

  displayErrorMessage(input: any) {
    if (input.control.hasError('required')) {
      console.log('Input is required');
    } else {
      input.control.markAsTouched();
    }
  }

  displayDOS(input: any) {
    return (this.survey.dateOfSurvey == null);
  }

  checkRequired() {
    console.log(this.survey.firstName!= '' && this.survey.lastName!= '' && this.survey.streetAddress!= '' && this.survey.city!= '' && this.survey.state!= '' && this.survey.zip!= '' && this.survey.telephoneNumber!= '' && this.survey.email!= '' && this.survey.dateOfSurvey!= null);
    
    return this.survey.firstName!= '' && this.survey.lastName!= '' && this.survey.streetAddress!= '' && this.survey.city!= '' && this.survey.state!= '' && this.survey.zip!= '' && this.survey.telephoneNumber!= '' && this.survey.email!= '' && this.survey.dateOfSurvey!= null;
    }
  
  onSubmit(){
    this.survey.likedMost = JSON.stringify(this.likedMost);
    console.log(this.survey.likedMost);
       
    console.log(this.survey);
    this.saveSurvey();
  }

}
