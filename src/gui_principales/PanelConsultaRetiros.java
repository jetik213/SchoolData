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
import gestion.GestionRetiro;

import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class PanelConsultaRetiros extends JPanel implements MouseListener, KeyListener {
	private JPanel paneHeader;
	private JTextField txtBuscar;
	private JPanel paneBtnBuscar;
	private JLabel lblBtnBuscar;
	private JPanel paneAlumno;
	private JPanel paneHeaderAlumno;
	private JLabel lblAlumno;
	private JLabel lblCodigoAlumnoTitle;
	private JLabel lblCodigoAlumno;
	private JLabel lblNombreAlumnoTitle;
	private JLabel lblNombreAlumno;
	private JLabel lblApPaternoAlumnoTitle;
	private JLabel lblApPaternoAlumno;
	private JLabel lblApMaternoAlumnoTitle;
	private JLabel lblApMaternoAlumno;
	private JLabel lblDniAlumnoTitle;
	private JLabel lblDniAlumno;
	private JLabel lblEdadAlumnoTitle;
	private JLabel lblEdadAlumno;
	private JLabel lblCelularAlumnoTitle;
	private JLabel lblCelularAlumno;
	private JSeparator separator;
	private JLabel lblFondo;
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
	/**
	 * Create the panel.
	 */
	public PanelConsultaRetiros() {
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
		txtBuscar.setToolTipText("Escriba el c\u00F3digo de Retiro \u00A1Solo N\u00FAmeros!");
		txtBuscar.addMouseListener(this);
		txtBuscar.setText("Ingrese el c\u00F3digo de Retiro...");
		txtBuscar.setForeground(Color.LIGHT_GRAY);
		txtBuscar.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtBuscar.setColumns(10);
		txtBuscar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 61, 105)));
		txtBuscar.setBounds(10, 20, 660, 30);
		paneHeader.add(txtBuscar);
		
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
		lblIcoBusqueda.setIcon(new ImageIcon(PanelConsultaRetiros.class.getResource("/images/ico_busqueda-White.png")));
		lblIcoBusqueda.setBounds(10, 3, 24, 24);
		paneBtnBuscar.add(lblIcoBusqueda);
		
		paneAlumno = new JPanel();
		paneAlumno.setLayout(null);
		paneAlumno.setBackground(Color.WHITE);
		paneAlumno.setBounds(0, 80, 569, 503);
		add(paneAlumno);
		
		paneHeaderAlumno = new JPanel();
		paneHeaderAlumno.setLayout(null);
		paneHeaderAlumno.setBackground(new Color(0, 61, 105));
		paneHeaderAlumno.setBounds(0, 0, 569, 30);
		paneAlumno.add(paneHeaderAlumno);
		
		lblAlumno = new JLabel("DATOS DEL ALUMNO RETIRADO");
		lblAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno.setForeground(Color.WHITE);
		lblAlumno.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAlumno.setBounds(0, 0, 569, 30);
		paneHeaderAlumno.add(lblAlumno);
		
		lblCodigoAlumnoTitle = new JLabel("C\u00F3digo:");
		lblCodigoAlumnoTitle.setForeground(Color.DARK_GRAY);
		lblCodigoAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCodigoAlumnoTitle.setBounds(20, 90, 150, 20);
		paneAlumno.add(lblCodigoAlumnoTitle);
		
		lblCodigoAlumno = new JLabel("");
		lblCodigoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoAlumno.setForeground(Color.DARK_GRAY);
		lblCodigoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblCodigoAlumno.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblCodigoAlumno.setBounds(30, 120, 220, 20);
		paneAlumno.add(lblCodigoAlumno);
		
		lblNombreAlumnoTitle = new JLabel("Nombre(s):");
		lblNombreAlumnoTitle.setForeground(Color.DARK_GRAY);
		lblNombreAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombreAlumnoTitle.setBounds(20, 170, 150, 20);
		paneAlumno.add(lblNombreAlumnoTitle);
		
		lblNombreAlumno = new JLabel("");
		lblNombreAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreAlumno.setForeground(Color.DARK_GRAY);
		lblNombreAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblNombreAlumno.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblNombreAlumno.setBounds(30, 200, 220, 20);
		paneAlumno.add(lblNombreAlumno);
		
		lblApPaternoAlumnoTitle = new JLabel("Ap. Paterno:");
		lblApPaternoAlumnoTitle.setForeground(Color.DARK_GRAY);
		lblApPaternoAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApPaternoAlumnoTitle.setBounds(20, 250, 150, 20);
		paneAlumno.add(lblApPaternoAlumnoTitle);
		
		lblApPaternoAlumno = new JLabel("");
		lblApPaternoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblApPaternoAlumno.setForeground(Color.DARK_GRAY);
		lblApPaternoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblApPaternoAlumno.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblApPaternoAlumno.setBounds(30, 280, 220, 20);
		paneAlumno.add(lblApPaternoAlumno);
		
		lblApMaternoAlumnoTitle = new JLabel("Ap. Materno:");
		lblApMaternoAlumnoTitle.setForeground(Color.DARK_GRAY);
		lblApMaternoAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApMaternoAlumnoTitle.setBounds(20, 330, 150, 20);
		paneAlumno.add(lblApMaternoAlumnoTitle);
		
		lblApMaternoAlumno = new JLabel("");
		lblApMaternoAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblApMaternoAlumno.setForeground(Color.DARK_GRAY);
		lblApMaternoAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblApMaternoAlumno.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblApMaternoAlumno.setBounds(30, 360, 220, 20);
		paneAlumno.add(lblApMaternoAlumno);
		
		lblDniAlumnoTitle = new JLabel("DNI:");
		lblDniAlumnoTitle.setForeground(Color.DARK_GRAY);
		lblDniAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDniAlumnoTitle.setBounds(310, 90, 150, 20);
		paneAlumno.add(lblDniAlumnoTitle);
		
		lblDniAlumno = new JLabel("");
		lblDniAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblDniAlumno.setForeground(Color.DARK_GRAY);
		lblDniAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblDniAlumno.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblDniAlumno.setBounds(320, 120, 220, 20);
		paneAlumno.add(lblDniAlumno);
		
		lblEdadAlumnoTitle = new JLabel("Edad:");
		lblEdadAlumnoTitle.setForeground(Color.DARK_GRAY);
		lblEdadAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEdadAlumnoTitle.setBounds(310, 170, 150, 20);
		paneAlumno.add(lblEdadAlumnoTitle);
		
		lblEdadAlumno = new JLabel("");
		lblEdadAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdadAlumno.setForeground(Color.DARK_GRAY);
		lblEdadAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblEdadAlumno.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblEdadAlumno.setBounds(320, 200, 220, 20);
		paneAlumno.add(lblEdadAlumno);
		
		lblCelularAlumnoTitle = new JLabel("Celular:");
		lblCelularAlumnoTitle.setForeground(Color.DARK_GRAY);
		lblCelularAlumnoTitle.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCelularAlumnoTitle.setBounds(310, 250, 150, 20);
		paneAlumno.add(lblCelularAlumnoTitle);
		
		lblCelularAlumno = new JLabel("");
		lblCelularAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelularAlumno.setForeground(Color.DARK_GRAY);
		lblCelularAlumno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblCelularAlumno.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 61, 105)));
		lblCelularAlumno.setBounds(320, 280, 220, 20);
		paneAlumno.add(lblCelularAlumno);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(0, 128, 0));
		separator.setBackground(new Color(0, 128, 0));
		separator.setBounds(285, 85, 2, 305);
		paneAlumno.add(separator);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PanelConsultaRetiros.class.getResource("/images/fondo_objeto.png")));
		lblFondo.setBounds(0, 0, 569, 503);
		paneAlumno.add(lblFondo);
		
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
		
		lblCurso = new JLabel("CURSO RETIRADO");
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
			mensaje("El código ingresado no se encuentra Retirado");
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
		lblCodigoAlumno.setText("");
		lblNombreAlumno.setText("");
		lblApPaternoAlumno.setText("");
		lblApMaternoAlumno.setText("");
		lblDniAlumno.setText("");
		lblEdadAlumno.setText("");
		lblCelularAlumno.setText("");

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
   			GestionRetiro gestionRetiro = new GestionRetiro();
   			
 			//------------------------------------------------------------------//	
	   		//			Llenar datos del alumno
	   	   	//------------------------------------------------------------------//
   			listaAlumno = gestionRetiro.consultaAlumnoMatricula(codMatricula);   	   		
   	   		AlumnoEntity ae = listaAlumno.get(0);
  	   		lblCodigoAlumno.setText(""+ae.getId());
  	  		lblNombreAlumno.setText(""+ae.getNombres());
  	  		lblApPaternoAlumno.setText(""+ae.getApellidoPaterno());
  	  		lblApMaternoAlumno.setText(""+ae.getApellidoMaterno());
  	  		lblDniAlumno.setText(""+ae.getDni());
  	  		lblEdadAlumno.setText(""+ae.getEdad());
  	  		lblCelularAlumno.setText(""+ae.getCelular());
  	  		
   		   	//------------------------------------------------------------------//	
   			//			Llenar datos de cursos
   	   		//------------------------------------------------------------------//
   	   		listaCurso = gestionRetiro.consultaCursoMatricula(codMatricula);
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
	protected void keyTypedTxtBuscar(KeyEvent e) {
		char c = e.getKeyChar();
		if ( c < '0' || c > '9')
			e.consume();
	}
}
