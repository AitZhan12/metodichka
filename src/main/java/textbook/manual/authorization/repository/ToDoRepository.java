package textbook.manual.authorization.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import textbook.manual.authorization.models.dtos.entities.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    Page<ToDo> findAll(Pageable pageable);
}
