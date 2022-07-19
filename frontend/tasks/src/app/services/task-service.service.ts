import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task,CreateDto, UpdateDto} from '../models/task.model';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {

  constructor(
    private httpClient: HttpClient
  ) { }

  private baseUrl = "http://localhost:8082/api/";

  //Obtener Tareas
  getTasks():Observable<Task[]>{
    return this.httpClient.get<Task[]>(`${this.baseUrl}tasks`)
  }

  //Crear nueva tarea
  createTask(dto:CreateDto){
    return this.httpClient.post<Task>(`${this.baseUrl}`,dto);
  }

  //Actualizar tarea
  updateTask(id:number,dto:UpdateDto){
    return this.httpClient.put<Task>(`${this.baseUrl}${id}`,dto)
  }

  //eliminar Tarea
  deleteTask(id:number){
    return this.httpClient.delete<Task>(`${this.baseUrl}${id}`);
  }

}
