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
import javax.swing.table.DefaultTableModel;

import entidades.CursoEntity;
import entidades.DocenteEntity;
import gestion.GestionCurso;

import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PanelConsultaCursos extends JPanel implements MouseListener, KeyListener {
	private JPanel paneHeader;
	private JTextField txtBuscar;
	private JPanel paneBtnBuscar;
	private JLabel lblBtnBuscar;
	private JPanel paneAlumno;
	private JLabel lblCodigoCursoTitle;
	private JLabel lblCodigoCurso;
	private JLabel lblAsignaturaCursoTitle;
	private JLabel lblAsignatura;
	private JLabel lblCicloCursoTitle;
	private JLabel lblCicloCurso;
	private JLabel lblNoCreditosCursoTitle;
	private JLabel lblNoCreditosCurso;
	private JLabel lblCantHorasCursoTitle;
	private JLabel lblCantHorasCurso;
	private JSeparator separator;
	private JPanel paneHeaderCurso;
	private JLabel lblCurso;
	private JLabel lblFondo;
	private JPanel paneDocente;
	private JLabel lblCodigoDocenteTitle;
	private JLabel lblNombreDocenteTitle;
	private JLabel lblApPaternoDocenteTitle;
	private JLabel lblApMaternoDocenteTitle;
	private JLabel lblDniDocenteTitle;
	private JLabel lblCelularDocenteTitle;
	private JPanel paneHeaderDocente;
	private JLabel lblDocente;
	private JTextField txtCodigoDocente;
	private JTextField txtNombreDocente;
	private JTextField txtApPaternoDocente;
	private JTextField txtApMaternoDocente;
	private JTextField txtDniDocente;
	private JTextField txtCelularDocente;
	private JLabel lblEspecialidadDocenteTitle;
	private JTextField txtEspecialidadDocente;
	private JLabel lblFiDocenteTitle;
	private JTextField txtFiDocente;
	private JLabel lblIcoBusqueda;
	
	//Variables globales
	ArrayList<CursoEntity> listaCurso = new ArrayList<CursoEntity>();
	ArrayList<DocenteEntity> listaDocente = new ArrayList<DocenteEntity>();
	/**
	 * Create the panel.
	 */
	public PanelConsultaCursos() {
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
		txtBuscar.setToolTipText("Escriba el c\u00F3digo del Curso \u00A1Solo n\u00FAmeros!");
		txtBuscar.addMouseListener(this);
		txtBuscar.setText("Ingrese el c\u00F3digo del Curso...");
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
		lblIcoBusqueda.setIcon(new ImageIcon(PanelConsultaCursos.class.getResource("/images/ico_busqueda-White.png")));
		lblIcoBusqueda.setBounds(10, 3, 24, 24);
		paneBtnBuscar.add(lblIcoBusqueda);
		
		paneAlumno = new JPanel();
		paneAlumno.setLayout(null);
		paneAlumno.setBackground(Color.WHITE);
		paneAlumno.setBounds(0, 80, 569, 503);
		add(paneAlumno);
		
		lblCodigoCursoTitle = new JLabel("C\u00F3digo:");
		lblCodigoCursoTitle.setForeground(Color.DARK_GRAY);
		lblCodigoCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodigoCursoTitle.setBounds(20, 90, 150, 20);
		paneAlumno.add(lblCodigoCursoTitle);
		
		lblCodigoCurso = new JLabel("");
		lblCodigoCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoCurso.setForeground(Color.DARK_GRAY);
		lblCodigoCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblCodigoCurso.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblCodigoCurso.setBounds(30, 120, 220, 20);
		paneAlumno.add(lblCodigoCurso);
		
		lblAsignaturaCursoTitle = new JLabel("Asignatura:");
		lblAsignaturaCursoTitle.setForeground(Color.DARK_GRAY);
		lblAsignaturaCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAsignaturaCursoTitle.setBounds(20, 170, 150, 20);
		paneAlumno.add(lblAsignaturaCursoTitle);
		
		lblAsignatura = new JLabel("");
		lblAsignatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsignatura.setForeground(Color.DARK_GRAY);
		lblAsignatura.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblAsignatura.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblAsignatura.setBounds(30, 200, 220, 20);
		paneAlumno.add(lblAsignatura);
		
		lblCicloCursoTitle = new JLabel("Ciclo:");
		lblCicloCursoTitle.setForeground(Color.DARK_GRAY);
		lblCicloCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCicloCursoTitle.setBounds(20, 250, 150, 20);
		paneAlumno.add(lblCicloCursoTitle);
		
		lblCicloCurso = new JLabel("");
		lblCicloCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCicloCurso.setForeground(Color.DARK_GRAY);
		lblCicloCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblCicloCurso.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblCicloCurso.setBounds(30, 280, 220, 20);
		paneAlumno.add(lblCicloCurso);
		
		lblNoCreditosCursoTitle = new JLabel("N\u00B0 de Cr\u00E9ditos:");
		lblNoCreditosCursoTitle.setForeground(Color.DARK_GRAY);
		lblNoCreditosCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNoCreditosCursoTitle.setBounds(20, 330, 150, 20);
		paneAlumno.add(lblNoCreditosCursoTitle);
		
		lblNoCreditosCurso = new JLabel("");
		lblNoCreditosCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoCreditosCurso.setForeground(Color.DARK_GRAY);
		lblNoCreditosCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblNoCreditosCurso.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblNoCreditosCurso.setBounds(30, 360, 220, 20);
		paneAlumno.add(lblNoCreditosCurso);
		
		lblCantHorasCursoTitle = new JLabel("Cantidad de Horas:");
		lblCantHorasCursoTitle.setForeground(Color.DARK_GRAY);
		lblCantHorasCursoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCantHorasCursoTitle.setBounds(310, 90, 230, 20);
		paneAlumno.add(lblCantHorasCursoTitle);
		
		lblCantHorasCurso = new JLabel("");
		lblCantHorasCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantHorasCurso.setForeground(Color.DARK_GRAY);
		lblCantHorasCurso.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblCantHorasCurso.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblCantHorasCurso.setBounds(320, 120, 220, 20);
		paneAlumno.add(lblCantHorasCurso);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(0, 128, 0));
		separator.setBackground(new Color(0, 128, 0));
		separator.setBounds(285, 85, 2, 305);
		paneAlumno.add(separator);
		
		paneHeaderCurso = new JPanel();
		paneHeaderCurso.setLayout(null);
		paneHeaderCurso.setBackground(new Color(0, 61, 105));
		paneHeaderCurso.setBounds(0, 0, 569, 30);
		paneAlumno.add(paneHeaderCurso);
		
		lblCurso = new JLabel("DATOS DEL CURSO");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCurso.setBounds(0, 0, 569, 30);
		paneHeaderCurso.add(lblCurso);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PanelConsultaCursos.class.getResource("/images/fondo_objeto.png")));
		lblFondo.setBounds(0, 0, 569, 503);
		paneAlumno.add(lblFondo);
		
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
		txtCodigoDocente.addKeyListener(this);
		txtCodigoDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoDocente.setForeground(Color.DARK_GRAY);
		txtCodigoDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCodigoDocente.setEditable(false);
		txtCodigoDocente.setColumns(10);
		txtCodigoDocente.setBounds(30, 81, 105, 20);
		paneDocente.add(txtCodigoDocente);
		
		txtNombreDocente = new JTextField();
		txtNombreDocente.addKeyListener(this);
		txtNombreDocente.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreDocente.setForeground(Color.DARK_GRAY);
		txtNombreDocente.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtNombreDocente.setEditable(false);
		txtNombreDocente.setColumns(10);
		txtNombreDocente.setBounds(30, 140, 226, 20);
		paneDocente.add(txtNombreDocente);
		
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
			mensaje("El código del curso ingresado no se encuentra registrado");
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
		txtNombreDocente.setText("");
		txtApPaternoDocente.setText("");
		txtApMaternoDocente.setText("");
		txtDniDocente.setText("");
		txtCelularDocente.setText("");
		txtEspecialidadDocente.setText("");
		txtFiDocente.setText("");

		lblCodigoCurso.setText("");
		lblAsignatura.setText("");
		lblCicloCurso.setText("");
		lblNoCreditosCurso.setText("");
		lblCantHorasCurso.setText("");
	}
	
	//Método para listar el el JTable
   	void listar() {
   		if(!txtBuscar.getText().trim().isEmpty()) {
   			int codCurso = Integer.parseInt(txtBuscar.getText());
   			GestionCurso gestionCurso = new GestionCurso();
   			
   		   	//------------------------------------------------------------------//	
   			//			Llenar datos de cursos
   	   		//------------------------------------------------------------------//
   	   		listaCurso = gestionCurso.buscarCursos(codCurso);
   	   		CursoEntity ce = listaCurso.get(0);
   			lblCodigoCurso.setText(""+ce.getCurId());
   			lblAsignatura.setText(""+ce.getCurNombre());
   			lblCicloCurso.setText(""+ce.getCurCiclo());
   			lblNoCreditosCurso.setText(""+ce.getCurCreditos());
   			lblCantHorasCurso.setText(""+ce.getCurHoras());
   			
	   		//------------------------------------------------------------------//
   			// 				Llenar datos de docente
	   		//------------------------------------------------------------------//
   			listaDocente = gestionCurso.docenteCurso(codCurso);
   			DocenteEntity de = listaDocente.get(0);
	   		txtCodigoDocente.setText(""+de.getId());
   			txtNombreDocente.setText(""+de.getNombres());
   			txtApPaternoDocente.setText(""+de.getApellidoPaterno());
   			txtApMaternoDocente.setText(""+de.getApellidoMaterno());
   			txtDniDocente.setText(""+de.getDni());
   			txtCelularDocente.setText(""+de.getCelular());
   			txtEspecialidadDocente.setText(""+de.getEspecialidad());
   			txtFiDocente.setText(""+de.getFechaIngreso());
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
