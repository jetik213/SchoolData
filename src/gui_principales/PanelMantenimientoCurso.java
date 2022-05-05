package gui_principales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import entidades.CursoEntity;
import gestion.GestionCurso;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class PanelMantenimientoCurso extends JPanel implements MouseListener, KeyListener {
	private JPanel paneHeader;
	private JTextField txtIngresarCodigo;
	private JPanel paneBtnAdicionar;
	private JLabel lblBtnAdicionar;
	private JPanel paneBtnEliminar;
	private JLabel lblBtnEliminar;
	private JPanel paneBtnModificar;
	private JLabel lblBtnModificar;
	private JPanel paneCursos;
	private JScrollPane scrollPane;
	private JTable tableCursos;
	private JPanel paneCursoDatos;
	private JPanel paneHeaderCurso;
	private JLabel lblCurso;
	private JLabel lblCodigoCursoTitle;
	private JTextField txtCodigoCurso;
	private JLabel lblAsignaturaCursoTitle;
	private JLabel lblCicloCursoTitle;
	private JLabel lblCreditosCursoTitle;
	private JLabel lblHorasCursoTitle;
	private JTextField txtAsignaturaCurso;
	private JTextField txtCicloCurso;
	private JTextField txtCreditosCurso;
	private JTextField txtHorasCurso;
	private JPanel paneBtn01;
	private JPanel paneBtn02;
	private JLabel lblBtn01;
	private JLabel lblBtn02;
	private JLabel lblConsultar;
	private JComboBox cboCiclo;
	private JLabel lblIcoBusqueda;
	private JLabel lblIcoAdd;
	private JLabel lblIcoModificar;
	private JLabel lblIcoEliminar;

	//Variables Globales	
	TableRowSorter<DefaultTableModel> sorter;
	ArrayList<CursoEntity> listaCurso = new ArrayList<CursoEntity>();
	DefaultTableModel modelo = new DefaultTableModel();
	boolean showDataTable = true;

	/**
	 * Create the panel.
	 */
	public PanelMantenimientoCurso() {
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
		txtIngresarCodigo.setToolTipText("Ingresa un dato del curso a consultar...");
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
		lblIcoAdd.setIcon(new ImageIcon(PanelMantenimientoCurso.class.getResource("/images/ico_add-white.png")));
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
		lblIcoEliminar.setIcon(new ImageIcon(PanelMantenimientoCurso.class.getResource("/images/ico_eliminar-white.png")));
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
		lblIcoModificar.setIcon(new ImageIcon(PanelMantenimientoCurso.class.getResource("/images/ico_modificar-white.png")));
		lblIcoModificar.setBounds(3, 3, 24, 24);
		paneBtnModificar.add(lblIcoModificar);
		
		lblConsultar = new JLabel("CONSULTAR :");
		lblConsultar.setForeground(new Color(0, 61, 105));
		lblConsultar.setFont(new Font("Verdana", Font.BOLD, 18));
		lblConsultar.setBounds(50, 20, 140, 30);
		paneHeader.add(lblConsultar);
		
		lblIcoBusqueda = new JLabel("");
		lblIcoBusqueda.setIcon(new ImageIcon(PanelMantenimientoCurso.class.getResource("/images/icoBig_Consulta.png")));
		lblIcoBusqueda.setBounds(10, 20, 30, 30);
		paneHeader.add(lblIcoBusqueda);
		
		paneCursos = new JPanel();
		paneCursos.setLayout(null);
		paneCursos.setBackground(Color.WHITE);
		paneCursos.setBounds(0, 140, 605, 443);
		add(paneCursos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 605, 443);
		paneCursos.add(scrollPane);
		
		tableCursos = new JTable();
		tableCursos.addKeyListener(this);
		tableCursos.addMouseListener(this);
		tableCursos.setSelectionForeground(Color.WHITE);
		tableCursos.setSelectionBackground(new Color(54, 128, 181));
		tableCursos.setRowMargin(0);
		tableCursos.setRowHeight(25);
		tableCursos.setIntercellSpacing(new Dimension(0, 0));
		tableCursos.setFocusable(false);
		tableCursos.setBorder(null);
		tableCursos.getTableHeader().setOpaque(false);
		tableCursos.getTableHeader().setBackground(new Color(0, 61, 105));
		tableCursos.getTableHeader().setForeground(Color.WHITE);
		scrollPane.setViewportView(tableCursos);
		tableCursos.setModel(modelo);
		modelo.addColumn("Código");
		modelo.addColumn("Curso");
		modelo.addColumn("Ciclo");
		modelo.addColumn("Créditos");
		modelo.addColumn("Horas");
		
		paneCursoDatos = new JPanel();
		paneCursoDatos.setBorder(new LineBorder(Color.WHITE, 5));
		paneCursoDatos.setBackground(new Color(0, 61, 105));
		paneCursoDatos.setBounds(615, 0, 250, 583);
		add(paneCursoDatos);
		paneCursoDatos.setLayout(null);
		
		paneHeaderCurso = new JPanel();
		paneHeaderCurso.setLayout(null);
		paneHeaderCurso.setBackground(Color.WHITE);
		paneHeaderCurso.setBounds(0, 0, 250, 30);
		paneCursoDatos.add(paneHeaderCurso);
		
		lblCurso = new JLabel("DATOS DEL CURSO");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setForeground(new Color(0, 61, 105));
		lblCurso.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCurso.setBounds(0, 0, 250, 30);
		paneHeaderCurso.add(lblCurso);
		
		lblCodigoCursoTitle = new JLabel("C\u00F3digo:");
		lblCodigoCursoTitle.setForeground(Color.WHITE);
		lblCodigoCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodigoCursoTitle.setBounds(20, 50, 150, 20);
		paneCursoDatos.add(lblCodigoCursoTitle);
		
		txtCodigoCurso = new JTextField();
		txtCodigoCurso.addKeyListener(this);
		txtCodigoCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoCurso.setForeground(Color.DARK_GRAY);
		txtCodigoCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCodigoCurso.setEditable(false);
		txtCodigoCurso.setColumns(10);
		txtCodigoCurso.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtCodigoCurso.setBackground(new Color(143, 178, 207));
		txtCodigoCurso.setBounds(30, 80, 190, 20);
		paneCursoDatos.add(txtCodigoCurso);
		
		lblAsignaturaCursoTitle = new JLabel("Asignatura:");
		lblAsignaturaCursoTitle.setForeground(Color.WHITE);
		lblAsignaturaCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAsignaturaCursoTitle.setBounds(20, 110, 150, 20);
		paneCursoDatos.add(lblAsignaturaCursoTitle);
		
		lblCicloCursoTitle = new JLabel("Ciclo:");
		lblCicloCursoTitle.setForeground(Color.WHITE);
		lblCicloCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCicloCursoTitle.setBounds(20, 178, 150, 20);
		paneCursoDatos.add(lblCicloCursoTitle);
		
		lblCreditosCursoTitle = new JLabel("N\u00B0 de Cr\u00E9ditos:");
		lblCreditosCursoTitle.setForeground(Color.WHITE);
		lblCreditosCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCreditosCursoTitle.setBounds(20, 238, 150, 20);
		paneCursoDatos.add(lblCreditosCursoTitle);
		
		lblHorasCursoTitle = new JLabel("Cant. de Horas:");
		lblHorasCursoTitle.setForeground(Color.WHITE);
		lblHorasCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblHorasCursoTitle.setBounds(20, 298, 150, 20);
		paneCursoDatos.add(lblHorasCursoTitle);
		
		txtAsignaturaCurso = new JTextField();
		txtAsignaturaCurso.addKeyListener(this);
		txtAsignaturaCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsignaturaCurso.setForeground(Color.DARK_GRAY);
		txtAsignaturaCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtAsignaturaCurso.setEditable(false);
		txtAsignaturaCurso.setColumns(10);
		txtAsignaturaCurso.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtAsignaturaCurso.setBackground(new Color(143, 178, 207));
		txtAsignaturaCurso.setBounds(30, 140, 190, 20);
		paneCursoDatos.add(txtAsignaturaCurso);
		
		txtCicloCurso = new JTextField();
		txtCicloCurso.addKeyListener(this);
		txtCicloCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtCicloCurso.setForeground(Color.DARK_GRAY);
		txtCicloCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCicloCurso.setEditable(false);
		txtCicloCurso.setColumns(10);
		txtCicloCurso.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtCicloCurso.setBackground(new Color(143, 178, 207));
		txtCicloCurso.setBounds(30, 208, 190, 20);
		paneCursoDatos.add(txtCicloCurso);
		
		txtCreditosCurso = new JTextField();
		txtCreditosCurso.addKeyListener(this);
		txtCreditosCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtCreditosCurso.setForeground(Color.DARK_GRAY);
		txtCreditosCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCreditosCurso.setEditable(false);
		txtCreditosCurso.setColumns(10);
		txtCreditosCurso.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtCreditosCurso.setBackground(new Color(143, 178, 207));
		txtCreditosCurso.setBounds(30, 268, 190, 20);
		paneCursoDatos.add(txtCreditosCurso);
		
		txtHorasCurso = new JTextField();
		txtHorasCurso.addKeyListener(this);
		txtHorasCurso.setHorizontalAlignment(SwingConstants.CENTER);
		txtHorasCurso.setForeground(Color.DARK_GRAY);
		txtHorasCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtHorasCurso.setEditable(false);
		txtHorasCurso.setColumns(10);
		txtHorasCurso.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 61, 105)));
		txtHorasCurso.setBackground(new Color(143, 178, 207));
		txtHorasCurso.setBounds(30, 328, 190, 20);
		paneCursoDatos.add(txtHorasCurso);
		
		paneBtn01 = new JPanel();
		paneBtn01.addMouseListener(this);
		paneBtn01.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtn01.setVisible(false);
		paneBtn01.setBackground(new Color(70, 130, 180));
		paneBtn01.setBounds(10, 525, 110, 30);
		paneCursoDatos.add(paneBtn01);
		paneBtn01.setLayout(null);
		
		lblBtn01 = new JLabel("AGREGAR");
		lblBtn01.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtn01.setForeground(Color.WHITE);
		lblBtn01.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtn01.setBounds(0, 0, 110, 30);
		paneBtn01.add(lblBtn01);
		
		paneBtn02 = new JPanel();
		paneBtn02.addMouseListener(this);
		paneBtn02.setVisible(false);
		paneBtn02.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtn02.setBackground(new Color(70, 130, 180));
		paneBtn02.setBounds(130, 525, 110, 30);
		paneCursoDatos.add(paneBtn02);
		paneBtn02.setLayout(null);
		
		lblBtn02 = new JLabel("CANCELAR");
		lblBtn02.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtn02.setForeground(Color.WHITE);
		lblBtn02.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtn02.setBounds(0, 0, 110, 30);
		paneBtn02.add(lblBtn02);
		
		cboCiclo = new JComboBox();
		cboCiclo.setForeground(Color.WHITE);
		cboCiclo.setVisible(false);
		cboCiclo.setModel(new DefaultComboBoxModel(new String[] {"Primer Ciclo", "Segundo Ciclo", "Tercer Ciclo", "Cuarto Ciclo", "Quinto Ciclo", "Sexto Ciclo"}));
		cboCiclo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		cboCiclo.setBackground(new Color(0, 61, 105));
		cboCiclo.setBounds(30, 208, 190, 20);
		paneCursoDatos.add(cboCiclo);
		((JLabel)cboCiclo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);//Alinea items de combo box
		
		listar();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == paneBtnEliminar) {
			mouseClickedPaneBtnEliminar(e);
		}
		if (e.getSource() == paneBtnModificar) {
			mouseClickedPaneBtnModificar(e);
		}
		if (e.getSource() == paneBtnAdicionar) {
			mouseClickedPaneBtnAdicionar(e);
		}
		if (e.getSource() == paneBtn02) {
			mouseClickedPaneBtn02(e);
		}
		if (e.getSource() == paneBtn01) {
			mouseClickedPaneBtn01(e);
		}
		if (e.getSource() == tableCursos) {
			mouseClickedTableCursos(e);
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
		txtCicloCurso.setVisible(false);
		cboCiclo.setVisible(true);
		txtCodigoCurso.setText("");//CAMBIADO
		txtAsignaturaCurso.setText("");
		txtCicloCurso.setText("");
		txtCreditosCurso.setText("");
		txtHorasCurso.setText("");
		
		txtCodigoCurso.setEditable(false);
		txtCodigoCurso.setBackground(new Color(143, 178, 207));
		txtAsignaturaCurso.setEditable(true);
		txtAsignaturaCurso.setBackground(Color.WHITE);
		txtCicloCurso.setEditable(true);
		txtCicloCurso.setBackground(Color.WHITE);
		txtCreditosCurso.setEditable(true);
		txtCreditosCurso.setBackground(Color.WHITE);
		txtHorasCurso.setEditable(true);
		txtHorasCurso.setBackground(Color.WHITE);
		
		//Agregado nuevo
		showDataTable = false;
		paneBtnModificar.setVisible(false);
		paneBtnEliminar.setVisible(false);
		txtIngresarCodigo.setEditable(false);
		txtIngresarCodigo.setBackground(Color.WHITE);
		txtAsignaturaCurso.requestFocus();
		tableCursos.clearSelection();		
	}
	
	protected void mouseClickedPaneBtnModificar(MouseEvent e) {
		if(txtCodigoCurso.getText().isEmpty()) {
			mensaje("Selecciona un Alumno de la tabla primero");
		} else {
			lblBtn01.setText("GUARDAR");
			paneBtn01.setVisible(true);
			paneBtn02.setVisible(true);
			txtCicloCurso.setVisible(false);
			cboCiclo.setVisible(true);
			txtCodigoCurso.setEditable(false);
			txtAsignaturaCurso.setEditable(true);
			txtCicloCurso.setEditable(true);
			txtCreditosCurso.setEditable(true);
			txtHorasCurso.setEditable(true);
			
			txtCodigoCurso.setBackground(new Color(143, 178, 207));
			txtAsignaturaCurso.setBackground(Color.WHITE);
			txtCicloCurso.setBackground(Color.WHITE);
			txtCreditosCurso.setBackground(Color.WHITE);
			txtHorasCurso.setBackground(Color.WHITE);
			
			//Agregado nuevo
			paneBtnAdicionar.setVisible(false);
			paneBtnEliminar.setVisible(false);
			txtIngresarCodigo.setEditable(false);
			txtIngresarCodigo.setBackground(Color.WHITE);
			txtAsignaturaCurso.requestFocus();
			
			//mostrarCboCiclo();
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
			int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar a este Curso?", "Alerta!", JOptionPane.YES_NO_OPTION);
			if(resp == JOptionPane.NO_OPTION){
			  // Codigo si cancela
			}else{
			  //Codigo si es ok
				
				int codigo = leerCodCur();
				
				GestionCurso gestionCurso = new GestionCurso();
				int resultado = gestionCurso.eliminarCurso(codigo);
				
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
			mensaje("ERROR! Seleccione un Curso");
			txtCodigoCurso.requestFocus();
		}
		limpieza();	
		txtIngresarCodigo.setText("");
		txtIngresarCodigo.requestFocus();
	}
	protected void mouseClickedPaneBtn01(MouseEvent e) {
		String op = lblBtn01.getText();
		if(op=="AGREGAR") {
			//EJECUTAR CÓDIGO AL HACER CLICK EN AGREGAR (ADICIONAR)
			agregarCurso();
		}else if(op=="GUARDAR") {
			//EJECUTAR CÓDIGO AL HACER CLICK EN GUARDAR (MODIFICAR)
			modificarCurso();
		}
		mostrarBotones();
		botonesOcultos();
		limpieza();
		deshabilitar();
	}
	
	protected void mouseClickedTableCursos(MouseEvent e) {
		navegar();
	}
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtIngresarCodigo) {
			keyReleasedTxtIngresarCodigo(e);
		}
		if (e.getSource() == tableCursos) {
			keyReleasedTableCursos(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtHorasCurso) {
			keyTypedTxtHorasCurso(e);
		}
		if (e.getSource() == txtCreditosCurso) {
			keyTypedTxtCreditosCurso(e);
		}
		if (e.getSource() == txtCicloCurso) {
			keyTypedTxtCicloCurso(e);
		}
		if (e.getSource() == txtAsignaturaCurso) {
			keyTypedTxtAsignaturaCurso(e);
		}
		if (e.getSource() == txtCodigoCurso) {
			keyTypedTxtCodigoCurso(e);
		}
	}
	protected void keyReleasedTableCursos(KeyEvent e) {
		navegar();
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
				tableCursos.clearSelection();
				limpieza();
			} else {
				tableCursos.changeSelection(0, 0, false, false);
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
		txtCodigoCurso.setText("");
		txtAsignaturaCurso.setText("");
		txtCicloCurso.setText("");
		txtCreditosCurso.setText("");
		txtHorasCurso.setText("");		
	}
	
	//Deshabilitar campos
	void deshabilitar() {
		txtCodigoCurso.setEditable(false);
		txtAsignaturaCurso.setEditable(false);
		txtCicloCurso.setEditable(false);
		txtCreditosCurso.setEditable(false);
		txtHorasCurso.setEditable(false);
		
		txtCodigoCurso.setBackground(new Color(143, 178, 207));
		txtAsignaturaCurso.setBackground(new Color(143, 178, 207));
		txtCicloCurso.setBackground(new Color(143, 178, 207));
		txtCreditosCurso.setBackground(new Color(143, 178, 207));
		txtHorasCurso.setBackground(new Color(143, 178, 207));
		
		txtCicloCurso.setVisible(true);
		cboCiclo.setVisible(false);
		
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
	}
	
	//Navegar
	void navegar() {
		if(showDataTable) {
			try {
				int select = tableCursos.getSelectedRow();
				txtCodigoCurso.setText(""+tableCursos.getValueAt(select, 0));
				txtAsignaturaCurso.setText(""+tableCursos.getValueAt(select, 1));
				txtCicloCurso.setText(""+tableCursos.getValueAt(select, 2));
				txtCreditosCurso.setText(""+tableCursos.getValueAt(select, 3));
				txtHorasCurso.setText(""+tableCursos.getValueAt(select, 4));
			}catch (Exception en) {
				
			}
				
		}
		
	}
	
	//Método para listar el el JTable
   	void listar() {

		GestionCurso gestionCurso = new GestionCurso();
		listaCurso = gestionCurso.listarCursos();
		
		for (int i = 0; i < listaCurso.size(); i++) {
			CursoEntity entity = listaCurso.get(i);
			String idCurso= Integer.toString(entity.getCurId());
			String nombre =  entity.getCurNombre();
			String ciclo = entity.getCurCiclo()+"";
			String creditos = entity.getCurCreditos()+"";
			String horas = entity.getCurHoras()+"";

			
			Object datos[] = {idCurso,nombre,ciclo,creditos,horas};
			modelo.addRow(datos);
			sorter = new TableRowSorter<>(modelo);
	   		tableCursos.setRowSorter(sorter);
		}	
   	}	
	
	//Método para agregar un nuevo registro
   	void agregarCurso() {
   		
		String nombre =  leerAsignatura();
		int ciclo = leerCboCiclo();
		int creditos = leerCreditos();
		int horas = leerHoras();
		
		CursoEntity cursoEntity = new CursoEntity(nombre, ciclo, creditos, horas);
		
		GestionCurso gestionCurso = new GestionCurso();
		int resultado = gestionCurso.registrarCurso(cursoEntity);
		
		if (resultado == 1) {
			JOptionPane.showMessageDialog(null, "Registro exitoso");
		} else {
			JOptionPane.showMessageDialog(null, "Registro incorrecto");
		}
		
		modelo.setRowCount(0);
		listar();			
   	}
   	  	
   	//Método para modificar un nuevo registro
   	void modificarCurso() {
	
		int codigo = leerCodCur();
		String nombre =  leerAsignatura();
		int ciclo = leerCboCiclo();
		int creditos = leerCreditos();
		int horas = leerHoras();

		CursoEntity cursoEntity = new CursoEntity(codigo , nombre, ciclo, creditos, horas, 1);	
		
		GestionCurso gestionCurso = new GestionCurso();
		int resultado = gestionCurso.editarCurso(cursoEntity);
		
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
   	int leerCodCur() {
   		return Integer.parseInt( txtCodigoCurso.getText().trim() );
   	}
	
	String leerAsignatura() {
		return txtAsignaturaCurso.getText().trim();
	}

	int leerCiclo() {
		return Integer.parseInt(txtCicloCurso.getText().trim());
	}
	
	int leerCboCiclo() {
		return cboCiclo.getSelectedIndex()+1;
	}
	
	int leerCreditos() {
		return Integer.parseInt( txtCreditosCurso.getText().trim() );
	}
	
	int leerHoras() {
		return Integer.parseInt( txtHorasCurso.getText().trim() );
	}
	
	
	//VALIDACIONES DE ESCRITURA
	protected void keyTypedTxtCodigoCurso(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtAsignaturaCurso(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtCicloCurso(KeyEvent e) {
		char c = e.getKeyChar();
		if((c< 'a' || c>'z') && (c< 'A' || c>'Z')&& (c>' ')&&(c<'á'||c>'ú')&&(c<'Á'||c>'Ú')&& ( c != ' '))
			e.consume();
	}
	protected void keyTypedTxtCreditosCurso(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
	protected void keyTypedTxtHorasCurso(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
}
