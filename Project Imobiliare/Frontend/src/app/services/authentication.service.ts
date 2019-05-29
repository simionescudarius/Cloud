import { tokenKey } from '@angular/core/src/view';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private endpoint = 'https://complete-kite-236211.appspot.com/v1/auth/';

  private headers = new HttpHeaders({
    'content-type': 'application/json'
  });

  constructor(private http: HttpClient, private _router: Router) { }

  login(username: string, password: string) {
    const json = JSON.stringify({
      username: username,
      password: password
    });

    return this.http.post(this.endpoint + 'login', json, { headers: this.headers, responseType: 'text' });
  }

  register(firstName: string, lastName: string, email: string, phone: string, password: string) {
    const json = JSON.stringify({
      email: email,
      firstName: firstName,
      lastName: lastName,
      password: password,
      phoneNumber: phone
    });

    return this.http.post(this.endpoint + 'register', json, { headers: this.headers, observe: 'response' });
  }

  verify() {
    return this.http.get(this.endpoint + 'verify',
      {
        headers: {
          'Content-Type': 'application/json',
          token: localStorage.getItem('token')
        },
        observe: 'response'
      });
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('email');
    localStorage.removeItem('remember_me');
    this._router.navigate(['/home'])
  }

}
