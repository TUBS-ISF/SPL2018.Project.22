package implementation;

import java.util.Arrays;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interfaces.IAppointmentProperty;

public class Time implements IAppointmentProperty{

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

		JLabel lblTime = new JLabel("Zeitpunkt:");
		
		JTextField tfTime = new JTextField();
		tfTime.setColumns(10);
		
		this.inputComponent = tfTime;
		
		return Arrays.asList(lblTime, tfTime);
	}	
}
