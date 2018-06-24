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
import javax.swing.JRadioButton; 
import java.sql.Date; 
import java.util.Calendar; 

public   class  MainWindow {
	

	private JFrame frmTerminkalender  ;

	
	private JTable tAppointments  ;

	
	
	private ArrayList<Appointment> appointments  = new ArrayList<Appointment>();

	
	
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

	
	
	 private void  initialize__wrappee__Base() {

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
				
				"Titel",
					
				"Zeitpunkt",
					
				"Priorität"
			}
		));
		
		frmTerminkalender.getContentPane().add(tAppointments, "cell 0 0 14 8,grow");
	}

	
	
	 private void  initialize__wrappee__Add() {
		
		initialize__wrappee__Base();
		
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

	}

	
	
	 private void  initialize__wrappee__Delete() {
		
		initialize__wrappee__Add();
		
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
	}

	
	
	 private void  initialize__wrappee__Edit() {
		
		initialize__wrappee__Delete();

		JButton btnEdit = new JButton("Edit");
		frmTerminkalender.getContentPane().add(btnEdit, "cell 12 8");
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedIndex = tAppointments.getSelectedRow();
				
				if(selectedIndex < appointments.size() && selectedIndex > -1) {
				
					Appointment appointment = appointments.get(selectedIndex);
					
					CreateAppointmentDialog dialog = new CreateAppointmentDialog(appointment);
					dialog.setVisible(true);
					
					dialog.addWindowListener(new WindowListener() {
						
						@Override
						public void windowClosed(WindowEvent e) {
				
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
			}
		});
	}

	
	
	 private void  initialize__wrappee__Day() {
		
		initialize__wrappee__Edit();

		JRadioButton rbtnDay = new JRadioButton("Tag");
		
		rbtnDay.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	selectDayOverview();
	        }
	    });
		
		frmTerminkalender.getContentPane().add(rbtnDay, "cell 1 8");
	}

	
	
	 private void  initialize__wrappee__Week() {
		
		initialize__wrappee__Day();

		JRadioButton rbtnWeek = new JRadioButton("Woche");
		
		rbtnWeek.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	selectWeekOverview();
	        }
	    });
		
		frmTerminkalender.getContentPane().add(rbtnWeek, "cell 2 8");
	}

	
	
	private void initialize() {
		
		initialize__wrappee__Week();

		JRadioButton rbtnMonth = new JRadioButton("Monat");
		
		rbtnMonth.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	selectMonthOverview();
	        }
	    });
		
		frmTerminkalender.getContentPane().add(rbtnMonth, "cell 3 8,aligny top");
	}

	
	
	private MainWindow() {
		
		initialize();
	}

	
	
	private void updateTable() {
		
		DefaultTableModel model = (DefaultTableModel) tAppointments.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			
			model.removeRow(i);
		}
		
		for(Appointment appointment : appointments) {
			
			model.addRow(appointment.getData().toArray());
		}
	}

	
	
	private void selectDayOverview() {
		
		DefaultTableModel model = (DefaultTableModel) tAppointments.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			
			model.removeRow(i);
		}
		
		int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		
		for(Appointment appointment : appointments) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(Date.valueOf(appointment.getTime()));
			
			if(cal.get(Calendar.DAY_OF_YEAR) == currentDay) {
				model.addRow(appointment.getData().toArray());
			}	
		}
	}

	
	
	private void selectWeekOverview() {
		
		DefaultTableModel model = (DefaultTableModel) tAppointments.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			
			model.removeRow(i);
		}
		
		int currentWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
		
		for(Appointment appointment : appointments) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(Date.valueOf(appointment.getTime()));
			
			if(cal.get(Calendar.WEEK_OF_YEAR) == currentWeek) {
				model.addRow(appointment.getData().toArray());
			}	
		}
	}

	
	
	private void selectMonthOverview() {
		
		DefaultTableModel model = (DefaultTableModel) tAppointments.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			
			model.removeRow(i);
		}
		
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		
		for(Appointment appointment : appointments) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(Date.valueOf(appointment.getTime()));
			
			if(cal.get(Calendar.MONTH) == currentMonth) {
				model.addRow(appointment.getData().toArray());
			}	
		}
	}


}
