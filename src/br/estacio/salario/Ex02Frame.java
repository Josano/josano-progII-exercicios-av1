package br.estacio.salario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex02Frame extends JFrame {

	private JPanel painelTopo;
	private JPanel painelCentro;
	private JPanel painelFundo;
	private JLabel lblSalarioBruto;
	private JTextField txtSalarioBruto;
	private JButton btnCalcular;
	private JCheckBox chkFormatar;
	private JLabel lblBaseInss;
	private JLabel lblDescInss;
	private JLabel lblBaseIrpf;
	private JLabel lblDescIrpf;
	private JTextField txtBaseInss;
	private JTextField txtDescInss;
	private JTextField txtBaseIrpf;
	private JTextField txtDescIrpf;
	private JLabel lblSalarioLiq;
	private JTextField txtSalarioLiq;

	public Ex02Frame() {
		iniciarElementos();
		configurarFrame();
		criarEvento();
		montarFrame();
	}

	/*
	 * Criando eventos
	 */
	private void criarEvento() {
		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CalcularCampos(chkFormatar.isSelected());
				
			}
		});
		
		chkFormatar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CalcularCampos(chkFormatar.isSelected());
			}
		});
			
	}
	
	private void CalcularCampos(Boolean formato) {
		Ex02Class calcular = new Ex02Class();
		double salarioBruto = Double.parseDouble(txtSalarioBruto.getText());
		double[] valoresCalculados = calcular.ValorCalculo(salarioBruto);
		
		txtBaseInss.setText(calcular.formataValor(valoresCalculados[0], formato));
		txtDescInss.setText(calcular.formataValor(valoresCalculados[1], formato));
		txtBaseIrpf.setText(calcular.formataValor(valoresCalculados[2], formato));
		txtDescIrpf.setText(calcular.formataValor(valoresCalculados[3], formato));
		txtSalarioLiq.setText(calcular.formataValor(valoresCalculados[4], formato));
		painelCentro.revalidate();		
	}		

	/*
	 * Montando Frame
	 */
	private void montarFrame() {
		painelTopo.add(lblSalarioBruto);
		painelTopo.add(txtSalarioBruto);
		painelTopo.add(btnCalcular);
		painelTopo.add(chkFormatar);
		painelCentro.add(lblBaseInss);
		painelCentro.add(txtBaseInss);
		painelCentro.add(lblDescInss);
		painelCentro.add(txtDescInss);
		painelCentro.add(lblBaseIrpf);
		painelCentro.add(txtBaseIrpf);
		painelCentro.add(lblDescIrpf);
		painelCentro.add(txtDescIrpf);
		painelFundo.add(lblSalarioLiq);
		painelFundo.add(txtSalarioLiq);
	}

	/**
	 * Iniciar Elementos
	 */
	private void iniciarElementos() {
		painelTopo = new JPanel(new FlowLayout());
		lblSalarioBruto = new JLabel("Salário Bruto:");
		txtSalarioBruto = new JTextField(10);
		btnCalcular = new JButton("Calcular");
		chkFormatar = new JCheckBox("Formatar");
		painelCentro = new JPanel(new GridLayout(4, 1));
		painelCentro = new JPanel(new GridLayout(4, 1));
		lblBaseInss = new JLabel("Base INSS");
		txtBaseInss = new JTextField();
		txtBaseInss.setEnabled(false);
		lblDescInss = new JLabel("Desconto INSS");
		txtDescInss = new JTextField(10);
		txtDescInss.setEnabled(false);
		lblBaseIrpf = new JLabel("Base IRPF");
		txtBaseIrpf = new JTextField(10);
		txtBaseIrpf.setEnabled(false);
		lblDescIrpf = new JLabel("Desconto IRPF");
		txtDescIrpf = new JTextField(10);
		txtDescIrpf.setEnabled(false);
		painelFundo = new JPanel(new FlowLayout());
		lblSalarioLiq = new JLabel("Salário Liquido:");
		txtSalarioLiq = new JTextField(10);
		txtSalarioLiq.setEnabled(false);
	}

	/*
	 * Configurando Frame
	 */
	private void configurarFrame() {
		this.setTitle("Calculador de salário");
		this.setSize(400, 180);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout(5, 5));

		this.add(painelTopo, BorderLayout.PAGE_START);
		this.add(painelCentro, BorderLayout.CENTER);
		this.add(painelFundo, BorderLayout.PAGE_END);
	}
}