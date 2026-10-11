import { Component } from '@angular/core';
import { NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { SharedModule } from './shared/shared.module';
import { UserStorageService } from './service/user-storage.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,SharedModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'fitnessWeb';
  isCollapsed = false;
  isUserLoggedIn:boolean=UserStorageService.isUserLoggedin();
  constructor(private router:Router){}
  ngOnInit(){
    this.router.events.subscribe(event=>{
      if (event instanceof NavigationEnd) {
        this.isUserLoggedIn = UserStorageService.isUserLoggedin();
      }
    });
  }
  logout(){
    UserStorageService.signout();
    this.router.navigateByUrl('/login')
  }
  
}
