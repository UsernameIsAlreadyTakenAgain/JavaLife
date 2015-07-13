package com.laboon;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import org.mockito.Mockito;

public class WorldTest {
	
	//Test _size=6 (base case)
	//Test to see whether the result string have 7 lines
	@Test
	public void testToString6(){
		World w=new World(6,3,80);
		String str=w.toString();
		String[] lines = str.split("\r\n|\r|\n");
		assertTrue(str.contains("012345"));
		assertEquals(lines.length,7); //include the first line "012345" so it's 7
	}

	//Test _size=1 (edge case)
	//When the world is a 1*1 matrix, test to see whether the result is "  "+0+"\n"+0+" "+"."+"\n"
	@Test
	public void testToString1() {
		World w=new World(1,1,50);
		w._world[0][0]=Mockito.mock(Cell.class);
		Mockito.when(w._world[0][0].getStateRep()).thenReturn('@');
		String actual=w.toString();
		StringBuilder expect=new StringBuilder();
	    expect.append("  "+0+"\n"+0+" "+"@"+"\n");
		assertEquals(actual,expect.toString());
	}
	
	//Test _size=10 (edge case)
	//Test to see whether the values in the first row is "0123456789"
	@Test 
	public void testToString10(){
		World w=new World(10,1,50);
		String str=w.toString();
		assertTrue(str.contains("0123456789"));
		assertFalse(str.contains("01234567890")); //make sure it stop at "0123456789"
	}
	
	//Test _size=11 (edge case)
	//Test to see whether the values in the first row is "01234567890"
	@Test
	public void testToStringValue11(){
		World w=new World(11,1,50);
		String str=w.toString();
		assertTrue(str.contains("01234567890"));
	}
	
	//Test _size=11 (edge case)
	//Test to see whether the last object in the cell array will be called
	@Test
	public void testToStringMethod11(){
		World w=new World(11,1,50);
		w._world[10][10]=Mockito.mock(Cell.class);
		Mockito.when(w._world[10][10].getStateRep()).thenReturn('@');
		String str=w.toString();
		Mockito.verify(w._world[10][10]).getStateRep();
		assertTrue(str.contains("@"));
	}
	
	//Test _size=0 (edge case)
	//when the world size is 0*0, test to see whether the result will be "  "+"\n"
	@Test
	public void testToString0(){
		World w=new World(0,1,50);
		String str=w.toString();
		assertEquals(str,"  "+"\n");
	}
	
}
