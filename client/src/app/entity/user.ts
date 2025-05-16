import {Role} from './role';
import {UserStatus} from './userstatus';
import {UserType} from './usertype';
import {Employee} from './employee';

export interface User{

  id?: number;
  email: string;
  password: string;
  roles: Role[];
  employee: Employee;
  docreated?: string;
  tocreated?: string;
  userstatus: UserStatus;
  usertype: UserType;
  description?: string;

}
