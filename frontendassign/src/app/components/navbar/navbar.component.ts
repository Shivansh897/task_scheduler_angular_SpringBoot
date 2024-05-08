import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  public isLoggedin = false;
  public user = null;
  constructor(public login:LoginService, private router: Router){}
  ngOnInit():void{
    this.isLoggedin=this.login.isLoggedin();
    this.user=this.login.getUser();
    console.log(this.user);
    
  }

  public logout(){
    this.login.logout();

         
    
    // window.location.reload(); 
    //  this.router.navigate(['/']);
    this.router.navigate(['/']).then(() => {
      window.location.reload();
    });
  }
}
