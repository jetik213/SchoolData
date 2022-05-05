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
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import entidades.AlumnoEntity;
import entidades.CursoEntity;
import entidades.MatriculaEntity;
import entidades.RetiroEntity;
import gestion.GestionAlumno;
import gestion.GestionCurso;
import gestion.GestionMatricula;
import gestion.GestionRetiro;

import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;

public class PanelRegistroRetiro extends JPanel implements MouseListener, ActionListener, KeyListener {
	private JPanel paneHeader;
	private JPanel paneBtnAdicionar;
	private JLabel lblBtnAdicionar;
	private JPanel paneBtnEliminar;
	private JLabel lblBtnEliminar;
	private JPanel paneBtnModificar;
	private JLabel lblBtnModificar;
	private JPanel paneMatriculas;
	private JScrollPane scrollPane;
	private JPanel paneMatricular;
	private JPanel paneHeaderRetirar;
	private JLabel lblRetirar;
	private JLabel lblNoMatricula;
	private JTextField txtNoMatricula;
	private JPanel paneBtn01;
	private JLabel lblBtn01;
	private JPanel paneBtn02;
	private JLabel lblBtn02;
	private JTable tableRetiros;
	private JLabel lblConsultar;
	private JTextField txtIngresarCodigo;
	private JLabel lblAlumno;
	private JLabel lblCodAlumno;
	private JLabel lblCurso;
	private JLabel lblCodCurso;
	private JTextField txtAlumno;
	private JTextField txtCodAlumno;
	private JTextField txtCurso;
	private JTextField txtCodCurso;
	private JLabel lblEstado;
	private JComboBox cboMatricula;
	private JLabel lblIcoBusqueda;
	private JLabel lblIcoAdd;
	private JLabel lblIcoModificar;
	private JLabel lblIcoEliminar;
	private JComboBox cboEstado;
	private JTextField txtEstado;


