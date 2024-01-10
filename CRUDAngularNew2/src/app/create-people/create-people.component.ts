import { Component } from '@angular/core';
import {People} from "../people";
import {PeopleService} from "../people.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-people',
  templateUrl: './create-people.component.html',
  styleUrls: ['./create-people.component.css']
})
export class CreatePeopleComponent {
  person: People = new People();
  title = "Create Dude :3";
  ngOnInit(){

  }
  constructor(private peopleService: PeopleService, private router: Router) {

  }
  savePerson(){
    this.peopleService.createPerson(this.person).subscribe(data =>{
        console.log(data);
    },
      error => console.log(error));
  }
  goToPeopleList(){
    this.router.navigate(['/peoples']);
  }
  onSubmit() {
    this.savePerson();
    this.goToPeopleList();
  }
}
