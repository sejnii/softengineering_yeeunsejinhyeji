import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class test_1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException 
	{
		// TODO Auto-generated method stub
//1.DATE
		Date d = new Date(86,04,04);
		System.out.println("date is:"+d);
	
//2.boolen������	
		final boolean DEBUG = false;
		System.out.println("Hellow, World!");
		if(DEBUG)
		{
			System.out.println("life is fuck");
		}
		else
		{
			System.out.println("life is fuck fucck");
		}

//3.error detect?
		String name = "poem";
		if (System.getProperty("debug.fetch") != null)
		{
			System.err.println("Fetching"+name);
		}
		else
		{
			System.err.println("What happened?");
			System.out.println("NO ERROR?");
		}
		
//4.length?		
		int i=4;
		if (args.length ==1) 
		{
			i = Integer.parseInt(args[0]);
		}
		assert i > 0 : "i is non-positive";
		System.out.println("Hello after an assertion");
		
//5.String -> Substring
		String a = "0123456789";
		String b = a.substring(5);
		String c = a.substring(5,7);
		String e = a.substring(5,a.length());
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(e);
		

//6.String Token :73 page
		StringTokenizer st = new StringTokenizer("Hellojjj");
		StringTokenizer st2 = new StringTokenizer("Heellojjjj",".|");
		while(st.hasMoreTokens())
		{
			System.out.println("Token:"+st.nextToken());
		}
		while(st.hasMoreElements())
		{
			System.out.println("Token2:"+st2.nextElement());
			
		}
		
//7.Scanner
	//	DateFormat format = new SimpleDateFormat("yyyy.mm.dd");
//		String a_date = format.format(fmat);
//		JFormattedTextField dateTextField = new JFormattedTextField(format);
		String name2;
		Scanner scan = new Scanner(System.in);
		System.out.println("name:");
		name2=scan.next();
		System.out.println(name2);

		System.out.println("date:");
		String a_dateString = scan.next();
		SimpleDateFormat a_format = new SimpleDateFormat("yyyy-MM-dd");
		Date a_date = a_format.parse(a_dateString);
		System.out.println("date:");
		System.out.println(a_date);
		
//8.AccountMain practice
		JFrame account_main_frm = new JFrame("Account Book");
		JLabel account_title_label = new JLabel("Account Book");
		
		account_main_frm.add(account_title_label);
	}

}