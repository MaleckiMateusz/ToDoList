import java.awt.Dimension;

import javax.swing.*;

public class delPanel {
	public String delPane() {
		String score = "1";
		
		JPanel delPanel = new JPanel();
		
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
		spinner.setPreferredSize(new Dimension(50,30));
		delPanel.add(spinner);
		
		int result = JOptionPane.showConfirmDialog(null, delPanel, "bbb", JOptionPane.OK_CANCEL_OPTION);
		
		if (result == JOptionPane.OK_OPTION)
			score = spinner.getValue().toString();
			
		return score;
	}
}
