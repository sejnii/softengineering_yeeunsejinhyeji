import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Vector;

import javax.print.attribute.AttributeSet;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

public class AccountWrite
{
	boolean add_account_confirm_boolean=true;
	
	String add_account_date="";
	String add_account_item="";
	int add_account_price=0;
	JButton account_add_yes_btn = new JButton("Save");
	
	
	public AccountWrite()
	{

		
		JFrame account_add_frame = new JFrame("Add Transaction History");
		JLabel acoount_add_main_label = new JLabel("Add Transaction History");
		JLabel account_add_date_label = new JLabel("Enter the date(year, Month, Day)");
		JLabel account_add_item_label = new JLabel("Enter the item name");
		JLabel account_add_price_label = new JLabel("Enter the price");
		JFormattedDateTextField account_date_textfield = new JFormattedDateTextField();
		JFormattedTextField account_item_textfield = new JFormattedTextField();
		JFormattedPriceTextField account_price_textfield = new JFormattedPriceTextField();
		JFormattedTextField account_price_textfield2 = new JFormattedTextField();


		JLabel add_test_show_label = new JLabel();
		add_test_show_label.setText("Test");
		
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
	
		account_add_yes_btn.addMouseListener(new MouseListener()
		{
				@SuppressWarnings("static-access")
				public void mouseClicked(MouseEvent e)
				{

					
					int account_add_yes_int = JOptionPane.showConfirmDialog(null,"Are you sure to add this?", "Add confirm", JOptionPane.YES_NO_OPTION);
					if (account_add_yes_int == JOptionPane.YES_OPTION)
					{
						add_account_confirm_boolean=true;
						add_account_date=account_date_textfield.getText();
						add_account_item=account_item_textfield.getText();
						add_account_price=Integer.parseInt(account_price_textfield2.getText());
						
						add_test_show_label.setText(add_account_date+";"
													+add_account_item+";"
													+add_account_price);
						
						AccountMain.account_table_row++;
						add_test_show_label.setText(add_test_show_label.getText()+";;"
								+AccountMain.account_table_row);
						
						AccountMain.account_date.setSize(AccountMain.account_table_row);
						AccountMain.account_date.set(AccountMain.account_table_row-1, add_account_date);

						AccountMain.account_item.setSize(AccountMain.account_table_row);
						AccountMain.account_item.set(AccountMain.account_table_row-1, add_account_item);
						
						AccountMain.account_price.setSize(AccountMain.account_table_row);
						AccountMain.account_price.set(AccountMain.account_table_row-1, add_account_price);
						
						add_test_show_label.setText(add_test_show_label.getText()+";;"
								+AccountMain.account_table_row);
						
					
						
				/*		AccountMain account_main =new AccountMain();
						account_main.account_date.setSize(account_main.account_table_row++);
						
						account_main.account_date.setElementAt(add_account_date, account_main.account_table_row);
						account_main.account_item.set(account_main.account_table_row, add_account_item);
						account_main.account_price.set(account_main.account_table_row, add_account_price);
						System.out.println(account_main.account_date.get(account_main.account_table_row));
					*/	
					
					}
					else
					{
						JOptionPane.showMessageDialog(null, "fail");
						System.out.println("false");
						add_account_confirm_boolean=false;
					}
				}
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
		
		account_add_frame.setLayout(null);
		account_add_frame.setBounds(500,100,400,800);
		
		acoount_add_main_label.setBounds(10, 10, 300, 50);
		account_add_date_label.setBounds(10, 80, 300, 35);
		account_add_item_label.setBounds(10, 150, 300, 35);
		account_add_price_label.setBounds(10, 250, 300, 35);
	
		account_date_textfield.setBounds(10, 110, 300, 35);
		account_item_textfield.setBounds(10, 180, 300, 35);
		account_price_textfield.setBounds(10, 300, 300, 35);
		add_test_show_label.setBounds(10, 340, 300, 300);

		account_price_textfield2.setBounds(10,340,300, 35);
		account_add_yes_btn.setBounds(50, 450, 100, 30);

		account_add_frame.add(acoount_add_main_label);
		account_add_frame.add(account_add_date_label);
		account_add_frame.add(account_date_textfield);
		account_add_frame.add(account_add_item_label);
		account_add_frame.add(account_item_textfield);
		account_add_frame.add(account_add_price_label);
		account_add_frame.add(account_price_textfield);
		account_add_frame.add(account_price_textfield2);
		account_add_frame.add(add_test_show_label);
		
		account_item_textfield.setDocument(new JTextFieldLimit(20));
		account_price_textfield2.setDocument(new JTextFieldLimit(7));
		
		account_add_frame.add(account_add_yes_btn);
		account_add_frame.setVisible(true);
	}
	
	
	
}
@SuppressWarnings("serial")
class JTextFieldLimit extends PlainDocument 
{
	private int limit;
	JTextFieldLimit(int limit)
	{
		super();
		this.limit = limit;

	}

	JTextFieldLimit(int limit, boolean upper) 
	{
	    super();
	    this.limit = limit;
	}

	public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException 
	{
		if (str == null)
			return;
	    if ((getLength() + str.length()) <= limit) 
	    {
	      super.insertString(offset, str,  attr);
	    }
	}
}
class JFormattedDateTextField extends JFormattedTextField
{
	Format format = new SimpleDateFormat("yyyy/MM/dd");
  
	public JFormattedDateTextField() 
	{
		super();
		MaskFormatter maskFormatter = null;
		try 
		{
			maskFormatter = new MaskFormatter("####/##/##");
		} 
		catch (ParseException e) 
		{
			
			e.printStackTrace();
		}
  
		maskFormatter.setPlaceholderCharacter('_');
		setFormatterFactory(new DefaultFormatterFactory(maskFormatter));
		this.addFocusListener(new FocusAdapter() 
		{
			public void focusGained(FocusEvent e)
			{
				if (getFocusLostBehavior() == JFormattedTextField.PERSIST)
				setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
			}
   
			public void focusLost(FocusEvent e)
			{
//				try 
//				{
//					Date date = (Date) format.parseObject(getText());
//					setValue(format.format(date));
//				} 
//				catch (ParseException pe)
//				{
					setFocusLostBehavior(JFormattedTextField.PERSIST);
//					setText("");
//					setValue(null);
//				}
			}
		});
	}
  
	public void setValue(Date date) 
	{
		super.setValue(toString(date));
	}
  
	@SuppressWarnings("unused")
	private Date toDate(String sDate) 
	{
		Date date = null;
		if (sDate == null) return null;
		try
		{
			date = (Date) format.parseObject(sDate);
		}
		catch (ParseException pe)
		{
			// ignore
		}
  
	return date;
	}
  
	private String toString(Date date) 
	{
		try
		{
			return format.format(date);
		}
		catch (Exception e) 
		{
			return "";
		}
	}
}
class JFormattedPriceTextField extends JFormattedTextField
{
//	Format format = new SimpleDateFormat("MM/dd/yyyy");
  
	public JFormattedPriceTextField() 
	{
		super();
		MaskFormatter maskFormatter = null;
		try 
		{
			maskFormatter = new MaskFormatter("####,####");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();

		}
  
		maskFormatter.setPlaceholderCharacter('_');
		setFormatterFactory(new DefaultFormatterFactory(maskFormatter));

		this.addFocusListener(new FocusAdapter() 
		{
			public void focusGained(FocusEvent e)
			{
				if (getFocusLostBehavior() == JFormattedTextField.PERSIST)
				setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
			}
   
			public void focusLost(FocusEvent e)
			{

				try 
				{
	
		//			Date date = (Date) format.parseObject(getText());
		//			setValue(format.format(date));
					setValue();
				} 
				catch (ParseException pe)
				{
	//				JOptionPane.showMessageDialog(null, "You can't transactiom more than that 1000,0000 won!");
					setFocusLostBehavior(JFormattedTextField.PERSIST);
					setText("");

		//			setValue(null);
				}
			}
		});
	}
  
	public void setValue() 
	{
		super.setValue("");
	}
  
	@SuppressWarnings("unused")
	private Date toDate(String sDate) 
	{
		Date date = null;
		if (sDate == null) return null;
		try
		{
			date = (Date) format.parseObject(sDate);
		}
		catch (ParseException pe)
		{
		// ignore
		}
  
      return date;
	}
  
	private String toString(Date date) 
	{
		try
		{
			return format.format(date);
		}
		catch (Exception e) 
		{
			return "";
		}
	}
}
