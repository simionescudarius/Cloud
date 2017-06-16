import { Injectable } from '@angular/core';
import {Http, Headers, Response} from "@angular/http";

@Injectable()
export class UserService {

  constructor(private http:Http) { }

  getUser(){
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('token', localStorage.getItem('currentUser'));
    return this.http.get('http://localhost:9999/v1/users/myInfos', {headers: headers})
      .map((response:Response) => response);
  }
}
