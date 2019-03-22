package com.cts.moviecruiserapp.ControllerTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import com.cts.moviecruiserapp.domain.Movie;
import com.cts.moviecruiserapp.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MovieAppControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private MovieService movieService;
	
	private Movie movie;
	
	static List<Movie> movies;
	
	ObjectMapper mapper;
	@Before
	public void setUp(){
		mapper=new ObjectMapper();
		movies=new ArrayList<Movie>();
		
		movie=new Movie(1, "kick1", "good v", "www.abc.com", "2015-03-23", 111, "1011");
		movies.add(movie);
		movies.add(new Movie(2, "kick2", "good v", "www.abc.com", "2015-03-23", 112, "10111"));
	}
	
	@Test
	public void testSaveNewMovieSuccess() throws Exception {
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIxMjM0NTYiLCJpYXQiOjE1MzY2NDIzNjh9.hWxT0EugLV4MG7NgL7roVR7fouzp3YVHuLEkCS3Mzb9O67eLC8Ulv6Qbg2vDOUv9";
		
		when(movieService.saveMovie(movie)).thenReturn(true);
		mockMvc.perform(post("/api/v1/movieservice/movie").header("authorization", "Bearer " + token).
				contentType(MediaType.APPLICATION_JSON).content(jsonToString(movie)))
		.andExpect(status().isCreated());
		verify(movieService, times(1)).saveMovie(Mockito.any(Movie.class));
		verifyNoMoreInteractions(movieService);
	}
	
	@Test
	public void testUpdateMovie() throws Exception{
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIxMjM0NTYiLCJpYXQiOjE1MzY2NDIzNjh9.hWxT0EugLV4MG7NgL7roVR7fouzp3YVHuLEkCS3Mzb9O67eLC8Ulv6Qbg2vDOUv9";
		when(movieService.updateMovie(movie)).thenReturn(movie);
		mockMvc.perform(put("/api/v1/movieservice/movie").header("authorization", "Bearer " + token).contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(movie)))
				.andExpect(status().isOk());
		verify(movieService,times(1)).updateMovie(Mockito.any(Movie.class));
	}
	@Test
	public void testDeleteMovie() throws Exception{
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIxMjM0NTYiLCJpYXQiOjE1MzY2NDIzNjh9.hWxT0EugLV4MG7NgL7roVR7fouzp3YVHuLEkCS3Mzb9O67eLC8Ulv6Qbg2vDOUv9";
		when(movieService.deleteMovieById(movie.getId())).thenReturn(true);
		mockMvc.perform(delete("/api/v1/movieservice/movie/"+movie.getId()).header("authorization", "Bearer " + token))
				.andExpect(status().isOk());
		verify(movieService,times(1)).deleteMovieById(movie.getId());
	}
	@Test
	public void testGetMovie() throws Exception{
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIxMjM0NTYiLCJpYXQiOjE1MzY2NDIzNjh9.hWxT0EugLV4MG7NgL7roVR7fouzp3YVHuLEkCS3Mzb9O67eLC8Ulv6Qbg2vDOUv9";
		when(movieService.getMovieById(movie.getId())).thenReturn(movie);
		mockMvc.perform(get("/api/v1/movieservice/movie/"+movie.getId()).header("authorization", "Bearer " + token))
				.andExpect(status().isOk());
		verify(movieService,times(1)).getMovieById(movie.getId());
	}
	@Test
	public void testGetMyMovies() throws Exception {
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIxMjM0NTYiLCJpYXQiOjE1MzY2NDIzNjh9.hWxT0EugLV4MG7NgL7roVR7fouzp3YVHuLEkCS3Mzb9O67eLC8Ulv6Qbg2vDOUv9";
		when(movieService.getMyMovies("123456")).thenReturn(null);
		mockMvc.perform(get("/api/v1/movieservice/movie").header("authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(movieService, times(1)).getMyMovies("123456");
		verifyNoMoreInteractions(movieService);
	}
	private String jsonToString(final Object object) {
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			result = "Json processing error";
		}
		return result;
	}
}

