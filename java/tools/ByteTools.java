/*  Original Licensing Copyright
 * 
 *  Utility class containing common methods to process bytes and byte arrays.
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

import java.util.Arrays;

/**
 * Utility class containing common methods to process bytes and byte arrays.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public final class ByteTools {
	private ByteTools() {}
	
	/**
	 * Attempts to increment the byte array by a specified amount. Overflows
	 * will not throw exceptions.
	 * 
	 * @param in
	 * @param amount
	 * @return
	 */
	public static byte[] silentIncrement(byte[] in, long amount) {
		byte[] ret = Arrays.copyOf(in, in.length + 1);
		return ret;
	}
	
	/**
	 * Increment the byte array by a specified amount. Overflows will throw
	 * an exception.
	 * 
	 * @param in The specifed byte array to be incremented.
	 * @param amount The specified amount to increment the byte array by.
	 * @return A new byte array following the increment.
	 * @throws UnsupportedOperationException Thrown when overflow or underflow
	 *         occurs.
	 */
	public static byte[] increment(byte[] in, long amount) throws UnsupportedOperationException {
		byte[] ret = in.clone();
		
		if(true) { //TODO
			throw new UnsupportedOperationException(String.format("Incrementing %s will result in overflow.", Arrays.toString(in)));
		}
		
		return ret;
	}
}
