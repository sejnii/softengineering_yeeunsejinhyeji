import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;


public class MemoMain{
   public static JFrame frame;
   JLabel lbtitle, check;
   JButton btnwrite;
   JButton[] memo_modify_button;
   JButton[] memo_delete_button;
   JPanel panel, ptop, pmemo, pbottom;
   JPanel pcenter;
   JLabel[][] memo_table_label;
   
   public static Vector<String> memo_vec ;
   static int delete_index;
   int memo_cnt=1;
   

   public static String getMemoContent(int edit_index) {
      return memo_vec.elementAt(edit_index);
   }
   
   public static void setMemoContent(int edit_index, String edit_content) {
      memo_vec.setElementAt(edit_content, edit_index);
   }
   
   public static void setMemoContent(String edit_content) {
      memo_vec.addElement(edit_content);
   }
   
   public MemoMain() {
      
      
      frame = new JFrame();
       frame.setTitle("MemoMain");
      
      panel = new JPanel();
      panel.setLayout(new BorderLayout());
      
      ptop = new JPanel();
      lbtitle = new JLabel("Memo Manager");
      lbtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      ptop.add(lbtitle);
      panel.add(ptop, BorderLayout.PAGE_START);
      
      pcenter = new JPanel();
      pcenter.setLayout(new GridLayout(0,3));
      memo_vec = new Vector<String>();
      memo_vec.add(0," ");
      memo_table_label = new JLabel[20][3];
      
      
      memo_table_label[0][0]=new JLabel("메모 내용");
      memo_table_label[0][1]=new JLabel("수  정");
      memo_table_label[0][2]=new JLabel("삭  제");
      
      
      try {
      BufferedReader reader = new BufferedReader(new FileReader("memo.txt"));
      String memo_str="";
     
      while((memo_str = reader.readLine())!=null) {
         memo_vec.add( memo_cnt, memo_str);
         memo_cnt++;
      }
      
      reader.close();
   
      
      memo_modify_button = new JButton[memo_cnt];
      memo_delete_button = new JButton[memo_cnt];
      
      for(int i=0; i<3; i++)
         pcenter.add(memo_table_label[0][i]);
      
      panel.add(pcenter);

      for(int i=1; i<memo_cnt; i++) {
         
         memo_table_label[i][0] = new JLabel(memo_vec.elementAt(i));
         memo_table_label[i][0].setAlignmentY(Component.LEFT_ALIGNMENT);
         memo_table_label[i][0].setSize(300, 20);
         
         memo_modify_button[i] = new JButton("수  정");
         memo_modify_button[i].setSize(80, 17);
         memo_table_label[i][1] = new JLabel();
         memo_table_label[i][1] = new JLabel("                                ");
         memo_table_label[i][1].setSize(100, 20);
         memo_table_label[i][1].add(memo_modify_button[i]);
         memo_modify_button[i].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
               // TODO Auto-generated method stub
               int modify_index=0;
                  for(int j=1;j<memo_cnt;j++) {
                     if(e.getSource()==memo_modify_button[j]) {
                        modify_index = j;
                     }
                  }
                  new MemoEdit(modify_index);   
            }
         });
                        
      
         
         memo_delete_button[i] = new JButton("삭  제");
         memo_delete_button[i].setSize(80, 17);
         memo_table_label[i][2] = new JLabel();
         memo_table_label[i][2] = new JLabel("                                ");
         memo_table_label[i][2].setSize(100, 20);
         memo_table_label[i][2].add(memo_delete_button[i]);
         delete_index = i;
         memo_delete_button[i].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                  // TODO Auto-generated method stub
               try {   
                  @SuppressWarnings("resource")
                  Writer memo_writer = new BufferedWriter(new FileWriter("memo.txt"));
               
                  
               for(int j=1;j<memo_cnt;j++) {
                  if(e.getSource()!=memo_delete_button[j]) {
                     memo_writer.write(memo_vec.elementAt(j)+"\r\n");
                  }
               }
               memo_writer.close();
               }
               catch(IOException e1) {
                  
               }
                     MemoMain.dispose();
                     new MemoMain();
               }
            });
         
         
         for(int j=0; j<3; j++)
            pcenter.add(memo_table_label[i][j]);
         
         panel.add(pcenter);
      }
      
      
      }
      catch(IOException e) {
    	  for(int j=0;j<3;j++)
    		  pcenter.add(memo_table_label[0][j]);
      }
      
      panel.add(pcenter, BorderLayout.CENTER);
      
      pbottom = new JPanel();
      btnwrite = new JButton("메모 작성");
      btnwrite.setAlignmentX(Component.RIGHT_ALIGNMENT);
      btnwrite.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
               new MemoWrite();
            
         }
      });
      
       frame.setBounds(200,200,100*3+100,38*memo_cnt+60+20);
         panel.setSize(100*3, 35*memo_cnt+50);
         
         for (int i=0; i<memo_cnt; i++)
         {
            for(int j=0; j<3; j++)
            {
               memo_table_label[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
               memo_table_label[i][j].setVerticalAlignment(SwingConstants.CENTER);
               memo_table_label[i][j].setHorizontalAlignment(SwingConstants.CENTER);
           
            }
         }

      pbottom.add(btnwrite);
      panel.add(pbottom, BorderLayout.PAGE_END);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.add(panel);
      frame.setVisible(true);
   }
   
   public static void dispose() {
      frame.dispose();
   }
   
   public static void main(String[] args)  {
      // TODO Auto-generated method stub
         
            new MemoMain();
         
         
      
   }
   


   

}
                            