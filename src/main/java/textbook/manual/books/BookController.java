package textbook.manual.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import textbook.manual.topics.TopicsService;

import java.util.List;

import java.util.stream.Collectors;

//@CrossOrigin("http://ng-code.s3-website.us-east-2.amazonaws.com/")
@RestController
@RequestMapping("/file")
public class BookController {

    @Autowired
    private BooksService book;



    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        try {
            book.store(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("download")
    public ResponseEntity<List<ResponseFile>> getAllFiles() {
        List<ResponseFile> files = book.getAll()
                .map(File -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/file/download/")
                    .path(String.valueOf(File.getId()))
                    .toUriString();
                    return new ResponseFile(
                            File.getFileName(),
                            fileDownloadUri,
                            File.getType(),
                            File.getData().length,
                            File.getId());
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("download/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable(value = "id") Long id) {
        Books file = book.getByID(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(file.getData());
    }

    @DeleteMapping("/{id}")
    public String deleteFile(@PathVariable(value = "id") Long id) {
        return book.delete(id);
    }

//    @CrossOrigin("http://localhost:4200")
    @GetMapping("/download/{categoryID}/{topicID}")
    public ResponseEntity<byte[]> getFile(@PathVariable(value = "categoryID") int categoryID,
                                          @PathVariable(value = "topicID") int topicID) {
        Books file = book.download(categoryID, topicID);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(file.getData().length)
                .body(file.getData());
    }

    @GetMapping("/download/pptx/{categoryID}/{topicID}")
    public ResponseEntity<byte[]> getPptxFile(@PathVariable(value = "categoryID") int categoryID,
                                          @PathVariable(value = "topicID") int topicID) {
        Books file = book.downloadPptx(categoryID, topicID);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(file.getData());
    }
}
