import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Location} from '@angular/common'
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-logged-navbar',
  templateUrl: './logged-navbar.component.html',
  styleUrls: ['./logged-navbar.component.css', '../../css/index.css'],
  providers: [AuthenticationService]
})
export class LoggedNavbarComponent implements OnInit {

  currentEmail: string = localStorage.getItem('currentEmail');
  userOptions: string[] = ['My Profile', 'Log Out'];

  constructor(private _router: Router, private _authenticationService: AuthenticationService, private _location: Location) {
  }

  redirectTo(option) {
    if(option == "home"){
      this._router.navigate(['/home']);
    }
    if (option == "My Profile") {
      this._router.navigate(['/myProfile'])
    } else if (option == "Log Out") {
      this._authenticationService.logout();
      if(window.location.pathname != '/home'){
        this._router.navigate(['/home']);
      }else window.location.reload();
    } else if (option == "announcementForm"){
      this._router.navigate(['/announcementForm'])
    }
  }

  ngOnInit() {
  }

}
