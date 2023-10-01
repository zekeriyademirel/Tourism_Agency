package com.tourismagency.View;

import com.tourismagency.Helper.Config;
import com.tourismagency.Helper.Helper;
import com.tourismagency.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wbottom;
    private JPanel wtop;
    private JTextField fld_user_uname;
    private JTextField fld_user_pass;
    private JButton btn_login;
    private JButton btn_SignUp;
    private JButton btn_ss;

    public LoginGUI() {
        add(wrapper);

        setSize(400, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_uname) || Helper.isFieldEmpty(fld_user_pass)) {
                Helper.showMsg("fill");
            } else {
              User u = User.getFetch(fld_user_uname.getText(), fld_user_pass.getText());
             if (u == null) {
                  Helper.showMsg("Kullanıcı Bulunamadı !");
             } else {
                 switch (u.getType()){
                     case "hotel" :
                         HotelGUI hotelGUI=new HotelGUI();
                          break;
          //            case "customer" :
          //                EducatorGUI edGUI=new EducatorGUI();
          //                break;
          //            case "student" :
          //                StudentGUI stGUI=new StudentGUI();
          //                break;
                }
                    dispose();

                }
            }

        });
        btn_SignUp.addActionListener(e -> {
            SignUpGUI signUpGUI=new SignUpGUI();
            dispose();
        });
        btn_ss.addActionListener(e -> {
            dispose();
            SearchScreenGUI ss=new SearchScreenGUI();
        });
    }
}
