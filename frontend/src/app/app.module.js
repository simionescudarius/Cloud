"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var platform_browser_1 = require("@angular/platform-browser");
var core_1 = require("@angular/core");
var ng2_bs3_modal_1 = require("ng2-bs3-modal/ng2-bs3-modal");
var app_component_1 = require("./app.component");
var navbar_component_1 = require("./navbar-component/navbar.component");
var forms_1 = require("@angular/forms");
var http_1 = require("@angular/http");
var login_register_component_1 = require("./login-register-component/login-register.component");
var header_component_component_1 = require("./header-component/header-component.component");
var most_popular_component_1 = require("./most-popular-component/most-popular.component");
var logged_navbar_component_1 = require("./logged-navbar-component/logged-navbar.component");
var announcement_component_1 = require("./announcement-component/announcement.component");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        declarations: [
            app_component_1.AppComponent,
            navbar_component_1.NavbarComponent,
            login_register_component_1.LoginRegisterComponent,
            header_component_component_1.HeaderComponent,
            most_popular_component_1.MostPopularComponent,
            announcement_component_1.AnnouncementComponent,
            logged_navbar_component_1.LoggedNavbarComponent
        ],
        imports: [
            platform_browser_1.BrowserModule,
            ng2_bs3_modal_1.Ng2Bs3ModalModule,
            forms_1.FormsModule,
            forms_1.ReactiveFormsModule,
            http_1.HttpModule
        ],
        providers: [],
        bootstrap: [app_component_1.AppComponent]
    })
], AppModule);
exports.AppModule = AppModule;
