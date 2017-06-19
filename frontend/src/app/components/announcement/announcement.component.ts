import {Component, OnInit} from '@angular/core';
import {logger} from "codelyzer/util/logger";
import {Announcement} from "./Announcement";
import {isUndefined} from "util";
import {ActivatedRoute, Params} from "@angular/router";
import {AnnouncementService} from "app/services/announcement.service";
import {AuthenticationService} from "../../services/authentication.service";
import {Coordonate} from "../map/coordonate";

@Component({
  selector: 'app-announcement',
  templateUrl: './announcement.component.html',
  styleUrls: ['./announcement.component.css'],
  providers: [AnnouncementService, AuthenticationService]
})
export class AnnouncementComponent implements OnInit {

  logged: boolean;
  noData: boolean = false;
  noise: boolean = false;
  chimic: boolean = false;
  waste: boolean = false;
  announcement: Announcement = new Announcement();
  announcementInfos: any [] = [];
  mapLat: number = 0;
  mapLng: number = 0;
  noiseMeter: number = 0;
  wasteMeter: number = 0;
  chimicMeter: number = 0;

  constructor(private _announcementService: AnnouncementService, private _route: ActivatedRoute,
              private _authenticationService: AuthenticationService) {
  }

  noiseP() {
    this.noise = !this.noise;
  }

  chimicP() {
    this.chimic = !this.chimic;
  }

  wasteP() {
    this.waste = !this.waste;
  }

  ngOnInit() {
    this._route.params.subscribe(params => {
      this._announcementService.getAnnouncementById(+params['id']).subscribe(
        data => {
          if (data.status == 204) {
            this.noData = true;
          } else if (data.status == 200) {
            var temp = data.json();
            console.log(data.json());
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
            this.mapLat = temp.realEstate.zone.latitude;
            this.mapLng = temp.realEstate.zone.longitude;
            this.chimicMeter = temp.realEstate.zone.chimicPollution * 10;
            this.noiseMeter = temp.realEstate.zone.noisePollution * 10;
            this.wasteMeter = temp.realEstate.zone.wastePollution * 10;
          }
        },
        error => {
          alert("Eroare:" + error);
        }
      );
    });
    this._announcementService.getAnnouncements("all", 0).subscribe(
      data => {
        console.log(data.json());
        let temp = data.json();
        for (let index = 0; index < temp.length; ++index) {
          var announcementInfo = new Coordonate();
          announcementInfo.lat = temp[index].realEstate.zone.latitude;
          announcementInfo.lng = temp[index].realEstate.zone.longitude;
          announcementInfo.waste = temp[index].realEstate.zone.wastePollution;
          announcementInfo.chimic = temp[index].realEstate.zone.chimicPollution;
          announcementInfo.noise = temp[index].realEstate.zone.noisePollution;
          this.announcementInfos.push(announcementInfo);
        }
      },
      error => {
        alert("Error" + error);
      }
    )
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
