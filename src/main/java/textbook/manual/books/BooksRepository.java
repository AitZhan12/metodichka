package textbook.manual.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    @Query(value = "SELECT * from books where categoryid =?1 and topicid = ?2 and type like '%pdf%'", nativeQuery = true)
    Books downLoad(int categoryID, int topicId);

    @Query(value = "SELECT * from books where categoryid =?1 and topicid = ?2 and type like '%pptx%'", nativeQuery = true)
    Books downLoadPptx(int categoryID, int topicId);
}
