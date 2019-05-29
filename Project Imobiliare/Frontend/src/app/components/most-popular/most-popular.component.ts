import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { AnnouncementService } from "../../services/announcement.service";
import { Announcement } from "../../models/Announcement";

@Component({
  selector: 'app-most-popular',
  templateUrl: './most-popular.component.html',
  styleUrls: ['./most-popular.component.css']
})
export class MostPopularComponent implements OnInit {

  mostPopular: Announcement[] = [];

  constructor(private _announcementService: AnnouncementService, private _router: Router) { }

  redirect(id) {
    this._router.navigate(['/announcement', id]);
  }

  ngOnInit() {
    this._announcementService.getMostPopular().subscribe(
      result => {
        if (result.body != null) {
          let temp = result.body;
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
            this.mostPopular.push(announcement);
          }
        }
      },
      error => {
        alert("Error" + error);
      }
    )
  }

}
