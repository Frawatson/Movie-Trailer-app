package DevOps.Mastery.Sapey.ReviewService;

import DevOps.Mastery.Sapey.Model.Movie;
import DevOps.Mastery.Sapey.Review.Review;
import DevOps.Mastery.Sapey.ReviewRepository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    //mongo db template to update the review
    @Autowired
    private MongoTemplate mongoTemplate;

    //updating the review array with new updates based on the imdbid match
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }

    //backend is completed for now, willl connect once front end is done!!!
}
