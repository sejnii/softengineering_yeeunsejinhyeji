package defau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Add_account_history 	//Class AccountWrite
{
	public static Vector <String> account_date = null;
	public static void setAccountDate(int edit_index, String edit_date) throws ParseException
	{

	//	Vector <String> account_date;
	//	SimpleDateFormat account_date_sdf = new SimpleDateFormat("yyyy/MM/dd");
	 //   Date account_date_date=null;
  //    sdf.applyPattern("yyyy/MM/dd");
	 //    edit_date = account_date_sdf.format(account_date_date);
	//	DateFormat account_date_dateformat = new SimpleDateFormat("dd/MM/yyyy");
	//	String account_date_string = account_date_dateformat.format(new Date(20100000+edit_index*1000));
	//	account_date_string="init_date"+edit_index+"th";
		DateFormat account_date_format = new SimpleDateFormat("yyyy/MM/dd");
		Date account_date_date = account_date_format.parse(edit_date);

		account_date.add(edit_index, account_date_format.format(account_date_date));
		System.out.println(account_date.get(edit_index));
/*	
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		JFormattedTextField txtDate = new JFormattedTextField(df);
		txtDate .addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      if (!((c >= '0') && (c <= '9') ||
		         (c == KeyEvent.VK_BACK_SPACE) ||
		         (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))        
		      {
		        JOptionPane.showMessageDialog(null, "Please Enter Valid");
		        e.consume();
		      }
		    }
		  });
		account_date.add(edit_index, edit_date);
*/
	}

	public static void main(String[] args) throws ParseException 	//public AccountWrite()	//생성자
	{

		int account_add_index = 0;	//나중에 Main 함수에서 add함수 호출횟수 -delete함수 호출 횟수
		
		Date account_date = new Date();
		DateFormat account_dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		
		JFrame account_add_frame = new JFrame("Add Transaction History");
		JLabel acoount_add_main_label = new JLabel("Add Transaction History");
		JLabel account_add_date_label = new JLabel("Enter the date(year, Month, Day)");
		JLabel account_add_item_label = new JLabel("Enter the item name");
		JLabel account_add_price_label = new JLabel("Enter the price");
		JFormattedTextField account_date_textfield = new JFormattedTextField();
		JButton account_add_yes_btn = new JButton("Save");

	
		
		account_date_textfield.setText(account_dateFormat.format(account_date));
		//setAccountDate(int, string)
		//마우스 버튼 클릭 -> 이벤트 클릭:set호출(입력된 값이 벡터로 들어가)

			account_date_textfield.addKeyListener(new KeyAdapter()
		{
			

		    public void keyTyped(KeyEvent e)
		    {
		      char c = e.getKeyChar();
		  
		      if ( !(  (c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)  )  )    // 
		      {
		        JOptionPane.showMessageDialog(null, "Please Enter Valid");
		   //     account_date_textfield.setText(account_dateFormat.format(account_date));
		        //e.consume();
		      }
      
		    }
		    
		  });

			
	/*	 account_add_yes_btn.addActionListener(new ActionListener(){
			   @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae)
			   {
				   
				   setAccountDate(account_add_index,account_date_textfield.getText());

	/*			   try 
				   {
					   
					   setAccountDate(account_add_index,account_date_textfield.getText());
					   
					   
				   } 
				   catch (ParseException e) 
				   {
					// TODO Auto-generated catch block
					   e.printStackTrace();
				   }
				   
			  //    account_date_textfield.setText(account_date_textfield.getText());
			      
			
			      // .... do some operation on value ...
			   }
			});
	*/	 
	//	setAccountDate(account_add_index,account_date_textfield.);
	//	System.out.println(account_date.get(account_add_index));
		
		
		
		account_add_frame.setLayout(null);
		account_add_frame.setBounds(500,100,400,600);
		
		
		acoount_add_main_label.setBounds(50, 10, 300, 50);
		account_add_date_label.setBounds(10, 80, 300, 35);
		account_add_item_label.setBounds(10, 150, 300, 35);
		account_add_price_label.setBounds(10, 250, 300, 35);
	
		account_date_textfield.setBounds(10, 100, 300, 35);
		
		account_add_yes_btn.setBounds(50, 450, 100, 30);

		
		account_add_frame.add(acoount_add_main_label);
		account_add_frame.add(account_add_date_label);
		account_add_frame.add(account_date_textfield);
		account_add_frame.add(account_add_item_label);
		account_add_frame.add(account_add_price_label);
		account_add_frame.add(account_add_yes_btn);

		
		account_add_frame.setVisible(true);

	}

}
