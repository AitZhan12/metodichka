package textbook.manual.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import textbook.manual.books.Books;

import java.awt.print.Book;
import java.util.List;

@Service
public class TopicsService {

    @Autowired
    private TopicsRepo topicsRepo;

    public List<Topics> getByCategory(int category) {
        return topicsRepo.getByCategory(category);
    }

    public Topics saveIt(Topics topics) {
        return topicsRepo.save(topics);
    }

    public List<Topics> getAll() {
        return topicsRepo.findAll();
    }

    public String getThesis(int category, int id) {
        return topicsRepo.getThesis(category, id);
    }

    public int getTopicID() {
        return topicsRepo.getTopicID();
    }

    public int getTopicCategory() {
       return topicsRepo.getTopicCategory();
    }

}
