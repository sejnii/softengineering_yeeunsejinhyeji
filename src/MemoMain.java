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
	static JFrame frame;
	JLabel lbtitle;
	JButton btnrevalidate, btnwrite;
	//JButton btnrevise[], btndelete[];
	JPanel panel, ptop, prefresh, pmemo, previse, pdelete, pbottom;
	JTextField memo;
	//JLabel lbmemo;
	//DefaultListModel memomodel;
	JLabel[][] memo_table_label;
	static Vector<String> memo_content;
	int memocnt=0;
	int edit_index;
	
	public String getMemoContent(int edit_index) {
		return memo_content.elementAt(edit_index);
	}
	
	public void setMemoContent(int edit_index, String edit_content) {
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
		
		//memo_content.addElement("SS");

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
		
		/*
		memo = new JTextField(30);
		memo.setAlignmentX(Component.CENTER_ALIGNMENT);
		memo.setDocument(new BoundDocument(20,memo));
		memo.addKeyListener(new KeyAdapter(){
	         public void keyTyped(KeyEvent e){
	             if(e.getKeyChar() == KeyEvent.VK_ENTER){
	                lbmemo[memocnt] = new JLabel(memo.getText());
	                memocnt++;
	                memo.setText("");
	             }
	          }
	       });
		ptop.add(memo);
		*/
		panel.add(ptop, BorderLayout.PAGE_START);
		
		pmemo = new JPanel();
		memo_table_label = new JLabel[memo_content.size()][1];
		pmemo.setLayout(new BoxLayout(pmemo, BoxLayout.Y_AXIS));
		for(int i=0; i<memo_content.size(); i++) {
			memo_table_label[i][0] = new JLabel(memo_content.elementAt(i));
			pmemo.add(memo_table_label[i][0]);
		}
		
		panel.add(pmemo, BorderLayout.LINE_START);
		
		previse = new JPanel();
		previse.setLayout(new BoxLayout(previse,BoxLayout.Y_AXIS));
		/*btnrevise = new Vector<JButton>();
		for(int i=0; i<lbmemo.size(); i++) {
			btnrevise.addElement(new JButton("수정"));
		}
		for(JButton btnrevise : btnrevise) {
			previse.add(btnrevise);
		}*/
		panel.add(previse, BorderLayout.CENTER);
		
		pdelete = new JPanel();
		panel.add(pdelete, BorderLayout.LINE_END);
		
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
			frame.getContentPane().revalidate();
		}
		
		
	}

}
                            