import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieModule } from './modules/movie/movie.module';
import { Routes, RouterModule } from '@angular/router';
import { SharedModule } from './modules/shared/shared.module';
import { LoginComponent } from './modules/authentication/components/login/login.component';
import { RegisterComponent } from './modules/authentication/components/register/register.component';
import { AuthenticationModule } from './modules/authentication/authentication.module';
import { AuthGuardService } from './auth-guard.service';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/register',
    pathMatch: 'full'
  }
]

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MovieModule,
    AuthenticationModule,
    SharedModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
