import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.*;

public class MemoEdit extends JFrame implements ActionListener {
   
   JPanel panel, ptitle, ptfmemo, pbtnrevise;
   JLabel lbtitle, lblimit;
   JButton btnrevise;
   JTextField tfmemo;

   int modify_index;
   
   public MemoEdit(int edit_index) {
      modify_index = edit_index;
      setTitle("MemoEdit");
      setSize(500,300);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      panel = new JPanel();
      panel.setLayout(new BorderLayout());
      
      ptitle = new JPanel();
      ptitle.setLayout(new BoxLayout(ptitle, BoxLayout.Y_AXIS));
      
      lbtitle = new JLabel("메모 작성");
      lbtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      lblimit = new JLabel("메모는 20자 이내로 수정해주세요.");
      lblimit.setAlignmentX(Component.CENTER_ALIGNMENT);
      ptitle.add(lbtitle);
      ptitle.add(lblimit);
      panel.add(ptitle, BorderLayout.PAGE_START);
      
      ptfmemo = new JPanel();
      tfmemo = new JTextField(30);
      tfmemo.setText(MemoMain.getMemoContent(edit_index));
      
      
      
      ptfmemo.add(tfmemo);
      panel.add(ptfmemo,BorderLayout.CENTER);
      
      pbtnrevise = new JPanel();
      btnrevise = new JButton("저장");
      btnrevise.addActionListener(this);
      pbtnrevise.add(btnrevise);
      panel.add(pbtnrevise, BorderLayout.PAGE_END);
      
      add(panel);
      setVisible(true);
   }
   
   
   public void memoFileEdit(String s) {
      try {
         
         Writer memo_writer = new BufferedWriter(new FileWriter("memo.txt"));
         int length = MemoMain.memo_vec.size();
         
         for(int i=1;i<length;i++)
         {
            if(i!=modify_index) {
               memo_writer.write(MemoMain.getMemoContent(i)+"\r\n");}
            else {
               memo_writer.write(s);
               }
            }
      
         memo_writer.close();
      }
      catch(IOException e1) {
         
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      Object source = e.getSource();
      
      if(source == btnrevise) {
         
         String s = tfmemo.getText()+"\r\n";
         memoFileEdit(s);
         
         MemoMain.dispose();
         new MemoMain();
         this.dispose();
      }
   }

}