import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.MaskFormatter;




public class CalculatorMain extends JFrame implements ActionListener{


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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
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
		
		return a/b;
		
	}
	
	public static void main(String[] args) throws ParseException {
		new CalculatorMain();
		
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
				a = Float.parseFloat(tfoperand1.getText());
				b = Float.parseFloat(tfoperand2.getText());
				result = divide(a,b);
				break;
			}
			tfresult.setText(""+result);
		}
		
	}
}

