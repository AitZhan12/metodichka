package textbook.manual.books;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import textbook.manual.topics.TopicsService;

import javax.sql.ConnectionPoolDataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.stream.Stream;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private TopicsService topic;

    public Books store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Books books = new Books(fileName, file.getContentType(), file.getBytes(), topic.getTopicCategory(), topic.getTopicID());

        return booksRepository.save(books);
    }

    public Books getByID(Long id) {
        return booksRepository.findById(id).get();
    }

    public String delete(Long id) {
        booksRepository.deleteById(id);
        return "success";
    }

    public Stream<Books> getAll() {
        return booksRepository.findAll().stream();
    }

    public Books download(int categoryID, int topicID) {
        return booksRepository.downLoad(categoryID, topicID);
    }

    public Books downloadPptx(int categoryID, int topicID) {
        return booksRepository.downLoadPptx(categoryID, topicID);
    }


}
