import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JFormattedTextField;

public class AccountMain_test {

	public static void main(String[] args) 
	{
		public Scanner scanner = new Scanner(System.in);
		
//		public AccountMain(){}
		JFrame frm = new JFrame("Account Book");
		
		Vector <String> account_date;
		Vector <String> account_item;
		Vector <Integer> account_price;
		
		
		
		public String getAccountDate(int edit_index) 
		{
			System.out.println("date:");
			String a_dateString = scanner.next();
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

			JFormattedTextField dateTextField = new JFormattedTextField(format);

			System.out.println("date:");	
		}


	}

}
