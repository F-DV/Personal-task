import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/task.model';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {

  constructor(
    private httpClient: HttpClient
  ) { }

  private baseUrl = "http://localhost:8080/api";

  //Obtener Tareas
  getTasks():Observable<Task[]>{
    return this.httpClient.get<Task[]>(`${this.baseUrl}/tasks`)
  }

}
