package dev.souravm9.MovieAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.souravm9.MovieAPI.models.Movie;
import dev.souravm9.MovieAPI.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> findAllMovies() {
		return movieRepository.findAll();
	}

	public Optional<Movie> findMovieByImdbId(String imdbId) {
		return movieRepository.findMovieByImdbId(imdbId);
	}
}
