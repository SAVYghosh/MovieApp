package com.cts.moviecruiserapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.moviecruiserapp.domain.Movie;
import com.cts.moviecruiserapp.exception.MovieAlreadyExistsException;
import com.cts.moviecruiserapp.exception.MovieNotFoundException;


public interface MovieService {

	boolean saveMovie(Movie movie) throws MovieAlreadyExistsException;

	Movie updateMovie(Movie movie) throws MovieNotFoundException;

	boolean deleteMovieById(int id) throws MovieNotFoundException;

	Movie getMovieById(int id) throws MovieNotFoundException;

	List<Movie> getMyMovies(String userId) throws MovieNotFoundException;
	}