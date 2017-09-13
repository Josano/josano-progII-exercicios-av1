package br.estacio.tabuada;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ex01Frame extends JFrame {
	
	private JPanel painelTopo;
	private JPanel painelCentro;
	private JLabel labelTabuadoDo;
	private JLabel lbInicial;
	private JLabel lbFinal;
	private JButton buttonCalcular;
	private JTextField txtInicial;
	private JTextField txtFinal;
	private JTextField txtNumero;
	
	public Ex01Frame() {
		instanciarComponentes();
		configurarFrame();
		definirEventos();
		montarFrame();
	}

	/*
	 * Definindo os eventos dos Frames.
	 */
	private void definirEventos() {
		
		buttonCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCentro.removeAll();
				painelCentro.repaint();
								
				if(txtNumero.requestFocusInWindow())
				    validaNulos(txtNumero, "Tabuada");
				
				if(txtInicial.requestFocusInWindow())
				    validaNulos(txtInicial, "Inicial");
				
				if(txtFinal.requestFocusInWindow())
				    validaNulos(txtFinal, "Final");

				try {
					Integer.valueOf(txtNumero.getText());				
				} catch (NumberFormatException ex) {				
					JOptionPane.showMessageDialog(null, "Valor Tabuada deve ser numerico");	
					txtNumero.setText(null);
					txtNumero.grabFocus();
					return;
				}
				
				try {
					Integer.valueOf(txtInicial.getText());				
				} catch (NumberFormatException ex) {				
					JOptionPane.showMessageDialog(null, "Valor Inicial deve ser numerico.");		
					txtInicial.grabFocus();
					return;
				}
				
				try {
					Integer.valueOf(txtFinal.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Valor Final deve ser numerico");
					txtFinal.grabFocus();
					return;
				}
				
				if(Integer.valueOf(txtFinal.getText()) < Integer.valueOf(txtInicial.getText())) {
					JOptionPane.showMessageDialog(null, "Valor Inicial maior que final");
					return;
				}
				
				Ex01Class classe = new Ex01Class();
				List<String> ListaDeValores = classe.listarTabuada(txtNumero.getText(), txtInicial.getText(), txtFinal.getText());
				
				for(int i = 0; i < ListaDeValores.size(); i++) {
					JLabel labelNovo = new JLabel();
					labelNovo.setText(ListaDeValores.get(i));
					labelNovo.setHorizontalAlignment(SwingConstants.LEFT);
					painelCentro.add(labelNovo);	
				}
				painelCentro.revalidate();
			}
		});
	}

	/*
	 * Configurando o Frame
	 */
	private void configurarFrame() {
		
		this.setSize(600, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Tabuada");
		this.setLayout(new BorderLayout(5,5));
		this.getContentPane().add(painelTopo, BorderLayout.PAGE_START);
		this.getContentPane().add(painelCentro, BorderLayout.CENTER);
	}
	
	/*
	 * Instanciando os Elementos
	 */
	private void instanciarComponentes()  {
		
		painelTopo = new JPanel(new FlowLayout());
		painelTopo.setBackground(Color.LIGHT_GRAY);
		lbInicial = new JLabel("De: ");
		lbFinal = new JLabel("Até: ");
		labelTabuadoDo = new JLabel("Tabuada do: ");
		txtInicial = new JTextField(10);
		txtFinal = new JTextField(10);
		txtNumero = new JTextField(10);
		buttonCalcular = new JButton("Calcular");
		painelCentro = new JPanel(new FlowLayout());
	}
	
	/*
	 * Adicionando elementos
	 */
	private void montarFrame() {
		painelTopo.add(labelTabuadoDo);
		painelTopo.add(txtNumero);
		painelTopo.add(lbInicial);
		painelTopo.add(txtInicial);
		painelTopo.add(lbFinal);
		painelTopo.add(txtFinal);
		painelTopo.add(buttonCalcular);
	}	

	/*
	* Verifica valores nulos
	*/
	public void validaNulos( JTextField valor, String texto){
		try {
			if(valor.getText().length() < 1) {
				JOptionPane.showMessageDialog(null, "Valor " + texto + " nao preenchido");
				valor.grabFocus();
				return;
			}
		} catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Valor " + texto + " nao preenchido");
			return;
		}
	}
}
