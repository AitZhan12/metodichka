package textbook.manual.topics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import textbook.manual.books.Books;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface TopicsRepo extends JpaRepository<Topics, Long> {

    @Query(value = "SELECT * from topics where category=?1", nativeQuery = true)
    List<Topics> getByCategory(int category);

    @Query(value = "SELECT thesis from topics where category=?1 and id=?2", nativeQuery = true)
    String getThesis(int category, int id);

    @Query(value = "SELECT id from topics order by id desc limit 1", nativeQuery = true)
    int getTopicID();

    @Query(value = "SELECT category from topics order by id desc limit 1", nativeQuery = true)
    int getTopicCategory();

}
