package presentacio;

import presentacio.views.LoginView;
import presentacio.views.SignUpView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;

public class Sudoku extends JFrame  implements ActionListener, KeyListener, PropertyChangeListener, MouseListener, ItemListener, ListSelectionListener {

	//Kakuro

	private JButton entrar, signUp, backLogin, bLogOff, bPerfil, bJugar, b2Jugar, bKakuroManagement, bStadistics, bBackPerfil;
	private JButton bBackJugar, bContinue, bCrear, bPlay, bBackJugar2;
	private JTextField txtUser, txtRegUser;
	private JPasswordField txtPassword, txtRegPassword, txtRegPassword2;
	private JPanel panelInici, panelRegistrar, panelMenu, panelJugar, panelPerfil, panelJugar2;
	private JLabel lblRegistrar, lblGuest;
	private JList<String> listPublic, listUser;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int size = 1;
	private JFormattedTextField[][] nums;
	private JLabel[][] numsImg;
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JList<String> listVariant;
	private JPanel sudokuPanel;
	private JLabel lblUserName;
	private JLabel lblImage;
	private JLabel lblImageUser;
	private JLabel lblSurnameinfo;
	private JLabel lblNameinfo;
	private JLabel lblPasswordinfo;
	private JLabel lblUsernameinfo;
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
	private JSplitPane mainPanel;
	private ButtonGroup variantButtons;
	private ButtonGroup levelButtons;
	private JMenu mnLevel;
	private JMenu mnVariant;
	private JMenu mnModes;
	private Color color = new Color(1);
	private ArrayList<JLabel> lblColors = new ArrayList<JLabel>();
	private ArrayList<JRadioButtonMenuItem> rdbtnVariant = new ArrayList<JRadioButtonMenuItem>();
	private ArrayList<JRadioButtonMenuItem> rdbtnMode = new ArrayList<JRadioButtonMenuItem>();
	private ArrayList<JRadioButtonMenuItem> rdbtnLevel = new ArrayList<JRadioButtonMenuItem>();


