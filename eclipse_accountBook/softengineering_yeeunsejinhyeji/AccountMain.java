import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
	public static JFrame account_main_frame = new JFrame("Account Book");

	
	public static Vector <String> account_date = new Vector<String>();
	public static Vector <String> account_item = new Vector<String>();
	public static Vector <String> account_price = new Vector<String>();
	
	public static String account_date_str="";
	public static String account_item_str="";
	public static String account_price_str="";
	
	public static int account_table_row;
	public static int account_table_column = 5;
	public static int max_table_string_length=20;
	public static JLabel[][] account_table_label= new JLabel[account_table_row][account_table_column];
	
	public static int account_main_frame_width;
	public static int account_main_frame_height;
	
	public static int account_delete_index;
	
	static File date_file=new File("AccountDate.txt");
	static File item_file=new File("AccountItem.txt");
	static File price_file=new File("AccountPrice.txt");
	
	
/*
	@SuppressWarnings("resource")
	public static void WriteDateFile(String content) throws FileNotFoundException, UnsupportedEncodingException
	{
		writer_date.println(content);
		writer_date.close();
//		return writer;
			
	}
	@SuppressWarnings("resource")
	public static void WriteItemFile(String content) throws FileNotFoundException, UnsupportedEncodingException
	{
		writer_item.println(content);
		writer_item.close();
//		return writer;
			
	}
	@SuppressWarnings("resource")
	public static void WritePriceFile(String content) throws FileNotFoundException, UnsupportedEncodingException
	{
		writer_price.println(content);
		writer_item.close();
//		return writer;	나중에 String return 되게 할 수도??
			
	}
	*/
	public int SetFiletoArray()
	{
		int row_number=0;
		/******* file content -> array *********/

		try {
			
		
				String date_line, item_line;
				String price_line;
				@SuppressWarnings("resource")

				BufferedReader date_br = new BufferedReader(new FileReader(AccountMain.date_file));
				BufferedReader item_br = new BufferedReader(new FileReader(AccountMain.item_file));
				BufferedReader price_br = new BufferedReader(new FileReader(AccountMain.price_file));

				
				
				int i=0,j=0,k=0;
				//파일 줄 수 세서 밭아 온 후 사이즈 정한다
				AccountMain.account_date.setSize(100);
				AccountMain.account_item.setSize(100);
				AccountMain.account_price.setSize(100);

				while((date_line=date_br.readLine()) != null)
				{
					if(i != 0)
					{
						setAccountDate(i, date_line);
					}
					System.out.println("date index"+i+" : "+date_line);
					i++;
					row_number=i;
				}
				while((item_line=item_br.readLine()) != null)
				{
					if(j != 0)
					{
						setAccountItem(j,item_line);
						System.out.println("item index"+j+" : "+item_line);
					}

					j++;
				}
				while((price_line=price_br.readLine()) != null)
				{
					if(k != 0)
					{
						setAccountPrice(k,price_line);
						System.out.println("price index"+k+" : "+price_line);


					}

					k++;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return row_number;
		
	}
	public AccountMain() throws FileNotFoundException, UnsupportedEncodingException
	{
		account_table_row=SetFiletoArray();
		
		/**************variable settings**************/

		
//		int account_table_row = 6+1;		//6:transction times, 1:first column for menu(Date, Item name, Price)
	

	
		JPanel account_table_pannel = new JPanel();
		JLabel account_title_label = new JLabel("Account Book");

		JButton[] account_modify_button = new JButton[account_table_row];
		JButton[] account_delete_button =  new JButton[account_table_row];
		JButton refresh_button;
		JButton add_deal_button = new JButton("Add transaction history");
		
		account_table_label = new JLabel[account_table_row][account_table_column];
		
		
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
		
//		account_table_label = new JLabel[account_table_row][account_table_column];
		
		
		/**************account label(table) first line(row) setting: meaning of each column**************/
		account_date.add(0,"date");
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
		
		
		
		/**************account label(table) main setting (except first row)**************/
		for (int table_row_int=1; table_row_int<account_table_row;table_row_int++)
		{
			//first column show: Date 
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
		
	
		
		for(int i=0; i<account_table_row-1; i++)
		{
			
		}
		
//		boolean test_add=false;
		add_deal_button.addActionListener(new ActionListener() 
		{ 	
			
			

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				try {
					new AccountWrite();
					account_main_frame.setVisible(false);
					account_main_frame.dispose();
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				AccountWrite account_write = new AccountWrite();
//				System.out.println(account_write.add_account_confirm_boolean);
				
//				account_table_row++;
//				System.out.println(account_table_row);
	//			account_write.accountWrite();
 
//				account_date.set(account_table_row-1, account_write.add_account_date);
				
	//			System.out.println(account_write.add_account_date);
//				System.out.println(account_date.get(account_table_row-1));
				
				/*				try {
					account_write.wait();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					if(account_write.add_account_confirm_boolean==true)
					{
						System.out.println(account_write.add_account_confirm_boolean);
						account_table_row++;
						account_date.add(account_table_row-2, account_write.add_account_date);
						account_item.add(account_table_row-2, account_write.add_account_item);
						account_price.add(account_table_row-2, account_write.add_account_price);
						
						System.out.println(account_table_row+" ;; "
											+account_write.add_account_date+";;");
					}
				}
*/		
				

			}
			
		});
		

		
		
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
		
	
		//refresh button setting (+checking the frame refresh by println)
		refresh_button.setBorder(null);
		refresh_button.setMargin(new Insets(30, 30, 30, 30));
		refresh_button.setBounds((account_main_frame_width-50),10,30, 30);
		refresh_button.setFont(new Font("Courier New",Font.BOLD, 12)	);
	//	refresh_button.setBackground(Color.LIGHT_GRAY);
		refresh_button.setBackground(null);
		account_main_frame.add(refresh_button );
		
		int before_add_row=account_table_row;
		refresh_button.addActionListener(new ActionListener()
		{
		      public void actionPerformed(ActionEvent e) 
		      {
		    		
		    		
		    		account_table_label = new JLabel[account_table_row][account_table_column];
	//				System.out.println(account_table_row+";;"+account_date.get(account_table_row-1));


		  		account_table_pannel.setLayout(new GridLayout(0,account_table_column));
//		    	  account_table_label =new JLabel[account_table_row][account_table_column];
				JButton[] account_modify_button = new JButton[account_table_row];
				JButton[] account_delete_button =  new JButton[account_table_row];
			
		  		
		    	for(int i=before_add_row; i<account_table_row; i++)
				{
		    		account_table_label = new JLabel[account_table_row][5];
		    		
		    		System.out.println("in for");
		    		System.out.println(";;before row"+before_add_row+";;");
		    		System.out.println(";;row;;;;"+account_table_row+";;");
					account_table_label[i][0]=new JLabel(account_date.get(i));
					account_table_label[i][1]=new JLabel(account_item.get(i));
					account_table_label[i][2]=new JLabel(account_price.get(i)+"won");
					
				
					account_table_label[i][3] = new JLabel();
					account_table_label[i][3].setSize(80, 35);
					account_modify_button[i] = new JButton("Click");
					account_modify_button[i].setBackground(Color.lightGray);
					account_modify_button[i].setBounds((max_table_string_length*6+64)/2-35, 5, 70, 25);
					account_modify_button[i].setBorder(null);
					account_table_label[i][3].add(account_modify_button[i]);
					
						account_table_label[i][4] = new JLabel();
						account_table_label[i][4].setSize(80, 35);
						account_delete_button[i] = new JButton("Click");
						account_delete_button[i].setBackground(Color.lightGray);
						account_delete_button[i].setBounds((max_table_string_length*6+64)/2-35, 5, 70, 25);
						account_delete_button[i].setBorder(null);
						account_table_label[i][4].add(account_delete_button[i]);
						
						account_delete_index=i;
						account_delete_button[i].addMouseListener(new MouseListener()
						{
							public void mouseClicked(MouseEvent e)
							{
								System.out.println(">>>>in delete btn");

								int account_add_yes_int = JOptionPane.showConfirmDialog(null,"Are you sure to delete this?", "Delete confirm", JOptionPane.YES_NO_OPTION);
								if (account_add_yes_int == JOptionPane.YES_OPTION)
								{
									account_date.removeElementAt(account_delete_index);
									account_item.removeElementAt(account_delete_index);
									account_price.removeElementAt(account_delete_index);
									
									account_table_row--;
					//				account_date.setSize(account_date.size()-1);
					//				account_item.setSize(account_item.size()-1);
					//				account_price.setSize(account_price.size()-1);

									
									
								//	for(int i=0; i<4; i++)
								//	{
										
										//account_table_label[account_delete_index][i].removeAll();
										//account_table_pannel.remove(account_table_label[account_delete_index][i]);
								//	}
									
									
									//AccountMain.setAccountDate(account_delete_index,null);
									//AccountMain.setAccountItem(account_delete_index,null);
									//AccountMain.setAccountPrice(account_delete_index,0);

						//			account_date.remove(account_delete_index);
						//			account_item.remove(account_delete_index);
						//			account_price.remove(account_delete_index);
									System.out.println("**************************************");
									System.out.println(";;delete #:"+account_delete_index);
						//			System.out.println(account_date.get(account_delete_index));
									System.out.println("**************************************");

									
									
//									account_item.removeElementAt(account_delete_index-1);
//									account_price.removeElementAt(account_delete_index-1);

								}					
							}

							@Override
							public void mouseEntered(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mouseExited(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mousePressed(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mouseReleased(MouseEvent arg0) {
								// TODO Auto-generated method stub
								
							}
						});
				
//						account_table_row=account_date.size();	
						
					
					for (int k=0; k<5; k++)
					{
						account_table_pannel.add(account_table_label[i][k]);
				
					}
//					account_main_frame_width = 100+((account_table_column-1)*80+max_table_string_length*30);
//					account_main_frame_height = ((account_table_row*35)+250);
//					account_main_frame.setBounds(120,120,account_main_frame_width,account_main_frame_height);
					
//					account_table_pannel.setBounds(50, 100, ((account_table_column-1)*80+max_table_string_length*30), (account_table_row*35));
		
				}
		        Component component = (Component) e.getSource();
		        JFrame frame = (JFrame) SwingUtilities.getRoot(component);
		        frame.getContentPane().revalidate();
//		        System.out.println("refresh OK");
//				System.out.println(account_table_row+";;"+account_date.get(account_table_row-1));
		
				
				account_main_frame_width = 100+((account_table_column-1)*80+max_table_string_length*30);
				account_main_frame_height = ((account_table_row*35)+250);
				account_main_frame.setBounds(120,120,account_main_frame_width,account_main_frame_height);
				
				account_table_pannel.setBounds(50, 100, ((account_table_column-1)*80+max_table_string_length*30), (account_table_row*35));
		//		

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
	public void dispose()
	{
		account_main_frame.dispose();
	}
}