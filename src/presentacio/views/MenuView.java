package presentacio.views;

import domini.TipusDificultat;
import domini.TipusMode;
import presentacio.Constants;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MenuView extends JPanel {

    JButton bPerfil, bJugar, bKakuroManagement, bLogOff, bStatistics; //Botons Meú principal
    JButton bContinue, b2Jugar, bCrear, bBackJugar; //
    JButton bPlay, bBackJugar2, bBackCrear2, bGenerate;
    JButton bCrearKakuro, bGenerarKakuro, bImportar, bBackManagement;
    JPanel principal, menuJugar, menuJugar2, panelUserList, menuCrear, menuManagement, panelModes, gamePanel, editor;
    JList listPublic, listUser;
    ButtonGroup buttonGroup_1;
    CardLayout cardLayout;
    ArrayList<JRadioButton> buttonsModeJugar;
    JTextField txtName;
    JLabel lblName;
    JComboBox comboRow, comboColumns, comboColumnsEditor, comboRowEditor;
    private ArrayList<JRadioButton> buttonsDificultatJugar, buttonsModerCrear;
    TipusDificultat t;
    TipusMode m;
    boolean color;
    JPanel[][] pEditor;

    public MenuView() {

        cardLayout = new CardLayout(0, 0);
        setLayout(cardLayout);
        principal = carregaMenuPrincipal();
        add(principal, "principal");

        menuJugar = carregarMenuJugar();
        add(menuJugar, "jugar");

        menuJugar2 = carregarVistaJugar2();
        add(menuJugar2, "jugar2");

        menuCrear = carregarVistaMenuCrear();
        add(menuCrear, "crear");

        menuManagement = carregarMenuManagement();
        add(menuManagement, "management");

        editor = editor();
        add(editor, "editor");

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
        listPublic.setLayoutOrientation(JList.VERTICAL);
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

    private JPanel carregarVistaMenuCrear() {

        buttonsModerCrear = new ArrayList<>();
        buttonsDificultatJugar = new ArrayList<>();

        String[] nums = {"3", "4", "5", "6", "7", "8", "9", "10", "11"};

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

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel.add(panel_1);

        lblName = new JLabel(Constants.NAME);
        lblName.setFont(new Font("Arial", Font.BOLD, 15));
        panel_1.add(lblName);

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);

        txtName = new JTextField();
        txtName.setFont(new Font("Arial", Font.PLAIN, 15));
        txtName.setEditable(true);
        txtName.setToolTipText(Constants.USER);
        panel_2.add(txtName);
        txtName.setColumns(14);

        Component verticalStrut_4 = Box.createVerticalStrut(15);
        panel.add(verticalStrut_4);

        JPanel panel_ = new JPanel();
        panel.add(panel_);

        JLabel lblRows = new JLabel(Constants.ROWS);
        panel_.add(lblRows);

        comboRow = new JComboBox(nums);
        panel_.add(comboRow);

        JLabel lblColumns = new JLabel(Constants.COLUMNS);
        panel_.add(lblColumns);

        comboColumns = new JComboBox(nums);
        panel_.add(comboColumns);

        Component verticalStrut4 = Box.createVerticalStrut(15);
        panel.add(verticalStrut4);


        JPanel pareLlistes = new JPanel();
        pareLlistes.setLayout(new BorderLayout(0, 0));
        panel.add(pareLlistes);


        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, Constants.DIFFICULT, TitledBorder.CENTER, TitledBorder.TOP, null, null));
        pareLlistes.add(panel_5, BorderLayout.WEST);
        panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

        JPanel panel_8 = new JPanel();
        panel_5.add(panel_8);
        panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
        buttonGroup_1 = new ButtonGroup();

        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton(Constants.EASY);
        buttonGroup_1.add(rdbtnNewRadioButton_3);
        rdbtnNewRadioButton_3.setAlignmentX(Component.CENTER_ALIGNMENT);
        rdbtnNewRadioButton_3.addItemListener(e -> t = TipusDificultat.FACIL);
        panel_8.add(rdbtnNewRadioButton_3);

        Component verticalStrut_2 = Box.createVerticalStrut(5);
        panel_8.add(verticalStrut_2);

        JRadioButton rdbtnNormal = new JRadioButton(Constants.NORMAL, true);
        buttonGroup_1.add(rdbtnNormal);
        rdbtnNormal.setAlignmentX(Component.CENTER_ALIGNMENT);
        rdbtnNormal.addItemListener(e -> t = TipusDificultat.NORMAL);
        t = TipusDificultat.NORMAL;
        panel_8.add(rdbtnNormal);


        Component verticalStrut_3 = Box.createVerticalStrut(5);
        panel_8.add(verticalStrut_3);

        JRadioButton rdbtnNewRadioButton_4 = new JRadioButton(Constants.HARD);
        buttonGroup_1.add(rdbtnNewRadioButton_4);
        buttonsDificultatJugar.add(rdbtnNewRadioButton_4);
        rdbtnNewRadioButton_4.setAlignmentX(Component.CENTER_ALIGNMENT);
        rdbtnNewRadioButton_4.addItemListener(e -> t = TipusDificultat.DIFICIL);
        panel_8.add(rdbtnNewRadioButton_4);


        panelModes = new JPanel();
        panelModes.setBorder(new TitledBorder(null, Constants.MODES, TitledBorder.CENTER, TitledBorder.TOP, null, null));
        pareLlistes.add(panelModes, BorderLayout.EAST);
        panelModes.setLayout(new BoxLayout(panelModes, BoxLayout.X_AXIS));

        JPanel panel_81 = new JPanel();
        panelModes.add(panel_81);
        panel_81.setLayout(new BoxLayout(panel_81, BoxLayout.Y_AXIS));
        ButtonGroup buttonGroup_2 = new ButtonGroup();

        JRadioButton rdbtnNewTraining = new JRadioButton(Constants.TRAINING);
        buttonGroup_2.add(rdbtnNewTraining);
        buttonsModerCrear.add(rdbtnNewTraining);
        rdbtnNewTraining.setAlignmentX(Component.CENTER_ALIGNMENT);
        rdbtnNewTraining.addItemListener(e -> m = TipusMode.TRAINING);
        panel_81.add(rdbtnNewTraining);

        Component verticalStru_2 = Box.createVerticalStrut(5);
        panel_81.add(verticalStru_2);

        JRadioButton rdbtnNor = new JRadioButton(Constants.NORMAL, true);
        buttonGroup_2.add(rdbtnNor);
        buttonsModerCrear.add(rdbtnNor);
        m = TipusMode.NORMAL;
        rdbtnNor.setAlignmentX(Component.CENTER_ALIGNMENT);
        rdbtnNor.addItemListener(e -> m = TipusMode.NORMAL);
        panel_81.add(rdbtnNor);

        Component verticalStru2 = Box.createVerticalStrut(5);
        panel_81.add(verticalStru2);

        JRadioButton rdbtnSpeed = new JRadioButton(Constants.SPEED);
        buttonGroup_2.add(rdbtnSpeed);
        buttonsModerCrear.add(rdbtnSpeed);
        rdbtnSpeed.addItemListener(e -> m = TipusMode.CONTRARRELLOTGE);
        rdbtnSpeed.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_81.add(rdbtnSpeed);


        Component verticalStru4 = Box.createVerticalStrut(15);
        panel.add(verticalStru4);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel.add(panel2);

        bGenerate = new JButton(Constants.GENERATE);
        bGenerate.setSize(new Dimension(200, 25));
        panel2.add(bGenerate);

        Component verticalStrut_6 = Box.createHorizontalStrut(10);
        panel2.add(verticalStrut_6);


        bBackCrear2 = new JButton(Constants.BACK);
        bBackCrear2.setSize(new Dimension(200, 25));
        panel2.add(bBackCrear2);

        return p;

    }

    //

    private JPanel carregarMenuManagement() {

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

        JLabel lblNewLabel = new JLabel(Constants.MANAGEMENT);
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

        bCrearKakuro = new JButton(Constants.CREAR);
        bCrearKakuro.setPreferredSize(new Dimension(200, 25));
        panel_1.add(bCrearKakuro);

        Component verticalStrut_3 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_3);

        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
        flowLayout_2.setAlignment(FlowLayout.CENTER);
        panel.add(panel_2);

        bGenerarKakuro = new JButton(Constants.GENERATE);
        bGenerarKakuro.setPreferredSize(new Dimension(200, 25));
        panel_2.add(bGenerarKakuro);

        Component verticalStrut_6 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_6);

        JPanel panel_3 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
        flowLayout_1.setAlignment(FlowLayout.CENTER);
        panel.add(panel_3);

        bImportar = new JButton(Constants.IMPORT);
        bImportar.setPreferredSize(new Dimension(200, 25));
        panel_3.add(bImportar);

        Component verticalStrut_2 = Box.createVerticalStrut(10);
        panel.add(verticalStrut_2);

        JPanel panel_5 = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) panel_5.getLayout();
        flowLayout_4.setAlignment(FlowLayout.CENTER);
        panel.add(panel_5);

        bBackManagement = new JButton(Constants.BACK);
        bBackManagement.setPreferredSize(new Dimension(200, 25));
        panel_5.add(bBackManagement);

        return p;

    }

    private JPanel editor() {

        JPanel p = new JPanel(new BorderLayout(0, 0));
        String[] nums = {"3", "4", "5", "6", "7", "8", "9", "10", "11"};

        //Mesures
        JPanel panel = new JPanel();
        p.add(panel, BorderLayout.NORTH);

        JLabel lblRows = new JLabel(Constants.ROWS);
        panel.add(lblRows);

        comboRowEditor = new JComboBox(nums);
        panel.add(comboRowEditor);

        JLabel lblColumns = new JLabel(Constants.COLUMNS);
        panel.add(lblColumns);

        comboColumnsEditor = new JComboBox(nums);
        panel.add(comboColumnsEditor);

        gamePanel = new JPanel();
        gamePanel.add(generTaulell(3, 3));
        p.add(gamePanel, BorderLayout.CENTER);


        JPanel panelImages = new JPanel();
        panelImages.setMinimumSize(new Dimension(70, 100));
        panelImages.setMaximumSize(new Dimension(100, 100));
        panelImages.setPreferredSize(new Dimension(100, 100));
        p.add(panelImages, BorderLayout.SOUTH);

        JLabel lblColor1 = new JLabel("");
        panelImages.add(lblColor1);
        lblColor1.setMinimumSize(new Dimension(30, 30));
        lblColor1.setMaximumSize(new Dimension(30, 30));
        lblColor1.setOpaque(true);

        lblColor1.setBackground(Color.WHITE);
        lblColor1.setPreferredSize(new Dimension(40, 40));

        JLabel lblColor2 = new JLabel("");
        panelImages.add(lblColor2);
        lblColor2.setOpaque(true);

        lblColor2.setBackground(Color.BLACK);
        lblColor2.setPreferredSize(new Dimension(40, 40));


        lblColor1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                color = true;
                lblColor1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
                lblColor2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
            }
        });

        lblColor2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                color = false;
                lblColor2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
                lblColor1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
            }
        });

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

    public ArrayList<JRadioButton> getButtonsDificultatJugar() {
        return buttonsDificultatJugar;
    }

    public ArrayList<JRadioButton> getButtonsModerCrear() {
        return buttonsModerCrear;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JLabel getLblName() {
        return lblName;
    }

    public JButton getbBackCrear2() {
        return bBackCrear2;
    }

    public JButton getbGenerate() {
        return bGenerate;
    }

    public JComboBox getComboRow() {
        return comboRow;
    }

    public JComboBox getComboColumns() {
        return comboColumns;
    }

    public JButton getbCrearKakuro() {
        return bCrearKakuro;
    }

    public JButton getbGenerarKakuro() {
        return bGenerarKakuro;
    }

    public JButton getbImportar() {
        return bImportar;
    }

    public JButton getbBackManagement() {
        return bBackManagement;
    }

    public JPanel getPanelModes() {
        return panelModes;
    }

    public TipusDificultat getT() {
        return t;
    }

    public TipusMode getM() {
        return m;
    }

    public JPanel generTaulell(int row, int col) {
        System.out.println(row + " " + col);

        JPanel panel = new JPanel(new GridLayout(row, col));
        pEditor = new JPanel[row][col];

        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        panel.setPreferredSize(new Dimension(400, 400));

        for (int i = 0; row > i; i++) {
            for (int j = 0; col > j; j++) {

                JPanel panel1 = new JPanel(new BorderLayout());
                pEditor[i][j] = panel1;

                JTextField textFieldRIGHT = new JTextField();
                textFieldRIGHT.setBackground(new Color(0, 0, 0, 0));
                textFieldRIGHT.setForeground(Color.white);
                textFieldRIGHT.setHorizontalAlignment(JTextField.RIGHT);
                textFieldRIGHT.setColumns(5);

                JTextField textFieldLEFT = new JTextField();
                textFieldLEFT.setBackground(new Color(0, 0, 0, 0));
                textFieldLEFT.setForeground(Color.white);
                textFieldLEFT.setHorizontalAlignment(JTextField.LEFT);
                textFieldLEFT.setColumns(5);

                panel1.add(textFieldLEFT, BorderLayout.SOUTH);
                panel1.add(textFieldRIGHT, BorderLayout.EAST);

                if (i == 0 || j == 0) {
                    //Negre
                    textFieldRIGHT.setVisible(true);
                    textFieldLEFT.setVisible(true);
                    panel1.setBackground(Color.black);

                } else {
                    textFieldRIGHT.setVisible(false);
                    textFieldLEFT.setVisible(false);
                    panel1.setBackground(Color.white);
                    panel1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                            for (int i = 0; i < row; i++) {
                                for (int j = 0; j < col; j++) {
                                    if (e.getSource() == pEditor[i][j]) {
                                        if (color) {
                                            panel1.setBackground(Color.white);
                                            for (Component c : panel1.getComponents()) {
                                                c.setVisible(false);
                                            }
                                            panel1.validate();
                                        } else {
                                            panel1.setBackground(Color.BLACK);
                                            for (Component c : panel1.getComponents()) {
                                                c.setVisible(true);
                                            }
                                            panel1.validate();

                                        }
                                    }
                                }
                            }
                        }
                    });
                }
                panel.add(panel1);
            }
        }

        return panel;

    }

    private JPanel crearNegre() {
        JPanel negre = new JPanel(new BorderLayout());
        negre.setPreferredSize(new Dimension(50, 50));
        negre.setBackground(Color.black);

        JTextField textFieldRIGHT = new JTextField();
        textFieldRIGHT.setBackground(Color.black);
        textFieldRIGHT.setForeground(Color.white);
        textFieldRIGHT.setHorizontalAlignment(JTextField.RIGHT);
        textFieldRIGHT.setColumns(5);

        JTextField textFieldLEFT = new JTextField();
        textFieldLEFT.setBackground(Color.black);
        textFieldLEFT.setForeground(Color.white);
        textFieldLEFT.setHorizontalAlignment(JTextField.LEFT);
        textFieldLEFT.setColumns(5);

        negre.add(textFieldLEFT, BorderLayout.SOUTH);
        negre.add(textFieldRIGHT, BorderLayout.EAST);
        return negre;
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public JComboBox getComboColumnsEditor() {
        return comboColumnsEditor;
    }

    public JComboBox getComboRowEditor() {
        return comboRowEditor;
    }


    public void updateEditor() {
        System.out.println("Hola");
        gamePanel.removeAll();
        gamePanel.add(generTaulell(Integer.parseInt(comboRowEditor.getSelectedItem().toString()), Integer.parseInt(comboColumnsEditor.getSelectedItem().toString())));
        gamePanel.validate();
    }


}
