/*  Original Licensing Copyright
 * 
 *  Copyright (C) 2021  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.dz_fs_dev.math.tools;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Contains a battery of tests to assess whether the {@link ByteTools} class
 * conforms to requirements.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.1.1
 */
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
}
