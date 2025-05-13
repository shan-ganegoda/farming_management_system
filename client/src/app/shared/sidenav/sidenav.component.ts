import { Component } from '@angular/core';
import {RouterLink, RouterLinkActive} from '@angular/router';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-sidenav',
  imports: [
    RouterLink,
    RouterLinkActive,
    DatePipe
  ],
  templateUrl: './sidenav.component.html',
  styleUrl: './sidenav.component.scss'
})
export class SidenavComponent {

  togglemenu1:boolean = false;
  today:any
  timenow:any

  constructor() {
    this.today = Date.now();
    this.updateTime();
    setInterval(() => this.updateTime(), 1000);
  }

  updateTime(){
    const now = new Date();
    this.timenow = now.toLocaleTimeString();
  }

}
