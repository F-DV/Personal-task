import { Component, OnInit } from '@angular/core';
import {TaskServiceService} from '../../services/task-service.service';
import {Task} from '../../models/task.model';

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {

  options:string[] = ["Hogar","Trabajo","Hábito"];
  priorities:string[] = ["Alta","Media","Baja"];
  name:string ="";
  task: Task = {
    id:0,
    type: "",
    priority: "",
    description: ""
  }

  constructor(
    private taskService: TaskServiceService
  ) { }

  ngOnInit(): void {
  }

  createNewTask(){
    this.taskService.createTask(this.task)
    .subscribe(data => {
      console.log('data',data);
    })


  }
  cancel(){
    this.task = {
      id:0,
      type: "",
      priority: "",
      description: ""
    }
  }

}
