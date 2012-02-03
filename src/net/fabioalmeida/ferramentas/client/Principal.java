/*
 *	fan.tools - small tools in java/gwt 
 *	Copyright (C) 2011  Fabio Almeida (http://fabioalmeida.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabioalmeida.ferramentas.client;


import net.fabioalmeida.ferramentas.util.NumeroCnpj;
import net.fabioalmeida.ferramentas.util.NumeroCpf;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
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
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;

public class Principal extends Composite {
	private Label lblNewLabel;
	private DockPanel dockPanel;
	private AbsolutePanel absolutePanel;
	private AbsolutePanel panelMenuEsquerdo;
	private DeckPanel deckPanel;
	private StackPanel stackPanel;
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
	private CheckBox formatadoCheckBox;
	private CheckBox formatadoCpfCheckBox;
	private AbsolutePanel panelStringUtil;
	private Button stringUtilButton;
	private Button stubButton;
	private FlowPanel flowPanel;
	private AbsolutePanel panelStubUtil;
	private Label lblStringUtil;
	private Label lblStubUtil;
	private Button btnTeste;
	private Label lblLabel;
	private TextBox textBox;
	private ToggleButton tglbtnTeste;
	private CheckBox chckbxNewCheckBox;
	private DateBox dateBox;
	private ListBox listBox;

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
		
		flowPanel = new FlowPanel();
		stackPanel.add(flowPanel, "Ferramentas", false);
		flowPanel.setSize("100%", "100%");
		
		geraCpfButton = FanFactory.createButtonMenu("CPF / CNPJ");
		flowPanel.add(geraCpfButton);
		geraCpfButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				deckPanel.showWidget(0);
			}
		});
		
		stringUtilButton = FanFactory.createButtonMenu("String Util");
		stringUtilButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				deckPanel.showWidget(1);
			}
		});
		flowPanel.add(stringUtilButton);
		stringUtilButton.setWidth("145px");
		
		stubButton = FanFactory.createButtonMenu("Stub Util");
		stubButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				deckPanel.showWidget(2);
			}
		});
		flowPanel.add(stubButton);
		stubButton.setWidth("145px");
		
		panelCentro = new AbsolutePanel();
		dockPanel.add(panelCentro, DockPanel.CENTER);
		panelCentro.setSize("790px", "910px");
		
		deckPanel = new DeckPanel();
		deckPanel.setAnimationEnabled(true);
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
				NumeroCpf cpf = new NumeroCpf(scpf);
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
				NumeroCpf cpf = new NumeroCpf();
				if(formatadoCpfCheckBox.getValue()) {
					cpfGeradoTextBox.setText(cpf.formatado());
					
				} else {
					cpfGeradoTextBox.setText(cpf.toString());
					
				}
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
				NumeroCnpj cnpj = new NumeroCnpj(scnpj);
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
				NumeroCnpj cnpj = new NumeroCnpj();
				String scnpj = null;
				if (formatadoCheckBox.getValue()) {
					scnpj = cnpj.formatado();
				} else {
					scnpj = cnpj.toString();
				}
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
		cnpjGeradoTextBox.setName("cnpjgerado");
		panelGeradores.add(cnpjGeradoTextBox, 133, 209);
		
		formatadoCheckBox = new CheckBox("Formatado");
		panelGeradores.add(formatadoCheckBox, 133, 242);
		
		formatadoCpfCheckBox = new CheckBox("Formatado");
		panelGeradores.add(formatadoCpfCheckBox, 133, 137);
		
		btnTeste = FanFactory.createButtonMenu("CPF / CNPJ");
		btnTeste.setHTML("Teste");
		panelGeradores.add(btnTeste, 28, 314);
		
		panelStringUtil = new AbsolutePanel();
		deckPanel.add(panelStringUtil);
		
		lblStringUtil = new Label("String Util");
		lblStringUtil.setStyleName("fan-label-titulo");
		lblStringUtil.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		panelStringUtil.add(lblStringUtil, 10, 10);
		lblStringUtil.setSize("770px", "19px");
		
		panelStubUtil = new AbsolutePanel();
		deckPanel.add(panelStubUtil);
		
		lblStubUtil = new Label("Stub Util");
		lblStubUtil.setStyleName("fan-label-titulo");
		lblStubUtil.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		panelStubUtil.add(lblStubUtil, 10, 10);
		lblStubUtil.setSize("770px", "19px");
		
		lblLabel = new Label("Label");
		panelStubUtil.add(lblLabel, 54, 99);
		
		textBox = new TextBox();
		textBox.setName("meutextbox");
		panelStubUtil.add(textBox, 54, 133);
		
		tglbtnTeste = new ToggleButton("teste");
		panelStubUtil.add(tglbtnTeste, 54, 196);
		
		chckbxNewCheckBox = new CheckBox("New check box");
		panelStubUtil.add(chckbxNewCheckBox, 57, 238);
		
		dateBox = new DateBox();
		panelStubUtil.add(dateBox, 54, 297);
		
		DOM.setElementProperty(dateBox.getElement(), "myid", "datebox");
		
		listBox = new ListBox();
		panelStubUtil.add(listBox, 114, 356);
		listBox.setVisibleItemCount(5);
		deckPanel.showWidget(2);
	}
}
