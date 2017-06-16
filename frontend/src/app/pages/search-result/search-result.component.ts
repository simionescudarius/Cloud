import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Announcement} from "../../components/announcement/Announcement";
import {AuthenticationService} from "../../services/authentication.service";
import {AnnouncementService} from "../../services/announcement.service";

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css'],
  providers: [AuthenticationService, AnnouncementService]
})
export class SearchResultComponent implements OnInit {
  logged: boolean;
  announcements: Announcement[] = [];

  constructor(private _authenticationService: AuthenticationService, private _announcementService: AnnouncementService, private _router: Router) {
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
    this._announcementService.getAnnouncements().subscribe(
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
          announcement.realEstate.zone.longidute = temp[index].realEstate.zone.longidute;
          this.announcements.push(announcement);
        }
        console.log(this.announcements[0].realEstate.area);
      },
      error => {
        alert("Error" + error);
      }
    )
  }
}
