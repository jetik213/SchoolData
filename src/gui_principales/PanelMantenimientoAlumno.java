package gui_principales;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import entidades.AlumnoEntity;
import gestion.GestionAlumno;

import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelMantenimientoAlumno extends JPanel implements MouseListener, KeyListener {
	private JPanel paneHeader;
	private JTextField txtIngresarCodigo;
	private JPanel paneAlumnoDatos;
	private JLabel lblAlumno;
	private JLabel lblCodigoAlumnoTitle;
	private JLabel lblNombreAlumnoTitle;
	private JLabel lblApPaternoAlumnoTitle;
	private JLabel lblApMaternoAlumnoTitle;
	private JLabel lblDniAlumnoTitle;
	private JLabel lblEdadAlumnoTitle;
	private JLabel lblCelularAlumnoTitle;
	private JPanel paneAlumnos;
	private JPanel paneBtnAdicionar;
	private JLabel lblBtnAdicionar;
	private JPanel paneBtnEliminar;
	private JLabel lblBtnEliminar;
	private JPanel paneBtnModificar;
	private JLabel lblBtnModificar;
	private JPanel paneBtn01;
	private JLabel lblBtn01;
	private JScrollPane scrollPane;
	private JTable tableAlumnos;
	private JTextField txtCodigoAlumno;
	private JTextField txtNombreAlumno;
	private JTextField txtApPaternoAlumno;
	private JTextField txtApMaternoAlumno;
	private JTextField txtDniAlumno;
	private JTextField txtEdadAlumno;
	private JTextField txtCelularAlumno;
	private JPanel paneBtn02;
	private JLabel lblBtn02;
	private JPanel paneHeaderAlumno;
	private JLabel lblConsultar;
	private JLabel lblIcoBusqueda;
	private JLabel lblIcoAdd;
	private JLabel lblIcoModificar;
	private JLabel lblIcoEliminar;
	private JComboBox cboEstado;
	private JLabel lblEstado;
	
	
	/*--------------------------------*/
	/*------M O D I F I C A R--------*/
	/*------------------------------*/
	//Variables Globales	
	ArrayList<AlumnoEntity> listaAlumno = new ArrayList<AlumnoEntity>();
	TableRowSorter<DefaultTableModel> sorter;
	DefaultTableModel modelo = new DefaultTableModel();
	boolean showDataTable = true;
	//Tener cuidado al borrar
	/**
	 * Create the panel.
	 */
	public PanelMantenimientoAlumno() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0,0,865,583);
		setLayout(null);
		
		paneHeader = new JPanel();
		paneHeader.setLayout(null);
		paneHeader.setBackground(Color.WHITE);
		paneHeader.setBounds(0, 0, 605, 130);
		add(paneHeader);
		
		txtIngresarCodigo = new JTextField();
		txtIngresarCodigo.setBackground(new Color(224, 255, 255));
		txtIngresarCodigo.addKeyListener(this);
		txtIngresarCodigo.setToolTipText("Ingresa un dato del alumno a consultar...");
		txtIngresarCodigo.setForeground(Color.DARK_GRAY);
		txtIngresarCodigo.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtIngresarCodigo.setColumns(10);
		txtIngresarCodigo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 61, 105)));
		txtIngresarCodigo.setBounds(215, 20, 380, 30);
		paneHeader.add(txtIngresarCodigo);
		
		paneBtnAdicionar = new JPanel();
		paneBtnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtnAdicionar.addMouseListener(this);
		paneBtnAdicionar.setLayout(null);
		paneBtnAdicionar.setBackground(new Color(0, 61, 105));
		paneBtnAdicionar.setBounds(10, 80, 150, 30);
		paneHeader.add(paneBtnAdicionar);
		
		lblBtnAdicionar = new JLabel("ADICIONAR");
		lblBtnAdicionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnAdicionar.setForeground(Color.WHITE);
		lblBtnAdicionar.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtnAdicionar.setBounds(13, 0, 137, 30);
		paneBtnAdicionar.add(lblBtnAdicionar);
		
		lblIcoAdd = new JLabel("");
		lblIcoAdd.setIcon(new ImageIcon(PanelMantenimientoAlumno.class.getResource("/images/ico_add-white.png")));
		lblIcoAdd.setBounds(3, 3, 24, 24);
		paneBtnAdicionar.add(lblIcoAdd);
		
		paneBtnEliminar = new JPanel();
		paneBtnEliminar.addMouseListener(this);
		paneBtnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtnEliminar.setLayout(null);
		paneBtnEliminar.setBackground(new Color(0, 61, 105));
		paneBtnEliminar.setBounds(445, 80, 150, 30);
		paneHeader.add(paneBtnEliminar);
		
		lblBtnEliminar = new JLabel("ELIMINAR");
		lblBtnEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnEliminar.setForeground(Color.WHITE);
		lblBtnEliminar.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtnEliminar.setBounds(13, 0, 137, 30);
		paneBtnEliminar.add(lblBtnEliminar);
		
		lblIcoEliminar = new JLabel("");
		lblIcoEliminar.setIcon(new ImageIcon(PanelMantenimientoAlumno.class.getResource("/images/ico_eliminar-white.png")));
		lblIcoEliminar.setBounds(3, 3, 24, 24);
		paneBtnEliminar.add(lblIcoEliminar);
		
		paneBtnModificar = new JPanel();
		paneBtnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtnModificar.addMouseListener(this);
		paneBtnModificar.setLayout(null);
		paneBtnModificar.setBackground(new Color(0, 61, 105));
		paneBtnModificar.setBounds(227, 80, 150, 30);
		paneHeader.add(paneBtnModificar);
		
		lblBtnModificar = new JLabel("MODIFICAR");
		lblBtnModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnModificar.setForeground(Color.WHITE);
		lblBtnModificar.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtnModificar.setBounds(13, 0, 137, 30);
		paneBtnModificar.add(lblBtnModificar);
		
		lblIcoModificar = new JLabel("");
		lblIcoModificar.setIcon(new ImageIcon(PanelMantenimientoAlumno.class.getResource("/images/ico_modificar-white.png")));
		lblIcoModificar.setBounds(3, 3, 24, 24);
		paneBtnModificar.add(lblIcoModificar);
		
		lblConsultar = new JLabel("CONSULTAR :");
		lblConsultar.setForeground(new Color(0, 61, 105));
		lblConsultar.setFont(new Font("Verdana", Font.BOLD, 18));
		lblConsultar.setBounds(50, 20, 140, 30);
		paneHeader.add(lblConsultar);
		
		lblIcoBusqueda = new JLabel("");
		lblIcoBusqueda.setIcon(new ImageIcon(PanelMantenimientoAlumno.class.getResource("/images/icoBig_Consulta.png")));
		lblIcoBusqueda.setBounds(10, 20, 30, 30);
		paneHeader.add(lblIcoBusqueda);
		
		paneAlumnoDatos = new JPanel();
		paneAlumnoDatos.setBorder(new LineBorder(Color.WHITE, 5));
		paneAlumnoDatos.setLayout(null);
		paneAlumnoDatos.setBackground(new Color(0, 61, 105));
		paneAlumnoDatos.setBounds(615, 0, 250, 583);
		add(paneAlumnoDatos);
		
		paneHeaderAlumno = new JPanel();
		paneHeaderAlumno.setBackground(Color.WHITE);
		paneHeaderAlumno.setBounds(0, 0, 250, 30);
		paneAlumnoDatos.add(paneHeaderAlumno);
		paneHeaderAlumno.setLayout(null);
		
		lblAlumno = new JLabel("DATOS DEL ALUMNO");
		lblAlumno.setBounds(0, 0, 250, 30);
		paneHeaderAlumno.add(lblAlumno);
		lblAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno.setForeground(new Color(0, 61, 105));
		lblAlumno.setFont(new Font("Verdana", Font.BOLD, 14));
		
		lblCodigoAlumnoTitle = new JLabel("C\u00F3digo:");
		lblCodigoAlumnoTitle.setForeground(Color.WHITE);
		lblCodigoAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodigoAlumnoTitle.setBounds(20, 50, 150, 20);
		paneAlumnoDatos.add(lblCodigoAlumnoTitle);
		
		lblNombreAlumnoTitle = new JLabel("Nombre(s):");
		lblNombreAlumnoTitle.setForeground(Color.WHITE);
		lblNombreAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombreAlumnoTitle.setBounds(20, 110, 150, 20);
		paneAlumnoDatos.add(lblNombreAlumnoTitle);
		
		lblApPaternoAlumnoTitle = new JLabel("Ap. Paterno:");
		lblApPaternoAlumnoTitle.setForeground(Color.WHITE);
		lblApPaternoAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApPaternoAlumnoTitle.setBounds(20, 178, 150, 20);
		paneAlumnoDatos.add(lblApPaternoAlumnoTitle);
		
		lblApMaternoAlumnoTitle = new JLabel("Ap. Materno:");
		lblApMaternoAlumnoTitle.setForeground(Color.WHITE);
		lblApMaternoAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApMaternoAlumnoTitle.setBounds(20, 238, 150, 20);
		paneAlumnoDatos.add(lblApMaternoAlumnoTitle);
		
		lblDniAlumnoTitle = new JLabel("DNI:");
		lblDniAlumnoTitle.setForeground(Color.WHITE);
		lblDniAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDniAlumnoTitle.setBounds(20, 298, 98, 20);
		paneAlumnoDatos.add(lblDniAlumnoTitle);
		
		lblEdadAlumnoTitle = new JLabel("Edad:");
		lblEdadAlumnoTitle.setForeground(Color.WHITE);
		lblEdadAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEdadAlumnoTitle.setBounds(130, 298, 90, 20);
		paneAlumnoDatos.add(lblEdadAlumnoTitle);
		
		lblCelularAlumnoTitle = new JLabel("Celular:");
		lblCelularAlumnoTitle.setForeground(Color.WHITE);
		lblCelularAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCelularAlumnoTitle.setBounds(20, 358, 150, 20);
		paneAlumnoDatos.add(lblCelularAlumnoTitle);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.addKeyListener(this);
		txtCodigoAlumno.setEditable(false);
		txtCodigoAlumno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtCodigoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoAlumno.setForeground(Color.DARK_GRAY);
		txtCodigoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCodigoAlumno.setBounds(30, 80, 190, 20);
		txtCodigoAlumno.setColumns(10);
		txtCodigoAlumno.setBackground(new Color(143, 178, 207));
		paneAlumnoDatos.add(txtCodigoAlumno);
		
		
		txtNombreAlumno = new JTextField();
		txtNombreAlumno.addKeyListener(this);
		txtNombreAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreAlumno.setForeground(Color.DARK_GRAY);
		txtNombreAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtNombreAlumno.setEditable(false);
		txtNombreAlumno.setColumns(10);
		txtNombreAlumno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtNombreAlumno.setBounds(30, 140, 190, 20);
		txtNombreAlumno.setBackground(new Color(143, 178, 207));
		paneAlumnoDatos.add(txtNombreAlumno);
		
		txtApPaternoAlumno = new JTextField();
		txtApPaternoAlumno.addKeyListener(this);
		txtApPaternoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtApPaternoAlumno.setForeground(Color.DARK_GRAY);
		txtApPaternoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApPaternoAlumno.setEditable(false);
		txtApPaternoAlumno.setColumns(10);
		txtApPaternoAlumno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtApPaternoAlumno.setBounds(30, 208, 190, 20);
		txtApPaternoAlumno.setBackground(new Color(143, 178, 207));
		paneAlumnoDatos.add(txtApPaternoAlumno);
		
		txtApMaternoAlumno = new JTextField();
		txtApMaternoAlumno.addKeyListener(this);
		txtApMaternoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtApMaternoAlumno.setForeground(Color.DARK_GRAY);
		txtApMaternoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApMaternoAlumno.setEditable(false);
		txtApMaternoAlumno.setColumns(10);
		txtApMaternoAlumno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtApMaternoAlumno.setBounds(30, 268, 190, 20);
		paneAlumnoDatos.add(txtApMaternoAlumno);
		txtApMaternoAlumno.setBackground(new Color(143, 178, 207));
		
		txtDniAlumno = new JTextField();
		txtDniAlumno.addKeyListener(this);
		txtDniAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtDniAlumno.setForeground(Color.DARK_GRAY);
		txtDniAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtDniAlumno.setEditable(false);
		txtDniAlumno.setColumns(10);
		txtDniAlumno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtDniAlumno.setBounds(30, 328, 90, 20);
		txtDniAlumno.setBackground(new Color(143, 178, 207));
		paneAlumnoDatos.add(txtDniAlumno);
		
		txtEdadAlumno = new JTextField();
		txtEdadAlumno.addKeyListener(this);
		txtEdadAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdadAlumno.setForeground(Color.DARK_GRAY);
		txtEdadAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtEdadAlumno.setEditable(false);
		txtEdadAlumno.setColumns(10);
		txtEdadAlumno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtEdadAlumno.setBounds(140, 328, 80, 20);
		txtEdadAlumno.setBackground(new Color(143, 178, 207));
		paneAlumnoDatos.add(txtEdadAlumno);
		
		txtCelularAlumno = new JTextField();
		txtCelularAlumno.addKeyListener(this);
		txtCelularAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelularAlumno.setForeground(Color.DARK_GRAY);
		txtCelularAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCelularAlumno.setEditable(false);
		txtCelularAlumno.setColumns(10);
		txtCelularAlumno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtCelularAlumno.setBounds(30, 388, 190, 20);
		txtCelularAlumno.setBackground(new Color(143, 178, 207));
		paneAlumnoDatos.add(txtCelularAlumno);
		
		paneBtn02 = new JPanel();
		paneBtn02.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtn02.setVisible(false);
		paneBtn02.addMouseListener(this);
		
		paneBtn01 = new JPanel();
		paneBtn01.addMouseListener(this);
		paneBtn01.setVisible(false);
		paneBtn01.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtn01.setLayout(null);
		paneBtn01.setBackground(new Color(70, 130, 180));
		paneBtn01.setBounds(10, 525, 110, 30);
		paneAlumnoDatos.add(paneBtn01);
		
		lblBtn01 = new JLabel("AGREGAR");
		lblBtn01.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtn01.setForeground(Color.WHITE);
		lblBtn01.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtn01.setBounds(0, 0, 110, 30);
		paneBtn01.add(lblBtn01);
		paneBtn02.setBackground(new Color(70, 130, 180));
		paneBtn02.setBounds(130, 525, 110, 30);
		paneAlumnoDatos.add(paneBtn02);
		paneBtn02.setLayout(null);
		
		lblBtn02 = new JLabel("CANCELAR");
		lblBtn02.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtn02.setForeground(Color.WHITE);
		lblBtn02.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtn02.setBounds(0, 0, 110, 30);
		paneBtn02.add(lblBtn02);
		
		cboEstado = new JComboBox();
		cboEstado.setVisible(false);
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"ACTIVO", "DESACTIVADO"}));
		cboEstado.setToolTipText("Selecciona una opci\u00F3n");
		cboEstado.setForeground(Color.WHITE);
		cboEstado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		cboEstado.setBackground(new Color(0, 61, 105));
		cboEstado.setBounds(30, 448, 190, 20);
		paneAlumnoDatos.add(cboEstado);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setVisible(false);
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEstado.setBounds(20, 418, 150, 20);
		paneAlumnoDatos.add(lblEstado);
		
		paneAlumnos = new JPanel();
		paneAlumnos.setLayout(null);
		paneAlumnos.setBackground(Color.WHITE);
		paneAlumnos.setBounds(0, 140, 605, 443);
		add(paneAlumnos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 605, 443);
		paneAlumnos.add(scrollPane);
		
		tableAlumnos = new JTable();
		tableAlumnos.addKeyListener(this);
		tableAlumnos.addMouseListener(this);
		tableAlumnos.setRowHeight(25);
		tableAlumnos.setRowMargin(0);
		tableAlumnos.setBorder(null);
		tableAlumnos.setFocusable(false);
		tableAlumnos.setIntercellSpacing(new Dimension(0, 0));
		tableAlumnos.setSelectionForeground(Color.WHITE);
		tableAlumnos.setSelectionBackground(new Color(54, 128, 181));
		tableAlumnos.getTableHeader().setOpaque(false);
		tableAlumnos.getTableHeader().setBackground(new Color(0, 61, 105));
		tableAlumnos.getTableHeader().setForeground(Color.WHITE);
		scrollPane.setViewportView(tableAlumnos);
		tableAlumnos.setModel(modelo);
		modelo.addColumn("ID");
		modelo.addColumn("Nombres");
		modelo.addColumn("Ap. Paterno");
		modelo.addColumn("Ap. Materno");
		modelo.addColumn("DNI");
		modelo.addColumn("Edad");
		modelo.addColumn("Celular");
		modelo.addColumn("Estado");
		
		listar();
		
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableAlumnos) {
			mouseClickedTableAlumnos(e);
		}
		if (e.getSource() == paneBtn01) {
			mouseClickedPaneBtn01(e);
		}
		if (e.getSource() == paneBtnEliminar) {
			mouseClickedPaneBtnEliminar(e);
		}
		if (e.getSource() == paneBtn02) {
			mouseClickedPaneBtn02(e);
		}
		if (e.getSource() == paneBtnModificar) {
			mouseClickedPaneBtnModificar(e);
		}
		if (e.getSource() == paneBtnAdicionar) {
			mouseClickedPaneBtnAdicionar(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == paneBtn01) {
			mouseEnteredPaneBtn01(e);
		}
		if (e.getSource() == paneBtnEliminar) {
			mouseEnteredPaneBtnEliminar(e);
		}
		if (e.getSource() == paneBtn02) {
			mouseEnteredPaneBtn02(e);
		}
		if (e.getSource() == paneBtnModificar) {
			mouseEnteredPaneBtnModificar(e);
		}
		if (e.getSource() == paneBtnAdicionar) {
			mouseEnteredPaneBtnAdicionar(e);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == paneBtn01) {
			mouseExitedPaneBtn01(e);
		}
		if (e.getSource() == paneBtnEliminar) {
			mouseExitedPaneBtnEliminar(e);
		}
		if (e.getSource() == paneBtn02) {
			mouseExitedPaneBtn02(e);
		}
		if (e.getSource() == paneBtnModificar) {
			mouseExitedPaneBtnModificar(e);
		}
		if (e.getSource() == paneBtnAdicionar) {
			mouseExitedPaneBtnAdicionar(e);
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	//EFECTO HOVER BOTONES
	protected void mouseEnteredPaneBtn01(MouseEvent e) {
		paneBtn01.setBackground(new Color(21, 39, 54));
	}
	protected void mouseEnteredPaneBtnEliminar(MouseEvent e) {
		paneBtnEliminar.setBackground(new Color(44, 110, 145));
	}
	protected void mouseEnteredPaneBtn02(MouseEvent e) {
		paneBtn02.setBackground(new Color(21, 39, 54));
	}
	protected void mouseEnteredPaneBtnModificar(MouseEvent e) {
		paneBtnModificar.setBackground(new Color(44, 110, 145));
	}
	protected void mouseEnteredPaneBtnAdicionar(MouseEvent e) {
		paneBtnAdicionar.setBackground(new Color(44, 110, 145));
	}	
	
	protected void mouseExitedPaneBtn01(MouseEvent e) {
		paneBtn01.setBackground(new Color(70, 130, 180));
	}
	protected void mouseExitedPaneBtnEliminar(MouseEvent e) {
		paneBtnEliminar.setBackground(new Color(0, 61, 105));
	}
	protected void mouseExitedPaneBtn02(MouseEvent e) {
		paneBtn02.setBackground(new Color(70, 130, 180));
	}
	protected void mouseExitedPaneBtnModificar(MouseEvent e) {
		paneBtnModificar.setBackground(new Color(0, 61, 105));
	}
	protected void mouseExitedPaneBtnAdicionar(MouseEvent e) {
		paneBtnAdicionar.setBackground(new Color(0, 61, 105));
	}	
	
	
	
	protected void mouseClickedPaneBtnAdicionar(MouseEvent e) {
		
		lblBtn01.setText("AGREGAR");
		paneBtn01.setVisible(true);
		paneBtn02.setVisible(true);
		//txtCodigoAlumno.setText(String.valueOf(arrAlum.codigoCorrelativo()));//CAMBIADO
		txtCodigoAlumno.setText("");//AGREGADO
		txtNombreAlumno.setText("");
		txtApPaternoAlumno.setText("");
		txtApMaternoAlumno.setText("");
		txtDniAlumno.setText("");
		txtEdadAlumno.setText("");
		txtCelularAlumno.setText("");
		
		txtCodigoAlumno.setEditable(false);
		txtCodigoAlumno.setBackground(new Color(143, 178, 207));
		txtNombreAlumno.setEditable(true);
		txtNombreAlumno.setBackground(Color.WHITE);
		txtApPaternoAlumno.setEditable(true);
		txtApPaternoAlumno.setBackground(Color.WHITE);
		txtApMaternoAlumno.setEditable(true);
		txtApMaternoAlumno.setBackground(Color.WHITE);
		txtDniAlumno.setEditable(true);
		txtDniAlumno.setBackground(Color.WHITE);
		txtEdadAlumno.setEditable(true);
		txtEdadAlumno.setBackground(Color.WHITE);
		txtCelularAlumno.setEditable(true);
		txtCelularAlumno.setBackground(Color.WHITE);

		showDataTable = false;
		paneBtnModificar.setVisible(false);
		paneBtnEliminar.setVisible(false);
		txtIngresarCodigo.setEditable(false);
		txtIngresarCodigo.setBackground(Color.WHITE);
		txtNombreAlumno.requestFocus();
		tableAlumnos.clearSelection();

	}
	protected void mouseClickedPaneBtnModificar(MouseEvent e) {
		if(txtCodigoAlumno.getText().isEmpty()) {
				mensaje("Selecciona un Alumno de la tabla primero");
			}else {
				lblBtn01.setText("GUARDAR");
				paneBtn01.setVisible(true);
				paneBtn02.setVisible(true);
				txtCodigoAlumno.setEditable(false);
				txtNombreAlumno.setEditable(true);
				txtApPaternoAlumno.setEditable(true);
				txtApMaternoAlumno.setEditable(true);
				txtDniAlumno.setEditable(false);
				txtEdadAlumno.setEditable(true);
				txtCelularAlumno.setEditable(true);
				
				txtCodigoAlumno.setBackground(new Color(143, 178, 207));
				txtDniAlumno.setBackground(new Color(143, 178, 207));
				txtNombreAlumno.setBackground(Color.WHITE);
				txtApPaternoAlumno.setBackground(Color.WHITE);
				txtApMaternoAlumno.setBackground(Color.WHITE);
				txtEdadAlumno.setBackground(Color.WHITE);
				txtCelularAlumno.setBackground(Color.WHITE);
				
				paneBtnAdicionar.setVisible(false);
				paneBtnEliminar.setVisible(false);
				txtIngresarCodigo.setEditable(false);
				txtIngresarCodigo.setBackground(Color.WHITE);
				txtNombreAlumno.requestFocus();
				lblEstado.setVisible(true);
				cboEstado.setVisible(true);
			}		
		
	}
	protected void mouseClickedPaneBtn02(MouseEvent e) {
		//EJECUTAR CÓDIGO AL HACER CLICK EN CANCELAR
		mostrarBotones();		
		botonesOcultos();
		limpieza();
		deshabilitar();
	}
	protected void mouseClickedPaneBtnEliminar(MouseEvent e) {
		//EJECUTAR CÓDIGO AL HACER CLICK EN ELIMINAR
		try {
			int select = tableAlumnos.getSelectedRow();
			
			int est = Integer.parseInt(tableAlumnos.getValueAt(select, 7)+"");		
			if (est != 1) {
				mensaje("No se puede eliminar Alumnos Matriculados o Retirados");
			} else {
				int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar a este Alumno?", "Alerta!", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.NO_OPTION){
				  // Codigo si cancela
				}else{
				  //Codigo si es ok
					
					/*--------------------------------*/
					/*------M O D I F I C A R--------*/
					/*------------------------------*/
					int codigo = leerCodAlu();
					
					GestionAlumno gestionAlumno = new GestionAlumno();
					int resultado = gestionAlumno.eliminarAlumno(codigo);
					
					if(resultado == 1) {
						JOptionPane.showMessageDialog(null, "Eliminación correcta");
					} else {
						JOptionPane.showMessageDialog(null, "Eliminación incorrecta");
					}
					
					//refrescar la tabla
					modelo.setRowCount(0);
					listar();
					
				}
			}
		}catch(Exception el){
			mensaje("ERROR! Seleccione un Alumno");
			txtCodigoAlumno.requestFocus();
		}
		limpieza();	
		txtIngresarCodigo.setText("");
		txtIngresarCodigo.requestFocus();
		
	}
	protected void mouseClickedPaneBtn01(MouseEvent e) {
		String op = lblBtn01.getText();
		/*int codigo = leerCodAlu();
		Alumno x = arrAlum.buscar(codigo);*/
		if(op=="AGREGAR") {
		//EJECUTAR CÓDIGO AL HACER CLICK EN AGREGAR (BOTÓN ADICIONAR)
			agregarAlumno();			
		}else if(op=="GUARDAR") {
		//EJECUTAR CÓDIGO AL HACER CLICK EN GUARDAR (BOTÓN MANTENIMIENTO)
			modificarAlumno();	
		}
		mostrarBotones();
		botonesOcultos();
		limpieza();
		deshabilitar();		
	}
	
	//Programar jtable
	protected void mouseClickedTableAlumnos(MouseEvent e) {
		navegar();		
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tableAlumnos) {
			keyReleasedTableAlumnos(e);
		}
		if (e.getSource() == txtIngresarCodigo) {
			keyReleasedTxtIngresarCodigo(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCelularAlumno) {
			keyTypedTxtCelularAlumno(e);
		}
		if (e.getSource() == txtEdadAlumno) {
			keyTypedTxtEdadAlumno(e);
		}
		if (e.getSource() == txtDniAlumno) {
			keyTypedTxtDniAlumno(e);
		}
		if (e.getSource() == txtApMaternoAlumno) {
			keyTypedTxtApMaternoAlumno(e);
		}
		if (e.getSource() == txtApPaternoAlumno) {
			keyTypedTxtApPaternoAlumno(e);
		}
		if (e.getSource() == txtNombreAlumno) {
			keyTypedTxtNombreAlumno(e);
		}
		if (e.getSource() == txtCodigoAlumno) {
			keyTypedTxtCodigoAlumno(e);
		}
		if (e.getSource() == txtIngresarCodigo) {
			keyTypedTxtIngresarCodigo(e);
		}
	}
	protected void keyReleasedTableAlumnos(KeyEvent e) {
		if((e.getKeyCode() == KeyEvent.VK_RIGHT) || (e.getKeyCode() == KeyEvent.VK_LEFT)) {
			navegar();
		}
		
	}
	
	protected void keyReleasedTxtIngresarCodigo(KeyEvent e) {
		filtrar();
	}
	protected void keyTypedTxtIngresarCodigo(KeyEvent e) {
		
		
		
	}
	
	
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*		M E T O D O S 		P R O P I O S    I M P L E M E N T A D O S        */
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	/*----------------------------------------------------------------------------*/
	
	private void filtrar() {
		try {
			String valor = txtIngresarCodigo.getText();
			sorter.setRowFilter(RowFilter.regexFilter(valor));
			
			//selecciona primera opción
			if(valor.isEmpty()) {
				tableAlumnos.clearSelection();
				limpieza();
			} else {
				tableAlumnos.changeSelection(0, 0, false, false);
				navegar();				
			}
			
			
		} catch (Exception e) {
			limpieza();
		}
	}
	
	
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
		
	}
	
	//Deshabilitar campos
	void deshabilitar() {
		txtCodigoAlumno.setEditable(false);
		txtNombreAlumno.setEditable(false);
		txtApPaternoAlumno.setEditable(false);
		txtApMaternoAlumno.setEditable(false);
		txtDniAlumno.setEditable(false);
		txtEdadAlumno.setEditable(false);
		txtCelularAlumno.setEditable(false);
		
		txtCodigoAlumno.setBackground(new Color(143, 178, 207));
		txtNombreAlumno.setBackground(new Color(143, 178, 207));
		txtApPaternoAlumno.setBackground(new Color(143, 178, 207));
		txtApMaternoAlumno.setBackground(new Color(143, 178, 207));
		txtDniAlumno.setBackground(new Color(143, 178, 207));
		txtEdadAlumno.setBackground(new Color(143, 178, 207));
		txtCelularAlumno.setBackground(new Color(143, 178, 207));
		
		txtIngresarCodigo.setText("");
		txtIngresarCodigo.requestFocus();
	}
	
	//Ocultar botones
	void botonesOcultos() {
		paneBtn01.setVisible(false);
		paneBtn02.setVisible(false);
		
		/*--------------------------------*/
		/*--------A G R E G A R----------*/
		/*------------------------------*/
		lblEstado.setVisible(false);
		cboEstado.setVisible(false);
	}
	
	//Mostrar botones
	void mostrarBotones() {
		showDataTable = true;
		paneBtnAdicionar.setVisible(true);
		paneBtnModificar.setVisible(true);
		paneBtnEliminar.setVisible(true);
		txtIngresarCodigo.setEditable(true);
		txtIngresarCodigo.setBackground(new Color(224, 255, 255));
	}
	
	//Navegar
	void navegar() {
		if(showDataTable) {
			try {
				int select = tableAlumnos.getSelectedRow();
				txtCodigoAlumno.setText(""+tableAlumnos.getValueAt(select, 0));
				txtNombreAlumno.setText(""+tableAlumnos.getValueAt(select, 1));
				txtApPaternoAlumno.setText(""+tableAlumnos.getValueAt(select, 2));
				txtApMaternoAlumno.setText(""+tableAlumnos.getValueAt(select, 3));
				txtDniAlumno.setText(""+tableAlumnos.getValueAt(select, 4));
				txtEdadAlumno.setText(""+tableAlumnos.getValueAt(select, 5));
				txtCelularAlumno.setText(""+tableAlumnos.getValueAt(select, 6));
			}catch (Exception en) {
				
			}
				
		}
		
	}
	
	//Método para listar el el JTable
   	void listar() {
  
   		/*--------------------------------*/
   		/*------M O D I F I C A R--------*/
   		/*------------------------------*/
		GestionAlumno gestionAlumno = new GestionAlumno();
		listaAlumno = gestionAlumno.listarAlumnos();
		
		for (int i = 0; i < listaAlumno.size(); i++) {
			AlumnoEntity entity = listaAlumno.get(i);
			String idAlumno= Integer.toString(entity.getId());
			String nombres =  entity.getNombres();
			String apPaterno = entity.getApellidoPaterno();
			String apMaterno = entity.getApellidoMaterno();
			String dni = entity.getDni();
			String edad = Integer.toString(entity.getEdad());			
			String celular = entity.getCelular();
			String estado = Integer.toString(entity.getEstado());

			
			Object datos[] = {idAlumno,nombres,apPaterno,apMaterno,dni,edad,celular,estado};
			modelo.addRow(datos);
			sorter = new TableRowSorter<>(modelo);
	   		tableAlumnos.setRowSorter(sorter);
		}
   	}	
	
	//Método para agregar un nuevo registro
   	void agregarAlumno() {
   		
   		/*--------------------------------*/
   		/*------M O D I F I C A R--------*/
   		/*------------------------------*/
		String nombres = leerNombresAlu();
		String ApPaterno = leerApePat();
		String ApMaterno = leerApeMat();
		String DNI = leerDNI();
		int Edad = leerEdad();
		String Celular = leerCelular();
		
		AlumnoEntity alumnoEntity = new AlumnoEntity(nombres, ApPaterno, ApMaterno, DNI, Edad, Celular);
		
		GestionAlumno gestionAlumno = new GestionAlumno();
		int resultado = gestionAlumno.registrarAlumno(alumnoEntity);
		
		if (resultado == 1) {
			JOptionPane.showMessageDialog(null, "Registro exitoso");
		} else {
			JOptionPane.showMessageDialog(null, "Registro incorrecto");
		}
		
		modelo.setRowCount(0);
		listar();	
   	}
   	
   	//Método para modificar un nuevo registro
   	void modificarAlumno() {
   		
   		/*--------------------------------*/
   		/*------M O D I F I C A R--------*/
   		/*------------------------------*/
   		
		//Obtener los datos que el usuario ingreso
		int codigo = leerCodAlu();
		String nombres = leerNombresAlu();
		String ApPaterno = leerApePat();
		String ApMaterno = leerApeMat();
		String DNI = leerDNI();
		int Edad = leerEdad();
		String Celular = leerCelular();
		int Estado = leerEstado();

		AlumnoEntity alumnoEntity = new AlumnoEntity(codigo, nombres, ApPaterno, ApMaterno, DNI, Edad, Celular, Estado);		
		
		GestionAlumno gestionAlumno = new GestionAlumno();
		int resultado = gestionAlumno.editarAlumno(alumnoEntity); //gestionProducto.editarProducto(productoEntity);
		
		if(resultado == 1) {
			JOptionPane.showMessageDialog(null, "Actualización correcta");
		} else {
			JOptionPane.showMessageDialog(null, "Actualización incorrecta");
		}
		
		//refrescar la tabla
		modelo.setRowCount(0);
		listar();

   	}
   	
   	//LEER DATOS DE LOS TXT DE ALUMNO
   	int leerCodAlu() {
   		return Integer.parseInt( txtCodigoAlumno.getText().trim() );
   	}
	
	String leerNombresAlu() {
		return txtNombreAlumno.getText().trim();
	}

	String leerApePat() {
		return txtApPaternoAlumno.getText().trim();
	}
	
	String leerApeMat() {
		return txtApMaternoAlumno.getText().trim();
	}
	
	String leerDNI() {

   		/*--------------------------------*/
   		/*------M O D I F I C A R--------*/
   		/*------------------------------*/
		return txtDniAlumno.getText().trim();
	}
	
	int leerEdad() {
		return Integer.parseInt( txtEdadAlumno.getText().trim() ); 
	}
	
	String leerCelular() {
		return txtCelularAlumno.getText().trim(); 
	}
	
	int leerEstado() {
		if(cboEstado.getSelectedItem().equals("ACTIVO")) return 1;
		else return 0;
	}
	
	//VALIDACIONES DE ESCRITURA
	protected void keyTypedTxtCodigoAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtNombreAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtApPaternoAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtApMaternoAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtDniAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtEdadAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtCelularAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
}


