import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import baseUrl from 'src/app/service/helper';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-addnote',
  templateUrl: './addnote.component.html',
  styleUrls: ['./addnote.component.css']
})
export class AddnoteComponent {


  constructor(private http: HttpClient,private login:LoginService,private router: Router){}

  user_id!:number


  public note={
    title:'',
    content:''
   
   }

   formSubmit(){

    
    this.login.getCurrentUser().subscribe((user:any)=>{

      this.user_id = user.id

      this.http.post(`${baseUrl}/notes/${this.user_id}`,this.note).subscribe((data)=>{
        console.log(data);
        
      },
      (error)=>{
        console.log(error);
        

      })

      

   })
    // this.http.post.(`${baseUrl}/notes/${user_id}`,this.note)
    this.router.navigate(["user-dashboard"])

   }

}
