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

import org.apache.commons.math.exception.NullArgumentException;

/**
 * Utility class containing common methods to process bytes and byte arrays.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.3*
 */
public final class ByteTools {
	private ByteTools() {}

	/**
	 * Attempts to increment the byte array by a specified amount. Overflows
	 * will not throw exceptions. If a null or empty byte array is specified,
	 * this method will return the argument as is.
	 * 
	 * @param in The specified byte array to be incremented.
	 * @param amount The specified amount to increment the byte array by.
	 * @return A new byte array following the increment.
	 * @since 0.0.3
	 */
	public static byte[] silentIncrement(byte[] in, long amount) {
		if(in == null || in.length == 0)return in;
		byte[] ret = Arrays.copyOf(in, in.length);
		for (int i = 0; i < in.length; i++) {
			int change = (int) (amount % Math.pow(2, i + 1));
			amount -= change;
			ret[in.length - 1 - i] += change;
		}

		return ret;	
	}

	/**
	 * Increment the byte array by a specified amount. Overflows and underflows
	 * will throw an exception.
	 * 
	 * @param in The specified byte array to be incremented.
	 * @param amount The specified amount to increment the byte array by.
	 * @return A new byte array following the increment.
	 * @throws NullArgumentException
	 * @throws IllegalArgumentException
	 * @throws UnsupportedOperationException Thrown when overflow or underflow
	 *         occurs.
	 * @since 0.0.3
	 */
	public static byte[] increment(byte[] in, long amount) throws NullArgumentException, IllegalArgumentException, UnsupportedOperationException {
		if(in == null) {
			throw new NullArgumentException();
		}else if(in.length == 0) {
			throw new IllegalArgumentException("");
		}
		
		byte[] ret = in.clone();

		if(true) { //TODO
			throw new UnsupportedOperationException(String.format("Incrementing %s will result in overflow.", Arrays.toString(in)));
		}

		return ret;
	}
}
