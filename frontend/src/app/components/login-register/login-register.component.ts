import {Component, OnInit, Output, ViewChild, Attribute} from '@angular/core';
import {isNull, isString, isUndefined} from "util";
import {ModalComponent} from 'ng2-bs3-modal/ng2-bs3-modal';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {EqualTextValidator} from "angular2-text-equality-validator";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['../../css/index.css'],
  providers: [AuthenticationService]
})
export class LoginRegisterComponent implements OnInit {
  animation: boolean = true;
  keyboard: boolean = true;
  backdrop: boolean = true;
  check: boolean = true;
  logged: boolean = false;
  loginFailed: boolean = false;
  registerFailed: boolean = false;
  registerComplete: boolean = false;
  emailUsed: boolean = false;
  registerForm: FormGroup;
  loginForm: FormGroup;

  signIn: ModalComponent;
  register: ModalComponent;

  constructor(private _formBuilder: FormBuilder, private _authenticationService: AuthenticationService,
              private _router: Router) {
  }

  rememberMe(checked) {
    this.check = checked;
  }

  loginClosed() {
    this.loginFailed = false;
  }

  login(value) {
    if (this.check == true) {
      localStorage.setItem("email", this.loginForm.value.email);
      localStorage.setItem("psw", this.loginForm.value.password);
    } else {
      localStorage.removeItem("email");
      localStorage.removeItem("psw");
    }
    this._authenticationService.login(value.email, value.password)
      .subscribe(
        data => {
          this.logged = true;
          this.loginFailed = false;
          setTimeout(() => window.location.reload(), 1000);
        },
        error => {
          alert("Failed" + error);
          this.logged = false;
          this.loginFailed = true;
        });
  }

  reg(value) {
    this._authenticationService.register(value.firstname, value.lastname, value.email, value.phone, value.password).subscribe(
      data => {
        if (data == "201") {
          this.emailUsed = false;
          this.registerFailed = false;
          this.registerComplete = true;
        } else {
          this.registerComplete = false;
          this.registerFailed = false;
          this.emailUsed = true;
        }
      },
      error => {
        alert("Failed" + error);
        this.registerComplete = false;
        this.registerFailed = false;
        this.loginFailed = true;
      });
  }

  ngOnInit() {
    this.logged = false;
    this.loginFailed = false;
    this.registerFailed = false;
    this.registerComplete = false;
    this.emailUsed = false;
    let email = localStorage.getItem("email");
    let psw = localStorage.getItem("psw");
    // this._authenticationService.logout();
    if (!isNull(email) && !isNull(psw)) {
      this.loginForm = this._formBuilder.group({
        'email': [email, Validators.compose([Validators.required, Validators.minLength(5), Validators.pattern("[[a-zA-Z0-9]+@[a-zA-Z]+[.][a-zA-Z]+")])],
        'password': [psw, Validators.compose([Validators.required, Validators.minLength(6)])]
      });
    } else {
      this.loginForm = this._formBuilder.group({
        'email': ['', Validators.compose([Validators.required, Validators.minLength(5), Validators.pattern("[[a-zA-Z0-9]+@[a-zA-Z]+[.][a-zA-Z]+")])],
        'password': ['', Validators.compose([Validators.required, Validators.minLength(6)])]
      });
    }
    this.registerForm = this._formBuilder.group({
      'firstname': ['', Validators.compose([Validators.required, Validators.pattern("[a-zA-Z]+")])],
      'lastname': ['', Validators.compose([Validators.required, Validators.pattern("[a-zA-Z]+")])],
      'email': ['', Validators.compose([Validators.required, Validators.minLength(5), Validators.pattern("[[a-zA-Z0-9]+@[a-zA-Z]+[.][a-zA-Z]+")])],
      'phone': ['', Validators.compose([Validators.required, Validators.minLength(9), Validators.maxLength(11), Validators.pattern("[0-9]+")])],
      'password': ['', Validators.compose([Validators.required, Validators.minLength(6)])],
      'repeatpassword': ['', Validators.compose([Validators.required, Validators.minLength(6)])]
    });
  }
}


