import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ThesisListComponent } from './thesis-list/thesis-list.component';
import { ThesisFormComponent } from './thesis-form/thesis-form.component';
import { ThesisService } from './service/thesis.service';
 
@NgModule({
  declarations: [
    AppComponent,
    ThesisListComponent,
    ThesisFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ThesisService],
  bootstrap: [AppComponent]
})
export class AppModule { }
