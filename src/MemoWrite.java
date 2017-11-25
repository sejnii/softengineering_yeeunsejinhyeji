import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MemoWrite extends JFrame implements ActionListener{
	JPanel panel, ptfmemo, pbtnsave;
	JButton btnsave;
	JTextField tfmemo;
	
	public MemoWrite() {
		setTitle("MemoWrite");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		ptfmemo = new JPanel();
		tfmemo = new JTextField(30);
		ptfmemo.add(tfmemo);
		panel.add(ptfmemo,BorderLayout.CENTER);
		
		pbtnsave = new JPanel();
		btnsave = new JButton("¿˙¿Â");
		btnsave.addActionListener(this);
		pbtnsave.add(btnsave);
		panel.add(pbtnsave, BorderLayout.LINE_END);
		
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
			MemoMain.setMemoContent(tfmemo.getText());
			this.dispose();
		}
		
	}

}
