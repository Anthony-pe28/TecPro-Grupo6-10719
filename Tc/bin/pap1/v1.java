package pap1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class v1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPrec;
	private JTextField txtCant;
	private JScrollPane scrollPane;
	private JTextArea txts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v1 frame = new v1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public v1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prenda: ");
		lblNewLabel.setBounds(279, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Talla:");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio:");
		lblNewLabel_2.setBounds(10, 58, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad:");
		lblNewLabel_3.setBounds(279, 58, 57, 14);
		contentPane.add(lblNewLabel_3);
		
		txtPrec = new JTextField();
		txtPrec.setBounds(66, 55, 83, 20);
		contentPane.add(txtPrec);
		txtPrec.setColumns(10);
		
		txtCant = new JTextField();
		txtCant.setBounds(354, 55, 86, 20);
		contentPane.add(txtCant);
		txtCant.setColumns(10);
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(10, 83, 89, 23);
				
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clase cl = m.buscar(cboxtall.getSelectedItem().toString(), cboxRop.getSelectedItem().toString());
				if (cl != null) {
					cl.setCant(cl.getCant()+Integer.parseInt(txtCant.getText()));
					txtCant.setText("");
					txtPrec.setText("");
				} else {
					m.adicionar(new clase(LeerTalla(), LeerCant(), LeerPrec(), LeerRopa()));					
					txtCant.setText("");
					txtPrec.setText("");
				}
			}	
		});
		contentPane.add(btnAdicionar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 430, 164);
		contentPane.add(scrollPane);
		
		txts = new JTextArea();
		scrollPane.setViewportView(txts);
		
		cboxtall = new JComboBox<String>();
		cboxtall.setModel(new DefaultComboBoxModel<String>(new String[] {"XS", "S", "M", "L", "XL"}));
		cboxtall.setToolTipText("");
		cboxtall.setBounds(66, 7, 83, 22);
		contentPane.add(cboxtall);
		
		cboxRop = new JComboBox<String>();
		cboxRop.setModel(new DefaultComboBoxModel<String>(new String[] {"Polera", "Camisa", "Polo", "Pantalones", "Shorts"}));
		cboxRop.setToolTipText("");
		cboxRop.setBounds(357, 7, 83, 22);
		contentPane.add(cboxRop);
		
		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(121, 83, 89, 23);
		contentPane.add(btnReportar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(236, 83, 89, 23);
		contentPane.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(351, 83, 89, 23);
		contentPane.add(btnBuscar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnReportar) {
			do_btnReportar_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
	}
	
	metodos m = new metodos();
	private JComboBox<String> cboxtall;
	private JComboBox<String> cboxRop;
	private JButton btnReportar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	
	void Listado () {
		txts.setText("");
		txts.append("Talla\tPrenda\tCantidad\tPrecio");
		for (int i = 0; i < m.cant(); i++) {
			txts.append("\n" + m.obtener(i).getTalla() + "\t" + m.obtener(i).getRopa() + "\t"+ m.obtener(i).getCant() + "\t" + m.obtener(i).getPrecio());
		}
	}
	
	String LeerTalla () {
		return cboxtall.getSelectedItem().toString();
	}
	int LeerCant () {
		return Integer.parseInt(txtCant.getText());
	}
	double LeerPrec () {
		return Double.parseDouble(txtPrec.getText());
	}
	String LeerRopa () {
		return cboxRop.getSelectedItem().toString();
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		clase cl = m.buscar(cboxtall.getSelectedItem().toString(), cboxRop.getSelectedItem().toString());
		if (cl != null) {
			JOptionPane.showMessageDialog(this,"Talla: "+cl.getTalla()+" - Prenda: "+cl.getRopa()+" - Cantidad: "+cl.getCant()+" - Precio: "+cl.getPrecio());
		} else {
			JOptionPane.showMessageDialog(this, "Datos no encontrados");
		}
	}
	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		Listado();
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		m.Eliminar(cboxtall.getSelectedItem().toString(),cboxRop.getSelectedItem().toString());
	}
}
