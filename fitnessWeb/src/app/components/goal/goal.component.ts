import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from '../../service/user.service';
import { SharedModule } from '../../shared/shared.module';
import { error } from 'console';

@Component({
  selector: 'app-goal',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './goal.component.html',
  styleUrl: './goal.component.scss'
})
export class GoalComponent implements OnInit{
gridStyle={
    width:'100%',
    textAlign:'center'
  };
  goalForm!:FormGroup;
  goals:any;
  constructor(private fb:FormBuilder,private message:NzMessageService,private userService:UserService){}

  
  ngOnInit(){
    this.goalForm=this.fb.group({
      description:[null,[Validators.required]],
      startDate:[null,[Validators.required]],
      endDate:[null,[Validators.required]], 
    });
    this.getAllGoals();
  }
  submitForm(){
    this.userService.postGoal(this.goalForm.value).subscribe(res=>{
      this.message.success("Workout posted successfully",{nzDuration:3000});
      this.goalForm.reset();
      this.getAllGoals();
    },error=>{
      this.message.error("Error while posting workout",{nzDuration:3000});
    })
  }
  getAllGoals(){
    this.userService.getGoals().subscribe(res => {
      this.goals = res;
      console.log(this.goals);
    }, error => {
      console.error("Erreur : ", error); // Affiche les erreurs dans la console
    });
  }
  upDateStatus(id:number){
    this.userService.upDateGoalStatus(id).subscribe(res=>{
      this.message.success("Goal updated successfully",{nzDuration:3000});
      this.getAllGoals(); 
    },error=>{
      this.message.error("Error while updating goal",{nzDuration:3000});
    })
  }
  deleteGoal(id:number){
    this.userService.deleteGoal(id).subscribe(res=>{
      this.message.success("Goal deleted successfully",{nzDuration:3000});
      this.getAllGoals();
    }, error => {
      this.message.error("Error while deleting Goal", { nzDuration: 3000 });
    });
  }

}
