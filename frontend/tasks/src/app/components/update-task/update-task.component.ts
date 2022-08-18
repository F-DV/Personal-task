import { Component, OnInit, Input } from '@angular/core';
import {TaskServiceService} from '../../services/task-service.service';
import {Task,UpdateDto} from '../../models/task.model';

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.css']
})
export class UpdateTaskComponent implements OnInit {

  //asignar id cuando es presionado el boton editar en el componente padre
  @Input() set assingId(idChosen:number){
    this.idChosen = idChosen;
    this.defaultValue();
    console.log(this.idChosen);
  };

  idChosen:number = 0;

  taskChosen: Task={
    id: 0,
    type: "",
    priority: "",
    description: ""
  }

  options:string[] = ["Hogar","Trabajo","Hábito"];
  priorities:string[] = ["Alta","Media","Baja"];
  tasks: Task[] = [];


  constructor(private taskService: TaskServiceService) { }

  ngOnInit(): void {
    this.getTasks();
  }

  private getTasks(){
    this.taskService.getTasks().subscribe(data => {
      this.tasks = data;
    })
  }

  defaultValue(){
    const index = this.tasks.findIndex(item => item.id === this.idChosen);
    this.taskChosen.id = this.tasks[index].id;
    this.taskChosen.type = this.tasks[index].type;
    this.taskChosen.priority = this.tasks[index].priority;
    this.taskChosen.description = this.tasks[index].description;
  }

  updateTask(){

    try{
      //Cambios recibidos de la vista
      const change:UpdateDto = {
        type: this.taskChosen.type,
        priority: this.taskChosen.priority,
        description: this.taskChosen.description,
      };

      this.taskService.updateTask(this.idChosen,change)
      .subscribe(data => {
        const taskIndex = this.tasks.findIndex(item => item.id === this.taskChosen.id);
        this.tasks[taskIndex] = data;
      });
      this.getTasks();
      alert("La tarea se edito con exito")
;    }catch(error){
      console.log('no se pudo editar:',error)
    }
  }

  cancel(){
    this.taskChosen = {
      id:0,
      type: "",
      priority: "",
      description: ""
    };
  }

}
