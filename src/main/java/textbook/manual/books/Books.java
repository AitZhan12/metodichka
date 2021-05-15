package textbook.manual.books;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fileName;
    private String type;
    @Lob
    private byte[] data;
    private int categoryID;
    private int topicID;

    public Books() {

    }
    public Books(String fileName, String type, byte[] data, int categoryID, int topicID) {
        this.fileName = fileName;
        this.type = type;
        this.data = data;
        this.categoryID = categoryID;
        this.topicID = topicID;
    }


}
