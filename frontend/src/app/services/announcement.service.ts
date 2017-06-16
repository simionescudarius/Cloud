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

  getAnnouncements() {
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get('http://localhost:9999/v1/announcements', {headers: headers})
      .map((response: Response) => response);
  }

  getMostPopular() {
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get('http://localhost:9999/v1/announcements/popular', {headers: headers})
      .map((response: Response) => response);
  }
}
