package gui_principales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import entidades.AlumnoEntity;
import entidades.CursoEntity;
import entidades.DocenteEntity;
import gestion.GestionMatricula;

import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class PanelConsultaMatriculas extends JPanel implements MouseListener, KeyListener {
	private JPanel paneHeader;
	private JTextField txtBuscar;
	private JPanel paneBtnBuscar;
	private JLabel lblBtnBuscar;
	private JPanel paneAlumno;
	private JPanel paneHeaderAlumno;
	private JLabel lblAlumno;
	private JLabel lblCodigoAlumnoTitle;
	private JLabel lblNombreAlumnoTitle;
	private JLabel lblApPaternoAlumnoTitle;
	private JLabel lblApMaternoAlumnoTitle;
	private JLabel lblDniAlumnoTitle;
	private JLabel lblEdadAlumnoTitle;
	private JLabel lblCelularAlumnoTitle;
	private JTextField txtCodigoAlumno;
	private JTextField txtNombreAlumno;
	private JTextField txtApPaternoAlumno;
	private JTextField txtApMaternoAlumno;
	private JTextField txtDniAlumno;
	private JTextField txtEdadAlumno;
	private JTextField txtCelularAlumno;
	private JPanel paneDocente;
	private JPanel paneHeaderDocente;
	private JLabel lblDocente;
	private JLabel lblCodigoDocenteTitle;
	private JLabel lblNombreDocenteTitle;
	private JLabel lblApPaternoDocenteTitle;
	private JLabel lblApMaternoDocenteTitle;
	private JLabel lblDniDocenteTitle;
	private JLabel lblCelularDocenteTitle;
	private JLabel lblEspecialidadDocenteTitle;
	private JLabel lblFiDocenteTitle;
	private JTextField txtCodigoDocente;
	private JTextField txtNombreDocente;
	private JTextField txtApPaternoDocente;
	private JTextField txtApMaternoDocente;
	private JTextField txtDniDocente;
	private JTextField txtCelularDocente;
	private JTextField txtEspecialidadDocente;
	private JTextField txtFiDocente;
	private JPanel paneCurso;
	private JPanel paneHeaderCurso;
	private JLabel lblCurso;
	private JLabel lblCodigoCursoTitle;
	private JLabel lblAsignaturaCursoTitle;
	private JLabel lblCicloCursoTitle;
	private JLabel lblCreditosCursoTitle;
	private JLabel lblHorasCursoTitle;
	private JTextField txtCodigoCurso;
	private JTextField txtAsignaturaCurso;
	private JTextField txtCicloCurso;
	private JTextField txtCreditosCurso;
	private JTextField txtHorasCurso;
	private JLabel lblIcoBusqueda;
	
	//Variables globales
	ArrayList<AlumnoEntity> listaAlumno = new ArrayList<AlumnoEntity>();
	ArrayList<CursoEntity> listaCurso = new ArrayList<CursoEntity>();
	ArrayList<DocenteEntity> listaDocente = new ArrayList<DocenteEntity>();
	/**
	 * Create the panel.
	 */
	public PanelConsultaMatriculas() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0,0,865,583);
		setLayout(null);
		
		paneHeader = new JPanel();
		paneHeader.setLayout(null);
		paneHeader.setBackground(Color.WHITE);
		paneHeader.setBounds(0, 0, 865, 70);
		add(paneHeader);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.addMouseListener(this);
		txtBuscar.setToolTipText("Escriba el c\u00F3digo de Matr\u00EDcula \u00A1Solo N\u00FAmeros!");
		txtBuscar.setText("Ingrese el c\u00F3digo de Matr\u00EDcula...");
		txtBuscar.setForeground(Color.LIGHT_GRAY);
		txtBuscar.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtBuscar.setColumns(10);
		txtBuscar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 61, 105)));
		txtBuscar.setBounds(10, 20, 660, 30);
		paneHeader.add(txtBuscar);
		
		paneBtnBuscar = new JPanel();
		paneBtnBuscar.addMouseListener(this);
		paneBtnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtnBuscar.setLayout(null);
		paneBtnBuscar.setBackground(new Color(0, 61, 105));
		paneBtnBuscar.setBounds(705, 20, 150, 30);
		paneHeader.add(paneBtnBuscar);
		
		lblBtnBuscar = new JLabel("BUSCAR");
		lblBtnBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnBuscar.setForeground(Color.WHITE);
		lblBtnBuscar.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtnBuscar.setBounds(0, 0, 150, 30);
		paneBtnBuscar.add(lblBtnBuscar);
		
		lblIcoBusqueda = new JLabel("");
		lblIcoBusqueda.setIcon(new ImageIcon(PanelConsultaMatriculas.class.getResource("/images/ico_busqueda-White.png")));
		lblIcoBusqueda.setBounds(10, 3, 24, 24);
		paneBtnBuscar.add(lblIcoBusqueda);
		
		paneAlumno = new JPanel();
		paneAlumno.setLayout(null);
		paneAlumno.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		paneAlumno.setBackground(new Color(0, 61, 105));
		paneAlumno.setBounds(0, 80, 286, 503);
		add(paneAlumno);
		
		paneHeaderAlumno = new JPanel();
		paneHeaderAlumno.setLayout(null);
		paneHeaderAlumno.setBackground(Color.WHITE);
		paneHeaderAlumno.setBounds(0, 0, 286, 30);
		paneAlumno.add(paneHeaderAlumno);
		
		lblAlumno = new JLabel("DATOS DEL ALUMNO");
		lblAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno.setForeground(new Color(0, 61, 105));
		lblAlumno.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAlumno.setBounds(0, 0, 286, 30);
		paneHeaderAlumno.add(lblAlumno);
		
		lblCodigoAlumnoTitle = new JLabel("C\u00F3digo:");
		lblCodigoAlumnoTitle.setForeground(Color.WHITE);
		lblCodigoAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodigoAlumnoTitle.setBounds(20, 50, 90, 20);
		paneAlumno.add(lblCodigoAlumnoTitle);
		
		lblNombreAlumnoTitle = new JLabel("Nombre(s):");
		lblNombreAlumnoTitle.setForeground(Color.WHITE);
		lblNombreAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombreAlumnoTitle.setBounds(20, 110, 150, 20);
		paneAlumno.add(lblNombreAlumnoTitle);
		
		lblApPaternoAlumnoTitle = new JLabel("Ap. Paterno:");
		lblApPaternoAlumnoTitle.setForeground(Color.WHITE);
		lblApPaternoAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApPaternoAlumnoTitle.setBounds(20, 178, 150, 20);
		paneAlumno.add(lblApPaternoAlumnoTitle);
		
		lblApMaternoAlumnoTitle = new JLabel("Ap. Materno:");
		lblApMaternoAlumnoTitle.setForeground(Color.WHITE);
		lblApMaternoAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApMaternoAlumnoTitle.setBounds(20, 238, 150, 20);
		paneAlumno.add(lblApMaternoAlumnoTitle);
		
		lblDniAlumnoTitle = new JLabel("DNI:");
		lblDniAlumnoTitle.setForeground(Color.WHITE);
		lblDniAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDniAlumnoTitle.setBounds(141, 50, 90, 20);
		paneAlumno.add(lblDniAlumnoTitle);
		
		lblEdadAlumnoTitle = new JLabel("Edad:");
		lblEdadAlumnoTitle.setForeground(Color.WHITE);
		lblEdadAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEdadAlumnoTitle.setBounds(20, 298, 140, 20);
		paneAlumno.add(lblEdadAlumnoTitle);
		
		lblCelularAlumnoTitle = new JLabel("Celular:");
		lblCelularAlumnoTitle.setForeground(Color.WHITE);
		lblCelularAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCelularAlumnoTitle.setBounds(20, 358, 140, 20);
		paneAlumno.add(lblCelularAlumnoTitle);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoAlumno.setForeground(Color.DARK_GRAY);
		txtCodigoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCodigoAlumno.setEditable(false);
		txtCodigoAlumno.setColumns(10);
		txtCodigoAlumno.setBounds(30, 81, 105, 20);
		paneAlumno.add(txtCodigoAlumno);
		
		txtNombreAlumno = new JTextField();
		txtNombreAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreAlumno.setForeground(Color.DARK_GRAY);
		txtNombreAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtNombreAlumno.setEditable(false);
		txtNombreAlumno.setColumns(10);
		txtNombreAlumno.setBounds(30, 140, 226, 20);
		paneAlumno.add(txtNombreAlumno);
		
		txtApPaternoAlumno = new JTextField();
		txtApPaternoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtApPaternoAlumno.setForeground(Color.DARK_GRAY);
		txtApPaternoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApPaternoAlumno.setEditable(false);
		txtApPaternoAlumno.setColumns(10);
		txtApPaternoAlumno.setBounds(30, 208, 226, 20);
		paneAlumno.add(txtApPaternoAlumno);
		
		txtApMaternoAlumno = new JTextField();
		txtApMaternoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtApMaternoAlumno.setForeground(Color.DARK_GRAY);
		txtApMaternoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApMaternoAlumno.setEditable(false);
		txtApMaternoAlumno.setColumns(10);
		txtApMaternoAlumno.setBounds(30, 268, 226, 20);
		paneAlumno.add(txtApMaternoAlumno);
		
		txtDniAlumno = new JTextField();
		txtDniAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtDniAlumno.setForeground(Color.DARK_GRAY);
		txtDniAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtDniAlumno.setEditable(false);
		txtDniAlumno.setColumns(10);
		txtDniAlumno.setBounds(151, 80, 105, 20);
		paneAlumno.add(txtDniAlumno);
		
		txtEdadAlumno = new JTextField();
		txtEdadAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdadAlumno.setForeground(Color.DARK_GRAY);
		txtEdadAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtEdadAlumno.setEditable(false);
		txtEdadAlumno.setColumns(10);
		txtEdadAlumno.setBounds(30, 328, 226, 20);
		paneAlumno.add(txtEdadAlumno);
		
		txtCelularAlumno = new JTextField();
		txtCelularAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelularAlumno.setForeground(Color.DARK_GRAY);
		txtCelularAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCelularAlumno.setEditable(false);
		txtCelularAlumno.setColumns(10);
		txtCelularAlumno.setBounds(30, 388, 226, 20);
		paneAlumno.add(txtCelularAlumno);
		
		paneDocente = new JPanel();
		paneDocente.setLayout(null);
		paneDocente.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		paneDocente.setBackground(new Color(0, 61, 105));
		paneDocente.setBounds(290, 80, 286, 503);
		add(paneDocente);
		
		paneHeaderDocente = new JPanel();
		paneHeaderDocente.setLayout(null);
		paneHeaderDocente.setBackground(Color.WHITE);
		paneHeaderDocente.setBounds(0, 0, 286, 30);
		paneDocente.add(paneHeaderDocente);
		
		lblDocente = new JLabel("DOCENTE A CARGO");
		lblDocente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocente.setForeground(new Color(0, 61, 105));
		lblDocente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDocente.setBounds(0, 0, 286, 30);
		paneHeaderDocente.add(lblDocente);
		
		lblCodigoDocenteTitle = new JLabel("C\u00F3digo:");
		lblCodigoDocenteTitle.setForeground(Color.WHITE);
		lblCodigoDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodigoDocenteTitle.setBounds(20, 50, 90, 20);
		paneDocente.add(lblCodigoDocenteTitle);
		
		lblNombreDocenteTitle = new JLabel("Nombre(s):");
		lblNombreDocenteTitle.setForeground(Color.WHITE);
		lblNombreDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombreDocenteTitle.setBounds(20, 110, 150, 20);
		paneDocente.add(lblNombreDocenteTitle);
		
		lblApPaternoDocenteTitle = new JLabel("Ap. Paterno:");
		lblApPaternoDocenteTitle.setForeground(Color.WHITE);
		lblApPaternoDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApPaternoDocenteTitle.setBounds(20, 178, 150, 20);
		paneDocente.add(lblApPaternoDocenteTitle);
		
		lblApMaternoDocenteTitle = new JLabel("Ap. Materno:");
		lblApMaternoDocenteTitle.setForeground(Color.WHITE);
		lblApMaternoDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApMaternoDocenteTitle.setBounds(20, 238, 150, 20);
		paneDocente.add(lblApMaternoDocenteTitle);
		
		lblDniDocenteTitle = new JLabel("DNI:");
		lblDniDocenteTitle.setForeground(Color.WHITE);
		lblDniDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDniDocenteTitle.setBounds(141, 50, 90, 20);
		paneDocente.add(lblDniDocenteTitle);
		
		lblCelularDocenteTitle = new JLabel("Celular:");
		lblCelularDocenteTitle.setForeground(Color.WHITE);
		lblCelularDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCelularDocenteTitle.setBounds(20, 298, 140, 20);
		paneDocente.add(lblCelularDocenteTitle);
		
		lblEspecialidadDocenteTitle = new JLabel("Especialidad:");
		lblEspecialidadDocenteTitle.setForeground(Color.WHITE);
		lblEspecialidadDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEspecialidadDocenteTitle.setBounds(20, 358, 140, 20);
		paneDocente.add(lblEspecialidadDocenteTitle);
		
		lblFiDocenteTitle = new JLabel("Fecha de Ingreso:");
		lblFiDocenteTitle.setForeground(Color.WHITE);
		lblFiDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFiDocenteTitle.setBounds(20, 418, 236, 20);
		paneDocente.add(lblFiDocenteTitle);
		
		txtCodigoDocente = new JTextField();
		txtCodigoDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoDocente.setForeground(Color.DARK_GRAY);
		txtCodigoDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCodigoDocente.setEditable(false);
		txtCodigoDocente.setColumns(10);
		txtCodigoDocente.setBounds(30, 81, 105, 20);
		paneDocente.add(txtCodigoDocente);
		
		txtNombreDocente = new JTextField();
		txtNombreDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreDocente.setForeground(Color.DARK_GRAY);
		txtNombreDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtNombreDocente.setEditable(false);
		txtNombreDocente.setColumns(10);
		txtNombreDocente.setBounds(30, 140, 226, 20);
		paneDocente.add(txtNombreDocente);
		
		txtApPaternoDocente = new JTextField();
		txtApPaternoDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtApPaternoDocente.setForeground(Color.DARK_GRAY);
		txtApPaternoDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApPaternoDocente.setEditable(false);
		txtApPaternoDocente.setColumns(10);
		txtApPaternoDocente.setBounds(30, 208, 226, 20);
		paneDocente.add(txtApPaternoDocente);
		
		txtApMaternoDocente = new JTextField();
		txtApMaternoDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtApMaternoDocente.setForeground(Color.DARK_GRAY);
		txtApMaternoDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApMaternoDocente.setEditable(false);
		txtApMaternoDocente.setColumns(10);
		txtApMaternoDocente.setBounds(30, 268, 226, 20);
		paneDocente.add(txtApMaternoDocente);
		
		txtDniDocente = new JTextField();
		txtDniDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtDniDocente.setForeground(Color.DARK_GRAY);
		txtDniDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtDniDocente.setEditable(false);
		txtDniDocente.setColumns(10);
		txtDniDocente.setBounds(151, 80, 105, 20);
		paneDocente.add(txtDniDocente);
		
		txtCelularDocente = new JTextField();
		txtCelularDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelularDocente.setForeground(Color.DARK_GRAY);
		txtCelularDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCelularDocente.setEditable(false);
		txtCelularDocente.setColumns(10);
		txtCelularDocente.setBounds(30, 328, 226, 20);
		paneDocente.add(txtCelularDocente);
		
		txtEspecialidadDocente = new JTextField();
		txtEspecialidadDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtEspecialidadDocente.setForeground(Color.DARK_GRAY);
		txtEspecialidadDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtEspecialidadDocente.setEditable(false);
		txtEspecialidadDocente.setColumns(10);
		txtEspecialidadDocente.setBounds(30, 388, 226, 20);
		paneDocente.add(txtEspecialidadDocente);
		
		txtFiDocente = new JTextField();
		txtFiDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtFiDocente.setForeground(Color.DARK_GRAY);
		txtFiDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtFiDocente.setEditable(false);
		txtFiDocente.setColumns(10);
		txtFiDocente.setBounds(30, 448, 226, 20);
		paneDocente.add(txtFiDocente);
		
		paneCurso = new JPanel();
		paneCurso.setLayout(null);
		paneCurso.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		paneCurso.setBackground(new Color(0, 61, 105));
		paneCurso.setBounds(579, 80, 286, 503);
		add(paneCurso);
		
		paneHeaderCurso = new JPanel();
		paneHeaderCurso.setLayout(null);
		paneHeaderCurso.setBackground(Color.WHITE);
		paneHeaderCurso.setBounds(0, 0, 286, 30);
		paneCurso.add(paneHeaderCurso);
		
		lblCurso = new JLabel("CURSO MATRICULADO");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setForeground(new Color(0, 61, 105));
		lblCurso.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCurso.setBounds(0, 0, 286, 30);
		paneHeaderCurso.add(lblCurso);
		
		lblCodigoCursoTitle = new JLabel("C\u00F3digo:");
		lblCodigoCursoTitle.setForeground(Color.WHITE);
		lblCodigoCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodigoCursoTitle.setBounds(20, 50, 150, 20);
		paneCurso.add(lblCodigoCursoTitle);
		
		lblAsignaturaCursoTitle = new JLabel("Asignatura:");
		lblAsignaturaCursoTitle.setForeground(Color.WHITE);
		lblAsignaturaCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAsignaturaCursoTitle.setBounds(20, 110, 150, 20);
		paneCurso.add(lblAsignaturaCursoTitle);
		
		lblCicloCursoTitle = new JLabel("Ciclo:");
		lblCicloCursoTitle.setForeground(Color.WHITE);
		lblCicloCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCicloCursoTitle.setBounds(20, 178, 150, 20);
		paneCurso.add(lblCicloCursoTitle);
		
		lblCreditosCursoTitle = new JLabel("N\u00B0 de Cr\u00E9ditos:");
		lblCreditosCursoTitle.setForeground(Color.WHITE);
		lblCreditosCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCreditosCursoTitle.setBounds(20, 238, 150, 20);
		paneCurso.add(lblCreditosCursoTitle);
		
		lblHorasCursoTitle = new JLabel("N\u00B0 de Horas:");
		lblHorasCursoTitle.setForeground(Color.WHITE);
		lblHorasCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblHorasCursoTitle.setBounds(20, 298, 150, 20);
		paneCurso.add(lblHorasCursoTitle);
		
		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoCurso.setForeground(Color.DARK_GRAY);
		txtCodigoCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCodigoCurso.setEditable(false);
		txtCodigoCurso.setColumns(10);
		txtCodigoCurso.setBounds(30, 81, 226, 20);
		paneCurso.add(txtCodigoCurso);
		
		txtAsignaturaCurso = new JTextField();
		txtAsignaturaCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsignaturaCurso.setForeground(Color.DARK_GRAY);
		txtAsignaturaCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtAsignaturaCurso.setEditable(false);
		txtAsignaturaCurso.setColumns(10);
		txtAsignaturaCurso.setBounds(30, 140, 226, 20);
		paneCurso.add(txtAsignaturaCurso);
		
		txtCicloCurso = new JTextField();
		txtCicloCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtCicloCurso.setForeground(Color.DARK_GRAY);
		txtCicloCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCicloCurso.setEditable(false);
		txtCicloCurso.setColumns(10);
		txtCicloCurso.setBounds(30, 208, 226, 20);
		paneCurso.add(txtCicloCurso);
		
		txtCreditosCurso = new JTextField();
		txtCreditosCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtCreditosCurso.setForeground(Color.DARK_GRAY);
		txtCreditosCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCreditosCurso.setEditable(false);
		txtCreditosCurso.setColumns(10);
		txtCreditosCurso.setBounds(30, 268, 226, 20);
		paneCurso.add(txtCreditosCurso);
		
		txtHorasCurso = new JTextField();
		txtHorasCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtHorasCurso.setForeground(Color.DARK_GRAY);
		txtHorasCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtHorasCurso.setEditable(false);
		txtHorasCurso.setColumns(10);
		txtHorasCurso.setBounds(30, 328, 226, 20);
		paneCurso.add(txtHorasCurso);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == paneBtnBuscar) {
			mouseClickedPaneBtnBuscar(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == paneBtnBuscar) {
			mouseEnteredPaneBtnBuscar(e);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == paneBtnBuscar) {
			mouseExitedPaneBtnBuscar(e);
		}
	}
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == txtBuscar) {
			mousePressedTxtBuscar(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mousePressedTxtBuscar(MouseEvent e) {
		txtBuscar.setForeground(Color.DARK_GRAY);
		txtBuscar.setText("");
	}
	protected void mouseEnteredPaneBtnBuscar(MouseEvent e) {
		paneBtnBuscar.setBackground(new Color(44, 110, 145));
	}
	protected void mouseExitedPaneBtnBuscar(MouseEvent e) {
		paneBtnBuscar.setBackground(new Color(0, 61, 105));
	}
	protected void mouseClickedPaneBtnBuscar(MouseEvent e) {
		//CÓDIGO BOTÓN BUSCAR
		try {
			limpieza();
			listar();
		}catch(Exception exc) {
			mensaje("El código de Matrícula ingresado no está registrado o está Retirado");
		}
	}
	
	
	
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*		M E T O D O S 		P R O P I O S    I M P L E M E N T A D O S        */
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	
	//Mostrar mensaje	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
   	
	//Limpiar registros
	void limpieza() {
		txtCodigoAlumno.setText("");
		txtNombreAlumno.setText("");
		txtApPaternoAlumno.setText("");
		txtApMaternoAlumno.setText("");
		txtDniAlumno.setText("");
		txtEdadAlumno.setText("");
		txtCelularAlumno.setText("");
		
		txtCodigoDocente.setText("");
		txtNombreDocente.setText("");
		txtApPaternoDocente.setText("");
		txtApMaternoDocente.setText("");
		txtDniDocente.setText("");
		txtCelularDocente.setText("");
		txtEspecialidadDocente.setText("");
		txtFiDocente.setText("");		

		txtCodigoCurso.setText("");
		txtAsignaturaCurso.setText("");
		txtCicloCurso.setText("");
		txtCreditosCurso.setText("");
		txtHorasCurso.setText("");
	}
	
	//Método para listar el el JTable
   	void listar() {
   		if(!txtBuscar.getText().trim().isEmpty()) {
   	   		int codMatricula = Integer.parseInt(txtBuscar.getText());  	   		
   	   		GestionMatricula gestionMatricula = new GestionMatricula();
   	   		
 			//------------------------------------------------------------------//	
	   		//			Llenar datos del alumno
	   	   	//------------------------------------------------------------------//
   	   		listaAlumno = gestionMatricula.consultaAlumnoMatricula(codMatricula);   	   		
   	   		AlumnoEntity ae = listaAlumno.get(0);
   	   		txtCodigoAlumno.setText(""+ae.getId());
	  		txtNombreAlumno.setText(""+ae.getNombres());
	  		txtApPaternoAlumno.setText(""+ae.getApellidoPaterno());
	  		txtApMaternoAlumno.setText(""+ae.getApellidoMaterno());
	  		txtDniAlumno.setText(""+ae.getDni());
	  		txtEdadAlumno.setText(""+ae.getEdad());
	  		txtCelularAlumno.setText(""+ae.getCelular());
	  		
 			//------------------------------------------------------------------//	
	   		//			Llenar datos del docente
	   	   	//------------------------------------------------------------------//
	  		listaDocente = gestionMatricula.consultaDocenteMatricula(codMatricula);
	  		DocenteEntity de = listaDocente.get(0);
  			txtCodigoDocente.setText(""+de.getId());
  			txtNombreDocente.setText(""+de.getNombres());
  			txtApPaternoDocente.setText(""+de.getApellidoPaterno());
  			txtApMaternoDocente.setText(""+de.getApellidoMaterno());
  			txtDniDocente.setText(""+de.getDni());
  			txtCelularDocente.setText(""+de.getCelular());
  			txtEspecialidadDocente.setText(""+de.getEspecialidad());
  			txtFiDocente.setText(""+de.getFechaIngreso());
  			
   		   	//------------------------------------------------------------------//	
   			//			Llenar datos de cursos
   	   		//------------------------------------------------------------------//
  			listaCurso = gestionMatricula.consultaCursoMatricula(codMatricula);
  			CursoEntity ce = listaCurso.get(0);
   	   		txtCodigoCurso.setText(""+ce.getCurId());
   			txtAsignaturaCurso.setText(""+ce.getCurNombre());
   			txtCicloCurso.setText(""+ce.getCurCiclo());
   			txtCreditosCurso.setText(""+ce.getCurCreditos());
   			txtHorasCurso.setText(""+ce.getCurHoras());
   		}

   	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			keyTypedTxtBuscar(e);
		}
	}
	
	//VALIDACIÓN DE ESCRITURA
	protected void keyTypedTxtBuscar(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
}
