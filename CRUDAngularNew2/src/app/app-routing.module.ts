import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {PeopleListComponent} from "./people-list/people-list.component";
import {CreatePeopleComponent} from "./create-people/create-people.component";
import {UpdatePeopleComponent} from "./update-people/update-people.component";
import {WelcomeContentComponent} from "./welcome-content/welcome-content.component";
import {LoginFormComponent} from "./login-form/login-form.component";
const routes: Routes = [
  {path: 'login', component: LoginFormComponent},
  {path: 'welcome',component: WelcomeContentComponent},
  {path: '', component:PeopleListComponent},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'peoples', component: PeopleListComponent},
  {path: 'create', component: CreatePeopleComponent},
  {path: 'update/:id', component: UpdatePeopleComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
