import {Injectable} from '@angular/core';
import {Http, Headers, Response} from "@angular/http";

@Injectable()
export class AnnouncementService {

  constructor(private http: Http) {
  }

  getAnnouncementById(id) {
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get('http://localhost:9999/v1/announcements/id=' + id, {headers: headers})
      .map((response: Response) => response);
  }

  getAnnouncements(type, roomNumber) {
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');

    if (type == "all" && roomNumber == 0) {
      return this.http.get('http://localhost:9999/v1/announcements', {headers: headers})
        .map((response: Response) => response);
    }else if (type == "Apartment" && roomNumber == 1) {
      return this.http.get('http://localhost:9999/v1/announcements/type='+type+'/roomNumber='+roomNumber, {headers: headers})
        .map((response: Response) => response);
    }else if (type == "Apartment" && roomNumber == 2) {
      return this.http.get('http://localhost:9999/v1/announcements/type='+type+'/roomNumber='+roomNumber, {headers: headers})
        .map((response: Response) => response);
    }else if (type == "Apartment" && roomNumber == 3) {
      return this.http.get('http://localhost:9999/v1/announcements/type='+type+'/roomNumber='+roomNumber, {headers: headers})
        .map((response: Response) => response);
    }else if (type == "Apartment" && roomNumber == 4) {
      return this.http.get('http://localhost:9999/v1/announcements/type='+type+'/roomNumber='+roomNumber, {headers: headers})
        .map((response: Response) => response);
    }else if (type == "Studio") {
      return this.http.get('http://localhost:9999/v1/announcements/type='+type, {headers: headers})
        .map((response: Response) => response);
    }else if (type == "Field") {
      return this.http.get('http://localhost:9999/v1/announcements/type='+type, {headers: headers})
        .map((response: Response) => response);
    }
  }

  getMyAnnouncements(){
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('token', localStorage.getItem('currentUser'));
    return this.http.get('http://localhost:9999/v1/announcements/myAnnouncements', {headers: headers})
      .map((response: Response) => response);
  }

  getMostPopular() {
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get('http://localhost:9999/v1/announcements/popular', {headers: headers})
      .map((response: Response) => response);
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
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('token', localStorage.getItem('currentUser'));
    return this.http.post('http://localhost:9999/v1/announcements/post', json, {headers: headers})
      .map((response: Response) => response.status.toString());
  }
}
