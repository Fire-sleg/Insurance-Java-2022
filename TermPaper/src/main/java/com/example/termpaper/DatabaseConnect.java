package com.example.termpaper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;

public class DatabaseConnect {
    private static int id_user;
    private static int id_insurance;
    private static int id_casco;
    private static int id_motor_liability;
    private static int id_green_card;
    public int logIn(String email, String password)
    {
        id_user=0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT * FROM dbo.Log_in_data\n" +
                    "WHERE Log_in_data.email = "+email+ "and Log_in_data.password = "+password;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                id_user = Integer.parseInt(resultSet.getString(1));
                System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id_user;

    }
    public int register(String name,
                        String surname,
                        String middleName,
                        String city,
                        String street,
                        int house,
                        int apartment,
                        String TIN,
                        String email,
                        String phoneNumber,
                        String password1)
    {
        int id=0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT TOP(1) id_insured FROM dbo.Data_of_insured\n" +
                    "ORDER BY id_insured desc";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                id = Integer.parseInt(resultSet.getString(1));
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            id++;
            SqlQuery = "INSERT INTO dbo.Data_of_insured\n" +
                    "VALUES('"+id+"','"+name+"','"+surname+"','"+middleName+"','"+
                    city+"','"+street+"','"+house+"','"+apartment+"','"+TIN+"','"+email+"','"+phoneNumber+"','"+password1+"');";
            resultSet = statement.executeQuery(SqlQuery);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id;

    }
    public int temp(String email, String password1)
    {
        id_user=0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT TOP(1) id_insured FROM dbo.Data_of_insured\n" +
                    "ORDER BY id_insured desc";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                id_user = Integer.parseInt(resultSet.getString(1));
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            //id_user++;
            SqlQuery = "INSERT INTO dbo.Log_in_data\n" +
                    "VALUES('"+id_user+"','"+email+"','"+password1+"');";
            resultSet = statement.executeQuery(SqlQuery);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id_user;
    }
    public int risks(int[] riskArr, int levelOfRisk)
    {
        /*id_user=0;*/
        id_insurance=0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT TOP(1) id_insurance FROM dbo.Risks\n" +
                    "ORDER BY id_insurance desc";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                id_insurance = Integer.parseInt(resultSet.getString(1));
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            id_insurance++;
            SqlQuery = "INSERT INTO dbo.Risks\n" +
                    "VALUES('"+id_insurance+"','"+riskArr[0]+"','"+riskArr[1]+"','"+riskArr[2]+"','"+riskArr[3]+"','"+riskArr[4]+"','"+riskArr[5]+"','"+riskArr[6]+"','"+riskArr[7]+"','"+riskArr[8]+"','"+levelOfRisk+"');";
            resultSet = statement.executeQuery(SqlQuery);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id_insurance;
    }
    public int levelOfRisk(){
        int level = 0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT TOP(1) level_of_risk FROM dbo.Risks\n" +
                    "WHERE id_insurance="+id_insurance+
                    "ORDER BY id_insurance desc";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                level = Integer.parseInt(resultSet.getString(1));
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return level;
    }

    public int commonData(String companyC, double costC)
    {
        id_insurance=0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT TOP(1) id_insurance FROM dbo.Common_Data\n" +
                    "ORDER BY id_insurance desc";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                id_insurance = Integer.parseInt(resultSet.getString(1));
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            //Calendar calendar = Calendar.getInstance();
            LocalDate time = LocalDate.now();
            id_insurance++;
            SqlQuery = "INSERT INTO dbo.Common_Data\n" +
                    "VALUES('"+id_insurance+"','"+time+"','"+1+"','"+time.withYear(time.getYear()+1)+"','"+companyC+"','"+costC+"');";
            resultSet = statement.executeQuery(SqlQuery);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id_insurance;
    }

    public int casco(String carBrandC, String carModelC, int yearOfManufactureC, int carPriceC)
    {
        id_casco=0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT TOP(1) id_casco FROM dbo.CASCO\n" +
                    "ORDER BY id_casco desc";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                id_casco = Integer.parseInt(resultSet.getString(1));
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            id_casco++;
            SqlQuery = "INSERT INTO dbo.CASCO\n" +
                    "VALUES('"+id_casco+"','"+carBrandC+"','"+carModelC+"','"+yearOfManufactureC+"','"+carPriceC+"');";
            resultSet = statement.executeQuery(SqlQuery);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id_casco;

    }

