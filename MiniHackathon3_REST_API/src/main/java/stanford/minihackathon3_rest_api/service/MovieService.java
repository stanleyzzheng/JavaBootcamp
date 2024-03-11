package stanford.minihackathon3_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stanford.minihackathon3_rest_api.DTO.MovieDTO;
import stanford.minihackathon3_rest_api.model.Movie;
import stanford.minihackathon3_rest_api.repository.MovieRepository;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie findById(String id) {
        return movieRepository.findById(id)
                .orElse(null);
    }

    public void saveMovie(MovieDTO movieDTO) {
        Movie movie = convertDTOtoEntity(movieDTO);
        try{
            URL imageUrl = new URL(movieDTO.getPoster());
            InputStream inputStream = imageUrl.openStream();
            byte[] imageData = inputStream.readAllBytes();
            movie.setImage(imageData);
        } catch (IOException e){
            e.printStackTrace();
        }
        Optional<Movie> existingMovie = movieRepository.findById(movie.getId());
        if (existingMovie.isEmpty()) {
            movieRepository.save(movie);
        }
    }

    private Movie convertDTOtoEntity(MovieDTO movieDTO) {
        Movie movieEntity = new Movie();
        movieEntity.setId(movieDTO.getId());
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setYear(movieDTO.getYear());
        movieEntity.setRated(movieDTO.getRated());
        movieEntity.setReleased(movieDTO.getReleased());
        movieEntity.setRuntime(movieDTO.getRuntime());
        movieEntity.setGenre(movieDTO.getGenre());
        movieEntity.setDirector(movieDTO.getDirector());
        movieEntity.setWriter(movieDTO.getWriter());
        movieEntity.setActors(movieDTO.getActors());
        movieEntity.setPlot(movieDTO.getPlot());
        movieEntity.setLanguage(movieDTO.getLanguage());
        movieEntity.setCountry(movieDTO.getCountry());
        movieEntity.setAwards(movieDTO.getAwards());
        movieEntity.setPoster(movieDTO.getPoster());
        movieEntity.setRottenTomatoesRating(movieDTO.getRottenTomatoesRating());
        return movieEntity;
    }
}
