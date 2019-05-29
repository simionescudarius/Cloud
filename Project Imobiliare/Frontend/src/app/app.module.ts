import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { SearchResultComponent } from './pages/search-result/search-result.component';
import { UserProfileComponent } from './pages/user-profile/user-profile.component';
import { AnnouncementFormComponent } from './components/announcement-form/announcement-form.component';
import { AnnouncementComponent } from './components/announcement/announcement.component';
import { HeaderComponent } from './components/header/header.component';
import { LeftPanelComponent } from './components/left-panel/left-panel.component';
import { LoggedNavbarComponent } from './components/logged-navbar/logged-navbar.component';
import { LoginRegisterComponent } from './components/login-register/login-register.component';
import { MapComponent } from './components/map/map.component';
import { MeetingsRequestsComponent } from './components/meetings-requests/meetings-requests.component';
import { MostPopularComponent } from './components/most-popular/most-popular.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { UserAnnouncementsComponent } from './components/user-announcements/user-announcements.component';
import { HttpClientModule } from '@angular/common/http';

import { BsModalModule } from 'ng2-bs3-modal';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AgmCoreModule } from '@agm/core';
import { MeetingsProgressComponent } from './components/meetings-progress/meetings-progress.component';
import { UserFavouritesComponent } from './components/user-favourites/user-favourites.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SearchResultComponent,
    UserProfileComponent,
    AnnouncementFormComponent,
    AnnouncementComponent,
    HeaderComponent,
    LeftPanelComponent,
    LoggedNavbarComponent,
    LoginRegisterComponent,
    MapComponent,
    MeetingsRequestsComponent,
    MostPopularComponent,
    NavbarComponent,
    UserAnnouncementsComponent,
    MeetingsProgressComponent,
    UserFavouritesComponent
  ],
  imports: [
    BrowserModule,
    BsModalModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAijOqQHRJt_tRxosgOMEDaD9dIIRxHa0Y'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
