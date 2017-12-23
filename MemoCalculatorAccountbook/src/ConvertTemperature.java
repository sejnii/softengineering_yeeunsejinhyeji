import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ConvertTemperature extends JFrame implements ActionListener {

   JPanel paneltitle, panelcon, panelselect;
   JRadioButton rbftoc, rbctof;
   JTextField tffirst, tfsecond;
   JLabel lbfirst, lbsecond, lbtitle;
   JButton btconvert;
   int flag;
   public ConvertTemperature(){
      
      
      start();
      paneltitle = new JPanel();
      panelselect = new JPanel();
      panelcon = new JPanel();
      
   ////////////////title panel/////////////////////
      
      lbtitle = new JLabel("°F <-> °C");
      lbtitle.setFont(new Font("굴림", Font.BOLD, 20));
      paneltitle.setLayout(new FlowLayout());
      paneltitle.add(lbtitle);
   
      ///////////////selection panel////////////////
      
      ButtonGroup group = new ButtonGroup();
      rbftoc = new JRadioButton("°F -> °C");
      rbctof = new JRadioButton("°C -> °F");
      group.add(rbctof);
      group.add(rbftoc);
      rbftoc.addActionListener(this);
      rbctof.addActionListener(this);
      panelselect.setLayout(new FlowLayout(FlowLayout.CENTER,100,0 ) );
      panelselect.add(rbftoc);
      panelselect.add(rbctof);
      
      
      ///////////////////////conversion panel////////////////////////////
      
      tffirst = new JTextField(10);
      tfsecond = new JTextField(10);
      tfsecond.setEditable(false);
      lbfirst = new JLabel();
      lbsecond = new JLabel();
      btconvert = new JButton("->");
      btconvert.addActionListener(this);
      panelcon.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
      panelcon.add(tffirst);
      panelcon.add(lbfirst);
      panelcon.add(btconvert);
      panelcon.add(tfsecond);
      panelcon.add(lbsecond);
      
      tffirst.setDocument(new JTextFieldLimit(10));
      
      ////////////////////////////////////////////////
      
      setLayout(new GridLayout(3,1, 0, 20));
      add(paneltitle);
      add(panelselect);
      add(panelcon);
      setTitle("Temperature Conversion");
      setSize(500, 300);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
      setVisible(true);
      setResizable(false);
   
      
      
   }
   public void start(){
      this.addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent e){
            setVisible(false);
            dispose();
         }
      });
         
         
      
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

   
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      JFrame frame = new ConvertTemperature();
      

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object source = e.getSource();
      // TODO Auto-generated method stub
      if(source == rbftoc){
         flag = 1;
         lbfirst.setText("°F");
         lbsecond.setText("°C");
      }
      else if(source == rbctof){
         flag = 2;
         lbfirst.setText("°C");
         lbsecond.setText("°F");
      }
   
      else if(source == btconvert){
         float n = Float.parseFloat(tffirst.getText());
         if(flag ==1){
            tfsecond.setText(""+ftoc(n));
            
         }
         if(flag ==2){
            tfsecond.setText(""+ctof(n));
         }
      }
   }
   
   
   public float ftoc (float a){
      return (float) ((a-32) / 1.8);
   }
   
   private float ctof (float a){
      return (float) (a*1.8) +32;
   }
   
   

}