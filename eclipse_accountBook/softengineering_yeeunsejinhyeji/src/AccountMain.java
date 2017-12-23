import java.awt.*;
import java.awt.event.*;
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

class AccountMain() thcolumns ParseException
{
	public static Vector <String> account_date = new Vector<String>();
	public static Vector <String> account_item = new Vector<String>();
	public static Vector <Integer> account_price = new Vector<Integer>();
	
	
	public AccountMain()
	{
		/**************variable settings**************/
		int max_table_string_length=0;
		
		int account_table_row = 6+1;		//6:transction times, 1:first column for menu(Date, Item name, Price)
		int account_table_column = 5;
		int account_main_frame_width;
		int account_main_frame_height;
	
		JFrame account_main_frame = new JFrame("Account Book");
		JPanel account_table_pannel = new JPanel();
		JLabel account_title_label = new JLabel("Account Book");
		JLabel[][] account_table_label;
		JButton[] account_modify_button = new JButton[account_table_row];
		JButton[] account_delete_button =  new JButton[account_table_row];
		JButton refresh_button;
		JButton add_deal_button = new JButton("Add transaction history");
		
		
		/**************set the refresh icon in refresh button**************/
		ImageIcon refresh_icon = new ImageIcon("C:\\Users\\ASUS\\refresh_btn_img2.png");
	 	Image get_refresh_img = refresh_icon.getImage() ;  
		Image resizing_img = get_refresh_img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
		ImageIcon new_size_refresh_icon = new ImageIcon( resizing_img );
		refresh_button = new JButton(new_size_refresh_icon);
		
		
		/**************basic setting for main frame & pannel & label**************/
		account_main_frame.setLayout(null);
		account_main_frame.getContentPane().setBackground(Color.WHITE);
		
		account_table_pannel.setLayout(new GridLayout(0,account_table_column));
		account_table_pannel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		account_table_pannel.setBackground(Color.WHITE);
		
		account_table_label = new JLabel[account_table_row][account_table_column];
		
		
		/**************account label(table) first line(row) setting: meaning of each column**************/
		account_date.add("date");
		account_item.add("item");
		account_price.add(null);
			
		account_table_label[0][0] = new JLabel(account_date.get(0));
		account_table_label[0][1] = new JLabel(account_item.get(0));
		account_table_label[0][2] = new JLabel("price");
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
		
		
		
		/**************account label(table) main setting (except first row)**************/
		for (int table_row_int=1; table_row_int<account_table_row;table_row_int++)
		{
			//first column show: Date 
			setAccountDate(table_row_int, "2011/11/11");
			account_table_label[table_row_int][0] = new JLabel(account_date.get(table_row_int));
			account_table_label[table_row_int][0].setSize(80, 35);

			
			//secont column show: Item (+define the max length of one column in table)
			setAccountItem(table_row_int,"things");
			account_table_label[table_row_int][1] = new JLabel(account_item.get(table_row_int));
			if(max_table_string_length<account_item.get(table_row_int).length())
			{
				max_table_string_length = account_item.get(table_row_int).length();	
			}
			account_table_label[table_row_int][1].setSize(max_table_string_length+10, 35);
			
			
			//third column show: Price
			setAccountPrice(table_row_int,table_row_int*1000);
			account_table_label[table_row_int][2] = new JLabel(account_price.get(table_row_int)+"won");
			account_table_label[table_row_int][2].setSize(80, 35);
			
			
			//forth column show: Modify button
			account_table_label[table_row_int][3] = new JLabel();
			account_table_label[table_row_int][3].setSize(80, 35);
			account_modify_button[table_row_int] = new JButton("Click");
//			account_modify_button[table_row_int].setSize(70, 25);
//			account_modify_button[table_row_int].setBackground(null);
			account_modify_button[table_row_int].setBackground(Color.lightGray);
			account_modify_button[table_row_int].setBorder(null);
			account_modify_button[table_row_int].setBounds((max_table_string_length*6+64)/2-35, 5, 70, 25);
			account_table_label[table_row_int][3].add(account_modify_button[table_row_int]);
			
			
			//fifth column show: Delete button
			account_table_label[table_row_int][4] = new JLabel();
			account_table_label[table_row_int][4].setSize(80, 35);
			account_delete_button[table_row_int] = new JButton("Click");
			account_delete_button[table_row_int].setBackground(Color.lightGray);
//			account_delete_button[table_row_int].setBackground(null);
//			account_delete_button[table_row_int].setSize(75, 30);
//			account_delete_button[table_row_int].setBounds(5, 5, 70, 25);
			account_delete_button[table_row_int].setBounds((max_table_string_length*6+64)/2-35, 5, 70, 25);
			account_delete_button[table_row_int].setBorder(null);
			account_table_label[table_row_int][4].add(account_delete_button[table_row_int]);
			
			
			
			//set the font and alignment in all table label
			for(int table_column_int=0; table_column_int<account_table_column; table_column_int++)
			{
				account_table_label[table_row_int][table_column_int].setFont(new Font("Courier New", Font.PLAIN, 15));

				account_table_label[table_row_int][table_column_int].setVerticalAlignment(SwingConstants.CENTER);
				account_table_label[table_row_int][table_column_int].setHorizontalAlignment(SwingConstants.CENTER);
	//			account_table_label[table_row_int][table_column].getBounds();
				account_table_label[table_row_int][table_column_int].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
				account_table_pannel.add(account_table_label[table_row_int][table_column_int]);
			}
		}
		
		
		/**************design settings**************/
		//main frame &  setting: concerning string length in table
		account_main_frame_width = 100+((account_table_column-1)*80+max_table_string_length*30);
		account_main_frame_height = ((account_table_row*35)+250);
		account_main_frame.setBounds(120,120,account_main_frame_width,account_main_frame_height);
		
		account_table_pannel.setBounds(50, 100, ((account_table_column-1)*80+max_table_string_length*30), (account_table_row*35));
		
		
		//main title label setting
		account_title_label.setBounds((account_main_frame_width/2)-130,20,250, 50);
		account_title_label.setVerticalAlignment(SwingConstants.CENTER);
		account_title_label.setHorizontalAlignment(SwingConstants.CENTER);
		account_title_label.setFont(new Font("Courier New", Font.BOLD, 30));
		account_main_frame.add(account_title_label);
		
	
		//refresh button setting (+cheching the frame refresh by println)
		refresh_button.setBorder(null);
		refresh_button.setMargin(new Insets(30, 30, 30, 30));
		refresh_button.setBounds((account_main_frame_width-50),10,30, 30);
		refresh_button.setFont(new Font("Courier New",Font.BOLD, 12)	);
	//	refresh_button.setBackground(Color.LIGHT_GRAY);
		refresh_button.setBackground(null);
		account_main_frame.add(refresh_button );
		refresh_button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        Component component = (Component) e.getSource();
		        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
		        frame.revalidate();
		        System.out.println("refresh OK");
		      }
		    });

		//add button setting
		add_deal_button.setBorder(null);
		add_deal_button.setBounds(account_main_frame_width-230,account_main_frame_height-80, 200, 30);
//		add_deal_button.setBackground(Color.LIGHT_GRAY);
//		add_deal_button.setBackground(Color.black);
		add_deal_button.setFont(new Font("Courier New",Font.BOLD, 12));
		account_main_frame.add(add_deal_button);
		
		//last setting: add pannel to frame & visible 
		account_main_frame.add(account_table_pannel);
		account_main_frame.setVisible(true);
	}
	
	
	
	
	public static void setAccountDate(int edit_index, String edit_date) thcolumns ParseException
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
		LocalDate account_date_localDate = LocalDate.parse(edit_date, formatter);
		
		account_date.add(edit_index,formatter.format(account_date_localDate));

	}
	public static void setAccountItem(int edit_index, String edit_item)
	{
		account_item.add(edit_index,edit_item);
	}
	public static void setAccountPrice(int edit_index, int edit_price)
	{
		account_price.add(edit_index,edit_price);
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
	public static int getAccountPrice(int edit_index)
	{
		return account_price.get(edit_index);
	}
}