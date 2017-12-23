package defau;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Modify_one_line
{

	public static void main(String[] args) 
	{

		JFrame account_modify_frame = new JFrame("Modify");
		JLabel acoount_modify_main_label = new JLabel("Rewrite the transaction history");
		JButton account_modify_yes_btn = new JButton("Modify");
		JButton account_modify_no_btn = new JButton("Cancel");
		
		JLabel account_modify_date_label = new JLabel("Rewrite the date(year, Month, Day)");
		JLabel account_modify_item_label = new JLabel("Rewrite the item name");
		JLabel account_modify_price_label = new JLabel("Rewrite the price");
		JFormattedDateTextField account_date_textfield = new JFormattedDateTextField();
		JFormattedTextField account_item_textfield = new JFormattedTextField();

		JFormattedTextField account_price_textfield2 = new JFormattedTextField();

	//	account_date_textfield.setText(t);
		
		account_modify_frame.setLayout(null);
		account_modify_frame.setBounds(500,100,400,600);
		
		acoount_modify_main_label.setBounds(50, 10, 300, 50);
		account_modify_yes_btn.setBounds(50, 450, 100, 30);
		account_modify_no_btn.setBounds(200, 450, 100, 30);
		
		account_modify_frame.add(acoount_modify_main_label);
		account_modify_frame.add(account_modify_yes_btn);
		account_modify_frame.add(account_modify_no_btn);
		
		account_modify_frame.setVisible(true);
		
		
		account_modify_frame.setLayout(null);
		account_modify_frame.setBounds(500,100,400,800);
		
		acoount_modify_main_label.setBounds(10, 10, 300, 50);
		account_modify_date_label.setBounds(10, 80, 300, 35);
		account_modify_item_label.setBounds(10, 150, 300, 35);
		account_modify_price_label.setBounds(10, 250, 300, 35);
	
		account_date_textfield.setBounds(10, 110, 300, 35);
		account_item_textfield.setBounds(10, 180, 300, 35);
	

		account_price_textfield2.setBounds(10,340,300, 35);
		account_modify_yes_btn.setBounds(50, 450, 100, 30);

		account_modify_frame.add(acoount_modify_main_label);
		account_modify_frame.add(account_modify_date_label);
		account_modify_frame.add(account_date_textfield);
		account_modify_frame.add(account_modify_item_label);
		account_modify_frame.add(account_item_textfield);
		account_modify_frame.add(account_modify_price_label);

		account_modify_frame.add(account_price_textfield2);

		
		account_item_textfield.setDocument(new JTextFieldLimit(20));
		account_price_textfield2.setDocument(new JTextFieldLimit(7));
		
		account_modify_frame.add(account_modify_yes_btn);
		account_modify_frame.setVisible(true);

	}

}
