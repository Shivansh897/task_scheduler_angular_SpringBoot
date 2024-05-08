import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import baseUrl from 'src/app/service/helper';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent {

   user_id!: number
  notes: any[] = [];

  constructor( ) { 
    
   }

  

 

  // fetchReviews(): void {
  //   // const apiUrl = `${baseUrl}/reviews/${this.product_id}`;

  //   this.http.get(`${baseUrl}/notes/recent-notes/${this.product_id}`).subscribe(
  //     (data: any) => {
  //       this.reviews = data;
  //     },
  //     (error: any) => {
  //       console.error(error);
  //     }
  //   );
  // }
  // top10notes():void{

  //   const user = this.login.getCurrentUser();

    
  //   console.log("user details are" + user);
    


  // }

}
