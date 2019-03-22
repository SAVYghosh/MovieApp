package com.cts.moviecruiserapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.moviecruiserapp.domain.Movie;


public interface MovieRepository extends JpaRepository<Movie, Integer>{

	List<Movie> findByUserId(String userId);
	Optional<Movie> findByMovieId(int movieId);
	
//	@Query("Select movie from Movie movie where movie.userId = (?1) and movie.movieId = (?2)")
//	Movie validate(String userId, int movieId);
	Optional<Movie> findByMovieIdAndUserId(int movieId,String userId);
}
