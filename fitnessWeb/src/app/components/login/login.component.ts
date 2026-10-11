import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';
import { AuthService } from '../../service/auth.service';
import { UserStorageService } from '../../service/user-storage.service';
import { error } from 'console';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  loginForm!:FormGroup;

  constructor(private fb:FormBuilder,private message:NzMessageService,private router:Router,private authService:AuthService){}
  ngOnInit(){
    this.loginForm=this.fb.group({
      username:[null,Validators.required],
      password:[null,Validators.required]
    })
  }
  submitForm(): void {
    if (this.loginForm.invalid) {
      this.message.error('Please fill out all fields!', { nzDuration: 3000 });
      return;
    }
  
    const { username, password } = this.loginForm.value;
  
    this.authService.login({ username, password }).subscribe(
      (res: any) => {
        console.log('Login Response:', res);
  
        // Check if the response contains a valid userId
        if (res ==='Login successful!') {
          const user = {
            id: res.userId,
            username: username // Optionally save the username as well
          };
  
          // Save the user data in localStorage
          UserStorageService.saveUser(user);
  
          // Show success message and redirect to the dashboard
          this.message.success('Login successful', { nzDuration: 3000 });
          this.router.navigateByUrl('/dashboard');
        } else {
          this.message.error('Unexpected response from the server.', { nzDuration: 3000 });
        }
      },
      (error) => {
        console.error('Login Error:', error);
  
        // Handle specific HTTP errors
        if (error.status === 401) {
          this.message.error('Invalid credentials!', { nzDuration: 5000 });
        } else {
          this.message.error('An error occurred during login.', { nzDuration: 5000 });
        }
      }
    );
  }
}
