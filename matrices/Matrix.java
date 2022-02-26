package com.dz_fs_dev.math.matrices;

import java.lang.reflect.Array;

/**
 * Represents a Matrix of numbers.
 * 
 * @param <T> The data type to be stored in this matrix. Must extend {@link Number}.
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
public class Matrix<T extends Number> {
	private T[][] data;
	
	@SuppressWarnings("unchecked")
	public Matrix(int rows, int columns, Number fill) {
		if(rows < 1)
			throw new IllegalArgumentException("Rows cannot be less than 1 for a given matrix.");
		if(columns < 1)
			throw new IllegalArgumentException("Columns cannot be less than 1 for a given matrix.");
		
		data = (T[][]) Array.newInstance(fill.getClass(), columns, rows);
		for(T[] x : data) {
			for(int y = 0; y < x.length; y++)
				x[y] = (T) fill;
		}
	}
}
