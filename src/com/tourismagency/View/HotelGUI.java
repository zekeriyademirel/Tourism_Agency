package com.tourismagency.View;

import com.tourismagency.Helper.Config;
import com.tourismagency.Helper.Helper;
import com.tourismagency.Model.Hotel;
import com.tourismagency.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HotelGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_welcome;
    private JButton btn_logout;
    private JButton btn_hotel_add;
    private JButton btn_room_add;
    private JButton btn_room_price;
    private JScrollPane scrl_hotel_list;
    private JTable tbl_hotel_list;

    private DefaultTableModel mdl_hotel_list;
    private Object[] row_hotel_list;
    private User user;
    private String hotelName;

    public HotelGUI() {
        this.user = user;

        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

//        lbl_welcome.setText("Hoşgeldiniz : " + user.getName() + " " + user.getSurname());

        mdl_hotel_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

       Object[] col_hotel_list = {"ID", "Hotel Adı", "Telefon", "E - mail", "Pansiyon Tipi",
               "Tesis Özellikleri", "Yıldız", "Adress", "Bölge", "Şehir"};
       mdl_hotel_list.setColumnIdentifiers(col_hotel_list);
       row_hotel_list = new Object[col_hotel_list.length];
    //  loadHotelModel();
      tbl_hotel_list.setModel(mdl_hotel_list);
       tbl_hotel_list.getTableHeader().setReorderingAllowed(false);
        tbl_hotel_list.getColumnModel().getColumn(0).setMaxWidth(60);


        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI login = new LoginGUI();
        });
        btn_hotel_add.addActionListener(e -> {
            dispose();
            HotelAddGUI hotelAdd=new HotelAddGUI();
        });
        btn_room_add.addActionListener(e -> {
            dispose();
            RoomAddGUI roomAdd=new RoomAddGUI();
        });
        btn_room_price.addActionListener(e -> {
            dispose();
            RoomPriceGUI roomPrice=new RoomPriceGUI();
        });
    }


    public void loadHotelModel() {

        DefaultTableModel clearModel = (DefaultTableModel) tbl_hotel_list.getModel();
        clearModel.setRowCount(0);

        for (Hotel obj : Hotel.getList()) {
            int i = 0;
            row_hotel_list[i++] = obj.getId();
            row_hotel_list[i++] = obj.getName();
            row_hotel_list[i++] = obj.getTelephone();
            row_hotel_list[i++] = obj.getEmail();
            row_hotel_list[i++] = obj.getHostelType();
            row_hotel_list[i++] = obj.getFacility();
            row_hotel_list[i++] = obj.getStar();
            row_hotel_list[i++] = obj.getAddress();
            row_hotel_list[i++] = obj.getRegion();
            row_hotel_list[i++] = obj.getCity();

            mdl_hotel_list.addRow(row_hotel_list);
        }

    }

    public static void main(String[] args) {
        HotelGUI h = new HotelGUI();
    }

}
