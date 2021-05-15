package textbook.manual.informatics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/informatics")
public class InformaticsController {

    @Autowired
    private InformaticsService service;

    @PostMapping("save")
    public Informatics save(@RequestBody Informatics informatics) {
        return service.save(informatics);
    }

    @GetMapping("grade/{id}")
    public List<Informatics> getByGrade(@PathVariable(value = "id")  int id) {
        return service.getByGrade(id);
    }
}
