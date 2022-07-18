import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task.model';
import { TaskServiceService} from 'src/app/services/task-service.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks: Task[] = [];

  constructor(private taskService:TaskServiceService) { }

  ngOnInit(): void {
    this.getTasks();
  }

  private getTasks(){
    this.taskService.getTasks().subscribe(date => {
      this.tasks = date;
    })
  }

}


