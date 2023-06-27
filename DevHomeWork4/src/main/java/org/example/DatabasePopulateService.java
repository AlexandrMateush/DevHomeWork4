package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String sqlFile = "sql/populate_db.sql";
        String sqlContent = readFileContent(sqlFile);

        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlContent);
            System.out.println("Database populated successfully.");
        } catch (SQLException e) {
            System.out.println("Error populating database: " + e.getMessage());
        }
    }

    private static String readFileContent(String filePath) {
        try {
            Path path = Paths.get(filePath);
            byte[] bytes = Files.readAllBytes(path);
            return new String(bytes);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return "";
        }
    }
}

