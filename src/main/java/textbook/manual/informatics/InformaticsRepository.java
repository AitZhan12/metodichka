package textbook.manual.informatics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface InformaticsRepository extends JpaRepository<Informatics, Long> {

    @Query(value = "SELECT * FROM informatics i " +
            "JOIN books b ON b.grade = i.grade" +
            "WHERE i.grade=1?", nativeQuery = true)
    List<Informatics> getByGrade(int grade);
}
