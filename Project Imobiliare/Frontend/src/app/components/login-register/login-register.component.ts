import { Component, OnInit, ViewChild } from '@angular/core';
import { isNull } from 'util';
import { BsModalComponent } from 'ng2-bs3-modal';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';

@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.css']
})
export class LoginRegisterComponent implements OnInit {

  animation: boolean = true;
  keyboard: boolean = true;
  backdrop: boolean = true;
  check: boolean = false;
  logged: boolean = false;
  loginFailed: boolean = false;
  registerFailed: boolean = false;
  registerComplete: boolean = false;
  emailUsed: boolean = false;
  isNewUser: boolean = false;
  registerForm: FormGroup;
  loginForm: FormGroup;

  @ViewChild('signIn')
  signIn: BsModalComponent;
  @ViewChild('register')
  register: BsModalComponent;

  constructor(private formBuilder: FormBuilder, private authenticationService: AuthenticationService, private router: Router) { }

  rememberMe(checked) {
    this.check = checked;
  }

  loginClosed() {
    this.signIn.close();
  }

  registerClosed() {
    this.register.close();
  }

  openLoginForm() {
    this.loginFailed = false;
    this.isNewUser = false;
    this.logged = false;
    this.loginForm.reset();
    this.signIn.open();
  }

  openRegisterForm() {
    this.emailUsed = false;
    this.registerFailed = false;
    this.registerComplete = false;
    this.registerForm.reset();
    this.register.open();
  }

  switchModals() {
    this.loginForm.reset();
    this.signIn.open();
    this.register.close();
  }

  login(value) {
    this.authenticationService.login(value.email, value.password).subscribe(
      response => {
        if (response) {
          localStorage.setItem('token', response.toString());
          localStorage.setItem('email', this.loginForm.value.email);

          if (this.check === true) {
            localStorage.setItem('remember_me', 'true');
          }
        }
        this.isNewUser = false;
        this.logged = true;
        this.loginFailed = false;
        setTimeout(() => location.reload(), 1000);
      },
      error => {
        console.log(error);
        this.isNewUser = false;
        this.logged = false;
        this.loginFailed = true;
      });
  }

  reg(value) {
    this.authenticationService.register(value.firstname, value.lastname, value.email, value.phone, value.password).subscribe(
      response => {
        if (response.status === 201) {
          this.emailUsed = false;
          this.registerFailed = false;
          this.registerComplete = true;

          this.isNewUser = true;
          this.switchModals();
        } else {
          this.registerComplete = false;
          this.registerFailed = false;
          this.emailUsed = true;
        }
      },
      error => {
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
    let email = localStorage.getItem('email');
    let psw = localStorage.getItem('psw');

    if (!isNull(email) && !isNull(psw)) {
      this.loginForm = this.formBuilder.group({
        'email': [email, Validators.compose([Validators.required, Validators.minLength(5), Validators.pattern("[[a-zA-Z0-9]+@[a-zA-Z]+[.][a-zA-Z]+")])],
        'password': [psw, Validators.compose([Validators.required, Validators.minLength(6)])]
      });
    } else {
      this.loginForm = this.formBuilder.group({
        'email': ['', Validators.compose([Validators.required, Validators.minLength(5), Validators.pattern("[[a-zA-Z0-9]+@[a-zA-Z]+[.][a-zA-Z]+")])],
        'password': ['', Validators.compose([Validators.required, Validators.minLength(6)])]
      });
    }
    this.registerForm = this.formBuilder.group({
      'firstname': ['', Validators.compose([Validators.required, Validators.pattern("[a-zA-Z]+")])],
      'lastname': ['', Validators.compose([Validators.required, Validators.pattern("[a-zA-Z]+")])],
      'email': ['', Validators.compose([Validators.required, Validators.minLength(5), Validators.pattern("[[a-zA-Z0-9]+@[a-zA-Z]+[.][a-zA-Z]+")])],
      'phone': ['', Validators.compose([Validators.required, Validators.minLength(9), Validators.maxLength(11), Validators.pattern("[0-9]+")])],
      'password': ['', Validators.compose([Validators.required, Validators.minLength(6)])],
      'repeatpassword': ['', Validators.compose([Validators.required, Validators.minLength(6)])]
    });
  }

}
