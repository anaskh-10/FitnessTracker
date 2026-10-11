import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const BASIC_URL="http://localhost:8089/"
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }
  
  postActivity(activityDto:any):Observable<any>{
    return this.http.post(BASIC_URL+"api/activity" ,activityDto);
  }
  getActivities():Observable<any>{
    return this.http.get(BASIC_URL+"api/activities");
  }
  deleteActivity(id: number): Observable<any> {
    return this.http.delete(`${BASIC_URL}api/activity/${id}`);
  }
  postWorkout(workoutDto:any):Observable<any>{
    return this.http.post(BASIC_URL+"api/workout" ,workoutDto);
  }
  getWorkouts():Observable<any>{
    return this.http.get(BASIC_URL+"api/workouts");
  }
  deleteWorkout(id: number): Observable<any> {
    return this.http.delete(`${BASIC_URL}api/workout/${id}`);
  }
  postGoal(goalDto:any):Observable<any>{
    return this.http.post(BASIC_URL+"api/goal" ,goalDto);
  }
  getGoals():Observable<any>{
    return this.http.get(BASIC_URL+"api/goals");
  }
  upDateGoalStatus(id:number):Observable<any>{
    return this.http.get(BASIC_URL+"api/goal/status/"+id);
  }
  deleteGoal(id: number): Observable<any> {
    return this.http.delete(`${BASIC_URL}api/goal/${id}`);
  }
  getStats():Observable<any>{
    return this.http.get(BASIC_URL+"api/stats");
  }
  getGraphStats():Observable<any>{
    return this.http.get(BASIC_URL+"api/graphs");
  }

} 