	//Variables globales	
	TableRowSorter<DefaultTableModel> sorter;
	boolean showDataTable = true;
	boolean filtrarCbo = true;
	boolean modReti = true;
	int opcion = 0;
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<RetiroEntity> listaRetiro = new ArrayList<RetiroEntity>();
	int filaSeleccionada = -1;
	ArrayList<AlumnoEntity> listaAlumno = new ArrayList<AlumnoEntity>();
	ArrayList<CursoEntity> listaCurso = new ArrayList<CursoEntity>();
	ArrayList<MatriculaEntity> listaMatricula = new ArrayList<MatriculaEntity>();
	/**
	 * Create the panel.
	 */
	public PanelRegistroRetiro() {
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
		lblIcoAdd.setIcon(new ImageIcon(PanelRegistroRetiro.class.getResource("/images/ico_add-white.png")));
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
		lblIcoEliminar.setIcon(new ImageIcon(PanelRegistroRetiro.class.getResource("/images/ico_eliminar-white.png")));
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
		lblIcoModificar.setIcon(new ImageIcon(PanelRegistroRetiro.class.getResource("/images/ico_modificar-white.png")));
		lblIcoModificar.setBounds(3, 3, 24, 24);
		paneBtnModificar.add(lblIcoModificar);
		
		lblConsultar = new JLabel("CONSULTAR :");
		lblConsultar.setForeground(new Color(0, 61, 105));
		lblConsultar.setFont(new Font("Verdana", Font.BOLD, 18));
		lblConsultar.setBounds(50, 20, 140, 30);
		paneHeader.add(lblConsultar);
		
		txtIngresarCodigo = new JTextField();
		txtIngresarCodigo.setToolTipText("Ingresa un dato del alumno a consultar...");
		txtIngresarCodigo.setForeground(Color.DARK_GRAY);
		txtIngresarCodigo.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtIngresarCodigo.setColumns(10);
		txtIngresarCodigo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 61, 105)));
		txtIngresarCodigo.setBackground(new Color(224, 255, 255));
		txtIngresarCodigo.setBounds(215, 20, 380, 30);
		paneHeader.add(txtIngresarCodigo);
		
		lblIcoBusqueda = new JLabel("");
		lblIcoBusqueda.setIcon(new ImageIcon(PanelRegistroRetiro.class.getResource("/images/icoBig_Consulta.png")));
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
		
		tableRetiros = new JTable();
		tableRetiros.addMouseListener(this);
		tableRetiros.setSelectionForeground(Color.WHITE);
		tableRetiros.setSelectionBackground(new Color(54, 128, 181));
		tableRetiros.setRowMargin(0);
		tableRetiros.setRowHeight(25);
		tableRetiros.setIntercellSpacing(new Dimension(0, 0));
		tableRetiros.setFocusable(false);
		tableRetiros.setBorder(null);
		tableRetiros.getTableHeader().setOpaque(false);
		tableRetiros.getTableHeader().setBackground(new Color(0, 61, 105));
		tableRetiros.getTableHeader().setForeground(Color.WHITE);
		scrollPane.setViewportView(tableRetiros);
		tableRetiros.setModel(modelo);
		modelo.addColumn("Matrícula ID");
		modelo.addColumn("Alumno ID");
		modelo.addColumn("Curso ID");
		modelo.addColumn("Fecha");
		modelo.addColumn("Estado");
		
		listar();
		
		paneMatricular = new JPanel();
		paneMatricular.setLayout(null);
		paneMatricular.setBorder(new LineBorder(Color.WHITE, 5));
		paneMatricular.setBackground(new Color(0, 61, 105));
		paneMatricular.setBounds(615, 0, 250, 583);
		add(paneMatricular);
		
		paneHeaderRetirar = new JPanel();
		paneHeaderRetirar.setLayout(null);
		paneHeaderRetirar.setBackground(Color.WHITE);
		paneHeaderRetirar.setBounds(0, 0, 250, 30);
		paneMatricular.add(paneHeaderRetirar);
		
		lblRetirar = new JLabel("RETIRAR");
		lblRetirar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetirar.setForeground(new Color(0, 61, 105));
		lblRetirar.setFont(new Font("Verdana", Font.BOLD, 14));
		lblRetirar.setBounds(0, 0, 250, 30);
		paneHeaderRetirar.add(lblRetirar);
		
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
		
		paneBtn01 = new JPanel();
		paneBtn01.addMouseListener(this);
		paneBtn01.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtn01.setLayout(null);
		paneBtn01.setVisible(false);
		paneBtn01.setBackground(new Color(70, 130, 180));
		paneBtn01.setBounds(10, 490, 110, 30);
		paneMatricular.add(paneBtn01);
		
		lblBtn01 = new JLabel("RETIRAR");
		lblBtn01.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtn01.setForeground(Color.WHITE);
		lblBtn01.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtn01.setBounds(0, 0, 110, 30);
		paneBtn01.add(lblBtn01);
		
		paneBtn02 = new JPanel();
		paneBtn02.addMouseListener(this);
		paneBtn02.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtn02.setLayout(null);
		paneBtn02.setVisible(false);
		paneBtn02.setBackground(new Color(70, 130, 180));
		paneBtn02.setBounds(130, 490, 110, 30);
		paneMatricular.add(paneBtn02);
		
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
		
		lblCodAlumno = new JLabel("Cod. Alumno:");
		lblCodAlumno.setForeground(Color.WHITE);
		lblCodAlumno.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodAlumno.setBounds(20, 170, 150, 20);
		paneMatricular.add(lblCodAlumno);
		
		lblCurso = new JLabel("Curso:");
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCurso.setBounds(20, 230, 150, 20);
		paneMatricular.add(lblCurso);
		
		lblCodCurso = new JLabel("Cod. Curso:");
		lblCodCurso.setForeground(Color.WHITE);
		lblCodCurso.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodCurso.setBounds(20, 290, 150, 20);
		paneMatricular.add(lblCodCurso);
		
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
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEstado.setBounds(20, 350, 100, 20);
		paneMatricular.add(lblEstado);
		
		cboMatricula = new JComboBox();
		cboMatricula.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		cboMatricula.addActionListener(this);
		cboMatricula.setForeground(Color.WHITE);
		cboMatricula.setBackground(new Color(0, 61, 105));
		cboMatricula.setVisible(false);
		cboMatricula.setBounds(30, 80, 190, 20);
		paneMatricular.add(cboMatricula);
		((JLabel)cboMatricula.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		cboEstado = new JComboBox();
		cboEstado.setVisible(false);
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"RETIRADO", "MATRICULADO"}));
		cboEstado.setBackground(new Color(0, 61, 105));
		cboEstado.setForeground(Color.WHITE);
		cboEstado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		cboEstado.setBounds(30, 380, 190, 20);
		paneMatricular.add(cboEstado);
		
		txtEstado = new JTextField();
		txtEstado.setText("RETIRADO");
		txtEstado.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstado.setForeground(Color.DARK_GRAY);
		txtEstado.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtEstado.setBackground(new Color(143, 178, 207));
		txtEstado.setBounds(30, 380, 190, 20);
		paneMatricular.add(txtEstado);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableRetiros) {
			mouseClickedTableRetiros(e);
		}
		if (e.getSource() == paneBtn02) {
			mouseClickedPaneBtn02(e);
		}
		if (e.getSource() == paneBtn01) {
			mouseClickedPaneBtn01(e);
		}
		if (e.getSource() == paneBtnModificar) {
			mouseClickedPaneBtnModificar(e);
		}
		if (e.getSource() == paneBtnEliminar) {
			mouseClickedPaneBtnEliminar(e);
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
		limpieza();
		filtrarCbo = false;
		opcion = 1;
		programarComboBoxs();
		lblBtn01.setText("RETIRAR");
		paneBtn01.setVisible(true);
		paneBtn02.setVisible(true);
		
		txtNoMatricula.setText("");
		
		txtNoMatricula.setVisible(false);
		cboMatricula.setVisible(true);
		
		showDataTable = false;
		paneBtnModificar.setVisible(false);
		paneBtnEliminar.setVisible(false);
		txtIngresarCodigo.setEditable(false);
		txtIngresarCodigo.setBackground(Color.WHITE);
		cboMatricula.requestFocus();
		tableRetiros.clearSelection();
	}
	
	protected void mouseClickedPaneBtnModificar(MouseEvent e) {
		if(txtNoMatricula.getText().isEmpty()) {
			mensaje("Selecciona un elemento de la tabla");
		} else {
			filtrarCbo = false;
			opcion = 2;
			programarComboBoxs();
			navegar();
			lblBtn01.setText("GUARDAR");
			paneBtn01.setVisible(true);
			paneBtn02.setVisible(true);
			
			cboEstado.setVisible(true);
			txtEstado.setVisible(false);
			cboMatricula.setVisible(false);
			txtNoMatricula.setVisible(true);
			
			paneBtnAdicionar.setVisible(false);
			paneBtnEliminar.setVisible(false);
			txtIngresarCodigo.setEditable(false);
			txtIngresarCodigo.setBackground(Color.WHITE);
		}
		
	}
	
	protected void mouseClickedPaneBtn02(MouseEvent e) {
		//EJECUTAR CÓDIGO AL HACER CLICK EN CANCELAR
		opcion = 0;
		filtrarCbo=true;
		modReti=true;
		mostrarBotones();		
		botonesOcultos();
		limpieza();
		deshabilitar();
	}
	protected void mouseClickedPaneBtnEliminar(MouseEvent e) {
		//EJECUTAR CÓDIGO AL HACER CLICK EN ELIMINAR
		if(txtNoMatricula.getText().isEmpty()) {
			mensaje("ERROR! Seleccione un Retiro de la tabla");
		}else {
			int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este Retiro?", "Alerta!", JOptionPane.YES_NO_OPTION);
			if(resp == JOptionPane.NO_OPTION){
			  // Codigo si cancela
			}else{
				//Codigo si es ok
				
				
				try {
					
					int codigo = leerCodMatri();
					
					GestionRetiro gestionRetiro = new GestionRetiro();
					int resultado = gestionRetiro.eliminarRetiro(codigo);
					
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
		if(op=="RETIRAR") {
			//EJECUTAR CÓDIGO AL HACER CLICK EN RETIRAR (AGREGAR)
			agregarRetiro();	
		}else if(op=="GUARDAR") {
			//EJECUTAR CÓDIGO AL HACER CLICK EN GUARDAR (MODIFICAR)
			modificarRetiro();
		}
		if(modReti) {
			mostrarBotones();
			botonesOcultos();
			limpieza();
			deshabilitar();	
		}
		opcion = 0;
	}
	
	//Programar jtable
	protected void mouseClickedTableRetiros(MouseEvent e) {
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
			sorter.setRowFilter(RowFilter.regexFilter(valor));
			
			//selecciona primera opción
			if(valor.isEmpty()) {
				tableRetiros.clearSelection();
				limpieza();
			} else {
				tableRetiros.changeSelection(0, 0, false, false);
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
		txtAlumno.setText("");
		txtCodAlumno.setText("");
		txtCurso.setText("");
		txtCodCurso.setText("");
		
	}
	
	//Deshabilitar campos
	void deshabilitar() {

		cboMatricula.setVisible(false);
		txtNoMatricula.setVisible(true);
		
		txtCurso.setVisible(true);
		cboEstado.setVisible(false);
		
		
		txtIngresarCodigo.setText("");
		txtIngresarCodigo.requestFocus();
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
		txtEstado.setVisible(true);
		txtEstado.setText("RETIRADO");
	}
	
	//Cargar todos los datos a cboMatricula
	void cargarComboBoxMatricula() {
		
		GestionMatricula gestionMatricula = new GestionMatricula();
		listaMatricula = gestionMatricula.listarMatricula();
		for (int i = 0; i < listaMatricula.size(); i++) {
			int numMatricula = listaMatricula.get(i).getMatId();
			cboMatricula.addItem(numMatricula+"");
		}

	}
	
	
	//Vaciar comboBoxs
	void limpiarComboBoxs() {
		cboMatricula.removeAllItems();
	}
	
	//Programar Combo Boxs
	void programarComboBoxs() {
		limpiarComboBoxs();

		cargarComboBoxMatricula();
		
		cboMatricula.setSelectedIndex(0);
		
		cboEstado.setVisible(true);
		cboMatricula.setVisible(true);
		txtNoMatricula.setVisible(false);
		
		
	}
	
	//Navegar
	void navegar() {
		if(showDataTable && opcion != 1) {
			
			try {
				filaSeleccionada = tableRetiros.getSelectedRow();
				txtNoMatricula.setText(""+tableRetiros.getValueAt(filaSeleccionada, 0));
				txtCodAlumno.setText(""+tableRetiros.getValueAt(filaSeleccionada, 1));
				txtCodCurso.setText(""+tableRetiros.getValueAt(filaSeleccionada, 2));		
				
				GestionRetiro gestionRetiro = new GestionRetiro();
				
				//Programar Alumno
				int codAlum = leerCodAlu();
				String nomA = gestionRetiro.nombreAlumno(codAlum);
				txtAlumno.setText(nomA);
				
				//Programar Curso
				int codCurso = leerCodCur();
				String nomC = gestionRetiro.nombreCurso(codCurso);
				txtCurso.setText(nomC);
				
				
			}catch(Exception em) {
				
			}
		}
		
	}
	
	//Método para listar el el JTable
	void listar() {
		
		GestionRetiro gestionRetiro = new GestionRetiro();
		listaRetiro = gestionRetiro.listarRetiro();
		
		for (int i = 0; i < listaRetiro.size(); i++) {
			RetiroEntity entity = listaRetiro.get(i);
			String idRetiro= Integer.toString(entity.getMatId());
			String idAlumno =  Integer.toString(entity.getAluId());
			String idCurso = Integer.toString(entity.getCurId());
			
			Date fechaDate = entity.getFecha();
			Locale fechLocale = new Locale("es","PE");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",fechLocale);
			
			String fechaRetiro = dateFormat.format(fechaDate);
			String estado = Integer.toString(entity.getMatEstado());
			
			Object datos[] = {idRetiro,idAlumno,idCurso,fechaRetiro,estado};
			modelo.addRow(datos);
			sorter = new TableRowSorter<>(modelo);
	   		tableRetiros.setRowSorter(sorter);
		}
	}	
	
	//Método para agregar un nuevo registro
   	void agregarRetiro() {
   		
			int codMat = leerCodMatriCbo();
			RetiroEntity retiroEntity = new RetiroEntity(codMat);	
			
			GestionRetiro gestionRetiro = new GestionRetiro();
			int resultado = gestionRetiro.editarRetiro(retiroEntity);
			
			if(resultado != -1) {
				JOptionPane.showMessageDialog(null, "Actualización correcta");
			} else {
				JOptionPane.showMessageDialog(null, "Actualización incorrecta");
			}
			
			//refrescar la tabla
			modelo.setRowCount(0);
			listar();   	
   		
   	}
   	  	
   	//Método para modificar un nuevo registro
   	void modificarRetiro() {
   			
   		if(filaSeleccionada >= 0) {
   			
   			int codMat = leerCodMatri();
 
   			int estado = leerEstado();
   			
   			RetiroEntity retiroEntity = new RetiroEntity(codMat, estado);		
   			
   			GestionRetiro gestionRetiro = new GestionRetiro();
   			int resultado = gestionRetiro.editarRetiro(retiroEntity);
   			
   			if(resultado != -1) {
   				JOptionPane.showMessageDialog(null, "Actualización correcta");
   			} else {
   				JOptionPane.showMessageDialog(null, "Actualización incorrecta");
   			}
   			
   			//refrescar la tabla
   			modelo.setRowCount(0);
   			listar();
   			limpieza();

   		}else {
   			mensaje("Selecciona una fila de la tabla");
   			modReti=false;
   		}
   			
   	}
   	
   	//LEER DATOS DE LOS CAMPOS TXT MATRICULA   	
   	int leerCodMatri() {
   		return Integer.parseInt( txtNoMatricula.getText().trim() );
   	}
   	
   	int leerCodMatriCbo() {
   		return Integer.parseInt( ""+cboMatricula.getSelectedItem() );
   	}
   	
   	int leerEstado() {
   		return Integer.parseInt( ""+cboEstado.getSelectedIndex() );
   	}
	
	int leerCodAlu() {
		return Integer.parseInt(txtCodAlumno.getText().trim());
	}

	int leerCodCur() {
		return Integer.parseInt(txtCodCurso.getText().trim());
	}
		
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboMatricula) {
			actionPerformedCboMatricula(e);
		}
	}
	protected void actionPerformedCboMatricula(ActionEvent e) {
		
		int posicionCboMatricula = cboMatricula.getSelectedIndex();
		if (posicionCboMatricula >= 0) {
			GestionMatricula gestionMatricula = new GestionMatricula();
			
			MatriculaEntity matriculaEntity = listaMatricula.get(posicionCboMatricula);			
			txtNoMatricula.setText(matriculaEntity.getMatId()+"");
			
			txtCodAlumno.setText(matriculaEntity.getAluId()+"");
			String nomAlumno = gestionMatricula.nombreAlumno(matriculaEntity.getAluId());
			txtAlumno.setText(nomAlumno);
						
			txtCodCurso.setText(matriculaEntity.getCurId()+"");
			String nomCurso = gestionMatricula.nombreCurso(matriculaEntity.getAluId());
			txtCurso.setText(nomCurso);
			
			if(matriculaEntity.getMatEstado() == 0) txtEstado.setText("RETIRADO");
			else txtEstado.setText("MATRICULADO");
			
		}
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCodCurso) {
			keyTypedTxtCoCurso(e);
		}
		if (e.getSource() == txtCurso) {
			keyTypedTxtCurso(e);
		}
		if (e.getSource() == txtCodAlumno) {
			keyTypedTxtCoAlumno(e);
		}
		if (e.getSource() == txtAlumno) {
			keyTypedTxtAlumno(e);
		}
		if (e.getSource() == txtNoMatricula) {
			keyTypedTxtNoMatricula(e);
		}
	}
	protected void keyTypedTxtNoMatricula(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtCoAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtCurso(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtCoCurso(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}

}
