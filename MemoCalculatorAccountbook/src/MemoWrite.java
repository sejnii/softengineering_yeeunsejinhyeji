import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.swing.text.AttributeSet;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MemoWrite extends JFrame implements ActionListener{
   
   JPanel panel, ptitle, ptfmemo, pbtnsave;
   JLabel lbtitle, lblimit;
   JButton btnsave;
   JTextField tfmemo;
   
   public MemoWrite() {
      setTitle("MemoWrite");
      setSize(500,300);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      panel = new JPanel();
      panel.setLayout(new BorderLayout());
      
      ptitle = new JPanel();
      ptitle.setLayout(new BoxLayout(ptitle, BoxLayout.Y_AXIS));
      
      lbtitle = new JLabel("메모 작성");
      lbtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      lblimit = new JLabel("메모는 20자 이내로 작성해주세요.");
      lblimit.setAlignmentX(Component.CENTER_ALIGNMENT);
      ptitle.add(lbtitle);
      ptitle.add(lblimit);
      panel.add(ptitle, BorderLayout.PAGE_START);
      
      ptfmemo = new JPanel();
      tfmemo = new JTextField(30);
      tfmemo.setDocument(new JTextFieldLimit(20));
      ptfmemo.add(tfmemo);
      panel.add(ptfmemo,BorderLayout.CENTER);
      
      pbtnsave = new JPanel();
      btnsave = new JButton("저  장");
      btnsave.addActionListener(this);
      pbtnsave.add(btnsave);
      panel.add(pbtnsave, BorderLayout.PAGE_END);
      
      add(panel);
      setVisible(true);
      
   }
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      new MemoWrite();
      
   }
   public void memoFileWrite(String data) {
      try {
         Writer memo_writer = new BufferedWriter(new FileWriter("memo.txt",true));
         memo_writer.append(data);
         memo_writer.close();
      }catch(IOException ex) {
         System.out.println("�삤瑜�");
      }
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      Object source = e.getSource();
      
      
      if(source == btnsave) {
         String data = tfmemo.getText()+"\r\n";
         
         memoFileWrite(data);
         
         MemoMain.dispose();
         new MemoMain();
         this.dispose();
         
      }
      
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
}