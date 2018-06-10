package implementation;

import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import interfaces.IAppointmentProperty;

public class Priority implements IAppointmentProperty {

	public enum PriorityEnum {
	
		None, 
		High,
		Medium,
		Low
	}

	private String value = null;
	private JComboBox<String> inputComponent = null;
	
	@Override
	public String getValue() {

		return this.value;
	}

	@Override
	public void setValue() {
		
		this.value = inputComponent.getSelectedItem().toString();
	}

	@Override
	public String getName() {
		return "Title";
	}

	@Override
	public List<JComponent> createInputComponents() {

		JLabel lblPriority = new JLabel("Priorit\u00E4t:");
			
		JComboBox<String> cbPriority = new JComboBox<>();

		for(PriorityEnum priority : PriorityEnum.values()) {
			
			cbPriority.addItem(priority.toString());
		}
		
		this.inputComponent = cbPriority;
		
		return Arrays.asList(lblPriority, cbPriority);
	}	
}


