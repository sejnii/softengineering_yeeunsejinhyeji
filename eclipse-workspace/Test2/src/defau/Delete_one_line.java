package defau;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Delete_one_line 
{

	public static void main(String[] args) 
	{
		JFrame account_delete_frame = new JFrame("Delete Warning");
		JLabel acoount_delete_warning_message_label = new JLabel("R u sure?");
		JButton account_delete_yes_btn = new JButton("Yes");
		JButton account_delete_no_btn = new JButton("No");
		
		account_delete_frame.setLayout(null);
		account_delete_frame.setBounds(500,300,300, 200);
		
		acoount_delete_warning_message_label.setBounds(50, 10, 100, 50);
		account_delete_yes_btn.setBounds(50, 100, 80, 30);
		account_delete_no_btn.setBounds(150, 100, 80, 30);
		
		account_delete_frame.add(acoount_delete_warning_message_label);
		account_delete_frame.add(account_delete_yes_btn);
		account_delete_frame.add(account_delete_no_btn);
		
		account_delete_frame.setVisible(true);

	}

}
