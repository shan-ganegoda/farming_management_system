import { Injectable } from '@angular/core';
import {environment} from '../../environment';
import {HttpClient} from '@angular/common/http';
import {Employee} from '../../entity/employee';

const API_URL = environment.apiUrl + '/employees';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  getAll(query:string){
    return this.http.get<Employee[]>(API_URL + query);
  }

  save(employee:Employee){
    return this.http.post<Employee>(API_URL,employee);
  }

  update(employee:Employee){
    return this.http.put<Employee>(API_URL,employee);
  }

  delete(id:number){
    return this.http.delete(API_URL + '/' + id);
  }
}
