import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const BASIC_URL="http://localhost:8089/"

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }
  
  register(signupRequest:any):Observable<any>{
    return this.http.post(BASIC_URL+"api/auth/register" ,signupRequest, { responseType: 'text' });
  }
  login(loginRequest:any):Observable<any>{
    return this.http.post(BASIC_URL+"api/auth/login",loginRequest, { responseType: 'text' });
  }
}
