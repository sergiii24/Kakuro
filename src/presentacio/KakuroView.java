package presentacio;

import presentacio.views.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KakuroView extends JFrame {

	//Kakuro

	private final JPanel panelInici;
	private final JPanel panelRegistrar;
	private final JPanel panelMenu;
	private final JPanel panelJugar;
	private final JPanel panelPerfil;
	private JPanel panelJugar2;

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private final int size = 1;
	private JFormattedTextField[][] nums;
	private JLabel[][] numsImg;
	private final CardLayout cardLayout;
	private final JPanel cardPanel;
	private JList<String> listVariant;
	private JPanel sudokuPanel;
	private JLabel lblUserName;
	private JLabel lblImage;
	private JLabel lblImageUser;
	private JButton btnUserInfo;
	private JButton btnPlay;
	private JButton btnLogOff;
	private JButton btnLogin;
	protected UndoManager manager = new UndoManager();
	private JProgressBar progressBar;
	private JLabel lblModename;
	private JLabel lblVariantname;
	private JLabel lblLevelname;
	private JList<String> listLevel;
	JList<String> listModes;



	private JButton btnHint;
	private JButton btnCheck;
	private JToggleButton tglbtnSolution;
	private JPanel panelTimer;
	private JPanel panelButtonsGame;
	private JLabel lblTimer;
	private JLabel lblUserProgress;
	private JPanel panelImages;
	private JRadioButtonMenuItem rdbtnOp1;
	private JRadioButtonMenuItem rdbtnOp2;
	private JRadioButtonMenuItem rdbtnOp3;
	private JRadioButtonMenuItem rdbtnOp4;
	private JRadioButtonMenuItem rdbtn9x9;
	private JRadioButtonMenuItem rdbtn6x6;
	private JRadioButtonMenuItem rdbtn4x4;
	private JRadioButtonMenuItem rdbtn4x4img;
	private JRadioButtonMenuItem rdbtnChecking;
	private JRadioButtonMenuItem rdbtnTraining;
	private JRadioButtonMenuItem rdbtnStand;
	private JRadioButtonMenuItem rdbtnSpeed;
	private ButtonGroup modesButtons;
	private JPanel sudokuCard;
	private ButtonGroup variantButtons;
	private ButtonGroup levelButtons;
	private JMenu mnLevel;
	private JMenu mnVariant;
	private JMenu mnModes;
	private final Color color = new Color(1);
	private final ArrayList<JLabel> lblColors = new ArrayList<JLabel>();
	private final ArrayList<JRadioButtonMenuItem> rdbtnVariant = new ArrayList<JRadioButtonMenuItem>();
	private final ArrayList<JRadioButtonMenuItem> rdbtnMode = new ArrayList<JRadioButtonMenuItem>();
	private final ArrayList<JRadioButtonMenuItem> rdbtnLevel = new ArrayList<JRadioButtonMenuItem>();


	/**
	 * Create the frame.
	 */
	public KakuroView(LoginView loginView, SignUpView signUpView, ProfileView profileView, MenuView menuView, GameView gameView) {
		setPreferredSize(new Dimension(800, 600));
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		setIconImage(new ImageIcon(KakuroView.class.getResource("../assets/img/Logo_Kajugo.png")).getImage());

		//setJMenuBar(menuBar);

		contentPane = new JPanel();
		//contentPane.setPreferredSize(new Dimension(600, 490));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);


		//INICI
		cardPanel = new JPanel();
		contentPane.add(cardPanel, BorderLayout.CENTER);
		cardLayout = new CardLayout(0, 0);
		cardPanel.setLayout(cardLayout);

		panelInici = loginView;
		cardPanel.add(panelInici, "login");

		panelRegistrar = signUpView;
		cardPanel.add(panelRegistrar, "reg");

		panelMenu = menuView;
		cardPanel.add(panelMenu, "menu");

		panelPerfil = profileView;
		cardPanel.add(panelPerfil, "perfil");

		panelJugar = gameView;
		cardPanel.add(panelJugar, "game");

		cardLayout.show(cardPanel, "login");

		pack();

	}




	private ImageIcon scaleImage(ImageIcon imageIcon, int width, int heigth) {
		Image image = imageIcon.getImage();                                             // transform it
		Image newimg = image.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);     // scale it the smooth way
		return new ImageIcon(newimg);
	}



	public void ficavista(JPanel panel) {
		cardPanel.add(panel, "Kakuro");
		cardLayout.show(cardPanel, "Kakuro");
		pack();
	}





	//MENU

	private JMenuBar carregaMenu() {

		JMenuBar menuBar = new JMenuBar();

		//Opcio File

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOp1File = new JMenuItem("Open");
		ImageIcon opensIcon = new ImageIcon(KakuroView.class.getResource("img/open.png"));
		opensIcon = scaleImage(opensIcon, 16, 16);
		mntmOp1File.setIcon(opensIcon);
		//mntmOp1File.addActionListener(this);
		mnFile.add(mntmOp1File);

		JMenuItem mntmOp2File = new JMenuItem("Save");
		//mntmOp2File.addActionListener(this);
		mntmOp2File.setIcon(new ImageIcon(KakuroView.class.getResource("img/floppy.gif")));
		mnFile.add(mntmOp2File);

		JSeparator separatorFile = new JSeparator();
		mnFile.add(separatorFile);

		JMenuItem mntmOp3File = new JMenuItem("Exit");
		//mntmOp3File.addActionListener(this);
		mntmOp3File.setIcon(new ImageIcon(KakuroView.class.getResource("img/close.gif")));
		mnFile.add(mntmOp3File);

		//Opcio Edit

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmOp1Edit = new JMenuItem("Clear");
		//mntmOp1Edit.addActionListener(this);
		ImageIcon clearIcon = new ImageIcon(KakuroView.class.getResource(("img/clear.png")));
		clearIcon = scaleImage(clearIcon, 16, 16);
		mntmOp1Edit.setIcon(clearIcon);
		mnEdit.add(mntmOp1Edit);

		JSeparator separatorEdit = new JSeparator();
		mnEdit.add(separatorEdit);

		JMenuItem mntmOp2Edit = new JMenuItem("Undo");
		//mntmOp2Edit.addActionListener(this);
		mntmOp2Edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mntmOp2Edit.setIcon(new ImageIcon(KakuroView.class.getResource("img/Redo_16x16_JFX.png")));
		mnEdit.add(mntmOp2Edit);

		JMenuItem mntmOp3Edit = new JMenuItem("Redo");
		//mntmOp3Edit.addActionListener(this);
		mntmOp3Edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmOp3Edit.setIcon(new ImageIcon(KakuroView.class.getResource("img/Undo_16x16_JFX.png")));
		mnEdit.add(mntmOp3Edit);

		//Opcio Level
		levelButtons = new ButtonGroup();
		mnLevel = new JMenu("Level");
		mnLevel.setEnabled(false);
		menuBar.add(mnLevel);

		rdbtnOp1 = new JRadioButtonMenuItem("Easy");
		//rdbtnOp1.addItemListener(this);
		mnLevel.add(rdbtnOp1);

		rdbtnOp2 = new JRadioButtonMenuItem("Medium");
		//rdbtnOp2.addItemListener(this);
		mnLevel.add(rdbtnOp2);

		rdbtnOp3 = new JRadioButtonMenuItem("Hard");
		//rdbtnOp3.addItemListener(this);
		mnLevel.add(rdbtnOp3);

		rdbtnOp4 = new JRadioButtonMenuItem("Wicked");
		//rdbtnOp4.addItemListener(this);
		mnLevel.add(rdbtnOp4);

		levelButtons.add(rdbtnOp1);
		levelButtons.add(rdbtnOp2);
		levelButtons.add(rdbtnOp3);
		levelButtons.add(rdbtnOp4);

		rdbtnLevel.add(rdbtnOp1);
		rdbtnLevel.add(rdbtnOp2);
		rdbtnLevel.add(rdbtnOp3);
		rdbtnLevel.add(rdbtnOp4);

		//Opcio Variant
		variantButtons = new ButtonGroup();
		mnVariant = new JMenu("Variant");
		mnVariant.setEnabled(false);
		menuBar.add(mnVariant);

		rdbtn9x9 = new JRadioButtonMenuItem("9x9");
		//rdbtn9x9.addItemListener(this);
		mnVariant.add(rdbtn9x9);

		rdbtn6x6 = new JRadioButtonMenuItem("6x6");
		//rdbtn6x6.addItemListener(this);
		mnVariant.add(rdbtn6x6);

		rdbtn4x4 = new JRadioButtonMenuItem("4x4");
		//rdbtn4x4.addItemListener(this);
		mnVariant.add(rdbtn4x4);

		rdbtn4x4img = new JRadioButtonMenuItem("4x4 images");
		//rdbtn4x4img.addItemListener(this);
		mnVariant.add(rdbtn4x4img);

		variantButtons.add(rdbtn9x9);
		variantButtons.add(rdbtn6x6);
		variantButtons.add(rdbtn4x4);
		variantButtons.add(rdbtn4x4img);

		rdbtnVariant.add(rdbtn9x9);
		rdbtnVariant.add(rdbtn6x6);
		rdbtnVariant.add(rdbtn4x4);
		rdbtnVariant.add(rdbtn4x4img);

		//Opcio Modes
		modesButtons = new ButtonGroup();
		mnModes = new JMenu("Modes");
		mnModes.setEnabled(false);
		menuBar.add(mnModes);

		rdbtnChecking = new JRadioButtonMenuItem("Checking");
		//rdbtnChecking.addItemListener(this);
		mnModes.add(rdbtnChecking);

		rdbtnTraining = new JRadioButtonMenuItem("Training");
		//rdbtnTraining.addItemListener(this);
		mnModes.add(rdbtnTraining);

		rdbtnStand = new JRadioButtonMenuItem("Stand-alone");
		//rdbtnStand.addItemListener(this);
		mnModes.add(rdbtnStand);

		rdbtnSpeed = new JRadioButtonMenuItem("Speed");
		//rdbtnSpeed.addItemListener(this);
		mnModes.add(rdbtnSpeed);

		modesButtons.add(rdbtnChecking);
		modesButtons.add(rdbtnTraining);
		modesButtons.add(rdbtnStand);
		modesButtons.add(rdbtnSpeed);

		rdbtnMode.add(rdbtnChecking);
		rdbtnMode.add(rdbtnTraining);
		rdbtnMode.add(rdbtnStand);
		rdbtnMode.add(rdbtnSpeed);

		//Opcio Help

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmRules = new JMenuItem("Rules");
		mntmRules.setIcon(new ImageIcon(KakuroView.class.getResource("img/amonestation.png")));
		mntmRules.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		mnHelp.add(mntmRules);
		//mntmRules.addActionListener(this);

		JMenuItem mntmHelp = new JMenuItem("Online Help");
		//mntmHelp.addActionListener(this);
		mntmHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		ImageIcon iconHelp1 = new ImageIcon(KakuroView.class.getResource("img/help.png"));
		iconHelp1 = scaleImage(iconHelp1, 16, 16);
		mntmHelp.setIcon(iconHelp1);
		mnHelp.add(mntmHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		//mntmAbout.addActionListener(this);
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
		ImageIcon iconHelp2 = new ImageIcon(KakuroView.class.getResource("img/about.png"));
		iconHelp2 = scaleImage(iconHelp2, 16, 16);
		mntmAbout.setIcon(iconHelp2);
		mnHelp.add(mntmAbout);

		return menuBar;

	}


	//TOOLBAR

	private JToolBar getToolBar() {

		JToolBar toolBar = new JToolBar();
		//contentPane.add(toolBar, BorderLayout.NORTH);

		JButton btnOpen = new JButton("");
		btnOpen.setActionCommand("Open");
		//btnOpen.addActionListener(this);
		ImageIcon openIcon = new ImageIcon(KakuroView.class.getResource("img/open.png"));
		openIcon = scaleImage(openIcon, 16, 16);
		btnOpen.setIcon(openIcon);
		toolBar.add(btnOpen);

		JButton btnSave = new JButton("");
		btnSave.setActionCommand("Save");
		//btnSave.addActionListener(this);
		btnSave.setIcon(new ImageIcon(KakuroView.class.getResource("img/floppy.gif")));
		toolBar.add(btnSave);

		JButton btnExit = new JButton("");
		btnExit.setActionCommand("Exit");
		//btnExit.addActionListener(this);
		btnExit.setIcon(new ImageIcon(KakuroView.class.getResource("img/close.gif")));
		toolBar.add(btnExit);

		JButton btnClear = new JButton("");
		btnClear.setActionCommand("Clear");
		//btnClear.addActionListener(this);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_2);
		//btnClear.setIcon(clearIcon);
		toolBar.add(btnClear);

		//JButton btnUndo = toolBar.add(UndoManagerHelper.getUndoAction(manager));
		JButton btnUndo = new JButton();
		btnUndo.setActionCommand("Undo");
		//btnUndo.addActionListener(this);
		btnUndo.setText("");
		btnUndo.setIcon(new ImageIcon(KakuroView.class.getResource("img/Undo_16x16_JFX.png")));
		toolBar.add(btnUndo);

		//JButton btnRedo = toolBar.add(UndoManagerHelper.getRedoAction(manager));
		JButton btnRedo = new JButton();
		//btnRedo.addActionListener(this);
		btnRedo.setActionCommand("Redo");
		btnRedo.setText("");
		btnRedo.setIcon(new ImageIcon(KakuroView.class.getResource("img/Redo_16x16_JFX.png")));
		toolBar.add(btnRedo);

		JButton btnHelp = new JButton("");
		btnHelp.setActionCommand("OnlineHelp");
		//btnHelp.addActionListener(this);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_3);
		//btnHelp.setIcon(iconHelp1);
		toolBar.add(btnHelp);

		JButton btnHelp2 = new JButton("");
		btnHelp2.setActionCommand("About");
		//btnHelp2.addActionListener(this);
		//btnHelp2.setIcon(iconHelp2);
		toolBar.add(btnHelp2);

		return toolBar;

	}


	//KAKURO

	//Menu






	//Actualitzar Vistes

	public void error(String missatge){

		JOptionPane.showOptionDialog(new JFrame(), missatge,
				"Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE,
				null, new Object[]{"Exit"}, JOptionPane.CANCEL_OPTION);

	}


	public void changeScreen(String screen) {
		cardLayout.show(cardPanel, screen);
	}




}