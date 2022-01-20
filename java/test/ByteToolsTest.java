package com.dz_fs_dev.math.tools;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ByteToolsTest {
	@Test
	void silentIncrement_emptyArray_returnsSameArray() {
		byte[] data = new byte[] {};
		assertEquals(data, ByteTools.silentIncrement(data, 1));
	}
	
	@Test
	void silentIncrement_returnsIncrementedClone() {
		byte[] data = new byte[] {1,5};
		String dataStr = Arrays.toString(data);
		
		assertEquals(Arrays.toString(new byte[] {1,6}),
				Arrays.toString(ByteTools.silentIncrement(data, 1)));
		assertEquals(dataStr, Arrays.toString(data));
	}
	
	@Test
	void silentIncrement2_emptyArray_returnsSameArray() {
		byte[] data = new byte[] {};
		assertEquals(data, ByteTools.silentIncrement2(data, 1));
	}
	
	@Test
	void silentIncrement2_returnsIncrementedClone() {
		byte[] data = new byte[] {1,5};
		String dataStr = Arrays.toString(data);
		
		assertEquals(Arrays.toString(new byte[] {1,6}),
				Arrays.toString(ByteTools.silentIncrement2(data, 1)));
		assertEquals(dataStr, Arrays.toString(data));
	}
}