    public int motorLiability(String carNumberM, String carBrandM, String carModelM, int yearOfManufactureM, int carPriceM, String bodyNumberM)
    {
        id_motor_liability=0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT TOP(1) id_motor_liability FROM dbo.Motor_Liability\n" +
                    "ORDER BY id_motor_liability desc";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                id_motor_liability = Integer.parseInt(resultSet.getString(1));
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            id_motor_liability++;
            SqlQuery = "INSERT INTO dbo.Motor_Liability\n" +
                    "VALUES('"+id_motor_liability+"','"+carNumberM+"','"+carBrandM+"','"+carModelM+"','"+yearOfManufactureM+"','"+bodyNumberM+"');";
            resultSet = statement.executeQuery(SqlQuery);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id_motor_liability;

    }

    public int greenCard(String region, String vehicleG)
    {
        id_green_card=0;
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT TOP(1) id_green_card FROM dbo.Green_Card\n" +
                    "ORDER BY id_green_card desc";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                id_green_card = Integer.parseInt(resultSet.getString(1));
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            id_green_card++;
            SqlQuery = "INSERT INTO dbo.Green_Card\n" +
                    "VALUES('"+id_green_card+"','"+region+"','"+vehicleG+"');";
            resultSet = statement.executeQuery(SqlQuery);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id_green_card;
    }


