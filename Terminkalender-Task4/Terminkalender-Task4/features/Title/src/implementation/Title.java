package implementation;

import java.util.Arrays;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaces.IAppointmentProperty;

public class Title implements IAppointmentProperty {

	private String value = null;
	private JTextField inputComponent = null;
	
	@Override
	public String getValue() {

		return this.value;
	}

	@Override
	public void setValue() {
		
		this.value = inputComponent.getText();
	}

	@Override
	public String getName() {
		return "Title";
	}
	
	@Override
	public List<JComponent> createInputComponents() {

		JLabel lblTitle = new JLabel("Titel:");

		
		JTextField tfTitle = new JTextField();
		tfTitle.setColumns(10);
		
		this.inputComponent = tfTitle;
		
		return Arrays.asList(lblTitle, tfTitle);
	}	
}
