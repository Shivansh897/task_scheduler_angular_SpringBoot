import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  //current user: which is logged in

  public getCurrentUser(){
    return this.http.get(`${baseUrl}/current_user`)
      
  }

  // generate token

  public generateToke(loginData:any){
    return this.http.post(`${baseUrl}/generate_token`, loginData)
  }

  //login user: set token in localStorage

  public loginUser(token:any){
    localStorage.setItem('token',token);
    return true;
  }

  //islogin : user is logedin or not
public isLoggedin(){
  let tokenstr = localStorage.getItem('token');
  if(tokenstr == undefined || tokenstr == '' || tokenstr==null){

    return false;
  }
  else{
    return true;
  }
  }
     // logout : remove token from local storage

     public logout(){
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      
      return true;
     }

     //get token
     public getToken()
{
  return localStorage.getItem('token');
}

// set userDetails
public SetUser(user:any){
  localStorage.setItem('user',JSON.stringify(user));
}

//get user
public getUser(){

  let userStr = localStorage.getItem('user');
  if(userStr != null){
    return JSON.parse(userStr);
  } else{
    this.logout();
    return null;
  }
}

//get userRole
public getUserRole(){
let user = this.getUser();

return user.authorities[0].authority
}
}
