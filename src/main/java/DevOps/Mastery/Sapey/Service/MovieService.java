package DevOps.Mastery.Sapey.Service;

import DevOps.Mastery.Sapey.Model.Movie;
import DevOps.Mastery.Sapey.Repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

//    public Optional<Movie> getMovieBYId(ObjectId id){
//        return movieRepository.findById(id);
//    }

    public Optional<Movie> getMovieByImdbId(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
