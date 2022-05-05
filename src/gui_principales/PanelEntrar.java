package gui_principales;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.Button;
import javax.swing.border.MatteBorder;

import gestion.GestionUsuario;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PanelEntrar extends JPanel implements MouseListener, ActionListener, KeyListener {
	private JTextField txtNombreUsuario;
	private JPasswordField passwordField;
	private Button btnLogIn;
	private JLabel lblIcoUsuario;
	private JLabel lblIcoPass;
	private JLabel lblTitulo;
	private JSeparator separator;

	
	//Variables globales
	//ArregloLogin al = new ArregloLogin();
	public static String usuario = "";
	/**
	 * Create the panel.
	 */
	public PanelEntrar() {
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(0,0,392,461);
		setLayout(null);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.addKeyListener(this);
		txtNombreUsuario.setFocusable(false);
		txtNombreUsuario.addMouseListener(this);
		txtNombreUsuario.setText("Nombre Usuario");
		txtNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtNombreUsuario.setBackground(SystemColor.inactiveCaptionBorder);
		txtNombreUsuario.setToolTipText("Ingresa tu usuario");
		txtNombreUsuario.setForeground(Color.GRAY);
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(70, 130, 240, 35);
		add(txtNombreUsuario);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(this);
		passwordField.addMouseListener(this);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		passwordField.setBackground(SystemColor.inactiveCaptionBorder);
		passwordField.setToolTipText("Ingresa tu contrase\u00F1a");
		passwordField.setText("*************");
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(70, 200, 240, 35);
		add(passwordField);
		
		btnLogIn = new Button("Ingresar");
		btnLogIn.addActionListener(this);
		btnLogIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogIn.addMouseListener(this);
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogIn.setBackground(new Color(0, 61, 105));
		btnLogIn.setBounds(70, 326, 240, 40);
		add(btnLogIn);
		
		lblIcoUsuario = new JLabel("");
		lblIcoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcoUsuario.setIcon(new ImageIcon(PanelEntrar.class.getResource("/images/ico_user-blue.png")));
		lblIcoUsuario.setBounds(25, 130, 35, 35);
		add(lblIcoUsuario);
		
		lblIcoPass = new JLabel("");
		lblIcoPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcoPass.setIcon(new ImageIcon(PanelEntrar.class.getResource("/images/ico_password-blue.png")));
		lblIcoPass.setBounds(25, 200, 35, 35);
		add(lblIcoPass);
		
		lblTitulo = new JLabel("Ingresa tus Datos");
		lblTitulo.setForeground(Color.DARK_GRAY);
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(70, 40, 240, 25);
		add(lblTitulo);
		
		separator = new JSeparator();
		separator.setBounds(70, 70, 240, 2);
		add(separator);


	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnLogIn) {
			mouseClickedBtnLogIn(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnLogIn) {
			mouseEnteredBtnLogIn(e);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnLogIn) {
			mouseExitedBtnLogIn(e);
		}
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == passwordField) {
			mousePressedPasswordField(e);
		}
		if (e.getSource() == txtNombreUsuario) {
			mousePressedTxtNombreUsuario(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mousePressedTxtNombreUsuario(MouseEvent e) {
		txtNombreUsuario.setFocusable(true);
		txtNombreUsuario.requestFocus();
		txtNombreUsuario.setText("");
		txtNombreUsuario.setForeground(Color.DARK_GRAY);
	}
	protected void mousePressedPasswordField(MouseEvent e) {
		passwordField.setText("");
		passwordField.setForeground(Color.DARK_GRAY);
	}
	protected void mouseEnteredBtnLogIn(MouseEvent e) {
		btnLogIn.setBackground(new Color(39, 92, 130));
	}
	protected void mouseExitedBtnLogIn(MouseEvent e) {
		btnLogIn.setBackground(new Color(0, 61, 105));
	}
	protected void mouseClickedBtnLogIn(MouseEvent e) {		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogIn) {
			actionPerformedBtnLogIn(e);
		}
	}
	protected void actionPerformedBtnLogIn(ActionEvent e) {
		//CODIGO INGRESAR
		try {
			if(txtNombreUsuario.getText().isEmpty() && passwordField.getPassword().toString().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
			} else if(txtNombreUsuario.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo de usuario no debe estar vacio");
			} else if(passwordField.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, "El campo de contraseña no debe estar vacio");
			} else {
				usuario = txtNombreUsuario.getText();
				String contra = new String(passwordField.getPassword());
				
				GestionUsuario gestionUsuario = new GestionUsuario();
				
				boolean resultado = gestionUsuario.verificarLogin(usuario, contra);
				
				if (resultado) {
					JOptionPane.showMessageDialog(null, "¡BIENVENIDO A SCHOOL DATA!");
					
					frmPrincipal pantalla = new frmPrincipal(); //instanciamos la pantalla principal
					pantalla.setLocationRelativeTo(null);//se posiciona en el centro de la pantalla
					pantalla.setVisible(true);
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this); //maximiza la pantalla
					frame.dispose(); //oculta el login
				} else {
					JOptionPane.showMessageDialog(null, "¡Datos incorrectos! Vuelve a ingresar tus datos");
				}				
			}
			
		} catch(Exception el){
			JOptionPane.showMessageDialog(null, "¡Rellene correctamente los campos!");
			txtNombreUsuario.setText("Ingresa tu usuario");
			txtNombreUsuario.setForeground(Color.GRAY);
			passwordField.setText("*************");
			passwordField.setForeground(Color.GRAY);
		}
		
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == passwordField) {
			keyTypedPasswordField(e);
		}
		if (e.getSource() == txtNombreUsuario) {
			keyTypedTxtNombreUsuario(e);
		}
	}
	protected void keyTypedTxtNombreUsuario(KeyEvent e) {

	}
	protected void keyTypedPasswordField(KeyEvent e) {

	}
}
