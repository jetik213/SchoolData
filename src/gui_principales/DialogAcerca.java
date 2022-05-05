package gui_principales;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class DialogAcerca extends JDialog implements MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblTitulo;
	private JLabel lblDesarrolladoPor;
	private JLabel lblIntegrante1;
	private JLabel lblIntegrante2;
	private JLabel lblIntegrante3;
	private JLabel lblIntegrante4;
	private JLabel lblProfesor;
	private JLabel lblLugar;
	private JPanel panelBtnCerrar;
	private JLabel lblCerrar;
	private JLabel lblCuadro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogAcerca dialog = new DialogAcerca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogAcerca() {
		setUndecorated(true);
		setVisible(true);
		setBounds(100, 100, 430, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 33, 51));
		contentPanel.setForeground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblTitulo = new JLabel("PROYECTO DE LENGUAJE DE PROGRAMACI\u00D3N");
		lblTitulo.setBorder(new LineBorder(Color.WHITE));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(10, 24, 396, 24);
		contentPanel.add(lblTitulo);
		
		lblDesarrolladoPor = new JLabel("DESARROLLADO POR:");
		lblDesarrolladoPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesarrolladoPor.setForeground(Color.WHITE);
		lblDesarrolladoPor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDesarrolladoPor.setBounds(10, 65, 396, 13);
		contentPanel.add(lblDesarrolladoPor);
		
		lblIntegrante1 = new JLabel("CASTILLO VILLACORTA, LUIS EDUARDO");
		lblIntegrante1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrante1.setForeground(Color.WHITE);
		lblIntegrante1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntegrante1.setBounds(10, 108, 396, 13);
		contentPanel.add(lblIntegrante1);
		
		lblIntegrante2 = new JLabel("DE LA CRUZ ANAZGO, ORLANDO MARTIN");
		lblIntegrante2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrante2.setForeground(Color.WHITE);
		lblIntegrante2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntegrante2.setBounds(10, 131, 396, 13);
		contentPanel.add(lblIntegrante2);
		
		lblIntegrante3 = new JLabel("JUAREZ MONTERO, LUIS ENRIQUE");
		lblIntegrante3.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrante3.setForeground(Color.WHITE);
		lblIntegrante3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntegrante3.setBounds(10, 154, 396, 13);
		contentPanel.add(lblIntegrante3);
		
		lblIntegrante4 = new JLabel("TINEO KAM, JEFFREY");
		lblIntegrante4.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntegrante4.setForeground(Color.WHITE);
		lblIntegrante4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIntegrante4.setBounds(10, 177, 396, 13);
		contentPanel.add(lblIntegrante4);
		
		lblProfesor = new JLabel("DOCENTE: VENTURA GONZALES, JORGE ENRIQUE");
		lblProfesor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfesor.setForeground(Color.WHITE);
		lblProfesor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProfesor.setBounds(10, 217, 396, 13);
		contentPanel.add(lblProfesor);
		
		lblLugar = new JLabel("LIMA - PER\u00DA 2022 \u00A9");
		lblLugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblLugar.setForeground(Color.WHITE);
		lblLugar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLugar.setBounds(10, 268, 396, 13);
		contentPanel.add(lblLugar);
		
		panelBtnCerrar = new JPanel();
		panelBtnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBtnCerrar.addMouseListener(this);
		panelBtnCerrar.setBackground(new Color(0, 61, 105));
		panelBtnCerrar.setBounds(138, 330, 146, 40);
		contentPanel.add(panelBtnCerrar);
		panelBtnCerrar.setLayout(null);
		
		lblCerrar = new JLabel("CERRAR");
		lblCerrar.setFont(new Font("Verdana", Font.BOLD, 16));
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setForeground(Color.WHITE);
		lblCerrar.setBounds(0, 0, 146, 40);
		panelBtnCerrar.add(lblCerrar);
		
		lblCuadro = new JLabel("");
		lblCuadro.setBorder(new LineBorder(Color.WHITE));
		lblCuadro.setBounds(34, 95, 346, 201);
		contentPanel.add(lblCuadro);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == panelBtnCerrar) {
			mouseClickedPanelBtnOk(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == panelBtnCerrar) {
			mouseEnteredPanelBtnOk(e);
		}
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == panelBtnCerrar) {
			mouseExitedPanelBtnOk(e);
		}
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedPanelBtnOk(MouseEvent e) {
		dispose();
	}
	protected void mouseEnteredPanelBtnOk(MouseEvent e) {
		panelBtnCerrar.setBackground(Color.WHITE);
		lblCerrar.setForeground(new Color(0, 61, 105));
	}
	protected void mouseExitedPanelBtnOk(MouseEvent e) {
		panelBtnCerrar.setBackground(new Color(0, 61, 105));
		lblCerrar.setForeground(Color.WHITE);
	}
}
