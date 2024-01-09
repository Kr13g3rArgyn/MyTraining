import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PeopleListComponent } from './people-list/people-list.component';
import { HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { CreatePeopleComponent } from './create-people/create-people.component'
import {  FormsModule } from "@angular/forms";
import { UpdatePeopleComponent } from './update-people/update-people.component';
import { AuthContentComponent } from './auth-content/auth-content.component';
import { WelcomeContentComponent } from './welcome-content/welcome-content.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { ContentComponent } from './content/content.component';
import { ButtonsComponent } from './buttons/buttons.component';
@NgModule({
  declarations: [
    AuthContentComponent,
    AppComponent,
    PeopleListComponent,
    CreatePeopleComponent,
    UpdatePeopleComponent,
    WelcomeContentComponent,
    LoginFormComponent,
    ContentComponent,
    ButtonsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
