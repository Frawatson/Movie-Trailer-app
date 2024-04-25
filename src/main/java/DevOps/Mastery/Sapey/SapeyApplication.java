package DevOps.Mastery.Sapey;

 import DevOps.Mastery.Sapey.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EntityScan ("DevOps.Mastery.Sapey.*")
//@RestController
public class SapeyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SapeyApplication.class, args);
	}


}
