package gui_principales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import entidades.DocenteEntity;
import gestion.GestionDocente;

import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class PanelMantenimientoDocente extends JPanel implements MouseListener, KeyListener {
	private JPanel paneHeader;
	private JTextField txtIngresarCodigo;
	private JPanel paneBtnAdicionar;
	private JLabel lblBtnAdicionar;
	private JPanel paneBtnEliminar;
	private JLabel lblBtnEliminar;
	private JPanel paneBtnModificar;
	private JLabel lblBtnModificar;
	private JPanel paneDocentes;
	private JScrollPane scrollPane;
	private JTable tableDocentes;
	private JPanel paneDocenteDatos;
	private JPanel paneHeaderDocente;
	private JLabel lblDocente;
	private JLabel lblCodigoDocenteTitle;
	private JTextField txtCodigoDocente;
	private JLabel lblNombreDocenteTitle;
	private JTextField txtNombreDocente;
	private JLabel lblApPaternoDocenteTitle;
	private JTextField txtApPaternoDocente;
	private JLabel lblApMaternoDocenteTitle;
	private JTextField txtApMaternoDocente;
	private JLabel lblDniDocenteTitle;
	private JTextField txtDniDocente;
	private JLabel lblCelularDocenteTitle;
	private JTextField txtCelularDocente;
	private JLabel lblEspecialidadDocenteTitle;
	private JTextField txtEspecialidadDocente;
	private JPanel paneBtn01;
	private JPanel paneBtn02;
	private JLabel lblBtn01;
	private JLabel lblBtn02;
	private JLabel lblFiDocenteTitle;
	private JTextField txtFiDocente;
	private JLabel lblConsultar;
	private JLabel lblIcoBusqueda;
	private JLabel lblIcoAdd;
	private JLabel lblIcoModificar;
	private JLabel lblIcoEliminar;
	
	//Variables Globales	
	TableRowSorter<DefaultTableModel> sorter;
	ArrayList<DocenteEntity> listaDocente = new ArrayList<DocenteEntity>();
	DefaultTableModel modelo = new DefaultTableModel();
	boolean showDataTable = true;
	private JDateChooser dateChooser;

	/**
	 * Create the panel.
	 */
	public PanelMantenimientoDocente() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0,0,865,583);
		setLayout(null);
		
		paneHeader = new JPanel();
		paneHeader.setLayout(null);
		paneHeader.setBackground(Color.WHITE);
		paneHeader.setBounds(0, 0, 605, 130);
		add(paneHeader);
		
		txtIngresarCodigo = new JTextField();
		txtIngresarCodigo.addKeyListener(this);
		txtIngresarCodigo.setBackground(new Color(224, 255, 255));
		txtIngresarCodigo.setToolTipText("Ingresa un dato del docente a consultar...");
		txtIngresarCodigo.setForeground(Color.DARK_GRAY);
		txtIngresarCodigo.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtIngresarCodigo.setColumns(10);
		txtIngresarCodigo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 61, 105)));
		txtIngresarCodigo.setBounds(215, 20, 380, 30);
		paneHeader.add(txtIngresarCodigo);
		
		paneBtnAdicionar = new JPanel();
		paneBtnAdicionar.addMouseListener(this);
		paneBtnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		lblIcoAdd.setIcon(new ImageIcon(PanelMantenimientoDocente.class.getResource("/images/ico_add-white.png")));
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
		lblIcoEliminar.setIcon(new ImageIcon(PanelMantenimientoDocente.class.getResource("/images/ico_eliminar-white.png")));
		lblIcoEliminar.setBounds(3, 3, 24, 24);
		paneBtnEliminar.add(lblIcoEliminar);
		
		paneBtnModificar = new JPanel();
		paneBtnModificar.addMouseListener(this);
		paneBtnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		lblIcoModificar.setIcon(new ImageIcon(PanelMantenimientoDocente.class.getResource("/images/ico_modificar-white.png")));
		lblIcoModificar.setBounds(3, 3, 24, 24);
		paneBtnModificar.add(lblIcoModificar);
		
		lblConsultar = new JLabel("CONSULTAR :");
		lblConsultar.setForeground(new Color(0, 61, 105));
		lblConsultar.setFont(new Font("Verdana", Font.BOLD, 18));
		lblConsultar.setBounds(50, 20, 140, 30);
		paneHeader.add(lblConsultar);
		
		lblIcoBusqueda = new JLabel("");
		lblIcoBusqueda.setIcon(new ImageIcon(PanelMantenimientoDocente.class.getResource("/images/icoBig_Consulta.png")));
		lblIcoBusqueda.setBounds(10, 20, 30, 30);
		paneHeader.add(lblIcoBusqueda);
		
		paneDocentes = new JPanel();
		paneDocentes.setLayout(null);
		paneDocentes.setBackground(Color.WHITE);
		paneDocentes.setBounds(0, 140, 605, 443);
		add(paneDocentes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 605, 443);
		paneDocentes.add(scrollPane);
		
		tableDocentes = new JTable();
		tableDocentes.addMouseListener(this);
		tableDocentes.setSelectionForeground(Color.WHITE);
		tableDocentes.setSelectionBackground(new Color(54, 128, 181));
		tableDocentes.setRowMargin(0);
		tableDocentes.setRowHeight(25);
		tableDocentes.setIntercellSpacing(new Dimension(0, 0));
		tableDocentes.setFocusable(false);
		tableDocentes.setBorder(null);
		tableDocentes.getTableHeader().setOpaque(false);
		tableDocentes.getTableHeader().setBackground(new Color(0, 61, 105));
		tableDocentes.getTableHeader().setForeground(Color.WHITE);
		scrollPane.setViewportView(tableDocentes);
		tableDocentes.setModel(modelo);
		modelo.addColumn("ID");
		modelo.addColumn("Nombres");
		modelo.addColumn("Ap. Paterno");
		modelo.addColumn("Ap. Materno");
		modelo.addColumn("DNI");
		modelo.addColumn("Fecha Ing.");
		modelo.addColumn("Celular");
		modelo.addColumn("Especialidad");
		
		paneDocenteDatos = new JPanel();
		paneDocenteDatos.setBorder(new LineBorder(Color.WHITE, 5));
		paneDocenteDatos.setBackground(new Color(0, 61, 105));
		paneDocenteDatos.setBounds(615, 0, 250, 583);
		add(paneDocenteDatos);
		paneDocenteDatos.setLayout(null);
		
		paneHeaderDocente = new JPanel();
		paneHeaderDocente.setLayout(null);
		paneHeaderDocente.setBackground(Color.WHITE);
		paneHeaderDocente.setBounds(0, 0, 250, 30);
		paneDocenteDatos.add(paneHeaderDocente);
		
		lblDocente = new JLabel("DATOS DEL DOCENTE");
		lblDocente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocente.setForeground(new Color(0, 61, 105));
		lblDocente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDocente.setBounds(0, 0, 250, 30);
		paneHeaderDocente.add(lblDocente);
		
		lblCodigoDocenteTitle = new JLabel("C\u00F3digo:");
		lblCodigoDocenteTitle.setForeground(Color.WHITE);
		lblCodigoDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodigoDocenteTitle.setBounds(20, 50, 150, 20);
		paneDocenteDatos.add(lblCodigoDocenteTitle);
		
		txtCodigoDocente = new JTextField();
		txtCodigoDocente.addKeyListener(this);
		txtCodigoDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoDocente.setForeground(Color.DARK_GRAY);
		txtCodigoDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCodigoDocente.setEditable(false);
		txtCodigoDocente.setColumns(10);
		txtCodigoDocente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtCodigoDocente.setBackground(new Color(143, 178, 207));
		txtCodigoDocente.setBounds(30, 80, 190, 20);
		paneDocenteDatos.add(txtCodigoDocente);
		
		lblNombreDocenteTitle = new JLabel("Nombre(s):");
		lblNombreDocenteTitle.setForeground(Color.WHITE);
		lblNombreDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombreDocenteTitle.setBounds(20, 110, 150, 20);
		paneDocenteDatos.add(lblNombreDocenteTitle);
		
		txtNombreDocente = new JTextField();
		txtNombreDocente.addKeyListener(this);
		txtNombreDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreDocente.setForeground(Color.DARK_GRAY);
		txtNombreDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtNombreDocente.setEditable(false);
		txtNombreDocente.setColumns(10);
		txtNombreDocente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtNombreDocente.setBackground(new Color(143, 178, 207));
		txtNombreDocente.setBounds(30, 140, 190, 20);
		paneDocenteDatos.add(txtNombreDocente);
		
		lblApPaternoDocenteTitle = new JLabel("Ap. Paterno:");
		lblApPaternoDocenteTitle.setForeground(Color.WHITE);
		lblApPaternoDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApPaternoDocenteTitle.setBounds(20, 178, 150, 20);
		paneDocenteDatos.add(lblApPaternoDocenteTitle);
		
		txtApPaternoDocente = new JTextField();
		txtApPaternoDocente.addKeyListener(this);
		txtApPaternoDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtApPaternoDocente.setForeground(Color.DARK_GRAY);
		txtApPaternoDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApPaternoDocente.setEditable(false);
		txtApPaternoDocente.setColumns(10);
		txtApPaternoDocente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtApPaternoDocente.setBackground(new Color(143, 178, 207));
		txtApPaternoDocente.setBounds(30, 208, 190, 20);
		paneDocenteDatos.add(txtApPaternoDocente);
		
		lblApMaternoDocenteTitle = new JLabel("Ap. Materno:");
		lblApMaternoDocenteTitle.setForeground(Color.WHITE);
		lblApMaternoDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApMaternoDocenteTitle.setBounds(20, 238, 150, 20);
		paneDocenteDatos.add(lblApMaternoDocenteTitle);
		
		txtApMaternoDocente = new JTextField();
		txtApMaternoDocente.addKeyListener(this);
		txtApMaternoDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtApMaternoDocente.setForeground(Color.DARK_GRAY);
		txtApMaternoDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApMaternoDocente.setEditable(false);
		txtApMaternoDocente.setColumns(10);
		txtApMaternoDocente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtApMaternoDocente.setBackground(new Color(143, 178, 207));
		txtApMaternoDocente.setBounds(30, 268, 190, 20);
		paneDocenteDatos.add(txtApMaternoDocente);
		
		lblDniDocenteTitle = new JLabel("DNI:");
		lblDniDocenteTitle.setForeground(Color.WHITE);
		lblDniDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDniDocenteTitle.setBounds(20, 298, 150, 20);
		paneDocenteDatos.add(lblDniDocenteTitle);
		
		txtDniDocente = new JTextField();
		txtDniDocente.addKeyListener(this);
		txtDniDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtDniDocente.setForeground(Color.DARK_GRAY);
		txtDniDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtDniDocente.setEditable(false);
		txtDniDocente.setColumns(10);
		txtDniDocente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtDniDocente.setBackground(new Color(143, 178, 207));
		txtDniDocente.setBounds(30, 328, 190, 20);
		paneDocenteDatos.add(txtDniDocente);
		
		lblCelularDocenteTitle = new JLabel("Celular:");
		lblCelularDocenteTitle.setForeground(Color.WHITE);
		lblCelularDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCelularDocenteTitle.setBounds(20, 358, 150, 20);
		paneDocenteDatos.add(lblCelularDocenteTitle);
		
		txtCelularDocente = new JTextField();
		txtCelularDocente.addKeyListener(this);
		txtCelularDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelularDocente.setForeground(Color.DARK_GRAY);
		txtCelularDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCelularDocente.setEditable(false);
		txtCelularDocente.setColumns(10);
		txtCelularDocente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtCelularDocente.setBackground(new Color(143, 178, 207));
		txtCelularDocente.setBounds(30, 388, 190, 20);
		paneDocenteDatos.add(txtCelularDocente);
		
		lblEspecialidadDocenteTitle = new JLabel("Especialidad:");
		lblEspecialidadDocenteTitle.setForeground(Color.WHITE);
		lblEspecialidadDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEspecialidadDocenteTitle.setBounds(20, 418, 150, 20);
		paneDocenteDatos.add(lblEspecialidadDocenteTitle);
		
		txtEspecialidadDocente = new JTextField();
		txtEspecialidadDocente.addKeyListener(this);
		txtEspecialidadDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtEspecialidadDocente.setForeground(Color.DARK_GRAY);
		txtEspecialidadDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtEspecialidadDocente.setEditable(false);
		txtEspecialidadDocente.setColumns(10);
		txtEspecialidadDocente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtEspecialidadDocente.setBackground(new Color(143, 178, 207));
		txtEspecialidadDocente.setBounds(30, 448, 190, 20);
		paneDocenteDatos.add(txtEspecialidadDocente);
		
		lblFiDocenteTitle = new JLabel("Fecha de Ingreso:");
		lblFiDocenteTitle.setForeground(Color.WHITE);
		lblFiDocenteTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFiDocenteTitle.setBounds(20, 478, 150, 20);
		paneDocenteDatos.add(lblFiDocenteTitle);
		
		txtFiDocente = new JTextField();
		txtFiDocente.addKeyListener(this);
		txtFiDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtFiDocente.setForeground(Color.DARK_GRAY);
		txtFiDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtFiDocente.setEditable(false);
		txtFiDocente.setColumns(10);
		txtFiDocente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtFiDocente.setBackground(new Color(143, 178, 207));
		txtFiDocente.setBounds(30, 508, 190, 20);
		paneDocenteDatos.add(txtFiDocente);
		
		paneBtn01 = new JPanel();
		paneBtn01.addMouseListener(this);
		paneBtn01.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtn01.setVisible(false);
		paneBtn01.setBackground(new Color(70, 130, 180));
		paneBtn01.setBounds(10, 540, 110, 30);
		paneDocenteDatos.add(paneBtn01);
		paneBtn01.setLayout(null);
		
		lblBtn01 = new JLabel("AGREGAR");
		lblBtn01.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtn01.setForeground(Color.WHITE);
		lblBtn01.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtn01.setBounds(0, 0, 110, 30);
		paneBtn01.add(lblBtn01);
		
		paneBtn02 = new JPanel();
		paneBtn02.addMouseListener(this);
		paneBtn02.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtn02.setVisible(false);
		paneBtn02.setBackground(new Color(70, 130, 180));
		paneBtn02.setBounds(130, 540, 110, 30);
		paneDocenteDatos.add(paneBtn02);
		paneBtn02.setLayout(null);
		
		lblBtn02 = new JLabel("CANCELAR");
		lblBtn02.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtn02.setForeground(Color.WHITE);
		lblBtn02.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtn02.setBounds(0, 0, 110, 30);
		paneBtn02.add(lblBtn02);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setVisible(false);
		dateChooser.setBounds(30, 509, 190, 19);
		paneDocenteDatos.add(dateChooser);
		
		listar();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableDocentes) {
			mouseClickedTableDocentes(e);
		}
		if (e.getSource() == paneBtn02) {
			mouseClickedPaneBtn02(e);
		}
		if (e.getSource() == paneBtn01) {
			mouseClickedPaneBtn01(e);
		}
		if (e.getSource() == paneBtnEliminar) {
			mouseClickedPaneBtnEliminar(e);
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
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		lblBtn01.setText("AGREGAR");
		paneBtn01.setVisible(true);
		paneBtn02.setVisible(true);
		txtCodigoDocente.setText("");//Cambiado
		txtNombreDocente.setText("");
		txtApPaternoDocente.setText("");
		txtApMaternoDocente.setText("");
		txtDniDocente.setText("");
		txtCelularDocente.setText("");
		txtEspecialidadDocente.setText("");
		txtFiDocente.setText(""+dtf2.format(LocalDateTime.now()));//Cambiado
		
		txtCodigoDocente.setEditable(false);
		txtCodigoDocente.setBackground(new Color(143, 178, 207));
		txtNombreDocente.setEditable(true);
		txtNombreDocente.setBackground(Color.WHITE);
		txtApPaternoDocente.setEditable(true);
		txtApPaternoDocente.setBackground(Color.WHITE);
		txtApMaternoDocente.setEditable(true);
		txtApMaternoDocente.setBackground(Color.WHITE);
		txtDniDocente.setEditable(true);
		txtDniDocente.setBackground(Color.WHITE);
		txtCelularDocente.setEditable(true);
		txtCelularDocente.setBackground(Color.WHITE);
		txtEspecialidadDocente.setEditable(true);
		txtEspecialidadDocente.setBackground(Color.WHITE);
		txtFiDocente.setEditable(false);
		txtFiDocente.setBackground(new Color(143, 178, 207));
		
		showDataTable = false;
		paneBtnModificar.setVisible(false);
		paneBtnEliminar.setVisible(false);
		txtIngresarCodigo.setEditable(false);
		txtIngresarCodigo.setBackground(Color.WHITE);
		txtNombreDocente.requestFocus();
		tableDocentes.clearSelection();

	}
	
	protected void mouseClickedPaneBtnModificar(MouseEvent e) {
		if(txtCodigoDocente.getText().isEmpty()) {
			mensaje("Selecciona un Docente de la tabla primero");
		}else {
			lblBtn01.setText("GUARDAR");
			paneBtn01.setVisible(true);
			paneBtn02.setVisible(true);
			txtCodigoDocente.setEditable(false);
			txtNombreDocente.setEditable(true);
			txtApPaternoDocente.setEditable(true);
			txtApMaternoDocente.setEditable(true);
			txtDniDocente.setEditable(false);
			txtCelularDocente.setEditable(true);
			txtEspecialidadDocente.setEditable(true);
			txtFiDocente.setEditable(true);
			
			txtCodigoDocente.setBackground(new Color(143, 178, 207));
			txtDniDocente.setBackground(new Color(143, 178, 207));
			txtNombreDocente.setBackground(Color.WHITE);
			txtApPaternoDocente.setBackground(Color.WHITE);
			txtApMaternoDocente.setBackground(Color.WHITE);
			txtCelularDocente.setBackground(Color.WHITE);
			txtEspecialidadDocente.setBackground(Color.WHITE);
			txtFiDocente.setBackground(Color.WHITE);
			
			paneBtnAdicionar.setVisible(false);
			paneBtnEliminar.setVisible(false);
			txtIngresarCodigo.setEditable(false);
			txtIngresarCodigo.setBackground(Color.WHITE);
			txtNombreDocente.requestFocus();
			
			txtFiDocente.setVisible(false);
			dateChooser.setVisible(true);
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
			int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar a este Docente?", "Alerta!", JOptionPane.YES_NO_OPTION);
			if(resp == JOptionPane.NO_OPTION){
			  // Codigo si cancela
			}else{
			  //Codigo si es ok
				
				int codigo = leerCodigo();
				
				GestionDocente gestionDocente = new GestionDocente();
				int resultado = gestionDocente.eliminarDocente(codigo);
				
				if(resultado == 1) {
					JOptionPane.showMessageDialog(null, "Eliminación correcta");
				} else {
					JOptionPane.showMessageDialog(null, "Eliminación incorrecta");
				}
				
				//refrescar la tabla
				modelo.setRowCount(0);
				listar();
			}
		}catch(Exception el){
			mensaje("ERROR! Seleccione un Docente");
			txtCodigoDocente.requestFocus();
		}
		limpieza();	
		txtIngresarCodigo.setText("");
		txtIngresarCodigo.requestFocus();
		
	}
	protected void mouseClickedPaneBtn01(MouseEvent e) {
		String op = lblBtn01.getText();
		if(op=="AGREGAR") {
			//EJECUTAR CÓDIGO AL HACER CLICK EN AGREGAR (ADICIONAR)
			agregarDocente();
		}else if(op=="GUARDAR") {
			//EJECUTAR CÓDIGO AL HACER CLICK EN GUARDAR (MODIFICAR)
			modificarDocente();
		}
		mostrarBotones();
		botonesOcultos();
		limpieza();
		deshabilitar();	
	}
	
	//Programar jtable
	protected void mouseClickedTableDocentes(MouseEvent e) {
		navegar();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtIngresarCodigo) {
			keyReleasedTxtIngresarCodigo(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtFiDocente) {
			keyTypedTxtFiDocente(e);
		}
		if (e.getSource() == txtEspecialidadDocente) {
			keyTypedTxtEspecialidadDocente(e);
		}
		if (e.getSource() == txtCelularDocente) {
			keyTypedTxtCelularDocente(e);
		}
		if (e.getSource() == txtDniDocente) {
			keyTypedTxtDniDocente(e);
		}
		if (e.getSource() == txtApMaternoDocente) {
			keyTypedTxtApMaternoDocente(e);
		}
		if (e.getSource() == txtApPaternoDocente) {
			keyTypedTxtApPaternoDocente(e);
		}
		if (e.getSource() == txtNombreDocente) {
			keyTypedTxtNombreDocente(e);
		}
		if (e.getSource() == txtCodigoDocente) {
			keyTypedTxtCodigoDocente(e);
		}
	}
	protected void keyReleasedTxtIngresarCodigo(KeyEvent e) {
		filtrar();
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
				tableDocentes.clearSelection();
				limpieza();
			} else {
				tableDocentes.changeSelection(0, 0, false, false);
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
		txtCodigoDocente.setText("");
		txtNombreDocente.setText("");
		txtApPaternoDocente.setText("");
		txtApMaternoDocente.setText("");
		txtDniDocente.setText("");
		txtCelularDocente.setText("");
		txtEspecialidadDocente.setText("");
		txtFiDocente.setText("");
		
	}
	
	//Deshabilitar campos
	void deshabilitar() {
		txtCodigoDocente.setEditable(false);
		txtNombreDocente.setEditable(false);
		txtApPaternoDocente.setEditable(false);
		txtApMaternoDocente.setEditable(false);
		txtDniDocente.setEditable(false);
		txtCelularDocente.setEditable(false);
		txtEspecialidadDocente.setEditable(false);
		txtFiDocente.setEditable(false);
		
		txtCodigoDocente.setBackground(new Color(143, 178, 207));
		txtNombreDocente.setBackground(new Color(143, 178, 207));
		txtApPaternoDocente.setBackground(new Color(143, 178, 207));
		txtApMaternoDocente.setBackground(new Color(143, 178, 207));
		txtDniDocente.setBackground(new Color(143, 178, 207));
		txtCelularDocente.setBackground(new Color(143, 178, 207));
		txtEspecialidadDocente.setBackground(new Color(143, 178, 207));
		txtFiDocente.setBackground(new Color(143, 178, 207));
		
		txtIngresarCodigo.setText("");
		txtIngresarCodigo.requestFocus();
		
		txtFiDocente.setVisible(true);
		dateChooser.setVisible(false);
	}
	
	//Ocultar botones
	void botonesOcultos() {
		paneBtn01.setVisible(false);
		paneBtn02.setVisible(false);
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
				int select = tableDocentes.getSelectedRow();
				txtCodigoDocente.setText(""+tableDocentes.getValueAt(select, 0));
				txtNombreDocente.setText(""+tableDocentes.getValueAt(select, 1));
				txtApPaternoDocente.setText(""+tableDocentes.getValueAt(select, 2));
				txtApMaternoDocente.setText(""+tableDocentes.getValueAt(select, 3));
				txtDniDocente.setText(""+tableDocentes.getValueAt(select, 4));
				txtCelularDocente.setText(""+tableDocentes.getValueAt(select, 6));
				txtEspecialidadDocente.setText(""+tableDocentes.getValueAt(select, 7));
				txtFiDocente.setText(""+tableDocentes.getValueAt(select, 5));
				
				Date fechaDate = new SimpleDateFormat("yyyy-MM-dd").parse(""+tableDocentes.getValueAt(select, 5));  
				dateChooser.setDate(fechaDate);
			}catch (Exception en) {
				
			}
				
		}
		
	}
	
	//Método para listar el el JTable
   	void listar() {

		GestionDocente gestionDocente = new GestionDocente();
		listaDocente = gestionDocente.listarDocentes();
		
		for (int i = 0; i < listaDocente.size(); i++) {
			DocenteEntity entity = listaDocente.get(i);
			String idDocente= Integer.toString(entity.getId());
			String nombre =  entity.getNombres();
			String apPaterno= entity.getApellidoPaterno()+"";
			String apMaterno = entity.getApellidoMaterno()+"";
			String dni = entity.getDni()+"";
			String feIngreso = entity.getFechaIngreso()+"";
			String celular = entity.getCelular()+"";
			String especialidad = entity.getEspecialidad()+"";

			
			Object datos[] = {idDocente,nombre,apPaterno,apMaterno,dni,feIngreso,celular,especialidad};
			modelo.addRow(datos);
			sorter = new TableRowSorter<>(modelo);
	   		tableDocentes.setRowSorter(sorter);
		}	
   	}	
	
	//Método para agregar un nuevo registro
   	void agregarDocente() {
   		
		String nombre =  leerNombres();
		String apPaterno = leerApePat();
		String apMaterno = leerApeMat();
		String dni = leerDNI();
		Date feIng = leerFechaActual();
		String celular = leerCelular();
		String especialidad = leerEspecialidad();
		
		DocenteEntity docenteEntity = new DocenteEntity(nombre, apPaterno, apMaterno, dni, feIng, celular, especialidad);
		
		GestionDocente gestionDocente = new GestionDocente();
		int resultado = gestionDocente.registrarDocente(docenteEntity);
		
		if (resultado == 1) {
			JOptionPane.showMessageDialog(null, "Registro exitoso");
		} else {
			JOptionPane.showMessageDialog(null, "Registro incorrecto");
		}
		
		modelo.setRowCount(0);
		listar();	
   	}
   	
   	//Método para modificar un nuevo registro
   	void modificarDocente() {
   		
   		int idDocente = leerCodigo();
		String nombre =  leerNombres();
		String apPaterno = leerApePat();
		String apMaterno = leerApeMat();
		String dni = leerDNI();
		Date feIng = leerFecha();
		String celular = leerCelular();
		String especialidad = leerEspecialidad();

		DocenteEntity docenteEntity = new DocenteEntity(idDocente, nombre, apPaterno, apMaterno, dni, feIng, celular, especialidad, 1);
		
		GestionDocente gestionDocente = new GestionDocente();
		int resultado = gestionDocente.editarDocente(docenteEntity);
		
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
   	int leerCodigo() {
   		return Integer.parseInt( txtCodigoDocente.getText().trim() );
   	}
	
	String leerNombres() {
		return txtNombreDocente.getText().trim();
	}

	String leerApePat() {
		return txtApPaternoDocente.getText().trim();
	}
	
	String leerApeMat() {
		return txtApMaternoDocente.getText().trim();
	}
	String leerDNI() {
		return txtDniDocente.getText().trim(); 
	}	
	String leerCelular() {
		return txtCelularDocente.getText().trim(); 
	}
	
	String leerEspecialidad() {
		return txtEspecialidadDocente.getText().trim();
	}
	Date leerFechaActual() {
		//SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
		return dateObj;
	}
	Date leerFecha() {
		return dateChooser.getDate();
	}
	
	//VALIDACIONES DE ESCRITURA
	protected void keyTypedTxtCodigoDocente(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtNombreDocente(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtApPaternoDocente(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtApMaternoDocente(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtDniDocente(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtCelularDocente(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtEspecialidadDocente(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtFiDocente(KeyEvent e) {
		char c = e.getKeyChar();
		if ( (c < '0' || c > '9')&&(c != '/'))
			e.consume();
	}
}
