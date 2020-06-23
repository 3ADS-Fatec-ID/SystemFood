package Pi;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AlterarFornecedor extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public AlterarFornecedor() {
		setLayout(null);
		setBounds(100, 100, 481, 290);

		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(193, 23, 112, 20);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(193, 54, 112, 20);
		add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(150, 26, 43, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setBounds(148, 57, 46, 14);
		add(lblNewLabel_2);
	
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(193, 82, 112, 20);
		add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ:");
		lblNewLabel_3.setBounds(152, 85, 36, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone:");
		lblNewLabel_4.setBounds(134, 116, 55, 14);
		add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(193, 113, 112, 20);
		add(textField_3);
		
		JLabel lblNewLabel_5 = new JLabel("Cidade:");
		lblNewLabel_5.setBounds(144, 147, 42, 14);
		add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Adamantina", "Adolfo", "Aguai", "Aguas da Prata", "Aguas de Lindoia", "Aguas de Santa Barbara", "Aguas de Sao Pedro", "Agudos", "Alambari", "Alfredo Marcondes", "Altair", "Altinopolis", "Alto Alegre", "Aluminio", "Alvares Florence", "Alvares Machado", "Alvaro de Carvalho", "Alvinlandia", "Americana", "Americo Brasiliense", "Americo de Campos", "Amparo", "Analandia", "Andradina", "Angatuba", "Anhembi", "Anhumas", "Aparecida d'Oeste", "Aparecida", "Apiai", "Aracariguama", "Aracatuba", "Aracoiaba da Serra", "Aramina", "Arandu", "Arapei", "Araraquara", "Araras", "Arco-Iris", "Arealva", "Areias", "Areiopolis", "Ariranha", "Artur Nogueira", "Aruja", "Aspasia", "Assis", "Atibaia", "Auriflama", "Avai", "Avanhandava", "Avare", "Bady Bassitt", "Balbinos", "Balsamo", "Bananal", "Barao de Antonina", "Barbosa", "Bariri", "Barra Bonita", "Barra do Chapeu", "Barra do Turvo", "Barretos", "Barrinha", "Barueri", "Bastos", "Batatais", "Bauru", "Bebedouro", "Bento de Abreu", "Bernardino de Campos", "Bertioga", "Bilac", "Birigui", "Biritiba-Mirim", "Boa Esperanca do Sul", "Bocaina", "Bofete", "Boituva", "Bom Jesus dos Perdoes", "Bom Sucesso de Itarare", "Bora", "Boraceia", "Borborema", "Borebi", "Botucatu", "Braganca Paulista", "Brauna", "Brejo Alegre", "Brodosqui", "Brotas", "Buri", "Buritama", "Buritizal", "Cabralia Paulista", "Cabreuva", "Cacapava", "Cachoeira Paulista", "Caconde", "Cafelandia", "Caiabu", "Caieiras", "Caiua", "Cajamar", "Cajati", "Cajobi", "Cajuru", "Campina do Monte Alegre", "Campinas", "Campo Limpo Paulista", "Campos Novos Paulista", "Campos do Jordao", "Cananeia", "Canas", "Candido Mota", "Candido Rodrigues", "Canitar", "Capao Bonito", "Capela do Alto", "Capivari", "Caraguatatuba", "Carapicuiba", "Cardoso", "Casa Branca", "Cassia dos Coqueiros", "Castilho", "Catanduva", "Catigua", "Cedral", "Cerqueira Cesar", "Cerquilho", "Cesario Lange", "Charqueada", "Chavantes", "Clementina", "Colina", "Colombia", "Conchal", "Conchas", "Cordeiropolis", "Coroados", "Coronel Macedo", "Corumbatai", "Cosmopolis", "Cosmorama", "Cotia", "Cravinhos", "Cristais Paulista", "Cruzalia", "Cruzeiro", "Cubatao", "Cunha", "Descalvado", "Diadema", "Dirce Reis", "Divinolandia", "Dobrada", "Dois Corregos", "Dolcinopolis", "Dourado", "Dracena", "Duartina", "Dumont", "Echapora", "Eldorado", "Elias Fausto", "Elisiario", "Embauba", "Embu", "Embu-Guacu", "Emilianopolis", "Engenheiro Coelho", "Espirito Santo do Pinhal", "Espirito Santo do Turvo", "Estiva Gerbi", "Estrela d'Oeste", "Estrela do Norte", "Euclides da Cunha Paulista", "Fartura", "Fernando Prestes", "Fernandopolis", "Fernao", "Ferraz de Vasconcelos", "Flora Rica", "Floreal", "Florida Paulista", "Florinia", "Franca", "Francisco Morato", "Franco da Rocha", "Gabriel Monteiro", "Galia", "Garca", "Gastao Vidigal", "Gaviao Peixoto", "General Salgado", "Getulina", "Glicerio", "Guaicara", "Guaimbe", "Guaira", "Guapiacu", "Guapiara", "Guara", "Guaracai", "Guaraci", "Guarani d'Oeste", "Guaranta", "Guararapes", "Guararema", "Guaratingueta", "Guarei", "Guariba", "Guaruja", "Guarulhos", "Guatapara", "Guzolandia", "Herculandia", "Holambra", "Hortolandia", "Iacanga", "Iacri", "Iaras", "Ibate", "Ibira", "Ibirarema", "Ibitinga", "Ibiuna", "Icem", "Iepe", "Igaracu do Tiete", "Igarapava", "Igarata", "Iguape", "Ilha Comprida", "Ilha Solteira", "Ilhabela", "Indaiatuba", "Indiana", "Indiapora", "Inubia Paulista", "Ipaucu", "Ipero", "Ipeuna", "Ipigua", "Iporanga", "Ipua", "Iracemapolis", "Irapua", "Irapuru", "Itabera", "Itai", "Itajobi", "Itaju", "Itanhaem", "Itaoca", "Itapecerica da Serra", "Itapetininga", "Itapeva", "Itapevi", "Itapira", "Itapirapua Paulista", "Itapolis", "Itaporanga", "Itapui", "Itapura", "Itaquaquecetuba", "Itarare", "Itariri", "Itatiba", "Itatinga", "Itirapina", "Itirapua", "Itobi", "Itu", "Itupeva", "Ituverava", "Jaborandi", "Jaboticabal", "Jacarei", "Jaci", "Jacupiranga", "Jaguariuna", "Jales", "Jambeiro", "Jandira", "Jardinopolis", "Jarinu", "Jau", "Jeriquara", "Joanopolis", "Joao Ramalho", "Jose Bonifacio", "Julio Mesquita", "Jumirim", "Jundiai", "Junqueiropolis", "Juquia", "Juquitiba", "Lagoinha", "Laranjal Paulista", "Lavinia", "Lavrinhas", "Leme", "Lencois Paulista", "Limeira", "Lindoia", "Lins", "Lorena", "Lourdes", "Louveira", "Lucelia", "Lucianopolis", "Luis Antonio", "Luiziania", "Lupercio", "Lutecia", "Macatuba", "Macaubal", "Macedonia", "Magda", "Mairinque", "Mairipora", "Manduri", "Maraba Paulista", "Maracai", "Marapoama", "Mariapolis", "Marilia", "Marinopolis", "Martinopolis", "Matao", "Maua", "Mendonca", "Meridiano", "Mesopolis", "Miguelopolis", "Mineiros do Tiete", "Mira Estrela", "Miracatu", "Mirandopolis", "Mirante do Paranapanema", "Mirassol", "Mirassolandia", "Mococa", "Mogi Guacu", "Moji das Cruzes", "Moji-Mirim", "Mombuca", "Moncoes", "Mongagua", "Monte Alegre do Sul", "Monte Alto", "Monte Aprazivel", "Monte Azul Paulista", "Monte Castelo", "Monte Mor", "Monteiro Lobato", "Morro Agudo", "Morungaba", "Motuca", "Murutinga do Sul", "Nantes", "Narandiba", "Natividade da Serra", "Nazare Paulista", "Neves Paulista", "Nhandeara", "Nipoa", "Nova Alianca", "Nova Campina", "Nova Canaa Paulista", "Nova Castilho", "Nova Europa", "Nova Granada", "Nova Guataporanga", "Nova Independencia", "Nova Luzitania", "Nova Odessa", "Novais", "Novo Horizonte", "Nuporanga", "Ocaucu", "Oleo", "Olimpia", "Onda Verde", "Oriente", "Orindiuva", "Orlandia", "Osasco", "Oscar Bressane", "Osvaldo Cruz", "Ourinhos", "Ouro Verde", "Ouroeste", "Pacaembu", "Palestina", "Palmares Paulista", "Palmeira d'Oeste", "Palmital", "Panorama", "Paraguacu Paulista", "Paraibuna", "Paraiso", "Paranapanema", "Paranapua", "Parapua", "Pardinho", "Pariquera-Acu", "Parisi", "Patrocinio Paulista", "Pauliceia", "Paulinia", "Paulistania", "Paulo de Faria", "Pederneiras", "Pedra Bela", "Pedranopolis", "Pedregulho", "Pedreira", "Pedrinhas Paulista", "Pedro de Toledo", "Penapolis", "Pereira Barreto", "Pereiras", "Peruibe", "Piacatu", "Piedade", "Pilar do Sul", "Pindamonhangaba", "Pindorama", "Pinhalzinho", "Piquerobi", "Piquete", "Piracaia", "Piracicaba", "Piraju", "Pirajui", "Pirangi", "Pirapora do Bom Jesus", "Pirapozinho", "Pirassununga", "Piratininga", "Pitangueiras", "Planalto", "Platina", "Poa", "Poloni", "Pompeia", "Pongai", "Pontal", "Pontalinda", "Pontes Gestal", "Populina", "Porangaba", "Porto Feliz", "Porto Ferreira", "Potim", "Potirendaba", "Pracinha", "Pradopolis", "Praia Grande", "Pratania", "Presidente Alves", "Presidente Bernardes", "Presidente Epitacio", "Presidente Prudente", "Presidente Venceslau", "Promissao", "Quadra", "Quata", "Queiroz", "Queluz", "Quintana", "Rafard", "Rancharia", "Redencao da Serra", "Regente Feijo", "Reginopolis", "Registro", "Restinga", "Ribeira", "Ribeirao Bonito", "Ribeirao Branco", "Ribeirao Corrente", "Ribeirao Grande", "Ribeirao Pires", "Ribeirao Preto", "Ribeirao do Sul", "Ribeirao dos Indios", "Rifaina", "Rincao", "Rinopolis", "Rio Claro", "Rio Grande da Serra", "Rio das Pedras", "Riolandia", "Riversul", "Rosana", "Roseira", "Rubiacea", "Rubineia", "Sabino", "Sagres", "Sales Oliveira", "Sales", "Salesopolis", "Salmourao", "Saltinho", "Salto Grande", "Salto de Pirapora", "Salto", "Sandovalina", "Santa Adelia", "Santa Albertina", "Santa Barbara d'Oeste", "Santa Branca", "Santa Clara d'Oeste", "Santa Cruz da Conceicao", "Santa Cruz da Esperanca", "Santa Cruz das Palmeiras", "Santa Cruz do Rio Pardo", "Santa Ernestina", "Santa Fe do Sul", "Santa Gertrudes", "Santa Isabel", "Santa Lucia", "Santa Maria da Serra", "Santa Mercedes", "Santa Rita d'Oeste", "Santa Rita do Passa Quatro", "Santa Rosa de Viterbo", "Santa Salete", "Santana da Ponte Pensa", "Santana de Parnaiba", "Santo Anastacio", "Santo Andre", "Santo Antonio da Alegria", "Santo Antonio de Posse", "Santo Antonio do Aracangua", "Santo Antonio do Jardim", "Santo Antonio do Pinhal", "Santo Expedito", "Santopolis do Aguapei", "Santos", "Sao Bento do Sapucai", "Sao Bernardo do Campo", "Sao Caetano do Sul", "Sao Carlos", "Sao Francisco", "Sao Joao da Boa Vista", "Sao Joao das Duas Pontes", "Sao Joao de Iracema", "Sao Joao do Pau d'Alho", "Sao Joaquim da Barra", "Sao Jose da Bela Vista", "Sao Jose do Barreiro", "Sao Jose do Rio Pardo", "Sao Jose do Rio Preto", "Sao Jose dos Campos", "Sao Lourenco da Serra", "Sao Luis do Paraitinga", "Sao Manuel", "Sao Miguel Arcanjo", "Sao Paulo", "Sao Pedro do Turvo", "Sao Pedro", "Sao Roque", "Sao Sebastiao da Grama", "Sao Sebastiao", "Sao Simao", "Sao Vicente", "Sarapui", "Sarutaia", "Sebastianopolis do Sul", "Serra Azul", "Serra Negra", "Serrana", "Sertaozinho", "Sete Barras", "Severinia", "Silveiras", "Socorro", "Sorocaba", "Sud Mennucci", "Sumare", "Suzanapolis", "Suzano", "Tabapua", "Tabatinga", "Taboao da Serra", "Taciba", "Taguai", "Taiacu", "Taiuva", "Tambau", "Tanabi", "Tapirai", "Tapiratiba", "Taquaral", "Taquaritinga", "Taquarituba", "Taquarivai", "Tarabai", "Taruma", "Tatui", "Taubate", "Tejupa", "Teodoro Sampaio", "Terra Roxa", "Tiete", "Timburi", "Torre de Pedra", "Torrinha", "Trabiju", "Tremembe", "Tres Fronteiras", "Tuiuti", "Tupa", "Tupi Paulista", "Turiuba", "Turmalina", "Ubarana", "Ubatuba", "Ubirajara", "Uchoa", "Uniao Paulista", "Urania", "Uru", "Urupes", "Valentim Gentil", "Valinhos", "Valparaiso", "Vargem Grande Paulista", "Vargem Grande do Sul", "Vargem", "Varzea Paulista", "Vera Cruz", "Vinhedo", "Viradouro", "Vista Alegre do Alto", "Vitoria Brasil", "Votorantim", "Votuporanga", "Zacarias"}));
		comboBox.setBounds(193, 143, 112, 22);
		add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(193, 176, 112, 20);
		add(textField_4);
		
		JLabel lblNewLabel = new JLabel("Bairro:");
		lblNewLabel.setBounds(148, 179, 43, 14);
		add(lblNewLabel);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(161, 210, 32, 14);
		add(lblRua);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(193, 207, 112, 20);
		add(textField_5);
		
		JLabel lblNewLabel_6 = new JLabel("CEP:");
		lblNewLabel_6.setBounds(160, 239, 33, 14);
		add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(193, 236, 112, 20);
		add(textField_6);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(325, 128, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChecarFornecedores checar = new ChecarFornecedores();
				Menu.atualizarPainel(checar);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AlterarFornecedor.class.getResource("/Imagens/Voltar.png")));
		btnNewButton_1.setBounds(27, 235, 87, 23);
		add(btnNewButton_1);
		
		JLabel planoFundo = new JLabel("");
		planoFundo.setBounds(0, 0, 481, 290);
		add(planoFundo);

	}
}
