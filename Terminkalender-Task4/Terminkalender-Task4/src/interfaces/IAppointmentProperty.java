package interfaces;

import java.util.List;
import javax.swing.JComponent;


public interface IAppointmentProperty {

	public String getValue();
	
	public void setValue();
	
	public String getName();
	
	public List<JComponent> createInputComponents();
}
