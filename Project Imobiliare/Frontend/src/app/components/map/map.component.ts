import { Component, OnInit } from '@angular/core';
import { AnnouncementService } from "../../services/announcement.service";
import { Router } from "@angular/router";
import { Coordonate } from '../../models/Coordonate';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  mapLat: number = 47.17207;
  mapLng: number = 27.537982;
  announcementInfos: Coordonate[] = [];
  noise: boolean = false;
  chimic: boolean = false;
  waste: boolean = false;

  constructor(private _router: Router, private _announcementService: AnnouncementService) { }

  redirectToAnnouncement(id) {
    this._router.navigate(['/announcement', id]);
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
    this._announcementService.getAnnouncements("all", 0).subscribe(
      data => {
        if (data.body != null) {
          let temp = data.body;
          for (let index = 0; index < temp.length; ++index) {
            var announcementInfo = new Coordonate();
            announcementInfo.lat = temp[index].realEstate.zone.latitude;
            announcementInfo.lng = temp[index].realEstate.zone.longitude;
            announcementInfo.id = temp[index].id;
            announcementInfo.title = temp[index].name;
            announcementInfo.price = temp[index].price;
            announcementInfo.area = temp[index].realEstate.area;
            announcementInfo.zone = temp[index].realEstate.zone.name;
            announcementInfo.waste = temp[index].realEstate.zone.wastePollution;
            announcementInfo.chimic = temp[index].realEstate.zone.chimicPollution;
            announcementInfo.noise = temp[index].realEstate.zone.noisePollution;
            this.announcementInfos.push(announcementInfo);
          }
        }
      },
      error => {
        alert("Error" + error);
      }
    )
  }

}
