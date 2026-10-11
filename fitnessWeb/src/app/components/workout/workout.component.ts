import { Component } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../service/user.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { error } from 'console';

@Component({
  selector: 'app-workout',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './workout.component.html',
  styleUrl: './workout.component.scss'
})
export class WorkoutComponent {
  gridStyle={
    width:'100%',
    textAlign:'center'
  };
  workoutForm!: FormGroup;
  listOfType:any[]=[
    "Cardio",
    "Strength",
    "Flexibility",
    "HIIT",
    "Pilates",
    "Dance",
    "Swimming",
    "Cycling",
    "Boxing",
    "CrossFit",
    "Rowing",
    "Stretching",
    "Martial Arts",
    "Gymnastics",
    "climbing",
    "Plyometrics"
  ];
  workouts:any;
  constructor(private fb:FormBuilder,private userService:UserService,private message:NzMessageService){}
  ngOnInit(){
    this.workoutForm=this.fb.group({
      type:[null, [Validators.required]],
      duration:[null, [Validators.required]],
      date:[null, [Validators.required]],
      caloriesBurned:[null, [Validators.required]],
    })
    this.getAllWorkouts();
  }
  submitForm(){
    this.userService.postWorkout(this.workoutForm.value).subscribe(res=>{
      this.message.success("Workout posted successfully",{nzDuration:3000});
      this.workoutForm.reset();
      this.getAllWorkouts();
    },error=>{
      this.message.error("Error while posting workout",{nzDuration:3000});
    });
  }
  getAllWorkouts(){
    this.userService.getWorkouts().subscribe(res => {
      this.workouts = res;
      console.log(this.workouts);
    }, error => {
      console.error("Erreur : ", error); // Affiche les erreurs dans la console
    });
  }
  deleteWorkout(id: number) {
    this.userService.deleteWorkout(id).subscribe(() => {
      this.message.success("Workout deleted successfully", { nzDuration: 3000 });
      this.getAllWorkouts();
    }, error => {
      this.message.error("Error while deleting workout", { nzDuration: 3000 });
    });
  }
  
}