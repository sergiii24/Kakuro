package Presentació;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class KakuroUI {

	private JFrame kakuroFrame;
	
	private JMenuBar menuBar;
	
	final JMenu aux_menu = new JMenu("Options");
	final JMenuItem exit = new JMenuItem("Exit");
	final JMenuItem backmenu = new JMenuItem("Tornar al menu");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		KakuroUI k = new KakuroUI();
		
		k.kakuroFrame.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public KakuroUI() {
		this.kakuroFrame = new JFrame("Kakuro");
		this.kakuroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.kakuroFrame.setLayout(new BorderLayout());
		this.kakuroFrame.setResizable(false);
		ini_menu_bar();
		this.kakuroFrame.setJMenuBar(this.menuBar);
		this.kakuroFrame.setSize(730, 730);
		
		VistaInicial view = new VistaInicial(this);
	}
	
	private void ini_menu_bar() {
		this.menuBar = new JMenuBar();
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel msg = new JLabel("<html>Estàs segur que vols sortir?<br/>(No es guardarà el progrés actual)</html>");
				Object[] options = {"Si", "No"};
				int input = JOptionPane.showOptionDialog(kakuroFrame, msg,
						"Tancar app",
						JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[1]);
				if (input == 0) System.exit(0);
			}
		});
		aux_menu.add(exit);
		
		backmenu.setEnabled(false);
		aux_menu.add(backmenu);
		this.menuBar.add(aux_menu);
	}
	
	public JFrame getKakuroFrame() {
		return this.kakuroFrame;
	}

}
