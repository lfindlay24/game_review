package gamers.inc.game_review;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/review")
public class RestReviewController {

    private final BusinessLayer bs = new BusinessLayer();

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
            return "Welcome to my Diary Application";
        }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public void createMessage(@RequestBody Map<String, Object> review) {
        try {
            bs.addReview(review);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//        @RequestMapping(path = "", method = RequestMethod.GET)
//        public ArrayList<Entry> findAllMessages() {
//        }

}
