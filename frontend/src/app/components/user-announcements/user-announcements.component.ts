import {Component, OnInit} from '@angular/core';
import {Announcement} from "../announcement/Announcement";
import {AnnouncementService} from "app/services/announcement.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-user-announcements',
  templateUrl: './user-announcements.component.html',
  styleUrls: ['./user-announcements.component.css'],
  providers: [AnnouncementService, AuthenticationService]
})
export class UserAnnouncementsComponent implements OnInit {

  userAnnouncements: Announcement[] = [];
  logged: boolean = false;

  constructor(private _announcementService: AnnouncementService, private _router: Router, private _authenticationService: AuthenticationService) {
  }

  redirect(id) {
    this._router.navigate(['/announcement', id]);
  }

  ngOnInit() {
    if (localStorage.getItem('currentUser') != null) {
      this._authenticationService.verify().subscribe(
        data => {
          if (data == "200") {
            this.logged = true;
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
    this._announcementService.getMyAnnouncements().subscribe(
      data => {
        let temp = data.json();
        for (let index = 0; index < temp.length; ++index) {
          var announcement = new Announcement();
          announcement.id = temp[index].id;
          announcement.name = temp[index].name;
          announcement.price = temp[index].price;
          announcement.viewNumber = temp[index].viewNumber;
          announcement.postDate = temp[index].postDate;
          announcement.expireDate = temp[index].expireDate;
          announcement.realEstate.area = temp[index].realEstate.area;
          announcement.realEstate.type.name = temp[index].realEstate.type.name;
          announcement.realEstate.roomNumber = temp[index].realEstate.roomNumber;
          announcement.realEstate.zone.name = temp[index].realEstate.zone.name;
          announcement.realEstate.zone.latitude = temp[index].realEstate.zone.latitude;
          announcement.realEstate.zone.longitude = temp[index].realEstate.zone.longitude;
          this.userAnnouncements.push(announcement);
        }
      },
      error => {
        alert("Error" + error);
      }
    )
  }


}
