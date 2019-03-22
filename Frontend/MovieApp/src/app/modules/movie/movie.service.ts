import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from './movie';
import { map } from 'rxjs/operators/map';
import { retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MovieService {


  newMovie:Movie;
  tmdb_endpoint: string;
  imagePrefix: string;
  apiKey: string;
  watchlistEndpoint: string;
  searchEndipoint: string

  constructor(private http: HttpClient) {
    this.apiKey = "api_key=ff1643df2207cb148309e7e7dc4ead0b";
    this.tmdb_endpoint = 'https://api.themoviedb.org/3';
    this.imagePrefix = "https://image.tmdb.org/t/p/w500";
    this.watchlistEndpoint = "http://localhost:8089/api/v1/movieservice/movie";
  }

  getMovies(type: string, page: number = 1): Observable<Array<Movie>> {
    const movieEndpoint = `${this.tmdb_endpoint}/movie/${type}?${this.apiKey}&page=${page}`
    return this.http.get(movieEndpoint).pipe(
      retry(3),
      map(this.pickMovieResults),
      map(this.transformPosterPath.bind(this))
    );
  }
  
  searchMovie(searchKey: string,page: number = 1): Observable<Array<Movie>> {
    if (searchKey.length > 0) {
      const searchEndpoint = `${this.tmdb_endpoint}/search/movie?${this.apiKey}&page=${page}&include_adult=true&query=${searchKey}`;
      return this.http.get(searchEndpoint).pipe(
        retry(3),
        map(this.pickMovieResults),
        map(this.transformPosterPath.bind(this))
      );
    }
  }

  addMovieToWatchlist(movie) {
    
    return this.http.post(this.watchlistEndpoint, movie);
  }

  getWatchlistedMovie(): Observable<Array<Movie>> {
    return this.http.get<Array<Movie>>(this.watchlistEndpoint);
  }

  deleteMovieFromWatchlist(movie) {
    const delUrl = `${this.watchlistEndpoint}/${movie.id}`;
    return this.http.delete(delUrl, {responseType: 'text'});
  }

  updateWatchlist(movie) {
    return this.http.put(this.watchlistEndpoint, movie);
  }

  pickMovieResults(response) {
    return response['results'];
  }

  transformPosterPath(movies): Array<Movie> {
    console.log(movies);
    return movies.map(movie => {
      movie.poster_path = `${this.imagePrefix}${movie.poster_path}`;
      return movie;
    })
  }

}
