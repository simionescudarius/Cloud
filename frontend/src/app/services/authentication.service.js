"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
require("rxjs/add/operator/map");
var AuthenticationService = (function () {
    function AuthenticationService(http) {
        this.http = http;
    }
    AuthenticationService.prototype.login = function (username, password) {
        var json = JSON.stringify({ username: username, password: password });
        var headers = new http_1.Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.post('http://localhost:9999/v1/auth/login', json, { headers: headers })
            .map(function (response) {
            if (response && response.text()) {
                localStorage.setItem('currentUser', JSON.stringify(response.text()));
                localStorage.setItem('currentEmail', username);
            }
        });
    };
    AuthenticationService.prototype.register = function (firstName, lastName, email, phone, password) {
        var json = JSON.stringify({
            email: email,
            firstName: firstName,
            lastName: lastName,
            password: password,
            phoneNumber: phone
        });
        var headers = new http_1.Headers();
        headers.append('Content-Type', 'application/json');
        return this.http.put('http://localhost:9999/v1/auth/register', json, { headers: headers })
            .map(function (response) { return response.status.toString(); });
    };
    AuthenticationService.prototype.logout = function () {
        localStorage.removeItem('currentUser');
    };
    return AuthenticationService;
}());
AuthenticationService = __decorate([
    core_1.Injectable()
], AuthenticationService);
exports.AuthenticationService = AuthenticationService;
