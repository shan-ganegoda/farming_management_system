import { Component } from '@angular/core';
import {FloatLabel} from 'primeng/floatlabel';
import {FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {InputText} from 'primeng/inputtext';
import {Password} from 'primeng/password';
import {StyleClass} from 'primeng/styleclass';
import {Button} from 'primeng/button';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [
    FloatLabel,
    FormsModule,
    InputText,
    Password,
    StyleClass,
    Button,
    RouterLink,
    ReactiveFormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  authForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.authForm = this.fb.group({
      username: new FormControl("",  [Validators.required]),
      password: new FormControl("",  [Validators.required]),
    });
  }

  submitForm() {
    // const {username , password} = this.authForm.getRawValue();
    console.log(this.authForm.value);
  }
}
