import javax.print.attribute.AttributeSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;


public class MemoMain extends JFrame implements ActionListener {
	int previouslist=0;
	static JFrame frame;
	JLabel lbtitle, check;
	JButton btnrevalidate, btnwrite;
	JButton[] btnrevise, btndelete;
	JPanel panel, ptop, prefresh, pmemo, pcenter, plineend, pbottom;
	JLabel[][] memo_table_label;
	//JLabel[] check1, check2;
	static Vector<String> memo_content;
	int memocnt=0;
	static int edit_index;
	int memo_table_row = 15;
	int memo_table_column=3;
	
	public static String getMemoContent(int edit_index) {
		return memo_content.elementAt(edit_index);
	}
	
	public static void setMemoContent(int edit_index, String edit_content) {
		memo_content.setElementAt(edit_content, edit_index);
	}
	
	public static void setMemoContent(String edit_content) {
		memo_content.addElement(edit_content);
	}
	
	public MemoMain() {
		setTitle("MemoMain");
		setSize(500,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		memo_content = new Vector<String>();
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		ptop = new JPanel();
		ptop.setLayout(new BoxLayout(ptop, BoxLayout.Y_AXIS));
		prefresh = new JPanel();
		prefresh.setLayout(new BorderLayout());
		btnrevalidate = new JButton("새로고침");
		btnrevalidate.addActionListener(this);
		prefresh.add(btnrevalidate,BorderLayout.LINE_END);
		ptop.add(prefresh);
		
		lbtitle = new JLabel("Memo Manager");
		lbtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		ptop.add(lbtitle);
		panel.add(ptop, BorderLayout.PAGE_START);
		
		pmemo = new JPanel();
		pmemo.setSize(400, 450);
		panel.add(pmemo, BorderLayout.LINE_START);
		

		pcenter = new JPanel();
		pcenter.setLayout(new BoxLayout(pcenter, BoxLayout.Y_AXIS));
		panel.add(pcenter, BorderLayout.CENTER);
		
		plineend = new JPanel();
		plineend.setLayout(new BoxLayout(plineend, BoxLayout.Y_AXIS));
		panel.add(plineend, BorderLayout.LINE_END);
		
		pbottom = new JPanel();
		btnwrite = new JButton("메모 작성");
		btnwrite.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnwrite.addActionListener(this);
		pbottom.add(btnwrite);
		panel.add(pbottom, BorderLayout.PAGE_END);
		
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frame = new MemoMain();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == btnwrite) {
			new MemoWrite();
		}
		if(source == btnrevalidate) {
			
			memo_table_label = new JLabel[memo_content.size()][3];
			btnrevise = new JButton[memo_content.size()];
			btndelete = new JButton[memo_content.size()];
			check = new JLabel("                        ");
			//check1 = new JLabel[memo_content.size()];
			//check2 = new JLabel[memo_content.size()];
			
			
			
			for(int i=previouslist; i<memo_content.size(); i++) {
				memo_table_label[i][0]= new JLabel(memo_content.elementAt(i));
				memo_table_label[i][0].setAlignmentY(Component.LEFT_ALIGNMENT);
				memo_table_label[i][0].setSize(300, 20);
				
				btnrevise[i] = new JButton("수정");
				int edit_index=i;
				btnrevise[i].addActionListener(new ActionListener(){

	                  @Override
	                  public void actionPerformed(ActionEvent arg0) {
	                     // TODO Auto-generated method stub
	                     new MemoEdit(edit_index);
	                  }
	                  
	               });
				btnrevise[i].setSize(60, 17);
				memo_table_label[i][1] = new JLabel("                        ");
				memo_table_label[i][1].setSize(80, 20);
				memo_table_label[i][1].add(btnrevise[i]);
				
				btndelete[i] = new JButton("삭제");
				//btndelete[i].addActionListener(this);
				btndelete[i].setSize(60, 17);
				memo_table_label[i][2] = new JLabel("                         ");
				memo_table_label[i][2].setSize(80, 20);
				memo_table_label[i][2].add(btndelete[i]);
				
				//check1[i] = new JLabel("                  ");
				//check2[i] = new JLabel("                  ");
				
				for(int j=0; j<memo_table_column; j++) {
					pmemo.add(memo_table_label[i][j]);
					pmemo.add(check);
					//pcenter.add(check1[i]); 
					//plineend.add(check2[i]);
					//pmemo.add(check);
				}
				
			}
			
			previouslist = memo_content.size();
			
			frame.getContentPane().revalidate();
		}
		/*
		for(int i=0; i<memo_content.size(); i++) {
			if(source == btnrevise[i]) {
				MemoMain.getMemoContent(i);
				new MemoEdit();
			}
		}
		*/		
	}

}
                            