import { Routes } from '@angular/router';
import { ActivityComponent } from './components/activity/activity.component';
import { WorkoutComponent } from './components/workout/workout.component';
import { GoalComponent } from './components/goal/goal.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { forbiddenGuard } from './guard/forbidden.guard';
import { DeniedAcsessComponent } from './guard/denied-acsess/denied-acsess.component';

export const routes: Routes = [
    {path:"activity",component:ActivityComponent,canActivate:[forbiddenGuard]},
    {path:"workout",component:WorkoutComponent,canActivate:[forbiddenGuard]},
    {path:"goal",component:GoalComponent,canActivate:[forbiddenGuard]},
    {path:"register",component:RegisterComponent},
    {path:"login",component:LoginComponent},
    {path:"dashboard",component:DashboardComponent,canActivate:[forbiddenGuard]},
    {path:"deniedAcces",component:DeniedAcsessComponent},
];
