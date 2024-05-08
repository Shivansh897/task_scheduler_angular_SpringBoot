import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { LoginService } from './login.service';
import {Observable} from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class NotesService {

  user_id!: string;

  

  constructor(private http: HttpClient,private login : LoginService) { }
  


  public getRecentNotes(){

    this.login.getCurrentUser().subscribe((user:any)=>{

       this.user_id = user.id


       return this.http.get(`${baseUrl}/notes/recent-notes/${this.user_id}`)
      

    }); 
 
      
  }
}
