package net.fabioalmeida.ferramentas.client;

import net.fabioalmeida.ferramentas.util.Cpf;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Principal extends Composite {
	private Label lblNewLabel;
	private DockPanel dockPanel;
	private AbsolutePanel absolutePanel;
	private AbsolutePanel panelMenuEsquerdo;
	private DeckPanel deckPanel;
	private StackPanel stackPanel;
	private VerticalPanel verticalPanel;
	private Button btnGeradorCpf;
	private AbsolutePanel panelGeradores;
	private TextBox cpfParaValidar;
	private Button btnNewButton;
	private Label lblNewLabel_1;
	private AbsolutePanel absolutePanel_1;
	private InlineHTML nlnhtmlNewInlinehtml;
	private AbsolutePanel panelCentro;

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
		
		btnGeradorCpf = new Button("Gerador CPF");
		btnGeradorCpf.setText("CPF / CNPJ");
		verticalPanel.add(btnGeradorCpf);
		btnGeradorCpf.setWidth("100%");
		verticalPanel.setCellHorizontalAlignment(btnGeradorCpf, HasHorizontalAlignment.ALIGN_CENTER);
		
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
		
		cpfParaValidar = new TextBox();
		panelGeradores.add(cpfParaValidar, 133, 61);
		
		btnNewButton = new Button("New button");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String scpf = cpfParaValidar.getText();
				Cpf cpf = new Cpf(scpf);
				boolean b = cpf.isCpf();
				if (b) {
					Window.alert("cpf válido");
				} else {
					Window.alert("cpf inválido");
				}
				
			}
		});
		btnNewButton.setText("Validar CPF");
		panelGeradores.add(btnNewButton, 28, 65);
		
		lblNewLabel = new Label("CPF / CNPJ");
		panelGeradores.add(lblNewLabel, 10, 10);
		lblNewLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		lblNewLabel.setStyleName("fan-label-titulo");
		lblNewLabel.setSize("770px", "19px");
		deckPanel.showWidget(0);
	}
}
