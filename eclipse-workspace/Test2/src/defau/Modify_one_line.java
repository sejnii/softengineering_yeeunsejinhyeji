package defau;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Modify_one_line
{

	public static void main(String[] args) 
	{

		JFrame account_modify_frame = new JFrame("Modify");
		JLabel acoount_modify_message_label = new JLabel("Rewrite the transaction history");
		JButton account_modify_yes_btn = new JButton("Modify");
		JButton account_modify_no_btn = new JButton("Cancel");
		
		account_modify_frame.setLayout(null);
		account_modify_frame.setBounds(500,100,400,600);
		
		acoount_modify_message_label.setBounds(50, 10, 300, 50);
		account_modify_yes_btn.setBounds(50, 450, 100, 30);
		account_modify_no_btn.setBounds(200, 450, 100, 30);
		
		account_modify_frame.add(acoount_modify_message_label);
		account_modify_frame.add(account_modify_yes_btn);
		account_modify_frame.add(account_modify_no_btn);
		
		account_modify_frame.setVisible(true);

	}

}
