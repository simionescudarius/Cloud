import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-header-component',
  templateUrl: './header-component.component.html',
  styleUrls: ['./header-component.component.css']
})
export class HeaderComponent implements OnInit {
  searchOptions = ['Studio', 'Apartment 1 room', 'Apartment 2 rooms', 'Apartment 3 rooms', 'Apartment 4 rooms', 'Field']
  selectedOption = 'All';

  constructor(private _router:Router) { }

  test(choice){
    this.selectedOption = choice;
  }

  searchResults(){
    this._router.navigate(['/searchResult']);
  }

  ngOnInit() {
  }

}
