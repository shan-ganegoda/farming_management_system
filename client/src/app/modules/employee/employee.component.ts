import {Component, OnInit} from '@angular/core';
import {Breadcrumb} from 'primeng/breadcrumb';
import {MenuItem} from 'primeng/api';
import {MatGridList, MatGridTile} from '@angular/material/grid-list';
import {ReactiveFormsModule} from '@angular/forms';
import {FloatLabel} from 'primeng/floatlabel';
import {InputText} from 'primeng/inputtext';
import {Select} from 'primeng/select';
import {DatePicker} from 'primeng/datepicker';
import {Textarea} from 'primeng/textarea';
import {Button, ButtonModule} from 'primeng/button';
import {ButtonGroup} from 'primeng/buttongroup';

interface Gender {
  name: string;
  id: string;
}

interface Designation {
  name: string;
  id: string;
}

interface EmployeeStatus {
  name: string;
  id: string;
}

interface EmployeeType {
  name: string;
  id: string;
}

@Component({
  selector: 'app-employee',
  imports: [
    Breadcrumb,
    MatGridList,
    MatGridTile,
    ReactiveFormsModule,
    FloatLabel,
    InputText,
    Select,
    DatePicker,
    Textarea,
    Button,
    ButtonModule,
    ButtonGroup
  ],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.scss'
})
export class EmployeeComponent implements OnInit{

  items: MenuItem[] | undefined;

  genders: Gender[] = [{ name: 'New York', id: 'NY' },
    { name: 'Rome', id: 'RM' },];

  designations: Designation[] = [{ name: 'New York', id: 'NY' },
    { name: 'Rome', id: 'RM' },];

  employeetypes: Designation[] = [{ name: 'New York', id: 'NY' },
    { name: 'Rome', id: 'RM' },];

  employeestatuses: Designation[] = [{ name: 'New York', id: 'NY' },
    { name: 'Rome', id: 'RM' },];




  home: MenuItem | undefined;
  imageempurl: string = "";

  constructor() {
  }

  ngOnInit() {
    this.items = [
      { label: 'Main' },
      { label: 'Employee' },
    ];

    this.home = { icon: 'pi pi-home', routerLink: '../home' };
  }


  selectImage($event: Event) {

  }

  clearImage() {

  }
}
