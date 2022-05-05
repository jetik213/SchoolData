package gui_principales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Label;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import entidades.AlumnoEntity;
import entidades.CursoEntity;
import gestion.GestionAlumno;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PanelConsultaAlumnos extends JPanel implements MouseListener, ActionListener, KeyListener {
	private JPanel paneCursos;
	private JTextField txtBuscarAlumno;
	private JPanel paneBtnBuscar;
	private JLabel lblBtnBuscar;
	private JLabel lblCursos;
	private JPanel paneHeader;
	private JLabel lblFondo;
	private JPanel paneHeaderCursos;
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
	private JLabel lblEstadoAlumnoTitle;
	private JTextField txtCodigoAlumno;
	private JTextField txtNombresAlumno;
	private JTextField txtApPaternoAlumno;
	private JTextField txtApMaternoAlumno;
	private JTextField txtDniAlumno;
	private JTextField txtEdadAlumno;
	private JTextField txtCelularAlumno;
	private JTextField txtEstadoAlumno;
	private JScrollPane scrollPane;
	private JTable tableCursos;
	private JLabel lblIcoBusqueda;

	
	/*--------------------------------*/
	/*------M O D I F I C A R--------*/
	/*------------------------------*/
	//Variables globales
	ArrayList<AlumnoEntity> listaAlumno = new ArrayList<AlumnoEntity>();
	ArrayList<CursoEntity> listaCurso = new ArrayList<CursoEntity>();
	DefaultTableModel modelo = new DefaultTableModel();
	//Tener cuidado al borrar métodos privados
	/**
	 * Create the panel.
	 */
	public PanelConsultaAlumnos() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0,0,865,583);
		setLayout(null);
		
		paneHeader = new JPanel();
		paneHeader.setBackground(Color.WHITE);
		paneHeader.setBounds(0, 0, 865, 70);
		add(paneHeader);
		paneHeader.setLayout(null);
		
		txtBuscarAlumno = new JTextField();
		txtBuscarAlumno.addKeyListener(this);
		txtBuscarAlumno.setToolTipText("Escriba el c\u00F3digo del Alumno, \u00A1solo n\u00FAmeros!");
		txtBuscarAlumno.setBounds(10, 20, 660, 30);
		paneHeader.add(txtBuscarAlumno);
		txtBuscarAlumno.addMouseListener(this);
		txtBuscarAlumno.setForeground(Color.LIGHT_GRAY);
		txtBuscarAlumno.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 61, 105)));
		txtBuscarAlumno.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtBuscarAlumno.setText("Ingrese el c\u00F3digo del Alumno...");
		txtBuscarAlumno.setColumns(10);
		
		paneBtnBuscar = new JPanel();
		paneBtnBuscar.setBounds(705, 20, 150, 30);
		paneHeader.add(paneBtnBuscar);
		paneBtnBuscar.addMouseListener(this);
		paneBtnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		paneBtnBuscar.setLayout(null);
		paneBtnBuscar.setBackground(new Color(0, 61, 105));
		
		lblBtnBuscar = new JLabel("BUSCAR");
		lblBtnBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnBuscar.setForeground(Color.WHITE);
		lblBtnBuscar.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBtnBuscar.setBounds(0, 0, 150, 30);
		paneBtnBuscar.add(lblBtnBuscar);
		
		lblIcoBusqueda = new JLabel("");
		lblIcoBusqueda.setIcon(new ImageIcon(PanelConsultaAlumnos.class.getResource("/images/ico_busqueda-White.png")));
		lblIcoBusqueda.setBounds(10, 3, 24, 24);
		paneBtnBuscar.add(lblIcoBusqueda);
		
		paneCursos = new JPanel();
		paneCursos.setBackground(Color.WHITE);
		paneCursos.setBounds(0, 80, 569, 503);
		add(paneCursos);
		paneCursos.setLayout(null);
		
		paneHeaderCursos = new JPanel();
		paneHeaderCursos.setBackground(new Color(0, 61, 105));
		paneHeaderCursos.setBounds(0, 0, 569, 30);
		paneCursos.add(paneHeaderCursos);
		paneHeaderCursos.setLayout(null);
		
		lblCursos = new JLabel("CURSOS MATRICULADOS");
		lblCursos.setBounds(0, 0, 569, 30);
		paneHeaderCursos.add(lblCursos);
		lblCursos.setForeground(Color.WHITE);
		lblCursos.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCursos.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PanelConsultaAlumnos.class.getResource("/images/fondo_objeto.png")));
		lblFondo.setBounds(0, 0, 569, 503);
		paneCursos.add(lblFondo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 40, 549, 364);
		paneCursos.add(scrollPane);
		
		tableCursos = new JTable();
		tableCursos.addMouseListener(this);
		tableCursos.addKeyListener(this);
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
		
		/*--------------------------------*/
		/*------M O D I F I C A R--------*/
		/*------------------------------*/
		tableCursos.setModel(modelo);
		modelo.addColumn("Código");
		modelo.addColumn("Curso");
		modelo.addColumn("Ciclo");
		modelo.addColumn("Créditos");
		modelo.addColumn("Horas");
		//HASTA ACÁ
		
		paneAlumno = new JPanel();
		paneAlumno.setLayout(null);
		paneAlumno.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		paneAlumno.setBackground(new Color(0, 61, 105));
		paneAlumno.setBounds(579, 80, 286, 503);
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
		
		lblEstadoAlumnoTitle = new JLabel("Estado:");
		lblEstadoAlumnoTitle.setForeground(Color.WHITE);
		lblEstadoAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEstadoAlumnoTitle.setBounds(20, 418, 236, 20);
		paneAlumno.add(lblEstadoAlumnoTitle);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.addKeyListener(this);
		txtCodigoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoAlumno.setForeground(Color.DARK_GRAY);
		txtCodigoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCodigoAlumno.setEditable(false);
		txtCodigoAlumno.setColumns(10);
		txtCodigoAlumno.setBounds(30, 81, 105, 20);
		paneAlumno.add(txtCodigoAlumno);
		
		txtNombresAlumno = new JTextField();
		txtNombresAlumno.addKeyListener(this);
		txtNombresAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombresAlumno.setForeground(Color.DARK_GRAY);
		txtNombresAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtNombresAlumno.setEditable(false);
		txtNombresAlumno.setColumns(10);
		txtNombresAlumno.setBounds(30, 140, 226, 20);
		paneAlumno.add(txtNombresAlumno);
		
		txtApPaternoAlumno = new JTextField();
		txtApPaternoAlumno.addKeyListener(this);
		txtApPaternoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtApPaternoAlumno.setForeground(Color.DARK_GRAY);
		txtApPaternoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApPaternoAlumno.setEditable(false);
		txtApPaternoAlumno.setColumns(10);
		txtApPaternoAlumno.setBounds(30, 208, 226, 20);
		paneAlumno.add(txtApPaternoAlumno);
		
		txtApMaternoAlumno = new JTextField();
		txtApMaternoAlumno.addKeyListener(this);
		txtApMaternoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtApMaternoAlumno.setForeground(Color.DARK_GRAY);
		txtApMaternoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtApMaternoAlumno.setEditable(false);
		txtApMaternoAlumno.setColumns(10);
		txtApMaternoAlumno.setBounds(30, 268, 226, 20);
		paneAlumno.add(txtApMaternoAlumno);
		
		txtDniAlumno = new JTextField();
		txtDniAlumno.addKeyListener(this);
		txtDniAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtDniAlumno.setForeground(Color.DARK_GRAY);
		txtDniAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtDniAlumno.setEditable(false);
		txtDniAlumno.setColumns(10);
		txtDniAlumno.setBounds(151, 80, 105, 20);
		paneAlumno.add(txtDniAlumno);
		
		txtEdadAlumno = new JTextField();
		txtEdadAlumno.addKeyListener(this);
		txtEdadAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdadAlumno.setForeground(Color.DARK_GRAY);
		txtEdadAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtEdadAlumno.setEditable(false);
		txtEdadAlumno.setColumns(10);
		txtEdadAlumno.setBounds(30, 328, 226, 20);
		paneAlumno.add(txtEdadAlumno);
		
		txtCelularAlumno = new JTextField();
		txtCelularAlumno.addKeyListener(this);
		txtCelularAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelularAlumno.setForeground(Color.DARK_GRAY);
		txtCelularAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtCelularAlumno.setEditable(false);
		txtCelularAlumno.setColumns(10);
		txtCelularAlumno.setBounds(30, 388, 226, 20);
		paneAlumno.add(txtCelularAlumno);
		
		txtEstadoAlumno = new JTextField();
		txtEstadoAlumno.addKeyListener(this);
		txtEstadoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadoAlumno.setForeground(Color.DARK_GRAY);
		txtEstadoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		txtEstadoAlumno.setEditable(false);
		txtEstadoAlumno.setColumns(10);
		txtEstadoAlumno.setBounds(30, 448, 226, 20);
		paneAlumno.add(txtEstadoAlumno);
		
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableCursos) {
			mouseClickedTableCursos(e);
		}
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
		if (e.getSource() == txtBuscarAlumno) {
			mousePressedTxtCodigo(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
	}
	
	protected void mouseClickedPaneBtnBuscar(MouseEvent e) {
		//CODIGO BOTÓN BUSCAR
		try {
			limpieza();
			listar();
		}catch(Exception exc) {
			mensaje("Coloca un código de alumno valido");
		}
		
		
	}
	protected void mouseEnteredPaneBtnBuscar(MouseEvent e) {
		paneBtnBuscar.setBackground(new Color(44, 110, 145));
	}
	protected void mouseExitedPaneBtnBuscar(MouseEvent e) {
		paneBtnBuscar.setBackground(new Color(0, 61, 105));
	}
	
	protected void mousePressedTxtCodigo(MouseEvent e) {
		txtBuscarAlumno.setForeground(Color.DARK_GRAY);
		txtBuscarAlumno.setText("");
	}
	public void actionPerformed(ActionEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tableCursos) {
			keyReleasedTableCursos(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtBuscarAlumno) {
			keyTypedTxtBuscarAlumno(e);
		}
	}
	protected void keyReleasedTableCursos(KeyEvent e) {
	}
	protected void mouseClickedTableCursos(MouseEvent e) {
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
		txtNombresAlumno.setText("");
		txtApPaternoAlumno.setText("");
		txtApMaternoAlumno.setText("");
		txtDniAlumno.setText("");
		txtEdadAlumno.setText("");
		txtCelularAlumno.setText("");
		txtEstadoAlumno.setText("");
		
		/*--------------------------------*/
		/*--------A G R E G A R----------*/
		/*------------------------------*/
		modelo.setRowCount(0);
	}
	
	/*--------------------------------*/
	/*------M O D I F I C A R--------*/
	/*------------------------------*/
	//Método para listar
   	void listar() {
		GestionAlumno gestionAlumno = new GestionAlumno();
		listaAlumno = gestionAlumno.buscarAlumnos(Integer.parseInt(txtBuscarAlumno.getText()));
		
		AlumnoEntity ae = listaAlumno.get(0);

		txtCodigoAlumno.setText(ae.getId()+"");
		txtNombresAlumno.setText(ae.getNombres());
		txtApPaternoAlumno.setText(ae.getApellidoPaterno());
		txtApMaternoAlumno.setText(ae.getApellidoMaterno());
		txtDniAlumno.setText(ae.getDni());
		txtEdadAlumno.setText(ae.getEdad()+"");
		txtCelularAlumno.setText(ae.getCelular());
		txtEstadoAlumno.setText(ae.getEstado()+"");
		
		listaCurso = gestionAlumno.cursosAlumnoMatriculado(Integer.parseInt(txtBuscarAlumno.getText()));
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

   	//VALIDACIONES DE ESCRITURAS

	protected void keyTypedTxtBuscarAlumno(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
}
