package textbook.manual.books;

import java.util.HashMap;
import java.util.Map;

public enum BookTypeEnum {

    Programming(1, "Programming"),
    Engineering(2, "Engineering"),
    Modeling(3, "Modeling"),
    Robotics(4, "Robotics");

    private final int id;
    private final String name;
    private static final Map<Integer, BookTypeEnum> idToEnum = new HashMap<>();

    BookTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    static {
        for(BookTypeEnum value : values()){
            idToEnum.put(value.id, value);
        }
    }

    public static BookTypeEnum fromID(int id) {
        return idToEnum.get(id);
    }
}
