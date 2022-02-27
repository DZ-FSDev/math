package com.dz_fs_dev.math.matrices;

import java.lang.reflect.Array;

/**
 * Represents a Matrix of {@link Number}s.
 * 
 * @param <T> The data type to be stored in this matrix. Must extend {@link Number}.
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.3
 */
public class Matrix<T extends Number> {
	private T[][] data;
	
	/**
	 * Initializes a new instance of a Matrix of {@link Number}s.
	 * 
	 * @param rows The number of rows this matrix shall have. Cannot be less than 1.
	 * @param columns The number of columns this matrix shall have. Cannot be less than 1.
	 * @param fill The starting value to set all elements of the matrix to.
	 *             Cannot be null.
	 * @since 0.0.1
	 */
	@SuppressWarnings("unchecked")
	public Matrix(int rows, int columns, Number fill) {
		if(rows < 1)
			throw new IllegalArgumentException("Rows cannot be less than 1 for a given matrix.");
		if(columns < 1)
			throw new IllegalArgumentException("Columns cannot be less than 1 for a given matrix.");
		if(fill == null)
			throw new NullPointerException("Matrix cannot be flled with null.");
			
		data = (T[][]) Array.newInstance(fill.getClass(), columns, rows);
		for(T[] x : data) {
			for(int y = 0; y < x.length; y++)
				x[y] = (T) fill;
		}
	}
	
	/*
	 * 
	 * @param data
	 * @since 0.0.2
	 */
	@SuppressWarnings("unchecked")
	public Matrix(T[][] data) {
		this.data = (T[][]) new Number[data.length][data[0].length];
		for(T[] x : data) {
			// TODO Not Implemented
		}
	}

	/**
	 * 
	 * 
	 * @param augend
	 * @return
	 * @since 0.0.3
	 */
	public Matrix<T> add(Matrix<T> augend) {
		// TODO Not Implemented
		return augend;
		
	}
}
