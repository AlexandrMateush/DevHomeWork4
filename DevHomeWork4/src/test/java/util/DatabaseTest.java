package util;

import org.example.Database;
import org.example.DatabaseQueryService;
import org.example.MaxProjectCountClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    @Test
    public void testConnection() {
        Connection connection = Database.getInstance().getConnection();
        assertNotNull(connection);

        try {
            assertTrue(connection.isValid(5));
        } catch (SQLException e) {
            Assertions.fail("З'єднання з базою даних не є валідним: " + e.getMessage());
        }
    }
}

