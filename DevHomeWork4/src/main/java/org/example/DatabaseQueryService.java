package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String sqlFile = "sql/find_max_projects_client.sql";
        String sqlContent = readFileContent(sqlFile);

        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlContent)) {

            List<MaxProjectCountClient> clients = new ArrayList<>();

            while (rs.next()) {
                String name = rs.getString("name");
                int projectCount = rs.getInt("projectCount");
                MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                clients.add(client);
            }

            return clients;
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }



    public List<LongestProjectDuration> findLongestProjectDuration() {

        String sqlFile = "sql/find_longest_project.sql";
        String sqlContent = readFileContent(sqlFile);


        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlContent)) {

            List<LongestProjectDuration> clients = new ArrayList<>();

            while (rs.next()) {
                String name = rs.getString("ID");
                int duration = rs.getInt("TIMESTAMPDIFF");
                LongestProjectDuration client = new LongestProjectDuration(name, duration);
                clients.add(client);
            }

            return clients;
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<MaxSalaryWorker> findMaxSalaryWorkers() {

        String sqlFile = "sql/find_max_salary_worker.sql";
        String sqlContent = readFileContent(sqlFile);


        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlContent)) {

            List<MaxSalaryWorker> workers = new ArrayList<>();

            while (rs.next()) {
                String name = rs.getString("NAME");
                int salary = rs.getInt("SALARY");
                MaxSalaryWorker worker = new MaxSalaryWorker(name, salary);
                workers.add(worker);
            }

            return workers;
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {
        String sqlFile = "sql/find_youngest_eldest_workers.sql";
        String sqlContent = readFileContent(sqlFile);


        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlContent)) {

            List<YoungestEldestWorker> workers = new ArrayList<>();

            while (rs.next()) {
                String type = rs.getNString("TYPE");
                String name = rs.getString("NAME");
                String birthday = rs.getString("BIRTHDAY");

                YoungestEldestWorker worker = new YoungestEldestWorker(type, name, birthday);
                workers.add(worker);
            }

            return workers;
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
        }
    }


    public List<ProjectPrice> printProjectPrices() {
        String sqlFile = "sql/print_project_prices.sql";
        String sqlContent = readFileContent(sqlFile);


        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlContent)) {

            List<ProjectPrice> projectPrices = new ArrayList<>();

            while (rs.next()) {
                String id = rs.getString("ID");
                int price = rs.getInt("PRICE");

                ProjectPrice projectPrice = new ProjectPrice(id, price);
                projectPrices.add(projectPrice);
            }
            return projectPrices;
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
            return new ArrayList<>();
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

