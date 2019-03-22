import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../movie.service';
import { Movie } from '../../movie';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'movie-watchlist',
  templateUrl: './watchlist.component.html',
  styleUrls: ['./watchlist.component.css']
})
export class WatchlistComponent implements OnInit {
  
  movies: Array<Movie>;
  useWatchlistApi: boolean = true;

  constructor(private service: MovieService, private snackBar: MatSnackBar) {
    this.movies = [];
   }

  ngOnInit() {
    let message="My Watchlist is empty";
    this.service.getWatchlistedMovie().subscribe(movies => {
      console.log(movies);
      // if(movies.length == 0) {
      //   this.snackBar.open(message, '', {
      //     duration: 10000
      //   });
      // }
      this.movies.push(...movies);
    },
    (error) =>
    {
        this.snackBar.open(message, '', {
          duration: 1000
        });
      
    })
  }

}
