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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Cursor;

public class Main {

	private JFrame frmPetshop;
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
	private File f_clientes;
	private File f_consultas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Consulta> consultasAgendadas;
	private JButton btnSalvar_remocaoCliente;
	private JButton btnSalvar_1;
	private JLabel lblMostrador_agendador;
	private Color verde;
	private Color vermelho;
	private JLabel lblMostrador_cadastroCliente;
	private JLabel lblMostrador_cadastroPet;
	private JLabel lblSelecioneOPet_1;
	private JFrame fEasterEgg;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmPetshop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// método que facilita a vida pra esconder todos e mostrar só o que for passado
	private void mostrarPainel(JPanel panel) {
		for (int i = 0; i < panels.size(); i++) {
			panels.get(i).setVisible(false);
		}
		// talvez fosse melhor fazer com IF e Else pra verificar se o objeto é o certo
		// mas consumiria mais processamento, então fica assim mesmo
		panel.setVisible(true);
		
	}
	
	// metodo pra adicionar o cliente em todas as combobox
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
	
	private void limparTodasComboBoxPet() {
		for (int i = 0; i < comboBoxes_Pets.size(); i++) {
			comboBoxes_Pets.get(i).removeAllItems();
		}
	}
	
	// metodos que escrevem os cadastros nos arquivos
	// clientes:
	private void salvarInformacoesClientes() {

		try {
			FileWriter fw_clientes = new FileWriter(f_clientes, false);
			BufferedWriter bw_clientes = new BufferedWriter(fw_clientes);
			
			for (int i = 0; i < clientes.size(); i++) {
				Cliente cliente = clientes.get(i);

				bw_clientes.append(cliente.getCpf());
				bw_clientes.append("\n");
				
				File f = new File("registros/clientes/" + cliente.getCpf() + ".txt");
				f.createNewFile();
				
				FileWriter fw = new FileWriter(f, false);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(cliente.getNome() + "\n");
				bw.write(cliente.getCpf() + "\n");
				bw.write(cliente.getEmail() + "\n");
				bw.write(String.valueOf(cliente.getTelefone()) + "\n");
				bw.write(String.valueOf(cliente.getPetsCadastrados()) + "\n");
				
				ArrayList<Pet> pets = cliente.getPets();
				
				for (int j = 0; j < pets.size() ; j++) {
					Pet pet = pets.get(i);
					bw.write(pet.getNome() + "\n");
					bw.write(pet.getIdade() + "\n");
					bw.write(pet.getEspecie() + "\n");
					bw.write(pet.getRaca() + "\n");
				}
				bw.close();
				fw.close();
			}
			
			bw_clientes.close();
			fw_clientes.close();
			
		} catch (IOException e) {
			
		}
	}
	
	// consultas:
	
	private void salvarInformacoesConsultas() {
		try {
			FileWriter fw_consultas = new FileWriter(f_consultas, false);
			BufferedWriter bw_consultas = new BufferedWriter(fw_consultas);
			
			for (int i = 0; i < consultasAgendadas.size(); i++) {
				Consulta consulta = consultasAgendadas.get(i);
				
				bw_consultas.write(String.valueOf(consulta.getData().getHora()) + " ");
				bw_consultas.write(String.valueOf(consulta.getData().getMinuto()) + " ");
				bw_consultas.write(String.valueOf(consulta.getData().getDia()) + " ");
				bw_consultas.write(String.valueOf(consulta.getData().getMes()) + " ");
				bw_consultas.write(String.valueOf(consulta.getData().getAno()) + " ");
				bw_consultas.write(String.valueOf(consulta.getVeterinario() + " "));
				bw_consultas.write(String.valueOf(consulta.getCliente().getCpf() + " "));
				bw_consultas.write(String.valueOf(consulta.getPetConsultado().getCadastro() + "\n"));
			}
			bw_consultas.close();
			fw_consultas.close();
			
		} catch (IOException e) {
		}
		
	}
	
	
	// metodo pra atualizar a textArea do visualizador (Clientes)
	
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
			textArea_VisualizarClientes.append("Pets cadastrados: ");
			textArea_VisualizarClientes.append(c.getPetsCadastrados() + " \n");
			
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
	
	// metodo pra atualizar a textArea do visualizador (Pets)
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
			// tenta pegar o pet
			pet = (Pet) comboBox_pet_visualizadorPets.getSelectedItem();
			cadastro = String.valueOf(pet.getCadastro());
			nome = pet.getNome();
			idade = String.valueOf(pet.getIdade());
			dono = ((Cliente)comboBox_cliente_visualizadorPets.getSelectedItem()).getNome();

			consultas = pet.getConsultas();
			try { // quando o pet é criado, não houve ultima consulta, logo a data seria null, o que gera uma NullPointerException				
				ultimaConsulta = pet.getUltimaConsulta().getDataFormatada();

			} catch (NullPointerException npe) {
			}

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
	
