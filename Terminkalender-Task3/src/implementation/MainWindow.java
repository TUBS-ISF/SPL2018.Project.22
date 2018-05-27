package implementation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainWindow {

	private JFrame frmTerminkalender;
	private JTable tAppointments;
	
	private ArrayList<Appointment> appointments = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmTerminkalender.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//--------------------- Gui initialization --------------------
		frmTerminkalender = new JFrame();
		frmTerminkalender.setTitle("Terminkalender");
		frmTerminkalender.setResizable(false);
		frmTerminkalender.setBounds(100, 100, 450, 300);
		frmTerminkalender.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTerminkalender.getContentPane().setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][]", "[grow][grow][][][][][][][]"));

		tAppointments = new JTable();
		tAppointments.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
				//#ifdef Title
//@				"Titel",
				//#endif
					
				//#ifdef Time
//@				"Zeitpunkt",
				//#endif
					
				//#ifdef Priority
//@				"Priorität"
				//#endif
			}
		));
		
		frmTerminkalender.getContentPane().add(tAppointments, "cell 0 0 14 8,grow");
		
		//------------------ Configuration evaluation -----------------
		
		//#ifdef Add
		JButton btnAdd = new JButton("Add");
		frmTerminkalender.getContentPane().add(btnAdd, "cell 11 8");
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CreateAppointmentDialog dialog = new CreateAppointmentDialog();
				dialog.setVisible(true);
				
				dialog.addWindowListener(new WindowListener() {
					
					@Override
					public void windowClosed(WindowEvent e) {
						
						appointments.add(dialog.getCreatedAppointment());
						updateTable();
					}

					@Override
					public void windowActivated(WindowEvent arg0) {

					}

					@Override
					public void windowClosing(WindowEvent arg0) {

					}

					@Override
					public void windowDeactivated(WindowEvent arg0) {

					}

					@Override
					public void windowDeiconified(WindowEvent arg0) {

					}

					@Override
					public void windowIconified(WindowEvent arg0) {

					}

					@Override
					public void windowOpened(WindowEvent arg0) {

					}
				});
			}
		});
		//#endif
		
		//#ifdef Edit
//@		JButton btnEdit = new JButton("Edit");
//@		frmTerminkalender.getContentPane().add(btnEdit, "cell 12 8");
//@		
//@		btnEdit.addActionListener(new ActionListener() {
//@			
//@			@Override
//@			public void actionPerformed(ActionEvent e) {
//@
//@				int selectedIndex = tAppointments.getSelectedRow();
//@				
//@				if(selectedIndex < appointments.size() && selectedIndex > -1) {
//@				
//@					Appointment appointment = appointments.get(selectedIndex);
//@					
//@					CreateAppointmentDialog dialog = new CreateAppointmentDialog(appointment);
//@					dialog.setVisible(true);
//@					
//@					dialog.addWindowListener(new WindowListener() {
//@						
//@						@Override
//@						public void windowClosed(WindowEvent e) {
//@				
//@							updateTable();
//@						}
//@
//@						@Override
//@						public void windowActivated(WindowEvent arg0) {
//@
//@						}
//@
//@						@Override
//@						public void windowClosing(WindowEvent arg0) {
//@
//@						}
//@
//@						@Override
//@						public void windowDeactivated(WindowEvent arg0) {
//@
//@						}
//@
//@						@Override
//@						public void windowDeiconified(WindowEvent arg0) {
//@
//@						}
//@
//@						@Override
//@						public void windowIconified(WindowEvent arg0) {
//@
//@						}
//@
//@						@Override
//@						public void windowOpened(WindowEvent arg0) {
//@
//@						}
//@					});
//@				}
//@			}
//@		});
		//#endif
		
		//#ifdef Delete
		JButton btnDelete = new JButton("Delete");
		frmTerminkalender.getContentPane().add(btnDelete, "cell 13 8");
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = tAppointments.getSelectedRow();
				
				if(selectedIndex < appointments.size() && selectedIndex > -1) {
					
					appointments.remove(selectedIndex);
					updateTable();
				}
			}
		});
		//#endif
	}
	
	private void updateTable() {
		
		DefaultTableModel model = (DefaultTableModel) tAppointments.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			
			model.removeRow(i);
		}
		
		for(Appointment appointment : appointments) {
			
			model.addRow(new Object[]{
					
					//#ifdef Title
//@					appointment.getTitle(), 
					//#endif
					
					//#ifdef Time
//@					appointment.getTime(),
					//#endif
					
					//#ifdef Priority
//@					appointment.getPriority().toString();
					//#endif
			});
		}
	}
}
