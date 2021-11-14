import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.sql.ResultSet;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Caminhar extends JFrame implements MouseListener{
	private ManipulaCaminhada cam=new ManipulaCaminhada();
	private String [] colunas=new String []{"Data","Fez"};
	private DefaultTableModel modelo=new DefaultTableModel(colunas,0);
	private JTable tabela=new JTable(modelo){ 
		public boolean isCellEditable(int rowIndex, int mColIndex) {  
		return false; 
	}};
	
	private JScrollPane rolagem=new JScrollPane(tabela);

	private JPanel contentPane;
	private ButtonGroup grupo= new ButtonGroup();
	private JFormattedTextField jftData = new JFormattedTextField();
	private JRadioButton jrbNao = new JRadioButton("Não");
	private JRadioButton jrbSim = new JRadioButton("Sim");
	private JLabel jlClique = new JLabel("Selecione a data que deseja excluir e clique no bot\u00E3o acima!");
	private JLabel lblNewLabel = new JLabel("Salvar!");
	private String dias;
	ResultSet resultado=cam.listagem();
	private final JLabel jlExcluir = new JLabel("Excluir");
	JPanel panel = new JPanel();

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caminhar frame = new Caminhar();
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
	public Caminhar() {
		setTitle("Caminhada");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Caminhar.class.getResource("/icon_parque.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 892, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		tabela.setForeground(Color.black);
		tabela.setBackground(new Color(153, 204, 255));
		tabela.setFont(new Font("Arial",Font.BOLD,11));
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(97);
		
		tabela.addMouseListener(this);
		preencheTabela(cam.listagem());
		contentPane.setLayout(null);
		rolagem.setBounds(560, 197, 200, 190);
		getContentPane().add(rolagem);
		
		JLabel jlData = new JLabel("Data");
		jlData.setBounds(472, 81, 62, 19);
		jlData.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		contentPane.add(jlData);
		jftData.setBounds(528, 80, 91, 20);
		jftData.setBackground(Color.WHITE);
		jftData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(jftData);
		
		JLabel lblFezCaminhada = new JLabel("Fez caminhada?");
		lblFezCaminhada.setBounds(472, 21, 181, 32);
		lblFezCaminhada.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		contentPane.add(lblFezCaminhada);
		jrbSim.setBounds(645, 30, 109, 23);
		jrbSim.setBackground(new Color(153, 204, 255));
		jrbSim.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		contentPane.add(jrbSim);
		grupo.add(jrbSim);
		jrbNao.setBounds(761, 30, 86, 23);
		jrbNao.setBackground(new Color(153, 204, 255));
		jrbNao.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		contentPane.add(jrbNao);
		grupo.add(jrbNao);
		
		try{
			MaskFormatter mascdata=new MaskFormatter("####-##-##");
			mascdata.install(jftData);
		}
		catch(Exception a){
			
		}
		
		JButton jbSalvar = new JButton("");
		jbSalvar.setBounds(612, 130, 50, 50);
		jbSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel.setVisible(true);
				jbSalvar.setBackground(new Color(0, 255, 255));
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setVisible(false);
				jbSalvar.setBackground(new Color(153, 204, 255));
				
			}
		});
		jbSalvar.setIcon(new ImageIcon(Caminhar.class.getResource("/check.png")));
		jbSalvar.setFocusPainted(false);
		jbSalvar.setBackground(new Color(153, 204, 255));
		jbSalvar.setFont(new Font("Tahoma", Font.BOLD, 15));
		jbSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManipulaCaminhada cam=new ManipulaCaminhada();
				String data= jftData.getText();
				
				
				String resposta = "";
				if(jrbSim.isSelected())
				{
					resposta ="Sim";
					
				}
				if(jrbNao.isSelected())
				{
					resposta="Não";
				}
				
				if(resposta.equals("")||data.equals("    -  -  "))
				{
					JOptionPane.showMessageDialog(null, "Responda se fez ou não caminhada");
					
				}
				else
				{
				cam.inserir(data, resposta); 
				preencheTabela(cam.listagem());
				
				jftData.setText("");
				grupo.clearSelection();
				}
				
				
				
				
			}
			
		});
		contentPane.add(jbSalvar);
		
		
		JLabel label = new JLabel("");
		label.setBounds(-60, 21, 514, 520);
		label.setIcon(new ImageIcon(Caminhar.class.getResource("/corredor.png")));
		contentPane.add(label);
		
		
		panel.setBounds(464, 21, 402, 173);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(153, 204, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(66, 119, 61, 31);
		panel.add(lblNewLabel);
		
		JLabel jlTituloData = new JLabel("Ano - M\u00EAs - Dia");
		jlTituloData.setFont(new Font("Tahoma", Font.BOLD, 10));
		jlTituloData.setBounds(66, 40, 97, 14);
		panel.add(jlTituloData);
		
		
		lblNewLabel.setVisible(false);
		
		JButton jbExcluir = new JButton("");
		jbExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jlExcluir.setVisible(true);
				jbExcluir.setBackground(new Color(0, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jlExcluir.setVisible(false);
				jbExcluir.setBackground(new Color(51, 204, 255));
			}
		});
		jbExcluir.setBounds(613, 398, 50, 50);
		jbExcluir.setFocusPainted(false);
		jbExcluir.setBackground(new Color(51, 204, 255));
		jbExcluir.setIcon(new ImageIcon(Caminhar.class.getResource("/app_icon_plus.png")));
		
		jbExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta=JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?");
				if(resposta==0)
				{	
					cam.excluir(jftData.getText());
					JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
					preencheTabela(cam.listagem());
					
				}	
			}
		});
		contentPane.add(jbExcluir);
		jlClique.setBounds(472, 459, 375, 14);
		jlClique.setFont(new Font("Tahoma", Font.BOLD, 11));
		jlClique.setForeground(Color.RED);
		contentPane.add(jlClique);
		jlExcluir.setForeground(Color.RED);
		jlExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		jlExcluir.setBounds(620, 459, 132, 19);
		jlExcluir.setVisible(false);
		
		contentPane.add(jlExcluir);
		jlClique.setVisible(false);
	}
	public void preencheTabela(ResultSet resultado)
	{
	
		try
		{
			modelo.setNumRows(0);
			while(resultado.next())
			{
				modelo.addRow(new String[]{resultado.getString("data"),resultado.getString("resposta")});
			}
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	
	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		jftData.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
		String resposta=tabela.getValueAt(tabela.getSelectedRow(), 1).toString();
		if(resposta.equals("Sim"))
		{
			jrbSim.setSelected(true);
		}
		else
		{
			jrbNao.setSelected(true);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		jlClique.setVisible(true);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		jlClique.setVisible(false);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
