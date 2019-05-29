import { UserFavouritesComponent } from './components/user-favourites/user-favourites.component';
import { MeetingsProgressComponent } from './components/meetings-progress/meetings-progress.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AnnouncementComponent } from './components/announcement/announcement.component';
import { SearchResultComponent } from './pages/search-result/search-result.component';
import { UserProfileComponent } from './pages/user-profile/user-profile.component';
import { AnnouncementFormComponent } from './components/announcement-form/announcement-form.component';
import { MeetingsRequestsComponent } from './components/meetings-requests/meetings-requests.component';
import { UserAnnouncementsComponent } from './components/user-announcements/user-announcements.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'announcement/:id', component: AnnouncementComponent },
  { path: 'searchResult/:type/:roomNumber', component: SearchResultComponent },
  { path: 'myProfile', component: UserProfileComponent },
  { path: 'announcementForm', component: AnnouncementFormComponent },
  { path: 'meetingsRequests', component: MeetingsRequestsComponent },
  { path: 'myAnnouncements', component: UserAnnouncementsComponent },
  { path: 'meetingsInProgress', component: MeetingsProgressComponent },
  { path: 'myFavourites', component: UserFavouritesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
