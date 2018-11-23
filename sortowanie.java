import javax.swing.DefaultListModel;
import javax.swing.JList;
	
public class sortowanie {
	
	static DefaultListModel model3 = new DefaultListModel();
	static int counterDate = 0;
	
	public static void main(String[] args) {
		model3.addElement("11");
		model3.addElement("22");
		model3.addElement("33");
		model3.addElement("44");
		model3.addElement("55");
		model3.addElement("66");
		model3.addElement("77");
		sortDate(model3);
		System.out.println(model3);
		for (int i=0;i<counterDate;i++) {
			System.out.println(model3.getElementAt(i));
		}
	}
	
	private static void sortDate(DefaultListModel mod) {
		// IMPORTANT EXAMPLE		
		counterDate = model3.getSize();
		String[] arrayStringDate = new String[counterDate];
		
		for (int i = 0; i < counterDate; i++)
			arrayStringDate[i] = (String) model3.remove(0);
		
		int n = counterDate;
		do {
			for(int i=0; i<n-1; i++) {
				if(Integer.parseInt(arrayStringDate[i]) > Integer.parseInt(arrayStringDate[i+1])) {
					String temp = arrayStringDate[i];
					arrayStringDate[i] = arrayStringDate[i+1];
					arrayStringDate[i+1] = temp;
				}
			}
			n = n-1;
		} while( n>1 );
		
		for (int i = 0; i < counterDate; i++)
			model3.addElement(arrayStringDate[i]);
		
	}
}
