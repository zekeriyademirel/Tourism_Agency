package com.tourismagency.View;

import com.tourismagency.Helper.Config;
import com.tourismagency.Helper.Helper;
import com.tourismagency.Model.Hotel;
import com.tourismagency.Model.Room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomAddGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_welcome;
    private JComboBox cmb_type;
    private JTextField fld_bedNumber;
    private JCheckBox chk_tv;
    private JCheckBox chk_minibar;
    private JCheckBox chk_safe;
    private JCheckBox chk_console;
    private JCheckBox chk_projeksiyon;
    private JTextField fld_meters;
    private JButton btn_add;

    private Hotel hotel;


    private final String[] roomTypeList = {"Single","Double","Suit"};

    public RoomAddGUI(){
        add(wrapper);
        setSize(500, 450);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        loadRoomTypeCombo();

        btn_add.addActionListener(e -> {
            int hotel_id = hotel.getId();
            String room_type = cmb_type.getSelectedItem().toString();
            int bedNumber = Integer.parseInt(fld_bedNumber.getText());
            boolean tv = chk_tv.isSelected();
            boolean minibar = chk_minibar.isSelected();
            boolean till = chk_safe.isSelected();
            boolean gameConsole = chk_console.isSelected();
            boolean projection = chk_projeksiyon.isSelected();
            double squareMeters=Double.parseDouble(fld_meters.getText());

            if (Room.isRoomTypeAdded(room_type,hotel_id) == 0){

                if (Room.add(room_type,bedNumber,tv,minibar,gameConsole,squareMeters,till,projection,hotel_id)){
                    Helper.showMsg("done");
                }else{
                    Helper.showMsg("error");
                }
            }else {
                Helper.showMsg("Bu otele ait " + room_type + " tipinde oda daha önce eklenmiştir.");
            }

        });
    }

    public void loadRoomTypeCombo() {
        cmb_type.removeAllItems();
        for (String s : roomTypeList){
            cmb_type.addItem(s);
        }
    }

}
