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
    private final Database database;

    public DatabaseQueryService(Database database) {
        this.database = database;
    }
    public List<LongestProjectDuration> findLongestProjectDuration() {
        List<LongestProjectDuration> longestProjectDurations = new ArrayList<>();


        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT PROJECT.NAME, DATEDIFF(PROJECT.END_DATE, PROJECT.START_DATE) AS DURATION " +
                     "FROM PROJECT " +
                     "WHERE DATEDIFF(PROJECT.END_DATE, PROJECT.START_DATE) = (SELECT MAX(DATEDIFF(PROJECT.END_DATE, PROJECT.START_DATE)) FROM PROJECT)")) {

            while (resultSet.next()) {
                String projectName = resultSet.getString("NAME");
                int duration = resultSet.getInt("DURATION");
                LongestProjectDuration projectDuration = new LongestProjectDuration(projectName, duration);
                longestProjectDurations.add(projectDuration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return longestProjectDurations;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker(){
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();

        try(Connection connection = database.getConnection();
        Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM find_max_salary_worker";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String name = resultSet.getString("NAME");
                int salary = resultSet.getInt("SALARY");


                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker(name, salary);
                maxSalaryWorkers.add(maxSalaryWorker);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return maxSalaryWorkers;
    }

    public List<YoungestEldestWorker> findYoungestWorkers() {
        List<YoungestEldestWorker> youngestWorkers = new ArrayList<>();

        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM find_youngest_eldest_workers WHERE TYPE = 'YOUNGEST'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String birthday = resultSet.getString("BIRTHDAY");

                YoungestEldestWorker youngestWorker = new YoungestEldestWorker("YOUNGEST", name, birthday);
                youngestWorkers.add(youngestWorker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return youngestWorkers;
    }

    public List<YoungestEldestWorker> findEldestWorkers() {
        List<YoungestEldestWorker> eldestWorkers = new ArrayList<>();

        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM find_youngest_eldest_workers WHERE TYPE = 'ELDEST'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String birthday = resultSet.getString("BIRTHDAY");

                YoungestEldestWorker eldestWorker = new YoungestEldestWorker("ELDEST", name, birthday);
                eldestWorkers.add(eldestWorker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eldestWorkers;
    }

    public List<ProjectPrice> printProjectPrices() {
        List<ProjectPrice> projectPrices = new ArrayList<>();

        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM print_project_prices";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int price = resultSet.getInt("PRICE");

                ProjectPrice projectPrice = new ProjectPrice(name, price);
                projectPrices.add(projectPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectPrices;
    }

}

