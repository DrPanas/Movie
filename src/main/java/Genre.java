import java.util.Objects;

public class Genre {

    private static  int id;
    private  String genre;

    public Genre(int id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public static  int getId() {
        return id;
    }

    public static Genre getGenreById(int selectGenreId) {
        return new Genre(selectGenreId,"Genre"+selectGenreId);
    }

    public String getGenre() {
        return genre;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre1 = (Genre) o;
        return id == genre1.id && Objects.equals(genre, genre1.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genre);
    }
}
