package defau;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
public class JustFF
{

	public static void main(String[] args) 
	{
		Vector <String> account_date = new Vector<String>();
		Vector <String> account_item = new Vector<String>();
		Vector <Integer> account_price = new Vector<Integer>();
		
		int account_table_column = 5;	//�̰� ���߿� set ȣ���� Ƚ�� Ȥ�� �߰� ��ư ���� Ƚ���� �޾ƿ´�.

		JFrame account_main_frame = new JFrame("Account Book");
		JLabel account_title_label = new JLabel("<Account Book>");
		JButton refresh_button = new JButton("Refresh");
		JButton add_deal_button = new JButton("Add transaction content");
		JPanel account_table_pannel = new JPanel();
		
		JButton account_modify_button = new JButton("M");
		
		JLabel[][] account_table_label;	// = new JLabel[3];
	//	JLabel[] account_table_label_item;
		
	//	account_main_frame.setLayout(new FlowLayout());
		account_main_frame.setBounds(120,120,500,700);
	
		account_table_pannel.setLayout(null);
		account_table_pannel.setLayout(new GridLayout(account_table_column,2));
	//	account_table_pannel.setBounds(100, 50, 10, (30*account_table_column));

//		account_table_column = account_date.size();
		
		account_table_label = new JLabel[account_table_column][5];
	//	account_table_label_item = new JLabel[account_table_column];
		
		//while
		for (int i=0; i<account_table_column; i++)
		{
	//		account_date.add(getAccountDate(i));//	get���� Date �޾ƿ´�.
			account_date.add(i+"th day");			//���߿� date�Լ��� �޾ƿ���
			account_table_label[i][1] = new JLabel(account_date.get(i));

			account_item.add(i+"stuff");	//���߿� �޾ƿ�
	//		account_table_label_item[i] = new JLabel(account_item.get(i));
			account_table_label[i][2] = new JLabel(account_item.get(i));
			
			account_price.add(i*1500);
			account_table_label[i][3] = new JLabel(account_price.get(i)+"won");
			
	//		account_table_label[i][4].getBorder();
		//	account_table_label[i][4].setLayout(new BorderLayout());
	//		account_table_label[i][4].setPreferredSize(new Dimension(200,100));
			account_table_label[i][4] = new JLabel("Modify");
	//		account_modify_button.setVisible(true);
	//		account_table_label[i][4].setText("Modify");
			account_modify_button.setSize(50, 30);
			account_table_label[i][4].add(account_modify_button);

			
			account_table_pannel.add(account_table_label[i][1]);
			account_table_pannel.add(account_table_label[i][2]);
			account_table_pannel.add(account_table_label[i][3]);
			account_table_pannel.add(account_table_label[i][4]);

		}
		
		account_table_column = account_date.size();
		
		account_title_label.setBounds(200,0,100, 50);
	//	account_title_label.setVerticalAlignment(SwingConstants.TOP);
	//	account_title_label.setHorizontalAlignment(SwingConstants.CENTER);
		account_main_frame.add(account_title_label);
		
		refresh_button.setBounds(350,0,100, 30);
	//	refresh_button.setVerticalAlignment(SwingConstants.TOP);
	//	refresh_button.setHorizontalAlignment(SwingConstants.RIGHT);
		account_main_frame.add(refresh_button );

		add_deal_button.setBounds(300,600, 150, 30);
		account_main_frame.add(add_deal_button);
		
//		account_table_pannel.setBounds(50,(10*account_table_column),10,50);
		account_table_pannel.setAlignmentX(SwingConstants.LEFT); //.setVerticalAlignment(SwingConstants.CENTER);
		account_table_pannel.setAlignmentY(SwingConstants.CENTER);
		account_main_frame.add(account_table_pannel);

		account_main_frame.setVisible(true);

		
		
		
				
 
	//	String getAccountDate(int edit_index)
	//	{
	//		String str;
	//		return;
	//	}
	/*	public void setAccountDate(int edit_index, String edit_date)
		{
			edit_index
			
		}
/*		public String getAccountItem(int edit_index)
		{
			
		}
		public void setAccountItem(int edit_index, String edit_item)
		{
			
		}
		public int getAccountPrice(int edit_index)
		{
			
		}
		public int setAccountPrice(int edit_index, int edit_price)
		{
			
		}
		
*/		
	
	}
	public static JButton createButton()
	{
		JButton button =new JButton();
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setFocusable(false);
		button.setMargin(new Insets(0,0,0,0));
		button.setContentAreaFilled(false);
//		button.setIcon(null);
		button.setText("MM");
		return button;
	}


	
}