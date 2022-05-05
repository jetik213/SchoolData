package gui_principales;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import entidades.CursoEntity;
import entidades.ReporteEntity;
import gestion.GestionCurso;
import gestion.GestionReporte;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReportes;
import util.ReporteRepositorio;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PanelReporteCurso extends JPanel implements ActionListener, MouseListener {
	private JPanel paneAlumnos;	
	private JPanel panelReporte;
	private JButton btnReporte;

	/**
	 * Create the panel.
	 */
	public PanelReporteCurso() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0,0,865,583);
		setLayout(null);
		
		paneAlumnos = new JPanel();
		paneAlumnos.setLayout(null);
		paneAlumnos.setBackground(Color.WHITE);
		paneAlumnos.setBounds(0, 0, 865, 583);
		add(paneAlumnos);
		
		panelReporte = new JPanel();
		panelReporte.setBackground(Color.WHITE);
		panelReporte.setBounds(0, 51, 865, 532);
		paneAlumnos.add(panelReporte);
		
		btnReporte = new JButton("GENERAR REPORTE");
		btnReporte.addActionListener(this);
		btnReporte.setForeground(Color.WHITE);
		btnReporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReporte.setBackground(new Color(0, 61, 105));
		btnReporte.setBounds(10, 10, 200, 30);
		paneAlumnos.add(btnReporte);
		
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	
	// Funciones Generales
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 1);
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
	protected void actionPerformedBtnReporte(ActionEvent e) {
		
		GestionReporte gestionReporte = new GestionReporte();
		List<ReporteEntity> listUsuarios = gestionReporte.listarCantidadMatriculaPorCurso();
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listUsuarios); //se convierte la lista a una lista del JR
		
		String file = ReporteRepositorio.REPORTE_CANTIDAD_MATRICULADOS;
		
		JasperPrint jasperPrint = GeneradorReportes.generarReporte(file, dataSource, null);
		
		JRViewer jrViewer = new JRViewer(jasperPrint);
		
		jrViewer.setPreferredSize(panelReporte.getSize());
				
		panelReporte.removeAll();
		panelReporte.add(jrViewer);
		panelReporte.repaint();
		panelReporte.revalidate();
		
	}
}
