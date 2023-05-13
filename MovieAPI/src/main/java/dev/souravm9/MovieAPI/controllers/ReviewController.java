package dev.souravm9.MovieAPI.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.souravm9.MovieAPI.models.Review;
import dev.souravm9.MovieAPI.services.ReviewService;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

	@Autowired
	private ReviewService service;

	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

		return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")),
				HttpStatus.OK);
	}

}
