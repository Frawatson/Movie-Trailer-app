package DevOps.Mastery.Sapey.Model;


import java.util.List;
import java.util.Objects;

import DevOps.Mastery.Sapey.Review.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String posters;
    private List<String> genres;
    private List<String> backdrops;
    //Manual reference relationship
    @DocumentReference
    private List<Review> reviewIds;

}
