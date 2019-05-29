import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private endpoint = 'https://complete-kite-236211.appspot.com/v1/users/';

  constructor(private http: HttpClient) { }

  getUser() {
    var headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    headers.set('token', localStorage.getItem('token'));
    return this.http.get<User>(this.endpoint + 'myInfos',
      {
        headers: {
          'Content-Type': 'application/json',
          token: localStorage.getItem('token')
        },
        observe: 'response'
      });
  }
}
