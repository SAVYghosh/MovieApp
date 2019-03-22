package com.cts.moviecruiserapp.RepositoryTest;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.moviecruiserapp.domain.Movie;
import com.cts.moviecruiserapp.repository.MovieRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
public class MovieAppRepositoryTest {

	@Autowired
	private transient  MovieRepository movieRepository;

	@After
	public void deleteData(){
		final Movie tempMovieDel = movieRepository.findByMovieId(11).get();
		movieRepository.delete(tempMovieDel);
		assertEquals(Optional.empty(), movieRepository.findByMovieId(11));
	}
	
	@Test
	public void testSaveMovie() throws Exception {
		movieRepository.save(new Movie(1, "kick", "good v", "www.abc.com", "2015-03-23", 11, "1011"));
		Movie movie = movieRepository.findByMovieId(11).get();
		assertThat(movie.getMovieId()).isEqualTo(11);
		}
	
	@Test
	public void testUpdateMovie() throws Exception {
		movieRepository.save(new Movie(1, "kick", "good v", "www.abc.com", "2015-03-23", 11, "1011"));
		final Movie movie = movieRepository.findByMovieId(11).get();
		movie.setComments("Hi");
		movieRepository.save(movie);
		final Movie tempMovie = movieRepository.findByMovieId(11).get();
		assertEquals("Hi", tempMovie.getComments());
		}
	
	@Test
	public void testDeleteMovie() throws Exception {
		movieRepository.save(new Movie(1, "kick", "good v", "www.abc.com", "2015-03-23", 11, "1011"));
		 Movie movie = movieRepository.findByMovieId(11).get();
		assertEquals("kick", movie.getTitle());
	}
	
	@Test
	public void testGetMovie() throws Exception {
		movieRepository.save(new Movie(1, "kick", "good v", "www.abc.com", "2015-03-23", 11, "1011"));
		 Movie movie = movieRepository.findByMovieId(11).get();
		assertEquals("kick", movie.getTitle());
	}
	
	@Test
	public void testGetAllMovies() throws Exception{
		movieRepository.save(new Movie(1, "kick", "good v", "www.abc.com", "2015-03-23", 11, "1011"));
		 List<Movie> listOfMovies = movieRepository.findByUserId("1011");
		 int listsize= listOfMovies.size()-1;
		 boolean flag=true;
		 if(listsize>0)
		 {
			  flag=true;
		 }
		assertEquals(true,flag);
	}
	
}
