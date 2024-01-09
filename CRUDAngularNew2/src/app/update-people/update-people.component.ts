import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PeopleService} from "../people.service";
import {People} from "../people";

@Component({
  selector: 'app-update-people',
  templateUrl: './update-people.component.html',
  styleUrls: ['./update-people.component.css']
})
export class UpdatePeopleComponent {
  //@ts-ignore
  id: number;
  title= "Edit dude >:)";
  person: People = new People();
  constructor(private route: ActivatedRoute,
              private peopleService: PeopleService,
              private router: Router) {
  }
  ngOnInit(){
    this.id = this.route.snapshot.params['id'];
    this.peopleService.getEmployeeById(this.id).subscribe(data => {
      this.person = data;
    },
      error => console.log(error))
  }
   goToPeopleList(){
    this.router.navigate(['/peoples']);
  }

  onSubmit() {
    this.ngOnInit();
  this.peopleService.updateEmployee(this.id,this.person).subscribe(data => {
    this.goToPeopleList();
  },
    error => console.log(error))
  }
}
