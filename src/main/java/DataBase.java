import java.util.*;

public class DataBase {

    private static Map<Integer, Movie> movieMap = new HashMap<>();
    private static List<Actor> actorList = new ArrayList<>();
    private static List<Director> directorList = new ArrayList<>();
    private static List<Writer> writerList = new ArrayList<>();
    private static List<Genre> genreList = new ArrayList<>();
    private static List<String> titleList = new ArrayList<>();
    private static List<Double> ratingList = new ArrayList<>();
    private static List<String> descriptionList = new ArrayList<>();
    private static Set<Actor> movieActorSet = new HashSet<>();
    public static Set<Writer> movieWriterSet = new HashSet<>();
    public static Set<Genre> movieGenreSet = new HashSet<>();


    public static void fillUpDataBase() {
        addLists();
        addMovieMap();
        System.out.println(movieMap);


    }

    public static void addLists() {
        for (int i = 0; i < 15; i++) {
            actorList.add(new Actor(i, "Actor" + i));
            directorList.add(new Director(i, "Director" + i));
            writerList.add(new Writer(i, "Writer" + i));
            genreList.add(new Genre(i, "Genre" + i));
            titleList.add("Title" + i);
            ratingList.add(0.5 + i);
            descriptionList.add("Description" + i);
        }
    }

    public static void addInfoMovie() {
            for ( int x = 0; x < ((int) (Math.random() * 3)) + 1; x++) {
                movieActorSet.clear();
                movieGenreSet.clear();
                movieWriterSet.clear();
                movieActorSet.add(actorList.get((int) (Math.random() * 15)));
                movieWriterSet.add(writerList.get((int) (Math.random() * 15)));
                movieGenreSet.add(genreList.get((int) (Math.random() * 15)));
                System.out.println(movieActorSet);
            }
        }


    public static void addMovieMap() {
        for (int i = 0; i <5; i++) {
            addInfoMovie();
            movieMap.put(i, new Movie(i, titleList.get((int) (Math.random() * 15)), ratingList.get((int) (Math.random() * 15)),
                    actorList.get((int) (Math.random() * 15)), writerList.get((int) (Math.random() * 15)), genreList.get((int) (Math.random() * 15)), descriptionList.get((int) (Math.random() * 15)),
                    directorList.get((int) (Math.random() * 15))));}

    }

    public static Map<Integer, Movie> getMovieMap() {
        return movieMap;
    }

    public static List<Actor> getActorList() {
        return actorList;
    }

    public static List<Director> getDirectorList() {
        return directorList;
    }

    public static List<Writer> getWriterList() {
        return writerList;
    }

    public static List<Genre> getGenreList() {
        return genreList;
    }

    public static List<String> getTitleList() {
        return titleList;
    }

    public static List<Double> getRatingList() {
        return ratingList;
    }

    public static List<String> getDescriptionList() {
        return descriptionList;
    }

    public static Set<Actor> getMovieActorSet() {
        return movieActorSet;
    }

    public static Set<Writer> getMovieWriterSet() {
        return movieWriterSet;
    }

    public static Set<Genre> getMovieGenreSet() {
        return movieGenreSet;
    }

    public static void setMovieMap(Map<Integer, Movie> movieMap) {
        DataBase.movieMap = movieMap;
    }

    public static void setActorList(List<Actor> actorList) {
        DataBase.actorList = actorList;
    }

    public static void setDirectorList(List<Director> directorList) {
        DataBase.directorList = directorList;
    }

    public static void setWriterList(List<Writer> writerList) {
        DataBase.writerList = writerList;
    }

    public static void setGenreList(List<Genre> genreList) {
        DataBase.genreList = genreList;
    }

    public static void setTitleList(List<String> titleList) {
        DataBase.titleList = titleList;
    }

    public static void setRatingList(List<Double> ratingList) {
        DataBase.ratingList = ratingList;
    }

    public static void setDescriptionList(List<String> descriptionList) {
        DataBase.descriptionList = descriptionList;
    }

    public static void setMovieActorSet(Set<Actor> movieActorSet) {
        DataBase.movieActorSet = movieActorSet;
    }

    public static void setMovieWriterSet(Set<Writer> movieWriterSet) {
        DataBase.movieWriterSet = movieWriterSet;
    }

    public static void setMovieGenreSet(Set<Genre> movieGenreSet) {
        DataBase.movieGenreSet = movieGenreSet;
    }

    public static void showAllTitle() {
        System.out.println(titleList);
    }

    public static void showAllGenre() {
        System.out.println(genreList);
    }

    public static void showAllActor() {
        System.out.println(actorList);
    }

    public static void showAllWriter() {
        System.out.println(writerList);
    }

    public static void showAllDirector() {
        System.out.println(directorList);
    }


}






