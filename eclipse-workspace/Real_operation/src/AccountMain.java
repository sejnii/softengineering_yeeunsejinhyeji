import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.Border;

class AccountMain
{
	public static JFrame account_main_frame ;

	
	public static Vector <String> account_date ;
	public static Vector <String> account_item ;
	public static Vector <String> account_price;
	
	public static String account_date_str="";
	public static String account_item_str="";
	public static String account_price_str="";
	
	public static int account_table_row;
	public static int account_table_column = 5;
	public static int max_table_string_length=20;
	public static JLabel[][] account_table_label;
		
	public static int account_main_frame_width;
	public static int account_main_frame_height;

	
	static String date_file="AccountDate.txt";
	static String item_file="AccountItem.txt";
	static String price_file="AccountPrice.txt";
	
	public int SetFiletoArray()
	{
		int row_number=0;
		/******* file content -> array *********/
		try {
			
			account_date = new Vector<String>();
			account_item = new Vector<String>();
			 account_price = new Vector<String>();
		
				String date_line, item_line;
				String price_line;
				BufferedReader date_br = new BufferedReader(new FileReader("accountDate.txt"));
				BufferedReader item_br = new BufferedReader(new FileReader("accountitem.txt"));
				BufferedReader price_br = new BufferedReader(new FileReader("accountprice.txt"));

				
				int i=0,j=0,k=0;
				//constraint to 100 or read
				
				while((date_line=date_br.readLine()) != null)
				{
//					if(i != 0)
//					{
						account_date.add(i, date_line);
//					}
					System.out.println("date index"+i+" : "+date_line);
					i++;
					row_number=i;
				}
				while((item_line=item_br.readLine()) != null)
				{
//					if(j != 0)
//					{
						account_item.add(j, item_line);
						System.out.println("item index"+j+" : "+item_line);
	//				}

					j++;
				}
				while((price_line=price_br.readLine()) != null)
				{
	//				if(k != 0)
	//				{
						account_price.add(k, price_line);
						System.out.println("price index"+k+" : "+price_line);


		//			}

					k++;
				}
				
				date_br.close();
				item_br.close();
				price_br.close();
			} catch (IOException e1) {
	
				e1.printStackTrace();
			}
//		if (row_number == 0)
//		{
//			row_number=2;
//		}


		return row_number;
		
	}
	public AccountMain() 
	{
		account_main_frame = new JFrame("Account Book");
		account_table_row=SetFiletoArray();

		System.out.println("row"+account_table_row);
		
		
		/**************variable settings**************/
	
		JPanel account_table_pannel = new JPanel();
		JLabel account_title_label = new JLabel("Account Book");

		account_table_label= new JLabel[account_table_row][account_table_column];
		JButton[] account_modify_button = new JButton[account_table_row];
		JButton[] account_delete_button =  new JButton[account_table_row];
		JButton add_deal_button = new JButton("Add transaction history");
		
		account_table_label = new JLabel[account_table_row][account_table_column];

		/**************basic setting for main frame & pannel & label**************/
		account_main_frame.setLayout(null);
		account_main_frame.getContentPane().setBackground(Color.WHITE);
		
		account_table_pannel.setLayout(new GridLayout(0,account_table_column));
		account_table_pannel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		account_table_pannel.setBackground(Color.WHITE);

		
		
		/**************account label(table) first line(row) setting: meaning of each column**************/
/*		account_date.add(0,"date");
		account_item.add(0,"item");
		account_price.add(0,"price");
			
		account_table_label[0][0] = new JLabel(account_date.get(0));
		account_table_label[0][1] = new JLabel(account_item.get(0));
		account_table_label[0][2] = new JLabel(account_price.get(0));
		account_table_label[0][3]= new JLabel("Modify");
		account_table_label[0][4]= new JLabel("Delete");
		
		for(int first_row_setting_int=0; first_row_setting_int<5; first_row_setting_int++)
		{
			account_table_label[0][first_row_setting_int].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			account_table_pannel.add(account_table_label[0][first_row_setting_int]);

			account_table_label[0][first_row_setting_int].setVerticalAlignment(SwingConstants.CENTER);
			account_table_label[0][first_row_setting_int].setHorizontalAlignment(SwingConstants.CENTER);
			account_table_label[0][first_row_setting_int].setFont(new Font("Courier New", Font.PLAIN, 15));
		}
		
*/		
		
		/**************account label(table) main setting (except first row)**************/
		for (int table_row_int=0; table_row_int<account_table_row;table_row_int++)
		{
	//		 SetFiletoArray();
			//first column show: Date 
			System.out.println(table_row_int+"-table date:"+account_date.get(table_row_int));
			account_table_label[table_row_int][0] = new JLabel(account_date.get(table_row_int));
			account_table_label[table_row_int][0].setSize(80, 35);

			
			//second column show: Item (+define the max length of one column in table)
			account_table_label[table_row_int][1] = new JLabel(account_item.get(table_row_int));
//
			
			account_table_label[table_row_int][1].setSize(max_table_string_length+10, 35);
			
			
			//third column show: Price
			account_table_label[table_row_int][2] = new JLabel(account_price.get(table_row_int)+"won");
			account_table_label[table_row_int][2].setSize(80, 35);
			
			
			//forth column show: Modify button
			account_table_label[table_row_int][3] = new JLabel();
			account_table_label[table_row_int][3].setSize(80, 35);
			account_modify_button[table_row_int] = new JButton("Click");
			account_modify_button[table_row_int].setBackground(Color.lightGray);
			account_modify_button[table_row_int].setBorder(null);
			account_modify_button[table_row_int].setBounds((max_table_string_length*6+64)/2-35, 5, 70, 25);
			account_table_label[table_row_int][3].add(account_modify_button[table_row_int]);
			account_modify_button[table_row_int].addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					for(int i=0;i<account_table_row;i++)
					{
						if(e.getSource() == account_modify_button[i])
						{
							System.out.println("modify:"+i);
							
								new AccountEdit(i);
							
						}
					}
					
				}
			});
			
			
			
			//fifth column show: Delete button
			account_table_label[table_row_int][4] = new JLabel();
			account_table_label[table_row_int][4].setSize(80, 35);
			account_delete_button[table_row_int] = new JButton("Click");
			account_delete_button[table_row_int].setBackground(Color.lightGray);
			account_delete_button[table_row_int].setBounds((max_table_string_length*6+64)/2-35, 5, 70, 25);
			account_delete_button[table_row_int].setBorder(null);
			
