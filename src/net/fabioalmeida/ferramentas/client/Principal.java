package net.fabioalmeida.ferramentas.client;


import net.fabioalmeida.ferramentas.util.Cnpj;
import net.fabioalmeida.ferramentas.util.Cpf;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Principal extends Composite {
	private Label lblNewLabel;
	private DockPanel dockPanel;
	private AbsolutePanel absolutePanel;
	private AbsolutePanel panelMenuEsquerdo;
	private DeckPanel deckPanel;
	private StackPanel stackPanel;
	private VerticalPanel verticalPanel;
	private Button geraCpfButton;
	private AbsolutePanel panelGeradores;
	private TextBox cpfParaValidarTextBox;
	private Button validarCpfButton;
	private Label lblNewLabel_1;
	private AbsolutePanel absolutePanel_1;
	private InlineHTML nlnhtmlNewInlinehtml;
	private AbsolutePanel panelCentro;
	private Button gerarCpfButton;
	private TextBox cpfGeradoTextBox;
	private Label respostaCpfLabel;
	private Button validarCnpjButton;
	private Button gerarCnpjButton;
	private TextBox cnpjValidarTextBox;
	private Label respostaCnpjLabel;
	private TextBox cnpjGeradoTextBox;

	public Principal() {
		
		dockPanel = new DockPanel();
		dockPanel.setStyleName("fan-dockPanel-principal");
		initWidget(dockPanel);
		dockPanel.setSize("950px", "1000px");
		
		absolutePanel = new AbsolutePanel();
		dockPanel.add(absolutePanel, DockPanel.NORTH);
		dockPanel.setCellHeight(absolutePanel, "90px");
		absolutePanel.setHeight("90px");
		
		lblNewLabel_1 = new Label("Ferramentas");
		lblNewLabel_1.setStyleName("fan-Label-Titulo");
		absolutePanel.add(lblNewLabel_1, 10, 10);
		
		absolutePanel_1 = new AbsolutePanel();
		absolutePanel_1.setStyleName("fan-titulo-menu");
		absolutePanel.add(absolutePanel_1, 0, 62);
		absolutePanel_1.setSize("950px", "28px");
		
		nlnhtmlNewInlinehtml = new InlineHTML("<a class=\"fan-link\" href=\"http://fabioalmeida.net\">Fábio Almeida</a>");
		nlnhtmlNewInlinehtml.setStyleName("fan-InlineHTML");
		absolutePanel_1.add(nlnhtmlNewInlinehtml, 829, 10);
		
		panelMenuEsquerdo = new AbsolutePanel();
		panelMenuEsquerdo.setStyleName("fan-menu-esquerda");
		dockPanel.add(panelMenuEsquerdo, DockPanel.WEST);
		dockPanel.setCellWidth(panelMenuEsquerdo, "160px");
		panelMenuEsquerdo.setSize("160px", "910px");
		
		stackPanel = new StackPanel();
		panelMenuEsquerdo.add(stackPanel, 0, 0);
		stackPanel.setSize("156px", "908px");
		
		verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("body");
		stackPanel.add(verticalPanel, "Ferramentas", false);
		verticalPanel.setSize("100%", "100%");
		
		geraCpfButton = new Button("Gerador CPF");
		geraCpfButton.setText("CPF / CNPJ");
		verticalPanel.add(geraCpfButton);
		geraCpfButton.setWidth("100%");
		verticalPanel.setCellHorizontalAlignment(geraCpfButton, HasHorizontalAlignment.ALIGN_CENTER);
		
		panelCentro = new AbsolutePanel();
		dockPanel.add(panelCentro, DockPanel.CENTER);
		panelCentro.setSize("790px", "910px");
		
		deckPanel = new DeckPanel();
		panelCentro.add(deckPanel);
		deckPanel.setStyleName("fan-deckPanel-centro");
		deckPanel.setSize("790px", "100%");
		
		panelGeradores = new AbsolutePanel();
		panelGeradores.setStyleName("fan-dockPanel-principal");
		deckPanel.add(panelGeradores);
		
		cpfParaValidarTextBox = new TextBox();
		panelGeradores.add(cpfParaValidarTextBox, 133, 61);
		
		validarCpfButton = new Button("New button");
		validarCpfButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String scpf = cpfParaValidarTextBox.getText();
				Cpf cpf = new Cpf(scpf);
				boolean b = cpf.valido();
				if (b) {
					respostaCpfLabel.setText("cpf válido");
				} else {
					respostaCpfLabel.setText("cpf inválido");
				}
				
			}
		});
		validarCpfButton.setText("Validar CPF");
		panelGeradores.add(validarCpfButton, 28, 65);
		validarCpfButton.setSize("93px", "25px");
		
		lblNewLabel = new Label("CPF / CNPJ");
		panelGeradores.add(lblNewLabel, 10, 10);
		lblNewLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		lblNewLabel.setStyleName("fan-label-titulo");
		lblNewLabel.setSize("770px", "19px");
		
		gerarCpfButton = new Button("Gerar CPF");
		gerarCpfButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Cpf cpf = new Cpf();
				cpfGeradoTextBox.setText(cpf.toString());
			}
		});
		panelGeradores.add(gerarCpfButton, 28, 108);
		gerarCpfButton.setSize("93px", "25px");
		
		cpfGeradoTextBox = new TextBox();
		panelGeradores.add(cpfGeradoTextBox, 133, 106);
		
		respostaCpfLabel = new Label(">                    ");
		respostaCpfLabel.setStyleName("fan-resposta-Label");
		panelGeradores.add(respostaCpfLabel, 319, 69);
		
		validarCnpjButton = new Button("Validar CNPJ");
		validarCnpjButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String scnpj = cnpjValidarTextBox.getText();
				Cnpj cnpj = new Cnpj(scnpj);
				boolean b = cnpj.valido();
				if (b) {
					respostaCnpjLabel.setText("cnpj válido");
				} else {
					respostaCnpjLabel.setText("cnpj inválido");
				}
				
			}
		});
		panelGeradores.add(validarCnpjButton, 28, 167);
		
		gerarCnpjButton = new Button("Gerar CNPJ");
		gerarCnpjButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Cnpj cnpj = new Cnpj();
				String scnpj = cnpj.toString();
				cnpjGeradoTextBox.setText(scnpj);
			}
		});
		panelGeradores.add(gerarCnpjButton, 28, 211);
		gerarCnpjButton.setSize("93px", "25px");
		
		cnpjValidarTextBox = new TextBox();
		panelGeradores.add(cnpjValidarTextBox, 133, 165);
		
		respostaCnpjLabel = new Label(">");
		respostaCnpjLabel.setStyleName("fan-resposta-Label");
		panelGeradores.add(respostaCnpjLabel, 319, 167);
		
		cnpjGeradoTextBox = new TextBox();
		panelGeradores.add(cnpjGeradoTextBox, 133, 209);
		deckPanel.showWidget(0);
	}
}
