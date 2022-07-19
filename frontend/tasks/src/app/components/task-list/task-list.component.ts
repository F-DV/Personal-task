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
  showEdit:boolean = false;
  editId:number = 0;

  constructor(
    private taskService:TaskServiceService,
    ) { }

  ngOnInit(): void {
    this.getTasks();
  }

  private getTasks(){
    this.taskService.getTasks().subscribe(data => {
      this.tasks = data;
    })
  }
  up(i:number,task:any){
    let insert:number = i - 1;
    this.tasks.splice(i,1);
    this.tasks.splice(insert,0,task);
  }
  down(i:number,task:any){
    let insert:number = i + 1;
    this.tasks.splice(i,1);
    this.tasks.splice(insert,0,task);
  }

  edit(id:number){
    this.editId = id;
    this.showEdit = true;
  }

  delet(id:number){
    this.taskService.deleteTask(id)
    .subscribe(dato => console.log(dato));
    this.getTasks();
  }

}


