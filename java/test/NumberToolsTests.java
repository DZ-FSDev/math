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

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.annotation.Timed;

/**
 * Utility class containing common methods to process numbers.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
class NumberToolsTests {

	@ParameterizedTest
	@CsvSource(value = {
			"36028797018963913:true", 
			"312679:true", 
			"1373:true", 
			"123:false", 
			"55:false", 
			"1:false", 
			"0:false", 
			"-5:false"}, delimiter = ':')
	@Timed(millis = 100)
	void isPrime_returns(long number, boolean isPrime) {
		assertEquals(isPrime, NumberTools.isPrime(number));
	}
}
