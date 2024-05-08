import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  constructor(private userService:UserService, private snack: MatSnackBar){}
  public user={
   username:'',
   password:'',
   cPassword:'',
   firstName:'',
   lastName:'',
   email:'',
  }
 
 
 
   formSubmit(){
     if (this.user.password !== this.user.cPassword) {
       // Passwords don't match, show an error message or perform any necessary action
       this.snack.open('Both doesnt matched!!','',{
        duration:3000
      });
       return; // Stop form submission
     }
     // alert("form submitted")
     console.log(this.user);
     if(this.user.email==`` || this.user.email==null){
       this.snack.open('email is required!!','',{
         duration:3000
       });
       return;
     };
     if(this.user.username==`` || this.user.username==null){
       this.snack.open('Username is required!!','',{
         duration:3000
       });
       return;
     };
     
     
   
 
   //addUser: if username and email are unique!!
   this.userService.getAllUsers().subscribe(
     (users: any[]) => {
       const emailExists = users.some((user) => user.email === this.user.email);
       const usernameExists = users.some((user) => user.username === this.user.username);
       if (emailExists) {
         this.snack.open('Email already exists!! Try another', '', { duration: 3000 });
       }else if (usernameExists) {
         this.snack.open('Username already exists!! Try another', '', { duration: 3000 });
       }
        else {
         this.userService.addUser(this.user).subscribe(
           (data:any) => {
             console.log(data);
             Swal.fire('Success', data.username+'is registered successfully', 'success');
           },
           (error:any) => {
             console.log(error);
             this.snack.open('An error occurred. Please try again later.', '', { duration: 3000 });
           }
         );
       }
     },
     (error:any) => {
       console.log(error);
       this.snack.open('An error occurred. Please try again later.', '', { duration: 3000 });
     }
   );
 }
 
 
}
