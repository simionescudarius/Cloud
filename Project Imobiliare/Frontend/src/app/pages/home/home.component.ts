import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  logged: boolean;

  constructor(private authenticationService: AuthenticationService) { }

  ngOnInit() {
    if (localStorage.getItem('token') != null) {
      this.authenticationService.verify().subscribe(
        response => {
          if (response.status === 200) {
            this.logged = true;
          } else {
            this.logged = false;
          }
        },
        error => {
          alert('Error!');
          console.log(error);
        }
      )
      this.logged = true;
    } else {
      this.logged = false;
    }
  }

}
