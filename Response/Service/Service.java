package Service;

import java.sql.*;
import Model.Model;

public class Service {
    String DBurl = "jdbc:mysql://localhost/recruit_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String DBusername = "root";
    String DBpassword = "";

    static protected Connection conn;
    Statement statement;

    public Service() {
       getConnection();
    }

    public void getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Connection Success");
        } catch (Exception ex) {
            System.out.println("Connection Failed " + ex.getMessage());
        }
    }

    public void readData(){
        for (int i = 0; i < Model.listRecruit.length; i++) {
            Model.listRecruit[i] = null; 
        }
        try {
            String query = "SELECT * FROM recruitment";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int totalData = 0;
            while (resultSet.next()) {
                Model.listRecruit[totalData] = new Model(resultSet.getString("name"), resultSet.getString("path"), resultSet.getInt("writing"), resultSet.getInt("coding"), resultSet.getInt("interview"), resultSet.getInt("score"), resultSet.getString("status"));
                totalData++;
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("SQL Error" + e.getMessage());
        }
    }

    public void addButton(String name, String path, int writing, int coding, int interview){
        double average = 0;

        if(path.equals("Android Developer")){
            average += writing * 0.2;
            average += coding * 0.5;
            average += interview * 0.5;
        }else {
            average += writing * 0.4;
            average += coding * 0.35;
            average += interview * 0.25;
        }

        String pass;
        if(average >= 85){
            pass = "Passed";
        } else {
            pass = "Failed";
        }

        try {

            String query = "INSERT INTO `recruitment` (`name`, `path`, `writing`, `coding`, `interview`, `score`, `status`) VALUES ('" + name + "', '" + path + "', '" + writing + "', '" + coding + "', '" + interview + "', '" + average + "', '" + pass + "')";

            statement = conn.createStatement();
            statement.executeUpdate(query);

            System.out.println("Input Success");
        } catch (Exception ex) {
            System.out.println("Input Failed " + ex.getMessage());
        }
    }

    public void deleteData(String name) {
        try {
            String query = "DELETE FROM `recruitment` WHERE name='" + name + "'";
    
            statement = conn.createStatement();
            statement.executeUpdate(query);
    
            System.out.println("Delete Success");
        } catch (Exception ex) {
            System.out.println("Delete Failed : " + ex.getMessage());
        }
    }

    public void updateData(String oldName, String name, String path, int writing, int coding, int interview) {

        double average = 0;

        if(path.equals("Android Developer")){
            average += writing * 0.2;
            average += coding * 0.5;
            average += interview * 0.5;
        }else {
            average += writing * 0.4;
            average += coding * 0.35;
            average += interview * 0.25;
        }

        String pass;
        
        if(average >= 85){
            pass = "Passed";
        } else {
            pass = "Failed";
        }
        try {
            String query = "UPDATE student SET name=?, path=?, writing=?, coding=?, interview=?, status=? WHERE name=?";
    
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, path);
            preparedStatement.setInt(3, writing);
            preparedStatement.setInt(4, coding);
            preparedStatement.setInt(5, interview);
            preparedStatement.setString(6, pass);
            preparedStatement.setString(7, oldName);

            preparedStatement.executeUpdate();
    
            System.out.println("Update Success");
        } catch (SQLException ex) {
            System.out.println("Update Failed : " + ex.getMessage());
        }
    }
}
