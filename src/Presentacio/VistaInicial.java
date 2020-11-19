package Presentacio;

import java.awt.*;

import javax.swing.*;

public class VistaInicial {
	private KakuroUI main;
	private JFrame root;
	
	private JPanel panelInici = new JPanel();
	private JPanel panelCon = new JPanel();
	
	private JLabel User= new JLabel("User:");
	private JTextField TUsuari = new JTextField();
	private JLabel Password = new JLabel("Password:");
	private JPasswordField TPassword = new JPasswordField();
	private JButton entrar = new JButton("Log in");
	
	private JLabel register = new JLabel("Click here to register", SwingConstants.CENTER);
	private JLabel guest = new JLabel("Click here to enter as a guest", SwingConstants.CENTER);
	
	
	public VistaInicial(KakuroUI mainKakuro) {
		main = mainKakuro;
		root = mainKakuro.getKakuroFrame();
		ini();
		
		root.getContentPane().removeAll();
		root.add(panelCon);
		root.repaint();
		root.setVisible(true);
	}
	
	private void ini() {
		panelInici = new JPanel(new GridBagLayout());
		
		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.HORIZONTAL;
		
		g.insets = new Insets(20, 50, 0, 50);
		g.ipady = 30;
		g.ipadx = 50;
		
		g.gridy = 1;
		panelInici.add(User, g);
		g.insets = new Insets(0, 50, 0, 50);
		g.gridy = 2;
		panelInici.add(TUsuari, g);
		g.gridy = 3;
		panelInici.add(Password, g);
		g.gridy = 4;
		panelInici.add(TPassword, g);
		
		g.insets.set(30, 50, 0, 50);
		g.gridy = 5;
		panelInici.add(entrar, g);
		g.insets.set(0, 50, -20, 50);
		g.gridy = 6;
		panelInici.add(register, g);
		g.insets.set(0, 50, 20, 50);
		g.gridy = 7;
		panelInici.add(guest, g);
		
		panelInici.setBackground(new java.awt.Color(255, 255, 255));
		panelInici.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
        panelInici.setForeground(new java.awt.Color(255, 255, 255));
        
        panelCon.setLayout(new GridBagLayout());
        panelCon.add(panelInici);
        setFonts();
	}
	
	private void setFonts() {
		Font fBold = new Font("Arial",Font.BOLD, 20);
		Font fPlain = new Font("Arial", Font.PLAIN, 18);
		
		User.setFont(fBold);
		TUsuari.setFont(fPlain);
		Password.setFont(fBold);
		TPassword.setFont(fPlain);
		register.setFont(new Font("Arial", Font.PLAIN, 12));
		guest.setFont(new Font("Arial", Font.PLAIN, 12));
	}
}
