import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;


public class TestConnection {

    private static final String USER_NAME = "root";
    private static final String PASSWORD = "otorinolaringolog";
    private static final String URL = "jdbc:mysql://localhost:3306/Movie?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static Statement statement;
    private static Connection connection;
    private static ResultSet resultSet;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        TestConnection.createConnection();

        for (int i = 4; i < 10; i++) {

            TestConnection.addMovie(new Movie("Title"+i, 1.5+i, Actor.getActorById(i), Writer.getWriterById(i),
                    Genre.getGenreById(i), "Description"+i, Director.getDirectorById(i)));
        }
        TestConnection.showAllMovies();
        TestConnection.closeConnection();
    }

    public static int addActor(Actor actor) throws SQLException {
        statement = connection.createStatement();
        String sqlQuery = String.format("INSERT INTO %s (%s,%s) VALUES (%d,'%s')",
                Const.TABLE_ACTORS, Const.COLUMN_ACTORS_ID, Const.COLUMN_ACTORS_NAME, actor.getId(), actor.getName());
//        int Actors = statement.executeUpdate("INSERT Actor(idActor,nameActor) VALUES (actor.getId,actor.getName())");
//        System.out.printf("Added %d Actors", Actors);
        statement.executeUpdate(sqlQuery);
        ResultSet rsActor = statement.executeQuery("SELECT LAST_INSERT_ID() AS id");
        rsActor.first();
        return rsActor.getInt("id");
    }


    public static void test() throws SQLException {
        statement = connection.createStatement();
        System.out.println("Inter Id Actor:");
        int selectId = scanner.nextInt();
        String sql = String.format("SELECT*FROM %s WHERE %s=%d", Const.TABLE_ACTORS, Const.COLUMN_ACTORS_ID, selectId);
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }

    }

    public static void addDirector() throws SQLException {
        statement = connection.createStatement();
        int Directors = statement.executeUpdate("INSERT Director(idDirector,nameDirector) VALUES (1,'Director1'),(2,'Director2'),(3,'Director3'),(4,'Director4'),(5,'Director5'),(6,'Director6'),(7,'Director7'),(8,'Director8'),(9,'Director9'),(10,'Director10')");
        System.out.printf("Added %d Directors", Directors);
    }

    public static void addWhiter() throws SQLException {
        statement = connection.createStatement();
        int Writers = statement.executeUpdate("INSERT Writer(idWriter,nameWriter) VALUES (1,'Writer1'),(2,'Writer2'),(3,'Writer3'),(4,'Whiter4'),(5,'Writer5'),(6,'Writer6'),(7,'Writer7'),(8,'Writer8'),(9,'Writer9'),(10,'Writer10')");
        System.out.printf("Added %d Writers", Writers);
    }

    public static void addGenre() throws SQLException {
        statement = connection.createStatement();
        int Genres = statement.executeUpdate("INSERT Genre(idGenre,nameGenre) VALUES (1,'Genre1'),(2,'Genre2'),(3,'Genre3'),(4,'Genre4'),(5,'Genre5'),(6,'Genre6'),(7,'Genre7'),(8,'Genre8'),(9,'Genre9'),(10,'Genre10')");
        System.out.printf("Added %d Genres", Genres);
    }

    public static void addMovie(Movie movie) throws SQLException {
        statement = connection.createStatement();
        String sqlQuery = String.format(Locale.US, "INSERT INTO %s (%s,%s,%s,%s,%s,%s,%s) " +
                        "VALUES ('%s',%f,%d,%d,%d,'%s',%d)",
                Const.TABLE_MOVIES,
                Const.COLUMN_MOVIE_TITLE, Const.COLUMN_MOVIE_RATING,
                Const.COLUMN_MOVIE_ACTOR, Const.COLUMN_MOVIE_WRITER, Const.COLUMN_MOVIE_GENRE,
                Const.COLUMN_MOVIE_DESCRIPTION, Const.COLUMN_MOVIE_DIRECTOR,
                Movie.getTitle(), Movie.getRating(), Actor.getId(), Writer.getId(), Genre.getId(),
                Movie.getDiscription(), Director.getId());
        System.out.println(sqlQuery);
        statement.executeUpdate(sqlQuery);
    }

    public static void showAllActors() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT*FROM Actor");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
    }

    public static void showAllDirectors() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT*FROM Director");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
    }

    public static void showAllWriters() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT*FROM Writer");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
    }


    public static void showAllMovies() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT*FROM Movie");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        }
    }

    public static void createConnection() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

    public static void closeConnection() throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
        }
    }

    public static void selectGenreSQL() throws SQLException {
        Statement statement = connection.createStatement();
        System.out.println("Please,select movie genre:");
        ResultSet allGenre = statement.executeQuery("SELECT * FROM " + Const.TABLE_GENRES);
        while (allGenre.next()) {
            System.out.println(allGenre.getString(1));
            System.out.println(allGenre.getString(2));
        }
//        int selectGenreId = scanner.nextInt();
//        String sqlQuery = String.format("SELECT * FROM %s WHERE %s = %d",
//                Const.TABLE_MOVIES, Const.COLUMN_GENRES_ID, selectGenreId);
//        System.out.println(sqlQuery);
    }
    // public static void selectActorSQL() throws SQLException {
    //       System.out.println("Please,select movie Actor:");
