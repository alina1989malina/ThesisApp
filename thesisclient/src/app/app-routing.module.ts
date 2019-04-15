import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ThesisListComponent } from './thesis-list/thesis-list.component';
import { ThesisFormComponent } from './thesis-form/thesis-form.component';
 
const routes: Routes = [
  { path: 'theses', component: ThesisListComponent },
  { path: 'addThesis', component: ThesisFormComponent }
];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


