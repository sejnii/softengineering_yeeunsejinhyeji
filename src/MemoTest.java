import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;

import org.junit.Test;

public class MemoTest {

	@Test
	public void testMemoFileWrite() {
		int cnt=0;
		
		Vector <String> memo_test = new Vector <String>();
		MemoWrite memowrite = new MemoWrite();
		String data = "memotest";
		memowrite.memoFileWrite(data+"\r\n");
		String s="";
		try {
		BufferedReader reader = new BufferedReader(new FileReader("memo.txt"));
		
		while( (s=reader.readLine()) != null) {
			memo_test.add(s);
			cnt++;			
		}
		reader.close();
		}
		catch(IOException e) {}
		assertTrue(memo_test.elementAt(cnt-1).equals(data));
		
	}
	
	@Test
	public void testMemoFileEdit() {
		new MemoMain();
		int modify_index = 1;
		MemoEdit memoedit = new MemoEdit(modify_index);
		Vector <String> edit_test = new Vector <String>();
		
		
		String s = "memochange";
		memoedit.memoFileEdit(s+"\r\n");
		
		String scheck="";
		try {
			BufferedReader reader = new BufferedReader(new FileReader("memo.txt"));
			
			while( (scheck=reader.readLine()) != null) {
				edit_test.add(scheck);		
			}
			reader.close();
			}
			catch(IOException e) {}
				
		assertTrue(edit_test.elementAt(modify_index-1).equals(s));
		
	}

}
