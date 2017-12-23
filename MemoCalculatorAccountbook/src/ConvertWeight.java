import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;



public class ConvertWeight extends JFrame implements ActionListener {

   JPanel paneltitle, panelcon, panelselect;
   JRadioButton rbpoundtokg, rbkgtopound;
   JTextField tffirst, tfsecond;
   JLabel lbfirst, lbsecond, lbtitle;
   JButton btconvert;
   int flag;
   public ConvertWeight(){
      
      paneltitle = new JPanel();
      panelselect = new JPanel();
      panelcon = new JPanel();
      
   ////////////////title panel/////////////////////
      
      lbtitle = new JLabel("pound <-> kg");
      lbtitle.setFont(new Font("굴림", Font.BOLD, 20));
      paneltitle.setLayout(new FlowLayout());
      paneltitle.add(lbtitle);
   
      ///////////////selection panel////////////////
      
      ButtonGroup group = new ButtonGroup();
      rbpoundtokg = new JRadioButton("pound -> kg");
      rbkgtopound = new JRadioButton("kg -> pound");
      group.add(rbpoundtokg);
      group.add(rbkgtopound);
      rbpoundtokg.addActionListener(this);
      rbkgtopound.addActionListener(this);
      panelselect.setLayout(new FlowLayout(FlowLayout.CENTER,100,0 ) );
      panelselect.add(rbpoundtokg);
      panelselect.add(rbkgtopound);
      
      
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
      setTitle("Weight Conversion");
      setSize(500, 300);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
      setVisible(true);
      setResizable(false);
   
      
      
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      JFrame frame= new ConvertWeight();
      

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

   
   
   @Override
   public void actionPerformed(ActionEvent e) {
      Object source = e.getSource();
      // TODO Auto-generated method stub
      if(source == rbpoundtokg){
         flag = 1;
         lbfirst.setText("pound");
         lbsecond.setText("kg");
      }
      else if(source == rbkgtopound){
         flag = 2;
         lbfirst.setText("kg");
         lbsecond.setText("pound");
      }
   
      else if(source == btconvert){
         float n = Float.parseFloat(tffirst.getText());
         if(flag ==1){
            tfsecond.setText(""+poundtokg(n));
            
         }
         if(flag ==2){
            tfsecond.setText(""+kgtopound(n));
         }
      }
   }
   
   
   private float poundtokg (float a){
      return (float) (a*0.4535924 );
   }
   
   private float kgtopound (float a){
      return (float) (a/ 0.4535924);
   }
   
   

}