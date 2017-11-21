import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;

public class test_2
{

	public static void main(String[] args) 
	{
		MouseListener listener = new MouseEventHandler();
		
		
//1.practice Swing - basic frame & button
		JFrame frm = new JFrame("First Swing");
		//title bar(���� ǥ����)

		frm.setBounds(400,200,400,200);	//��ġ, ũ��
		frm.setLayout(new FlowLayout());	//������Ʈ ��ġ
		
		JButton btn1 = new JButton("My Button");
		JButton btn2 = new JButton("our Button");
		JButton btn3 = new JButton("Our Button");
		
		btn1.addMouseListener(listener);
		btn2.addMouseListener(listener);
		btn3.addMouseListener(listener);
		
		frm.add(btn1);
		frm.add(btn2);
		frm.add(btn3);
		frm.setVisible(true);
		
//frame 2��° ����	- ū ������ ��ư Ŭ���� �����	
		JFrame frm2 = new JFrame("FlowLayout Test");
		
		frm2.setLayout(new FlowLayout());
		frm2.setBounds(120, 120, 400, 200);
		
		frm2.add(new JButton("Hi!"));
		frm2.add(new JButton("I like Swing!"));
		frm2.add(new JButton("I am a button"));
		frm2.add(new LargeButton("Hi!"));
		frm2.add(new LargeButton("I like Swing!"));
		frm2.add(new LargeButton("I am a button"));
		
		frm2.setVisible(true);
		
//3. Panel making		
		JFrame frm3 = new JFrame("Multi Layout Manager");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JButton[] btns = new JButton[4];
		JButton[] btns2 = new JButton[6];
		
		frm3.setLayout(new FlowLayout());
		frm3.setBounds(120,120,250,150);

		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new GridLayout(2,3,2,2));
		
		for(int i=0; i<4; i++)
		{
			panel1.add(btns[i] = new JButton("B"+(i+1)));
		}
		for(int i=0; i<6; i++)
		{
			panel2.add(btns2[i] = new JButton("B"+(i+5)
					));
		}
		
		frm3.add(panel1, BorderLayout.NORTH);
		frm3.add(panel2, BorderLayout.CENTER);

		frm3.setVisible(true);
		
//Practice Vector <>
		Scanner scanner2 = new Scanner(System.in);
		
		//int test_length;
		//String sample;
		String d_str;
//		Vector<Date> test_v = new Vector <Date>();
		
		System.out.println("date:");
		String test_d = scanner2.next();
		SimpleDateFormat test_f = new SimpleDateFormat("yyyy-MM-dd");
		Date test_date = test_f.parse(test_d);
		System.out.println("date:");
		System.out.println(test_date);
		
		
		
//Account main test
		Vector <String> account_date = new Vector<String>();
		//Vector <String> account_item = new Vector<String>();
		//Vector <Integer> account_price = new Vector<Integer>();
		
		
		JFrame account_main_frm = new JFrame("Account Book");
		JLabel account_title_label = new JLabel("Account Book");

		JButton refresh_button = new JButton("Refresh");
		
		account_main_frm.setLayout(new FlowLayout());
		account_main_frm.setBounds(100, 200, 900, 500);
		
		account_main_frm.add(account_title_label);
		account_main_frm.add(refresh_button);
		
		account_main_frm.setVisible(true);	
		
		
//2.X��ư �����ϰ� ���شٴµ� ��� ��
/*		WindowListener listen = (WindowListener) new WindowAdapter()
		{
			public void windowClosing(WindowEvent ev)
			{
				System.exit(0);
			}
		};
		frm.addWindowListener(listen);
*/
	}
}
//3.Event listener - ��ư���� ���콺 ��ġ, ��ư Ŭ�� ���� �� �̺�Ʈ ���	
class MouseEventHandler implements MouseListener
{
//	public void mouseClicked(MouseEvent e)
//	{		
//		e.removeremoveAll();
//	}
	@SuppressWarnings("deprecation")
	public void mouseClicked(MouseEvent e)
	{
//		JFrame fr = (JFrame)e.getComponent();
		JButton button = (JButton)e.getComponent();
		button.setText("Clicked");
		System.out.println("Clicked Button"+e.getButton());
		System.out.println("Clicked mouse and then released");
		
//		fr.removeAll();
//		fr.repaint();
//		fr.resize(600,600);
	}
	public void mouseEntered(MouseEvent e)
	{
		System.out.println("Ŀ�� ��ư �� ����");			
	}
	public void mouseExited(MouseEvent e) 
	{
		System.out.println("Ŀ�� ��ư �� Ż��");
	}
	public void mousePressed(MouseEvent e) 
	{
		System.out.println("���콺 ��ư ����");
	}
	public void mouseReleased(MouseEvent e)
	{
		System.out.println("���콺 ��ư Ǯ��");
	}
}
	
class LargeButton extends JButton
{
	public LargeButton(String str)
	{
		super(str);		
	}
	public Dimension getPreferredSize()
	{
		Dimension largeBtmSz =  new Dimension
				(
						super.getPreferredSize().width+30,
						super.getPreferredSize().height+15
				);
		return largeBtmSz;
	}
}
