import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { AnnouncementService } from "../../services/announcement.service";
import { AuthenticationService } from "../../services/authentication.service";
import { BsModalComponent } from 'ng2-bs3-modal';
import { Router } from '@angular/router';

@Component({
  selector: 'app-announcement-form',
  templateUrl: './announcement-form.component.html',
  styleUrls: ['./announcement-form.component.css']
})
export class AnnouncementFormComponent implements OnInit {

  announcementForm: FormGroup;
  typeOptions = ['Studio', 'Apartment', 'Field'];
  selectedOption = 'Type';
  chimicPollution: number = 0;
  wastePollution: number = 0;
  noisePollution: number = 0;
  title: string = 'My first AGM project';
  lat: number = 47.17207;
  lng: number = 27.537982;
  markerLat: number;
  markerLng: number;
  bars: boolean = false;
  entertainment: boolean = false;
  greatVeiw: boolean = false;
  hardReachable: boolean = false;
  parking: boolean = false;
  publicTransport: boolean = false;
  shops: boolean = false;
  logged: boolean = true;
  date: Date = new Date();

  @ViewChild('announcementCreated')
  announcementCreated: BsModalComponent;

  constructor(private _formBuilder: FormBuilder,
    private _announcementService: AnnouncementService,
    private _authenticationService: AuthenticationService,
    private _router: Router
  ) {
  }

  closePopup() {
    this.announcementCreated.close();
    this._router.navigate(['/home'])
  }

  createAnnouncement(value) {
    var time = this.date.getTime();
    this._announcementService.registerAnnouncement(value.description, value.name, time, value.price, value.area, value.roomNumber,
      this.selectedOption, value.zoneName, this.bars, this.chimicPollution, this.entertainment, this.greatVeiw, this.hardReachable,
      this.markerLat, this.markerLng, this.noisePollution, this.parking, value.postalCode, this.publicTransport, this.shops, this.wastePollution
    ).subscribe(
      data => {
        this.announcementCreated.open();
      },
      error => {
        alert("Error " + error);
        console.log(error);
      }
    )
  }

  haveBars() {
    this.bars = !this.bars;
  }

  haveshops() {
    this.shops = !this.shops;
  }

  haveEntertainment() {
    this.entertainment = !this.entertainment;
  }

  haveparking() {
    this.parking = !this.parking;
  }

  havepublicTransport() {
    this.publicTransport = !this.publicTransport;
  }

  haveGreatVeiw() {
    this.greatVeiw = !this.greatVeiw;
  }

  haveHardReachable() {
    this.hardReachable = !this.hardReachable;
  }

  mapClicked($event) {
    this.markerLat = $event.coords.lat;
    this.markerLng = $event.coords.lng;
  }

  noisePollutionM() {
    this.noisePollution--;
  }

  noisePollutionP() {
    this.noisePollution++;
  }

  chimicPollutionM() {
    this.chimicPollution--;
  }

  chimicPollutionP() {
    this.chimicPollution++;
  }

  wastePollutionM() {
    this.wastePollution--;
  }

  wastePollutionP() {
    this.wastePollution++;
  }

  selectOption(choice) {
    this.selectedOption = choice;
  }


  ngOnInit() {
    if (localStorage.getItem('token') != null) {
      this._authenticationService.verify().subscribe(
        result => {
          if (result.status === 200) {
            this.logged = true;
          } else {
            this.logged = false;
          }
        },
        error => {
          alert("Eroare:" + error);
          console.log(error);
        }
      )
    } else {
      this.logged = false;
    }
    this.announcementForm = this._formBuilder.group({
      'name': ['', Validators.compose([Validators.required, Validators.pattern("[ a-zA-Z0-9]+")])],
      'price': ['', Validators.compose([Validators.required, Validators.pattern("[0-9]+")])],
      'area': ['', Validators.compose([Validators.required, Validators.pattern("[1-9][0-9]{1,3}")])],
      'roomNumber': ['', Validators.compose([Validators.required, Validators.pattern("[1-9]?[0-9]{1,3}")])],
      'description': ['', Validators.compose([Validators.required, Validators.minLength(6)])],
      'postalCode': ['', Validators.compose([Validators.required, Validators.pattern("[0-9]{6}")])],
      'zoneName': ['', Validators.compose([Validators.required, Validators.pattern("[ a-zA-Z0-9]+")])],
    });
  }

}
