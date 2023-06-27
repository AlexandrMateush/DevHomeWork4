package util;

import org.example.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseTest {

    @Test
    public void testConnection() {
        Connection connection = Database.getInstance().getConnection();
        Assertions.assertNotNull(connection);

        try {
            Assertions.assertTrue(connection.isValid(5));
        } catch (SQLException e) {
            Assertions.fail("З'єднання з базою даних не є валідним: " + e.getMessage());
        }
    }
}
