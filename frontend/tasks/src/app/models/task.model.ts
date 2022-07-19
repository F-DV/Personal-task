export interface Task{
  id:number;
  type: string;
  description: string;
  priority:string;
}

export interface CreateDto extends Omit<Task, 'id'>{

}

export interface UpdateDto extends Partial<CreateDto>{

}


