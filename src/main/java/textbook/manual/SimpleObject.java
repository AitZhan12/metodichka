package textbook.manual;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SimpleObject {
    public String name;
    public int id;

    public String toString() {
        return "{id: " + this.id + ", name: '" + this.name + "'}";
    }

    public int compareTo(Object o) {
        if (o == null) {
            return 1;

        } else if (!(o instanceof  SimpleObject)) {
            return 1;
        } else {
            return this.name == null ? -1 : this.name.compareTo(((SimpleObject)o).name);
        }
    }

    public boolean equals(Object obj) {
        return obj instanceof SimpleObject && ((SimpleObject)obj).id == this.id;
    }
}
