package textbook.manual.stem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface stemRepo extends JpaRepository<STEM, Long> {

    @Query(value = "select description from stem where id = (select max(id) from stem)", nativeQuery = true)
    String getDesc();


}
