package presentacio.views;
import presentacio.Constants;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {

    JTextField txtUser, txtPassword;
    JButton entrar;
    JLabel lblRegistrar, lblGuest;

    public LoginView() {

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        Font fBold = new Font("Arial", Font.BOLD, 20);
        Font fPlain = new Font("Arial", Font.PLAIN, 18);

        JPanel panel = new JPanel();

        panel.setBackground(new Color(240, 240, 240));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        Component verticalStrut = Box.createVerticalStrut(20);
        panel.add(verticalStrut);

        ImageIcon imageUser = new ImageIcon(new ImageIcon(getClass().getResource("../../assets/img/Logo_Kajugo.png")).getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH));
        JLabel lblImage = new JLabel(imageUser);
        lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblImage);

        Component verticalStrut_1 = Box.createVerticalStrut(20);
        panel.add(verticalStrut_1);

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel.add(panel_1);

        JLabel lblNewLabel = new JLabel(Constants.USER);
        lblNewLabel.setFont(fBold);
        panel_1.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);

        txtUser = new JTextField();
        txtUser.setFont(fPlain);
        txtUser.setEditable(true);
        txtUser.setToolTipText(Constants.USER);
        panel_2.add(txtUser);
        txtUser.setColumns(14);

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
        panel.add(panel_4);

        txtPassword = new JPasswordField();
        panel_4.add(txtPassword);
        txtPassword.setFont(fPlain);
        txtPassword.setColumns(14);

        Component verticalStrut_2 = Box.createVerticalStrut(20);
        panel.add(verticalStrut_2);

        JPanel panel_5 = new JPanel();
        panel.add(panel_5);

        entrar = new JButton(Constants.LOGIN);
        entrar.setPreferredSize(new Dimension(200, 25));
        panel_5.add(entrar);

        Component verticalStrut_6 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_6);

        JPanel panel_6 = new JPanel();
        panel.add(panel_6);
        panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblRegistrar = new JLabel(Constants.REGISTER);
        lblRegistrar.setFont(new Font("Arial", Font.PLAIN, 12));
        panel_6.add(lblRegistrar);

        JPanel panel_7 = new JPanel();
        panel.add(panel_7);

        lblGuest = new JLabel(Constants.GUEST);
        lblGuest.setFont(new Font("Arial", Font.PLAIN, 12));
        panel_7.add(lblGuest);

    }

    public JTextField getTxtUser() {
        return txtUser;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public JButton getEntrar() {
        return entrar;
    }

    public JLabel getLblRegistrar() {
        return lblRegistrar;
    }

    public JLabel getLblGuest() {
        return lblGuest;
    }

}
