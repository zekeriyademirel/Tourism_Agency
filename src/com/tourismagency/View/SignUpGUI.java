package com.tourismagency.View;

import com.tourismagency.Helper.Config;
import com.tourismagency.Helper.Helper;
import com.tourismagency.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpGUI extends JFrame{
    private JPanel wrapper;
    private JLabel fld_signUp;
    private JTextField fld_signUp_name;
    private JTextField fld_signUp_surname;
    private JTextField fld_signUp_uname;
    private JTextField fld_signUp_email;
    private JTextField fld_signUp_pass;
    private JTextField fld_signUp_cnfrm_pass;
    private JButton btn_signUp;

    public SignUpGUI(){
        add(wrapper);

        setSize(400, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        btn_signUp.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_signUp_name)
                    || Helper.isFieldEmpty(fld_signUp_surname)
                    || Helper.isFieldEmpty(fld_signUp_uname)
                    || Helper.isFieldEmpty(fld_signUp_pass)
                    || Helper.isFieldEmpty(fld_signUp_cnfrm_pass)
                    || Helper.isFieldEmpty(fld_signUp_email)
            ) {
                Helper.showMsg("fill");
            } else {

                String name = fld_signUp_name.getText();
                String surname=fld_signUp_surname.getText();
                String uname = fld_signUp_uname.getText();
                String pass = fld_signUp_pass.getText();
                String cnfrmpass = fld_signUp_cnfrm_pass.getText();
                String email = fld_signUp_email.getText();
                String type = "customer";

                if (isEmail(email) && isPassword(pass, cnfrmpass)) {
                    if (User.add(name,surname, uname,email, pass, type)) {
                        Helper.showMsg("done");

                        fld_signUp_name.setText(null);
                        fld_signUp_surname.setText(null);
                        fld_signUp_uname.setText(null);
                        fld_signUp_pass.setText(null);
                        fld_signUp_cnfrm_pass.setText(null);
                        fld_signUp_email.setText(null);

                    }
                }

            }

            dispose();
            LoginGUI login = new LoginGUI();
        });
    }

    private boolean isEmail(String email) {
        if (email.contains("@gmail.com")
                || email.contains("@hotmail.com")
                || email.contains("@icloud.com")
                || email.contains("@yahoo.com")
                || email.contains("@yandex.com")
                || email.contains("@outlook.com")) {
            return true;
        } else {
            Helper.showMsg("Lütfen geçerli bir e-mail giriniz !");
            return false;
        }
    }

    private boolean isPassword(String pass, String cnfrmpass) {
        if (pass.length() < 8 || cnfrmpass.length() < 8) {
            Helper.showMsg("Şifre en az 8 karakter uzunluğunda olmalı !");
            return false;
        }
        if (!(pass.equals(cnfrmpass))) {
            Helper.showMsg("Şifreler eşleşmiyor !");
            return false;
        }
        return true;
    }


}
