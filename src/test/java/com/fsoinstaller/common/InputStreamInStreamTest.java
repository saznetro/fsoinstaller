package com.fsoinstaller.common;

import org.mockito.Mockito;
import org.testng.annotations.Test;

public class InputStreamInStreamTest {
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testTotalBytesBiggerThanAllowedFail(){
		//GIVEN
		long totalBytes= ((long)Integer.MAX_VALUE+1);
		//WHEN
		 new InputStreamInStream(null, totalBytes);
		//THEN
		//exception
	}
	
	@Test(expectedExceptions = NullPointerException.class)
	public void testInputStreamSourceIsNullFail(){
		//GIVEN
		InputStreamSource inputStreamSource=null;
		//WHEN
		 new InputStreamInStream(inputStreamSource, 1);
		//THEN
		//exception
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testTotalBytesLesserThanAllowedFail(){
		//GIVEN
		InputStreamSource inputStreamSource=Mockito.mock(InputStreamSource.class);
		//WHEN
		 new InputStreamInStream(inputStreamSource, -1);
		//THEN
		//exception
	}
}
