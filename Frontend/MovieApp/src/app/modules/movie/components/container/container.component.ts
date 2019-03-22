import { Component, OnInit, Input } from '@angular/core';
import { MovieService } from '../../movie.service';
import { Movie } from '../../movie';
import { ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';


@Component({
  selector: 'movie-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.css']
})
export class ContainerComponent implements OnInit {

  @Input()
  movies: Array<Movie>;
  
  @Input()
  useWatchlistApi: boolean;

  constructor(private service: MovieService, private snackBar: MatSnackBar) { }

  ngOnInit() {

  }

  addToWatchlist(movie) {
    let message = `${movie.title} added to Wathclist`;
    this.service.addMovieToWatchlist(movie).subscribe((movie) => {
      this.snackBar.open(message, '', {
        duration: 1000
      });
    })
  }

  deleteMovieFromWatchlist(movie) {
    this.service.deleteMovieFromWatchlist(movie).subscribe((result) => {
      let message = `${movie.title} ${result}`;
      this.snackBar.open(message, '', {
        duration: 1000
      });
      const index = this.movies.indexOf(movie);
      this.movies.splice(index, 1);
    });
    
  }

}
