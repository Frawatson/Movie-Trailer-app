package DevOps.Mastery.Sapey.ReviewController;

import DevOps.Mastery.Sapey.Review.Review;
import DevOps.Mastery.Sapey.ReviewService.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
//allows application to be access via different http url
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "https://a838-2603-8080-a9f0-3cf0-50b8-8ebb-dd42-6d40.ngrok-free.app")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    //Creating the api call for review submission
    @PostMapping
    public ResponseEntity<Review> createReview (@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }

}
