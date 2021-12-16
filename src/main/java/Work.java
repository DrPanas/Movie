import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Work {
    public static Scanner scanner = new Scanner(System.in);


    public static void work() {

        System.out.println("Please,select option: 1-search by genre 2-search actor 3-search by director 4-search by writer");
        int selectOption = scanner.nextInt();

        switch (selectOption) {
            case 1:
                selectGenre();
                break;
            case 2:
                selectActor();
                break;
            case 3:
                selectDirector();
                break;
            case 4:
                selectWriter();
            default:
                System.exit(-1);
        }
    }


    public static void selectGenre() {
        System.out.println("Please,select movie genre:");
        DataBase.showAllGenre();
        int selectGenreId = scanner.nextInt();
        Genre selectGenre = Genre.getGenreById(selectGenreId);

        for (Map.Entry<Integer, Movie> entry : DataBase.getMovieMap().entrySet()) {
            Movie currentMovie = entry.getValue();
            if (currentMovie.getGenre().getId()==selectGenreId) {
                System.out.println("Название: " + currentMovie.getTitle());
                System.out.printf("Рейтинг: %.1f \n", currentMovie.getRating());
                System.out.println("Актеры: " + currentMovie.getActor());
                System.out.println("Сценаристы: " + currentMovie.getWriter());
                System.out.println("Жанры: " + currentMovie.getGenre());
                System.out.println("Описание: " + currentMovie.getDescription());
                System.out.println("Режисер: " + currentMovie.getDirector());
                System.out.println("");
            }
        }
    }


    public static void selectActor() {
        System.out.println("Please,select Actor:");
        DataBase.showAllActor();
        int selectActorId = scanner.nextInt();
        Actor selectActor = Actor.getActorById(selectActorId);

        for (Map.Entry<Integer, Movie> entry : DataBase.getMovieMap().entrySet()) {
            Movie currentMovie = entry.getValue();
            if (currentMovie.getActor().getId()==selectActorId) {
                System.out.println("Название: " + currentMovie.getTitle());
                System.out.printf("Рейтинг: %.1f \n", currentMovie.getRating());
                System.out.println("Актеры: " + currentMovie.getActor());
                System.out.println("Сценаристы: " + currentMovie.getWriter());
                System.out.println("Жанры: " + currentMovie.getGenre());
                System.out.println("Описание: " + currentMovie.getDescription());
                System.out.println("Режисер: " + currentMovie.getDirector());
                System.out.println("");
            }
        }
    }

    public static void selectDirector() {
        System.out.println("Please,select movie Director:");
        DataBase.showAllDirector();
        int selectDirectorId = scanner.nextInt();
        for (Map.Entry<Integer, Movie> entry : DataBase.getMovieMap().entrySet()) {
            Movie currentMovie = entry.getValue();
            if (currentMovie.getDirector().getId() == selectDirectorId) {
                System.out.println("Название: " + currentMovie.getTitle());
                System.out.printf("Рейтинг: %.1f \n", currentMovie.getRating());
                System.out.println("Актеры: " + currentMovie.getActor());
                System.out.println("Сценаристы: " + currentMovie.getWriter());
                System.out.println("Жанры: " + currentMovie.getGenre());
                System.out.println("Описание: " + currentMovie.getDescription());
                System.out.println("Режисер: " + currentMovie.getDirector());
                System.out.println("");
            }
        }
    }

    public static void selectWriter() {
        System.out.println("Please,select movie Writer:");
        DataBase.showAllWriter();
        int selectWriterId = scanner.nextInt();
        Writer selectWriter = Writer.getWriterById(selectWriterId);
        for (Map.Entry<Integer, Movie> entry : DataBase.getMovieMap().entrySet()) {
            Movie currentMovie = entry.getValue();
            if (currentMovie.getWriter().getId()==selectWriterId) {
                System.out.println("Название: " + currentMovie.getTitle());
                System.out.printf("Рейтинг: %.1f \n", currentMovie.getRating());
                System.out.println("Актеры: " + currentMovie.getActor());
                System.out.println("Сценаристы: " + currentMovie.getWriter());
                System.out.println("Жанры: " + currentMovie.getGenre());
                System.out.println("Описание: " + currentMovie.getDescription());
                System.out.println("Режисер: " + currentMovie.getDirector());
                System.out.println("");
            }
        }
    }
}

