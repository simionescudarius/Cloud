import {Component, OnInit} from '@angular/core';
import {User} from "./user";
import {UserService} from "../../services/user.service";
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers: [UserService, AuthenticationService]
})
export class UserProfileComponent implements OnInit {
  user : User = {
    firstName: "",
    lastName: "",
    phoneNumber: "",
    email: ""
  }

  logged: boolean;

  constructor(private _userService: UserService, private _authenticationService: AuthenticationService) {
  }

  getUser() {
    this._userService.getUser().subscribe(
      data => {
        this.user.firstName = data.json().firstName;
        this.user.lastName = data.json().lastName;
        this.user.phoneNumber = data.json().phoneNumber;
        this.user.email = localStorage.getItem('currentEmail');
      },
      error => {
        alert("Eroare" + error);
      }
    )
  }

  ngOnInit() {
    if (localStorage.getItem('currentUser') != null) {
      this._authenticationService.verify().subscribe(
        data =>{
          if (data == "200"){
            this.logged = true;
            this.getUser();
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
