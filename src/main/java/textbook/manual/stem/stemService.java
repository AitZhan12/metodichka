package textbook.manual.stem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class stemService {

    @Autowired
    private stemRepo stem;

    public STEM saveStem(STEM s) {
        return stem.save(s);
    }

    public String getAll() {
        return stem.getDesc();
    }
}
