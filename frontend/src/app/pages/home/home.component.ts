import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-home',
  templateUrl: 'home.component.html',
  styleUrls: ['./home.component.css'],
  providers:[AuthenticationService]
})
export class HomeComponent implements OnInit{
  logged: boolean;

  constructor(private _authenticationService: AuthenticationService){}

  ngOnInit() {
    if (localStorage.getItem('currentUser') != null) {
      this._authenticationService.verify().subscribe(
        data =>{
          if (data == "200"){
            this.logged = true;
          }else{
            this.logged = false;
          }
        },
        error => {
         alert("Eroare:" + error);
        }
      )
    } else {
      this.logged = false;
    }
  }
}
