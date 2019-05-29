import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-logged-navbar',
  templateUrl: './logged-navbar.component.html',
  styleUrls: ['./logged-navbar.component.css']
})
export class LoggedNavbarComponent implements OnInit {

  email: string = localStorage.getItem('email');
  userOptions: string[] = ['My Profile', 'Log Out'];

  constructor(private router: Router, private authenticationService: AuthenticationService, private location: Location) { }

  redirectTo(option) {
    if (option == "home") {
      this.router.navigate(['/home']);
    }
    if (option == "My Profile") {
      this.router.navigate(['/myProfile'])
    } else if (option == "Log Out") {
      this.authenticationService.logout();
      if (window.location.pathname != '/home') {
        this.router.navigate(['/home']);
      } else window.location.reload();
    } else if (option == "announcementForm") {
      this.router.navigate(['/announcementForm'])
    }
  }

  ngOnInit() {
  }

}
