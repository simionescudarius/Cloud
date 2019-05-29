import { Component, OnInit } from '@angular/core';
import { UserService } from "../../services/user.service";

@Component({
  selector: 'app-meetings-progress',
  templateUrl: './meetings-progress.component.html',
  styleUrls: ['./meetings-progress.component.css'],
  providers: [UserService]
})
export class MeetingsProgressComponent implements OnInit {

  constructor(private _userService: UserService) { }

  ngOnInit() {
  }

}
