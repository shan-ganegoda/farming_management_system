import { Component } from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {SidenavComponent} from '../sidenav/sidenav.component';

@Component({
  selector: 'app-mainwindow',
  imports: [
    RouterOutlet,
    SidenavComponent
  ],
  templateUrl: './mainwindow.component.html',
  styleUrl: './mainwindow.component.scss'
})
export class MainwindowComponent {

}