//        ResultSet allActor = statement.executeQuery("SELECT * FROM " + Const.TABLE_ACTORS);
//        System.out.println(allActor);
//        showAllActors();
//        statement = connection.createStatement();
//        int selectActorId = scanner.nextInt();
//        String sqlQuery = String.format("SELECT * FROM %s WHERE %s = %d",
//                Const.TABLE_MOVIES, Const.COLUMN_ACTORS_ID, selectActorId);
//        ResultSet selectActor = statement.executeQuery(sqlQuery);
//        while (selectActor.next()) {
//            System.out.println(selectActor.getString(2));
//        }
//    }


//    public static void selectWriterSQL() throws SQLException {
//        System.out.println("Please,select movie Writer:");
//        ResultSet allWriter = statement.executeQuery("SELECT * FROM " + Const.TABLE_WRITERS);
//        System.out.println(allWriter);
//        int selectWriterId = scanner.nextInt();
//        String sqlQuery = String.format("SELECT * FROM %s WHERE %s = %d",
//                Const.TABLE_MOVIES, Const.COLUMN_ACTORS_ID, selectWriterId);
//        System.out.println(sqlQuery);
//    }
//
//    public static void selectDirectorSQL() throws SQLException {
//        System.out.println("Please,select movie Director:");
//        ResultSet allDirector = statement.executeQuery("SELECT * FROM " + Const.TABLE_DIRECTORS);
//        System.out.println(allDirector);
//        int selectDirectorId = scanner.nextInt();
//        String sqlQuery = String.format("SELECT * FROM %s WHERE %s = %d",
//                Const.TABLE_MOVIES, Const.COLUMN_ACTORS_ID, selectDirectorId);
//        System.out.println(sqlQuery);
//    }


//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        String sqlQuery = "select idActor,nameActor from Actor";
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(sqlQuery);
//            while (resultSet.next()) {
//                int idActor = resultSet.getInt(1);
//                String nameActor = resultSet.getString(2);
//                System.out.printf("idActor:%d,nameActor:%s", idActor, nameActor);
//            }
//        } catch (SQLException | NoSuchMethodException sqlEx) {
//            sqlEx.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException se) {/*cant do anything*/}
//            try {
//                if (connection != null) {
//                    statement.close();
//                }
//            } catch (SQLException se) {/*cant do anything*/}
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//            } catch (SQLException se) {/*cant do anything*/}
//
//
//        }
//    }
}




