/*  Original Licensing Copyright
 * 
 *  Utility class containing common methods to process numbers.
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

import java.math.BigDecimal;

/**
 * Utility class containing common methods to process numbers.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
public final class NumberTools {
	private NumberTools() {}
	
	/**
	 * Performs a primality test; returns true if the specified number is
	 * prime and false otherwise.
	 * 
	 * @param number The specified number to undergo the primality test.
	 * @return True if the specified number is prime and false otherwise.
	 * @since 0.0.1
	 */
	public static boolean isPrime(long number) {
		for(long i = 2; i < number; i = i % 2 == 1 ? 2 : 1) {
			if(number % i == 0) return false;
		}
		
		return true;
	}
	
	/**
	 * Returns the significant figures in a specified BigDecimal.
	 * 
	 * @param decimal The specified BigDecimal.
	 * @return The significant figures in a specified BigDecimal.
	 * @since 0.0.2
	 */
	public static int calcSigFigs(BigDecimal decimal) {
		int precision = decimal.precision();
		int scale = decimal.scale();

		if(scale > 0) {
			return precision;
		}else {
			return decimal
					.stripTrailingZeros()
					.precision();
		}
	}
}
