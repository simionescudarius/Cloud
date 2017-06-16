import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {Ng2Bs3ModalModule} from 'ng2-bs3-modal/ng2-bs3-modal';
import {AppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from "@angular/http";
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./pages/home/home.component";
import {AnnouncementComponent} from "./components/announcement/announcement.component";
import {SearchResultComponent} from "./pages/search-result/search-result.component";
import {UserProfileComponent} from "./pages/user-profile/user-profile.component";
import {NavbarComponent} from "./components/navbar/navbar.component";
import {LoginRegisterComponent} from "./components/login-register/login-register.component";
import {HeaderComponent} from "./components/header/header-component.component";
import {MostPopularComponent} from "./components/most-popular/most-popular.component";
import {LoggedNavbarComponent} from "./components/logged-navbar/logged-navbar.component";
import {MapComponent} from "./components/map/map.component";
import {AgmCoreModule} from "@agm/core";
import {UserAnnouncementsComponent} from "./components/user-announcements/user-announcements.component";
import {LeftPanelComponent} from "./components/left-panel/left-panel.component";

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch:'full'},
  {path: 'home', component: HomeComponent},
  {path: 'announcement/:id', component: AnnouncementComponent},
  {path: 'searchResult', component: SearchResultComponent},
  {path: 'myProfile', component: UserProfileComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginRegisterComponent,
    HeaderComponent,
    MostPopularComponent,
    AnnouncementComponent,
    LoggedNavbarComponent,
    HomeComponent,
    SearchResultComponent,
    UserProfileComponent,
    MapComponent,
    UserAnnouncementsComponent,
    LeftPanelComponent
  ],
  imports: [
    BrowserModule,
    Ng2Bs3ModalModule,
    FormsModule,
    ReactiveFormsModule,
    [RouterModule.forRoot(routes)],
    HttpModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAZksBYKq4HH8pLQoPjoTDBtSJr_-40FWI'
    })
  ],
  providers: [],
  exports: [RouterModule],
  bootstrap: [AppComponent]
})
export class AppModule {
}
