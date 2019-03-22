import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../movie.service';
import { Movie } from '../../movie';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'movie-tmdb-container',
  templateUrl: './tmdb-container.component.html',
  styleUrls: ['./tmdb-container.component.css']
})
export class TmdbContainerComponent implements OnInit {

  movies: Array<Movie>;
  movieType: string;

  constructor(private service: MovieService, private route: ActivatedRoute) {
    this.movies = [];
    this.route.data.subscribe((data) => {
      this.movieType = data.movieType;
    });
  }

  ngOnInit() {
    this.service.getMovies(this.movieType).subscribe((movies) => {
      this.movies.push(...movies);
    })
  }

}
