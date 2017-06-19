import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Announcement} from "../../components/announcement/Announcement";
import {AuthenticationService} from "../../services/authentication.service";
import {AnnouncementService} from "../../services/announcement.service";
import {Coordonate} from "../../components/map/coordonate";

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css'],
  providers: [AuthenticationService, AnnouncementService]
})
export class SearchResultComponent implements OnInit {
  logged: boolean;
  announcements: Announcement[] = [];
  announcementInfos: any [] = [];
  mapLat: number = 47.17207;
  mapLng: number = 27.537982;
  noise: boolean = false;
  chimic: boolean = false;
  waste: boolean = false;

  constructor(private _authenticationService: AuthenticationService, private _announcementService: AnnouncementService,
              private _router: Router, private _route: ActivatedRoute) {
  }

  noiseP(){
    this.noise = !this.noise;
  }

  chimicP(){
    this.chimic = !this.chimic;
  }

  wasteP(){
    this.waste = !this.waste;
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
    var type;
    var roomNumber;
    this._route.params.subscribe(params => {
      type = params['type'];
      roomNumber = +params['roomNumber'];
      this.announcements = [];
      this._announcementService.getAnnouncements(type, roomNumber).subscribe(
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
            this.announcements.push(announcement);
          }
        },
        error => {
          alert("Error" + error);
        }
      )
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
  }
}
