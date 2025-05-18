import {Gender} from './gender';
import {Designation} from './designation';
import {EmployeeStatus} from './EmployeeStatus';
import {EmployeeType} from './employeetype';

export interface Employee{

  id: number;
  firstname:string;
  lastname:string;
  photo:string;
  nic:string;
  empnumber:string;
  mobile:string;
  land:string;
  email:string;
  gender:Gender;
  dob:string;
  designation:Designation;
  doassigned:string;
  employeestatus:EmployeeStatus;
  employeetype:EmployeeType;
  description:string;

}
