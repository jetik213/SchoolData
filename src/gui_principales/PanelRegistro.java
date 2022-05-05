package gui_principales;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import entidades.UsuarioEntity;
import gestion.GestionUsuario;
import rsdragdropfiles.RSDragDropFiles;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.Button;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PanelRegistro extends JPanel implements MouseListener, ActionListener, KeyListener {
	private JLabel lblRegistraTusDatos;
	private JTextField txtUsuario;
	private JPasswordField pass;
	private Button btnRegistrar;
	private JLabel lblNewLabel;
	private JLabel lblSiNoDeja;
	private JTextField txtContraseñaAdmi;
	private JButton btnCargar;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblFoto;
	private JSeparator separator;
	private JLabel lblIcoUsuario;
	private JLabel lblIcoContraseña;
	private JLabel lblIcoFoto;
	private JLabel lblIcoKey;
	private JLabel lblIcoCheck;
	private JLabel lblIcoNombre;
	private JLabel lblNombre;
	private JTextField txtNombre;	
	
	
	//Variables Globales
	String direccion = "";

	/**
	 * Create the panel.
	 */
	public PanelRegistro() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(0,0,392,461);
		setLayout(null);
		
		lblRegistraTusDatos = new JLabel("Registra tus Datos");
		lblRegistraTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistraTusDatos.setForeground(Color.DARK_GRAY);
		lblRegistraTusDatos.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblRegistraTusDatos.setBounds(70, 40, 240, 25);
		add(lblRegistraTusDatos);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(this);
		txtUsuario.setToolTipText("\u00A1M\u00E1ximo 10 caracteres!");
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setForeground(Color.DARK_GRAY);
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(new LineBorder(Color.DARK_GRAY));
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setBounds(155, 100, 175, 25);
		add(txtUsuario);
		
		pass = new JPasswordField();
		pass.addKeyListener(this);
		pass.addMouseListener(this);
		pass.setToolTipText("\u00A1M\u00E1ximo 10 caracteres!");
		pass.setText("*************");
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setForeground(Color.DARK_GRAY);
		pass.setBorder(new LineBorder(Color.DARK_GRAY));
		pass.setBackground(Color.WHITE);
		pass.setBounds(155, 146, 175, 25);
		add(pass);
		
		btnRegistrar = new Button("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.addMouseListener(this);
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.setBackground(new Color(0, 61, 105));
		btnRegistrar.setBounds(70, 380, 240, 40);
		add(btnRegistrar);
		
		lblNewLabel = new JLabel("Si tienes una contrase\u00F1a de administrador");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 290, 280, 14);
		add(lblNewLabel);
		
		lblSiNoDeja = new JLabel("ingr\u00E9sala, sino deja este espacio en blanco");
		lblSiNoDeja.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiNoDeja.setBounds(50, 303, 280, 14);
		add(lblSiNoDeja);
		
		txtContraseñaAdmi = new JTextField();
		txtContraseñaAdmi.setToolTipText("Deja en blanco sino tienes el serial");
		txtContraseñaAdmi.setHorizontalAlignment(SwingConstants.CENTER);
		txtContraseñaAdmi.setForeground(Color.DARK_GRAY);
		txtContraseñaAdmi.setBounds(60, 327, 270, 20);
		add(txtContraseñaAdmi);
		txtContraseñaAdmi.setColumns(10);
		
		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(this);
		btnCargar.setFont(new Font("Verdana", Font.BOLD, 10));
		btnCargar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCargar.setForeground(Color.WHITE);
		btnCargar.setBackground(new Color(70, 130, 180));
		btnCargar.setBounds(155, 233, 89, 23);
		add(btnCargar);
		
		lblUsuario = new JLabel("*Usuario :");
		lblUsuario.setForeground(Color.DARK_GRAY);
		lblUsuario.setFont(new Font("Verdana", Font.BOLD, 12));
		lblUsuario.setBounds(50, 100, 95, 25);
		add(lblUsuario);
		
		lblContrasea = new JLabel("*Contrase\u00F1a :");
		lblContrasea.setForeground(Color.DARK_GRAY);
		lblContrasea.setFont(new Font("Verdana", Font.BOLD, 12));
		lblContrasea.setBounds(50, 146, 95, 25);
		add(lblContrasea);
		
		lblFoto = new JLabel("Subir Foto :");
		lblFoto.setForeground(Color.DARK_GRAY);
		lblFoto.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFoto.setBounds(50, 233, 95, 25);
		add(lblFoto);
		
		separator = new JSeparator();
		separator.setBounds(70, 70, 240, 2);
		add(separator);
		
		lblIcoUsuario = new JLabel("");
		lblIcoUsuario.setIcon(new ImageIcon(PanelRegistro.class.getResource("/images/ico_user-blue.png")));
		lblIcoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcoUsuario.setBounds(10, 95, 30, 30);
		add(lblIcoUsuario);
		
		lblIcoContraseña = new JLabel("");
		lblIcoContraseña.setIcon(new ImageIcon(PanelRegistro.class.getResource("/images/ico_password-blue.png")));
		lblIcoContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcoContraseña.setBounds(10, 141, 30, 30);
		add(lblIcoContraseña);
		
		lblIcoFoto = new JLabel("");
		lblIcoFoto.setIcon(new ImageIcon(PanelRegistro.class.getResource("/images/ico_picture-blue.png")));
		lblIcoFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcoFoto.setBounds(10, 226, 30, 30);
		add(lblIcoFoto);
		
		lblIcoKey = new JLabel("");
		lblIcoKey.setIcon(new ImageIcon(PanelRegistro.class.getResource("/images/ico_key-blue.png")));
		lblIcoKey.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcoKey.setBounds(20, 317, 30, 30);
		add(lblIcoKey);
		
		lblIcoCheck = new JLabel("");
		lblIcoCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcoCheck.setBounds(254, 233, 20, 20);
		add(lblIcoCheck);
		
		lblIcoNombre = new JLabel("");
		lblIcoNombre.setIcon(new ImageIcon(PanelRegistro.class.getResource("/images/ico_name-blue.png")));
		lblIcoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcoNombre.setBounds(10, 186, 30, 30);
		add(lblIcoNombre);
		
		lblNombre = new JLabel("*Nombre :");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNombre.setBounds(50, 191, 95, 25);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setToolTipText("\u00A1M\u00E1ximo 20 caracteres!");
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setForeground(Color.DARK_GRAY);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setColumns(10);
		txtNombre.setBorder(new LineBorder(Color.DARK_GRAY));
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(155, 191, 175, 25);
		add(txtNombre);

	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnRegistrar) {
			mouseEnteredBtnRegistrar(e);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnRegistrar) {
			mouseExitedBtnRegistrar(e);
		}
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == pass) {
			mousePressedPass(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredBtnRegistrar(MouseEvent e) {
		btnRegistrar.setBackground(new Color(39, 92, 130));		
	}
	protected void mouseExitedBtnRegistrar(MouseEvent e) {
		btnRegistrar.setBackground(new Color(0, 61, 105));
	}	
	protected void mousePressedPass(MouseEvent e) {
		pass.setText("");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCargar) {
			actionPerformedBtnCargar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		//CODIGO INGRESAR
		try {
			if(txtUsuario.getText().isEmpty() && pass.getPassword().toString().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Los campos no deben estar vacios");
			} else if(txtUsuario.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo de usuario no debe estar vacio");
			} else if(pass.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, "El campo de contraseña no debe estar vacio");
			} else if(txtNombre.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo de nombre no debe estar vacio");
			} else {
				String usuario = txtUsuario.getText().trim();
				String contraseña = new String(pass.getPassword()).trim();
				String nombre = txtNombre.getText().trim().toUpperCase();
				int tipo = tipoUsuario();
				if(direccion.isEmpty()) {
					direccion = "src/images/usuarios/user_defecto.jpg";
				}
				if( tipo != 0) {
					
					UsuarioEntity usuarioEntity = new UsuarioEntity();
					usuarioEntity.setUsuario(usuario);
					usuarioEntity.setContra(contraseña);
					usuarioEntity.setNombre(nombre);
					usuarioEntity.setTipo(tipo);
					usuarioEntity.setRutaFoto(direccion);
					
					GestionUsuario gestionUsuario = new GestionUsuario();
					int resultado = gestionUsuario.registrarUsuario(usuarioEntity);
					
					if (resultado == 1) {
						JOptionPane.showMessageDialog(null, "Registro de usuario exitoso");
					} else {
						JOptionPane.showMessageDialog(null, "Registro de usuario incorrecto");
					}

					limpiar();
				} else {
					JOptionPane.showMessageDialog(null, "¡Contraseña de administror incorrecta!");
				}
								
			}
		} catch(Exception el){
			JOptionPane.showMessageDialog(null, "¡Rellene correctamente los campos!");
			limpiar();
		}	
	}
	
	void limpiar() {
		txtUsuario.setText("");
		pass.setText("*************");
		txtContraseñaAdmi.setText("");
		txtNombre.setText("");
		lblIcoCheck.setIcon(null);
	}

	protected void actionPerformedBtnCargar(ActionEvent e) {
		JFileChooser jf = new JFileChooser();
		jf.setMultiSelectionEnabled(false);//Para no poder seleccionar varios documentos o imagenes
		FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("*jpg","jpg");//Filtrar solo jpg
		jf.setFileFilter(filtroImagen);
		if(jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { //cuando da la opcion aceptar para cargar la imagen
			direccion = jf.getSelectedFile().getAbsolutePath(); //devuelve la ruta
			lblIcoCheck.setIcon(new ImageIcon(PanelRegistro.class.getResource("/images/ico_check-green.png"))); //carga el check verde si cargo correctamente la imagen
		}
	}
	
	private int tipoUsuario() {
		if (txtContraseñaAdmi.getText().isEmpty()) {
			return 1;
		}
		else if (txtContraseñaAdmi.getText().equals(UsuarioEntity.SERIAL_USUARIOS)) {
			return 2;
		} else {
			return 0;
		}
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtNombre) {
			keyTypedTxtNombre(e);
		}
		if (e.getSource() == pass) {
			keyTypedPass(e);
		}
		if (e.getSource() == txtUsuario) {
			keyTypedTxtUsuario(e);
		}
	}
	protected void keyTypedTxtUsuario(KeyEvent e) {
		if(txtUsuario.getText().length()>=10)
			e.consume();
	}
	protected void keyTypedPass(KeyEvent e) {
		if(pass.getPassword().length >=10)
			e.consume();
	}
	protected void keyTypedTxtNombre(KeyEvent e) {
		if(txtNombre.getText().length()>=20)
			e.consume();
	}
}
