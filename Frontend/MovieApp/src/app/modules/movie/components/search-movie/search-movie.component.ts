import { Component, OnInit } from '@angular/core';
import { Movie } from '../../movie';
import { MovieService } from '../../movie.service';

@Component({
  selector: 'search-movie',
  templateUrl: './search-movie.component.html',
  styleUrls: ['./search-movie.component.css']
})
export class SearchMovieComponent implements OnInit {

  movies: Array<Movie>;

  constructor(private service: MovieService) { }

  ngOnInit() {
  }

  onEnter(searchKey) {
    this.service.searchMovie(searchKey).subscribe(movies => {
      this.movies = movies;
    })
  }
}
