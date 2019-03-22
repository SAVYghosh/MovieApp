import { NgModule } from '@angular/core';
import { ThumbnailComponent } from './components/thumbnail/thumbnail.component';
import { MovieService } from './movie.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ContainerComponent } from './components/container/container.component';
import { MovieRouterModule } from './movie-router.router';
import { MovieDialogComponent } from './components/movie-dialog/movie-dialog.component';
import { TmdbContainerComponent } from './components/tmdb-container/tmdb-container.component';
import { WatchlistComponent } from './components/watchlist/watchlist.component';
import { SharedModule } from '../shared/shared.module';
import { SearchMovieComponent } from './components/search-movie/search-movie.component';
import { TokenInterceptorService } from './token-interceptor.service';

@NgModule({
  imports: [
    SharedModule,
    HttpClientModule,
    MovieRouterModule
  ],
  declarations: [
    ThumbnailComponent,
    ContainerComponent,
    WatchlistComponent,
    TmdbContainerComponent,
    MovieDialogComponent,
    SearchMovieComponent
  ],
  entryComponents: [
    MovieDialogComponent
  ],
  exports: [
    MovieRouterModule,
    ThumbnailComponent
  ],
  providers: [MovieService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    }
  ]})
export class MovieModule { }
