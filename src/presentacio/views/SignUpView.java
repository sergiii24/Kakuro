package presentacio.views;

import presentacio.Constants;

import javax.swing.*;
import java.awt.*;

public class SignUpView extends JPanel {

    JButton backLogin, signUp;
    JTextField txtRegUser, txtRegPassword, txtRegPassword2;

    public SignUpView() {

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        Font fBold = new Font("Arial", Font.BOLD, 20);
        Font fPlain = new Font("Arial", Font.PLAIN, 18);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        Component verticalStrut = Box.createVerticalStrut(20);
        panel.add(verticalStrut);

        ImageIcon imageUser = new ImageIcon(getClass().getResource("../../assets/img/Logo_Kajugo.png"));
        imageUser = scaleImage(imageUser, 128, 128);
        JLabel lblImage = new JLabel(imageUser);
        lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblImage);

        Component verticalStrut_1 = Box.createVerticalStrut(20);
        panel.add(verticalStrut_1);

        JPanel panel_0 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_0.getLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        panel.add(panel_0);

        JLabel lblNewLabel0 = new JLabel(Constants.SIGNUP);
        lblNewLabel0.setFont(fBold);
        panel_0.add(lblNewLabel0);

        Component verticalStrut_0 = Box.createVerticalStrut(20);
        panel.add(verticalStrut_0);

        JPanel panel_1 = new JPanel();
        ((FlowLayout) panel_1.getLayout()).setAlignment(FlowLayout.LEFT);
        panel.add(panel_1);

        JLabel lblNewLabel = new JLabel(Constants.USER);
        lblNewLabel.setFont(fBold);
        panel_1.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);

        txtRegUser = new JTextField();
        txtRegUser.setFont(fPlain);
        txtRegUser.setToolTipText(Constants.USER);
        panel_2.add(txtRegUser);
        txtRegUser.setColumns(14);

        Component verticalStrut_3 = Box.createVerticalStrut(20);
        panel.add(verticalStrut_3);

        JPanel panel_3 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        panel.add(panel_3);

        JLabel lblNewLabel_2 = new JLabel(Constants.PASSWORD);
        lblNewLabel_2.setFont(fBold);
        panel_3.add(lblNewLabel_2);

        JPanel panel_4 = new JPanel();
        panel_4.setLayout(new BorderLayout(0, 0));
        panel.add(panel_4);

        txtRegPassword = new JPasswordField();
        panel_4.add(txtRegPassword, BorderLayout.NORTH);
        txtRegPassword.setColumns(14);

        JLabel lblNewLabel_5 = new JLabel(Constants.CONFIRMPASSWORD);
        lblNewLabel_2.setFont(fBold);
        panel_4.add(lblNewLabel_5, BorderLayout.CENTER);

        txtRegPassword2 = new JPasswordField();
        panel_4.add(txtRegPassword2, BorderLayout.SOUTH);
        txtRegPassword2.setColumns(14);

        Component verticalStrut_2 = Box.createVerticalStrut(20);
        panel.add(verticalStrut_2);

        JPanel panel_5 = new JPanel();
        panel.add(panel_5);

        signUp = new JButton(Constants.SIGNUP);
        signUp.setPreferredSize(new Dimension(200, 25));
        panel_5.add(signUp);

        Component verticalStrut_6 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_6);

        JPanel panel_6 = new JPanel();
        panel.add(panel_6);
        panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        backLogin = new JButton(Constants.BACK);
        backLogin.setPreferredSize(new Dimension(200, 25));
        panel_6.add(backLogin);

    }

    private ImageIcon scaleImage(ImageIcon imageIcon, int width, int heigth) {
        Image image = imageIcon.getImage();                                             // transform it
        Image newimg = image.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);     // scale it the smooth way
        return new ImageIcon(newimg);
    }

    public JButton getBackLogin() {
        return backLogin;
    }

    public JButton getSignUp() {
        return signUp;
    }

    public JTextField getTxtRegUser() {
        return txtRegUser;
    }

    public JTextField getTxtRegPassword() {
        return txtRegPassword;
    }

    public JTextField getTxtRegPassword2() {
        return txtRegPassword2;
    }

}
