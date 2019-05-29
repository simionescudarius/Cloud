import { Component, OnInit } from '@angular/core';
import { UserService } from "../../services/user.service";

@Component({
  selector: 'app-meetings-requests',
  templateUrl: './meetings-requests.component.html',
  styleUrls: ['./meetings-requests.component.css'],
  providers: [UserService]
})
export class MeetingsRequestsComponent implements OnInit {

  constructor(private _userService: UserService) { }

  ngOnInit() {
  }

}
