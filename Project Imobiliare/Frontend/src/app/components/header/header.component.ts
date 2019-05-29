import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  searchOptions = ['All', 'Studio', 'Apartment 1 room', 'Apartment 2 rooms', 'Apartment 3 rooms', 'Apartment 4 rooms', 'Field']
  selectedOption = 'All';

  constructor(private _router: Router) { }

  test(choice) {
    this.selectedOption = choice;
  }

  searchResults() {
    if (this.selectedOption == "All") {
      this._router.navigate(['/searchResult', "all", 0]);
    } else if (this.selectedOption == "Apartment 1 room") {
      this._router.navigate(['/searchResult', 'Apartment', 1]);
    } else if (this.selectedOption == "Apartment 2 rooms") {
      this._router.navigate(['/searchResult', 'Apartment', 2]);
    } else if (this.selectedOption == "Apartment 3 rooms") {
      this._router.navigate(['/searchResult', 'Apartment', 3]);
    } else if (this.selectedOption == "Apartment 4 rooms") {
      this._router.navigate(['/searchResult', 'Apartment', 4]);
    } else if (this.selectedOption == "Field") {
      this._router.navigate(['/searchResult', 'Field', 0]);
    } else if (this.selectedOption == "Studio") {
      this._router.navigate(['/searchResult', 'Studio', 0]);
    }

  }

  ngOnInit() {
  }

}
