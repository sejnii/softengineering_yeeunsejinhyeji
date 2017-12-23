import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class ConvertLength extends JFrame implements ActionListener {

   JPanel paneltitle, panelcon, panelselect;
   JRadioButton rbinchtocm, rbcmtoinch;
   JTextField tffirst, tfsecond;
   JLabel lbfirst, lbsecond, lbtitle;
   JButton btconvert;
   int flag;
   public ConvertLength(){
      
      paneltitle = new JPanel();
      panelselect = new JPanel();
      panelcon = new JPanel();
      
   ////////////////title panel/////////////////////
      
      lbtitle = new JLabel("inch <-> cm");
      lbtitle.setFont(new Font("굴림", Font.BOLD, 20));
      paneltitle.setLayout(new FlowLayout());
      paneltitle.add(lbtitle);
   
      ///////////////selection panel////////////////
      
      ButtonGroup group = new ButtonGroup();
      rbinchtocm = new JRadioButton("inch -> cm");
      rbcmtoinch = new JRadioButton("cm -> inch");
      group.add(rbcmtoinch);
      group.add(rbinchtocm);
      rbinchtocm.addActionListener(this);
      rbcmtoinch.addActionListener(this);
      panelselect.setLayout(new FlowLayout(FlowLayout.CENTER,100,0 ) );
      panelselect.add(rbinchtocm);
      panelselect.add(rbcmtoinch);
      
      
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
      setTitle("Length Conversion");
      setSize(500, 300);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
      setVisible(true);
      setResizable(false);
   
      
      
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      JFrame frame = new ConvertLength();
      
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
      if(source == rbinchtocm){
         flag = 1;
         lbfirst.setText("inch");
         lbsecond.setText("cm");
      }
      else if(source == rbcmtoinch){
         flag = 2;
         lbfirst.setText("cm");
         lbsecond.setText("inch");
      }
   
      else if(source == btconvert){
         float n = Float.parseFloat(tffirst.getText());
         if(flag ==1){
            tfsecond.setText(""+inchtocm(n));
            
         }
         if(flag ==2){
            tfsecond.setText(""+cmtoinch(n));
         }
      }
   }
   
   
   private float inchtocm (float a){
      return (float) (a*2.54);
   }
   
   private float cmtoinch (float a){
      return (float) (a/2.54);
   }
   
   

}