    public int insuranceCasco()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT TOP(1) id_insurance FROM dbo.Common_Data\n" +
                    "ORDER BY id_insurance desc";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                id_insurance = Integer.parseInt(resultSet.getString(1));
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            SqlQuery = "INSERT INTO dbo.Insurance\n" +
                    "VALUES('"+id_user+"','"+id_insurance+"','"+id_casco+"','"+0+"','"+0+"');";
            resultSet = statement.executeQuery(SqlQuery);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id_user;
    }

    public int insuranceMotorLiability()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT TOP(1) id_insurance FROM dbo.Common_Data\n" +
                    "ORDER BY id_insurance desc";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                id_insurance = Integer.parseInt(resultSet.getString(1));
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            SqlQuery = "INSERT INTO dbo.Insurance\n" +
                    "VALUES('"+id_user+"','"+id_insurance+"','"+0+"','"+id_motor_liability+"','"+0+"');";
            resultSet = statement.executeQuery(SqlQuery);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id_user;
    }

    public int insuranceGreenCard()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT TOP(1) id_insurance FROM dbo.Common_Data\n" +
                    "ORDER BY id_insurance desc";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next())
            {
                id_insurance = Integer.parseInt(resultSet.getString(1));
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            SqlQuery = "INSERT INTO dbo.Insurance\n" +
                    "VALUES('"+id_user+"','"+id_insurance+"','"+0+"','"+0+"','"+id_green_card+"');";
            resultSet = statement.executeQuery(SqlQuery);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id_user;
    }

    public ObservableList<CommonData> getCommonData()
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        ObservableList<CommonData> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT start_date,validity,finish_date,company,cost FROM dbo.Common_Data\n" +
                    "JOIN dbo.Insurance on\n" +
                    "Insurance.id_insurance = Common_Data.id_insurance\n" +
                    "WHERE id_user = " + id_user;
            ResultSet resultSet = statement.executeQuery(SqlQuery);

            LocalDate start_date;
            LocalDate finish_date;
            int validity;
            String company;
            double cost;

            while(resultSet.next())
            {
                start_date = resultSet.getDate("start_date").toLocalDate();
                validity = Integer.parseInt(resultSet.getString("validity"));
                finish_date = resultSet.getDate("finish_date").toLocalDate();
                company = resultSet.getString("company");
                cost = Double.parseDouble(resultSet.getString("cost"));
                CommonData commonData = new CommonData(start_date,validity,finish_date,company,cost);
                list.add(commonData);
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }
    public void update(int id, int v)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";

        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "Select * FROM dbo.Common_Data";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            while (resultSet.next())
            {
                if(ch == id)
                {
                    id = resultSet.getInt("id_insurance");
                }
            }
            SqlQuery = "UPDATE dbo.Common_Data\n" +
                    "SET validity = "+v+",\n" +
                    "finish_date = DATEADD(YEAR,"+v+",finish_date),\n" +
                    "cost = cost*"+v+"\n" +
                    "where id_insurance = "+id+";";
            System.out.println(SqlQuery);
            resultSet = statement.executeQuery(SqlQuery);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public ObservableList<Casco> getDataCasco(int id)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        ObservableList<Casco> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT car_brand,car_model,year_of_manufacture_of_the_car,car_price FROM dbo.CASCO\n" +
                    "JOIN dbo.Insurance on\n" +
                    "Insurance.id_casco = CASCO.id_casco\n" +
                    "WHERE id_user = " + id_user + " and CASCO.id_casco = " + id;
            ResultSet resultSet = statement.executeQuery(SqlQuery);

            String car_brand;
            String car_model;
            int year_of_manufacture_of_the_car;
            int car_price;


            while(resultSet.next())
            {
                car_brand = resultSet.getString("car_brand");
                car_model = resultSet.getString("car_model");
                year_of_manufacture_of_the_car = Integer.parseInt(resultSet.getString("year_of_manufacture_of_the_car"));
                car_price = Integer.parseInt(resultSet.getString("car_price"));
                Casco casco = new Casco(car_brand,car_model,year_of_manufacture_of_the_car,car_price);
                list.add(casco);
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }
    public ObservableList<MotorLiability> getDataMotorLiability(int id)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        ObservableList<MotorLiability> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT car_number,car_brand,car_model,year_of_manufacture_of_the_car,body_number FROM dbo.Motor_Liability\n" +
                    "JOIN dbo.Insurance on\n" +
                    "Insurance.id_motor_liability = Motor_Liability.id_motor_liability\n" +
                    "WHERE id_user = " + id_user + " and Motor_Liability.id_motor_liability = " + id;
            ResultSet resultSet = statement.executeQuery(SqlQuery);

            String car_number;
            String car_brand;
            String car_model;
            int year_of_manufacture_of_the_car;
            String body_number;


            while(resultSet.next())
            {
                car_number = resultSet.getString("car_number");
                car_brand = resultSet.getString("car_brand");
                car_model = resultSet.getString("car_model");
                year_of_manufacture_of_the_car = Integer.parseInt(resultSet.getString("year_of_manufacture_of_the_car"));
                body_number = resultSet.getString("body_number");
                MotorLiability motorLiability = new MotorLiability(car_number,car_brand,car_model,year_of_manufacture_of_the_car,body_number);
                list.add(motorLiability);
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }
    public ObservableList<GreenCard> getDataGreenData(int id)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";
        ObservableList<GreenCard> list = FXCollections.observableArrayList();
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "SELECT region_of_stay,vehicle FROM dbo.Green_Card\n" +
                    "JOIN dbo.Insurance on\n" +
                    "Insurance.id_green_card = Green_Card.id_green_card\n" +
                    "WHERE id_user = " + id_user + " and Green_Card.id_green_card = " + id;
            ResultSet resultSet = statement.executeQuery(SqlQuery);

            String region_of_stay;
            String vehicle;


            while(resultSet.next())
            {
                region_of_stay = resultSet.getString("region_of_stay");
                vehicle = resultSet.getString("vehicle");
                GreenCard greenCard = new GreenCard(region_of_stay,vehicle);
                list.add(greenCard);
                //System.out.println(String.format("%30s %30s %30s",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return list;
    }

    public int[] view (int id)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";

        int[] arr = new int[2];
        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "Select * FROM dbo.Common_Data";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            while (resultSet.next())
            {
                if(ch == id)
                {
                    id = resultSet.getInt("id_insurance");
                }
            }
            SqlQuery = "SELECT id_casco FROM dbo.Insurance\n" +
                    "WHERE id_insurance = " + id;
            resultSet = statement.executeQuery(SqlQuery);
            int temp_id_casco = 0;
            while (resultSet.next())
            {
                temp_id_casco = resultSet.getInt("id_casco");
            }
            if (temp_id_casco == 0)
            {
                SqlQuery = "SELECT id_motor_liability FROM dbo.Insurance\n" +
                        "WHERE id_insurance = " + id;
                resultSet = statement.executeQuery(SqlQuery);
                int temp_id_motor_liability = 0;
                while (resultSet.next())
                {
                    temp_id_motor_liability = resultSet.getInt("id_motor_liability");
                }
                if (temp_id_motor_liability == 0)
                {
                    SqlQuery = "SELECT id_green_card FROM dbo.Insurance\n" +
                            "WHERE id_insurance = " + id;
                    resultSet = statement.executeQuery(SqlQuery);
                    int temp_id_green_card = 0;
                    while (resultSet.next())
                    {
                        temp_id_green_card = resultSet.getInt("id_green_card");
                    }
                    if (temp_id_green_card == 0)
                    {
                        arr[0] = 0;
                        arr[1] = 0;
                        return arr;
                    }
                    else {
                        //temp_id_green_card++;
                        arr[0] = temp_id_green_card;
                        arr[1] = 3;
                        return arr;
                    }
                }
                else {
                    //temp_id_motor_liability++;
                    arr[0] = temp_id_motor_liability;
                    arr[1] = 2;
                    return arr;
                }
            }
            else {
                //temp_id_casco++;
                arr[0] = temp_id_casco;
                arr[1] = 1;
                return arr;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return arr;

    }

    public void delete(int id)
    {
        Connection conn = null;
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER02:1433;databaseName=TermPaper;encrypt=true;trustServerCertificate=true";

        try {
            // db parameters
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            // create a connection to the database
            conn = DriverManager.getConnection(url,"Oleksandr","0000");
            System.out.println("Connection to MSSQLSERVER02 for SelectUsers established");
            Statement statement = conn.createStatement();
            String SqlQuery = "Select * FROM dbo.Common_Data";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            while (resultSet.next())
            {
                if(ch == id)
                {
                    id = resultSet.getInt("id_insurance");
                }
            }
            SqlQuery = "SELECT id_casco FROM dbo.Insurance\n" +
                    "WHERE id_insurance = " + id;
            resultSet = statement.executeQuery(SqlQuery);
            int temp_id_casco = 0;
            while (resultSet.next())
            {
                temp_id_casco = resultSet.getInt("id_casco");
            }
            if (temp_id_casco == 0)
            {
                SqlQuery = "SELECT id_motor_liability FROM dbo.Insurance\n" +
                        "WHERE id_insurance = " + id;
                resultSet = statement.executeQuery(SqlQuery);
                int temp_id_motor_liability = 0;
                while (resultSet.next())
                {
                    temp_id_motor_liability = resultSet.getInt("id_motor_liability");
                }
                if (temp_id_motor_liability == 0)
                {
                    SqlQuery = "SELECT id_green_card FROM dbo.Insurance\n" +
                            "WHERE id_insurance = " + id;
                    resultSet = statement.executeQuery(SqlQuery);
                    int temp_id_green_card = 0;
                    while (resultSet.next())
                    {
                        temp_id_green_card = resultSet.getInt("id_green_card");
                    }
                    if (temp_id_green_card == 0)
                    {
                        return;
                    }
                    else {
                        SqlQuery = "DELETE FROM dbo.Common_Data\n" +
                                "WHERE id_insurance = " + id + "\n" +
                                "DELETE FROM dbo.Green_Card\n" +
                                "WHERE id_green_card = " + temp_id_green_card + "\n" +
                                "DELETE FROM dbo.Insurance\n" +
                                "WHERE id_green_card = " + temp_id_green_card+"\n" +
                                " and id_user = " + id_user + "\n" +
                                "DELETE FROM dbo.Risks\n" +
                                "WHERE id_insurance = " + id;
                        resultSet = statement.executeQuery(SqlQuery);
                    }
                }
                else {
                    SqlQuery = "DELETE FROM dbo.Common_Data\n" +
                            "WHERE id_insurance = " + id + "\n" +
                            "DELETE FROM dbo.Motor_Liability\n" +
                            "WHERE id_motor_liability = " + temp_id_motor_liability + "\n" +
                            "DELETE FROM dbo.Insurance\n" +
                            "WHERE id_motor_liability = " + temp_id_motor_liability+"\n" +
                            " and id_user = " + id_user + "\n" +
                            "DELETE FROM dbo.Risks\n" +
                            "WHERE id_insurance = " + id;
                    resultSet = statement.executeQuery(SqlQuery);
                }
            }
            else {
                SqlQuery = "DELETE FROM dbo.Common_Data\n" +
                        "WHERE id_insurance = " + id + "\n" +
                        "DELETE FROM dbo.CASCO\n" +
                        "WHERE id_casco = " + temp_id_casco + "\n" +
                        "DELETE FROM dbo.Insurance\n" +
                        "WHERE id_casco = " + temp_id_casco+"\n" +
                        " and id_user = " + id_user + "\n" +
                        "DELETE FROM dbo.Risks\n" +
                        "WHERE id_insurance = " + id;
                resultSet = statement.executeQuery(SqlQuery);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}