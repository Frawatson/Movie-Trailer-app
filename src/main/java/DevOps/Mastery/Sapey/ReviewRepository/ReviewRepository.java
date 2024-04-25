package DevOps.Mastery.Sapey.ReviewRepository;

import DevOps.Mastery.Sapey.Review.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
