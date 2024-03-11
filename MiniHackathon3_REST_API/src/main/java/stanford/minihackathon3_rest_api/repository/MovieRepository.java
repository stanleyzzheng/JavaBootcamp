package stanford.minihackathon3_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stanford.minihackathon3_rest_api.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
