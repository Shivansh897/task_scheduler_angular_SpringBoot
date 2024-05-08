import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { userGuard } from './service/user.guard';
import { AddnoteComponent } from './components/addnote/addnote.component';
import { SingleNoteComponent } from './components/single-note/single-note.component';

const routes: Routes = [
  {
    path: 'signup',
    component: SignupComponent,
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full'
  },
  {
    path: 'user-dashboard',
    component: UserDashboardComponent,
    pathMatch: 'full',
    canActivate:[userGuard]
  },
  {
    path: 'addNote',
    component: AddnoteComponent,
    pathMatch: 'full',
   
  },
  {
    path: 'note/:note_id',
    component: SingleNoteComponent,
    pathMatch: 'full',
    
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

  
}
