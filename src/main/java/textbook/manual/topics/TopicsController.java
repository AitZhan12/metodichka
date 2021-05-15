package textbook.manual.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import textbook.manual.SimpleObject;
import textbook.manual.books.Books;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("topics")
public class TopicsController {

    @Autowired
    private TopicsService service;

    @GetMapping("/category/{id}")
    public List<Topics> getByCategory(@PathVariable(value = "id") int id) {
        return service.getByCategory(id);
    }

    @GetMapping("/all")
    public List<Topics> getAll() {
        return service.getAll();
    }

    @PostMapping("/save")
    public Topics store(@RequestBody Topics t) {
        return service.saveIt(t);
    }

    @GetMapping("/thesis/{categoryId}/{id}")
    public String getThesis(@PathVariable(value = "categoryId") int categoryId,
                            @PathVariable(value = "id") int id) {
        return service.getThesis(categoryId, id);
    }
}
