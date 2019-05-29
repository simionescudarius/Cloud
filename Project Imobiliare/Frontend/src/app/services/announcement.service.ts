import { Announcement } from './../models/Announcement';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AnnouncementService {

  private endpoint = 'https://complete-kite-236211.appspot.com/v1/announcements/';

  private headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(private http: HttpClient) { }

  getAnnouncementById(id) {
    return this.http.get<Announcement>(this.endpoint + 'id=' + id,
      {
        headers: {
          'Content-Type': 'application/json'
        },
        observe: 'response'
      });
  }

  getAnnouncements(type, roomNumber) {
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');

    if (type == "all" && roomNumber == 0) {
      return this.http.get<Announcement[]>(this.endpoint,
        {
          headers: {
            'Content-Type': 'application/json'
          },
          observe: 'response'
        });
    } else if (type == "Apartment" && roomNumber == 1) {
      return this.http.get<Announcement[]>(this.endpoint + 'type=' + type + '/roomNumber=' + roomNumber,
        {
          headers: {
            'Content-Type': 'application/json'
          },
          observe: 'response'
        });
    } else if (type == "Apartment" && roomNumber == 2) {
      return this.http.get<Announcement[]>(this.endpoint + 'type=' + type + '/roomNumber=' + roomNumber,
        {
          headers: {
            'Content-Type': 'application/json'
          },
          observe: 'response'
        });
    } else if (type == "Apartment" && roomNumber == 3) {
      return this.http.get<Announcement[]>(this.endpoint + 'type=' + type + '/roomNumber=' + roomNumber,
        {
          headers: {
            'Content-Type': 'application/json'
          },
          observe: 'response'
        });
    } else if (type == "Apartment" && roomNumber == 4) {
      return this.http.get<Announcement[]>(this.endpoint + 'type=' + type + '/roomNumber=' + roomNumber,
        {
          headers: {
            'Content-Type': 'application/json'
          },
          observe: 'response'
        });
    } else if (type == "Studio") {
      return this.http.get<Announcement[]>(this.endpoint + 'type=' + type,
        {
          headers: {
            'Content-Type': 'application/json'
          },
          observe: 'response'
        });
    } else if (type == "Field") {
      return this.http.get<Announcement[]>(this.endpoint + 'type=' + type,
        {
          headers: {
            'Content-Type': 'application/json'
          },
          observe: 'response'
        });
    }
  }

  getMyAnnouncements() {
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('token', localStorage.getItem('currentUser'));
    return this.http.get<Announcement[]>(this.endpoint + 'myAnnouncements',
      {
        headers: {
          'Content-Type': 'application/json',
          token: localStorage.getItem('token')
        },
        observe: 'response'
      });
  }

  getMostPopular() {
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get<Announcement[]>(this.endpoint + 'popular',
      {
        headers: {
          'Content-Type': 'application/json'
        },
        observe: 'response'
      });
  }

  getFavouriteAnnouncements() {
    return this.http.get<Announcement[]>('https://complete-kite-236211.appspot.com/v1/favourites/',
      {
        headers: {
          'Content-Type': 'application/json',
          token: localStorage.getItem('token')
        },
        observe: 'response'
      });
  }

  registerAnnouncement(description, name, postDate, price, area, roomNumber, type, zoneName, bars, chimic, entertainment,
    greatView, hardReachable, lat, lng, noisePollution, parking, postalCode, publicTransport, shops, wastePollution) {
    var json = JSON.stringify({
      description: description,
      expireDate: 149897984401,
      name: name,
      postDate: postDate,
      price: price,
      realEstate: {
        area: area,
        roomNumber: roomNumber,
        type: {
          name: type
        },
        zone: {
          name: zoneName,
          barsNearby: bars,
          chimicPollution: chimic,
          entertainmentNearby: entertainment,
          greatView: greatView,
          hardReachable: hardReachable,
          latitude: lat,
          longitude: lng,
          noisePollution: noisePollution,
          parking: parking,
          postalCode: postalCode,
          publicTransportNearby: publicTransport,
          shopsNearby: shops,
          wastePollution: wastePollution
        }
      }
    });
    return this.http.post(this.endpoint + 'post', json,
      {
        headers: {
          'Content-Type': 'application/json',
          token: localStorage.getItem('token')
        },
        observe: 'response'
      });
  }
}
