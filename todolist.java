import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class todolist extends JFrame{
	
	JButton butPlus,butMinus;
	int countergol = 0;
	String[] modelA = new String[10];
	final DefaultListModel model1 = new DefaultListModel();
	final DefaultListModel model2 = new DefaultListModel();
	final DefaultListModel model3 = new DefaultListModel();
	final DefaultListModel model1description = new DefaultListModel();
	final DefaultListModel model2description = new DefaultListModel();
	final DefaultListModel model3description = new DefaultListModel();
	JSpinner spinner;
	
	int counterDate1 = 0;
	int counterDate2 = 0;
	int counterDate3 = 0;
	
	public todolist() {
		this.setSize(300,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		listPanel();
		this.setVisible(true);
	}
	
	private void listPanel() {
		
		JPanel thePanel = new JPanel();	
		thePanel.setLayout(new BorderLayout());
		
		JPanel thePanel1 = new JPanel();
		thePanel1.setLayout(new BorderLayout());
		
		JPanel thePanel2 = new JPanel();
		thePanel2.setLayout(new BorderLayout());
		
		
		//button add
			ListenForButton lForBut = new ListenForButton();
			Font  f1  = new Font(Font.SANS_SERIF, Font.PLAIN,  28);
			butPlus = new JButton("+");
			butPlus.setFont(f1);
			butPlus.addActionListener(lForBut);
			butPlus.setPreferredSize(new Dimension(50, 50));
			thePanel1.add(butPlus, BorderLayout.WEST);
		//button add
		
		//date
			String[] month = {"January","February","March","April","May","June",
					"July","August","September","October","November","December"};
			String timeStamp1 = new SimpleDateFormat("dd ").format(Calendar.getInstance().getTime());
			int timeStamp2 = Integer.parseInt(new SimpleDateFormat("MM").format(Calendar.getInstance().getTime()))-1;
			String timeStamp3 = new SimpleDateFormat(" yyyy").format(Calendar.getInstance().getTime());
			JLabel dateLabel = new JLabel(timeStamp1 + month[timeStamp2].toString() + timeStamp3);
			thePanel1.add(dateLabel, BorderLayout.CENTER);
		//date
		
		//button delete
			butMinus = new JButton("-");
			butMinus.setFont(f1);
			butMinus.addActionListener(lForBut);
			butMinus.setPreferredSize(new Dimension(50, 50));
			thePanel1.add(butMinus, BorderLayout.EAST);
		//button delete
			
		//list
			JPanel Panel1 = new JPanel();
			Panel1.setLayout(new BorderLayout());
			final JList listLabel1 = new JList(model1description);
			listLabel1.setBackground(Color.orange);
			Panel1.add(listLabel1, BorderLayout.CENTER);
			
			JPanel Panel2 = new JPanel();
			Panel2.setLayout(new BorderLayout());
			final JList listLabel2 = new JList(model2description);
			listLabel2.setBackground( new Color(240, 240, 0) );
			Panel2.add(listLabel2, BorderLayout.CENTER);
			
			JPanel Panel3 = new JPanel();
			Panel3.setLayout(new BorderLayout());
			
			final JList listLabel3 = new JList(model3description);
			listLabel3.setBackground(Color.lightGray);
			Panel3.add(listLabel3, BorderLayout.CENTER);
			
			thePanel2.add(Panel3, BorderLayout.NORTH);
			Panel3.add(Panel2, BorderLayout.NORTH);
			Panel2.add(Panel1, BorderLayout.NORTH);
		//list
			

		thePanel.add(thePanel1, BorderLayout.NORTH);  // butAdd, date, counter
		thePanel.add(thePanel2, BorderLayout.CENTER); // list
		this.add(thePanel);
	}
	
	public class ListenForButton implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//add task
			if(e.getSource() == butPlus){	
				addPanel tas = new addPanel();
				String napis = tas.addPanell();
				if(napis != "") {
					
					switch (napis.charAt(0)) {
						case '1':
							model1.addElement(napis);
							model1.equals(sortDate(model1, ++counterDate1, 1));
							break;
						case '2':
							model2.addElement(napis);
							model2.equals(sortDate(model2, ++counterDate2, 2));
							break;
						case '3':
							model3.addElement(napis);
							model3.equals(sortDate(model3, ++counterDate3, 3));
							break;
					}
				}
				 
			}
			
			//delete task
			if(e.getSource() == butMinus){	
				delPanel del = new delPanel();
				int delthis = Integer.parseInt(del.delPane());
				if(delthis < model1.getSize()) { 
					model1.removeElementAt(delthis); 
					model1description.removeElementAt(delthis); 
					counterDate1 -= 1;;
				}
				else {
					delthis -= model1.getSize();
					if(delthis < model2.getSize()) { 
						model2.removeElementAt(delthis); 
						model2description.removeElementAt(delthis); 
						counterDate2 -= 1;;
					}
					else {
						delthis -= model1.getSize();
						if(delthis < model3.getSize()) { 
							model3.removeElementAt(delthis); 
							model3description.removeElementAt(delthis); 
							counterDate3 -= 1;;
						}
					}
				}
			}
				
		}

		private DefaultListModel sortDate(DefaultListModel mod, int counterDate, int model) {	
			String[] arrayStringDate = new String[counterDate];
			for (int i = 0; i < counterDate; i++)
				arrayStringDate[i] = (String) mod.remove(0);
			
			int n = counterDate;		
			do {
				for(int i=0; i<n-1; i++) {
					if(Integer.parseInt(arrayStringDate[i].substring(2, 10)) > 
						Integer.parseInt(arrayStringDate[i+1].substring(2, 10))) {
						String temp = arrayStringDate[i];
						arrayStringDate[i] = arrayStringDate[i+1];
						arrayStringDate[i+1] = temp;
					}
				}
				n = n-1;
			} while( n>1 );
			
			switch (model) {
				case 1: model1description.removeAllElements(); break;
				case 2: model2description.removeAllElements(); break;
				case 3: model3description.removeAllElements(); break;
			}
			for (String val : arrayStringDate) {
				mod.addElement(val);
				switch (model) {
				case 1:
					model1description.addElement(val.substring(13, val.length()) + " " + 
							val.substring(8, 10) + "." + val.substring(6, 8) +  "." + 
							val.substring(2, 6));
				break;
				case 2:
					model2description.addElement(val.substring(13, val.length()) + " " + 
							val.substring(8, 10) + "." + val.substring(6, 8) +  "." + 
							val.substring(2, 6));
				break;
				case 3:
					model3description.addElement(val.substring(13, val.length()) + " " + 
							val.substring(8, 10) + "." + val.substring(6, 8) +  "." + 
							val.substring(2, 6));
				break;
				}
			}
			
			return mod;
		}
	}
}
