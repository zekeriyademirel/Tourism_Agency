package com.tourismagency.View;

import com.tourismagency.Helper.Config;
import com.tourismagency.Helper.Helper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HotelAddGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_hotel_list;
    private JPanel pnl_hostel_list;
    private JPanel pnl_facility_list;
    private JCheckBox chck_hostel_tampans;
    private JCheckBox chck_hostel_yarpans;
    private JCheckBox chck_hostel_yatak;
    private JCheckBox chck_hostel_alcol;
    private JCheckBox chck_hostel_hersey;
    private JCheckBox chck_hostel_ultra;
    private JCheckBox chck_hostel_kahvaltı;
    private JCheckBox chck_facility_otopark;
    private JCheckBox chck_facility_wifi;
    private JCheckBox chck_facility_yuzme;
    private JCheckBox chck_facility_fitness;
    private JCheckBox chck_facility_hotel;
    private JCheckBox chck_facility_spa;
    private JCheckBox chck_facility_odaservis;
    private JTextField fld_hotel_name;
    private JTextField fld_hotel_tel;
    private JTextField fld_hotel_email;
    private JComboBox cmb_hotel_star;
    private JTextField fld_hotel_address;
    private JButton btn_hotel_exit;
    private JButton btn_hotel_add;
    private JTextField fld_hotel_city;
    private JTextField fld_hotel_area;

    private DefaultTableModel mdl_hoteladd_list;
    private Object[] row_hoteladd_list;

    public HotelAddGUI(){
        add(wrapper);
        setSize(600, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        mdl_hoteladd_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        btn_hotel_exit.addActionListener(e -> {
            dispose();
            HotelGUI login = new HotelGUI();
        });
    }
}
