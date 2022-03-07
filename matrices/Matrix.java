/*  Original Licensing Copyright
 * 
 *  Represents an immutable Matrix of Numbers.
 *  Copyright (C) 2022  DZ-FSDev
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
package com.dz_fs_dev.math.matrices;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * Represents a Matrix of {@link Number}s. This implementation sports
 * immutability in that all operations will produce a new instance of
 * {@link Matrix}.
 * 
 * @param <T> The data type to be stored in this matrix. Must extend
 *            {@link Number}.
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.16
 */
public class Matrix<T extends Number> {
	private T[][] data;

	/**
	 * Initializes a new instance of a Matrix of {@link Number}s of specified
	 * dimensions.
	 * 
	 * @param rows The number of rows this matrix shall have. Cannot be less
	 *             than 1.
	 * @param columns The number of columns this matrix shall have. Cannot be
	 *                less than 1.
	 * @param fill The starting value to set all elements of the matrix to.
	 *             Cannot be null.
	 * @since 0.0.1
	 */
	@SuppressWarnings("unchecked")
	public Matrix(int rows, int columns, Number fill) {
		if(rows < 1)
			throw new IllegalArgumentException(
					"Rows cannot be less than 1 for a given matrix.");
		if(columns < 1)
			throw new IllegalArgumentException(
					"Columns cannot be less than 1 for a given matrix.");
		if(fill == null)
			throw new NullPointerException(
					"Matrix cannot be flled with null.");

		data = (T[][]) Array.newInstance(fill.getClass(), columns, rows);
		for(T[] x : data) {
			for(int y = 0; y < x.length; y++)
				x[y] = (T) fill;
		}
	}


	/**
	 * Initializes a new instance of a Matrix based off a 2D array of
	 * {@link Number}s.
	 * 
	 * @param data The data to initialize this Matrix with.
	 * @since 0.0.6
	 */
	@SuppressWarnings("unchecked")
	public Matrix(T[][] data) {
		this.data = (T[][]) new Number[data.length][data[0].length];
		for(int x = 0; x < data.length; x++) {
			for(int y = 0; y < data[x].length; y++) {
				this.data[x][y] = data[x][y];
			}
		}
	}

	/**
	 * Internal constructor.
	 * 
	 * @param data
	 * @param sender
	 * @since 0.0.7
	 */
	private Matrix(T[][] data, Matrix<T> sender) {
		this.data = data;
	}

	/**
	 * Adds a given pair of {@link Number}s. Supports major implementations
	 * including:
	 * <ul>
	 *   <li>{@link Integer}
	 *   <li>{@link Long}
	 *   <li>{@link Float}
	 *   <li>{@link Double}
	 *   <li>{@link BigInteger}
	 *   <li>{@link BigDecimal}
	 *   <li>{@link Rational}
	 * </ul>
	 * 
	 * @param <T> The type of the numbers to be added; must be a subclass of
	 *            {@link Number}.
	 * @param t The left augend in an add operation.
	 * @param t2 The right augend in an add operation.
	 * @return The sum of the operation.
	 * @since 0.0.12
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Number> T add(T t, T t2) {
		if(t instanceof Long)
			return (T)Long.valueOf(t.longValue() + t2.longValue());
		else if(t instanceof Integer)
			return (T)Integer.valueOf(t.intValue() + t2.intValue());
		else if(t instanceof Float)
			return (T)Float.valueOf(t.intValue() + t2.intValue());
		else if(t instanceof Double)
			return (T)Double.valueOf(t.intValue() + t2.intValue());
		else if(t instanceof BigInteger)
			return (T)(((BigInteger)t).add((BigInteger)t2));
		else if(t instanceof BigDecimal)
			return (T)(((BigDecimal)t).add((BigDecimal)t2));
		else if(t instanceof Rational)
			return (T)(((Rational)t).add((Rational)t2));
		throw new UnsupportedOperationException(
				String.format("%s adding is not supported.", t.getClass()));
	}
	
	/**
	 * Subtracts a given pair of {@link Number}s. Supports major
	 * implementations including:
	 * <ul>
	 *   <li>{@link Integer}
	 *   <li>{@link Long}
	 *   <li>{@link Float}
	 *   <li>{@link Double}
	 *   <li>{@link BigInteger}
	 *   <li>{@link BigDecimal}
	 *   <li>{@link Rational}
	 * </ul>
	 * 
	 * @param <T> The type of the numbers to be subtracted; must be a subclass
	 *            of {@link Number}.
	 * @param t The left subtrahend of the subtract operation.
	 * @param t2 The right subtrahend of the subtract operation.
	 * @return The difference of the operation.
	 * @since 0.0.15
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Number> T subtract(T t, T t2) {
		if(t instanceof Long)
			return (T)Long.valueOf(t.longValue() - t2.longValue());
		else if(t instanceof Integer)
			return (T)Integer.valueOf(t.intValue() - t2.intValue());
		else if(t instanceof Float)
			return (T)Float.valueOf(t.intValue() - t2.intValue());
		else if(t instanceof Double)
			return (T)Double.valueOf(t.intValue() - t2.intValue());
		else if(t instanceof BigInteger)
			return (T)(((BigInteger)t).subtract((BigInteger)t2));
		else if(t instanceof BigDecimal)
			return (T)(((BigDecimal)t).subtract((BigDecimal)t2));
		else if(t instanceof Rational)
			return (T)(((Rational)t).subtract((Rational)t2));
		throw new UnsupportedOperationException(
				String.format("%s adding is not supported.", t.getClass()));
	}

	/**
	 * 
	 * 
	 * @param augend
	 * @return
	 * @since 0.0.8
	 */
	@SuppressWarnings("unchecked")
	public Matrix<T> add(Matrix<T> augend) {
		T[][] newData = (T[][]) Array.newInstance(data[0][0].getClass(), data.length, data[0].length);

		for(int x = 0; x < data.length; x++) {
			for(int y = 0; y < data[x].length; y++) {
				newData[x][y] = add(this.data[x][y], augend.data[x][y]);
			}
		}

		return new Matrix<T>(newData, this);
	}
	
	/**
	 * 
	 * @param scalar
	 * @return
	 * @since 0.0.16
	 */
	public Matrix<T> add(T scalar) {
		T[][] newData = (T[][]) Array.newInstance(data[0][0].getClass(), data.length, data[0].length);

		for(int x = 0; x < data.length; x++) {
			for(int y = 0; y < data[x].length; y++) {
				newData[x][y] = add(this.data[x][y], scalar);
			}
		}

		return new Matrix<T>(newData, this);
	}

	/**
	 * 
	 * 
	 * @param subtrahend
	 * @return
	 * @since 0.0.13
	 */
	@SuppressWarnings("unchecked")
	public Matrix<T> subtract(Matrix<T> subtrahend) {
		T[][] newData = (T[][]) Array.newInstance(data[0][0].getClass(), data.length, data[0].length);

		for(int x = 0; x < data.length; x++) {
			for(int y = 0; y < data[x].length; y++) {
				newData[x][y] = subtract(this.data[x][y], subtrahend.data[x][y]);
			}
		}

		return new Matrix<T>(newData, this);
	}

	/**
	 * @since 0.0.5
	 */
	@Override
	public String toString() {
		return ("Matrix [data=" + Arrays.deepToString(data) + "]")
				.replace("], ", "\n").replace("]", "").replace("[", "");
	}
}
