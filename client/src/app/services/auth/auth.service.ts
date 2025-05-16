import { Injectable } from '@angular/core';
import {environment} from '../../environment';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {TokenService} from './token.service';
import {tap} from 'rxjs';

const API_URL = environment.apiUrl + '/auth/';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private router:Router,
    private http:HttpClient,
    private tokenService:TokenService,
    ) { }

  login(username:string,password:string){
    return this.http.post(API_URL + 'login',{username,password})
      .pipe(
        tap((response: any) =>{
          this.tokenService.setToken(response.AccessToken);
        })
      )
  }

  refreshToken(){
    return this.http.get(API_URL + 'refresh');
  }

  // logout(){
  //   this.http.get(API_URL + 'logout');
  // }

  // checkUser(email:string){
  //   return this.http.post(API_URL + 'check',email);
  // }

}
