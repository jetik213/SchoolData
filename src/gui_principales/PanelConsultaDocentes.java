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
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;

import entidades.CursoEntity;
import entidades.DocenteEntity;
import gestion.GestionDocente;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Cursor;

public class PanelConsultaDocentes extends JPanel implements MouseListener, KeyListener {
	private JPanel paneHeader;
	private JTextField txtBuscarDocente;
	private JPanel paneBtnBuscar;
	private JLabel lblBtnBuscar;
	private JPanel paneAlumno;
	private JPanel paneHeaderCursos;
	private JLabel lblCursos;
	private JLabel lblFondo;
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
	private JTextField txtNombresDocente;
	private JTextField txtApPaternoDocente;
	private JTextField txtApMaternoDocente;
	private JTextField txtDniDocente;
	private JTextField txtCelularDocente;
	private JTextField txtEspecialidadDocente;
	private JTextField txtFiDocente;
	private JScrollPane scrollPane;
	private JTable tableCursos;
	private JLabel lblIcoBusqueda;

	//Variables globales	
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<CursoEntity> listaCurso = new ArrayList<CursoEntity>();
	ArrayList<DocenteEntity> listaDocente = new ArrayList<DocenteEntity>();
	/**
	 * Create the panel.
	 */
	public PanelConsultaDocentes() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0,0,865,583);
		setLayout(null);
		
		paneHeader = new JPanel();
		paneHeader.setLayout(null);
		paneHeader.setBackground(Color.WHITE);
		paneHeader.setBounds(0, 0, 865, 70);
		add(paneHeader);
		
		txtBuscarDocente = new JTextField();
		txtBuscarDocente.setToolTipText("Escriba el c\u00F3digo del Docente \u00A1Solo n\u00FAmeros!");
		txtBuscarDocente.addMouseListener(this);
		txtBuscarDocente.addKeyListener(this);
		txtBuscarDocente.setText("Ingrese el c\u00F3digo del Docente...");
		txtBuscarDocente.setForeground(Color.LIGHT_GRAY);
		txtBuscarDocente.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtBuscarDocente.setColumns(10);
		txtBuscarDocente.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 61, 105)));
		txtBuscarDocente.setBounds(10, 20, 660, 30);
		paneHeader.add(txtBuscarDocente);
		
		paneBtnBuscar = new JPanel();
		paneBtnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtnBuscar.addMouseListener(this);
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
		lblIcoBusqueda.setIcon(new ImageIcon(PanelConsultaDocentes.class.getResource("/images/ico_busqueda-White.png")));
		lblIcoBusqueda.setBounds(10, 3, 24, 24);
		paneBtnBuscar.add(lblIcoBusqueda);
		
		paneAlumno = new JPanel();
		paneAlumno.setLayout(null);
		paneAlumno.setBackground(Color.WHITE);
		paneAlumno.setBounds(0, 80, 569, 503);
		add(paneAlumno);
		
		paneHeaderCursos = new JPanel();
		paneHeaderCursos.setLayout(null);
		paneHeaderCursos.setBackground(new Color(0, 61, 105));
		paneHeaderCursos.setBounds(0, 0, 569, 30);
		paneAlumno.add(paneHeaderCursos);
		
		lblCursos = new JLabel("CURSOS ASIGNADOS AL DOCENTE");
		lblCursos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCursos.setForeground(Color.WHITE);
		lblCursos.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCursos.setBounds(0, 0, 569, 30);
		paneHeaderCursos.add(lblCursos);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PanelConsultaDocentes.class.getResource("/images/fondo_objeto.png")));
		lblFondo.setBounds(0, 0, 569, 503);
		paneAlumno.add(lblFondo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 40, 549, 364);
		paneAlumno.add(scrollPane);
		
		tableCursos = new JTable();
		tableCursos.addKeyListener(this);
		tableCursos.addMouseListener(this);
		tableCursos.setRowHeight(25);
		tableCursos.setRowMargin(0);
		tableCursos.setBorder(null);
		tableCursos.setFocusable(false);
		tableCursos.setIntercellSpacing(new Dimension(0, 0));
		tableCursos.setSelectionForeground(Color.WHITE);
		tableCursos.setSelectionBackground(new Color(54, 128, 181));
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
		
		paneDocente = new JPanel();
		paneDocente.setLayout(null);
		paneDocente.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		paneDocente.setBackground(new Color(0, 61, 105));
		paneDocente.setBounds(579, 80, 286, 503);
		add(paneDocente);
		
		paneHeaderDocente = new JPanel();
		paneHeaderDocente.setLayout(null);
		paneHeaderDocente.setBackground(Color.WHITE);
		paneHeaderDocente.setBounds(0, 0, 286, 30);
		paneDocente.add(paneHeaderDocente);
		
		lblDocente = new JLabel("DATOS DEL DOCENTE");
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
		txtCodigoDocente.addKeyListener(this);
		txtCodigoDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoDocente.setForeground(Color.DARK_GRAY);
		txtCodigoDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCodigoDocente.setEditable(false);
		txtCodigoDocente.setColumns(10);
		txtCodigoDocente.setBounds(30, 81, 105, 20);
		paneDocente.add(txtCodigoDocente);
		
		txtNombresDocente = new JTextField();
		txtNombresDocente.addKeyListener(this);
		txtNombresDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombresDocente.setForeground(Color.DARK_GRAY);
		txtNombresDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtNombresDocente.setEditable(false);
		txtNombresDocente.setColumns(10);
		txtNombresDocente.setBounds(30, 140, 226, 20);
		paneDocente.add(txtNombresDocente);
		
		txtApPaternoDocente = new JTextField();
		txtApPaternoDocente.addKeyListener(this);
		txtApPaternoDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtApPaternoDocente.setForeground(Color.DARK_GRAY);
		txtApPaternoDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApPaternoDocente.setEditable(false);
		txtApPaternoDocente.setColumns(10);
		txtApPaternoDocente.setBounds(30, 208, 226, 20);
		paneDocente.add(txtApPaternoDocente);
		
		txtApMaternoDocente = new JTextField();
		txtApMaternoDocente.addKeyListener(this);
		txtApMaternoDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtApMaternoDocente.setForeground(Color.DARK_GRAY);
		txtApMaternoDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApMaternoDocente.setEditable(false);
		txtApMaternoDocente.setColumns(10);
		txtApMaternoDocente.setBounds(30, 268, 226, 20);
		paneDocente.add(txtApMaternoDocente);
		
		txtDniDocente = new JTextField();
		txtDniDocente.addKeyListener(this);
		txtDniDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtDniDocente.setForeground(Color.DARK_GRAY);
		txtDniDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtDniDocente.setEditable(false);
		txtDniDocente.setColumns(10);
		txtDniDocente.setBounds(151, 80, 105, 20);
		paneDocente.add(txtDniDocente);
		
		txtCelularDocente = new JTextField();
		txtCelularDocente.addKeyListener(this);
		txtCelularDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelularDocente.setForeground(Color.DARK_GRAY);
		txtCelularDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCelularDocente.setEditable(false);
		txtCelularDocente.setColumns(10);
		txtCelularDocente.setBounds(30, 328, 226, 20);
		paneDocente.add(txtCelularDocente);
		
		txtEspecialidadDocente = new JTextField();
		txtEspecialidadDocente.addKeyListener(this);
		txtEspecialidadDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtEspecialidadDocente.setForeground(Color.DARK_GRAY);
		txtEspecialidadDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtEspecialidadDocente.setEditable(false);
		txtEspecialidadDocente.setColumns(10);
		txtEspecialidadDocente.setBounds(30, 388, 226, 20);
		paneDocente.add(txtEspecialidadDocente);
		
		txtFiDocente = new JTextField();
		txtFiDocente.addKeyListener(this);
		txtFiDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtFiDocente.setForeground(Color.DARK_GRAY);
		txtFiDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtFiDocente.setEditable(false);
		txtFiDocente.setColumns(10);
		txtFiDocente.setBounds(30, 448, 226, 20);
		paneDocente.add(txtFiDocente);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == paneBtnBuscar) {
			mouseClickedPaneBtnBuscar(e);
		}
		if (e.getSource() == tableCursos) {
			mouseClickedTableCursos(e);
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
		if (e.getSource() == txtBuscarDocente) {
			mousePressedTxtBuscarDocente(e);
		}
		
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mousePressedTxtBuscarDocente(MouseEvent e) {
		txtBuscarDocente.setForeground(Color.DARK_GRAY);
		txtBuscarDocente.setText("");
	}
	protected void mouseEnteredPaneBtnBuscar(MouseEvent e) {
		paneBtnBuscar.setBackground(new Color(44, 110, 145));
	}
	protected void mouseExitedPaneBtnBuscar(MouseEvent e) {
		paneBtnBuscar.setBackground(new Color(0, 61, 105));
	}
	protected void mouseClickedTableCursos(MouseEvent e) {
	}

	protected void mouseClickedPaneBtnBuscar(MouseEvent e) {
		//CÓDIGO BOTÓN BUSCAR
		try {
			limpieza();
			listar();
		}catch(Exception exc) {
			mensaje("El docente no tiene asignado ningún curso o el código no existe");
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
		txtCodigoDocente.setText("");
		txtNombresDocente.setText("");
		txtApPaternoDocente.setText("");
		txtApMaternoDocente.setText("");
		txtDniDocente.setText("");
		txtCelularDocente.setText("");
		txtEspecialidadDocente.setText("");
		txtFiDocente.setText("");
	}
	
	//Método para listar
   	void listar() {
   		
   		GestionDocente gestionDocente = new GestionDocente();
   		listaDocente = gestionDocente.buscarDocentes(Integer.parseInt(txtBuscarDocente.getText()));
   		
   		
   		
  		//------------------------------------------------------------------//
  		// 				Llenar datos de docente
  		//------------------------------------------------------------------//
   		DocenteEntity de = listaDocente.get(0);
   		txtCodigoDocente.setText(""+de.getId());
		txtNombresDocente.setText(""+de.getNombres());
		txtApPaternoDocente.setText(""+de.getApellidoPaterno());
		txtApMaternoDocente.setText(""+de.getApellidoMaterno());
		txtDniDocente.setText(""+de.getDni());
		txtCelularDocente.setText(""+de.getCelular());
		txtEspecialidadDocente.setText(""+de.getEspecialidad());
		txtFiDocente.setText(""+de.getFechaIngreso());
		
		listaCurso = gestionDocente.cursosDocente(Integer.parseInt(txtBuscarDocente.getText()));
		for (int i = 0; i < listaCurso.size(); i++) {
			CursoEntity entity = listaCurso.get(i);
			String idCurso= Integer.toString(entity.getCurId());
			String nombre =  entity.getCurNombre();
			String ciclo = Integer.toString(entity.getCurCiclo());
			String creditos = Integer.toString(entity.getCurCreditos());
			String horas = Integer.toString(entity.getCurHoras());

			
			Object datos[] = {idCurso,nombre,ciclo,creditos,horas};
			modelo.addRow(datos);
			
		}
   	}	

	public void keyPressed(KeyEvent e) {

	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tableCursos) {
			keyReleasedTableCursos(e);
		}
	}
	public void keyTyped(KeyEvent e) {

		if (e.getSource() == txtBuscarDocente) {
			keyTypedTxtBuscarDocente(e);
		}
	}
	protected void keyReleasedTableCursos(KeyEvent e) {
	}

	//VALIDACIÓN DE ESCRITURA
	protected void keyTypedTxtBuscarDocente(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}

}
