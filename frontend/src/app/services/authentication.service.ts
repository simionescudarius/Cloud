import {Injectable} from '@angular/core';
import {Http, Headers, Response} from "@angular/http";
import 'rxjs/add/operator/map'

@Injectable()
export class AuthenticationService {

  constructor(private http: Http) {
  }

  login(username: string, password: string) {
    var json = JSON.stringify({username: username, password: password});
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:9999/v1/auth/login', json, {headers: headers})
      .map((response: Response) => {
        if (response && response.text()) {
          localStorage.setItem('currentUser', response.text());
          localStorage.setItem('currentEmail', username);
        }
      });
  }

  register(firstName: string, lastName: string, email: string, phone: string, password: string) {
    var json = JSON.stringify({
      email: email,
      firstName: firstName,
      lastName: lastName,
      password: password,
      phoneNumber: phone
    });
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.put('http://localhost:9999/v1/auth/register', json, {headers: headers})
      .map((response: Response) => response.status.toString());
  }

  verify() {
    var headers = new Headers();
    headers.append('token', localStorage.getItem('currentUser'));
    return this.http.get('http://localhost:9999/v1/auth/verify', {headers: headers})
      .map((response: Response) => response.status.toString());
  }

  logout() {
    localStorage.removeItem('currentUser');
  }

}
