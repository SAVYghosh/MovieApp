import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { WatchlistComponent } from './components/watchlist/watchlist.component';
import { TmdbContainerComponent } from './components/tmdb-container/tmdb-container.component';
import { SearchMovieComponent } from './components/search-movie/search-movie.component';
import { AuthGuardService } from 'src/app/auth-guard.service';

const movieRoutes: Routes = [
    {
        path: 'movies',
        canActivate: [AuthGuardService],
        children: [
            {
                path: '',
                redirectTo: '/movies/popular',
                pathMatch: 'full'
            },
            {
                path: 'popular',
                component: TmdbContainerComponent,
                data: {
                    movieType: 'popular'
                },
            },
            {
                path: 'top_rated',
                component: TmdbContainerComponent,
                data: {
                    movieType: 'top_rated'
                },
            },
            {
                path: 'watchlist',
                component: WatchlistComponent,
            },
            {
                path: 'search',
                component: SearchMovieComponent,
            }
        ]
    }
]


@NgModule({
    imports: [
        RouterModule.forChild(movieRoutes)
    ],
    exports: [
        RouterModule
    ]
})

export class MovieRouterModule { }