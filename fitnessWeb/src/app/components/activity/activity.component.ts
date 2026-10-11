import { Component,OnInit } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from '../../service/user.service';
import { error } from 'console';

@Component({
  selector: 'app-activity',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './activity.component.html',
  styleUrl: './activity.component.scss'
})
export class ActivityComponent implements OnInit {
  gridStyle={
    width:'100%',
    textAlign:'center'
  };
  activityForm!:FormGroup;
  activities:any;
  constructor(private fb:FormBuilder,private message:NzMessageService,private userService:UserService){}

  
  ngOnInit(){
    this.activityForm=this.fb.group({
      caloriesBurned:[null,[Validators.required]],
      steps:[null,[Validators.required]],
      distance:[null,[Validators.required]],
      date:[null,[Validators.required]],
    });

    this.getAllActivities();
  }
  submitForm(){
    this.userService.postActivity(this.activityForm.value).subscribe(res=>{
        this.message.success("Activity posted successfully",{nzDuration:3000});
        this.activityForm.reset();
        this.getAllActivities();

    },error=>{
        this.message.error("Error while posting Activity",{nzDuration:3000});
    })
  }
  getAllActivities(){
    this.userService.getActivities().subscribe(res=>{
      this.activities=res;
      console.log(this.activities);
    })
  }
  DeleteActivity(id:number){
    this.userService.deleteActivity(id).subscribe(res=>{
      this.message.success("Activity deleted successfully", { nzDuration: 3000 });
      this.getAllActivities();
    }, error => {
      this.message.error("Error while deleting activity", { nzDuration: 3000 });
 
    })
  }
}
