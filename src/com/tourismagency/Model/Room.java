package com.tourismagency.Model;

import com.tourismagency.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Room {
    private int id;
    private String room_type;
    private int bedNumber;
    private boolean tv;
    private boolean minibar;
    private boolean gameConsole;
    private double squareMeters;
    private boolean till;
    private boolean projection;
    private Hotel hotel;

    public Room() {
    }

    public Room(int id, String room_type, int bedNumber, boolean tv, boolean minibar, boolean gameConsole, int squareMeters, boolean till, boolean projection) {
        this.id = id;
        this.room_type = room_type;
        this.bedNumber = bedNumber;
        this.tv = tv;
        this.minibar = minibar;
        this.gameConsole = gameConsole;
        this.squareMeters = squareMeters;
        this.till = till;
        this.projection = projection;
    }

    public static int isRoomTypeAdded(String roomType, int hotelId) {
        String query = "SELECT id FROM room WHERE room_type = ? AND hotel_id = ?";
        int id = 0;
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, roomType);
            pr.setInt(2, hotelId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    // 	id	room_type	bedNumber	tv	minibar	gameConsole	squareMeters	till	projection	hotel_id
    public static boolean add(String room_type, int bedNumber, boolean tv, boolean minibar, boolean gameConsole, double squareMeters, boolean till, boolean projection, int hotel_id) {
        String query = "INSERT INTO room (room_type,bedNumber,tv,minibar,gameConsole,squareMeters,till,projection,hotel_id) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, room_type);
            pr.setInt(2, bedNumber);
            pr.setBoolean(3, tv);
            pr.setBoolean(4, minibar);
            pr.setBoolean(5, gameConsole);
            pr.setDouble(6, squareMeters);
            pr.setBoolean(7, till);
            pr.setBoolean(8, projection);
            pr.setInt(9, hotel_id);

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getHotelIdByRoomId(int id) {
        String query = "SELECT course_id from public.room WHERE id = " + id;
        int result = 0;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            result = rs.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isGameConsole() {
        return gameConsole;
    }

    public void setGameConsole(boolean gameConsole) {
        this.gameConsole = gameConsole;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public boolean isTill() {
        return till;
    }

    public void setTill(boolean till) {
        this.till = till;
    }

    public boolean isProjection() {
        return projection;
    }

    public void setProjection(boolean projection) {
        this.projection = projection;
    }
}
