package presentacio.views;

import presentacio.Constants;

import javax.swing.*;
import java.awt.*;

public class ProfileView extends JPanel {

    JLabel lblUsernameinfo, lblPasswordinfo, lblNameinfo, lblSurnameinfo;
    JButton bBackPerfil;

    public ProfileView() {

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        Component verticalStrut = Box.createVerticalStrut(20);
        panel.add(verticalStrut);

        ImageIcon imageUser = new ImageIcon(getClass().getResource("../../assets/img/Logo_Kajugo.png"));
        imageUser = scaleImage(imageUser, 128, 128);
        JLabel lblImage = new JLabel(imageUser);
        lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblImage);

        Component verticalStrut_1 = Box.createVerticalStrut(30);
        panel.add(verticalStrut_1);

        JPanel panel_0 = new JPanel();
        FlowLayout flowLayout0 = (FlowLayout) panel_0.getLayout();
        flowLayout0.setAlignment(FlowLayout.CENTER);
        panel.add(panel_0);

        JLabel lblNewLabel = new JLabel(Constants.PROFILE);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setForeground(SystemColor.activeCaption);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 33));
        panel_0.add(lblNewLabel);

        Component verticalStrut_0 = Box.createVerticalStrut(30);
        panel.add(verticalStrut_0);

        JPanel panelInfo = new JPanel();
        panelInfo.setPreferredSize(new Dimension(300, 110));
        panelInfo.setMinimumSize(new Dimension(300, 100));
        panelInfo.setMaximumSize(new Dimension(300, 100));
        panel.add(panelInfo);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername.setMinimumSize(new Dimension(75, 14));
        lblUsername.setPreferredSize(new Dimension(100, 20));
        lblUsername.setMaximumSize(new Dimension(75, 14));
        panelInfo.add(lblUsername);

        lblUsernameinfo = new JLabel("");
        lblUsernameinfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsernameinfo.setPreferredSize(new Dimension(100, 16));
        panelInfo.add(lblUsernameinfo);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword.setMaximumSize(new Dimension(75, 14));
        lblPassword.setMinimumSize(new Dimension(75, 14));
        lblPassword.setPreferredSize(new Dimension(100, 20));
        panelInfo.add(lblPassword);

        lblPasswordinfo = new JLabel("");
        lblPasswordinfo.setPreferredSize(new Dimension(100, 20));
        lblPasswordinfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panelInfo.add(lblPasswordinfo);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setPreferredSize(new Dimension(100, 20));
        panelInfo.add(lblName);

        lblNameinfo = new JLabel("");
        lblNameinfo.setPreferredSize(new Dimension(100, 20));
        lblNameinfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panelInfo.add(lblNameinfo);

        JLabel lblSurname = new JLabel("Surname:");
        lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSurname.setPreferredSize(new Dimension(100, 20));
        panelInfo.add(lblSurname);

        lblSurnameinfo = new JLabel("");
        lblSurnameinfo.setPreferredSize(new Dimension(100, 20));
        lblSurnameinfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panelInfo.add(lblSurnameinfo);

        Component verticalStrut_4 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_4);

        JPanel panel_5 = new JPanel();
        panel.add(panel_5);

        bBackPerfil = new JButton(Constants.BACK);
        bBackPerfil.setPreferredSize(new Dimension(200, 25));
        panel_5.add(bBackPerfil);


    }

    private ImageIcon scaleImage(ImageIcon imageIcon, int width, int heigth) {
        Image image = imageIcon.getImage();                                             // transform it
        Image newimg = image.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);     // scale it the smooth way
        return new ImageIcon(newimg);
    }

    public JLabel getLblUsernameinfo() {
        return lblUsernameinfo;
    }

    public JLabel getLblPasswordinfo() {
        return lblPasswordinfo;
    }

    public JLabel getLblNameinfo() {
        return lblNameinfo;
    }

    public JLabel getLblSurnameinfo() {
        return lblSurnameinfo;
    }

    public JButton getbBackPerfil() {
        return bBackPerfil;
    }

}
