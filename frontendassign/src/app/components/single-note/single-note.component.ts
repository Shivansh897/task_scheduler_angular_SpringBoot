import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import baseUrl from 'src/app/service/helper';
import { LoginService } from 'src/app/service/login.service';
import { NotesService } from 'src/app/service/notes.service';

@Component({
  selector: 'app-single-note',
  templateUrl: './single-note.component.html',
  styleUrls: ['./single-note.component.css']
})
export class SingleNoteComponent {
   notes:any={}
   note_id!:number
  constructor(private http: HttpClient,private login: LoginService, private note : NotesService,private router : Router,private route: ActivatedRoute){}
    
  ngOnInit():void {
    this.route.params.subscribe(params => {
      this.note_id = params['note_id'];
      this.getNotes();
    });
  }

  getNotes(){



      this.http.get(`${baseUrl}/notes/${this.note_id}`).subscribe((data:any)=>{
       this.notes = data
       console.log(this.notes);
       
        
      })

  }

  deleteNotes(note_id:number){

    this.http.delete<any>(`${baseUrl}/notes/${note_id}`).subscribe((data)=>{
      
      
      console.log("note deleted", note_id);

      
     
     
      
    },
    (error)=>{
      console.log(error);
    
    }
    )

    this.router.navigate(['user-dashboard'])

    
    

   

  }


}
