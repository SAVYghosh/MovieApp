import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { Movie } from '../../movie';
import { MovieDialogComponent } from '../movie-dialog/movie-dialog.component';
import { MatDialog } from '@angular/material/dialog';


@Component({
  selector: 'movie-thumbnail',
  templateUrl: './thumbnail.component.html',
  styleUrls: ['./thumbnail.component.css']
})
export class ThumbnailComponent implements OnInit {

  @Input()
  movie: Movie;
  
  @Input()
  useWatchlistApi: boolean;

  @Output()
  addMovie = new EventEmitter();

  @Output()
  deleteMovie = new EventEmitter();

  constructor(private dialog: MatDialog) { }

  ngOnInit() { }

  addToWatchlist() {
    this.addMovie.emit(this.movie);
  }

  deleteFromWatchlist() {
    this.deleteMovie.emit(this.movie);
  }

  updateWatchlist(actionType) {
    let dialogRef = this.dialog.open(MovieDialogComponent, {
      width: '400px',
      data: {obj: this.movie, actionType: actionType}
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }
}
