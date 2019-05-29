import { Component, OnInit } from '@angular/core';
import { User } from "../../models/User";
import { UserService } from "../../services/user.service";
import { AuthenticationService } from "../../services/authentication.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
  providers: [UserService, AuthenticationService]
})
export class UserProfileComponent implements OnInit {

  user: User = {
    firstName: "",
    lastName: "",
    phoneNumber: "",
    email: ""
  }

  logged: boolean;

  constructor(private _userService: UserService, private _authenticationService: AuthenticationService) { }

  getUser() {
    this._userService.getUser().subscribe(
      data => {
        this.user.firstName = data.body.firstName;
        this.user.lastName = data.body.lastName;
        this.user.phoneNumber = data.body.phoneNumber;
        this.user.email = localStorage.getItem('email');
      },
      error => {
        alert("Eroare" + error);
      }
    )
  }

  ngOnInit() {
    if (localStorage.getItem('token') != null) {
      this._authenticationService.verify().subscribe(
        result => {
          if (result.status === 200) {
            this.logged = true;
            this.getUser();
          } else {
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
