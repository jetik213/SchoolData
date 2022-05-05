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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import entidades.AlumnoEntity;
import entidades.CursoEntity;
import entidades.DocenteEntity;
import entidades.MatriculaEntity;
import gestion.GestionAlumno;
import gestion.GestionCurso;
import gestion.GestionDocente;
import gestion.GestionMatricula;

import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class PanelRegistroMatricula extends JPanel implements MouseListener, ActionListener, KeyListener {
	private JPanel paneHeader;
	private JPanel paneBtnAdicionar;
	private JLabel lblBtnAdicionar;
	private JPanel paneBtnEliminar;
	private JLabel lblBtnEliminar;
	private JPanel paneBtnModificar;
	private JLabel lblBtnModificar;
	private JPanel paneMatriculas;
	private JScrollPane scrollPane;
	private JTable tableMatriculas;
	private JPanel paneMatricular;
	private JPanel paneHeaderMatricular;
	private JLabel lblMatricular;
	private JLabel lblNoMatricula;
	private JTextField txtNoMatricula;
	private JLabel lblCodAlumno;
	private JTextField txtCodAlumno;
	private JLabel lblCodCurso;
	private JTextField txtCodCurso;
	private JLabel lblCodDocente;
	private JTextField txtCodDocente;
	private JLabel lblFecha;
	private JPanel paneBtn01;
	private JPanel paneBtn02;
	private JLabel lblBtn01;
	private JLabel lblBtn02;
	private JLabel lblAlumno;
	private JComboBox cboAlumno;
	private JLabel lblCurso;
	private JComboBox cboCurso;
	private JLabel lblDocente;
	private JComboBox cboDocente;
	private JLabel lblConsultar;
	private JTextField txtIngresarCodigo;
	private JTextField txtAlumno;
	private JTextField txtCurso;
	private JTextField txtDocente;
	private JLabel lblIcoBusqueda;
	private JLabel lblIcoAdd;
	private JLabel lblIcoModificar;
	private JLabel lblIcoEliminar;
	private JDateChooser dateChooser;
	
	//Variables globales	
	ArrayList<AlumnoEntity> listaAlumno = new ArrayList<AlumnoEntity>();
	ArrayList<CursoEntity> listaCurso = new ArrayList<CursoEntity>();
	ArrayList<DocenteEntity> listaDocente = new ArrayList<DocenteEntity>();
	TableRowSorter<DefaultTableModel> sorter;
	boolean showDataTable = true;
	boolean modMatri = true;
	int opcion = 0;
	int filaSeleccionada = -1;
	ArrayList<MatriculaEntity> listaMatricula = new ArrayList<MatriculaEntity>();
	DefaultTableModel modelo = new DefaultTableModel();

	
	/**
	 * Create the panel.
	 */
	public PanelRegistroMatricula() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0,0,865,583);
		setLayout(null);
		
		paneHeader = new JPanel();
		paneHeader.setLayout(null);
		paneHeader.setBackground(Color.WHITE);
		paneHeader.setBounds(0, 0, 605, 130);
		add(paneHeader);
		
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
		lblIcoAdd.setIcon(new ImageIcon(PanelRegistroMatricula.class.getResource("/images/ico_add-white.png")));
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
		lblBtnEliminar.setBounds(0, 0, 150, 30);
		paneBtnEliminar.add(lblBtnEliminar);
		
		lblIcoEliminar = new JLabel("");
		lblIcoEliminar.setIcon(new ImageIcon(PanelRegistroMatricula.class.getResource("/images/ico_eliminar-white.png")));
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
		lblIcoModificar.setIcon(new ImageIcon(PanelRegistroMatricula.class.getResource("/images/ico_modificar-white.png")));
		lblIcoModificar.setBounds(3, 3, 24, 24);
		paneBtnModificar.add(lblIcoModificar);
		
		lblConsultar = new JLabel("CONSULTAR :");
		lblConsultar.setForeground(new Color(0, 61, 105));
		lblConsultar.setFont(new Font("Verdana", Font.BOLD, 18));
		lblConsultar.setBounds(50, 20, 140, 30);
		paneHeader.add(lblConsultar);
		
		txtIngresarCodigo = new JTextField();
		txtIngresarCodigo.addKeyListener(this);
		txtIngresarCodigo.setToolTipText("Ingresa un dato del alumno a consultar...");
		txtIngresarCodigo.setForeground(Color.DARK_GRAY);
		txtIngresarCodigo.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtIngresarCodigo.setColumns(10);
		txtIngresarCodigo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 61, 105)));
		txtIngresarCodigo.setBackground(new Color(224, 255, 255));
		txtIngresarCodigo.setBounds(215, 20, 380, 30);
		paneHeader.add(txtIngresarCodigo);
		
		lblIcoBusqueda = new JLabel("");
		lblIcoBusqueda.setIcon(new ImageIcon(PanelRegistroMatricula.class.getResource("/images/icoBig_Consulta.png")));
		lblIcoBusqueda.setBounds(10, 20, 30, 30);
		paneHeader.add(lblIcoBusqueda);
		
		paneMatriculas = new JPanel();
		paneMatriculas.setLayout(null);
		paneMatriculas.setBackground(Color.WHITE);
		paneMatriculas.setBounds(0, 140, 605, 443);
		add(paneMatriculas);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 605, 443);
		paneMatriculas.add(scrollPane);
		
		tableMatriculas = new JTable();
		tableMatriculas.addMouseListener(this);
		tableMatriculas.setSelectionForeground(Color.WHITE);
		tableMatriculas.setSelectionBackground(new Color(54, 128, 181));
		tableMatriculas.setRowMargin(0);
		tableMatriculas.setRowHeight(25);
		tableMatriculas.setIntercellSpacing(new Dimension(0, 0));
		tableMatriculas.setFocusable(false);
		tableMatriculas.setBorder(null);
		tableMatriculas.getTableHeader().setOpaque(false);
		tableMatriculas.getTableHeader().setBackground(new Color(0, 61, 105));
		tableMatriculas.getTableHeader().setForeground(Color.WHITE);
		scrollPane.setViewportView(tableMatriculas);
		tableMatriculas.setModel(modelo);
		modelo.addColumn("Matrícula ID");
		modelo.addColumn("Alumno ID");
		modelo.addColumn("Curso ID");
		modelo.addColumn("Docente ID");
		modelo.addColumn("Fecha");
		
		paneMatricular = new JPanel();
		paneMatricular.setBorder(new LineBorder(Color.WHITE, 5));
		paneMatricular.setBackground(new Color(0, 61, 105));
		paneMatricular.setBounds(615, 0, 250, 583);
		add(paneMatricular);
		paneMatricular.setLayout(null);
		
		paneHeaderMatricular = new JPanel();
		paneHeaderMatricular.setLayout(null);
		paneHeaderMatricular.setBackground(Color.WHITE);
		paneHeaderMatricular.setBounds(0, 0, 250, 30);
		paneMatricular.add(paneHeaderMatricular);
		
		lblMatricular = new JLabel("FICHA DE MATR\u00CDCULA");
		lblMatricular.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatricular.setForeground(new Color(0, 61, 105));
		lblMatricular.setFont(new Font("Verdana", Font.BOLD, 14));
		lblMatricular.setBounds(0, 0, 250, 30);
		paneHeaderMatricular.add(lblMatricular);
		
		lblNoMatricula = new JLabel("N\u00B0 de Matr\u00EDcula:");
		lblNoMatricula.setForeground(Color.WHITE);
		lblNoMatricula.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNoMatricula.setBounds(20, 50, 150, 20);
		paneMatricular.add(lblNoMatricula);
		
		txtNoMatricula = new JTextField();
		txtNoMatricula.addKeyListener(this);
		txtNoMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		txtNoMatricula.setForeground(Color.DARK_GRAY);
		txtNoMatricula.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtNoMatricula.setEditable(false);
		txtNoMatricula.setColumns(10);
		txtNoMatricula.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtNoMatricula.setBackground(new Color(143, 178, 207));
		txtNoMatricula.setBounds(30, 80, 190, 20);
		paneMatricular.add(txtNoMatricula);
		
		lblCodAlumno = new JLabel("Cod. Alumno:");
		lblCodAlumno.setForeground(Color.WHITE);
		lblCodAlumno.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodAlumno.setBounds(20, 170, 150, 20);
		paneMatricular.add(lblCodAlumno);
		
		txtCodAlumno = new JTextField();
		txtCodAlumno.addKeyListener(this);
		txtCodAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodAlumno.setForeground(Color.DARK_GRAY);
		txtCodAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtCodAlumno.setEditable(false);
		txtCodAlumno.setColumns(10);
		txtCodAlumno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtCodAlumno.setBackground(new Color(143, 178, 207));
		txtCodAlumno.setBounds(30, 200, 190, 20);
		paneMatricular.add(txtCodAlumno);
		
		lblCodCurso = new JLabel("Cod. Curso:");
		lblCodCurso.setForeground(Color.WHITE);
		lblCodCurso.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodCurso.setBounds(20, 290, 150, 20);
		paneMatricular.add(lblCodCurso);
		
		txtCodCurso = new JTextField();
		txtCodCurso.addKeyListener(this);
		txtCodCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodCurso.setForeground(Color.DARK_GRAY);
		txtCodCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtCodCurso.setEditable(false);
		txtCodCurso.setColumns(10);
		txtCodCurso.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtCodCurso.setBackground(new Color(143, 178, 207));
		txtCodCurso.setBounds(30, 320, 190, 20);
		paneMatricular.add(txtCodCurso);
		
		lblCodDocente = new JLabel("Cod. Docente:");
		lblCodDocente.setForeground(Color.WHITE);
		lblCodDocente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodDocente.setBounds(20, 410, 150, 20);
		paneMatricular.add(lblCodDocente);
		
		txtCodDocente = new JTextField();
		txtCodDocente.addKeyListener(this);
		txtCodDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodDocente.setForeground(Color.DARK_GRAY);
		txtCodDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtCodDocente.setEditable(false);
		txtCodDocente.setColumns(10);
		txtCodDocente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtCodDocente.setBackground(new Color(143, 178, 207));
		txtCodDocente.setBounds(30, 440, 190, 20);
		paneMatricular.add(txtCodDocente);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setVisible(false);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFecha.setBounds(20, 470, 100, 20);
		paneMatricular.add(lblFecha);
		
		paneBtn01 = new JPanel();
		paneBtn01.setVisible(false);
		paneBtn01.addMouseListener(this);
		paneBtn01.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtn01.setBackground(new Color(70, 130, 180));
		paneBtn01.setBounds(10, 540, 110, 30);
		paneMatricular.add(paneBtn01);
		paneBtn01.setLayout(null);
		
		lblBtn01 = new JLabel("MATRICULAR");
		lblBtn01.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtn01.setForeground(Color.WHITE);
		lblBtn01.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtn01.setBounds(0, 0, 110, 30);
		paneBtn01.add(lblBtn01);
		
		paneBtn02 = new JPanel();
		paneBtn02.setVisible(false);
		paneBtn02.addMouseListener(this);
		paneBtn02.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtn02.setBackground(new Color(70, 130, 180));
		paneBtn02.setBounds(130, 540, 110, 30);
		paneMatricular.add(paneBtn02);
		paneBtn02.setLayout(null);
		
		lblBtn02 = new JLabel("CANCELAR");
		lblBtn02.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtn02.setForeground(Color.WHITE);
		lblBtn02.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtn02.setBounds(0, 0, 110, 30);
		paneBtn02.add(lblBtn02);
		
		lblAlumno = new JLabel("Alumno:");
		lblAlumno.setForeground(Color.WHITE);
		lblAlumno.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAlumno.setBounds(20, 110, 150, 20);
		paneMatricular.add(lblAlumno);	
		
		cboAlumno = new JComboBox();
		cboAlumno.addKeyListener(this);
		cboAlumno.setVisible(false);
		cboAlumno.addActionListener(this);
		cboAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		cboAlumno.setForeground(Color.WHITE);
		cboAlumno.setBackground(new Color(0, 61, 105));
		cboAlumno.setBounds(30, 140, 190, 20);
		paneMatricular.add(cboAlumno);
		((JLabel)cboAlumno.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);//Alinea items de combo box
		
		
		lblCurso = new JLabel("Curso:");
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCurso.setBounds(20, 230, 150, 20);
		paneMatricular.add(lblCurso);
		
		cboCurso = new JComboBox();
		cboCurso.addKeyListener(this);
		cboCurso.setVisible(false);
		cboCurso.addActionListener(this);
		cboCurso.setForeground(Color.WHITE);
		cboCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		cboCurso.setBackground(new Color(0, 61, 105));
		cboCurso.setBounds(30, 260, 190, 20);
		paneMatricular.add(cboCurso);
		((JLabel)cboCurso.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);//Alinea items de combo box
		
		
		lblDocente = new JLabel("Docente:");
		lblDocente.setForeground(Color.WHITE);
		lblDocente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDocente.setBounds(20, 350, 150, 20);
		paneMatricular.add(lblDocente);
		
		cboDocente = new JComboBox();
		cboDocente.addKeyListener(this);
		cboDocente.setVisible(false);
		cboDocente.addActionListener(this);
		cboDocente.setForeground(Color.WHITE);
		cboDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		cboDocente.setBackground(new Color(0, 61, 105));
		cboDocente.setBounds(30, 380, 190, 20);
		paneMatricular.add(cboDocente);
		
		txtAlumno = new JTextField();
		txtAlumno.addKeyListener(this);
		txtAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlumno.setForeground(Color.DARK_GRAY);
		txtAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtAlumno.setEditable(false);
		txtAlumno.setColumns(10);
		txtAlumno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtAlumno.setBackground(new Color(143, 178, 207));
		txtAlumno.setBounds(30, 140, 190, 20);
		paneMatricular.add(txtAlumno);
		
		txtCurso = new JTextField();
		txtCurso.addKeyListener(this);
		txtCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtCurso.setForeground(Color.DARK_GRAY);
		txtCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtCurso.setEditable(false);
		txtCurso.setColumns(10);
		txtCurso.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtCurso.setBackground(new Color(143, 178, 207));
		txtCurso.setBounds(30, 260, 190, 20);
		paneMatricular.add(txtCurso);
		
		txtDocente = new JTextField();
		txtDocente.addKeyListener(this);
		txtDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtDocente.setForeground(Color.DARK_GRAY);
		txtDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtDocente.setEditable(false);
		txtDocente.setColumns(10);
		txtDocente.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtDocente.setBackground(new Color(143, 178, 207));
		txtDocente.setBounds(30, 380, 190, 20);
		paneMatricular.add(txtDocente);
		
		dateChooser = new JDateChooser();
		dateChooser.setVisible(false);
		dateChooser.setBounds(30, 501, 190, 19);
		paneMatricular.add(dateChooser);
		((JLabel)cboDocente.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);//Alinea items de combo box
		
		listar();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableMatriculas) {
			mouseClickedTableMatriculas(e);
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
		opcion = 0;
		programarComboBoxs();
		lblBtn01.setText("MATRICULAR");
		paneBtn01.setVisible(true);
		paneBtn02.setVisible(true);
		
		//txtNoMatricula.setText(""+am.codigoCorrelativo());//Cambiado
		txtNoMatricula.setText("");
		txtCodAlumno.setText("");
		txtCodCurso.setText("");
		txtCodDocente.setText("");
		
		
		txtNoMatricula.setEditable(false);
		txtNoMatricula.setBackground(new Color(143, 178, 207));
		
		//Agregado nuevo
		showDataTable = false;
		paneBtnModificar.setVisible(false);
		paneBtnEliminar.setVisible(false);
		txtIngresarCodigo.setEditable(false);
		txtIngresarCodigo.setBackground(Color.WHITE);
		cboAlumno.requestFocus();
		tableMatriculas.clearSelection();		

	}
	protected void mouseClickedPaneBtnModificar(MouseEvent e) {
		if(txtNoMatricula.getText().isEmpty()) {
			mensaje("Selecciona un elemento de la tabla");
		} else {
			opcion = 1;
			programarComboBoxs();
			navegar();
			lblBtn01.setText("GUARDAR");
			paneBtn01.setVisible(true);
			paneBtn02.setVisible(true);
			
			txtNoMatricula.setEditable(false);
			lblFecha.setVisible(true);
			dateChooser.setVisible(true);
			
			txtNoMatricula.setBackground(new Color(143, 178, 207));
			
			//Agregado nuevo
			paneBtnAdicionar.setVisible(false);
			paneBtnEliminar.setVisible(false);
			txtIngresarCodigo.setEditable(false);
			txtIngresarCodigo.setBackground(Color.WHITE);
			cboAlumno.requestFocus();
		}		
	}
	
	protected void mouseClickedPaneBtn02(MouseEvent e) {
		//EJECUTAR CÓDIGO AL HACER CLICK EN CANCELAR
		modMatri=true;
		mostrarBotones();		
		botonesOcultos();
		limpieza();
		deshabilitar();
		cboAlumno.setVisible(false);
		cboCurso.setVisible(false);
		cboDocente.setVisible(false);
		txtAlumno.setVisible(true);
		txtCurso.setVisible(true);
		txtDocente.setVisible(true);
		dateChooser.setVisible(false);
		lblFecha.setVisible(false);
	}
	protected void mouseClickedPaneBtnEliminar(MouseEvent e) {
		//EJECUTAR CÓDIGO AL HACER CLICK EN ELIMINAR
		if(txtNoMatricula.getText().isEmpty()) {
			mensaje("ERROR! Seleccione una Matrícula de la tabla");
		}else {
			int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar esta Matrícula?", "Alerta!", JOptionPane.YES_NO_OPTION);
			if(resp == JOptionPane.NO_OPTION){
			  // Codigo si cancela
			}else{
				//Codigo si es ok
				try {
					
					int codigo = leerCodMatri();
					
					GestionMatricula gestionMatricula = new GestionMatricula();
					int resultado = gestionMatricula.eliminarMatricula(codigo);
									
					if(resultado != -1) {
						JOptionPane.showMessageDialog(null, "Eliminación correcta");
					} else {
						JOptionPane.showMessageDialog(null, "Eliminación incorrecta");
					}
					
					//refrescar la tabla
					modelo.setRowCount(0);
					listar();
					limpieza();

				}catch(Exception el){
					mensaje("ERROR! Vuelva a intentarlo");
				}			
			}
		}		
	}
	protected void mouseClickedPaneBtn01(MouseEvent e) {
		String op = lblBtn01.getText();
		if(op=="MATRICULAR") {
			//EJECUTAR CÓDIGO AL HACER CLICK EN MATRICULAR (BOTÓN ADICIONAR)
			agregarMatricula();			
		}else if(op=="GUARDAR") {
			//EJECUTAR CÓDIGO AL HACER CLICK EN GUARDAR (BOTÓN MANTENIMIENTO)
			modificarMatricula();
		}
		if(modMatri) {
			mostrarBotones();
			botonesOcultos();
			limpieza();
			deshabilitar();	
		}
		
	}
	
	//Programar jtable
	protected void mouseClickedTableMatriculas(MouseEvent e) {
		navegar();
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
			sorter.setRowFilter(RowFilter.regexFilter(valor));//llama al metodo para filtrar
			
			//selecciona primera opción
			if(valor.isEmpty()) {
				tableMatriculas.clearSelection();
				limpieza();
			} else {
				tableMatriculas.changeSelection(0, 0, false, false);
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
		txtNoMatricula.setText("");
		txtCodAlumno.setText("");
		txtCodCurso.setText("");
		txtCodDocente.setText("");
		dateChooser.setDate(null);
		txtAlumno.setText("");
		txtCurso.setText("");
		txtDocente.setText("");
		filaSeleccionada = -1;
	}
	
	//Deshabilitar campos
	void deshabilitar() {
		txtNoMatricula.setEditable(false);
		txtCodAlumno.setEditable(false);
		txtCodCurso.setEditable(false);
		txtCodDocente.setEditable(false);
		cboAlumno.setVisible(false);
		cboCurso.setVisible(false);
		cboDocente.setVisible(false);
		txtAlumno.setVisible(true);
		txtDocente.setVisible(true);
		txtCurso.setVisible(true);
		
		txtNoMatricula.setBackground(new Color(143, 178, 207));
		txtCodAlumno.setBackground(new Color(143, 178, 207));
		txtCodCurso.setBackground(new Color(143, 178, 207));
		txtCodDocente.setBackground(new Color(143, 178, 207));
		
		txtIngresarCodigo.setText("");
		txtIngresarCodigo.requestFocus();
	}
	
	//Ocultar botones
	void botonesOcultos() {
		paneBtn01.setVisible(false);
		paneBtn02.setVisible(false);
		lblFecha.setVisible(false);
		dateChooser.setVisible(false);
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
	
	//Cargar datos a cboAlumno
	void cargarComboBoxAlumnos() {
		
		GestionAlumno gestionAlumno = new GestionAlumno();
		listaAlumno = gestionAlumno.listarAlumnos();
		for (int i = 0; i < listaAlumno.size(); i++) {
			String nombreAlumnos = listaAlumno.get(i).getNombres() + " " +listaAlumno.get(i).getApellidoPaterno() + " " + listaAlumno.get(i).getApellidoMaterno();
			cboAlumno.addItem(nombreAlumnos);
		}
	}

	
	//Cargar datos a cboCurso
	void cargarComboBoxCurso() {

		GestionCurso gestionCurso = new GestionCurso();
		listaCurso = gestionCurso.listarCursos();
		for (int i = 0; i < listaCurso.size(); i++) {
			String nombreCursos = listaCurso.get(i).getCurNombre();
			cboCurso.addItem(nombreCursos);
		}
	}	
	
	//Cargar datos a cboDocente
	void cargarComboBoxDocente() {

		GestionDocente gestionDocente = new GestionDocente();
		listaDocente = gestionDocente.listarDocentes();
		for (int i = 0; i < listaDocente.size(); i++) {
			String nombreDocentes = listaDocente.get(i).getNombres() + " " +listaDocente.get(i).getApellidoPaterno() + " " + listaDocente.get(i).getApellidoMaterno();
			cboDocente.addItem(nombreDocentes);
		}
	}
	
	//Vaciar comboBoxs
	void limpiarComboBoxs() {
		cboAlumno.removeAllItems();
		cboCurso.removeAllItems();
		cboDocente.removeAllItems();
	}
	
	//Programar Combo Boxs
	void programarComboBoxs() {
		limpiarComboBoxs();

		cargarComboBoxAlumnos();
		cargarComboBoxCurso();
		cargarComboBoxDocente();
		
		cboAlumno.setSelectedIndex(0);
		cboCurso.setSelectedIndex(0);
		cboDocente.setSelectedIndex(0);
		
		cboAlumno.setVisible(true);
		cboCurso.setVisible(true);
		cboDocente.setVisible(true);
		txtAlumno.setVisible(false);
		txtCurso.setVisible(false);
		txtDocente.setVisible(false);
	}
	
	//Navegar
	void navegar() {
		if(showDataTable) {
			try {
				filaSeleccionada = tableMatriculas.getSelectedRow();
				txtNoMatricula.setText(""+tableMatriculas.getValueAt(filaSeleccionada, 0));
				txtCodAlumno.setText(""+tableMatriculas.getValueAt(filaSeleccionada, 1));
				txtCodCurso.setText(""+tableMatriculas.getValueAt(filaSeleccionada, 2));
				txtCodDocente.setText(""+tableMatriculas.getValueAt(filaSeleccionada, 3));
								
				Date fechaDate = new SimpleDateFormat("dd/MM/yyyy").parse(""+tableMatriculas.getValueAt(filaSeleccionada, 4));  
				dateChooser.setDate(fechaDate);
				
				GestionMatricula gestionMatricula = new GestionMatricula();
				
				//Programar Alumno
				int codAlum = leerCodAlu();
				String nomA = gestionMatricula.nombreAlumno(codAlum);
				txtAlumno.setText(nomA);
				cboAlumno.setSelectedItem(nomA);
				
				//Programar Curso
				int codCurso = leerCodCur();
				String nomC = gestionMatricula.nombreCurso(codCurso);
				txtCurso.setText(nomC);
				cboCurso.setSelectedItem(nomC);
				
				//Programar Docente
				int codDocente = leerCodDoc();
				String nomD = gestionMatricula.nombreDocente(codDocente);
				txtDocente.setText(nomD);
				cboDocente.setSelectedItem(nomD);
				
			}catch(Exception em) {
				
			}
			
		}
		
	}
	
	//Método para listar el el JTable
	void listar() {

		GestionMatricula gestionMatricula = new GestionMatricula();
		listaMatricula = gestionMatricula.listarMatricula();
		
		for (int i = 0; i < listaMatricula.size(); i++) {
			MatriculaEntity entity = listaMatricula.get(i);
			String idMatricula= Integer.toString(entity.getMatId());
			String idAlumno =  Integer.toString(entity.getAluId());
			String idCurso = Integer.toString(entity.getCurId());
			String idDocente = Integer.toString(entity.getDocId());
			
			Date fechaDate = entity.getFecha();
			Locale fechLocale = new Locale("es","PE");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",fechLocale);
			
			String fechaMatricula = dateFormat.format(fechaDate);
			
			Object datos[] = {idMatricula,idAlumno,idCurso,idDocente,fechaMatricula};
			modelo.addRow(datos);
			sorter = new TableRowSorter<>(modelo);
	   		tableMatriculas.setRowSorter(sorter);
		}
	}	
	
	//Método para agregar un nuevo registro
   	void agregarMatricula() {
   		
   		if(!estaRegistrado()) {
   	   		int codAlum = leerCodAlu();
   	   		int codCur = leerCodCur();
   	   		int codDoc = leerCodDoc();   		
   	   		
   			MatriculaEntity matriculaEntity = new MatriculaEntity(codAlum, codCur, codDoc);
   			
   			GestionMatricula gestionMatricula = new GestionMatricula();
   			int resultado = gestionMatricula.registrarMatricula(matriculaEntity);
   			
   			if (resultado != -1) {
   				JOptionPane.showMessageDialog(null, "Registro exitoso");
   			} else {
   				JOptionPane.showMessageDialog(null, "Registro incorrecto");
   			}
   			
   			modelo.setRowCount(0);
   			listar();
   	   		
   		} else {
   			mensaje("El Alumno ya está registrado en ese curso");
   			modMatri=false;
   		}
   		
   		
   	}
   	//Método comprobar si ya está registrado en un curso
   	public boolean estaRegistrado() {
   		
   		int idAlumno = leerCodAlu();
   		int idCurso = leerCodCur();
   		
   		//Si modificamos
   		if (opcion == 1) {
   			filaSeleccionada = tableMatriculas.getSelectedRow();
			
			MatriculaEntity entity = listaMatricula.get(filaSeleccionada);
			
			if(entity.getAluId() == idAlumno && entity.getCurId() == idCurso) return false;
   		}
   		
   		GestionMatricula gestionMatricula = new GestionMatricula();
   		boolean resultado = gestionMatricula.verificarMatricula(idAlumno, idCurso);
   		
   		return resultado;
   		
   	}
   	  	
   	//Método para modificar un nuevo registro
   	void modificarMatricula() {
   		
   		if(!estaRegistrado() && filaSeleccionada >= 0) {
   			
   			int codMat = leerCodMatri();
   			int codAlum = leerCodAlu();
   	   		int codCur = leerCodCur();
   	   		int codDoc = leerCodDoc();
   	   		
   	   		Date fecha = leerFecha();
   			
   			MatriculaEntity matriculaEntity = new MatriculaEntity(codMat, codAlum, codCur, codDoc, fecha);		
   			
   			GestionMatricula gestionMatricula = new GestionMatricula();
   			int resultado = gestionMatricula.editarMatricula(matriculaEntity); //gestionProducto.editarProducto(productoEntity);
   			
   			if(resultado == 1) {
   				JOptionPane.showMessageDialog(null, "Actualización correcta");
   			} else {
   				JOptionPane.showMessageDialog(null, "Actualización incorrecta");
   			}
   			
   			//refrescar la tabla
   			modelo.setRowCount(0);
   			listar();

   		}else {
   			mensaje("El Alumno ya está registrado en ese curso");
   			modMatri=false;
   		}
   			
   	}
   	
   	//LEER DATOS DE LOS CAMPOS TXT MATRICULA
   	int leerCodMatri() {
   		return Integer.parseInt( txtNoMatricula.getText().trim() );
   	}
	
	int leerCodAlu() {
		return Integer.parseInt(txtCodAlumno.getText().trim());
	}

	int leerCodCur() {
		return Integer.parseInt(txtCodCurso.getText().trim());
	}
	
	int leerCodDoc() {
		return Integer.parseInt(txtCodDocente.getText().trim());
	}
	
	Date leerFecha() {
		return dateChooser.getDate();
	}
	   
		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboDocente) {
			actionPerformedCboDocente(e);
		}
		if (e.getSource() == cboCurso) {
			actionPerformedCboCurso(e);
		}
		if (e.getSource() == cboAlumno) {
			actionPerformedCboAlumno(e);
		}
	}
	protected void actionPerformedCboAlumno(ActionEvent e) {
		
		int posicionCboAlumno = cboAlumno.getSelectedIndex();
		if (posicionCboAlumno >= 0) {
			AlumnoEntity alumnoEntity = listaAlumno.get(posicionCboAlumno);
			txtCodAlumno.setText(alumnoEntity.getId()+"");
		}

		
	}
	protected void actionPerformedCboCurso(ActionEvent e) {
		
		int posicionCboCurso = cboCurso.getSelectedIndex();
		if (posicionCboCurso >= 0) {
			CursoEntity cursoEntity = listaCurso.get(posicionCboCurso);
			txtCodCurso.setText(cursoEntity.getCurId()+"");
		}

	}
	protected void actionPerformedCboDocente(ActionEvent e) {
		
		int posicionCboDocente = cboDocente.getSelectedIndex();
		if (posicionCboDocente >= 0) {
			DocenteEntity docenteEntity = listaDocente.get(posicionCboDocente);
			txtCodDocente.setText(docenteEntity.getId()+"");
		}
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtIngresarCodigo) {
			keyReleasedTxtIngresarCodigo(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDocente) {
			keyTypedTxtDocente(e);
		}
		if (e.getSource() == txtCurso) {
			keyTypedTxtCurso(e);
		}
		if (e.getSource() == txtAlumno) {
			keyTypedTxtAlumno(e);
		}
		if (e.getSource() == txtCodDocente) {
			keyTypedTxtNomDocente(e);
		}

		if (e.getSource() == txtCodCurso) {
			keyTypedTxtNomCurso(e);
		}

		if (e.getSource() == txtCodAlumno) {
			keyTypedTxtNomAlumno(e);
		}
		if (e.getSource() == txtNoMatricula) {
			keyTypedTxtNoMatricula(e);
		}
	}
	protected void keyReleasedTxtIngresarCodigo(KeyEvent e) {
		filtrar();
	}
	
	//VALIDACIONES DE ESCRITURA
	protected void keyTypedTxtNoMatricula(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtNomAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtNomCurso(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}

	protected void keyTypedTxtNomDocente(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtCurso(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtDocente(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
}
