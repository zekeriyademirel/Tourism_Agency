package com.tourismagency.Model;

import com.tourismagency.Helper.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Hotel {
    private int id;
    private String name;
    private int telephone;
    private String email;
    private String hostelType;
    private String facility;
    private int star;
    private String address;
    private String region;
    private String city;

    public Hotel() {
    }

    public Hotel(int id, String name, int telephone, String email, String hostelType, String facility, int star, String address,String region, String city) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.hostelType = hostelType;
        this.facility = facility;
        this.star = star;
        this.address = address;
        this.region = region;
        this.city = city;
    }

    public static ArrayList<Hotel> getList() {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        String query = "SELECT * FROM hotel";
        Hotel obj;

        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Hotel();

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setTelephone(rs.getInt("telephone"));
                obj.setEmail(rs.getString("email"));
                obj.setHostelType(rs.getString("hostel_type"));
                obj.setFacility(rs.getString("facility"));
                obj.setStar(rs.getInt("star"));
                obj.setAddress(rs.getString("address"));
                obj.setRegion(rs.getString("region"));
                obj.setCity(rs.getString("city"));

                hotelList.add(obj);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotelList;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHostelType() {
        return hostelType;
    }

    public void setHostelType(String hostelType) {
        this.hostelType = hostelType;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
