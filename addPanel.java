import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class addPanel {
	public String addPanell() {
		JSpinner spinner;
		String str = "";
		JPanel addPanel = new JPanel();
		addPanel.setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.insets = new Insets(5,5,5,5);
		gridConstraints.anchor = GridBagConstraints.CENTER;
		gridConstraints.fill = GridBagConstraints.BOTH;
		
		//description
			JTextField description = new JTextField(15);
			gridConstraints.gridx = 1;
			gridConstraints.gridy = 1;
			addPanel.add(new JLabel("description:"), gridConstraints);
			gridConstraints.gridx = 2;	
			gridConstraints.gridy = 1;
			addPanel.add(description, gridConstraints);
		//description
		 
		//priority
			JComboBox favoriteShows;
			String[] shows = {"  1", "  2", "  3"};
			favoriteShows = new JComboBox(shows);
			favoriteShows.setSelectedIndex(2);
			gridConstraints.gridx = 1;
			gridConstraints.gridy = 2;
			addPanel.add(new JLabel("priority:"), gridConstraints);
			gridConstraints.gridx = 2;
			addPanel.add(favoriteShows, gridConstraints);
		//priority
		
		//date
			Date todaysDate = new Date();
			spinner = new JSpinner(new SpinnerDateModel(todaysDate, null, null,
			        Calendar.DAY_OF_MONTH));
			JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "dd/MM/yy");
			spinner.setEditor(dateEditor);
			gridConstraints.gridx = 1;
			gridConstraints.gridy = 3;
			addPanel.add(new JLabel("Date:"), gridConstraints);
			gridConstraints.gridx = 2;
			addPanel.add(spinner, gridConstraints);
		//date
		
		//day recurrence
			JTextField recurrence = new JTextField(5);			
			recurrence.setText("0");
			gridConstraints.gridx = 1;
			gridConstraints.gridy = 4;
			addPanel.add(new JLabel("Number days recurrence:"), gridConstraints);
			gridConstraints.gridx = 2;
			addPanel.add(recurrence, gridConstraints);
		//day recurrence
		
		int result = JOptionPane.showConfirmDialog(null, addPanel, 
		         "Add task", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			task t1 = new task(description.getText(),favoriteShows.getSelectedIndex()+1, spinner, recurrence.getText());
			str = Integer.toString(t1.getPriority()) + " " + t1.getDate() + " " + Integer.toString(t1.getRecurrence()) + " " + t1.getDescription();
		}	
		return str;
	}
}
