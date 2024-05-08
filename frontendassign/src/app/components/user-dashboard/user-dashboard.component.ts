import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { NotesService } from 'src/app/service/notes.service';

import baseUrl from 'src/app/service/helper';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent {

  public allNotes:any[]=[]
  user_id!: string;
  note_id!:number;
  constructor(private http: HttpClient,private login: LoginService, private note : NotesService,private router : Router){}
  

  ngOnInit() {
    this.getTop10Notes()
  }

  

    getTop10Notes(){

      this.login.getCurrentUser().subscribe((user:any)=>{

        this.user_id = user.id
 
 
         this.http.get(`${baseUrl}/notes/recent-notes/${this.user_id}`).subscribe((data:any)=>{
          console.log(data);
          this.allNotes = data
          
         })

     })

    }

    deleteNotes(note_id:number){

      this.http.delete<any>(`${baseUrl}/notes/${note_id}`).subscribe((data)=>{
        
        this.router.navigate([this.router.url])
        console.log("note deleted", note_id);
       
       
        
      },
      (error)=>{
        console.log(error);
      
      }
      )
      

     

    }

    fullview(note_id:number){
      this.router.navigate(['/note',note_id])
    }
    



}
