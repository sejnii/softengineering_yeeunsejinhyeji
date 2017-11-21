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
	JLabel lbtitle;
	JButton btnrefresh, btnwrite;
	Vector<JButton> btnrevise, btndelete;
	JPanel panel, ptop, prefresh, pmemo, previse, pdelete, pbottom;
	JTextField memo;
	Vector<JLabel> lbmemo;
	//DefaultListModel memomodel;
	
	public MemoMain() {
		setTitle("MemoMain");
		setSize(500,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbmemo = new Vector<JLabel>();
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		ptop = new JPanel();
		ptop.setLayout(new BoxLayout(ptop, BoxLayout.Y_AXIS));
		prefresh = new JPanel();
		prefresh.setLayout(new BorderLayout());
		btnrefresh = new JButton("새로고침");
		btnrefresh.addActionListener(this);
		prefresh.add(btnrefresh,BorderLayout.LINE_END);
		ptop.add(prefresh);
		
		lbtitle = new JLabel("Memo Manager");
		lbtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		ptop.add(lbtitle);
		
		//lbmemo = new JList(new DefaultListModel());
	    //memomodel = (DefaultListModel) lbmemo.getModel();
		memo = new JTextField(30);
		memo.setAlignmentX(Component.CENTER_ALIGNMENT);
		memo.setDocument(new BoundDocument(20,memo));
		memo.addKeyListener(new KeyAdapter(){
	         public void keyTyped(KeyEvent e){
	             if(e.getKeyChar() == KeyEvent.VK_ENTER){
	                lbmemo.addElement(new JLabel(memo.getText()));
	                memo.setText("");
	             }
	          }
	       });
		ptop.add(memo);
		
		panel.add(ptop, BorderLayout.PAGE_START);
		
		pmemo = new JPanel();
		pmemo.setLayout(new BoxLayout(pmemo, BoxLayout.Y_AXIS));
		for(int i=0; i<lbmemo.size(); i++) {
			pmemo.add(lbmemo.elementAt(i));
		}
		panel.add(pmemo, BorderLayout.LINE_START);
		
		previse = new JPanel();
		previse.setLayout(new BoxLayout(previse,BoxLayout.Y_AXIS));
		btnrevise = new Vector<JButton>();
		for(int i=0; i<lbmemo.size(); i++) {
			btnrevise.addElement(new JButton("수정"));
		}
		for(JButton btnrevise : btnrevise) {
			previse.add(btnrevise);
		}
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
	
	class BoundDocument extends PlainDocument {
		protected int charLimit;
		protected JTextComponent textComp;
		public BoundDocument(int charLimit) { this.charLimit = charLimit; }
		public BoundDocument(int charLimit, JTextComponent textComp) { this.charLimit = charLimit; this.textComp = textComp; }

		public void insertString (int offs, String str, AttributeSet a) throws BadLocationException
		{
		if (textComp.getText().getBytes().length + str.getBytes().length <= charLimit) { super.insertString(offs, str, (javax.swing.text.AttributeSet) a); }
		}
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemoMain();
		
		

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
                            