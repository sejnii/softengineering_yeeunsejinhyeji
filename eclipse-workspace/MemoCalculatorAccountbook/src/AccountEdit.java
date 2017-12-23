import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;



public class AccountEdit
{

	
	public JTextField account_item_textfield = new JTextField();

	////////////세진 추가2///////////////
	public static void editfile(int edit_index, String modify_account_date, String modify_account_item, String modify_account_price)
	{
		try{
		Writer date_txt_writer;
		Writer item_txt_writer;
		Writer price_txt_writer;
		
			date_txt_writer = new BufferedWriter(new FileWriter("accountdate.txt"));
			item_txt_writer = new BufferedWriter(new FileWriter("accountitem.txt"));
			price_txt_writer = new BufferedWriter(new FileWriter("accountprice.txt"));

		
		
		int size = AccountMain.account_date.size();
		for(int i=0;i<size;i++){
			if(i!=edit_index)
					date_txt_writer.write(AccountMain.account_date.elementAt(i)+"\r\n");
				
			else if(i==edit_index)
				date_txt_writer.write(modify_account_date+"\r\n");
		}
		
		for(int i=0;i<size;i++){
			if(i!=edit_index)
					item_txt_writer.write(AccountMain.account_item.elementAt(i)+"\r\n");
				
			else if(i==edit_index)
				item_txt_writer.write(modify_account_item+"\r\n");
		}
		
		for(int i=0;i<size;i++){
			if(i!=edit_index)
				 	price_txt_writer.write(AccountMain.account_price.elementAt(i)+"\r\n");
				
			else if(i==edit_index)
				price_txt_writer.write(modify_account_price+"\r\n");
		}
		
		
		date_txt_writer.close();
		item_txt_writer.close();
		price_txt_writer.close();

		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public AccountEdit(int edit_index) 
	{
		
		JFrame account_modify_frame = new JFrame("Modify");
		JLabel acoount_modify_main_label = new JLabel("Rewrite the transaction history");
		JButton account_modify_yes_btn = new JButton("Modify");
		JButton account_modify_no_btn = new JButton("Cancel");
		
		JLabel account_modify_date_label = new JLabel("Rewrite the date(year, Month, Day)");
		JLabel account_modify_item_label = new JLabel("Rewrite the item name");
		JLabel account_modify_price_label = new JLabel("Rewrite the price");
		JFormattedDateTextField account_date_textfield = new JFormattedDateTextField();
		JTextField account_price_textfield2 = new JTextField();
		
		
		String origin_date, origin_item;
		String origin_price;

		origin_date = AccountMain.getAccountDate(edit_index);
		origin_item = AccountMain.getAccountItem(edit_index);
		origin_price = AccountMain.getAccountPrice(edit_index);
		
	
		
		
		System.out.println(origin_item);
		System.out.println(origin_price);
		account_date_textfield.setValue(origin_date);
		account_item_textfield.setDocument(new JTextFieldLimit(20));
		account_price_textfield2.setDocument(new JTextFieldLimit(7));
		account_item_textfield.setText(""+origin_item);
		
		account_price_textfield2.setText(""+origin_price);
		
		
		
		account_price_textfield2.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				if ( !(  (c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)  )  )    // 
				{
					JOptionPane.showMessageDialog(null, "Please Enter Valid");
					this.keyTyped(null);
				}
			}
		});
		
		account_modify_yes_btn.addMouseListener(new MouseListener()
		{
				public void mouseClicked(MouseEvent e)
				{

		//			int index;
					int account_modify_yes_int = JOptionPane.showConfirmDialog(null,"Are you sure to modify this?", "Modify confirm", JOptionPane.YES_NO_OPTION);
					if (account_modify_yes_int == JOptionPane.YES_OPTION)
					{		
		//				AccountMain account_main = new AccountMain();
						
					String modify_account_date, modify_account_item;
					String modify_account_price;
					modify_account_item=account_item_textfield.getText();
					modify_account_price=account_price_textfield2.getText();
					modify_account_date=account_date_textfield.getText();
					/*
					
					
					AccountMain.setAccountDate(edit_index, modify_account_date);
					AccountMain.setAccountItem(edit_index, modify_account_item);
					AccountMain.setAccountPrice(edit_index, modify_account_price);
				*/
					
					
					
					////////////세진 수정2///////////////
					
					editfile(edit_index, modify_account_date, modify_account_item, modify_account_price);
					////////////여기까지////////////////////
					}
					else
					{
						JOptionPane.showMessageDialog(null, "fail");
					
				
					}
					
					////////////세진 수정2///////////////
					account_modify_frame.setVisible(false);
					account_modify_frame.dispose();
					AccountMain.dispose();
					new AccountMain();
									/////////////////여기까지/////////////////
				}
				
				
				
				
				

				
				
				////////////////////////여기까지/////////////////////////////
				
				
				
				
				@Override
				public void mouseEntered(MouseEvent e) 
				{
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseExited(MouseEvent e)
				{
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mousePressed(MouseEvent e)
				{
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseReleased(MouseEvent e)
				{
					// TODO Auto-generated method stub
					
				}
				
		});
		
		
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

		/*
		
		*/
		account_modify_frame.add(account_modify_yes_btn);
		account_modify_frame.setVisible(true);
		
		////////////세진 수정2///////////////
		account_modify_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
		//////////////////여기까지///////////////
	}
	
	
	@SuppressWarnings("serial")
	class JTextFieldLimit extends PlainDocument {
		  private int limit;
		  JTextFieldLimit(int limit) {
		    super();
		    this.limit = limit;
		  }

		  JTextFieldLimit(int limit, boolean upper) {
		    super();
		    this.limit = limit;
		  }

		  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		    if (str == null)
		      return;

		    if ((getLength() + str.length()) <= limit) {
		      super.insertString(offset, str, attr);
		    }
		  }
		}
}
