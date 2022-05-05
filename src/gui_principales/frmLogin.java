package gui_principales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;

public class frmLogin extends JFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private Label lblClose;
	
	//IMPORTAMOS LOS PANEL
	private PanelEntrar panelEntrar;
	private PanelRegistro panelRegistro;
	
	//Variables Globales
	//ArregloLogin al = new ArregloLogin();
	private JPanel paneMainContent;
	private JLabel lblImagen;
	private JLabel lblTxt1;
	private JLabel lblRegistrate;
	private JLabel lblIngresa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setLocationRelativeTo(null);
					frame.setUndecorated(true); //Elimina botones de minimizar, maximizar, cerrar
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmLogin.class.getResource("/images/icono01.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 461);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRegistrate = new JLabel("Reg\u00EDstrate");
		lblRegistrate.addMouseListener(this);
		
		lblIngresa = new JLabel("Ingresa");
		lblIngresa.addMouseListener(this);
		lblIngresa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIngresa.setVisible(false);
		lblIngresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresa.setForeground(new Color(173, 216, 230));
		lblIngresa.setBorder(null);
		lblIngresa.setBounds(156, 418, 70, 14);
		contentPane.add(lblIngresa);
		lblRegistrate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrate.setBorder(null);
		lblRegistrate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRegistrate.setForeground(new Color(173, 216, 230));
		lblRegistrate.setBounds(156, 418, 70, 14);
		contentPane.add(lblRegistrate);
		
		lblTxt1 = new JLabel("\u00BFA\u00FAn no tienes una cuenta?");
		lblTxt1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxt1.setForeground(Color.WHITE);
		lblTxt1.setBounds(104, 397, 161, 14);
		contentPane.add(lblTxt1);
		
		lblClose = new Label("X");
		lblClose.setBounds(746, 0, 38, 33);
		contentPane.add(lblClose);
		lblClose.setForeground(Color.BLACK);
		lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClose.addMouseListener(this);
		lblClose.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClose.setAlignment(Label.CENTER);
		lblClose.setBackground(SystemColor.inactiveCaptionBorder);
		
		paneMainContent = new JPanel();
		paneMainContent.setBackground(SystemColor.inactiveCaptionBorder);
		paneMainContent.setBounds(392, 0, 392, 461);
		contentPane.add(paneMainContent);
		paneMainContent.setLayout(null);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(0, 0, 392, 461);
		contentPane.add(lblImagen);
		lblImagen.setIcon(new ImageIcon(frmLogin.class.getResource("/images/login.jpg")));
		
		//Agregar panel entrar
		panelEntrar = new PanelEntrar();
		menuClicked(panelEntrar);
		
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblIngresa) {
			mouseClickedLblIngresa(e);
		}
		if (e.getSource() == lblRegistrate) {
			mouseClickedLblRegistrate(e);
		}
		if (e.getSource() == lblClose) {
			mouseClickedLblClose(e);
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {		
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == lblClose) {
			mouseEnteredLblClose(e);
		}
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == lblClose) {
			mouseExitedLblClose(e);
		}
	}
	
	protected void mouseClickedLblClose(MouseEvent e) {
		System.exit(0);
	}
	protected void mouseEnteredLblClose(MouseEvent e) {
		lblClose.setBackground(Color.RED);
		lblClose.setForeground(Color.WHITE);
	}
	protected void mouseExitedLblClose(MouseEvent e) {
		lblClose.setBackground(SystemColor.inactiveCaptionBorder);
		lblClose.setForeground(Color.BLACK);
	}
	public void actionPerformed(ActionEvent e) {
	}
	
	//Metodos panel
	public void menuClicked(JPanel panel) {
		
		paneMainContent.removeAll();
		paneMainContent.add(panel);
		paneMainContent.revalidate();
		paneMainContent.repaint();
	}
	protected void mouseClickedLblRegistrate(MouseEvent e) {
		panelRegistro = new PanelRegistro();
		menuClicked(panelRegistro);
		lblTxt1.setText("¿Ya tienes una cuenta?");;
		lblRegistrate.setVisible(false);
		lblIngresa.setVisible(true);
	}
	protected void mouseClickedLblIngresa(MouseEvent e) {
		panelEntrar = new PanelEntrar();
		menuClicked(panelEntrar);
		lblTxt1.setText("¿Aún no tienes una cuenta?");
		lblRegistrate.setVisible(true);
		lblIngresa.setVisible(false);
	}
}
