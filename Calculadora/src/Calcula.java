import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.RenderingHints.Key;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import java.awt.Window.Type;


public class Calcula extends JFrame {

	private JPanel contentPane;
	private JTextField jtValor;
	private double numero1, numero2,resultado;
	private String operacao, ponto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Calcula frame = new Calcula();					
	}

	/**
	 * Create the frame.
	 */
	public Calcula() {
		setTitle("Calculadora");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\314124272\\Downloads\\Calculadora\\calculator_100870.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 219, 307);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jtValor = new JTextField();
		jtValor.setHorizontalAlignment(SwingConstants.RIGHT);
		jtValor.setFont(new Font("Tahoma", Font.BOLD, 20));
		jtValor.setForeground(Color.BLACK);
		jtValor.setBackground(Color.WHITE);
		jtValor.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent evento) {
				
				String caracteres="0123456789.";
				if(!caracteres.contains(evento.getKeyChar()+""))
				{
					evento.consume();
				}
				
				if(jtValor.getText().contains(".") && evento.getKeyChar()=='.')
				{
					evento.consume();
					
				}
				
			}
		});
		jtValor.addKeyListener(new java.awt.event.KeyAdapter() {
			  public void keyPressed(java.awt.event.KeyEvent evt) {
			    if (evt.getKeyCode() == KeyEvent.VK_ADD) {
			    	numero1=Double.parseDouble(jtValor.getText());
					operacao="+";
					jtValor.setText("");
			    
			    } else if (evt.getKeyCode() == KeyEvent.VK_SUBTRACT) {
			    	numero1=Double.parseDouble(jtValor.getText());
					operacao="\u2212";
					jtValor.setText("");
			    	
			    } else if (evt.getKeyCode() == KeyEvent.VK_MULTIPLY) {
			    	numero1=Double.parseDouble(jtValor.getText());
					operacao="X";
					jtValor.setText("");
			    	
			    } else if (evt.getKeyCode() == KeyEvent.VK_DIVIDE) {
			    	numero1=Double.parseDouble(jtValor.getText());
					operacao="/";
					jtValor.setText("");
			    	
			    } else if (evt.getKeyCode() == KeyEvent.VK_DECIMAL) {
			    	jtValor.setText(jtValor.getText()+".");
			    	
			    }
			    else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			    	try
					{
					
					numero2=Double.parseDouble(jtValor.getText());
					if(operacao.equals("+"))
					{
						resultado=numero1+numero2;
					}
					jtValor.setText(resultado+"");
					
				
					if(operacao.equals("\u2212"))
					{
						resultado=numero1-numero2;
					}
					jtValor.setText(resultado+"");
				
				
					if(operacao.equals("X"))
					{
						resultado=numero1*numero2;
					}
					jtValor.setText(resultado+"");
				
				
					if(operacao.equals("/"))
					{
						resultado=numero1/numero2;
					}
					jtValor.setText(resultado+"");
					
					}
					catch(Exception a)
					{
						jtValor.setText("");
					}
				
			     
			    	
			    }
			  }
			});
		jtValor.setBounds(1, 0, 201, 90);
		contentPane.add(jtValor);
		jtValor.setColumns(10);
		
		JButton jb1 = new JButton("1");
		jb1.setFocusPainted(false);
		jb1.setBackground(Color.CYAN);
		jb1.setForeground(Color.BLACK);
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtValor.setText(jtValor.getText()+"1");
			}
		});
		jb1.setBounds(1, 165, 51, 39);
		contentPane.add(jb1);
		
		JButton jb2 = new JButton("2");
		jb2.setFocusPainted(false);
		jb2.setForeground(Color.BLACK);
		jb2.setBackground(Color.CYAN);
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtValor.setText(jtValor.getText()+"2");
			}
		});
		jb2.setBounds(50, 165, 51, 39);
		contentPane.add(jb2);
		
		JButton jbmais = new JButton("+");
		jbmais.setFont(new Font("Tahoma", Font.BOLD, 11));
		jbmais.setFocusPainted(false);
		jbmais.setForeground(Color.BLACK);
		jbmais.setBackground(Color.CYAN);
		jbmais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				numero1=Double.parseDouble(jtValor.getText());
				operacao="+";
				jtValor.setText("");
			}
		});

		jbmais.setBounds(150, 203, 51, 39);
		contentPane.add(jbmais);
		
		JButton jbigual = new JButton("=");
		jbigual.setFocusPainted(false);
		jbigual.setBackground(new Color(0, 0, 204));
		jbigual.setForeground(new Color(255, 255, 255));
		jbigual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				
				numero2=Double.parseDouble(jtValor.getText());
				if(operacao.equals("+"))
				{
					resultado=numero1+numero2;
				}
				jtValor.setText(resultado+"");
				
			
				if(operacao.equals("\u2212"))
				{
					resultado=numero1-numero2;
				}
				jtValor.setText(resultado+"");
			
			
				if(operacao.equals("X"))
				{
					resultado=numero1*numero2;
				}
				jtValor.setText(resultado+"");
			
			
				if(operacao.equals("/"))
				{
					resultado=numero1/numero2;
				}
				jtValor.setText(resultado+"");
				
				}
				catch(Exception a)
				{
					jtValor.setText("");
				}
			}
		});
		jbigual.setBounds(100, 242, 101, 23);
		contentPane.add(jbigual);
		
		JButton jb3 = new JButton("3");
		jb3.setFocusPainted(false);
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtValor.setText(jtValor.getText()+"3");
			}
		});
		jb3.setForeground(Color.BLACK);
		jb3.setBackground(Color.CYAN);
		jb3.setBounds(100, 165, 51, 39);
		contentPane.add(jb3);
		
		JButton jb0 = new JButton("0");
		jb0.setFocusPainted(false);
		jb0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtValor.setText(jtValor.getText()+"0");
			}
		});
		jb0.setForeground(Color.BLACK);
		jb0.setBackground(Color.CYAN);
		jb0.setBounds(1, 203, 51, 39);
		contentPane.add(jb0);
		
		JButton jb4 = new JButton("4");
		jb4.setFocusPainted(false);
		jb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtValor.setText(jtValor.getText()+"4");
			}
		});
		jb4.setBackground(Color.CYAN);
		jb4.setForeground(Color.BLACK);
		jb4.setBounds(1, 127, 51, 39);
		contentPane.add(jb4);
		
		JButton jb5 = new JButton("5");
		jb5.setFocusPainted(false);
		jb5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtValor.setText(jtValor.getText()+"5");
			}
		});
		jb5.setBackground(Color.CYAN);
		jb5.setForeground(Color.BLACK);
		jb5.setBounds(50, 127, 51, 39);
		contentPane.add(jb5);
		
		JButton jb6 = new JButton("6");
		jb6.setFocusPainted(false);
		jb6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtValor.setText(jtValor.getText()+"6");
			}
		});
		jb6.setForeground(Color.BLACK);
		jb6.setBackground(Color.CYAN);
		jb6.setBounds(100, 127, 51, 39);
		contentPane.add(jb6);
		
		JButton jb7 = new JButton("7");
		jb7.setFocusPainted(false);
		jb7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtValor.setText(jtValor.getText()+"7");
			}
		});
		jb7.setForeground(Color.BLACK);
		jb7.setBackground(Color.CYAN);
		jb7.setBounds(1, 89, 51, 39);
		contentPane.add(jb7);
		
		JButton jb8 = new JButton("8");
		jb8.setFocusPainted(false);
		jb8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtValor.setText(jtValor.getText()+"8");
			}
		});
		jb8.setForeground(Color.BLACK);
		jb8.setBackground(Color.CYAN);
		jb8.setBounds(50, 89, 51, 39);
		contentPane.add(jb8);
		
		JButton jb9 = new JButton("9");
		jb9.setFocusPainted(false);
		jb9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				jtValor.setText(jtValor.getText()+"9");
			}
		});
		jb9.setForeground(Color.BLACK);
		jb9.setBackground(Color.CYAN);
		jb9.setBounds(100, 89, 51, 39);
		contentPane.add(jb9);
		
		JButton jbponto = new JButton(".");
		jbponto.setFont(new Font("Tahoma", Font.BOLD, 11));
		jbponto.setFocusPainted(false);
		jbponto.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				jtValor.setText(jtValor.getText()+".");
			}
		
		});
		jbponto.setForeground(Color.BLACK);
		jbponto.setBackground(Color.CYAN);
		jbponto.setBounds(50, 203, 51, 39);
		contentPane.add(jbponto);
		
		//raiz quadrada
		JButton jbraiz = new JButton("\u221A");
		jbraiz.setFocusPainted(false);
		jbraiz.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				numero1=Double.parseDouble(jtValor.getText());
				resultado= Math.sqrt(numero1);
				jtValor.setText(""+resultado);
			
			}
		});
		jbraiz.setForeground(Color.BLACK);
		jbraiz.setBackground(Color.CYAN);
		jbraiz.setBounds(100, 203, 51, 39);
		contentPane.add(jbraiz);
		
		//subtração
		JButton jbsubtrair = new JButton("\u2212");
		jbsubtrair.setFont(new Font("Tahoma", Font.BOLD, 11));
		jbsubtrair.setFocusPainted(false);
		jbsubtrair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero1=Double.parseDouble(jtValor.getText());
				operacao="\u2212";
				jtValor.setText("");
			}
		});
		jbsubtrair.setForeground(Color.BLACK);
		jbsubtrair.setBackground(Color.CYAN);
		jbsubtrair.setBounds(150, 165, 51, 39);
		contentPane.add(jbsubtrair);
		
		//multiplicação
		JButton jbmultiplicar = new JButton("x");
		jbmultiplicar.setFont(new Font("Tahoma", Font.BOLD, 11));
		jbmultiplicar.setFocusPainted(false);
		jbmultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero1=Double.parseDouble(jtValor.getText());
				operacao="X";
				jtValor.setText("");
			}
		});
		jbmultiplicar.setForeground(Color.BLACK);
		jbmultiplicar.setBackground(Color.CYAN);
		jbmultiplicar.setBounds(150, 127, 51, 39);
		contentPane.add(jbmultiplicar);
		
		//delete
		JButton jbdelete = new JButton("DEL");
		jbdelete.setFocusPainted(false);
		jbdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jtValor.setText("");
				
			}
		});
		jbdelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		jbdelete.setBackground(new Color(255, 0, 0));
		jbdelete.setForeground(new Color(255, 255, 255));
		jbdelete.setBounds(1, 242, 100, 23);
		contentPane.add(jbdelete);
		
		//divisão
		JButton jbdividir = new JButton("/");
		jbdividir.setFont(new Font("Tahoma", Font.BOLD, 11));
		jbdividir.setFocusPainted(false);
		jbdividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numero1=Double.parseDouble(jtValor.getText());
				operacao="/";
				jtValor.setText("");
			}
		});
		jbdividir.setForeground(Color.BLACK);
		jbdividir.setBackground(Color.CYAN);
		jbdividir.setBounds(150, 89, 51, 39);
		contentPane.add(jbdividir);
		
		setVisible(true);
	}
}
