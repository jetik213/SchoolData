package gui_principales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.image.BufferedImage; //ass
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.awt.Image;

import entidades.UsuarioEntity;
import gestion.GestionUsuario;

import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseMotionListener;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;

import javax.imageio.ImageIO;
import javax.swing.DebugGraphics;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class frmPrincipal extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

	private JPanel contentPane;
	private JPanel paneMenu;
	private JPanel paneMainContent;

	/**
	 * Launch the application.
	 */
	
	//IMPORTAMOS LOS PANEL
	private PanelConsultaAlumnos panelConsultaAlumnos;
	private PanelConsultaCursos panelConsultaCursos;
	private PanelConsultaDocentes panelConsultaDocentes;
	private PanelConsultaMatriculas panelConsultaMatriculas;
	private PanelConsultaRetiros panelConsultaRetiros;
	private PanelMantenimientoAlumno panelMantenimientoAlumno;
	private PanelMantenimientoDocente panelMantenimientoDocente;
	private PanelMantenimientoCurso panelMantenimientoCurso;
	private PanelRegistroMatricula panelRegistroMatricula;
	private PanelRegistroRetiro panelRegistroRetiro;
	private PanelReportePendiente panelReportePendiente;
	private PanelReporteVigente panelReporteVigente;
	private PanelReporteCurso panelReporteCurso;
	private PanelReporteRetirados panelReporteRetirados;
	private PanelReporteDocenteHoraria panelReporteDocenteHoraria;
	
	private JPanel paneConsulta;
	private JLabel lblConsulta;
	private JPanel paneMantenimiento;
	private JLabel lblMantenimiento;
	private JPanel paneRegistro;
	private JLabel lblRegistro;
	private JSeparator separatorReporteDeAlumnos;
	private JPanel paneReporte;
	private JLabel lblReporte;
	private JLabel lblLogo;
	private JPanel panelEncabezado;
	private Label lblSalir;
	private Panel paneHeader;
	private JSeparator separator;
	private Panel paneMinimizar;
	private JLabel lblTextoLogo;
	private JLabel lblIconoLogo;
	private JLabel lblNameUser;
	private JPanel paneUser;
	private JLabel lblTitulo;
	private JLabel lblIco;
	

	private JLabel lblIcoConsulta;
	private JLabel lblIcoMantenimiento;
	private JLabel lblIcoRegistro;
	private JLabel lblIcoReporte;
	private JPanel paneAcerca;
	private JLabel lblAcerca;
	private JLabel lblIcoAcerca;
	private JLabel lblFrase1;
	private JLabel lblFrase2;
	private JComboBox cboSelect;
	private JLabel lblIcoUser;
	private JPanel paneCerrarSesion;
	private JLabel lblCerrarSesion;
	private JLabel lblIcoCerrarSesion;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Variables globales de almacenamiento de posición
	int xMouse, yMouse;
	//Variables globales
	ArrayList<UsuarioEntity> listaUsuario = new ArrayList<UsuarioEntity>();
	String nomUser = PanelEntrar.usuario;
	/**
	 * Create the frame.
	 */
	public frmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmPrincipal.class.getResource("/images/icono01.png")));
		setBackground(new Color(0, 154, 66));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 720);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		paneMenu = new JPanel();
		paneMenu.setBackground(new Color(0, 33, 51));
		paneMenu.setBounds(0, 0, 315, 720);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		paneConsulta = new JPanel();
		paneConsulta.addMouseListener(this);
		paneConsulta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneConsulta.setLayout(null);
		paneConsulta.setBackground(new Color(0, 61, 105));
		paneConsulta.setBounds(10, 261, 295, 40);
		paneMenu.add(paneConsulta);
		
		lblConsulta = new JLabel("CONSULTA");
		lblConsulta.setHorizontalAlignment(SwingConstants.LEFT);
		lblConsulta.setForeground(Color.WHITE);
		lblConsulta.setFont(new Font("Verdana", Font.BOLD, 14));
		lblConsulta.setBounds(55, 0, 230, 40);
		paneConsulta.add(lblConsulta);
		
		lblIcoConsulta = new JLabel("");
		lblIcoConsulta.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoConsulta_White.png")));
		lblIcoConsulta.setBounds(16, 8, 24, 24);
		paneConsulta.add(lblIcoConsulta);
		
		paneMantenimiento = new JPanel();
		paneMantenimiento.addMouseListener(this);
		paneMantenimiento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneMantenimiento.setLayout(null);
		paneMantenimiento.setBackground(new Color(0, 61, 105));
		paneMantenimiento.setBounds(10, 311, 295, 40);
		paneMenu.add(paneMantenimiento);
		
		lblMantenimiento = new JLabel("MANTENIMIENTO");
		lblMantenimiento.setHorizontalAlignment(SwingConstants.LEFT);
		lblMantenimiento.setForeground(Color.WHITE);
		lblMantenimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		lblMantenimiento.setBounds(55, 0, 230, 40);
		paneMantenimiento.add(lblMantenimiento);
		
		lblIcoMantenimiento = new JLabel("");
		lblIcoMantenimiento.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoMantenimiento_White.png")));
		lblIcoMantenimiento.setBounds(16, 8, 24, 24);
		paneMantenimiento.add(lblIcoMantenimiento);
		
		paneRegistro = new JPanel();
		paneRegistro.addMouseListener(this);
		paneRegistro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneRegistro.setLayout(null);
		paneRegistro.setBackground(new Color(0, 61, 105));
		paneRegistro.setBounds(10, 361, 295, 40);
		paneMenu.add(paneRegistro);
		
		lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistro.setForeground(Color.WHITE);
		lblRegistro.setFont(new Font("Verdana", Font.BOLD, 14));
		lblRegistro.setBounds(55, 0, 230, 40);
		paneRegistro.add(lblRegistro);
		
		lblIcoRegistro = new JLabel("");
		lblIcoRegistro.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoRegistro_White.png")));
		lblIcoRegistro.setBounds(16, 8, 24, 24);
		paneRegistro.add(lblIcoRegistro);
		
		paneReporte = new JPanel();
		paneReporte.addMouseListener(this);
		paneReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneReporte.setLayout(null);
		paneReporte.setBackground(new Color(0, 61, 105));
		paneReporte.setBounds(10, 411, 295, 40);
		paneMenu.add(paneReporte);
		
		lblReporte = new JLabel("REPORTE");
		lblReporte.setHorizontalAlignment(SwingConstants.LEFT);
		lblReporte.setForeground(Color.WHITE);
		lblReporte.setFont(new Font("Verdana", Font.BOLD, 14));
		lblReporte.setBounds(55, 0, 230, 40);
		paneReporte.add(lblReporte);
		
		lblIcoReporte = new JLabel("");
		lblIcoReporte.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoReporte_White.png")));
		lblIcoReporte.setBounds(16, 8, 24, 24);
		paneReporte.add(lblIcoReporte);
		
		paneUser = new JPanel();
		paneUser.setBackground(new Color(0, 94, 145));
		paneUser.setForeground(new Color(0, 0, 0));
		paneUser.setBounds(0, 0, 315, 207);
		paneMenu.add(paneUser);
		paneUser.setLayout(null);
		
		lblNameUser = new JLabel("USER_GENERIC");
		lblNameUser.setBounds(10, 170, 295, 19);
		paneUser.add(lblNameUser);
		lblNameUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNameUser.setForeground(Color.WHITE);
		
		lblLogo = new JLabel("");
		lblLogo.setBorder(new LineBorder(new Color(0, 128, 0), 3));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(93, 30, 120, 120);
		paneUser.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/usuarios/user_defecto.jpg")));
		
		lblIcoUser = new JLabel("");
		lblIcoUser.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoBig_Usuario.png")));
		lblIcoUser.setBounds(15, 15, 40, 40);
		paneUser.add(lblIcoUser);
		
		paneAcerca = new JPanel();
		paneAcerca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneAcerca.addMouseListener(this);
		paneAcerca.setLayout(null);
		paneAcerca.setBackground(new Color(0, 61, 105));
		paneAcerca.setBounds(10, 461, 295, 40);
		paneMenu.add(paneAcerca);
		
		lblAcerca = new JLabel("ACERCA DE");
		lblAcerca.setHorizontalAlignment(SwingConstants.LEFT);
		lblAcerca.setForeground(Color.WHITE);
		lblAcerca.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAcerca.setBounds(55, 0, 230, 40);
		paneAcerca.add(lblAcerca);
		
		lblIcoAcerca = new JLabel("");
		lblIcoAcerca.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoAcerca_White.png")));
		lblIcoAcerca.setBounds(16, 8, 24, 24);
		paneAcerca.add(lblIcoAcerca);
		
		separatorReporteDeAlumnos = new JSeparator();
		separatorReporteDeAlumnos.setForeground(new Color(96, 178, 26));
		separatorReporteDeAlumnos.setBackground(Color.WHITE);
		separatorReporteDeAlumnos.setBounds(10, 601, 295, 1);
		paneMenu.add(separatorReporteDeAlumnos);
		
		lblFrase1 = new JLabel("\"S\u00E9 el protagonista de tu");
		lblFrase1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrase1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblFrase1.setForeground(Color.WHITE);
		lblFrase1.setBounds(30, 612, 254, 40);
		paneMenu.add(lblFrase1);
		
		lblFrase2 = new JLabel("propio Aprendizaje\"");
		lblFrase2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrase2.setForeground(Color.WHITE);
		lblFrase2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblFrase2.setBounds(30, 649, 254, 40);
		paneMenu.add(lblFrase2);
		
		paneCerrarSesion = new JPanel();
		paneCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneCerrarSesion.addMouseListener(this);
		paneCerrarSesion.setLayout(null);
		paneCerrarSesion.setBackground(new Color(0, 61, 105));
		paneCerrarSesion.setBounds(10, 551, 295, 40);
		paneMenu.add(paneCerrarSesion);
		
		lblCerrarSesion = new JLabel("CERRAR SESI\u00D3N");
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		lblCerrarSesion.setForeground(Color.WHITE);
		lblCerrarSesion.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCerrarSesion.setBounds(55, 0, 230, 40);
		paneCerrarSesion.add(lblCerrarSesion);
		
		lblIcoCerrarSesion = new JLabel("");
		lblIcoCerrarSesion.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoLogout_White.png")));
		lblIcoCerrarSesion.setBounds(16, 8, 24, 24);
		paneCerrarSesion.add(lblIcoCerrarSesion);
		
		paneMainContent = new JPanel();
		paneMainContent.setBounds(325, 127, 865, 583);
		contentPane.add(paneMainContent);
		paneMainContent.setLayout(null);
		
		panelEncabezado = new JPanel();
		panelEncabezado.setBackground(Color.WHITE);
		panelEncabezado.setBounds(325, 57, 865, 60);
		contentPane.add(panelEncabezado);
		panelEncabezado.setLayout(null);
		
		lblTitulo = new JLabel("CONSULTA");
		lblTitulo.setForeground(new Color(0, 44, 68));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(50, 14, 260, 30);
		panelEncabezado.add(lblTitulo);
		
		lblIco = new JLabel("");
		lblIco.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoBig_Consulta.png")));
		lblIco.setBounds(10, 14, 30, 30);
		panelEncabezado.add(lblIco);
		
		cboSelect = new JComboBox();
		cboSelect.addActionListener(this);
		cboSelect.setToolTipText("Selecciona una opci\u00F3n");
		cboSelect.setBackground(new Color(0, 61, 105));
		cboSelect.setForeground(Color.WHITE);
		cboSelect.setFont(new Font("Verdana", Font.BOLD, 14));
		cboSelect.setModel(new DefaultComboBoxModel(new String[] {"ALUMNOS", "DOCENTES", "CURSOS", "MATR\u00CDCULAS", "RETIROS"}));
		cboSelect.setBounds(579, 14, 270, 30);
		((JLabel)cboSelect.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);//Alinea items de combo box
		panelEncabezado.add(cboSelect);
		
		user();
		//Agregar		
		panelConsultaAlumnos = new PanelConsultaAlumnos();
		menuClicked(panelConsultaAlumnos);
		
		paneHeader = new Panel();
		paneHeader.setBackground(new Color(0, 44, 68));
		paneHeader.addMouseMotionListener(this);
		paneHeader.addMouseListener(this);
		paneHeader.setBounds(0, 0, 1200, 44);
		contentPane.add(paneHeader);
		paneHeader.setLayout(null);
		
		lblSalir = new Label("X");
		lblSalir.setBounds(1155, 0, 45, 44);
		paneHeader.add(lblSalir);
		lblSalir.addMouseListener(this);
		lblSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setBackground(new Color(0, 44, 68));
		lblSalir.setAlignment(Label.CENTER);
		lblSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		paneMinimizar = new Panel();
		paneMinimizar.addMouseListener(this);
		paneMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneMinimizar.setBounds(1110, 0, 45, 44);
		paneHeader.add(paneMinimizar);
		paneMinimizar.setLayout(null);
		
		separator = new JSeparator();
		separator.setBounds(15, 20, 15, 10);
		paneMinimizar.add(separator);
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		
		lblTextoLogo = new JLabel("VIRTUAL DATA");
		lblTextoLogo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextoLogo.setBorder(null);
		lblTextoLogo.setForeground(Color.WHITE);
		lblTextoLogo.setFont(new Font("Virtual DJ", Font.BOLD, 25));
		lblTextoLogo.setBounds(379, 2, 276, 40);
		paneHeader.add(lblTextoLogo);
		
		lblIconoLogo = new JLabel("");
		lblIconoLogo.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icono01.png")));
		lblIconoLogo.setBounds(324, 2, 40, 40);
		paneHeader.add(lblIconoLogo);
			
	}
	
	//Programar usuario
	public void user() {
		GestionUsuario gestionUsuario = new GestionUsuario();
		listaUsuario = gestionUsuario.datosUsuario(nomUser);
		UsuarioEntity ue = listaUsuario.get(0);
		
		String bienvenido = "Bienvenido "+ue.getNombre();
		lblNameUser.setText(bienvenido.toUpperCase());
		
		Blob blob = ue.getBlob(); //cadena bytes
		
		byte[] data;
		try {
			data = blob.getBytes(1, (int)blob.length()); //guardamos el binario blob en el arreglo byte data
			BufferedImage img = null; //creamos un objeto del tipo bufferedimage
			img = ImageIO.read(new ByteArrayInputStream(data)); //se lee la imagen que esta guardado en byte data
			ImageIcon icono = new ImageIcon(img);
			Image imgEscalada = icono.getImage().getScaledInstance(lblLogo.getWidth(),
					lblLogo.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon iconoEscalado = new ImageIcon(imgEscalada);
			lblLogo.setIcon(iconoEscalado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	//Metodos panel
	public void menuClicked(JPanel panel) {
		
		paneMainContent.removeAll();
		paneMainContent.add(panel);
		paneMainContent.revalidate();
		paneMainContent.repaint();
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == paneAcerca) {
			mouseClickedPaneAcerca(e);
		}
		if (e.getSource() == paneMinimizar) {
			mouseClickedPaneMinimizar(e);
		}
		if (e.getSource() == lblSalir) {
			mouseClickedLabelSalir(e);
		}
		if (e.getSource() == paneReporte) {
			mouseClickedPaneReporte(e);
		}
		if (e.getSource() == paneRegistro) {
			mouseClickedPaneRegistro(e);
		}
		if (e.getSource() == paneMantenimiento) {
			mouseClickedPaneMantenimiento(e);
		}
		if (e.getSource() == paneConsulta) {
			mouseClickedPaneConsulta(e);
		}
		if (e.getSource() == paneCerrarSesion) {
			mouseClickedPaneCerrarSesion(e);
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == paneAcerca) {
			mouseEnteredPaneAcerca(e);
		}
		if (e.getSource() == paneMinimizar) {
			mouseEnteredPaneMinimizar(e);
		}
		if (e.getSource() == paneReporte) {
			mouseEnteredPaneReportePendiente(e);
		}
		if (e.getSource() == paneRegistro) {
			mouseEnteredPaneRegistroMatricula(e);
		}
		if (e.getSource() == paneMantenimiento) {
			mouseEnteredPaneMantenimientoAlumno(e);
		}
		if (e.getSource() == paneConsulta) {
			mouseEnteredPaneConsultaAlumnos(e);
		}
		
		if (e.getSource() == lblSalir) {
			mouseEnteredLblSalir(e);
		}
		if (e.getSource() == paneCerrarSesion) {
			mouseEnteredPaneCerrarSesion(e);
		}
	}
	
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == paneAcerca) {
			mouseExitedPaneAcerca(e);
		}
		if (e.getSource() == paneMinimizar) {
			mouseExitedPaneMinimizar(e);
		}
		if (e.getSource() == paneReporte) {
			mouseExitedPaneReportePendiente(e);
		}
		if (e.getSource() == paneRegistro) {
			mouseExitedPaneRegistroMatricula(e);
		}
		if (e.getSource() == paneMantenimiento) {
			mouseExitedPaneMantenimientoAlumno(e);
		}
		if (e.getSource() == paneConsulta) {
			mouseExitedPaneConsultaAlumnos(e);
		}
		
		if (e.getSource() == lblSalir) {
			mouseExitedLblSalir(e);
		}
		if (e.getSource() == paneCerrarSesion) {
			mouseExitedPaneCerrarSesion(e);
		}
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == paneHeader) {
			mousePressedPaneHeader(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	protected void mouseClickedPaneConsulta(MouseEvent e) {
		lblTitulo.setText("CONSULTA");
		lblIco.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoBig_Consulta.png")));
		cboSelect.setModel(new DefaultComboBoxModel(new String[] {"ALUMNOS", "DOCENTES", "CURSOS", "MATR\u00CDCULAS", "RETIROS"}));
		panelConsultaAlumnos = new PanelConsultaAlumnos();
		menuClicked(panelConsultaAlumnos);
	}
	protected void mouseClickedPaneMantenimiento(MouseEvent e) {
		lblTitulo.setText("MANTENIMIENTO");
		lblIco.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoBig_Mantenimiento.png")));
		cboSelect.setModel(new DefaultComboBoxModel(new String[] {"ALUMNO", "CURSO", "DOCENTE"}));
		panelMantenimientoAlumno = new PanelMantenimientoAlumno();
		menuClicked(panelMantenimientoAlumno);
		
		GestionUsuario gestionUsuario = new GestionUsuario();
		listaUsuario = gestionUsuario.datosUsuario(nomUser);
		UsuarioEntity ue = listaUsuario.get(0);
		
		if(ue.getTipo() == 2) {
			lblTitulo.setText("MANTENIMIENTO");
			lblIco.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoBig_Mantenimiento.png")));
			cboSelect.setModel(new DefaultComboBoxModel(new String[] {"ALUMNO", "CURSO", "DOCENTE"}));
			panelMantenimientoAlumno = new PanelMantenimientoAlumno();
			menuClicked(panelMantenimientoAlumno);
		}else {
			JOptionPane.showMessageDialog(null, "Tienes que ser administrador para ver este campo");
		}

	}
	protected void mouseClickedPaneRegistro(MouseEvent e) {
		lblTitulo.setText("REGISTRO");
		lblIco.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoBig_Registro.png")));
		cboSelect.setModel(new DefaultComboBoxModel(new String[] {"MATR\u00CDCULA", "RETIRO"}));
		panelRegistroMatricula = new PanelRegistroMatricula();
		menuClicked(panelRegistroMatricula);
		
		GestionUsuario gestionUsuario = new GestionUsuario();
		listaUsuario = gestionUsuario.datosUsuario(nomUser);
		UsuarioEntity ue = listaUsuario.get(0);
		
		if(ue.getTipo() == 2) {
			lblTitulo.setText("REGISTRO");
			lblIco.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoBig_Registro.png")));
			cboSelect.setModel(new DefaultComboBoxModel(new String[] {"MATR\u00CDCULA", "RETIRO"}));
			panelRegistroMatricula = new PanelRegistroMatricula();
			menuClicked(panelRegistroMatricula);
		}else {
			JOptionPane.showMessageDialog(null, "Tienes que ser administrador para ver este campo");
		}
	}
	protected void mouseClickedPaneReporte(MouseEvent e) {
		lblTitulo.setText("REPORTE DE ALUMNOS");
		lblIco.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoBig_Reporte.png")));
		cboSelect.setModel(new DefaultComboBoxModel(new String[] {"ALUMNOS MAT. PENDIENTE", "ALUMNOS MAT. VIGENTE", "ALUMNOS RETIRADOS", "ALUMNOS MAT. CURSO", "DOCENTES CARGA H."}));
		panelReportePendiente = new PanelReportePendiente();
		menuClicked(panelReportePendiente);
	}

	protected void mouseClickedPaneAcerca(MouseEvent e) {
		DialogAcerca acerca = new DialogAcerca();
		acerca.setVisible(true);
		acerca.setLocationRelativeTo(this);
	}
	
	protected void mouseClickedLabelSalir(MouseEvent e) {

		int resp = JOptionPane.showConfirmDialog(null, "¿Deseas salir del programa?", "Alerta!", JOptionPane.YES_NO_OPTION);
		if(resp == JOptionPane.NO_OPTION){
		  // Codigo si cancela
		}else{
		  //Codigo si es ok
			System.exit(0);
		}
		
	}
	protected void mouseClickedPaneCerrarSesion(MouseEvent e) {
		
		int resp = JOptionPane.showConfirmDialog(null, "¿Deseas cerrar sesión?", "Alerta!", JOptionPane.YES_NO_OPTION);
		if(resp == JOptionPane.NO_OPTION){
		  // Codigo si cancela
		}else{
		  //Codigo si es ok
			frmLogin pantalla = new frmLogin();
			pantalla.setLocationRelativeTo(null);
			pantalla.setUndecorated(true);
			pantalla.setVisible(true);
			this.dispose();
		}		
	}
	
	protected void mouseClickedPaneMinimizar(MouseEvent e) {
		this.setExtendedState(ICONIFIED);
	}
	
	//Cambiar color al pasar encima de los 
	protected void mouseEnteredPaneConsultaAlumnos(MouseEvent e) {
		paneConsulta.setBackground(Color.WHITE);
		lblConsulta.setForeground(new Color(0, 61, 105));
		lblIcoConsulta.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoConsulta_Blue.png")));
	}
	protected void mouseEnteredPaneMantenimientoAlumno(MouseEvent e) {
		paneMantenimiento.setBackground(Color.WHITE);
		lblMantenimiento.setForeground(new Color(0, 61, 105));
		lblIcoMantenimiento.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoMantenimiento_Blue.png")));
	}
	protected void mouseEnteredPaneRegistroMatricula(MouseEvent e) {
		paneRegistro.setBackground(Color.WHITE);
		lblRegistro.setForeground(new Color(0, 61, 105));
		lblIcoRegistro.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoRegistro_Blue.png")));
	}
	protected void mouseEnteredPaneReportePendiente(MouseEvent e) {
		paneReporte.setBackground(Color.WHITE);
		lblReporte.setForeground(new Color(0, 61, 105));
		lblIcoReporte.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoReporte_Blue.png")));
	}
	protected void mouseEnteredPaneAcerca(MouseEvent e) {
		paneAcerca.setBackground(Color.WHITE);
		lblAcerca.setForeground(new Color(0, 61, 105));
		lblIcoAcerca.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoAcerca_Blue.png")));
	}
	protected void mouseEnteredPaneCerrarSesion(MouseEvent e) {
		paneCerrarSesion.setBackground(Color.WHITE);
		lblCerrarSesion.setForeground(new Color(0, 61, 105));
		lblIcoCerrarSesion.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoLogout_Blue.png")));
	}
	protected void mouseEnteredLblSalir(MouseEvent e) {
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setBackground(Color.RED);
	}
	
	protected void mouseEnteredPaneMinimizar(MouseEvent e) {
		paneMinimizar.setBackground(new Color(0, 94, 145));
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
	}
	
	//Volver al color al salir de
	protected void mouseExitedPaneConsultaAlumnos(MouseEvent e) {
		paneConsulta.setBackground(new Color(0, 61, 105));
		lblConsulta.setForeground(Color.WHITE);
		lblIcoConsulta.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoConsulta_White.png")));
	}
	protected void mouseExitedPaneMantenimientoAlumno(MouseEvent e) {
		paneMantenimiento.setBackground(new Color(0, 61, 105));
		lblMantenimiento.setForeground(Color.WHITE);
		lblIcoMantenimiento.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoMantenimiento_White.png")));
	}
	protected void mouseExitedPaneRegistroMatricula(MouseEvent e) {
		paneRegistro.setBackground(new Color(0, 61, 105));
		lblRegistro.setForeground(Color.WHITE);
		lblIcoRegistro.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoRegistro_White.png")));
	}
	protected void mouseExitedPaneReportePendiente(MouseEvent e) {
		paneReporte.setBackground(new Color(0, 61, 105));
		lblReporte.setForeground(Color.WHITE);
		lblIcoReporte.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoReporte_White.png")));
	}
	protected void mouseExitedPaneAcerca(MouseEvent e) {
		paneAcerca.setBackground(new Color(0, 61, 105));
		lblAcerca.setForeground(Color.WHITE);
		lblIcoAcerca.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoAcerca_White.png")));
	}
	protected void mouseExitedPaneCerrarSesion(MouseEvent e) {
		paneCerrarSesion.setBackground(new Color(0, 61, 105));
		lblCerrarSesion.setForeground(Color.WHITE);
		lblIcoCerrarSesion.setIcon(new ImageIcon(frmPrincipal.class.getResource("/images/icoLogout_White.png")));
	}
	
	protected void mouseExitedLblSalir(MouseEvent e) {
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setBackground(new Color(0, 44, 68));
	}
	
	protected void mouseExitedPaneMinimizar(MouseEvent e) {
		paneMinimizar.setBackground(new Color(0, 44, 68));
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
	}
	
	protected void mousePressedPaneHeader(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == paneHeader) {
			mouseDraggedPaneHeader(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	protected void mouseDraggedPaneHeader(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		this.setLocation(x-xMouse, y-yMouse);
	}
	
	
	//Programación del COMBO-BOX
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboSelect) {
			actionPerformedCboSelect(e);
		}
	}
	protected void actionPerformedCboSelect(ActionEvent e) {
		String title = lblTitulo.getText();
		int select = cboSelect.getSelectedIndex();
		
		if (title == "CONSULTA") {
			switch (select) {
			case 0:
				panelConsultaAlumnos = new PanelConsultaAlumnos();
				menuClicked(panelConsultaAlumnos);
				break;
			case 1:
				panelConsultaDocentes = new PanelConsultaDocentes();
				menuClicked(panelConsultaDocentes);
				break;
			case 2:
				panelConsultaCursos = new PanelConsultaCursos();
				menuClicked(panelConsultaCursos);
				break;
			case 3:
				panelConsultaMatriculas = new PanelConsultaMatriculas();
				menuClicked(panelConsultaMatriculas);
				break;
			case 4:
				panelConsultaRetiros = new PanelConsultaRetiros();
				menuClicked(panelConsultaRetiros);
				break;
			}
		}else if (title == "MANTENIMIENTO") {
				switch (select) {
				case 0:
					panelMantenimientoAlumno = new PanelMantenimientoAlumno();
					menuClicked(panelMantenimientoAlumno);
					break;
				case 1:
					panelMantenimientoCurso = new PanelMantenimientoCurso();
					menuClicked(panelMantenimientoCurso);
					break;
				case 2:
					panelMantenimientoDocente = new PanelMantenimientoDocente();
					menuClicked(panelMantenimientoDocente);
					break;
				}
			}else if (title == "REGISTRO") {
					switch (select) {
					case 0:
						panelRegistroMatricula = new PanelRegistroMatricula();
						menuClicked(panelRegistroMatricula);
						break;
					case 1:
						panelRegistroRetiro = new PanelRegistroRetiro();
						menuClicked(panelRegistroRetiro);
						break;
					}					
				}else if (title == "REPORTE DE ALUMNOS") {
						switch (select) {
						case 0:
							panelReportePendiente = new PanelReportePendiente();
							menuClicked(panelReportePendiente);
							break;
						case 1:
							panelReporteVigente = new PanelReporteVigente();
							menuClicked(panelReporteVigente);
							break;
						case 2:
							panelReporteRetirados = new PanelReporteRetirados();
							menuClicked(panelReporteRetirados);
							break;
						case 3:
							panelReporteCurso = new PanelReporteCurso();
							menuClicked(panelReporteCurso);
							break;
						case 4:
							panelReporteDocenteHoraria = new PanelReporteDocenteHoraria();
							menuClicked(panelReporteDocenteHoraria);
							break;
						}						
					}
	}

}
