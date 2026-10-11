import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SharedModule } from '../../shared/shared.module';
import { AuthService } from '../../service/auth.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  registerForm!:FormGroup

  constructor(private fb:FormBuilder,private authService:AuthService,private message:NzMessageService,private router:Router){}
  ngOnInit(){
    this.registerForm=this.fb.group({
      
      username:[null,[Validators.required]],
      password:[null,[Validators.required]]
    })
  }
  submitForm(): void {
    if (this.registerForm.invalid) {
      this.message.error('Please fill out all fields!', { nzDuration: 3000 });
      return;
    }

    const { username, password } = this.registerForm.value;

    this.authService.register({ username, password }).subscribe(
      (res: any) => {
        console.log('Registration Response:', res);
        if (res === 'User registered successfully!') {
          this.message.success('Signup successful', { nzDuration: 3000 });
          this.router.navigateByUrl('login'); // Redirect to login page after registration
        } else {
          this.message.error(res || 'Registration failed!', { nzDuration: 3000 });
        }
      },
      (error) => {
        // Handle HTTP errors (e.g., 400 Bad Request, 409 Conflict)
        this.message.error(error.error || 'An error occurred during registration.', { nzDuration: 3000 });
      }
    );
  
  }

}
