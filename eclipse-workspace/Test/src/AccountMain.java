import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JFormattedTextField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AccountMain 
{
	public Scanner scanner = new Scanner(System.in);
	
	//interface
	Vector <String> account_date;
	Vector <String> account_item;
	Vector <Integer> account_price;
	
	//inside(not in interface)
	JFrame account_main_frm = new JFrame("Account Book");
	JLabel account_title_label = new JLabel("Account Book");
	
	account_main_frm.add(account_title_label);
	
	
	
	
	public AccountMain()	//»ý¼ºÀÚ
	{
		
		
	}
	public String getAccountDate(int edit_index) 
	{
		System.out.println("date:");
		String a_dateString = scan.next();
		SimpleDateFormat a_format = new SimpleDateFormat("yyyy-MM-dd");
		Date a_date = a_format.parse(a_dateString);
		System.out.println("date:");
		System.out.println(a_date);
		
	
		return null;
		
	}
	public void setAccountDate(int edit_index, String edit_date)
	{
		
		String 
		DateFormat format = new SimpleDateFormat("yyyy,mm,dd,hh,mm,ss");
//		JFormattedTextField dateTextField = new JFormattedTextField(format);

		System.out.println("date:");	
	}
	public String getAccountItem(int edit_index)
	{
		
	}
	public void setAccountItem(int edit_index, String edit_item)
	{
		
	}
	public int getAccountPrice(int edit_index)
	{
		
	}
	public void setAccountprice(int edit_index, int edit_price)
	{
		
	}

}
