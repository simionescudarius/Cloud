import {Component, OnInit} from '@angular/core';
import {logger} from "codelyzer/util/logger";
import {Announcement} from "./Announcement";
import {isUndefined} from "util";
import {ActivatedRoute, Params} from "@angular/router";
import {AnnouncementService} from "app/services/announcement.service";
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-announcement',
  templateUrl: './announcement.component.html',
  styleUrls: ['./announcement.component.css'],
  providers: [AnnouncementService, AuthenticationService]
})
export class AnnouncementComponent implements OnInit {

  logged: boolean;
  noData: boolean = false;
  announcement: Announcement = new Announcement();

  constructor(private _announcementService: AnnouncementService, private _route: ActivatedRoute,
              private _authenticationService: AuthenticationService) {
  }

  ngOnInit() {
    this._route.params.subscribe(params => {
      this._announcementService.getAnnouncementById(+params['id']).subscribe(
        data => {
          if (data.status == 204) {
            this.noData = true;
          } else if (data.status == 200) {
            var temp = data.json();
            this.announcement.id = temp.id;
            this.announcement.name = temp.name;
            this.announcement.price = temp.price;
            this.announcement.viewNumber = temp.viewNumber;
            this.announcement.postDate = temp.postDate;
            this.announcement.expireDate = temp.expireDate;
            this.announcement.owner.id = temp.owner.id;
            this.announcement.owner.phoneNumber = temp.owner.phoneNumber;
            this.announcement.owner.firstName = temp.owner.firstName;
            this.announcement.owner.lastName = temp.owner.lastName;
            this.announcement.realEstate.area = temp.realEstate.area;
            this.announcement.realEstate.type.name = temp.realEstate.type.name;
            this.announcement.realEstate.roomNumber = temp.realEstate.roomNumber;
            this.announcement.realEstate.zone.name = temp.realEstate.zone.name;
            this.announcement.realEstate.zone.latitude = temp.realEstate.zone.latitude;
            this.announcement.realEstate.zone.longidute = temp.realEstate.zone.longidute;
          }
        },
        error => {
          alert("Eroare:" + error);
        }
      );
    });
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
  }
}
