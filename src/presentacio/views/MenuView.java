package presentacio.views;

import presentacio.Constants;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuView extends JPanel {

    JButton bPerfil, bJugar, bKakuroManagement, bLogOff, bStatistics; //Botons Meú principal
    JButton bContinue, b2Jugar, bCrear, bBackJugar; //
    JButton bPlay, bBackJugar2;
    JPanel principal, menuJugar, menuJugar2, panelUserList;
    JList listPublic, listUser;
    ButtonGroup buttonGroup_1;
    CardLayout cardLayout;
    ArrayList<JRadioButton> buttonsModeJugar;

    public MenuView() {

        cardLayout = new CardLayout(0, 0);
        setLayout(cardLayout);
        principal = carregaMenuPrincipal();
        add(principal, "principal");

        menuJugar = carregarMenuJugar();
        add(menuJugar, "jugar");

        menuJugar2 = carregarVistaJugar2();
        add(menuJugar2, "jugar2");


        cardLayout.show(this, "principal");

    }


    private JPanel carregaMenuPrincipal() {

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel panel = new JPanel();

        panel.setBackground(new Color(240, 240, 240));
        p.add(panel);
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

        JLabel lblNewLabel = new JLabel(Constants.MAIN);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setForeground(SystemColor.activeCaption);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 33));
        panel_0.add(lblNewLabel);

        Component verticalStrut_0 = Box.createVerticalStrut(30);
        panel.add(verticalStrut_0);

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        panel.add(panel_1);

        bJugar = new JButton(Constants.PLAY);
        bJugar.setPreferredSize(new Dimension(200, 25));
        panel_1.add(bJugar);

        Component verticalStrut_3 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_3);

        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
        flowLayout_2.setAlignment(FlowLayout.CENTER);
        panel.add(panel_2);

        bKakuroManagement = new JButton(Constants.MANAGEMENT);
        bKakuroManagement.setPreferredSize(new Dimension(200, 25));
        panel_2.add(bKakuroManagement);

        Component verticalStrut_6 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_6);

        JPanel panel_3 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
        flowLayout_1.setAlignment(FlowLayout.CENTER);
        panel.add(panel_3);

        bPerfil = new JButton(Constants.PROFILE);
        bPerfil.setPreferredSize(new Dimension(200, 25));
        panel_3.add(bPerfil);

        Component verticalStrut_2 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_2);

        JPanel panel_6 = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
        flowLayout_4.setAlignment(FlowLayout.CENTER);
        panel.add(panel_6);

        bStatistics = new JButton(Constants.STADISTICS);
        bStatistics.setPreferredSize(new Dimension(200, 25));
        panel_6.add(bStatistics);

        Component verticalStrut_4 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_4);

        JPanel panel_5 = new JPanel();
        panel.add(panel_5);

        bLogOff = new JButton(Constants.LOGOFF);
        bLogOff.setPreferredSize(new Dimension(200, 25));
        panel_5.add(bLogOff);

        return p;

    }


    private JPanel carregarMenuJugar() {

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel panel = new JPanel();

        panel.setBackground(new Color(240, 240, 240));
        p.add(panel);
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

        JLabel lblNewLabel = new JLabel(Constants.MAIN);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setForeground(SystemColor.activeCaption);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 33));
        panel_0.add(lblNewLabel);

        Component verticalStrut_0 = Box.createVerticalStrut(30);
        panel.add(verticalStrut_0);

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        panel.add(panel_1);

        bContinue = new JButton(Constants.CONTINUE);
        bContinue.setPreferredSize(new Dimension(200, 25));
        panel_1.add(bContinue);

        Component verticalStrut_3 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_3);

        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
        flowLayout_2.setAlignment(FlowLayout.CENTER);
        panel.add(panel_2);

        b2Jugar = new JButton(Constants.PLAY);
        b2Jugar.setPreferredSize(new Dimension(200, 25));
        panel_2.add(b2Jugar);

        Component verticalStrut_6 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_6);

        JPanel panel_3 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
        flowLayout_1.setAlignment(FlowLayout.CENTER);
        panel.add(panel_3);

        bCrear = new JButton(Constants.CREAR);
        bCrear.setPreferredSize(new Dimension(200, 25));
        panel_3.add(bCrear);

        Component verticalStrut_2 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_2);

        JPanel panel_5 = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) panel_5.getLayout();
        flowLayout_4.setAlignment(FlowLayout.CENTER);
        panel.add(panel_5);

        bBackJugar = new JButton(Constants.BACK);
        bBackJugar.setPreferredSize(new Dimension(200, 25));
        panel_5.add(bBackJugar);

        return p;

    }

    private JPanel carregarVistaJugar2() {

        buttonsModeJugar = new ArrayList<>();

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel panel = new JPanel();

        panel.setBackground(new Color(240, 240, 240));
        p.add(panel);
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

        JLabel lblNewLabel = new JLabel(Constants.PLAY);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setForeground(SystemColor.activeCaption);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 33));
        panel_0.add(lblNewLabel);

        Component verticalStrut_0 = Box.createVerticalStrut(30);
        panel.add(verticalStrut_0);

        JPanel pareLlistes = new JPanel();
        pareLlistes.setLayout(new BorderLayout(0, 0));
        panel.add(pareLlistes);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(null, Constants.PUBLIC, TitledBorder.RIGHT, TitledBorder.TOP, null, null));
        pareLlistes.add(panel_4, BorderLayout.WEST);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

        listPublic = new JList(); //data has type Object[]
        listPublic.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listPublic.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listPublic.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(listPublic);
        listScroller.setPreferredSize(new Dimension(250, 80));
        panel_4.add(listScroller);

        Component verticalStrut_4 = Box.createVerticalStrut(30);
        panel.add(verticalStrut_4);


        panelUserList = new JPanel();
        panelUserList.setBorder(new TitledBorder(null, Constants.YOURS, TitledBorder.RIGHT, TitledBorder.TOP, null, null));
        pareLlistes.add(panelUserList, BorderLayout.EAST);
        panelUserList.setLayout(new BoxLayout(panelUserList, BoxLayout.X_AXIS));

        listUser = new JList(); //data has type Object[]
        listUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listUser.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listUser.setVisibleRowCount(-1);

        JScrollPane listScroller2 = new JScrollPane(listUser);
        listScroller2.setPreferredSize(new Dimension(250, 80));
        panelUserList.add(listScroller2);

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, Constants.MODES, TitledBorder.RIGHT, TitledBorder.TOP, null, null));
        pareLlistes.add(panel_5, BorderLayout.SOUTH);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

        JPanel panel_8 = new JPanel();
        panel_5.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
        buttonGroup_1 = new ButtonGroup();

        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Training");
        buttonGroup_1.add(rdbtnNewRadioButton_3);
        buttonsModeJugar.add(rdbtnNewRadioButton_3);
        rdbtnNewRadioButton_3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_8.add(rdbtnNewRadioButton_3);

        Component verticalStrut_2 = Box.createVerticalStrut(5);
        panel_8.add(verticalStrut_2);

        JRadioButton rdbtnNormal = new JRadioButton("Normal");
        buttonGroup_1.add(rdbtnNormal);
        buttonsModeJugar.add(rdbtnNormal);
        rdbtnNormal.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_8.add(rdbtnNormal);

        Component verticalStrut_3 = Box.createVerticalStrut(5);
        panel_8.add(verticalStrut_3);

        JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Time Trial");
        buttonGroup_1.add(rdbtnNewRadioButton_4);
        buttonsModeJugar.add(rdbtnNewRadioButton_4);
        rdbtnNewRadioButton_4.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_8.add(rdbtnNewRadioButton_4);

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
        panel.add(panel_2);

        bPlay = new JButton(Constants.PLAY);
        bPlay.setMinimumSize(new Dimension(200, 25));
        panel_2.add(bPlay);

        Component verticalStrut_6 = Box.createHorizontalStrut(10);
        panel_2.add(verticalStrut_6);


        bBackJugar2 = new JButton(Constants.BACK);
        bBackJugar2.setMinimumSize(new Dimension(200, 25));
        panel_2.add(bBackJugar2);

        return p;

    }

    //Update Views
    public void updateUserList(List<String> partides) {

        listUser.setListData(partides.toArray());

    }

    public void updatePublicList(List<String> partides) {
        listPublic.setListData(partides.toArray());
    }


    private ImageIcon scaleImage(ImageIcon imageIcon, int width, int heigth) {
        Image image = imageIcon.getImage();                                             // transform it
        Image newimg = image.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);     // scale it the smooth way
        return new ImageIcon(newimg);
    }

    public void updateView(String name) {
        this.cardLayout.show(this, name);
    }

    public JButton getbPerfil() {
        return bPerfil;
    }

    public JButton getbJugar() {
        return bJugar;
    }

    public JButton getbKakuroManagement() {
        return bKakuroManagement;
    }

    public JButton getbLogOff() {
        return bLogOff;
    }

    public JButton getbStatistics() {
        return bStatistics;
    }

    public JButton getbContinue() {
        return bContinue;
    }

    public JButton getB2Jugar() {
        return b2Jugar;
    }

    public JButton getbCrear() {
        return bCrear;
    }

    public JButton getbBackJugar() {
        return bBackJugar;
    }

    public JButton getbPlay() {
        return bPlay;
    }

    public JButton getbBackJugar2() {
        return bBackJugar2;
    }

    public JPanel getPanelUserList() {
        return panelUserList;
    }

    public JList getListPublic() {
        return listPublic;
    }

    public JList getListUser() {
        return listUser;
    }

    public ButtonGroup getButtonGroup_1() {
        return buttonGroup_1;
    }

    public ArrayList<JRadioButton> getButtonsModeJugar() {
        return buttonsModeJugar;
    }

}
