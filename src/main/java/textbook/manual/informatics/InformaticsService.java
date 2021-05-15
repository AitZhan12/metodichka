package textbook.manual.informatics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformaticsService {

    @Autowired
    private InformaticsRepository repository;

    public Informatics save(Informatics informatics) {
        return repository.save(informatics);
    }

    public List<Informatics> getAll() {
        return repository.findAll();
    }

    public Optional<Informatics> getById(Long id ) {
        return repository.findById(id);
    }

    public void  deleteById(Long id) {
        if (getById(id).isPresent()) {
            repository.deleteById(id);
        }
    }

    public List<Informatics> getByGrade(int grade) {
        return repository.getByGrade(grade);
    }
}
