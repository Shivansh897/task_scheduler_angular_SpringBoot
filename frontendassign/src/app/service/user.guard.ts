import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable()
export class userGuard implements CanActivate {
  constructor(private login: LoginService, private router : Router){}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    
    if(this.login.isLoggedin() && this.login.getUserRole()=='NORMAL'){
       
        return true;
    }

    this.router.navigate(['login']);

    return false;
  }
  
 
};

