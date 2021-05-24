package textbook.manual.stem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("http://ng-code.s3-website.us-east-2.amazonaws.com/")
@RestController
@RequestMapping("/stem")
public class stemController {

    @Autowired
    private stemService service;

    @PostMapping("/save")
    public STEM saveStem(@RequestBody STEM stem) {
        return service.saveStem(stem);
    }

    @GetMapping(value = "/getDesc")
    public String getDescription() {
        return service.getAll();
    }

}
