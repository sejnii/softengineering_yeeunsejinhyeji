import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class AccountBookTest {

	@SuppressWarnings("static-access")
	@Test
	public void testAccountWrite() throws IOException 
	{
		AccountWrite write = new AccountWrite();
		
		String write_item="hot cappuccino";
		write.fileWrite("20171223", write_item, "4500");
		
		String write_line_item;
		String get_write_line_item = null;
		
		BufferedReader item_br = new BufferedReader(new FileReader("accountItem.txt"));
		while((write_line_item=item_br.readLine()) != null)
		{
			get_write_line_item=write_line_item;
		}

		item_br.close();
		
		assertTrue(get_write_line_item.equals(write_item));

	}

	@SuppressWarnings("static-access")
	@Test
	public void testAccounEdit() throws IOException 
	{
		String edit_item="[m]golden_cake";
		System.out.println("edit item: "+edit_item);
		
		AccountEdit.editfile(2, "20211215",edit_item , "500000");
	
		String edit_line_item;
		
		edit_line_item=Files.readAllLines(Paths.get("accountItem.txt")).get(2-1);
		System.out.println("edit line in txt"+edit_line_item);
		
		assertTrue(edit_line_item.equals(edit_item));

	}
	
	

}
