# SmartSurvey: A Full-Stack Feedback App

## Overview
SmartSurvey is a full-stack web application designed to collect and manage user feedback through surveys. Built with **Java Spring Boot** for the backend and **Angular** for the frontend, the application enables users to create, view, update, and delete surveys. The project follows a structured approach to ensure scalability, maintainability, and performance.

## Tech Stack
- **Backend:** Java Spring Boot
- **Frontend:** Angular
- **Database:** SQL Server

---

## Backend Setup (Spring Boot)

1. **Create the Survey model:**
    ```java
    @Entity
    @Table(name = "surveys")
    public class Survey { ... }
    ```

2. **Implement the repository interface:**
    ```java
    public interface SurveyRepository extends JpaRepository<Survey, Long> { }
    ```

3. **Implement the service layer:**
    ```java
    @Service
    public class SurveyService { ... }
    ```

4. **Implement the controller (`@RestController`) with API endpoints:**
    - Creating a survey (`POST /api/surveys`)
    - Fetching surveys (`GET /api/surveys`)
    - Updating a survey (`PUT /api/surveys/{id}`)
    - Deleting a survey (`DELETE /api/surveys/{id}`)

5. **Run the backend application from Eclipse as a Java Application.**

---

## Frontend Setup (Angular)

1. **Install Angular CLI:**
    ```sh
    npm install -g @angular/cli
    ```
2. **Verify the installation:**
    ```sh
    ng version
    ```
3. **Create a new Angular project:**
    ```sh
    ng new angular-survey --standalone=true
    ```
4. **Navigate to the project directory and run:**
    ```sh
    ng serve --watch
    ```
    - The application will run on `http://localhost:4200`

5. **Create components:**
    ```sh
    ng g c home
    ng g c view-surveys
    ng g c survey
    ng g c page-not-found
    ```
6. **Create a Survey model in `models/survey.model.ts`**:
    ```ts
    export interface Survey {
      id: number;
      title: string;
      description: string;
    }
    ```
7. **Set up `survey.service.ts`:**
    ```ts
    import { HttpClient } from '@angular/common/http';
    
    constructor(private http: HttpClient) { }
    fetchSurveys() { return this.http.get('/api/surveys'); }
    ```
8. **Install dependencies:**
    ```sh
    npm install bootstrap sweetalert2 angular-material
    ```
9. **Add routes in `app-routing.module.ts`:**
    ```ts
    const routes: Routes = [
      { path: '', component: HomeComponent },
      { path: 'survey-list', component: ViewSurveysComponent },
      { path: 'add-survey', component: SurveyComponent },
      { path: '**', component: PageNotFoundComponent }
    ];
    ```
10. **Implement survey list and form components using Bootstrap.**

---

## Features
✅ **Create surveys**  
✅ **View list of surveys**  
✅ **Update survey details**  
✅ **Delete surveys**  
✅ **Responsive UI**  
✅ **Secure API endpoints with validation**  

---

## Running the Application

1. **Start the backend (Spring Boot) from Eclipse.**
2. **Start the frontend (Angular):**
    ```sh
    ng serve
    ```
3. **Open `http://localhost:4200` in the browser.**

---

## API Endpoints

| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | `/api/surveys` | Get all surveys |
| POST | `/api/surveys` | Create a new survey |
| PUT | `/api/surveys/{id}` | Update survey by ID |
| DELETE | `/api/surveys/{id}` | Delete survey by ID |

---

## Future Enhancements
- Add user authentication with JWT
- Implement survey analytics and reporting
- Enhance UI with Material Design
- Deploy on AWS or Azure

---

## Contributors
📌 Developed as part of **SWE-642 HW3 Assignment**  
📌 Team: Keerthi Ramireddy, Mary Rithika Reddy Gade, Karthik Reddy Musku, Meghana Tummala  

---

## License
This project is licensed under the **MIT License**.
