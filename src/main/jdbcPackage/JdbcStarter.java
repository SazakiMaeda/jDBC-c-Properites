package main.jdbcPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStarter {
    public static void main(String[] args) throws SQLException {
        String SQL = """
                SELECT * FROM test.FUCK;
                """;

        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement();
        ) {
            var ResoutSet = statement.executeQuery(SQL);
            System.out.println(ResoutSet);

            while (ResoutSet.next()) {
                System.out.println(ResoutSet.getInt("id"));
                System.out.println(ResoutSet.getString("name"));
                System.out.println("______");
            }
        }
    }
}
