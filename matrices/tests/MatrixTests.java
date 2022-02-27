package com.dz_fs_dev.math.matrices;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.function.Consumer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Contains a battery of tests to verify {@link Matrix} conforms to
 * requirements.
 * 
 * @author DZ-FSDev
 * @since 17.0.2
 * @version 0.0.1
 */
class MatrixTests {
	@ParameterizedTest
	@CsvSource({
		"10,15,8.505,java.lang.Double",
		"10,15,8,java.lang.Integer",
		"10,15,9,java.lang.Long"
	})
	void constructor1_initializesCorrectly(
			int rows, int columns, String fillString, String typeStr) 
					throws InstantiationException, IllegalAccessException,
					IllegalArgumentException, InvocationTargetException,
					NoSuchMethodException, SecurityException,
					ClassNotFoundException, NoSuchFieldException {
		// Arrange
		Class<?> type = Class.forName(typeStr);
		Number fill = (Number) type.getConstructor(String.class)
				.newInstance(fillString);
		Field dataField = Matrix.class.getDeclaredField("data");
		dataField.setAccessible(true);

		// Act
		Matrix<?> target = new Matrix<>(rows, columns, fill);

		// Access
		@SuppressWarnings("unchecked")
		T[][] targetDataField = (T[][]) dataField.get(target);

		// Assert
		assertAll(
				() -> assertEquals(columns, targetDataField.length, "The backing data does not match the specified row count."),
				
				() -> Arrays.spliterator(targetDataField)
				.forEachRemaining(new Consumer<Object[]>() {
					@Override
					public void accept(Object[] t) {
						assertEquals(rows, t.length, "The backing data does not match the specified row count.");
					}
				}),
				
				() -> assertInstanceOf(type.arrayType().arrayType(), targetDataField, "The backing data is typed incorrectly."),
				
				() -> Arrays.spliterator(targetDataField)
				.forEachRemaining(new Consumer<Object[]>() {
					@Override
					public void accept(Object[] t) {
						assertEquals(rows, t.length, "The backing data does not match the specified row count.");
					}
				}),
				
				() -> Arrays.spliterator(targetDataField)
				.forEachRemaining(new Consumer<Object[]>() {
					@Override
					public void accept(Object[] t) {
						Object[] arrExpected = (Object[])Array.newInstance(type, rows);
						Arrays.fill(arrExpected, fill);
						assertArrayEquals(arrExpected, t, "The backing data was not filled with the specified fill value.");
					}
				})
				);
	}

	@ParameterizedTest
	@CsvSource(
			"10,15,8.505,java.lang.Double"
			)
	void constructor1_initializesFilledMatrix(
			int rows, int columns, String fillString, String type) 
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		Class<?> clazz = Class.forName(type);
		Number fill = (Number) clazz.getConstructor(String.class)
				.newInstance(fillString);
		Matrix<Double> target = new Matrix<Double>(rows, columns, fill);

		assertAll(
				() -> fail("Not Yet Implemented")
				);
	}
}
