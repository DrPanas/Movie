import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Movie {

    private static  int id;
    private static String title;
    private static double rating;
    private static Actor actor;
    private static Writer writer;
    private static Genre genre;
    private static String description;
    private static Director director;

    public Movie(int id, String title, double rating, Actor actor, Writer writer, Genre genre, String description, Director director) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.actor = actor;
        this.writer = writer;
        this.genre = genre;
        this.description = description;
        this.director = director;
    }

    public Movie(String title, double rating, Actor actor, Writer writer, Genre genre, String description, Director director){
        this.title = title;
        this.rating = rating;
        this.actor = actor;
        this.writer = writer;
        this.genre = genre;
        this.description = description;
        this.director = director;
    }

    public static int getId() {
        return id;
    }

    public static String getDiscription() {
        return description;
    }

    public static String getTitle() {
        return title;
    }

    public static double getRating() {
        return rating;
    }

    public Actor getActor() {
        return actor;
    }

    public Writer getWriter() {
        return writer;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public static Director getDirector() {
        return director;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", actor=" + actor +
                ", writer=" + writer +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                ", director=" + director +
                '}';
    }
}