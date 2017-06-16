"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var util_1 = require("util");
var forms_1 = require("@angular/forms");
var authentication_service_1 = require("../services/authentication.service");
var LoginRegisterComponent = (function () {
    function LoginRegisterComponent(_formBuilder, _authenticationService) {
        this._formBuilder = _formBuilder;
        this._authenticationService = _authenticationService;
        this.animation = true;
        this.keyboard = true;
        this.backdrop = true;
        this.check = true;
        this.logged = false;
        this.loginFailed = false;
        this.registerFailed = false;
        this.registerComplete = false;
        this.emailUsed = false;
    }
    LoginRegisterComponent.prototype.rememberMe = function (checked) {
        this.check = checked;
    };
    LoginRegisterComponent.prototype.loginClosed = function () {
        this.loginFailed = false;
    };
    LoginRegisterComponent.prototype.login = function (value) {
        var _this = this;
        if (this.check == true) {
            localStorage.setItem("email", this.loginForm.value.email);
            localStorage.setItem("psw", this.loginForm.value.password);
        }
        else {
            localStorage.removeItem("email");
            localStorage.removeItem("psw");
        }
        this._authenticationService.login(value.email, value.password)
            .subscribe(function (data) {
            alert("Success");
            _this.logged = true;
            _this.loginFailed = false;
            //REDIRECT HERE TO LOGGED PAGE
        }, function (error) {
            alert("Failed" + error);
            _this.logged = false;
            _this.loginFailed = true;
        });
    };
    LoginRegisterComponent.prototype.reg = function (value) {
        var _this = this;
        this._authenticationService.register(value.firstname, value.lastname, value.email, value.phone, value.password).subscribe(function (data) {
            alert("Success" + data);
            if (data == "201") {
                _this.emailUsed = false;
                _this.registerFailed = false;
                _this.registerComplete = true;
            }
            else {
                _this.registerComplete = false;
                _this.registerFailed = false;
                _this.emailUsed = true;
            }
        }, function (error) {
            alert("Failed" + error);
            _this.registerComplete = false;
            _this.registerFailed = false;
            _this.loginFailed = true;
        });
    };
    LoginRegisterComponent.prototype.ngOnInit = function () {
        this.logged = false;
        this.loginFailed = false;
        this.registerFailed = false;
        this.registerComplete = false;
        this.emailUsed = false;
        var email = localStorage.getItem("email");
        var psw = localStorage.getItem("psw");
        this._authenticationService.logout();
        if (!util_1.isNull(email) && !util_1.isNull(psw)) {
            this.loginForm = this._formBuilder.group({
                'email': [email, forms_1.Validators.compose([forms_1.Validators.required, forms_1.Validators.minLength(5), forms_1.Validators.pattern("[[a-zA-Z0-9]+@[a-zA-Z]+[.][a-zA-Z]+")])],
                'password': [psw, forms_1.Validators.compose([forms_1.Validators.required, forms_1.Validators.minLength(6)])]
            });
        }
        else {
            this.loginForm = this._formBuilder.group({
                'email': ['', forms_1.Validators.compose([forms_1.Validators.required, forms_1.Validators.minLength(5), forms_1.Validators.pattern("[[a-zA-Z0-9]+@[a-zA-Z]+[.][a-zA-Z]+")])],
                'password': ['', forms_1.Validators.compose([forms_1.Validators.required, forms_1.Validators.minLength(6)])]
            });
        }
        this.registerForm = this._formBuilder.group({
            'firstname': ['test', forms_1.Validators.compose([forms_1.Validators.required, forms_1.Validators.pattern("[a-zA-Z]+")])],
            'lastname': ['test', forms_1.Validators.compose([forms_1.Validators.required, forms_1.Validators.pattern("[a-zA-Z]+")])],
            'email': ['test@gmail.com', forms_1.Validators.compose([forms_1.Validators.required, forms_1.Validators.minLength(5), forms_1.Validators.pattern("[[a-zA-Z0-9]+@[a-zA-Z]+[.][a-zA-Z]+")])],
            'phone': ['1233211231', forms_1.Validators.compose([forms_1.Validators.required, forms_1.Validators.minLength(9), forms_1.Validators.maxLength(11), forms_1.Validators.pattern("[0-9]+")])],
            'password': ['parola', forms_1.Validators.compose([forms_1.Validators.required, forms_1.Validators.minLength(6)])],
            'repeatpassword': ['parola', forms_1.Validators.compose([forms_1.Validators.required, forms_1.Validators.minLength(6)])]
        });
    };
    return LoginRegisterComponent;
}());
LoginRegisterComponent = __decorate([
    core_1.Component({
        selector: 'app-login-register',
        templateUrl: './login-register.component.html',
        styleUrls: ['../css/index.css'],
        providers: [authentication_service_1.AuthenticationService]
    })
], LoginRegisterComponent);
exports.LoginRegisterComponent = LoginRegisterComponent;