	/**
	 * Create the frame.
	 */
	public Sudoku(LoginView loginView, SignUpView signUpView) {
		setPreferredSize(new Dimension(800, 600));
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		setIconImage(new ImageIcon(Sudoku.class.getResource("../assets/img/Logo_Kajugo.png")).getImage());

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

		panelMenu = carregaVistaMenu();
		cardPanel.add(panelMenu, "menu");

		panelJugar = carregarVistaJugar();
		cardPanel.add(panelJugar, "play");

		panelPerfil = carregaVistaPerfil();
		cardPanel.add(panelPerfil, "perfil");

		panelJugar2 = carregarVistaJugar2();
		cardPanel.add(panelJugar2, "play2");


		//JPanel panelSelector = new JPanel();
		//mainPanel.setRightComponent(panelSelector);
		//panelSelector.setLayout(new BoxLayout(panelSelector, BoxLayout.Y_AXIS));

		//JLabel lblMidoku = new JLabel("MIDOKU");
		//lblMidoku.setFont(new Font("Tahoma", Font.PLAIN, 40));
		//lblMidoku.setAlignmentX(Component.CENTER_ALIGNMENT);
		//panelSelector.add(lblMidoku);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setMinimumSize(new Dimension(0, 10));
		//panelSelector.add(verticalStrut_3);

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 65));
		//panelSelector.add(panel_2);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalStrut_7.setPreferredSize(new Dimension(17, 0));
		panel_2.add(horizontalStrut_7);

		JLabel lblMode = new JLabel("Mode");
		lblMode.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblMode);
		lblMode.setFont(new Font("Georgia", Font.BOLD, 18));

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_4);

		listModes = new JList<String>();
		panel_2.add(listModes);
		listModes.setFont(new Font("CourierNew", Font.BOLD, 12));
		listModes.setBackground(new Color(238, 238, 238));
		listModes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModes.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		listModes.addListSelectionListener(this);
		listModes.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 7561326095386089317L;
			String[] values = new String[]{"Checking", "Training", "Stand-Alone", "Speed"};

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		verticalStrut_4.setMinimumSize(new Dimension(0, 10));
		//panelSelector.add(verticalStrut_4);

		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 65));
		//panelSelector.add(panel_3);

		JLabel lblVariant = new JLabel("Variant");
		panel_3.add(lblVariant);
		lblVariant.setFont(new Font("Georgia", Font.BOLD, 18));
		lblVariant.setAlignmentX(Component.CENTER_ALIGNMENT);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_3.add(horizontalStrut_5);

		listVariant = new JList<String>();
		panel_3.add(listVariant);
		listVariant.setBackground(new Color(238, 238, 238));
		listVariant.addListSelectionListener(this);
		listVariant.setFont(new Font("CourierNew", Font.BOLD, 12));
		listVariant.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listVariant.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 8276875384363394368L;
			String[] values = new String[]{"9x9", "6x6", "4x4", "4x4 images"};

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		verticalStrut_5.setMinimumSize(new Dimension(0, 10));
		//panelSelector.add(verticalStrut_5);

		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 65));
		//panelSelector.add(panel_4);

		JLabel lblLevel = new JLabel("Level");
		panel_4.add(lblLevel);
		lblLevel.setFont(new Font("Georgia", Font.BOLD, 18));
		lblLevel.setAlignmentX(Component.CENTER_ALIGNMENT);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_6);

		listLevel = new JList<String>();
		panel_4.add(listLevel);
		listLevel.setBackground(new Color(238, 238, 238));
		listLevel.addListSelectionListener(this);
		listLevel.setFont(new Font("CourierNew", Font.BOLD, 12));
		listLevel.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1047319466281166954L;
			String[] values = new String[]{"Easy", "Medium", "Hard", "Wicked"};

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});

		Component verticalGlue_1 = Box.createVerticalGlue();
		//panelSelector.add(verticalGlue_1);

		btnPlay = new JButton("PLAY!");
		btnPlay.setMaximumSize(new Dimension(85, 25));
		btnPlay.setPreferredSize(new Dimension(85, 25));
		btnPlay.setToolTipText("Must be logged to play!");
		btnPlay.setEnabled(false);
		btnPlay.setActionCommand("Play");
		btnPlay.addActionListener(this);
		btnPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
		//panelSelector.add(btnPlay);

		Component verticalGlue_2 = Box.createVerticalGlue();
		//panelSelector.add(verticalGlue_2);

		JPanel panelUser = new JPanel();
		panelUser.setPreferredSize(new Dimension(200, 350));
		//mainPanel.setLeftComponent(panelUser);
		ImageIcon imageUser = new ImageIcon(Sudoku.class.getResource("img/user.png"));
		imageUser = scaleImage(imageUser, 128, 128);
		panelUser.setLayout(new BoxLayout(panelUser, BoxLayout.Y_AXIS));

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panelUser.add(verticalStrut_2);

		lblImage = new JLabel("");
		lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblImage.setIcon(imageUser);
		panelUser.add(lblImage);

		Component verticalStrut_14 = Box.createVerticalStrut(20);
		panelUser.add(verticalStrut_14);

		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(32767, 50));
		panel_1.setPreferredSize(new Dimension(10, 50));
		panelUser.add(panel_1);

		JLabel labelUser = new JLabel("User:");
		panel_1.add(labelUser);

		lblUserName = new JLabel("Guest");
		panel_1.add(lblUserName);

		Component verticalStrut = Box.createVerticalStrut(20);
		panelUser.add(verticalStrut);

		btnLogin = new JButton("Login");
		btnLogin.setPreferredSize(new Dimension(85, 25));
		btnLogin.setMaximumSize(new Dimension(85, 25));
		btnLogin.setActionCommand("Login");
		btnLogin.addActionListener(this);
		btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelUser.add(btnLogin);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panelUser.add(verticalStrut_1);

		btnLogOff = new JButton("Logoff");
		btnLogOff.setMaximumSize(new Dimension(85, 25));
		btnLogOff.setPreferredSize(new Dimension(85, 25));
		btnLogOff.setEnabled(false);
		btnLogOff.addActionListener(this);
		btnLogOff.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelUser.add(btnLogOff);

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		panelUser.add(verticalStrut_8);

		btnUserInfo = new JButton("User Info");
		btnUserInfo.setVisible(false);
		btnUserInfo.setActionCommand("Configuration");
		btnUserInfo.addActionListener(this);
		btnUserInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelUser.add(btnUserInfo);

		Component verticalGlue = Box.createVerticalGlue();
		panelUser.add(verticalGlue);

		sudokuCard = new JPanel();
		cardPanel.add(sudokuCard, "Sudoku");
		sudokuCard.setLayout(new BorderLayout(0, 0));

		JPanel titlePanel = new JPanel();
		sudokuCard.add(titlePanel, BorderLayout.NORTH);

		JLabel label_1 = new JLabel("MIDOKU");
		titlePanel.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_1.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel bodyPanel = new JPanel();
		sudokuCard.add(bodyPanel, BorderLayout.CENTER);

		JPanel panelInfoGame = new JPanel();
		panelInfoGame.setPreferredSize(new Dimension(90, 180));
		bodyPanel.add(panelInfoGame);
		panelInfoGame.setLayout(new BoxLayout(panelInfoGame, BoxLayout.Y_AXIS));

		Component verticalGlue_5 = Box.createVerticalGlue();
		panelInfoGame.add(verticalGlue_5);

		JLabel lblMode_1 = new JLabel("Mode : ");
		lblMode_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInfoGame.add(lblMode_1);

		lblModename = new JLabel("modeName");
		lblModename.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInfoGame.add(lblModename);

		Component verticalStrut_9 = Box.createVerticalStrut(20);
		panelInfoGame.add(verticalStrut_9);

		JLabel lblVariant_1 = new JLabel("Variant:");
		lblVariant_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInfoGame.add(lblVariant_1);

		lblVariantname = new JLabel("variantName");
		lblVariantname.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInfoGame.add(lblVariantname);

		Component verticalStrut_10 = Box.createVerticalStrut(20);
		panelInfoGame.add(verticalStrut_10);

		JLabel labelLevel = new JLabel("Level:");
		labelLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInfoGame.add(labelLevel);

		lblLevelname = new JLabel("levelName");
		lblLevelname.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInfoGame.add(lblLevelname);

		Component verticalGlue_6 = Box.createVerticalGlue();
		panelInfoGame.add(verticalGlue_6);

		Component horizontalStrut = Box.createHorizontalStrut(10);
		horizontalStrut.setPreferredSize(new Dimension(8, 0));
		bodyPanel.add(horizontalStrut);


		sudokuPanel = new JPanel();
		bodyPanel.add(sudokuPanel);
		sudokuPanel.setMinimumSize(new Dimension(350, 350));
		sudokuPanel.setMaximumSize(new Dimension(350, 350));
		sudokuPanel.setPreferredSize(new Dimension(350, 350));

		Component horizontalStrut_1 = Box.createHorizontalStrut(10);
		bodyPanel.add(horizontalStrut_1);

		panelButtonsGame = new JPanel();
		panelButtonsGame.setPreferredSize(new Dimension(100, 290));
		bodyPanel.add(panelButtonsGame);
		panelButtonsGame.setLayout(new BoxLayout(panelButtonsGame, BoxLayout.Y_AXIS));

		lblTimer = new JLabel("Timer:");
		lblTimer.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelButtonsGame.add(lblTimer);

		panelTimer = new JPanel();
		panelTimer.setMaximumSize(new Dimension(90, 25));
		panelTimer.setPreferredSize(new Dimension(60, 20));
		panelButtonsGame.add(panelTimer);

		JLabel lblTimersec = new JLabel("00");
		panelTimer.add(lblTimersec);

		JLabel lblTimePunt = new JLabel(":");
		panelTimer.add(lblTimePunt);

		JLabel lblTimeMin = new JLabel("00");
		panelTimer.add(lblTimeMin);

		Component verticalStrut_11 = Box.createVerticalStrut(20);
		panelButtonsGame.add(verticalStrut_11);

		btnHint = new JButton("Hint");
		btnHint.setVisible(false);
		btnHint.setMaximumSize(new Dimension(90, 25));
		btnHint.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelButtonsGame.add(btnHint);

		Component verticalStrut_12 = Box.createVerticalStrut(20);
		panelButtonsGame.add(verticalStrut_12);

		btnCheck = new JButton("Check");
		btnCheck.setVisible(false);
		btnCheck.setMaximumSize(new Dimension(90, 25));
		btnCheck.setPreferredSize(new Dimension(90, 25));
		btnCheck.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelButtonsGame.add(btnCheck);

		Component verticalStrut_13 = Box.createVerticalStrut(20);
		panelButtonsGame.add(verticalStrut_13);

		tglbtnSolution = new JToggleButton("Solution");
		tglbtnSolution.setMargin(new Insets(2, 2, 2, 2));
		tglbtnSolution.setVisible(false);
		tglbtnSolution.setMaximumSize(new Dimension(90, 25));
		tglbtnSolution.setFont(new Font("Dialog", Font.BOLD, 12));
		tglbtnSolution.setPreferredSize(new Dimension(90, 25));
		tglbtnSolution.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelButtonsGame.add(tglbtnSolution);

		Component verticalStrut_16 = Box.createVerticalStrut(20);
		verticalStrut_16.setPreferredSize(new Dimension(0, 40));
		panelButtonsGame.add(verticalStrut_16);

		panelImages = new JPanel();
		panelImages.setMinimumSize(new Dimension(70, 100));
		panelImages.setMaximumSize(new Dimension(100, 100));
		panelImages.setPreferredSize(new Dimension(100, 100));
		panelButtonsGame.add(panelImages);

		JLabel lblColor1 = new JLabel("");
		panelImages.add(lblColor1);
		lblColor1.setMinimumSize(new Dimension(30, 30));
		lblColor1.setMaximumSize(new Dimension(30, 30));
		lblColor1.setOpaque(true);
		lblColor1.addMouseListener(this);
		lblColor1.setBackground(Color.RED);
		lblColor1.setPreferredSize(new Dimension(40, 40));

		JLabel lblColor2 = new JLabel("");
		panelImages.add(lblColor2);
		lblColor2.setOpaque(true);
		lblColor2.addMouseListener(this);
		lblColor2.setBackground(Color.YELLOW);
		lblColor2.setPreferredSize(new Dimension(40, 40));

		JLabel lblColor3 = new JLabel("");
		panelImages.add(lblColor3);
		lblColor3.setOpaque(true);
		lblColor3.addMouseListener(this);
		lblColor3.setBackground(Color.GREEN);
		lblColor3.setPreferredSize(new Dimension(40, 40));

		JLabel lblColor4 = new JLabel("");
		panelImages.add(lblColor4);
		lblColor4.setOpaque(true);
		lblColor4.addMouseListener(this);
		lblColor4.setBackground(Color.CYAN);
		lblColor4.setPreferredSize(new Dimension(40, 40));

		lblColors.add(lblColor1);
		lblColors.add(lblColor2);
		lblColors.add(lblColor3);
		lblColors.add(lblColor4);

		//crearSudoku(9);

		JPanel bottomPanel = new JPanel();
		sudokuCard.add(bottomPanel, BorderLayout.SOUTH);

		lblUserProgress = new JLabel("User progress:");
		bottomPanel.add(lblUserProgress);

		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		bottomPanel.add(progressBar);

		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		horizontalStrut_8.setPreferredSize(new Dimension(40, 0));
		bottomPanel.add(horizontalStrut_8);



		cardLayout.show(cardPanel, "login");

		pack();

	}

	//Accions dels botons

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
			case "Login":
				loginUser();
				break;
			case "Logoff":
				logoffUser();
				break;
			case "Configuration":
				cardLayout.show(cardPanel, "Login");
				break;
			case "Back":
				((CardLayout) cardPanel.getLayout()).show(cardPanel, "Main");
				break;
			case "Play":
				jugarSudoku();
				progressBar.setIndeterminate(true);

				mnLevel.setEnabled(true);
				mnModes.setEnabled(true);
				mnVariant.setEnabled(true);

				break;
			case "Open":
				break;
			case "Save":
				break;
			case "Exit":
				int op = JOptionPane.showOptionDialog(new JFrame(), "Do you want to exit the game?",
						"Exit", JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, new Object[]{"Cancel", "Exit"}, JOptionPane.CANCEL_OPTION);
				if (op == 1) {
					cardLayout.show(cardPanel, "Main");
					mnLevel.setEnabled(false);
					mnModes.setEnabled(false);
					mnVariant.setEnabled(false);

				}

				break;

			case "Redo":
				try {
					manager.redo();
				} catch (CannotRedoException e2) {
					// TODO: handle exception
				}
				break;
			case "Undo":
				try {
					manager.undo();
				} catch (CannotUndoException e3) {
					// TODO: handle exception
				}
				//updateUndoState();
				//redoAction.updateRedoState();
				break;

			case "Clear":
				clearSudoku();
				break;
			case "Online Help":
				try {
					Desktop.getDesktop().browse(new URI("http://www.sudokudragon.com/sudokustrategy.htm"));
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (URISyntaxException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				break;

			case "About":
				//VidSerA15AboutContent aboutPanel;
				//try {
				//	aboutPanel = new VidSerA15AboutContent();
				//	aboutPanel.setProgramIcon(new ImageIcon(Sudoku.class.getResource("/activities/img/calculator.png")));
				//	aboutPanel.setProgramDescription("The traditional game called Sudoku.");
				// 	aboutPanel.setProgramName("Midoku");
				//	aboutPanel.setProgramCopyright("Copyright 2017 Sergi Vidiella");
				JDialog dialog = new JDialog();
				//	dialog.getContentPane().add(aboutPanel);
				dialog.pack();
				dialog.setVisible(true);
				//} catch (IOException e1) {
				// TODO Auto-generated catch block
				//	e1.printStackTrace();
				//}
				break;

			default:
				break;
		}

	}

	private void clearSudoku() {
		if (rdbtn4x4img.isSelected()) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					//numsImg[i][j].setBackground(testColor[i][j]);
				}
			}

		} else {

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (nums[i][j].isEditable()) nums[i][j].setValue(null);
				}
			}
		}

	}


	private ImageIcon scaleImage(ImageIcon imageIcon, int width, int heigth) {
		Image image = imageIcon.getImage();                                             // transform it
		Image newimg = image.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);     // scale it the smooth way
		return new ImageIcon(newimg);
	}


	public void jugarSudoku() {
		if (listVariant.isSelectionEmpty() || listModes.isSelectionEmpty() || listLevel.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Missing something to be selected!", "Error", JOptionPane.ERROR_MESSAGE);
		} else {

			if (listVariant.getSelectedIndex() == 3) {
				size = 4;
				sudokuPanel.removeAll();
				panelImages.setVisible(true);

				TaskColor task = new TaskColor();
				task.addPropertyChangeListener(this);
				task.execute();

			} else {
				size = Integer.parseInt(listVariant.getSelectedValue().substring(0, 1));
				sudokuPanel.removeAll();
				panelImages.setVisible(false);

				Task task = new Task();
				task.addPropertyChangeListener(this);
				task.execute();

			}

			if (listModes.getSelectedIndex() == 0) {

				btnCheck.setVisible(true);
				btnHint.setVisible(false);
				tglbtnSolution.setVisible(false);
				panelButtonsGame.remove(panelTimer);
				panelButtonsGame.remove(lblTimer);
				lblUserProgress.setVisible(false);
				progressBar.setVisible(false);

			} else {
				if (listModes.getSelectedIndex() == 1) {

					btnCheck.setVisible(true);
					btnHint.setVisible(true);
					tglbtnSolution.setVisible(true);
					panelButtonsGame.remove(panelTimer);
					panelButtonsGame.remove(lblTimer);
					lblUserProgress.setVisible(false);
					progressBar.setVisible(false);

				} else {

					btnCheck.setVisible(false);
					btnHint.setVisible(false);
					tglbtnSolution.setVisible(false);
					panelButtonsGame.add(panelTimer, 1);
					panelButtonsGame.add(lblTimer, 0);
					lblUserProgress.setVisible(true);
					progressBar.setVisible(true);

					progressBar.setIndeterminate(true);

				}
			}

			setLblVariantnameText(listVariant.getSelectedValue());
			setLblModenameText(listModes.getSelectedValue());
			setLblLevelnameText(listLevel.getSelectedValue());

			cardLayout.show(cardPanel, "Sudoku");
		}
	}


	public void ficavista(JPanel panel) {
		cardPanel.add(panel, "Kakuro");
		cardLayout.show(cardPanel, "Kakuro");
		pack();
	}


	private void loginUser() {

		//VidSerA14Login jdialog = new VidSerA14Login();
		//ImageIcon user = new ImageIcon(VidSerA14TestJOptionPane.class.getResource("/activities/img/user.png"));
		//user = scaleImage(user, 64, 64);
		//JOptionPane.showOptionDialog(null, jdialog, "Login", JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE, user, new Object[] {"Cancel", "Login"}, JOptionPane.CANCEL_OPTION);
		//System.out.println("Username: "+jdialog.getLoginUsername()+ " Password: "+jdialog.getLoginPassword());

		//if(checkUser(jdialog.getLoginUsername(), jdialog.getLoginPassword())) {

		//	loginButtonsActivated(true);

		//} else {

		//	JOptionPane.showMessageDialog(null, "User incorrect!");

		//}
	}

	private void logoffUser() {

		ImageIcon imageUser = (ImageIcon) getLblImageUserIcon();
		imageUser = scaleImage(imageUser, 32, 32);
		int op = JOptionPane.showOptionDialog(new JFrame(), "Do you want to logoff?",
				"Exit", JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE,
				imageUser, new Object[]{"Cancel", "Exit"}, JOptionPane.CANCEL_OPTION);

		if (op == 1) {
			imageUser = new ImageIcon(Sudoku.class.getResource("/activities/img/user.png"));
			imageUser = scaleImage(imageUser, 128, 128);
			setLblUserName("Guest");
			setLblImageIcon(imageUser);
			loginButtonsActivated(false);
		}

	}

	private void loginButtonsActivated(Boolean estat) {

		btnUserInfo.setVisible(estat);
		btnPlay.setEnabled(estat);
		btnLogOff.setEnabled(estat);
		btnLogin.setEnabled(!estat);

	}


	private boolean checkUser(String username, String password) {

		String user = "";
		String pass = "";

		if (username.equals(user) && password.equals(pass)) {
			ImageIcon imageUser = new ImageIcon(Sudoku.class.getResource("/activities/img/sergi.png"));
			imageUser = scaleImage(imageUser, 128, 128);

			setLblUserName("Sergi");
			setLblImageIcon(imageUser);
			setLblImageUserIcon(imageUser);
			;
			setLblUsernameinfoText("Sergi");
			setLblNameinfoText("Sergi");
			setLblSurnameinfoText("Vidiella");
			setLblPasswordinfoText("sergi");

			return true;

		} else {

			return false;

		}
	}


	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress" == evt.getPropertyName()) {
			int progress = (Integer) evt.getNewValue();
			progressBar.setIndeterminate(false);
			progressBar.setValue(progress);
		}
	}


	/*
	 * Executed in event dispatch thread
	 */
	public void done() {
		Toolkit.getDefaultToolkit().beep();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (rdbtn4x4img.isSelected()) {

			for (JLabel jLabel : lblColors) {
				if (e.getSource() == jLabel) {
					color = jLabel.getBackground();
					jLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
					System.out.println("1");
					for (JLabel jLabels : lblColors) {
						if (e.getSource() != jLabels) jLabels.setBorder(new LineBorder(new Color(0, 0, 0), 0));
					}
				}
			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (e.getSource() == numsImg[i][j]) {
						numsImg[i][j].setBackground(color);
						System.out.println("2");
					}
				}
			}

		} else {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (e.getSource().equals(nums[i][j])) {
						try {
							nums[i][j].selectAll();
						} catch (NullPointerException except) {
							// TODO: handle exception
							System.out.println("hola");
						}
					}
				}
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		//LEVEL
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (rdbtnOp1 == e.getItemSelectable() && sudokuCard.isVisible()) {

				listLevel.setSelectedIndex(0);
				jugarSudoku();
				activarRadioButtons(rdbtnLevel, rdbtnOp1);

			}

			if (rdbtnOp2 == e.getItemSelectable() && sudokuCard.isVisible()) {

				listLevel.setSelectedIndex(1);
				jugarSudoku();
				activarRadioButtons(rdbtnLevel, rdbtnOp2);

			}

			if (rdbtnOp3 == e.getItemSelectable() && sudokuCard.isVisible()) {

				listLevel.setSelectedIndex(2);
				jugarSudoku();
				activarRadioButtons(rdbtnLevel, rdbtnOp3);

			}

			if (rdbtnOp4 == e.getItemSelectable() && sudokuCard.isVisible()) {

				listLevel.setSelectedIndex(3);
				jugarSudoku();
				activarRadioButtons(rdbtnLevel, rdbtnOp4);

			}
		}

		//VARIANT
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (rdbtn9x9 == e.getItemSelectable() && sudokuCard.isVisible()) {

				listVariant.setSelectedIndex(0);
				jugarSudoku();
				activarRadioButtons(rdbtnVariant, rdbtn9x9);

			}

			if (rdbtn6x6 == e.getItemSelectable() && sudokuCard.isVisible()) {

				listVariant.setSelectedIndex(1);
				jugarSudoku();
				activarRadioButtons(rdbtnVariant, rdbtn6x6);

			}

			if (rdbtn4x4 == e.getItemSelectable() && sudokuCard.isVisible()) {

				listVariant.setSelectedIndex(2);
				jugarSudoku();
				activarRadioButtons(rdbtnVariant, rdbtn4x4);

			}

			if (rdbtn4x4img == e.getItemSelectable() && sudokuCard.isVisible()) {

				listVariant.setSelectedIndex(3);
				jugarSudoku();
				activarRadioButtons(rdbtnVariant, rdbtn4x4img);

			}
		}

		//MODE
		if (e.getStateChange() == ItemEvent.SELECTED) {

			if (rdbtnChecking == e.getItemSelectable() && sudokuCard.isVisible()) {

				listModes.setSelectedIndex(0);
				jugarSudoku();
				activarRadioButtons(rdbtnMode, rdbtnChecking);

			}

			if (rdbtnTraining == e.getItemSelectable() && sudokuCard.isVisible()) {

				listModes.setSelectedIndex(1);
				jugarSudoku();
				activarRadioButtons(rdbtnMode, rdbtnTraining);

			}

			if (rdbtnStand == e.getItemSelectable() && sudokuCard.isVisible()) {

				listModes.setSelectedIndex(2);
				jugarSudoku();
				activarRadioButtons(rdbtnMode, rdbtnStand);

			}

			if (rdbtnSpeed == e.getItemSelectable() && sudokuCard.isVisible()) {
				listModes.setSelectedIndex(3);
				jugarSudoku();
				activarRadioButtons(rdbtnMode, rdbtnSpeed);

			}
		}

	}

	public void activarRadioButtons(ArrayList<JRadioButtonMenuItem> llista, JRadioButtonMenuItem desButton) {

		for (JRadioButtonMenuItem button : llista) {
			if (button.equals(desButton)) {
				button.setEnabled(false);
			} else {
				button.setEnabled(true);
			}
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (e.getValueIsAdjusting()) {
			if (e.getSource().equals(listModes)) {
				JRadioButtonMenuItem but;
				int i = 0;
				Enumeration<AbstractButton> modeButtons = modesButtons.getElements();
				while (modeButtons.hasMoreElements()) {
					but = (JRadioButtonMenuItem) modeButtons.nextElement();
					if (i == listModes.getSelectedIndex() && mainPanel.isShowing())
						modesButtons.setSelected(but.getModel(), true);
					i++;
				}
			}

			if (e.getSource().equals(listLevel)) {
				JRadioButtonMenuItem but;
				int i = 0;
				Enumeration<AbstractButton> levelButton = levelButtons.getElements();
				while (levelButton.hasMoreElements()) {
					but = (JRadioButtonMenuItem) levelButton.nextElement();
					if (i == listLevel.getSelectedIndex() && mainPanel.isShowing())
						levelButtons.setSelected(but.getModel(), true);
					i++;
				}
			}

			if (e.getSource().equals(listVariant)) {
				JRadioButtonMenuItem but;
				int i = 0;
				Enumeration<AbstractButton> varButtons = variantButtons.getElements();
				while (varButtons.hasMoreElements()) {
					but = (JRadioButtonMenuItem) varButtons.nextElement();
					if (i == listVariant.getSelectedIndex() && mainPanel.isShowing())
						variantButtons.setSelected(but.getModel(), true);
					i++;
				}
			}
		}


	}


	// Getters and Setters

	public void setLblUserName(String text) {
		lblUserName.setText(text);
	}

	public void setLblImage(JLabel lblImage) {
		this.lblImage = lblImage;
	}

	public void setLblImageUser(JLabel lblImageUser) {
		this.lblImageUser = lblImageUser;
	}

	public JLabel getLblUserName() {
		return lblUserName;
	}

	public JLabel getLblImage() {
		return lblImage;
	}

	public JLabel getLblImageUser() {
		return lblImageUser;
	}

	public Icon getLblImageIcon() {
		return lblImage.getIcon();
	}

	public void setLblImageIcon(Icon icon) {
		lblImage.setIcon(icon);
	}

	public Icon getLblImageUserIcon() {
		return lblImageUser.getIcon();
	}

	public void setLblImageUserIcon(Icon icon_1) {
		lblImageUser.setIcon(icon_1);
	}

	public String getLblSurnameinfoText() {
		return lblSurnameinfo.getText();
	}

	public void setLblSurnameinfoText(String text_1) {
		lblSurnameinfo.setText(text_1);
	}

	public String getLblNameinfoText() {
		return lblNameinfo.getText();
	}

	public void setLblNameinfoText(String text_2) {
		lblNameinfo.setText(text_2);
	}

	public String getLblPasswordinfoText() {
		return lblPasswordinfo.getText();
	}

	public void setLblPasswordinfoText(String text_3) {
		lblPasswordinfo.setText(text_3);
	}

	public String getLblUsernameinfoText() {
		return lblUsernameinfo.getText();
	}

	public void setLblUsernameinfoText(String text_4) {
		lblUsernameinfo.setText(text_4);
	}

	public String getLblModenameText() {
		return lblModename.getText();
	}

	public void setLblModenameText(String text_5) {
		lblModename.setText(text_5);
	}

	public String getLblVariantnameText() {
		return lblVariantname.getText();
	}

	public void setLblVariantnameText(String text_6) {
		lblVariantname.setText(text_6);
	}

	public String getLblLevelnameText() {
		return lblLevelname.getText();
	}

	public void setLblLevelnameText(String text_7) {
		lblLevelname.setText(text_7);
	}

	//Task de sudoku amb numeros

	class Task extends SwingWorker<Void, Void> {
		/*
		 * Main task. Executed in background thread.
		 */
		@Override
		public Void doInBackground() {
			int progress = 0;
			// Initialize progress property.
			setProgress(0);

			int buit = 0;
			int total = 0;
			int ple = 0;

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (nums[i][j].getText().equals("")) total++;
				}
			}

			while (progress < 100) {

				buit = 0;

				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (nums[i][j].getText().equals("")) buit++;
					}
				}

				ple = total - buit;
				progress = Math.round(((float) ple / total) * 100);

				setProgress(Math.min(progress, 100));
			}
			return null;
		}
	}

	//Task sudoku amb colors

	class TaskColor extends SwingWorker<Void, Void> {
		/*
		 * Main task. Executed in background thread.
		 */
		@Override
		public Void doInBackground() {
			int progress = 0;
			// Initialize progress property.
			setProgress(0);

			Color c = new Color(240, 240, 240);
			int buit = 0;
			int total = 0;
			int ple = 0;


			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (numsImg[i][j].getBackground().equals(c)) total++;
				}
			}

			while (progress < 100) {

				buit = 0;

				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (numsImg[i][j].getBackground().equals(c)) buit++;
					}
				}

				ple = total - buit;
				progress = Math.round(((float) ple / total) * 100);

				setProgress(Math.min(progress, 100));
			}
			return null;

		}
	}


	//MENU

	private JMenuBar carregaMenu() {

		JMenuBar menuBar = new JMenuBar();

		//Opcio File

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOp1File = new JMenuItem("Open");
		ImageIcon opensIcon = new ImageIcon(Sudoku.class.getResource("img/open.png"));
		opensIcon = scaleImage(opensIcon, 16, 16);
		mntmOp1File.setIcon(opensIcon);
		mntmOp1File.addActionListener(this);
		mnFile.add(mntmOp1File);

		JMenuItem mntmOp2File = new JMenuItem("Save");
		mntmOp2File.addActionListener(this);
		mntmOp2File.setIcon(new ImageIcon(Sudoku.class.getResource("img/floppy.gif")));
		mnFile.add(mntmOp2File);

		JSeparator separatorFile = new JSeparator();
		mnFile.add(separatorFile);

		JMenuItem mntmOp3File = new JMenuItem("Exit");
		mntmOp3File.addActionListener(this);
		mntmOp3File.setIcon(new ImageIcon(Sudoku.class.getResource("img/close.gif")));
		mnFile.add(mntmOp3File);

		//Opcio Edit

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmOp1Edit = new JMenuItem("Clear");
		mntmOp1Edit.addActionListener(this);
		ImageIcon clearIcon = new ImageIcon(Sudoku.class.getResource(("img/clear.png")));
		clearIcon = scaleImage(clearIcon, 16, 16);
		mntmOp1Edit.setIcon(clearIcon);
		mnEdit.add(mntmOp1Edit);

		JSeparator separatorEdit = new JSeparator();
		mnEdit.add(separatorEdit);

		JMenuItem mntmOp2Edit = new JMenuItem("Undo");
		mntmOp2Edit.addActionListener(this);
		mntmOp2Edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mntmOp2Edit.setIcon(new ImageIcon(Sudoku.class.getResource("img/Redo_16x16_JFX.png")));
		mnEdit.add(mntmOp2Edit);

		JMenuItem mntmOp3Edit = new JMenuItem("Redo");
		mntmOp3Edit.addActionListener(this);
		mntmOp3Edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmOp3Edit.setIcon(new ImageIcon(Sudoku.class.getResource("img/Undo_16x16_JFX.png")));
		mnEdit.add(mntmOp3Edit);

		//Opcio Level
		levelButtons = new ButtonGroup();
		mnLevel = new JMenu("Level");
		mnLevel.setEnabled(false);
		menuBar.add(mnLevel);

		rdbtnOp1 = new JRadioButtonMenuItem("Easy");
		rdbtnOp1.addItemListener(this);
		mnLevel.add(rdbtnOp1);

		rdbtnOp2 = new JRadioButtonMenuItem("Medium");
		rdbtnOp2.addItemListener(this);
		mnLevel.add(rdbtnOp2);

		rdbtnOp3 = new JRadioButtonMenuItem("Hard");
		rdbtnOp3.addItemListener(this);
		mnLevel.add(rdbtnOp3);

		rdbtnOp4 = new JRadioButtonMenuItem("Wicked");
		rdbtnOp4.addItemListener(this);
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
		rdbtn9x9.addItemListener(this);
		mnVariant.add(rdbtn9x9);

		rdbtn6x6 = new JRadioButtonMenuItem("6x6");
		rdbtn6x6.addItemListener(this);
		mnVariant.add(rdbtn6x6);

		rdbtn4x4 = new JRadioButtonMenuItem("4x4");
		rdbtn4x4.addItemListener(this);
		mnVariant.add(rdbtn4x4);

		rdbtn4x4img = new JRadioButtonMenuItem("4x4 images");
		rdbtn4x4img.addItemListener(this);
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
		rdbtnChecking.addItemListener(this);
		mnModes.add(rdbtnChecking);

		rdbtnTraining = new JRadioButtonMenuItem("Training");
		rdbtnTraining.addItemListener(this);
		mnModes.add(rdbtnTraining);

		rdbtnStand = new JRadioButtonMenuItem("Stand-alone");
		rdbtnStand.addItemListener(this);
		mnModes.add(rdbtnStand);

		rdbtnSpeed = new JRadioButtonMenuItem("Speed");
		rdbtnSpeed.addItemListener(this);
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
		mntmRules.setIcon(new ImageIcon(Sudoku.class.getResource("img/amonestation.png")));
		mntmRules.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		mnHelp.add(mntmRules);
		mntmRules.addActionListener(this);

		JMenuItem mntmHelp = new JMenuItem("Online Help");
		mntmHelp.addActionListener(this);
		mntmHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		ImageIcon iconHelp1 = new ImageIcon(Sudoku.class.getResource("img/help.png"));
		iconHelp1 = scaleImage(iconHelp1, 16, 16);
		mntmHelp.setIcon(iconHelp1);
		mnHelp.add(mntmHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(this);
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
		ImageIcon iconHelp2 = new ImageIcon(Sudoku.class.getResource("img/about.png"));
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
		btnOpen.addActionListener(this);
		ImageIcon openIcon = new ImageIcon(Sudoku.class.getResource("img/open.png"));
		openIcon = scaleImage(openIcon, 16, 16);
		btnOpen.setIcon(openIcon);
		toolBar.add(btnOpen);

		JButton btnSave = new JButton("");
		btnSave.setActionCommand("Save");
		btnSave.addActionListener(this);
		btnSave.setIcon(new ImageIcon(Sudoku.class.getResource("img/floppy.gif")));
		toolBar.add(btnSave);

		JButton btnExit = new JButton("");
		btnExit.setActionCommand("Exit");
		btnExit.addActionListener(this);
		btnExit.setIcon(new ImageIcon(Sudoku.class.getResource("img/close.gif")));
		toolBar.add(btnExit);

		JButton btnClear = new JButton("");
		btnClear.setActionCommand("Clear");
		btnClear.addActionListener(this);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_2);
		//btnClear.setIcon(clearIcon);
		toolBar.add(btnClear);

		//JButton btnUndo = toolBar.add(UndoManagerHelper.getUndoAction(manager));
		JButton btnUndo = new JButton();
		btnUndo.setActionCommand("Undo");
		btnUndo.addActionListener(this);
		btnUndo.setText("");
		btnUndo.setIcon(new ImageIcon(Sudoku.class.getResource("img/Undo_16x16_JFX.png")));
		toolBar.add(btnUndo);

		//JButton btnRedo = toolBar.add(UndoManagerHelper.getRedoAction(manager));
		JButton btnRedo = new JButton();
		btnRedo.addActionListener(this);
		btnRedo.setActionCommand("Redo");
		btnRedo.setText("");
		btnRedo.setIcon(new ImageIcon(Sudoku.class.getResource("img/Redo_16x16_JFX.png")));
		toolBar.add(btnRedo);

		JButton btnHelp = new JButton("");
		btnHelp.setActionCommand("OnlineHelp");
		btnHelp.addActionListener(this);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		toolBar.add(horizontalStrut_3);
		//btnHelp.setIcon(iconHelp1);
		toolBar.add(btnHelp);

		JButton btnHelp2 = new JButton("");
		btnHelp2.setActionCommand("About");
		btnHelp2.addActionListener(this);
		//btnHelp2.setIcon(iconHelp2);
		toolBar.add(btnHelp2);

		return toolBar;

	}


	//KAKURO

	//Menu

	private JPanel carregaVistaMenu() {

		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel = new JPanel();

		panel.setBackground(new Color(240, 240, 240));
		p.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut);

		ImageIcon imageUser = new ImageIcon(getClass().getResource("../assets/img/Logo_Kajugo.png"));
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

		bStadistics = new JButton(Constants.STADISTICS);
		bStadistics.setPreferredSize(new Dimension(200, 25));
		panel_6.add(bStadistics);

		Component verticalStrut_4 = Box.createVerticalStrut(10);
		panel.add(verticalStrut_4);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);

		bLogOff = new JButton(Constants.LOGOFF);
		bLogOff.setPreferredSize(new Dimension(200, 25));
		panel_5.add(bLogOff);

		return p;

	}

	private JPanel carregarVistaJugar() {

		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel = new JPanel();

		panel.setBackground(new Color(240, 240, 240));
		p.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut);

		ImageIcon imageUser = new ImageIcon(getClass().getResource("../assets/img/Logo_Kajugo.png"));
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
		panel.add(panel_3);

		bBackJugar = new JButton(Constants.BACK);
		bBackJugar.setPreferredSize(new Dimension(200, 25));
		panel_5.add(bBackJugar);

		return p;

	}

	private JPanel carregarVistaJugar2() {

		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel = new JPanel();

		panel.setBackground(new Color(240, 240, 240));
		p.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut);

		ImageIcon imageUser = new ImageIcon(getClass().getResource("../assets/img/Logo_Kajugo.png"));
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
		pareLlistes.setLayout(new BorderLayout(0,0));
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


		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, Constants.YOURS, TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		pareLlistes.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		listUser = new JList(); //data has type Object[]
		listUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUser.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listUser.setVisibleRowCount(-1);

		JScrollPane listScroller2 = new JScrollPane(listUser);
		listScroller2.setPreferredSize(new Dimension(250, 80));
		panel_3.add(listScroller2);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, Constants.PUBLIC, TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		pareLlistes.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Training");
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_8.add(rdbtnNewRadioButton_3);

		Component verticalStrut_2 = Box.createVerticalStrut(5);
		panel_8.add(verticalStrut_2);

		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		buttonGroup_1.add(rdbtnNormal);
		rdbtnNormal.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_8.add(rdbtnNormal);

		Component verticalStrut_3 = Box.createVerticalStrut(5);
		panel_8.add(verticalStrut_3);

		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Time Trial");
		buttonGroup_1.add(rdbtnNewRadioButton_4);
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



	private JPanel carregaVistaPerfil() {

		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel = new JPanel();

		panel.setBackground(new Color(240, 240, 240));
		p.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut);

		ImageIcon imageUser = new ImageIcon(getClass().getResource("../assets/img/Logo_Kajugo.png"));
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

		return p;

	}





	//Actualitzar Vistes

	public void error(String missatge){

		JOptionPane.showOptionDialog(new JFrame(), missatge,
				"Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE,
				null, new Object[]{"Exit"}, JOptionPane.CANCEL_OPTION);

	}

	public void setDataPerfil(String id, int nKakurosResolts, int puntuacio) {

		System.out.println(id);
		lblUsernameinfo.setText(id);
		lblPasswordinfo.setText(""+nKakurosResolts);
		lblNameinfo.setText(""+puntuacio);

	}

	public void vistaRegistrat() {

		bPerfil.setVisible(true);
		bKakuroManagement.setVisible(true);

	}

	public void vistaGuest() {

		bPerfil.setVisible(false);
		bKakuroManagement.setVisible(false);

	}





	public void changeScreen(String screen) {
		cardLayout.show(cardPanel, screen);
	}

	public JButton getEntrar() {
		return entrar;
	}

	public JTextField getTUsuari() {
		return txtUser;
	}

	public JTextField getTPassword() {
		return txtPassword;
	}

	public JLabel getLblRegistrar() {
		return lblRegistrar;
	}

	public JButton getSignUp() {
		return signUp;
	}

	public JButton getBackLogin() {
		return backLogin;
	}

	public JButton getbLogOff() {
		return bLogOff;
	}

	public JButton getbPerfil() {
		return bPerfil;
	}

	public JButton getbJugar() {
		return bJugar;
	}

	public JLabel getLblGuest() {
		return lblGuest;
	}

	public JTextField getTxtRegUser() {
		return txtRegUser;
	}

	public JPasswordField getTxtRegPassword() {
		return txtRegPassword;
	}

	public JPasswordField getTxtRegPassword2() {
		return txtRegPassword2;
	}

	public JButton getbBackPerfil() {
		return bBackPerfil;
	}

	public JButton getbBackJugar() {
		return bBackJugar2;
	}

	public JButton getB2Jugar() {
		return b2Jugar;
	}

	public JButton getbPlay() { return bPlay; }

}