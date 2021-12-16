import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Director {

    private static int id;
    String name;

    public Director(String name) {
        this.name = name;
    }

    public Director(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public static Director getDirectorById(int selectDirectorId) {
        return new Director(selectDirectorId,"Genre"+selectDirectorId);
    }
    public  static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return id == director.id && Objects.equals(name, director.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