	// método que faz a label ficar vermelha ou verde, dando feedback
	private void colorizarLabel(JLabel label,boolean sucesso) {
		if (sucesso) {
			label.setText("Informações Salvas!");
			label.setForeground(verde);
		} else {
			label.setText("Erro nas Informações!");
			label.setForeground(vermelho);
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
		fEasterEgg = new JFrame();
		
		verde = new Color(0, 255, 34);
		vermelho = new Color(255, 7, 0);
		
		clientes = new ArrayList<Cliente>();
		consultasAgendadas = new ArrayList<Consulta>();
		ArrayList<Cliente> clientesDeletados = new ArrayList<Cliente>();
		
		frmPetshop = new JFrame();
		frmPetshop.setTitle("PetShop");
		frmPetshop.setBackground(new Color(255, 255, 255));
		frmPetshop.setResizable(false);
		frmPetshop.setBounds(100, 100, 450, 400);
		frmPetshop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPetshop.getContentPane().setLayout(new CardLayout(0, 0));
		
		pHome = new JPanel();
		pHome.setBackground(new Color(153, 153, 204));
		frmPetshop.getContentPane().add(pHome, "name_603179695376100");
		pHome.setLayout(null);
		
		pCadastro_cliente = new JPanel();
		pCadastro_cliente.setBackground(new Color(153, 153, 204));
		frmPetshop.getContentPane().add(pCadastro_cliente, "name_1207081952357000");
		pCadastro_cliente.setLayout(null);
		
		pCancelador = new JPanel();
		pCancelador.setBackground(new Color(153, 153, 204));
		frmPetshop.getContentPane().add(pCancelador, "name_1207127860104200");
		pCancelador.setLayout(null);
		
		pCadastro = new JPanel();
		pCadastro.setBackground(new Color(153, 153, 204));
		frmPetshop.getContentPane().add(pCadastro, "name_603181757104400");
		pCadastro.setLayout(null);
		
		pCadastro_pet = new JPanel();
		pCadastro_pet.setBackground(new Color(153, 153, 204));
		pCadastro_pet.setLayout(null);
		frmPetshop.getContentPane().add(pCadastro_pet, "name_1209713983276400");
		
		EasterEgg = new PanelJogoDaVelha(300, 300, fEasterEgg);
		EasterEgg.setLayout(null);
		
		pAgendador = new JPanel();
		pAgendador.setBackground(new Color(153, 153, 204));
		frmPetshop.getContentPane().add(pAgendador, "name_24945018835900");
		
		pVisualizador_clientes = new JPanel();
		pVisualizador_clientes.setBackground(new Color(153, 153, 204));
		frmPetshop.getContentPane().add(pVisualizador_clientes, "name_25299206819600");
		pVisualizador_clientes.setLayout(null);
		
		pVisualizador_pets = new JPanel();
		pVisualizador_pets.setBackground(new Color(153, 153, 204));
		pVisualizador_pets.setLayout(null);
		frmPetshop.getContentPane().add(pVisualizador_pets, "name_26883894905100");
		
		pVisualizador_consultas = new JPanel();
		pVisualizador_consultas.setBackground(new Color(153, 153, 204));
		pVisualizador_consultas.setLayout(null);
		frmPetshop.getContentPane().add(pVisualizador_consultas, "name_26891221701900");
		
		pRemover = new JPanel();
		pRemover.setBackground(new Color(153, 153, 204));
		frmPetshop.getContentPane().add(pRemover, "name_28145899150400");
		pRemover.setLayout(null);
		
		pRemover_cliente = new JPanel();
		pRemover_cliente.setBackground(new Color(153, 153, 204));
		frmPetshop.getContentPane().add(pRemover_cliente, "name_28157573016600");
		pRemover_cliente.setLayout(null);
		
		pVisualizador = new JPanel();
		pVisualizador.setBackground(new Color(153, 153, 204));
		frmPetshop.getContentPane().add(pVisualizador, "name_32146536350300");
		pVisualizador.setLayout(null);
		
		pRemover_pet = new JPanel();
		pRemover_pet.setBackground(new Color(153, 153, 204));
		pRemover_pet.setLayout(null);
		frmPetshop.getContentPane().add(pRemover_pet, "name_36376354945300");
		
		//grande arraylist de panels 
		panels = new ArrayList<JPanel>();
		
		panels.add(pHome);
		
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
		
		btnConsulta = new JButton("Visualizar");
		btnConsulta.setFocusPainted(false);
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			pHome.setVisible(false);	
			pVisualizador.setVisible(true);
			}
		});
		btnConsulta.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnConsulta.setBackground(new Color(255, 255, 255));
		btnConsulta.setBounds(10, 141, 114, 33);
		pHome.add(btnConsulta);
		
		btnRemoverCadastro = new JButton("Remover Cadastro");
		btnRemoverCadastro.setFocusPainted(false);
		btnRemoverCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pRemover.setVisible(true);
				pHome.setVisible(false);
			}
		});
		btnRemoverCadastro.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemoverCadastro.setBackground(new Color(255, 255, 255));
		btnRemoverCadastro.setBounds(10, 198, 114, 33);
		pHome.add(btnRemoverCadastro);
		
		btnSair = new JButton("Sair");
		btnSair.setFocusPainted(false);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setBounds(10, 255, 114, 33);
		pHome.add(btnSair);
		
		btnCadastros = new JButton("Cadastros");
		btnCadastros.setFocusPainted(false);
		btnCadastros.setForeground(new Color(0, 0, 0));
		btnCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pCadastro.setVisible(true);	
			pHome.setVisible(false);
			}
		});
		btnCadastros.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastros.setBackground(new Color(255, 255, 255));
		btnCadastros.setBounds(10, 84, 114, 33);
		pHome.add(btnCadastros);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFocusPainted(false);
		btnSalvar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnSalvar.setBackground(new Color(255, 255, 255));
		btnSalvar.setBounds(309, 289, 114, 33);
		pHome.add(btnSalvar);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/imagemPetshop.png")));
		label.setBounds(66, 25, 391, 277);
		pHome.add(label);
		

		
		JLabel lblCadastros = new JLabel("Cadastros");
		lblCadastros.setForeground(new Color(51, 0, 51));
		lblCadastros.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastros.setFont(new Font("Noto Sans Light", Font.PLAIN, 28));
		lblCadastros.setBounds(57, 12, 330, 62);
		pCadastro.add(lblCadastros);
		
		btnCadastrarNovoPet = new JButton("Cadastrar Novo Cliente");
		btnCadastrarNovoPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pCadastro_cliente.setVisible(true);
				pCadastro.setVisible(false);
			}
		});
		btnCadastrarNovoPet.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastrarNovoPet.setBackground(new Color(255, 255, 255));
		btnCadastrarNovoPet.setBounds(154, 103, 136, 33);
		pCadastro.add(btnCadastrarNovoPet);
		
		btnCadastrarNovoPet_1 = new JButton("Cadastrar Novo Pet");
		btnCadastrarNovoPet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pCadastro.setVisible(false);
				pCadastro_pet.setVisible(true);
			}
		});
		btnCadastrarNovoPet_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastrarNovoPet_1.setBackground(new Color(255, 255, 255));
		btnCadastrarNovoPet_1.setBounds(154, 170, 136, 33);
		pCadastro.add(btnCadastrarNovoPet_1);
		
		btnCadastro_Voltar = new JButton("Voltar");
		btnCadastro_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pCadastro.setVisible(false);
				pHome.setVisible(true);
			}
		});
		btnCadastro_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastro_Voltar.setBackground(new Color(255, 255, 255));
		btnCadastro_Voltar.setBounds(154, 237, 136, 33);
		pCadastro.add(btnCadastro_Voltar);
		


		
		lblNomeDoCliente = new JLabel("CPF:");
		lblNomeDoCliente.setForeground(new Color(51, 0, 51));
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDoCliente.setBounds(33, 112, 144, 44);
		pCadastro_cliente.add(lblNomeDoCliente);
		
		lblNomeDoCliente_1 = new JLabel("Nome do cliente:");
		lblNomeDoCliente_1.setForeground(new Color(51, 0, 51));
		lblNomeDoCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDoCliente_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDoCliente_1.setBounds(33, 26, 144, 44);
		pCadastro_cliente.add(lblNomeDoCliente_1);
		
		textField_cadastroCliente_nome = new JTextField();
		textField_cadastroCliente_nome.setBounds(33, 69, 144, 20);
		pCadastro_cliente.add(textField_cadastroCliente_nome);
		textField_cadastroCliente_nome.setColumns(10);
		
		textField_cadastroCliente_CPF = new JTextField();
		textField_cadastroCliente_CPF.setColumns(10);
		textField_cadastroCliente_CPF.setBounds(33, 155, 144, 20);
		pCadastro_cliente.add(textField_cadastroCliente_CPF);
		
		btnCadastro_cliente_Voltar = new JButton("Voltar");
		btnCadastro_cliente_Voltar.setFocusPainted(false);
		btnCadastro_cliente_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pCadastro_cliente.setVisible(false);
			pCadastro.setVisible(true);
			}
		});
		btnCadastro_cliente_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastro_cliente_Voltar.setBackground(new Color(255, 255, 255));
		btnCadastro_cliente_Voltar.setBounds(33, 255, 89, 33);
		pCadastro_cliente.add(btnCadastro_cliente_Voltar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFocusPainted(false);
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
				}
				
				colorizarLabel(lblMostrador_cadastroCliente, valido);
				
				salvarInformacoesClientes();
			}
		});
		btnCadastrar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setBounds(177, 255, 89, 33);
		pCadastro_cliente.add(btnCadastrar);
		
		btnCadastrarPet = new JButton("Cadastrar Pet");
		btnCadastrarPet.setFocusPainted(false);
		btnCadastrarPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pCadastro_cliente.setVisible(false);
			pCadastro_pet.setVisible(true);
			}
		});
		btnCadastrarPet.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnCadastrarPet.setBackground(new Color(255, 255, 255));
		btnCadastrarPet.setBounds(320, 255, 89, 33);
		pCadastro_cliente.add(btnCadastrarPet);
		
		textField_cadastroCliente_telefone = new JTextField();
		textField_cadastroCliente_telefone.setColumns(10);
		textField_cadastroCliente_telefone.setBounds(265, 155, 144, 20);
		pCadastro_cliente.add(textField_cadastroCliente_telefone);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(new Color(51, 0, 51));
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(265, 112, 144, 44);
		pCadastro_cliente.add(lblTelefone);
		
		textField_cadastroCliente_email = new JTextField();
		textField_cadastroCliente_email.setColumns(10);
		textField_cadastroCliente_email.setBounds(265, 69, 144, 20);
		pCadastro_cliente.add(textField_cadastroCliente_email);
		
		JLabel lblEmailDoCliente = new JLabel("Email do cliente:");
		lblEmailDoCliente.setForeground(new Color(51, 0, 51));
		lblEmailDoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailDoCliente.setBounds(265, 26, 144, 44);
		pCadastro_cliente.add(lblEmailDoCliente);
		
		lblMostrador_cadastroCliente = new JLabel("");
		lblMostrador_cadastroCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrador_cadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMostrador_cadastroCliente.setBounds(18, 289, 408, 41);
		pCadastro_cliente.add(lblMostrador_cadastroCliente);
		

		comboBox_consulta_cancelador = new JComboBox<Consulta>();
		comboBox_consulta_cancelador.setForeground(new Color(51, 0, 51));
		comboBox_consulta_cancelador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					Consulta cons = (Consulta) comboBox_consulta_cancelador.getSelectedItem();
					textArea_cancelador.setText(cons.formatar());
				} catch (Exception ex) {
					
				}

			}
		});
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(pCancelador, popupMenu);
		
		JMenuItem mntmIrParaO = new JMenuItem("Ir para o EasterEgg");
		mntmIrParaO.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {

				
				fEasterEgg.getContentPane().add(EasterEgg);
				
				fEasterEgg.setSize(318, 346);

				fEasterEgg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				fEasterEgg.setVisible(true);
				fEasterEgg.setResizable(false);
				EasterEgg.setFocusable(true);
				EasterEgg.requestFocus();

				EasterEgg.setVisible(true);
				
				EasterEgg.reset();
			}
		});
		popupMenu.add(mntmIrParaO);
		comboBox_consulta_cancelador.setBounds(10, 68, 329, 20);
		pCancelador.add(comboBox_consulta_cancelador);
		
		JLabel lblSelecioneAConsula = new JLabel("Selecione a consulta que voc\u00EA deseja cancelar:");
		lblSelecioneAConsula.setForeground(new Color(51, 0, 51));
		lblSelecioneAConsula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelecioneAConsula.setBounds(10, 11, 332, 54);
		pCancelador.add(lblSelecioneAConsula);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 330, 222);
		pCancelador.add(scrollPane);
		
		textArea_cancelador = new JTextArea();
		scrollPane.setViewportView(textArea_cancelador);
		
		btnConsulta_cancela_Voltar = new JButton("Voltar");
		btnConsulta_cancela_Voltar.setFocusPainted(false);
		btnConsulta_cancela_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pHome);
				
			}
		});
		btnConsulta_cancela_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnConsulta_cancela_Voltar.setBackground(new Color(255, 255, 255));
		btnConsulta_cancela_Voltar.setBounds(350, 286, 82, 41);
		pCancelador.add(btnConsulta_cancela_Voltar);
		
		btnConsulta_cancela_Confirma = new JButton("Remover");
		btnConsulta_cancela_Confirma.setFocusPainted(false);
		btnConsulta_cancela_Confirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
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
				} catch  (NullPointerException npe) {
					// Em alguns casos, ele tentava pegar consulta, não conseguia e tudo quebrava
				}
			}
		});
		btnConsulta_cancela_Confirma.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnConsulta_cancela_Confirma.setBackground(new Color(255, 255, 255));
		btnConsulta_cancela_Confirma.setBounds(351, 107, 82, 41);
		pCancelador.add(btnConsulta_cancela_Confirma);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 204));
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		panel.setBounds(416, 0, 28, 23);
		pCancelador.add(panel);
		
		btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.setFocusPainted(false);
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarInformacoesConsultas();
			}
		});
		btnSalvar_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnSalvar_1.setBackground(new Color(255, 255, 255));
		btnSalvar_1.setBounds(351, 199, 82, 41);
		pCancelador.add(btnSalvar_1);

		JLabel lblIdadeDoPet = new JLabel("Idade do pet:");
		lblIdadeDoPet.setForeground(new Color(51, 0, 51));
		lblIdadeDoPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdadeDoPet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdadeDoPet.setBounds(258, 112, 144, 20);
		pCadastro_pet.add(lblIdadeDoPet);
		
		JLabel lblNomeDoPet = new JLabel("Nome do Pet:");
		lblNomeDoPet.setForeground(new Color(51, 0, 51));
		lblNomeDoPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDoPet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeDoPet.setBounds(256, 55, 144, 20);
		pCadastro_pet.add(lblNomeDoPet);
		
		textField_cadastroPet_nomedoPet = new JTextField();
		textField_cadastroPet_nomedoPet.setColumns(10);
		textField_cadastroPet_nomedoPet.setBounds(245, 78, 165, 20);
		pCadastro_pet.add(textField_cadastroPet_nomedoPet);
		
		textField_cadastroPet_idadeDoPet = new JTextField();
		textField_cadastroPet_idadeDoPet.setColumns(10);
		textField_cadastroPet_idadeDoPet.setBounds(245, 134, 165, 20);
		pCadastro_pet.add(textField_cadastroPet_idadeDoPet);
		
		button_4 = new JButton("Voltar");
		button_4.setFocusPainted(false);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pCadastro_pet.setVisible(false);
			pCadastro.setVisible(true);
			}
		});
		button_4.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		button_4.setBackground(new Color(255, 255, 255));
		button_4.setBounds(22, 246, 134, 33);
		pCadastro_pet.add(button_4);
		
		btn_cadastrarPet = new JButton("Cadastrar");
		btn_cadastrarPet.setFocusPainted(false);
		btn_cadastrarPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso = true;
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
					salvarInformacoesClientes();
				} catch(Exception exc) {
					sucesso = false;
				}
				
				colorizarLabel(lblMostrador_cadastroPet, sucesso);

			}
		});
		btn_cadastrarPet.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btn_cadastrarPet.setBackground(new Color(255, 255, 255));
		btn_cadastrarPet.setBounds(22, 158, 134, 33);
		pCadastro_pet.add(btn_cadastrarPet);
		
		JLabel lblRaa = new JLabel("Ra\u00E7a:");
		lblRaa.setForeground(new Color(51, 0, 51));
		lblRaa.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRaa.setBounds(256, 173, 144, 20);
		pCadastro_pet.add(lblRaa);
		
		textField_cadastroPet_racaDoPet = new JTextField();
		textField_cadastroPet_racaDoPet.setColumns(10);
		textField_cadastroPet_racaDoPet.setBounds(245, 196, 165, 20);
		pCadastro_pet.add(textField_cadastroPet_racaDoPet);
		
		JLabel lblEspcie = new JLabel("Esp\u00E9cie");
		lblEspcie.setForeground(new Color(51, 0, 51));
		lblEspcie.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspcie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspcie.setBounds(256, 233, 144, 20);
		pCadastro_pet.add(lblEspcie);
		
		textField_cadastroPet_especieDoPet = new JTextField();
		textField_cadastroPet_especieDoPet.setColumns(10);
		textField_cadastroPet_especieDoPet.setBounds(245, 257, 165, 20);
		pCadastro_pet.add(textField_cadastroPet_especieDoPet);
		
		comboBox_cliente_cadastroPet = new JComboBox<Cliente>();
		comboBox_cliente_cadastroPet.setBounds(22, 78, 134, 20);
		pCadastro_pet.add(comboBox_cliente_cadastroPet);
		comboBoxes_Clientes.add(comboBox_cliente_cadastroPet);
		
		lblMostrador_cadastroPet = new JLabel("");
		lblMostrador_cadastroPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrador_cadastroPet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMostrador_cadastroPet.setBounds(18, 282, 408, 41);
		pCadastro_pet.add(lblMostrador_cadastroPet);
		

		
		btnAgendador_voltar = new JButton("Voltar");
		btnAgendador_voltar.setBounds(319, 242, 82, 41);
		btnAgendador_voltar.setFocusPainted(false);
		btnAgendador_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pHome);
			}
		});
		pAgendador.setLayout(null);
		btnAgendador_voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnAgendador_voltar.setBackground(new Color(255, 255, 255));
		pAgendador.add(btnAgendador_voltar);
		
		btnAgendardor_cofirma = new JButton("Agendar");
		btnAgendardor_cofirma.setBounds(319, 190, 82, 41);
		btnAgendardor_cofirma.setFocusPainted(false);
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
				
				boolean informacoesCorretas = (!veterinario.equals("")) && (cliente != null) && (pet != null);
				
				if (informacoesCorretas) {
					Consulta consulta = new Consulta(dataDaConsulta, veterinario, cliente, pet);
					
					pet.consultar(consulta);
					
					consultasAgendadas.add(consulta);
					
					comboBox_consulta_cancelador.addItem(consulta);
					
					textArea_VisualizarConsultas.append(consulta.formatar());
					textArea_VisualizarConsultas.append("\n");
					atualizarVisualizadorPet();
					salvarInformacoesConsultas();
				}
				
				colorizarLabel(lblMostrador_agendador, informacoesCorretas);

				

				

			}
		});
		btnAgendardor_cofirma.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnAgendardor_cofirma.setBackground(new Color(255, 255, 255));
		pAgendador.add(btnAgendardor_cofirma);
		
		JLabel lblAgendarConsulta = new JLabel("Agendar Consulta");
		lblAgendarConsulta.setForeground(new Color(51, 0, 51));
		lblAgendarConsulta.setBounds(115, 6, 214, 69);
		lblAgendarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAgendarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		pAgendador.add(lblAgendarConsulta);
		
		JLabel lblNome = new JLabel("Hora");
		lblNome.setForeground(new Color(51, 0, 51));
		lblNome.setBounds(30, 97, 72, 27);
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pAgendador.add(lblNome);
		
		JLabel lblVeterinarioa = new JLabel("Veterinario(a)");
		lblVeterinarioa.setForeground(new Color(51, 0, 51));
		lblVeterinarioa.setBounds(30, 180, 111, 27);
		lblVeterinarioa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pAgendador.add(lblVeterinarioa);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(new Color(51, 0, 51));
		lblCliente.setBounds(30, 218, 92, 27);
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pAgendador.add(lblCliente);
		
		JLabel lblPet = new JLabel("Pet");
		lblPet.setForeground(new Color(51, 0, 51));
		lblPet.setBounds(30, 256, 92, 27);
		lblPet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pAgendador.add(lblPet);
		
		textField_veterinario = new JTextField();
		textField_veterinario.setBounds(186, 181, 111, 27);
		textField_veterinario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pAgendador.add(textField_veterinario);
		textField_veterinario.setColumns(10);
		
		comboBox_cliente_agendador = new JComboBox<Cliente>();
		comboBox_cliente_agendador.setBounds(186, 223, 111, 20);
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
		pAgendador.add(comboBox_cliente_agendador);
		comboBoxes_Clientes.add(comboBox_cliente_agendador);
		
		comboBox_pet_agendador = new JComboBox<Pet>();
		comboBox_pet_agendador.setBounds(186, 261, 111, 20);
		pAgendador.add(comboBox_pet_agendador);
		comboBoxes_Pets.add(comboBox_pet_agendador);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setForeground(new Color(51, 0, 51));
		lblDia.setBounds(114, 97, 33, 27);
		lblDia.setHorizontalAlignment(SwingConstants.LEFT);
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pAgendador.add(lblDia);
		
		JLabel lblMes = new JLabel("M\u00EAs");
		lblMes.setForeground(new Color(51, 0, 51));
		lblMes.setBounds(186, 97, 111, 27);
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pAgendador.add(lblMes);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setForeground(new Color(51, 0, 51));
		lblAno.setBounds(334, 97, 33, 27);
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pAgendador.add(lblAno);
		
		spinner_hora = new JSpinner();
		spinner_hora.setBackground(new Color(255, 255, 255));
		spinner_hora.setBounds(30, 126, 52, 20);
		spinner_hora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		pAgendador.add(spinner_hora);
		
		spinner_minutos = new JSpinner();
		spinner_minutos.setBackground(new Color(255, 255, 255));
		spinner_minutos.setBounds(30, 151, 52, 20);
		spinner_minutos.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		pAgendador.add(spinner_minutos);
		
		spinner_dia = new JSpinner();
		spinner_dia.setBackground(new Color(255, 255, 255));
		spinner_dia.setBounds(114, 126, 45, 27);
		spinner_dia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		pAgendador.add(spinner_dia);
		
		spinner_ano = new JSpinner();
		spinner_ano.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner_ano.setBackground(new Color(255, 255, 255));
		spinner_ano.setBounds(319, 126, 72, 27);
		spinner_ano.setModel(new SpinnerNumberModel(new Integer(2020), new Integer(2019), null, new Integer(1)));
		pAgendador.add(spinner_ano);
		
		comboBox_mesesDoAno = new JComboBox<String>();
		comboBox_mesesDoAno.setBounds(186, 126, 111, 22);
		
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
		
		lblMostrador_agendador = new JLabel("");
		lblMostrador_agendador.setBounds(18, 284, 408, 41);
		lblMostrador_agendador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMostrador_agendador.setHorizontalAlignment(SwingConstants.CENTER);
		pAgendador.add(lblMostrador_agendador);
		
		

		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setForeground(new Color(51, 0, 51));
		lblClientes.setBackground(new Color(255, 255, 255));
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setBounds(181, 11, 81, 38);
		pVisualizador_clientes.add(lblClientes);
		
		JLabel lblSelcioneOCliente = new JLabel("Selcione o Cliente:");
		lblSelcioneOCliente.setForeground(new Color(51, 0, 51));
		lblSelcioneOCliente.setBackground(new Color(255, 255, 255));
		lblSelcioneOCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelcioneOCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelcioneOCliente.setBounds(40, 50, 120, 39);
		pVisualizador_clientes.add(lblSelcioneOCliente);
		
		comboBox_cliente_visualizador = new JComboBox<Cliente>();
		comboBox_cliente_visualizador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarVisualizadorCliente();
				
				

			}
		});
		comboBox_cliente_visualizador.setBounds(40, 96, 113, 20);
		pVisualizador_clientes.add(comboBox_cliente_visualizador);
		comboBoxes_Clientes.add(comboBox_cliente_visualizador);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 127, 364, 196);
		pVisualizador_clientes.add(scrollPane_1);
		
		textArea_VisualizarClientes = new JTextArea();
		scrollPane_1.setViewportView(textArea_VisualizarClientes);
		
		btnVisulaizar_clientes_Voltar = new JButton("Voltar");
		btnVisulaizar_clientes_Voltar.setFocusPainted(false);
		btnVisulaizar_clientes_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pVisualizador_clientes.setVisible(false);
				pVisualizador.setVisible(true);
			}
		});
		btnVisulaizar_clientes_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnVisulaizar_clientes_Voltar.setBackground(new Color(255, 255, 255));
		btnVisulaizar_clientes_Voltar.setBounds(291, 94, 113, 25);
		pVisualizador_clientes.add(btnVisulaizar_clientes_Voltar);
		

		JLabel label_1 = new JLabel("");
		label_1.setBounds(10, 70, 46, 14);
		pVisualizador_pets.add(label_1);
		
		JLabel lblPets = new JLabel("Pets");
		lblPets.setForeground(new Color(51, 0, 51));
		lblPets.setHorizontalAlignment(SwingConstants.CENTER);
		lblPets.setFont(new Font("Tahoma", Font.PLAIN, 22));
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
		comboBox_cliente_visualizadorPets.setBounds(10, 105, 111, 20);
		pVisualizador_pets.add(comboBox_cliente_visualizadorPets);
		comboBoxes_Clientes.add(comboBox_cliente_visualizadorPets);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(133, 70, 286, 249);
		pVisualizador_pets.add(scrollPane_2);
		
		textArea_VisualizarPets = new JTextArea();
		scrollPane_2.setViewportView(textArea_VisualizarPets);
		
		btnVisulaizar_pets_Voltar = new JButton("Voltar");
		btnVisulaizar_pets_Voltar.setFocusPainted(false);
		btnVisulaizar_pets_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pVisualizador_pets.setVisible(false);
				pVisualizador.setVisible(true);
			}
		});
		btnVisulaizar_pets_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnVisulaizar_pets_Voltar.setBackground(new Color(255, 255, 255));
		btnVisulaizar_pets_Voltar.setBounds(10, 294, 111, 25);
		pVisualizador_pets.add(btnVisulaizar_pets_Voltar);
		
		comboBox_pet_visualizadorPets = new JComboBox<Pet>();
		comboBox_pet_visualizadorPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarVisualizadorPet();
			}
		});
		comboBox_pet_visualizadorPets.setBounds(10, 201, 111, 20);
		pVisualizador_pets.add(comboBox_pet_visualizadorPets);
		comboBoxes_Pets.add(comboBox_pet_visualizadorPets);
		
		JLabel lblSelecioneOPet = new JLabel("Selecione o Pet:");
		lblSelecioneOPet.setForeground(new Color(51, 0, 51));
		lblSelecioneOPet.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelecioneOPet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelecioneOPet.setBounds(10, 165, 113, 25);
		pVisualizador_pets.add(lblSelecioneOPet);
		
		JLabel lblSelcioneOCliente_1 = new JLabel("Selcione o Cliente:");
		lblSelcioneOCliente_1.setForeground(new Color(51, 0, 51));
		lblSelcioneOCliente_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelcioneOCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelcioneOCliente_1.setBounds(10, 69, 113, 25);
		pVisualizador_pets.add(lblSelcioneOCliente_1);
		

		
		JLabel lblConsultas = new JLabel("Consultas");
		lblConsultas.setForeground(new Color(51, 0, 51));
		lblConsultas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblConsultas.setBounds(128, 11, 188, 62);
		pVisualizador_consultas.add(lblConsultas);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(41, 133, 344, 183);
		pVisualizador_consultas.add(scrollPane_3);
		
		textArea_VisualizarConsultas = new JTextArea();
		scrollPane_3.setViewportView(textArea_VisualizarConsultas);
		
		btnVisulaizar_consultas_Voltar = new JButton("Voltar");
		btnVisulaizar_consultas_Voltar.setFocusPainted(false);
		btnVisulaizar_consultas_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pVisualizador_consultas.setVisible(false);
				pVisualizador.setVisible(true);
			}
		});
		btnVisulaizar_consultas_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnVisulaizar_consultas_Voltar.setBackground(new Color(255, 255, 255));
		btnVisulaizar_consultas_Voltar.setBounds(295, 84, 90, 45);
		pVisualizador_consultas.add(btnVisulaizar_consultas_Voltar);
		

		
		JLabel lblRemocao = new JLabel("Remo\u00E7\u00E3o");
		lblRemocao.setForeground(new Color(51, 0, 51));
		lblRemocao.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemocao.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblRemocao.setBounds(57, 11, 330, 62);
		pRemover.add(lblRemocao);
		
		 
		btnRemoverCliente = new JButton("Remover Cliente");
		btnRemoverCliente.setFocusPainted(false);
		btnRemoverCliente.addActionListener(new ActionListener() {
 
			public void actionPerformed(ActionEvent e) {
			pRemover.setVisible(false);
			pRemover_cliente.setVisible(true);
			}
		});
		btnRemoverCliente.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemoverCliente.setBackground(new Color(255, 255, 255));
		btnRemoverCliente.setBounds(154, 101, 136, 33);
		pRemover.add(btnRemoverCliente);
	
		btnRemoverPet = new JButton("Remover Pet");
		btnRemoverPet.setFocusPainted(false);
		btnRemoverPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pRemover.setVisible(false);
			pRemover_pet.setVisible(true);
			}
		});
		btnRemoverPet.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemoverPet.setBackground(new Color(255, 255, 255));
		btnRemoverPet.setBounds(154, 165, 136, 33);
		pRemover.add(btnRemoverPet);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFocusPainted(false);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pRemover.setVisible(false);
			pHome.setVisible(true);
			}
		});
		btnVoltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setBounds(154, 230, 136, 33);
		pRemover.add(btnVoltar);
		

		
		lblRemoverCliente = new JLabel("Remo\u00E7\u00E3o de Cliente");
		lblRemoverCliente.setForeground(new Color(51, 0, 51));
		lblRemoverCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverCliente.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblRemoverCliente.setBounds(57, 11, 330, 62);
		pRemover_cliente.add(lblRemoverCliente);
		
		lblSelecioneOCliente = new JLabel("Selecione o Cliente");
		lblSelecioneOCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneOCliente.setForeground(new Color(51, 0, 51));
		lblSelecioneOCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelecioneOCliente.setBounds(81, 109, 137, 42);
		pRemover_cliente.add(lblSelecioneOCliente);
		
		comboBox_cliente_remocaoCliente = new JComboBox<Cliente>();
		comboBox_cliente_remocaoCliente.setBounds(228, 122, 117, 20);
		pRemover_cliente.add(comboBox_cliente_remocaoCliente);
		comboBoxes_Clientes.add(comboBox_cliente_remocaoCliente);
		
		btnRemover_cliente_Voltar = new JButton("Voltar");
		btnRemover_cliente_Voltar.setFocusPainted(false);
		btnRemover_cliente_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pRemover_cliente.setVisible(false);
				pRemover.setVisible(true);
				
			}
		});
		btnRemover_cliente_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemover_cliente_Voltar.setBackground(new Color(255, 255, 255));
		btnRemover_cliente_Voltar.setBounds(160, 249, 119, 33);
		pRemover_cliente.add(btnRemover_cliente_Voltar);
		
		btnRemover = new JButton("Remover");
		btnRemover.setFocusPainted(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = (Cliente) comboBox_cliente_remocaoCliente.getSelectedItem();
				
				clientes.remove(cliente);
				
				for (int i = 0; i < comboBoxes_Clientes.size(); i++) {
					comboBoxes_Clientes.get(i).removeItem(cliente);
					
				}
				
				Cliente clienteVisulizador = (Cliente) comboBox_cliente_visualizador.getSelectedItem();
				try {
					if (cliente.getCpf().equals(clienteVisulizador.getCpf())) {
						comboBox_pet_visualizadorPets.removeAllItems();
					}
				} catch (NullPointerException npe) {
					comboBox_pet_visualizadorPets.removeAllItems();
				}

				
				
				// Quando o cliente for excluido, excluir tambem todas as consultas dele:
				
				for (int i= 0; i < consultasAgendadas.size(); i++) {
					Consulta consulta = consultasAgendadas.get(i);
						try { // se n tiver consultas, gera NullPointerException
							if (consulta.getCliente().getCpf().equals(cliente.getCpf())) {
							// provavelmente daria para comparar os dois objetos diretamente,
							// ja que eu tenho quase certeza que o objeto da arraylist é só um
							// "pointer" pra o objeto, mas vamos pelo lado segur, afinal tem chave única.
							consultasAgendadas.remove(consulta);
							}
						
						} catch (NullPointerException npe) {
							
						}

					
				}
				
				// Colocar o cliente na lista de delets
				
				clientesDeletados.add(cliente);
				

				
			}
		});
		btnRemover.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemover.setBackground(new Color(255, 255, 255));
		btnRemover.setBounds(97, 205, 119, 33);
		pRemover_cliente.add(btnRemover);
		
		btnSalvar_remocaoCliente = new JButton("Salvar");
		btnSalvar_remocaoCliente.setFocusPainted(false);
		btnSalvar_remocaoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (Cliente clienteDeletado : clientesDeletados) {
					// testando essa estrutura nova
					try {
						File clienteDeletado_file = new File("registros/clientes/" + clienteDeletado.getCpf() + ".txt");
						clienteDeletado_file.delete();
					} catch (Exception ex) {

					}
				}
				
				clientesDeletados.clear();
				salvarInformacoesClientes();
				salvarInformacoesConsultas();
			}
		});
		btnSalvar_remocaoCliente.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnSalvar_remocaoCliente.setBackground(new Color(255, 255, 255));
		btnSalvar_remocaoCliente.setBounds(228, 205, 119, 33);
		pRemover_cliente.add(btnSalvar_remocaoCliente);
		
		btnVoltar_1 = new JButton("Voltar");
		btnVoltar_1.setFocusPainted(false);
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pVisualizador.setVisible(false);
				pHome.setVisible(true);
			}
			
		});
		btnVoltar_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnVoltar_1.setBackground(new Color(255, 255, 255));
		btnVoltar_1.setBounds(154, 223, 136, 33);
		pVisualizador.add(btnVoltar_1);
		
		btnPets = new JButton("Pets");
		btnPets.setFocusPainted(false);
		btnPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pVisualizador.setVisible(false);
				pVisualizador_pets.setVisible(true);
			}
		});
		btnPets.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnPets.setBackground(new Color(255, 255, 255));
		btnPets.setBounds(154, 179, 136, 33);
		pVisualizador.add(btnPets);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setFocusPainted(false);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pVisualizador.setVisible(false);
				pVisualizador_clientes.setVisible(true);
			}
		});
		btnClientes.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnClientes.setBackground(new Color(255, 255, 255));
		btnClientes.setBounds(154, 135, 136, 33);
		pVisualizador.add(btnClientes);
		
		JLabel lblVisualizar = new JLabel("Visualizar:");
		lblVisualizar.setForeground(new Color(51, 0, 51));
		lblVisualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisualizar.setFont(new Font("Dialog", Font.PLAIN, 26));
		lblVisualizar.setBounds(57, 11, 330, 62);
		pVisualizador.add(lblVisualizar);
		
		lblRemooDePet = new JLabel("Remo\u00E7\u00E3o de Pet");
		lblRemooDePet.setForeground(new Color(51, 0, 51));
		lblRemooDePet.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemooDePet.setFont(new Font("Dialog", Font.PLAIN, 28));
		lblRemooDePet.setBounds(57, 11, 330, 62);
		pRemover_pet.add(lblRemooDePet);
		
		label_3 = new JLabel("Selecione o Cliente");
		label_3.setForeground(new Color(51, 0, 51));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(67, 73, 132, 49);
		pRemover_pet.add(label_3);
		
		comboBox_cliente_remocaoPet = new JComboBox<Cliente>();
		comboBox_cliente_remocaoPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_pet_remocaoPet.removeAllItems();
				try { // se não tiver cliente isso é null -> NullPointerException 
					Cliente cliente = (Cliente) comboBox_cliente_remocaoPet.getSelectedItem();
					for (int i = 0; i < cliente.getPets().size(); i++) {
						comboBox_pet_remocaoPet.addItem(cliente.getPets().get(i));
					}
				} catch (NullPointerException npe) {
					
				}

				
			}
		});
		comboBox_cliente_remocaoPet.setBounds(67, 123, 119, 20);
		pRemover_pet.add(comboBox_cliente_remocaoPet);
		comboBoxes_Clientes.add(comboBox_cliente_remocaoPet);
		
		btnRemover_pet_Voltar = new JButton("Voltar");
		btnRemover_pet_Voltar.setFocusPainted(false);
		btnRemover_pet_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pRemover_pet.setVisible(false);
				pRemover.setVisible(true);
			
			}
		});
		btnRemover_pet_Voltar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnRemover_pet_Voltar.setBackground(new Color(255, 255, 255));
		btnRemover_pet_Voltar.setBounds(152, 263, 119, 33);
		pRemover_pet.add(btnRemover_pet_Voltar);
		
		btn_removerPet = new JButton("Remover");
		btn_removerPet.setFocusPainted(false);
		btn_removerPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pet pet = (Pet) comboBox_pet_remocaoPet.getSelectedItem();
				Cliente dono = (Cliente) comboBox_cliente_remocaoPet.getSelectedItem();
				
				dono.getPets().remove(pet);
				dono.updatePetsCadastrados();
				
				for (int i = 0; i < comboBoxes_Pets.size(); i++) {
					try {
						comboBoxes_Pets.get(i).removeItem(pet);
					} catch (Exception ex) {}
				}
				
				// Quando o pet for deletado, deletar tambem as consultas dele:
				
				for (int i = 0; i < consultasAgendadas.size(); i++) {
					Consulta consulta = consultasAgendadas.get(i);
					Pet petConsultado = consulta.getPetConsultado();
					Cliente clienteConsulta = consulta.getCliente();
					if (clienteConsulta.getCpf().equals(dono.getCpf()) && petConsultado.getCadastro() == pet.getCadastro()) {
						consultasAgendadas.remove(i);
					}
				}
				
				
			}
		});
		btn_removerPet.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btn_removerPet.setBackground(new Color(255, 255, 255));
		btn_removerPet.setBounds(232, 117, 119, 33);
		pRemover_pet.add(btn_removerPet);
		
		lblSelecioneOPet_1 = new JLabel("Selecione o Pet");
		lblSelecioneOPet_1.setForeground(new Color(51, 0, 51));
		lblSelecioneOPet_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelecioneOPet_1.setBounds(67, 165, 132, 44);
		pRemover_pet.add(lblSelecioneOPet_1);
		
		comboBox_pet_remocaoPet = new JComboBox<Pet>();
		comboBox_pet_remocaoPet.setBounds(67, 209, 119, 20);
		pRemover_pet.add(comboBox_pet_remocaoPet);
		comboBoxes_Pets.add(comboBox_pet_remocaoPet);
		
		JButton btnSalvar_remocaoPet = new JButton("Salvar");
		btnSalvar_remocaoPet.setFocusPainted(false);
		btnSalvar_remocaoPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvarInformacoesClientes();
			}
		});
		btnSalvar_remocaoPet.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		btnSalvar_remocaoPet.setBackground(new Color(255, 255, 255));
		btnSalvar_remocaoPet.setBounds(232, 203, 119, 33);
		pRemover_pet.add(btnSalvar_remocaoPet);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.WHITE);
		frmPetshop.setJMenuBar(menuBar);
		
		JMenu mnCadstros = new JMenu("Cadastros");
		mnCadstros.setForeground(new Color(0, 0, 0));
		mnCadstros.setBackground(new Color(255, 255, 255));
		mnCadstros.setBorder(null);
		menuBar.add(mnCadstros);
		
		mntmCadastarNovoCliente = new JMenuItem("Cadastrar Novo Cliente");
		mntmCadastarNovoCliente.setBackground(new Color(255, 255, 255));
		mntmCadastarNovoCliente.setForeground(new Color(0, 0, 0));
		mntmCadastarNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pCadastro_cliente);		
			}
		});
		mntmCadastarNovoCliente.setBounds(new Rectangle(2, 2, 0, 0));
		mntmCadastarNovoCliente.setBorder(null);
		mnCadstros.add(mntmCadastarNovoCliente);
		
		mntmCadastrarNovoPet = new JMenuItem("Cadastrar Novo Pet");
		mntmCadastrarNovoPet.setBackground(new Color(255, 255, 255));
		mntmCadastrarNovoPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pCadastro_pet);
			}
		});
		mntmCadastrarNovoPet.setBorder(null);
		mnCadstros.add(mntmCadastrarNovoPet);
		
		JMenu mnConsulta = new JMenu("Consultas");
		mnConsulta.setBackground(Color.WHITE);
		mnConsulta.setForeground(new Color(0, 0, 0));
		menuBar.add(mnConsulta);
		
		JMenuItem mntmAgendarConsulta = new JMenuItem("Agendar Consulta");
		mntmAgendarConsulta.setBackground(new Color(255, 255, 255));
		mntmAgendarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 mostrarPainel(pAgendador);
				
			}
		});
		mntmAgendarConsulta.setBorder(null);
		mnConsulta.add(mntmAgendarConsulta);
		
		mntmCancelarConsulta = new JMenuItem("Cancelar Consulta");
		mntmCancelarConsulta.setBackground(new Color(255, 255, 255));
		mntmCancelarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pCancelador);
			
			}
		});
		mntmCancelarConsulta.setBorder(null);
		mnConsulta.add(mntmCancelarConsulta);
		
		JMenu mnVisualizar = new JMenu("Visualizar");
		mnVisualizar.setBackground(new Color(255, 255, 255));
		mnVisualizar.setForeground(new Color(0, 0, 0));
		menuBar.add(mnVisualizar);
		
		mntmVisualizarClientes = new JMenuItem("Visualizar Clientes");
		mntmVisualizarClientes.setBackground(new Color(255, 255, 255));
		mntmVisualizarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pVisualizador_clientes);
			}
		});
		mntmVisualizarClientes.setBorder(null);
		mnVisualizar.add(mntmVisualizarClientes);
		
		mntmVisulizarPets = new JMenuItem("Visulizar Pets");
		mntmVisulizarPets.setBackground(new Color(255, 255, 255));
		mntmVisulizarPets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pVisualizador_pets);
			}
		});
		mntmVisulizarPets.setBorder(null);
		mnVisualizar.add(mntmVisulizarPets);
		
		mntmVisualizarConsultas = new JMenuItem("Visualizar Consultas");
		mntmVisualizarConsultas.setBackground(new Color(255, 255, 255));
		mntmVisualizarConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pVisualizador_consultas);
			
			}
		});
		mntmVisualizarConsultas.setBorder(null);
		mnVisualizar.add(mntmVisualizarConsultas);
		
		JMenu mnRemover = new JMenu("Remover");
		mnRemover.setBackground(Color.WHITE);
		mnRemover.setForeground(new Color(0, 0, 0));
		menuBar.add(mnRemover);
		
		JMenuItem mntmRemoverCliente = new JMenuItem("Remover Cliente");
		mntmRemoverCliente.setBackground(new Color(255, 255, 255));
		mntmRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pRemover_cliente);
			}
		});
		mnRemover.add(mntmRemoverCliente);
		
		JMenuItem mntmRemoverPet = new JMenuItem("Remover Pet");
		mntmRemoverPet.setBackground(new Color(255, 255, 255));
		mntmRemoverPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainel(pRemover_pet);
			}
		});
		mnRemover.add(mntmRemoverPet);
		
		JMenu mnSalvar = new JMenu("Salvar");
		mnSalvar.setForeground(Color.BLACK);
		mnSalvar.setBackground(Color.WHITE);
		menuBar.add(mnSalvar);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar Tudo");
		mntmSalvar.setBackground(Color.WHITE);
		mnSalvar.add(mntmSalvar);
		
		JMenuItem mntmSalvarClientesE = new JMenuItem("Salvar Clientes e Pets");
		mntmSalvarClientesE.setBackground(Color.WHITE);
		mnSalvar.add(mntmSalvarClientesE);
		
		JMenuItem mntmSalvarconsultas = new JMenuItem("Salvar Consultas");
		mntmSalvarconsultas.setBackground(Color.WHITE);
		mnSalvar.add(mntmSalvarconsultas);
		mntmSalvarconsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarInformacoesConsultas();
			}
		});
		mntmSalvarClientesE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvarInformacoesClientes();
			}
		});
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarInformacoesClientes();
				salvarInformacoesConsultas();
			}
		});
		
		// Quando tudo estiver inicializado, recupera as as informações de cadastros
		
		// Pega clientes:
		try {
			File pastaRegistros = new File("registros");
			pastaRegistros.mkdir();
			
			File pastaClientes = new File("registros/clientes");
			pastaClientes.mkdir();
			
			f_clientes = new File("registros/clientes.txt");
			f_clientes.createNewFile();

			FileReader fr_clientes = new FileReader(f_clientes);
			BufferedReader br_clientes = new BufferedReader(fr_clientes);
			
			String linha;
			
			while((linha = br_clientes.readLine()) != null) {
				File file_cliente = new File("registros/clientes/" + linha + ".txt");
				file_cliente.createNewFile();
				
				FileReader fr = new FileReader(file_cliente);
				BufferedReader br =  new BufferedReader(fr);
				
				String nome = br.readLine();
				String cpf = br.readLine();
				String email = br.readLine();
				int telefone = Integer.parseInt(br.readLine());
				
				Cliente donoPet = new Cliente(nome, cpf, email, telefone);
				
				int petsCadastrados = Integer.parseInt(br.readLine());
				limparTodasComboBoxPet();
				for (int i = 0; i < petsCadastrados; i++) {
					String nomePet = br.readLine();
					int idadePet = Integer.parseInt(br.readLine());
					String especiePet = br.readLine();
					String racaPet = br.readLine();
					donoPet.cadastrarPet(nomePet, idadePet, especiePet, racaPet);
					adicionarEmTodasComboBox(new Pet(nomePet, donoPet.getPetsCadastrados()-1, idadePet, especiePet, racaPet));
					
				}
				br.close();
				fr.close();
				clientes.add(donoPet);
				adicionarEmTodasComboBox(donoPet);
				
			}
			br_clientes.close();
			fr_clientes.close();
			
			// Pega consultas:
			f_consultas = new File("registros/consultas.txt");
			f_consultas.createNewFile();

			
			FileReader fr_consultas = new FileReader(f_consultas);
			BufferedReader br_consultas = new BufferedReader(fr_consultas);
			
			linha = "";
			
			while((linha = br_consultas.readLine()) != null) {
				String[] val = linha.split(" ");
				int hora = Integer.parseInt(val[0]);
				int minuto = Integer.parseInt(val[1]);
				int dia = Integer.parseInt(val[2]);
				int mes = Integer.parseInt(val[3]);
				int ano = Integer.parseInt(val[4]);
				String veterinario = val[5];
				String cpf = val[6];
				int cadastroPet = Integer.parseInt(val[7]); 
				Cliente cliente = null;
				Pet pet = null;
				for (int i = 0; i < clientes.size(); i++) {
					if(clientes.get(i).getCpf().equals(cpf)) {
						cliente = clientes.get(i);
						pet = clientes.get(i).getPets().get(cadastroPet);
					}
				}
				
				Data data = new Data(minuto, hora, dia, mes, ano);
				
				Consulta consulta = new Consulta(data, veterinario, cliente, pet);
				
				consultasAgendadas.add(consulta);
				comboBox_consulta_cancelador.addItem(consulta);
				textArea_VisualizarConsultas.append(consulta.formatar());
				
			}
			
			br_consultas.close();
			fr_consultas.close();
			
		} catch (Exception e) {
			
		}
		
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
