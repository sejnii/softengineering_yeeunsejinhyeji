import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import javax.swing.text.BadLocationException;



public class CalculatorMain extends JFrame implements ActionListener{


	static JFrame frame;
	JPanel paneltitle, panelcal, panelcon;
	JLabel lbtitle, lboperator;
	JTextField tfoperand1, tfoperand2, tfresult; 
	JButton btplus, btminus, btmultiply, btdivide, btequal, bttempcon, btweightcon, btlengcon;
	float result;
	int operatorflag;
	public CalculatorMain(){
		
		
		
		
		paneltitle = new JPanel();
		panelcal = new JPanel();
		panelcon = new JPanel();
		
		///////////title panel//////////
		
		
		lbtitle = new JLabel("Calculator");
		lbtitle.setFont(new Font("굴림", Font.BOLD, 20));
		paneltitle.setLayout(new FlowLayout());
		paneltitle.add(lbtitle);
		
		
		///////////////calculation panel//////////////
		
		JPanel panelcalnorth, panelcalcenter, panelcalsouth;
		
		panelcalnorth = new JPanel();
		panelcalcenter = new JPanel();
		panelcalsouth = new JPanel();
		
		tfoperand1 = new JTextField(10);
		tfoperand2 = new JTextField(10);
		
		lboperator = new JLabel();
		lboperator.setFont(new Font("굴림", Font.BOLD, 15));
		
		btplus = new JButton("+");
		btplus.addActionListener((ActionListener) this);
		btminus = new JButton("-");
		btminus.addActionListener((ActionListener) this);
		btmultiply= new JButton("*");
		btmultiply.addActionListener((ActionListener) this);
		btdivide = new JButton("/");
		btdivide.addActionListener((ActionListener) this);
		btequal = new JButton("=");
		btequal.addActionListener((ActionListener) this);
		
		tfresult = new JTextField(30);
		tfresult.setEditable(false);
		
		panelcalnorth.setLayout(new FlowLayout(FlowLayout.CENTER, 30,0));
		panelcalnorth.add(tfoperand1);
		panelcalnorth.add(lboperator);
		panelcalnorth.add(tfoperand2);
		
		tfoperand1.setDocument(new JTextFieldLimit(10));
		tfoperand2.setDocument(new JTextFieldLimit(10));
		
		panelcalcenter.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
		panelcalcenter.add(btplus);
		panelcalcenter.add(btminus);
		panelcalcenter.add(btmultiply);
		panelcalcenter.add(btdivide);
		panelcalcenter.add(btequal);

		panelcalsouth.setLayout(new FlowLayout());
		panelcalsouth.add(tfresult);
		
		panelcal.setBorder(BorderFactory.createTitledBorder("Calculator"));
		panelcal.setLayout(new GridLayout(3,1,20, 20));
		panelcal.add(panelcalnorth);
		panelcal.add(panelcalcenter);
		panelcal.add(panelcalsouth);
		
	
		
		//////////conversion panel/////////////
		
		bttempcon = new JButton("°F <-> °C");
		btweightcon = new JButton("pound<->kg");
		btlengcon = new JButton("inch<->cm");
		bttempcon.addActionListener(this);
		btweightcon.addActionListener(this);
		btlengcon.addActionListener(this);
		panelcon.setBorder(BorderFactory.createTitledBorder("Unit Conversion"));
		panelcon.setLayout(new GridLayout(3,1,20, 20));
		panelcon.add(bttempcon);
		panelcon.add(btweightcon);
		panelcon.add(btlengcon);
			
		
		
		
		///////////////////////////////////////////
		
		
		add(paneltitle, BorderLayout.NORTH);
		add(panelcal, BorderLayout.CENTER);
		add(panelcon, BorderLayout.EAST);
		setTitle("Calculator");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		setVisible(true);
		setResizable(false);
	
	}
	
	
	public float add(float a, float b){
		
		return a+b;
		
	}
	
	public float minus(float a, float b){
		
		return a-b;
		
	}
	
	public float multiply(float a, float b){
		
		return a*b;
		
	}
	
	public float divide(float a, float b){
		
		if(b==0)
			throw new ArithmeticException();
		return a/b;
		
	}
	
	class JTextFieldLimit extends PlainDocument {
		  private int limit;
		  JTextFieldLimit(int limit) {
		    super();
		    this.limit = limit;
		  }

		  JTextFieldLimit(int limit, boolean upper) {
		    super();
		    this.limit = limit;
		  }

		  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		    if (str == null)
		      return;

		    if ((getLength() + str.length()) <= limit) {
		      super.insertString(offset, str, attr);
		    }
		  }
		}

	
	public static void main(String[] args) throws ParseException {
		frame = new CalculatorMain();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == btplus ){
			operatorflag = 1;
			lboperator.setText("+");
		}
		else if(source == btminus){
			operatorflag = 2;
			lboperator.setText("-");
		}
		else if(source == btmultiply){
			operatorflag = 3;
			lboperator.setText("*");
		}
		else if(source == btdivide){
			operatorflag = 4;
			lboperator.setText("/");
		}
		
		else if(source == btequal){
			switch(operatorflag){
			case 1:
				float a = Float.parseFloat(tfoperand1.getText());
				float b = Float.parseFloat(tfoperand2.getText());
				result = add(a,b);
				break;
			case 2:
				a = Float.parseFloat(tfoperand1.getText());
				b = Float.parseFloat(tfoperand2.getText());
				result = minus(a,b);
				break;
			case 3: 
				a = Float.parseFloat(tfoperand1.getText());
				b = Float.parseFloat(tfoperand2.getText());
				result = multiply(a,b);
				break;
			case 4: 
				try{
				a = Float.parseFloat(tfoperand1.getText());
				b = Float.parseFloat(tfoperand2.getText());
				result = divide(a,b);}
				catch(Exception z){
					JOptionPane.showMessageDialog(frame, "error : division by zero");
					break;
				}
				break;
			}
			tfresult.setText(""+result);
		}
		
		else if(source == bttempcon){
			Frame f = new ConvertTemperature();
			f.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					f.setVisible(false);
					f.dispose();
				}
			});
			
		}
		else if( source == btlengcon){
			new ConvertLength();
		}
		else if(source == btweightcon){
			new ConvertWeight();
		}
	}
}

