package com.cts.moviecruiserapp.ServiceTest;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.moviecruiserapp.domain.Movie;
import com.cts.moviecruiserapp.exception.MovieAlreadyExistsException;
import com.cts.moviecruiserapp.exception.MovieNotFoundException;
import com.cts.moviecruiserapp.repository.MovieRepository;
import com.cts.moviecruiserapp.service.MovieService;
import com.cts.moviecruiserapp.service.MovieServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MovieAppServiceTest {

	@Mock
	MovieRepository mockMovieRepository;
	
	@InjectMocks
	MovieServiceImpl mockMovieService;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	Movie movie=new Movie();
	
	@Test
	public void testSaveMovie() throws MovieAlreadyExistsException{
		when(mockMovieRepository.save(movie)).thenReturn(movie);
		assertEquals(true,mockMovieService.saveMovie(movie));
	}
	
	@Test
	public void testUpdateMovie() throws MovieAlreadyExistsException, MovieNotFoundException{
		movie.setId(1);
		movie.setMovieId(1);
		movie.setTitle("kick");
		when(mockMovieRepository.findById(1)).thenReturn(Optional.of(movie));
		assertEquals(movie,mockMovieService.updateMovie(movie));
	}
	
	@Test
	public void testDeleteMovieById() throws MovieAlreadyExistsException, MovieNotFoundException{
		movie.setId(1);
		movie.setMovieId(1);
		movie.setTitle("kick");
		when(mockMovieRepository.findById(1)).thenReturn(Optional.of(movie));
		assertEquals(true,mockMovieService.deleteMovieById(movie.getId()));
	}
	
	@Test
	public void testGetMovieById() throws MovieAlreadyExistsException, MovieNotFoundException{
		movie.setId(1);
		movie.setMovieId(1);
		movie.setTitle("kick");
		when(mockMovieRepository.findById(1)).thenReturn(Optional.of(movie));
		assertEquals(movie,mockMovieService.getMovieById(movie.getId()));
	}
	
	@Test
	public void testGetAllMovie() throws MovieAlreadyExistsException, MovieNotFoundException{
		movie.setId(1);
		movie.setMovieId(1);
		movie.setTitle("kick");
		movie.setUserId("1");
		List<Movie> list=new ArrayList<Movie>();
		list.add(movie);
		when(mockMovieRepository.findByUserId("1")).thenReturn(list);
		assertEquals(list,mockMovieService.getMyMovies("1"));
	}
	
}
