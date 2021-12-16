import java.util.Objects;

public class Writer {

    private static int id;
    private String name;

    public Writer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Writer(String name) {
        this.name = name;
    }

    public static Writer getWriterById(int selectWriterId) {
        return new Writer(selectWriterId,"Writer"+selectWriterId);
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Writer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return id == writer.id && Objects.equals(name, writer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
