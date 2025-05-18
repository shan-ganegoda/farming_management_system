import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
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
import {MatPaginator} from '@angular/material/paginator';
import {AsyncPipe} from '@angular/common';
import {MatTableDataSource} from '@angular/material/table';
import {Employee} from '../../entity/employee';
import {Observable} from 'rxjs';
import {EmployeeService} from '../../services/employee/employee.service';

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
    ButtonGroup,
    MatPaginator,
    AsyncPipe,
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

  isFailed = false;
  isLoading = false;

  // protected hasUpdateAuthority = this.authorizationService.hasAuthority("Employee-Update"); //need to be false
  // protected hasDeleteAuthority = this.authorizationService.hasAuthority("Employee-Delete"); //need to be false
  // protected hasWriteAuthority = this.authorizationService.hasAuthority("Employee-Write"); //need to be false
  // protected hasReadAuthority = this.authorizationService.hasAuthority("Employee-Read"); //need to be false

  protected hasUpdateAuthority = false
  protected hasDeleteAuthority = false
  protected hasWriteAuthority = false
  protected hasReadAuthority = false

  employees: Employee[] = [];

  dataSource!: MatTableDataSource<Employee>;
  data!: Observable<any>
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  home: MenuItem | undefined;
  imageempurl: string = "";

  constructor(
    private es:EmployeeService,
    private cdr:ChangeDetectorRef,
    ) {
  }

  ngOnInit() {
    this.items = [
      { label: 'Main' },
      { label: 'Employee' },
    ];

    this.home = { icon: 'pi pi-home', routerLink: '../home' };

    this.initialize();
  }

  initialize() {
    this.loadTable("");
  }

  loadTable(query:string){
    this.es.getAll(query).subscribe({
      next:data =>{
        this.employees = data;
        console.log(this.employees);
        this.dataSource = new MatTableDataSource<Employee>(this.employees);
        this.cdr.detectChanges();
        this.dataSource.paginator = this.paginator;
        this.data = this.dataSource.connect();
      }
    })
  }


  selectImage($event: Event) {

  }

  clearImage() {

  }

  fillForm(employee: any) {

  }
}
