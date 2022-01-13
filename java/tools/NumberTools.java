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
 * @version 0.0.3
 */
public final class NumberTools {
	private NumberTools() {
	}

	/**
	 * Performs a primality test; returns true if the specified number is prime and
	 * false otherwise. Prime numbers belong to the set of all natural numbers
	 * greater than 1. Such number cannot be built as a product of two smaller
	 * positive natural numbers greater than 1.
	 * 
	 * @param number The specified number to undergo the primality test.
	 * @return True if the specified number is prime and false otherwise.
	 * @since 0.0.3
	 */
	public static boolean isPrime(long number) {
		boolean isPrime = number > 3;
		if (number <= 3)
			isPrime = number > 1;

		if ((number % 2 == 0) || (number % 3 == 0))
			isPrime = false;

		for (long i = 5; isPrime && i * i <= number; i += 6) {
			if (number % i == 0 || number % (i + 2) == 0)
				isPrime = false;
		}

		return isPrime;
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

		if (scale > 0) {
			return precision;
		} else {
			return decimal.stripTrailingZeros().precision();
		}
	}
}
