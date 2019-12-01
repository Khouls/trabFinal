package main;

//importar as classes criadas
import classes_veterinarias.*;
import jogoDaVelha.PanelJogoDaVelha;

//imports do windowbuilder
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Rectangle;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Cursor;

public class Main {

	private JFrame frame;
	private JMenuItem mntmVisualizarConsultas;
	private JMenuItem mntmVisulizarPets;
	private JMenuItem mntmVisualizarClientes;
	private JMenuItem mntmCadastarNovoCliente;
	private JMenuItem mntmCadastrarNovoPet;
	private JMenuItem mntmCancelarConsulta;
	private JPanel pCadastro;
	private PanelJogoDaVelha EasterEgg;
	private JPanel pCadastro_cliente;
	private JPanel pCancelador;
	private JButton btnCadastros;
	private JLabel lblNomeDoCliente;
	private JLabel lblNomeDoCliente_1;
	private JTextField textField_cadastroCliente_nome;
	private JTextField textField_cadastroCliente_CPF;
	private JTextField textField_cadastroPet_nomedoPet;
	private JTextField textField_cadastroPet_idadeDoPet;
	private JTextField textField_cadastroPet_racaDoPet;
	private JTextField textField_cadastroPet_especieDoPet;
	private JPanel pCadastro_pet;
	private JPanel pHome;
	private JTextField textField_veterinario;
	private JButton btnSair;
	private JButton btnRemoverCadastro;
	private JButton btnConsulta;
	private JButton btnCadastrarNovoPet;
	private JButton btnCadastrarNovoPet_1;
	private JButton btnCadastro_Voltar;
	private JButton btnCadastro_cliente_Voltar;
	private JButton btnCadastrar;
	private JButton btnCadastrarPet;
	private JButton btnConsulta_cancela_Voltar;
	private JButton btnConsulta_cancela_Confirma;
	private JButton button_4;
	private JButton btn_cadastrarPet;
	private JButton btnAgendador_voltar;
	private JButton btnAgendardor_cofirma;
	private JButton btnVisulaizar_clientes_Voltar;
	private JButton btnVisulaizar_pets_Voltar;
	private JButton btnVisulaizar_consultas_Voltar;
	private JButton btnRemoverCliente;
	private JButton btnVoltar_1;
	private JButton btnPets;
	private JButton btnClientes;
	private JButton btnRemoverPet;
	private JButton btnVoltar;
	private JPanel pAgendador;
	private JPanel pVisualizador_clientes;
	private JPanel pVisualizador_pets;
	private JPanel pVisualizador_consultas;
	private JPanel pRemover;
	private JPanel pRemover_cliente;
	private JPanel pVisualizador;
	private JLabel lblRemoverCliente;
	private JLabel lblSelecioneOCliente;
	private JComboBox<Cliente> comboBox_cliente_remocaoCliente;
	private JButton btnRemover_cliente_Voltar;
	private JButton btnRemover;
	private JPanel pRemover_pet;
	private JLabel lblRemooDePet;
	private JLabel label_3;
	private JComboBox<Cliente> comboBox_cliente_remocaoPet;
	private JButton btnRemover_pet_Voltar;
	private JButton btn_removerPet;
	private JLabel lblSelecioneOPet;
	private JComboBox<Pet> comboBox_pet_remocaoPet;
	private ArrayList<JPanel> panels;
	
	private JComboBox<Consulta> comboBox_consulta_cancelador;
	private JComboBox<Cliente> comboBox_cliente_cadastroPet;
	private JComboBox<Cliente> comboBox_cliente_agendador;
	private JComboBox<Pet> comboBox_pet_agendador;
	private JComboBox<Cliente> comboBox_cliente_visualizador;
	private JComboBox<Cliente> comboBox_cliente_visualizadorPets;
	private JComboBox<Pet> comboBox_pet_visualizadorPets;

	private JTextArea textArea_VisualizarClientes;
	private ArrayList<JComboBox<Pet>> comboBoxes_Pets;
	
