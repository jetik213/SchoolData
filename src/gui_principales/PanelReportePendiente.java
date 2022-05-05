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
import gestion.GestionAlumno;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReportes;
import util.ReporteRepositorio;

import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelReportePendiente extends JPanel implements MouseListener, KeyListener, ActionListener {
	private JPanel paneAlumnos;
	
	
	//Variables Globales
	TableRowSorter<DefaultTableModel> sorter;
	boolean showDataTable = true;	
	
	//añadir
	public String pb_estado_re;
	private JButton btnReporte;
	private JPanel panelReporte;
	/**
	 * Create the panel.
	 */
	public PanelReportePendiente() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0,0,865,583);
		setLayout(null);
		
		paneAlumnos = new JPanel();
		paneAlumnos.setLayout(null);
		paneAlumnos.setBackground(Color.WHITE);
		paneAlumnos.setBounds(0, 0, 865, 583);
		add(paneAlumnos);
		
		btnReporte = new JButton("GENERAR REPORTE");
		btnReporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReporte.setForeground(Color.WHITE);
		btnReporte.addActionListener(this);
		btnReporte.setBackground(new Color(0, 61, 105));
		btnReporte.setBounds(10, 10, 200, 30);
		paneAlumnos.add(btnReporte);
		
		panelReporte = new JPanel();
		panelReporte.setBackground(Color.WHITE);
		panelReporte.setBounds(0, 51, 865, 532);
		paneAlumnos.add(panelReporte);
		
	}
	


	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
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

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}

	}

	protected void actionPerformedBtnReporte(ActionEvent e) {
		
		GestionAlumno gestionUsuario = new GestionAlumno();
		List<AlumnoEntity> listUsuarios = gestionUsuario.listarAlumnosMatriculaPendiente();
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listUsuarios); //se convierte la lista a una lista del JR
		
		String file = ReporteRepositorio.REPORTE_MATRICULA_PENDIENTE;
		
		JasperPrint jasperPrint = GeneradorReportes.generarReporte(file, dataSource, null);
		
		JRViewer jrViewer = new JRViewer(jasperPrint);
		
		jrViewer.setPreferredSize(panelReporte.getSize());
				
		panelReporte.removeAll();
		panelReporte.add(jrViewer);
		panelReporte.repaint();
		panelReporte.revalidate();
	}
}
