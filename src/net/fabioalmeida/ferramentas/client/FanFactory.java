package net.fabioalmeida.ferramentas.client;
import com.google.gwt.user.client.ui.Button;

public final class FanFactory {
	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source text "CPF / CNPJ"
	 */
	public static Button createButtonMenu(String text) {
		Button button = new Button("Gerador CPF");
		button.setWidth("145px");
		button.setText(text);
		return button;
	}
}