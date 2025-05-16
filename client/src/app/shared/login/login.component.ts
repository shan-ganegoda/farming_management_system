import {Component, OnInit} from '@angular/core';
import {FloatLabel} from 'primeng/floatlabel';
import {FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {InputText} from 'primeng/inputtext';
import {Password} from 'primeng/password';
import {StyleClass} from 'primeng/styleclass';
import {Button} from 'primeng/button';
import {Router, RouterLink} from '@angular/router';
import {AuthService} from '../../services/auth/auth.service';
import {StorageService} from '../../services/auth/storage.service';
import {ToastService} from '../../utils/toast/toast.service';

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
export class LoginComponent implements OnInit{

  authForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private as:AuthService,
    private ss:StorageService,
    private tst:ToastService,
  ) {
    this.authForm = this.fb.group({
      username: new FormControl("",  [Validators.required]),
      password: new FormControl("",  [Validators.required]),
    });
  }

  ngOnInit(): void {
        if(this.ss.isLoggedIn()){
          this.router.navigateByUrl('/main/home');
        }
    }

  submitForm() {
    if(this.authForm.valid){
      const {username, password} = this.authForm.value;this.as.login(username,password).subscribe({
        next:(data:any) => {
          this.ss.saveUser(data.user);
          //console.log(data.authUser.user);
          this.ss.saveUserAuthorities(data["authorities"]);

          this.router.navigateByUrl('/main/home');
          this.authForm.reset();
        },
        error: (error:any) => {
          console.log(error);
          this.tst.handleResult("failed","Invalid Email And Password!");
        }
      })
    }else{
      this.tst.handleResult("Failed","Invalid Email And Password!");
    }
  }
}
