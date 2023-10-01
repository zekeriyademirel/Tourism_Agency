package com.tourismagency.Model;

import com.tourismagency.Helper.DBConnector;
import com.tourismagency.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String surname;
    private String uname;
    private String email;
    private String pass;
    private String type;

    public User() {
    }

    public User(int id, String name, String surname, String uname, String email, String pass, String type) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.uname = uname;
        this.email = email;
        this.pass = pass;
        this.type = type;
    }


    public static boolean add(String name,String surname, String uname, String email, String pass, String type) {
        String query = "INSERT INTO user (name, surname, uname,email, pass, type) VALUES (?,?,?,?,?,?)";

        User findUser = User.getFetch(uname);

        if (findUser != null) {
            Helper.showMsg("Bu kullanıcı adı daha önceden eklenmiş. Lütfen farklı bir kullanıcı adı giriniz !");
            return false;
        }

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, surname);
            pr.setString(3, uname);
            pr.setString(4,email);
            pr.setString(5, pass);
            pr.setString(6, type);

            int response = pr.executeUpdate();

            if (response == -1) {
                Helper.showMsg("error");
            }

            return response != -1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    public static User getFetch(String uname) {

        User obj = null;

        String query = "SELECT * FROM user WHERE uname= ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, uname);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setSurname(rs.getString("surname"));
                obj.setUname(rs.getString("uname"));
                obj.setEmail(rs.getString("email"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    public static User getFetch(String uname, String pass) {

        User obj = null;

        String query = "SELECT * FROM user WHERE uname= ? AND pass= ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, uname);
            pr.setString(2, pass);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                switch (rs.getString("type")) {
                    case "hotel":
                        obj = new User();
                        break;
                }

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setSurname(rs.getString("surname"));
                obj.setUname(rs.getString("uname"));
                obj.setEmail(rs.getString("email"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }


    public static ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        User obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setSurname(rs.getString("surname"));
                obj.setUname(rs.getString("uname"));
                obj.setEmail(rs.getString("email"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
