package com.tourismagency.View;

import com.tourismagency.Helper.Config;
import com.tourismagency.Helper.Helper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchScreenGUI extends JFrame{
    private JTextField fld_ss_area;
    private JTextField fld_ss_input;
    private JTextField fld_ss_out;
    private JPanel wrapper;
    private JTextField fld_ss_guest;
    private JButton btn_ss_search;
    private JButton btn_back;

    private DefaultTableModel mdl_ss_list;
    private Object[] row_ss_list;

    public SearchScreenGUI(){
        add(wrapper);
        setSize(550, 250);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

//        lbl_welcome.setText("Hoşgeldiniz : " + user.getName() + " " + user.getSurname());

        mdl_ss_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        btn_back.addActionListener(e -> {
            dispose();
            LoginGUI l=new LoginGUI();
        });
    }
}