	private ArrayList<JComboBox<Cliente>> comboBoxes_Clientes;
	private JSpinner spinner_dia;
	private JSpinner spinner_ano;
	private JTextField textField_cadastroCliente_telefone;
	private JTextField textField_cadastroCliente_email;
	private JTextArea textArea_VisualizarPets;
	private JSpinner spinner_hora;
	private JSpinner spinner_minutos;
	private JComboBox<String> comboBox_mesesDoAno;
	private JTextArea textArea_VisualizarConsultas;
	private JTextArea textArea_cancelador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//método que facilita a vida pra esconder todos e mostrar só o que for passado
	private void mostrarPainel(JPanel panel) {
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).setVisible(false);

			
		}
		
		
		// talvez fosse melhor fazer com IF e Else pra verificar se o objeto é o certo
		//mas consumiria mais processamento, então fica assim mesmo
		panel.setVisible(true);
		
	}
	
	//metodo pra adicionaro o cliente em todas as combobox
	private void adicionarEmTodasComboBox(Cliente cliente) {
		for (int i = 0; i < comboBoxes_Clientes.size(); i++) {
			comboBoxes_Clientes.get(i).addItem(cliente);

		}
		
	}
	
	//sobrecarga pra fazer o msm com pets
	private void adicionarEmTodasComboBox(Pet pet) {
		for (int i = 0; i < comboBoxes_Pets.size(); i++) {
			comboBoxes_Pets.get(i).addItem(pet);
		}
		
	}
	
	//metodo pra atualizar a textArea do visualizador (Clientes)
	
	private void atualizarVisualizadorCliente() {
		Cliente c =  null; 
		
		try {
			c =(Cliente) comboBox_cliente_visualizador.getSelectedItem();
			textArea_VisualizarClientes.setText("");
			textArea_VisualizarClientes.append("Nome: ");
			textArea_VisualizarClientes.append(c.getNome() + ".\n");
			textArea_VisualizarClientes.append("CPF: ");
			textArea_VisualizarClientes.append(c.getCpf() + ".\n");
			textArea_VisualizarClientes.append("E-Mail: ");
			textArea_VisualizarClientes.append(c.getEmail() + ".\n");
			textArea_VisualizarClientes.append("Telefone: ");
			textArea_VisualizarClientes.append(c.getTelefone() + ".\n");
			textArea_VisualizarClientes.append("Pets cadastrados: \n");
			
			for (int i = 0; i < c.getPets().size(); i++) {
				Pet pet = c.getPets().get(i);
				textArea_VisualizarClientes.append("Cadastro " + i + ": \n");
				textArea_VisualizarClientes.append("    Nome: ");
				textArea_VisualizarClientes.append(pet.getNome()+ ".\n");
				
				textArea_VisualizarClientes.append("    Idade: ");
				textArea_VisualizarClientes.append(pet.getIdade()+ ".\n");
				

				textArea_VisualizarClientes.append("    Espécie: ");
				textArea_VisualizarClientes.append(pet.getEspecie()+ ".\n");
				
				textArea_VisualizarClientes.append("    Raça: ");
				textArea_VisualizarClientes.append(pet.getRaca()+ ".\n");
				
				String ultimaConsulta = "";
				
				try {
					ultimaConsulta = pet.getUltimaConsulta().getDataFormatada();
					
					textArea_VisualizarClientes.append("    Número de Consultas Realizadas: ");
					textArea_VisualizarClientes.append(pet.getConsultasRealizdas()+ ".\n");
					
					textArea_VisualizarClientes.append("    Ultima Consulta: ");
					textArea_VisualizarClientes.append(ultimaConsulta + ".\n");

				} catch(Exception ex) {
					textArea_VisualizarClientes.append("    Pet ainda não consultado.\n");
				}
				
			}
		} catch(NullPointerException npe) {
			textArea_VisualizarClientes.setText("");
		}
		
	}
	
	//metodo pra atualizar a textArea do visualizador (Pets)
	private void atualizarVisualizadorPet() {
		Pet pet;
		String cadastro = "";
		String nome = "";
		String idade = "";
		String dono = "";
		String ultimaConsulta = "";
		int consultasRealizadas = 0;
		
		ArrayList<Consulta> consultas = null;
		
		textArea_VisualizarPets.setText("");
		try {
			//tenta pegar o pet
			pet = (Pet) comboBox_pet_visualizadorPets.getSelectedItem();
			
			cadastro = String.valueOf(pet.getCadastro());
			nome = pet.getNome();
			idade = String.valueOf(pet.getIdade());
			dono = ((Cliente)comboBox_cliente_visualizadorPets.getSelectedItem()).getNome();
			consultas = pet.getConsultas();
			ultimaConsulta = pet.getUltimaConsulta().getDataFormatada();
			consultasRealizadas = pet.getConsultasRealizdas();
			textArea_VisualizarPets.append("Cadastro: ");
			textArea_VisualizarPets.append(cadastro + ".\n");
			
			textArea_VisualizarPets.append("Nome: ");
			textArea_VisualizarPets.append(nome + ".\n");
			
			textArea_VisualizarPets.append("Idade: ");
			textArea_VisualizarPets.append(idade + ".\n");
			
			textArea_VisualizarPets.append("Dono: ");
			textArea_VisualizarPets.append(dono + ".\n");

				
			if (consultasRealizadas > 0){
				textArea_VisualizarPets.append("Consultas realizadas: ");
				textArea_VisualizarPets.append(String.valueOf(consultasRealizadas) + ".\n");
				

				
				textArea_VisualizarPets.append("Ultima consulta realizada em: ");
				textArea_VisualizarPets.append(ultimaConsulta + ".\n");
				
				textArea_VisualizarPets.append("Consultou em: \n");
				
				for (int i = 0; i < consultas.size(); i++) {
					textArea_VisualizarPets.append("    " + consultas.get(i).toString());
					textArea_VisualizarPets.append(".\n");
				}
				
			} else {
				textArea_VisualizarPets.append("O pet ainda não foi consultado.");
				
			}
			textArea_VisualizarPets.append("\n");
			
			
			
		} catch (NullPointerException npe) {
		}


	}
		
	
	
	
	
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Consulta> consultasAgendadas = new ArrayList<Consulta>();

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		pHome = new JPanel();
		pHome.setBackground(new Color(211, 211, 211));
		frame.getContentPane().add(pHome, "name_603179695376100");
		pHome.setLayout(null);
		
		pCadastro_cliente = new JPanel();
		frame.getContentPane().add(pCadastro_cliente, "name_1207081952357000");
		pCadastro_cliente.setLayout(null);
		
		pCancelador = new JPanel();
		frame.getContentPane().add(pCancelador, "name_1207127860104200");
		pCancelador.setLayout(null);
		
		pCadastro = new JPanel();
		frame.getContentPane().add(pCadastro, "name_603181757104400");
		pCadastro.setLayout(null);
		
		pCadastro_pet = new JPanel();
		pCadastro_pet.setLayout(null);
		frame.getContentPane().add(pCadastro_pet, "name_1209713983276400");
		
		EasterEgg = new PanelJogoDaVelha(300, 300);
		frame.getContentPane().add(EasterEgg, "name_1038451643549800");
		EasterEgg.setLayout(null);
		
		pAgendador = new JPanel();
		pAgendador.setLayout(null);
		frame.getContentPane().add(pAgendador, "name_24945018835900");
		
		pVisualizador_clientes = new JPanel();
		frame.getContentPane().add(pVisualizador_clientes, "name_25299206819600");
		pVisualizador_clientes.setLayout(null);
		
		pVisualizador_pets = new JPanel();
		pVisualizador_pets.setLayout(null);
		frame.getContentPane().add(pVisualizador_pets, "name_26883894905100");
		
		pVisualizador_consultas = new JPanel();
		pVisualizador_consultas.setLayout(null);
		frame.getContentPane().add(pVisualizador_consultas, "name_26891221701900");
		
		pRemover = new JPanel();
		frame.getContentPane().add(pRemover, "name_28145899150400");
		pRemover.setLayout(null);
		
		pRemover_cliente = new JPanel();
		frame.getContentPane().add(pRemover_cliente, "name_28157573016600");
		pRemover_cliente.setLayout(null);
		
		pVisualizador = new JPanel();
		frame.getContentPane().add(pVisualizador, "name_32146536350300");
		pVisualizador.setLayout(null);
		
		pRemover_pet = new JPanel();
		pRemover_pet.setLayout(null);
		frame.getContentPane().add(pRemover_pet, "name_36376354945300");
		
		//grande arraylist de panels 
		panels = new ArrayList<JPanel>();
		
		panels.add(pHome);
		panels.add(EasterEgg);
		
		panels.add(pCadastro);
		panels.add(pCadastro_cliente);
		panels.add(pCadastro_pet);
		panels.add(pCancelador);
		
		panels.add(pAgendador);
		
		panels.add(pVisualizador);
		panels.add(pVisualizador_clientes);
		panels.add(pVisualizador_consultas);
		panels.add(pVisualizador_pets);
		
		panels.add(pRemover);
		panels.add(pRemover_cliente);
		panels.add(pRemover_pet);
		
		//grande array de comboBoxes(Clientes)
		comboBoxes_Clientes = new ArrayList<JComboBox<Cliente>>();
		

		//media arraylist de comboBoxes(Pets)
		comboBoxes_Pets = new ArrayList<JComboBox<Pet>>();
		



		

		JLabel lblNewLabel = new JLabel("Petshop");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Noto Sans Light", Font.PLAIN, 28));
		lblNewLabel.setBounds(43, 0, 330, 62);
		pHome.add(lblNewLabel);
		
		btnConsulta = new JButton("Visualizar");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			pHome.setVisible(false);	
			pVisualizador.setVisible(true);
			}
		});
		btnConsulta.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnConsulta.setBackground(SystemColor.controlHighlight);
		btnConsulta.setBounds(10, 108, 114, 33);
		pHome.add(btnConsulta);
		
		btnRemoverCadastro = new JButton("Remover Cadastro");
		btnRemoverCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pRemover.setVisible(true);
				pHome.setVisible(false);
			}
		});
		btnRemoverCadastro.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemoverCadastro.setBackground(SystemColor.controlHighlight);
		btnRemoverCadastro.setBounds(10, 152, 114, 33);
		pHome.add(btnRemoverCadastro);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnSair.setBackground(SystemColor.controlHighlight);
		btnSair.setBounds(10, 196, 114, 33);
		pHome.add(btnSair);
		
		btnCadastros = new JButton("Cadastros");
		btnCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pCadastro.setVisible(true);	
			pHome.setVisible(false);
			}
		});
		btnCadastros.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastros.setBackground(SystemColor.controlHighlight);
		btnCadastros.setBounds(10, 67, 114, 33);
		pHome.add(btnCadastros);
		

		
		JLabel lblCadastros = new JLabel("Cadastros");
		lblCadastros.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastros.setFont(new Font("Noto Sans Light", Font.PLAIN, 28));
		lblCadastros.setBounds(57, 0, 330, 62);
		pCadastro.add(lblCadastros);
		
		btnCadastrarNovoPet = new JButton("Cadastrar Novo Cliente");
		btnCadastrarNovoPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pCadastro_cliente.setVisible(true);
				pCadastro.setVisible(false);
			}
		});
		btnCadastrarNovoPet.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastrarNovoPet.setBackground(SystemColor.controlHighlight);
		btnCadastrarNovoPet.setBounds(154, 92, 136, 33);
		pCadastro.add(btnCadastrarNovoPet);
		
		btnCadastrarNovoPet_1 = new JButton("Cadastrar Novo Pet");
		btnCadastrarNovoPet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pCadastro.setVisible(false);
				pCadastro_pet.setVisible(true);
			}
		});
		btnCadastrarNovoPet_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastrarNovoPet_1.setBackground(SystemColor.controlHighlight);
		btnCadastrarNovoPet_1.setBounds(154, 136, 136, 33);
		pCadastro.add(btnCadastrarNovoPet_1);
		
		btnCadastro_Voltar = new JButton("Voltar");
		btnCadastro_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pCadastro.setVisible(false);
				pHome.setVisible(true);
			}
		});
		btnCadastro_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastro_Voltar.setBackground(SystemColor.controlHighlight);
		btnCadastro_Voltar.setBounds(154, 180, 136, 33);
		pCadastro.add(btnCadastro_Voltar);
		


		
		lblNomeDoCliente = new JLabel("CPF:");
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDoCliente.setBounds(33, 57, 144, 44);
		pCadastro_cliente.add(lblNomeDoCliente);
		
		lblNomeDoCliente_1 = new JLabel("Nome do cliente:");
		lblNomeDoCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDoCliente_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDoCliente_1.setBounds(33, 0, 144, 44);
		pCadastro_cliente.add(lblNomeDoCliente_1);
		
		textField_cadastroCliente_nome = new JTextField();
		textField_cadastroCliente_nome.setBounds(33, 35, 144, 20);
		pCadastro_cliente.add(textField_cadastroCliente_nome);
		textField_cadastroCliente_nome.setColumns(10);
		
		textField_cadastroCliente_CPF = new JTextField();
		textField_cadastroCliente_CPF.setColumns(10);
		textField_cadastroCliente_CPF.setBounds(33, 100, 144, 20);
		pCadastro_cliente.add(textField_cadastroCliente_CPF);
		
		btnCadastro_cliente_Voltar = new JButton("Voltar");
		btnCadastro_cliente_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pCadastro_cliente.setVisible(false);
			pCadastro.setVisible(true);
			}
		});
		btnCadastro_cliente_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastro_cliente_Voltar.setBackground(SystemColor.controlHighlight);
		btnCadastro_cliente_Voltar.setBounds(88, 191, 89, 33);
		pCadastro_cliente.add(btnCadastro_cliente_Voltar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField_cadastroCliente_nome.getText();
				String cpf = textField_cadastroCliente_CPF.getText();
				String email = textField_cadastroCliente_email.getText();
				boolean valido = true;
				int telefone = 0;
				try {
					telefone = Integer.parseInt(textField_cadastroCliente_telefone.getText());
				} catch (Exception ex) {
					valido = false;
				}



				 // Cpf e' o identificador unico
				for (int i = 0; i < clientes.size(); i++) { //entao nao pode ter 2 iguais
					if (clientes.get(i).getCpf().equals(cpf)) {
						valido = false;
					}
				}
				if (valido) {
					Cliente cliente = new Cliente(nome, cpf, email, telefone);
					// adiciona o cliente em tudo
					clientes.add(cliente);
					adicionarEmTodasComboBox(cliente);
					
				} else {
					System.out.println("CPF JA CADASTRADO");
				}
			}
		});
		btnCadastrar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastrar.setBackground(SystemColor.controlHighlight);
		btnCadastrar.setBounds(177, 146, 89, 33);
		pCadastro_cliente.add(btnCadastrar);
		
		btnCadastrarPet = new JButton("Cadastrar Pet");
		btnCadastrarPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pCadastro_cliente.setVisible(false);
			pCadastro_pet.setVisible(true);
			}
		});
		btnCadastrarPet.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastrarPet.setBackground(SystemColor.controlHighlight);
		btnCadastrarPet.setBounds(265, 191, 89, 33);
		pCadastro_cliente.add(btnCadastrarPet);
		
		textField_cadastroCliente_telefone = new JTextField();
		textField_cadastroCliente_telefone.setColumns(10);
		textField_cadastroCliente_telefone.setBounds(265, 100, 144, 20);
		pCadastro_cliente.add(textField_cadastroCliente_telefone);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(265, 57, 144, 44);
		pCadastro_cliente.add(lblTelefone);
		
		textField_cadastroCliente_email = new JTextField();
		textField_cadastroCliente_email.setColumns(10);
		textField_cadastroCliente_email.setBounds(265, 35, 144, 20);
		pCadastro_cliente.add(textField_cadastroCliente_email);
		
		JLabel lblEmailDoCliente = new JLabel("Email do cliente:");
		lblEmailDoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailDoCliente.setBounds(265, 0, 144, 44);
		pCadastro_cliente.add(lblEmailDoCliente);
		

		comboBox_consulta_cancelador = new JComboBox<Consulta>();
		comboBox_consulta_cancelador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					Consulta cons = (Consulta) comboBox_consulta_cancelador.getSelectedItem();
					textArea_cancelador.setText(cons.formatar());
				} catch (Exception ex) {
					
				}

			}
		});
		comboBox_consulta_cancelador.setBounds(10, 68, 330, 20);
		pCancelador.add(comboBox_consulta_cancelador);
		
		JLabel lblSelecioneAConsula = new JLabel("Selecione a consulta que voc\u00EA deseja cancelar:");
		lblSelecioneAConsula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelecioneAConsula.setBounds(10, 11, 330, 41);
		pCancelador.add(lblSelecioneAConsula);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 330, 121);
		pCancelador.add(scrollPane);
		
		textArea_cancelador = new JTextArea();
		scrollPane.setViewportView(textArea_cancelador);
		
		btnConsulta_cancela_Voltar = new JButton("Voltar");
		btnConsulta_cancela_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pHome);
				
			}
		});
		btnConsulta_cancela_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnConsulta_cancela_Voltar.setBackground(SystemColor.controlHighlight);
		btnConsulta_cancela_Voltar.setBounds(350, 187, 82, 41);
		pCancelador.add(btnConsulta_cancela_Voltar);
		
		btnConsulta_cancela_Confirma = new JButton("Cancelar");
		btnConsulta_cancela_Confirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulta cons = (Consulta) comboBox_consulta_cancelador.getSelectedItem();
				

				
				consultasAgendadas.remove(cons);
				textArea_VisualizarConsultas.setText("");
				comboBox_consulta_cancelador.removeAllItems();
				
				for (int i = 0; i < consultasAgendadas.size(); i++) {
					textArea_VisualizarConsultas.append(consultasAgendadas.get(i).formatar());
					textArea_VisualizarConsultas.append("\n");
					comboBox_consulta_cancelador.addItem(consultasAgendadas.get(i));
				}
				
				Pet pet = cons.getPetConsultado();
				pet.getConsultas().remove(cons);
				pet.atualizarUltimaConsulta();

				
				atualizarVisualizadorPet();
				
			}
		});
		btnConsulta_cancela_Confirma.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnConsulta_cancela_Confirma.setBackground(SystemColor.controlHighlight);
		btnConsulta_cancela_Confirma.setBounds(350, 107, 82, 41);
		pCancelador.add(btnConsulta_cancela_Confirma);
		
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		panel.setBounds(422, 0, 10, 10);
		pCancelador.add(panel);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(panel, popupMenu);
		
		JMenuItem mntmIrParaO = new JMenuItem("Ir para o EasterEgg");
		mntmIrParaO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(EasterEgg);
				EasterEgg.reset();
			}
		});
		popupMenu.add(mntmIrParaO);

		JLabel lblIdadeDoPet = new JLabel("Idade do pet:");
		lblIdadeDoPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdadeDoPet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdadeDoPet.setBounds(245, 61, 144, 20);
		pCadastro_pet.add(lblIdadeDoPet);
		
		JLabel lblNomeDoPet = new JLabel("Nome do Pet:");
		lblNomeDoPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDoPet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeDoPet.setBounds(245, 13, 144, 20);
		pCadastro_pet.add(lblNomeDoPet);
		
		textField_cadastroPet_nomedoPet = new JTextField();
		textField_cadastroPet_nomedoPet.setColumns(10);
		textField_cadastroPet_nomedoPet.setBounds(234, 30, 165, 20);
		pCadastro_pet.add(textField_cadastroPet_nomedoPet);
		
		textField_cadastroPet_idadeDoPet = new JTextField();
		textField_cadastroPet_idadeDoPet.setColumns(10);
		textField_cadastroPet_idadeDoPet.setBounds(234, 81, 165, 20);
		pCadastro_pet.add(textField_cadastroPet_idadeDoPet);
		
		button_4 = new JButton("Voltar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pCadastro_pet.setVisible(false);
			pCadastro.setVisible(true);
			}
		});
		button_4.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		button_4.setBackground(SystemColor.controlHighlight);
		button_4.setBounds(10, 191, 134, 33);
		pCadastro_pet.add(button_4);
		
		btn_cadastrarPet = new JButton("Cadastrar");
		btn_cadastrarPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idade = 0;
				String nome = textField_cadastroPet_nomedoPet.getText();

				String especie = textField_cadastroPet_especieDoPet.getText();
				String raca = textField_cadastroPet_racaDoPet.getText();
				Cliente dono = (Cliente) comboBox_cliente_cadastroPet.getSelectedItem();
				try { //evitar que algum animal coloque que o pet tem Li anos
					idade = Integer.parseInt(textField_cadastroPet_idadeDoPet.getText());
					dono.cadastrarPet(nome, idade, especie, raca);
					
					if (clientes.size() == 1) {
						adicionarEmTodasComboBox(new Pet(nome, dono.getPetsCadastrados()-1, idade, especie, raca));
				
					}if (((Cliente) comboBox_cliente_visualizador.getSelectedItem()).getCpf().equals(dono.getCpf())) {
						//atualiza a textarea do visualizador automaticamente
						atualizarVisualizadorCliente();
						
					}

				} catch(Exception exc) {
					System.out.println("Algum dos dados inseridos esta errado");
				}

			}
		});
		btn_cadastrarPet.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btn_cadastrarPet.setBackground(SystemColor.controlHighlight);
		btn_cadastrarPet.setBounds(10, 147, 134, 33);
		pCadastro_pet.add(btn_cadastrarPet);
		
		JLabel lblRaa = new JLabel("Ra\u00E7a:");
		lblRaa.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRaa.setBounds(245, 112, 144, 20);
		pCadastro_pet.add(lblRaa);
		
		textField_cadastroPet_racaDoPet = new JTextField();
		textField_cadastroPet_racaDoPet.setColumns(10);
		textField_cadastroPet_racaDoPet.setBounds(234, 135, 165, 20);
		pCadastro_pet.add(textField_cadastroPet_racaDoPet);
		
		JLabel lblEspcie = new JLabel("Esp\u00E9cie");
		lblEspcie.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspcie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspcie.setBounds(245, 166, 144, 20);
		pCadastro_pet.add(lblEspcie);
		
		textField_cadastroPet_especieDoPet = new JTextField();
		textField_cadastroPet_especieDoPet.setColumns(10);
		textField_cadastroPet_especieDoPet.setBounds(234, 190, 165, 20);
		pCadastro_pet.add(textField_cadastroPet_especieDoPet);
		
		comboBox_cliente_cadastroPet = new JComboBox<Cliente>();
		comboBox_cliente_cadastroPet.setBounds(10, 40, 134, 20);
		pCadastro_pet.add(comboBox_cliente_cadastroPet);
		comboBoxes_Clientes.add(comboBox_cliente_cadastroPet);
		

		
		btnAgendador_voltar = new JButton("Voltar");
		btnAgendador_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pHome);
			}
		});
		btnAgendador_voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnAgendador_voltar.setBackground(SystemColor.controlHighlight);
		btnAgendador_voltar.setBounds(336, 158, 82, 41);
		pAgendador.add(btnAgendador_voltar);
		
		btnAgendardor_cofirma = new JButton("Agendar");
		btnAgendardor_cofirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hora = (int)spinner_hora.getValue();
				int minuto = (int)spinner_minutos.getValue();
				int dia = (int)spinner_dia.getValue();
				int mes = comboBox_mesesDoAno.getSelectedIndex()+1;
				int ano = (int)spinner_ano.getValue();
				
				Data dataDaConsulta = new Data(minuto, hora, dia, mes, ano);
				
				String veterinario = textField_veterinario.getText();
				
				Pet pet = (Pet) comboBox_pet_agendador.getSelectedItem();
				Cliente cliente = (Cliente) comboBox_cliente_agendador.getSelectedItem();
				
				Consulta consulta = new Consulta(dataDaConsulta, veterinario, cliente, pet);
				
				pet.consultar(consulta);
				
				consultasAgendadas.add(consulta);
				
				comboBox_consulta_cancelador.addItem(consulta);
				
				textArea_VisualizarConsultas.append(consulta.formatar());
				textArea_VisualizarConsultas.append("\n");
				atualizarVisualizadorCliente();
				

			}
		});
		btnAgendardor_cofirma.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnAgendardor_cofirma.setBackground(SystemColor.controlHighlight);
		btnAgendardor_cofirma.setBounds(336, 58, 82, 41);
		pAgendador.add(btnAgendardor_cofirma);
		
		JLabel lblAgendarConsulta = new JLabel("Agendar Consulta");
		lblAgendarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgendarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendarConsulta.setBounds(124, 0, 199, 33);
		pAgendador.add(lblAgendarConsulta);
		
		JLabel lblNome = new JLabel("Hora");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 34, 72, 27);
		pAgendador.add(lblNome);
		
		JLabel lblVeterinarioa = new JLabel("Veterinario(a)");
		lblVeterinarioa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVeterinarioa.setBounds(10, 96, 92, 27);
		pAgendador.add(lblVeterinarioa);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCliente.setBounds(10, 134, 92, 27);
		pAgendador.add(lblCliente);
		
		JLabel lblPet = new JLabel("Pet");
		lblPet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPet.setBounds(10, 172, 92, 27);
		pAgendador.add(lblPet);
		
		textField_veterinario = new JTextField();
		textField_veterinario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_veterinario.setBounds(145, 100, 111, 27);
		pAgendador.add(textField_veterinario);
		textField_veterinario.setColumns(10);
		
		comboBox_cliente_agendador = new JComboBox<Cliente>();
		comboBox_cliente_agendador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = (Cliente) comboBox_cliente_agendador.getSelectedItem();
				
				comboBox_pet_agendador.removeAllItems();
				if (clientes.size() > 0) {
					for (int i = 0; i < cliente.getPets().size(); i++) {
						comboBox_pet_agendador.addItem(cliente.getPets().get(i));
					}
				}

				
			}
		});
		comboBox_cliente_agendador.setBounds(145, 138, 111, 20);
		pAgendador.add(comboBox_cliente_agendador);
		comboBoxes_Clientes.add(comboBox_cliente_agendador);
		
		comboBox_pet_agendador = new JComboBox<Pet>();
		comboBox_pet_agendador.setBounds(145, 176, 111, 20);
		pAgendador.add(comboBox_pet_agendador);
		comboBoxes_Pets.add(comboBox_pet_agendador);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDia.setBounds(94, 34, 33, 27);
		pAgendador.add(lblDia);
		
		JLabel lblMes = new JLabel("M\u00EAs");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMes.setBounds(145, 34, 111, 27);
		pAgendador.add(lblMes);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAno.setBounds(272, 34, 33, 27);
		pAgendador.add(lblAno);
		
		spinner_hora = new JSpinner();
		spinner_hora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner_hora.setBounds(10, 67, 30, 22);
		pAgendador.add(spinner_hora);
		
		spinner_minutos = new JSpinner();
		spinner_minutos.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_minutos.setBounds(52, 67, 30, 22);
		pAgendador.add(spinner_minutos);
		
		spinner_dia = new JSpinner();
		spinner_dia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_dia.setBounds(101, 67, 30, 22);
		pAgendador.add(spinner_dia);
		
		spinner_ano = new JSpinner();
		spinner_ano.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2019), null, new Integer(1)));
		spinner_ano.setBounds(272, 67, 52, 22);
		pAgendador.add(spinner_ano);
		
		comboBox_mesesDoAno = new JComboBox<String>();
		comboBox_mesesDoAno.setBounds(145, 67, 111, 22);
		
		comboBox_mesesDoAno.addItem("Janeiro");
		comboBox_mesesDoAno.addItem("Fevereiro");
		comboBox_mesesDoAno.addItem("Marco");
		comboBox_mesesDoAno.addItem("Abril");
		comboBox_mesesDoAno.addItem("Maio");
		comboBox_mesesDoAno.addItem("Junho");
		comboBox_mesesDoAno.addItem("Julho");
		comboBox_mesesDoAno.addItem("Agosto");
		comboBox_mesesDoAno.addItem("Setembro");
		comboBox_mesesDoAno.addItem("Outubro");
		comboBox_mesesDoAno.addItem("Novembro");
		comboBox_mesesDoAno.addItem("Dezembro");
		
		pAgendador.add(comboBox_mesesDoAno);
		
		

		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setBounds(181, 11, 81, 38);
		pVisualizador_clientes.add(lblClientes);
		
		JLabel lblSelcioneOCliente = new JLabel("Selcione o Cliente:");
		lblSelcioneOCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelcioneOCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelcioneOCliente.setBounds(10, 45, 113, 39);
		pVisualizador_clientes.add(lblSelcioneOCliente);
		
		comboBox_cliente_visualizador = new JComboBox<Cliente>();
		comboBox_cliente_visualizador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarVisualizadorCliente();
				
				

			}
		});
		comboBox_cliente_visualizador.setBounds(10, 84, 113, 20);
		pVisualizador_clientes.add(comboBox_cliente_visualizador);
		comboBoxes_Clientes.add(comboBox_cliente_visualizador);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(147, 62, 274, 151);
		pVisualizador_clientes.add(scrollPane_1);
		
		textArea_VisualizarClientes = new JTextArea();
		scrollPane_1.setViewportView(textArea_VisualizarClientes);
		
		btnVisulaizar_clientes_Voltar = new JButton("Voltar");
		btnVisulaizar_clientes_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pVisualizador_clientes.setVisible(false);
				pVisualizador.setVisible(true);
			}
		});
		btnVisulaizar_clientes_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnVisulaizar_clientes_Voltar.setBackground(SystemColor.controlHighlight);
		btnVisulaizar_clientes_Voltar.setBounds(10, 188, 113, 25);
		pVisualizador_clientes.add(btnVisulaizar_clientes_Voltar);
		

		JLabel label_1 = new JLabel("");
		label_1.setBounds(10, 70, 46, 14);
		pVisualizador_pets.add(label_1);
		
		JLabel lblPets = new JLabel("Pets");
		lblPets.setHorizontalAlignment(SwingConstants.CENTER);
		lblPets.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPets.setBounds(181, 11, 81, 38);
		pVisualizador_pets.add(lblPets);
		
		comboBox_cliente_visualizadorPets = new JComboBox<Cliente>();
		comboBox_cliente_visualizadorPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Pet> pets = ((Cliente) comboBox_cliente_visualizadorPets.getSelectedItem()).getPets();
					comboBox_pet_visualizadorPets.removeAllItems();
					for (int i = 0; i < pets.size(); i++) {
						comboBox_pet_visualizadorPets.addItem(pets.get(i));
					}
					
				} catch (Exception ex) {
				}

			}
		});
		comboBox_cliente_visualizadorPets.setBounds(10, 87, 111, 20);
		pVisualizador_pets.add(comboBox_cliente_visualizadorPets);
		comboBoxes_Clientes.add(comboBox_cliente_visualizadorPets);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(133, 70, 286, 156);
		pVisualizador_pets.add(scrollPane_2);
		
		textArea_VisualizarPets = new JTextArea();
		scrollPane_2.setViewportView(textArea_VisualizarPets);
		
		btnVisulaizar_pets_Voltar = new JButton("Voltar");
		btnVisulaizar_pets_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pVisualizador_pets.setVisible(false);
				pVisualizador.setVisible(true);
			}
		});
		btnVisulaizar_pets_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnVisulaizar_pets_Voltar.setBackground(SystemColor.controlHighlight);
		btnVisulaizar_pets_Voltar.setBounds(10, 188, 61, 25);
		pVisualizador_pets.add(btnVisulaizar_pets_Voltar);
		
		comboBox_pet_visualizadorPets = new JComboBox<Pet>();
		comboBox_pet_visualizadorPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarVisualizadorPet();
			}
		});
		comboBox_pet_visualizadorPets.setBounds(10, 143, 111, 20);
		pVisualizador_pets.add(comboBox_pet_visualizadorPets);
		comboBoxes_Pets.add(comboBox_pet_visualizadorPets);
		
		JLabel lblSelecioneOPet = new JLabel("Selecione o Pet:");
		lblSelecioneOPet.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelecioneOPet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelecioneOPet.setBounds(10, 118, 113, 25);
		pVisualizador_pets.add(lblSelecioneOPet);
		
		JLabel lblSelcioneOCliente_1 = new JLabel("Selcione o Cliente:");
		lblSelcioneOCliente_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelcioneOCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelcioneOCliente_1.setBounds(10, 59, 113, 25);
		pVisualizador_pets.add(lblSelcioneOCliente_1);
		

		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultas.setBounds(181, 11, 81, 38);
		pVisualizador_consultas.add(lblConsultas);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(94, 84, 316, 129);
		pVisualizador_consultas.add(scrollPane_3);
		
		textArea_VisualizarConsultas = new JTextArea();
		scrollPane_3.setViewportView(textArea_VisualizarConsultas);
		
		btnVisulaizar_consultas_Voltar = new JButton("Voltar");
		btnVisulaizar_consultas_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pVisualizador_consultas.setVisible(false);
				pVisualizador.setVisible(true);
			}
		});
		btnVisulaizar_consultas_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnVisulaizar_consultas_Voltar.setBackground(SystemColor.controlHighlight);
		btnVisulaizar_consultas_Voltar.setBounds(10, 125, 61, 25);
		pVisualizador_consultas.add(btnVisulaizar_consultas_Voltar);
		

		
		JLabel lblRemocao = new JLabel("Remo\u00E7\u00E3o");
		lblRemocao.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemocao.setFont(new Font("Dialog", Font.PLAIN, 28));
		lblRemocao.setBounds(57, 11, 330, 62);
		pRemover.add(lblRemocao);
		
		 
		btnRemoverCliente = new JButton("Remover Cliente");
		btnRemoverCliente.addActionListener(new ActionListener() {
 
			public void actionPerformed(ActionEvent e) {
			pRemover.setVisible(false);
			pRemover_cliente.setVisible(true);
			}
		});
		btnRemoverCliente.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemoverCliente.setBackground(SystemColor.controlHighlight);
		btnRemoverCliente.setBounds(154, 84, 136, 33);
		pRemover.add(btnRemoverCliente);
	
		btnRemoverPet = new JButton("Remover Pet");
		btnRemoverPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pRemover.setVisible(false);
			pRemover_pet.setVisible(true);
			}
		});
		btnRemoverPet.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemoverPet.setBackground(SystemColor.controlHighlight);
		btnRemoverPet.setBounds(154, 128, 136, 33);
		pRemover.add(btnRemoverPet);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pRemover.setVisible(false);
			pHome.setVisible(true);
			}
		});
		btnVoltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnVoltar.setBackground(SystemColor.controlHighlight);
		btnVoltar.setBounds(154, 172, 136, 33);
		pRemover.add(btnVoltar);
		

		
		lblRemoverCliente = new JLabel("Remo\u00E7\u00E3o de Cliente");
		lblRemoverCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverCliente.setFont(new Font("Dialog", Font.PLAIN, 28));
		lblRemoverCliente.setBounds(57, 11, 330, 62);
		pRemover_cliente.add(lblRemoverCliente);
		
		lblSelecioneOCliente = new JLabel("Selecione o Cliente");
		lblSelecioneOCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelecioneOCliente.setBounds(100, 79, 119, 29);
		pRemover_cliente.add(lblSelecioneOCliente);
		
		comboBox_cliente_remocaoCliente = new JComboBox<Cliente>();
		comboBox_cliente_remocaoCliente.setBounds(231, 84, 117, 20);
		pRemover_cliente.add(comboBox_cliente_remocaoCliente);
		comboBoxes_Clientes.add(comboBox_cliente_remocaoCliente);
		
		btnRemover_cliente_Voltar = new JButton("Voltar");
		btnRemover_cliente_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pRemover_cliente.setVisible(false);
				pRemover.setVisible(true);
				
			}
		});
		btnRemover_cliente_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemover_cliente_Voltar.setBackground(SystemColor.controlHighlight);
		btnRemover_cliente_Voltar.setBounds(162, 187, 119, 33);
		pRemover_cliente.add(btnRemover_cliente_Voltar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = (Cliente) comboBox_cliente_remocaoCliente.getSelectedItem();
				
				clientes.remove(cliente);
				
				for (int i = 0; i < comboBoxes_Clientes.size(); i++) {
					comboBoxes_Clientes.get(i).removeItem(cliente);
					
				}
				
			}
		});
		btnRemover.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemover.setBackground(SystemColor.controlHighlight);
		btnRemover.setBounds(162, 131, 119, 33);
		pRemover_cliente.add(btnRemover);
		
		btnVoltar_1 = new JButton("Voltar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pVisualizador.setVisible(false);
				pHome.setVisible(true);
			}
			
		});
		btnVoltar_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnVoltar_1.setBackground(SystemColor.controlHighlight);
		btnVoltar_1.setBounds(154, 172, 136, 33);
		pVisualizador.add(btnVoltar_1);
		
		btnPets = new JButton("Pets");
		btnPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pVisualizador.setVisible(false);
				pVisualizador_pets.setVisible(true);
			}
		});
		btnPets.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnPets.setBackground(SystemColor.controlHighlight);
		btnPets.setBounds(154, 128, 136, 33);
		pVisualizador.add(btnPets);
		
		btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pVisualizador.setVisible(false);
				pVisualizador_clientes.setVisible(true);
			}
		});
		btnClientes.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnClientes.setBackground(SystemColor.controlHighlight);
		btnClientes.setBounds(154, 84, 136, 33);
		pVisualizador.add(btnClientes);
		
		JLabel lblVisualizar = new JLabel("Visualizar:");
		lblVisualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisualizar.setFont(new Font("Dialog", Font.PLAIN, 28));
		lblVisualizar.setBounds(57, 11, 330, 62);
		pVisualizador.add(lblVisualizar);
		
		lblRemooDePet = new JLabel("Remo\u00E7\u00E3o de Pet");
		lblRemooDePet.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemooDePet.setFont(new Font("Dialog", Font.PLAIN, 28));
		lblRemooDePet.setBounds(57, 11, 330, 62);
		pRemover_pet.add(lblRemooDePet);
		
		label_3 = new JLabel("Selecione o Cliente");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(67, 84, 119, 20);
		pRemover_pet.add(label_3);
		
		comboBox_cliente_remocaoPet = new JComboBox<Cliente>();
		comboBox_cliente_remocaoPet.setBounds(67, 113, 119, 20);
		pRemover_pet.add(comboBox_cliente_remocaoPet);
		comboBoxes_Clientes.add(comboBox_cliente_remocaoPet);
		
		btnRemover_pet_Voltar = new JButton("Voltar");
		btnRemover_pet_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pRemover_pet.setVisible(false);
				pRemover.setVisible(true);
			
			}
		});
		btnRemover_pet_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemover_pet_Voltar.setBackground(SystemColor.controlHighlight);
		btnRemover_pet_Voltar.setBounds(223, 154, 119, 49);
		pRemover_pet.add(btnRemover_pet_Voltar);
		
		btn_removerPet = new JButton("Remover");
		btn_removerPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pet pet = (Pet) comboBox_pet_remocaoPet.getSelectedItem();
				Cliente dono = (Cliente) comboBox_cliente_remocaoPet.getSelectedItem();
				
				dono.getPets().remove(pet);
				
				for (int i = 0; i < comboBoxes_Pets.size(); i++) {
					try {
						comboBoxes_Pets.get(i).removeItem(pet);
					} catch (Exception ex) {}
				}
				
			}
		});
		btn_removerPet.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btn_removerPet.setBackground(SystemColor.controlHighlight);
		btn_removerPet.setBounds(223, 84, 119, 49);
		pRemover_pet.add(btn_removerPet);
		
		lblSelecioneOPet = new JLabel("Selecione o Pet");
		lblSelecioneOPet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelecioneOPet.setBounds(67, 154, 119, 20);
		pRemover_pet.add(lblSelecioneOPet);
		
		comboBox_pet_remocaoPet = new JComboBox<Pet>();
		comboBox_pet_remocaoPet.setBounds(67, 183, 119, 20);
		pRemover_pet.add(comboBox_pet_remocaoPet);
		comboBoxes_Pets.add(comboBox_pet_remocaoPet);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(menuBar);
		
		JMenu mnCadstros = new JMenu("Cadastros");
		mnCadstros.setBorder(null);
		menuBar.add(mnCadstros);
		
		mntmCadastarNovoCliente = new JMenuItem("Cadastrar Novo Cliente");
		mntmCadastarNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pCadastro_cliente);		
			}
		});
		mntmCadastarNovoCliente.setBounds(new Rectangle(2, 2, 0, 0));
		mntmCadastarNovoCliente.setBorder(null);
		mnCadstros.add(mntmCadastarNovoCliente);
		
		mntmCadastrarNovoPet = new JMenuItem("Cadastrar Novo Pet");
		mntmCadastrarNovoPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pCadastro_pet);
			}
		});
		mntmCadastrarNovoPet.setBorder(null);
		mnCadstros.add(mntmCadastrarNovoPet);
		
		JMenu mnConsulta = new JMenu("Consultas");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmAgendarConsulta = new JMenuItem("Agendar Consulta");
		mntmAgendarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 mostrarPainel(pAgendador);
				
			}
		});
		mntmAgendarConsulta.setBorder(null);
		mnConsulta.add(mntmAgendarConsulta);
		
		mntmCancelarConsulta = new JMenuItem("Cancelar Consulta");
		mntmCancelarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pCancelador);
			
			}
		});
		mntmCancelarConsulta.setBorder(null);
		mnConsulta.add(mntmCancelarConsulta);
		
		JMenu mnVisualizar = new JMenu("Visualizar");
		menuBar.add(mnVisualizar);
		
		mntmVisualizarClientes = new JMenuItem("Visualizar Clientes");
		mntmVisualizarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pVisualizador_clientes);
			}
		});
		mntmVisualizarClientes.setBorder(null);
		mnVisualizar.add(mntmVisualizarClientes);
		
		mntmVisulizarPets = new JMenuItem("Visulizar Pets");
		mntmVisulizarPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pVisualizador_pets);
			}
		});
		mntmVisulizarPets.setBorder(null);
		mnVisualizar.add(mntmVisulizarPets);
		
		mntmVisualizarConsultas = new JMenuItem("Visualizar Consultas");
		mntmVisualizarConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pVisualizador_consultas);
			
			}
		});
		mntmVisualizarConsultas.setBorder(null);
		mnVisualizar.add(mntmVisualizarConsultas);
		
		JMenu mnRemover = new JMenu("Remover");
		menuBar.add(mnRemover);
		
		JMenuItem mntmRemoverCliente = new JMenuItem("Remover Cliente");
		mntmRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pRemover_cliente);
			}
		});
		mnRemover.add(mntmRemoverCliente);
		
		JMenuItem mntmRemoverPet = new JMenuItem("Remover Pet");
		mntmRemoverPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pRemover_pet);
			}
		});
		mnRemover.add(mntmRemoverPet);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
