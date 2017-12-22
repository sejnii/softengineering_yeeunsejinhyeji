import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.swing.*;

public class MemoWrite extends JFrame implements ActionListener{
	
	JPanel panel, ptitle, ptfmemo, pbtnsave;
	JLabel lbtitle, lblimit;
	JButton btnsave;
	JTextField tfmemo;
	
	public MemoWrite() {
		setTitle("MemoWrite");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		ptitle = new JPanel();
		ptitle.setLayout(new BoxLayout(ptitle, BoxLayout.Y_AXIS));
		
		lbtitle = new JLabel("�޸� �ۼ�");
		lbtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblimit = new JLabel("�޸�� 20�� �̳��� �ۼ����ּ���.");
		lblimit.setAlignmentX(Component.CENTER_ALIGNMENT);
		ptitle.add(lbtitle);
		ptitle.add(lblimit);
		panel.add(ptitle, BorderLayout.PAGE_START);
		
		ptfmemo = new JPanel();
		tfmemo = new JTextField(30);
		ptfmemo.add(tfmemo);
		panel.add(ptfmemo,BorderLayout.CENTER);
		
		pbtnsave = new JPanel();
		btnsave = new JButton("����");
		btnsave.addActionListener(this);
		pbtnsave.add(btnsave);
		panel.add(pbtnsave, BorderLayout.PAGE_END);
		
		add(panel);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemoWrite();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		
		if(source == btnsave) {
			String data = tfmemo.getText()+"\r\n";
			
			try {
				Writer memo_writer = new BufferedWriter(new FileWriter("memo.txt",true));
				memo_writer.append(data);
				memo_writer.close();
			}catch(IOException ex) {
				System.out.println("����");
			}
			
			
			MemoMain.dispose();
			new MemoMain();
			this.dispose();
			
		}
		
	}

}
