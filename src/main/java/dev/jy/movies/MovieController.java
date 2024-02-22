package dev.jy.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Creation of the RESTful web services
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    private MovieService movieService; // Instantiate the variable instead using constructor
    @GetMapping
    public ResponseEntity<List> getAllMovies() {
        return new ResponseEntity<List>(movieService.allMovies(), HttpStatus.OK); // HTTP.OK means 200
    } // Rest Api contains controller(receive request and return a response), service, repository layer.

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