//			account_delete_index=table_row_int;
			account_table_label[table_row_int][4].add(account_delete_button[table_row_int]);

			account_delete_button[table_row_int].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e)
				{
					int account_delete_index=0;
					for(int k=0;k<account_delete_button.length;k++)
						if(e.getSource() == account_delete_button[k])
							account_delete_index = k;
					System.out.println(">>>>>>>>>>>delete index: "+account_delete_index);

					System.out.println("In delete btn");

					try {
						Writer date_txt_writer = new BufferedWriter(new FileWriter(date_file));
						Writer item_txt_writer = new BufferedWriter(new FileWriter(item_file));
						Writer price_txt_writer = new BufferedWriter(new FileWriter(price_file));
						

						for(int i=0;i<account_table_row;i++)
						{
							
							if(i!=account_delete_index) {
								date_txt_writer.write(account_date.elementAt(i)+"\r\n");
								item_txt_writer.write(account_item.elementAt(i)+"\r\n");
								price_txt_writer.write(account_price.elementAt(i)+"\r\n");
							}


						}
						date_txt_writer.close();
						item_txt_writer.close();
						price_txt_writer.close();
//						SetFiletoArray();
					}
					catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					
						account_main_frame.setVisible(false);
						account_main_frame.dispose();
						new AccountMain();
						System.out.println("Make new main class");
	//					SetFiletoArray();

					
				}});
			


			
			
			//set the font and alignment in all table label
			for(int table_column_int=0; table_column_int<account_table_column; table_column_int++)
			{
				account_table_label[table_row_int][table_column_int].setFont(new Font("Courier New", Font.PLAIN, 15));

				account_table_label[table_row_int][table_column_int].setVerticalAlignment(SwingConstants.CENTER);
				account_table_label[table_row_int][table_column_int].setHorizontalAlignment(SwingConstants.CENTER);
				account_table_label[table_row_int][table_column_int].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				account_table_pannel.add(account_table_label[table_row_int][table_column_int]);
				
			}
		}

		add_deal_button.addActionListener(new ActionListener() 
		{ 	
			
			

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				
					new AccountWrite();

			
			}
			
		}
		);
		

		/**************design settings**************/
		//main frame &  setting: concerning string length in table
		account_main_frame_width = 100+((account_table_column-1)*80+max_table_string_length*30);
		account_main_frame_height = ((account_table_row*35)+250);
	//	account_main_frame.setBounds(120,120,account_main_frame_width,account_main_frame_height);
		account_main_frame.setBounds(120,120,1200,400);
		
		account_table_pannel.setBounds(50, 100, ((account_table_column-1)*80+max_table_string_length*30), (account_table_row*35));
		
		
		//main title label setting
		account_title_label.setBounds((account_main_frame_width/2)-130,20,250, 50);
		account_title_label.setVerticalAlignment(SwingConstants.CENTER);
		account_title_label.setHorizontalAlignment(SwingConstants.CENTER);
		account_title_label.setFont(new Font("Courier New", Font.BOLD, 30));
		account_main_frame.add(account_title_label);


		//add button setting
		add_deal_button.setBorder(null);
		add_deal_button.setBounds(account_main_frame_width-230,account_main_frame_height-80, 200, 30);
		add_deal_button.setFont(new Font("Courier New",Font.BOLD, 12));
		account_main_frame.add(add_deal_button);
		
		//last setting: add pannel to frame & visible 
		account_main_frame.add(account_table_pannel);
		account_main_frame.setVisible(true);
		
		//do not turn off other frames if main frame is turned off
		account_main_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	
	
	
	
	public static void setAccountDate(int edit_index, String edit_date) 
	{
	
		account_date.set(edit_index,edit_date);

	}
	public static void setAccountDate(String edit_date) 
	{
		int size=account_date.size();
		account_date.setSize(size+1);
		account_date.set(size, edit_date);
		

	}
	public static void setAccountItem(int edit_index, String edit_item)
	{
		account_item.setElementAt(edit_item, edit_index);
	}
	public static void setAccountItem(String edit_item)
	{	int size=account_item.size();
		account_item.setSize(size+1);
		account_item.set(size, edit_item);
	}
	
	public static void setAccountPrice(int edit_index, String edit_price)
	{
		account_price.set(edit_index,edit_price);
	}
	public static void setAccountPrice(String add_account_price)
	{
		int size=account_price.size();
		account_price.setSize(size+1);
		account_price.set(size, add_account_price);
	}
	//maybe do no need: get functions		//just use:    account_date.get(index_number);
	public static String getAccountDate(int edit_index)
	{
		return account_date.get(edit_index);
	}
	public static String getAccountItem(int edit_index)
	{
		return account_item.get(edit_index);
	}
	public static String getAccountPrice(int edit_index)
	{
		return account_price.get(edit_index);
	}
	public static void dispose()
	{
		account_main_frame.dispose();
	}
}
/*
public class AccountDelete implements MouseListener 
{
	
    //where initialization occurs:
    //Register for mouse events on blankArea and the panel.
 //   blankArea.addMouseListener(this);
  //  addMouseListener(this);

	public void mousePressed(MouseEvent e) {
		
		
//		saySomething("Mouse pressed; # of clicks: "
//	                + e.getClickCount(), e);
	}
	
	public void mouseReleased(MouseEvent e) {
//	   saySomething("Mouse released; # of clicks: "
//	                + e.getClickCount(), e);
	}
	
	public void mouseEntered(MouseEvent e) {
//	   saySomething("Mouse entered", e);
	}
	
	public void mouseExited(MouseEvent e) {
//	   saySomething("Mouse exited", e);
	}
	
	public void mouseClicked(MouseEvent e) {
//	   saySomething("Mouse clicked (# of clicks: "
//	                + e.getClickCount() + ")", e);
	}
	
	void saySomething(String eventDescription, MouseEvent e) {
//	    textArea.append(eventDescription + " detected on "
//	                    + e.getComponent().getClass().getName()
//	                    + "." + newline);
	}
}
*/