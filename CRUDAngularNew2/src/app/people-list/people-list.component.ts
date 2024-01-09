import { Component } from '@angular/core';
import {People} from "../people";
import {PeopleService} from "../people.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-people-list',
  templateUrl: './people-list.component.html',
  styleUrls: ['./people-list.component.css']
})
export class PeopleListComponent {
  //@ts-ignore
  people: People[];
  constructor(private peopleService: PeopleService,
              private router: Router) {
  }
  private getPeople(){
    this.peopleService.getEmployeeList().subscribe(data =>{
      this.people = data;
    });
  }
  ngOnInit(): void{
    this.getPeople();
  }
  updatePerson(id: number) {
    this.router.navigate(['update',id])
  }
  deletePerson(id: number) {
    this.peopleService.deleteEmployee(id).subscribe(data =>
    {
      console.log(data);
      this.getPeople();
    })
  }
}
