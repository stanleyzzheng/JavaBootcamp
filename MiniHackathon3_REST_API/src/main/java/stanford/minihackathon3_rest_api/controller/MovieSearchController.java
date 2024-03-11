package stanford.minihackathon3_rest_api.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import stanford.minihackathon3_rest_api.DTO.MovieDTO;
import stanford.minihackathon3_rest_api.model.Movie;
import stanford.minihackathon3_rest_api.service.MovieService;

//import java.util.Base64;

@Controller
public class MovieSearchController {

    @Autowired
    private MovieService movieService;
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @PostMapping("/movie")
    public ResponseEntity<String> createMovie(@RequestBody MovieDTO movieDTO){
        movieService.saveMovie(movieDTO);
        return new ResponseEntity<>("Movie created successfully. ID: ", HttpStatus.CREATED);
    }
    @GetMapping("/movie-detail/{id}")
    public String movieDetail(@PathVariable String id, Model model){
        Movie movie = movieService.findById(id);
        String base64encodedImage = Base64.encodeBase64String(movie.getImage());
        if(movie != null){
            model.addAttribute("movie", movie);
            model.addAttribute("image", base64encodedImage);
        }
        return "movie-detail";
    }

}
