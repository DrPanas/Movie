import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Scanner;
//
//public class DBHandler extends TestConnection{
//    private static Connection connection;
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static int addActor(Actor actor) throws SQLException {
//        String sqlCommand = String.format("INSERT INTO %s (%s) VALUES ('%s')",
//                Const.TABLE_ACTORS, Const.COLUMN_ACTORS_NAME, actor.getName());
//        return insertInto(sqlCommand);
//    }
//
//    private static int insertInto(String sqlCommand) throws SQLException {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(sqlCommand);
//
//            ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID() AS id");
//
//            resultSet.first();
//            return resultSet.getInt("id");
//        }
//    }
//}
//