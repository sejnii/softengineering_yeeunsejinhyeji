import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MemoEdit extends JFrame implements ActionListener {
	
	JPanel panel, ptitle, ptfmemo, pbtnrevise;
	JLabel lbtitle, lblimit;
	JButton btnrevise;
	JTextField tfmemo;
	private static int edit_index;
	
	public MemoEdit(int edit_index) {
		setTitle("MemoEdit");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		ptitle = new JPanel();
		ptitle.setLayout(new BoxLayout(ptitle, BoxLayout.Y_AXIS));
		
		lbtitle = new JLabel("�޸� �ۼ�");
		lbtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblimit = new JLabel("�޸�� 20�� �̳��� �������ּ���.");
		lblimit.setAlignmentX(Component.CENTER_ALIGNMENT);
		ptitle.add(lbtitle);
		ptitle.add(lblimit);
		panel.add(ptitle, BorderLayout.PAGE_START);
		
		ptfmemo = new JPanel();
		tfmemo = new JTextField(30);
		tfmemo.setText(MemoMain.getMemoContent(edit_index));
		ptfmemo.add(tfmemo);
		panel.add(ptfmemo,BorderLayout.CENTER);
		
		pbtnrevise = new JPanel();
		btnrevise = new JButton("����");
		btnrevise.addActionListener(this);
		pbtnrevise.add(btnrevise);
		panel.add(pbtnrevise, BorderLayout.PAGE_END);
		
		add(panel);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemoEdit(edit_index);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == btnrevise) {
			MemoMain.setMemoContent(edit_index, tfmemo.getText());
			System.out.println(tfmemo.getText());
			this.dispose();
		}
	}

}
