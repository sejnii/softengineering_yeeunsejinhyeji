import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener{

	JButton btmemo, btcal, btacc;
	JPanel panelmemo, panelcal, panelacc, paneltitle;
	JLabel lbtitle;
	public Main(){
		
		paneltitle = new JPanel();
		
		lbtitle = new JLabel("Main Page");
		lbtitle.setFont(new Font("êµ´ë¦¼", Font.BOLD, 40));
		paneltitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		paneltitle.add(lbtitle);
	
		
		panelmemo = new JPanel();
		panelcal = new JPanel();
		panelacc = new JPanel();
		
		btmemo = new JButton("Memo Manager");
		btcal = new JButton("Calculator");
		btacc = new JButton("Account Book");
		
		btmemo.addActionListener(this);
		btcal.addActionListener(this);
		btacc.addActionListener(this);
		
		btmemo.setPreferredSize(new Dimension(200, 50));
		btcal.setPreferredSize(new Dimension(200, 50));
		btacc.setPreferredSize(new Dimension(200, 50));
		
		btmemo.setVerticalAlignment(JButton.CENTER);
		btcal.setVerticalAlignment(JButton.CENTER);
		btacc.setVerticalAlignment(JButton.CENTER);
		
		panelmemo.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelcal.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelacc.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelmemo.add(btmemo, new GridBagConstraints());
		panelcal.add(btcal, new GridBagConstraints());
		panelacc.add(btacc, new GridBagConstraints());
		
		add(paneltitle);
		add(panelmemo);
		add(panelcal);
		add(panelacc);
		setLayout(new GridLayout(4, 1, 0, 30));
		setTitle("Main Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		setResizable(false);
		
	}
	
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if(source == btmemo){
			new MemoMain();
		}
		if(source == btcal){
			new CalculatorMain();
			
		}
		if(source == btacc){
			new AccountMain();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new Main();
	}

}