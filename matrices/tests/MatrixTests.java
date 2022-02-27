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
	@CsvSource(
			"10,15,8.505,java.lang.Double"
			)
	void constructor1_initializesCorrectSizeMatrix(
			int rows, int columns, String fillString, String type) 
					throws InstantiationException, IllegalAccessException,
					IllegalArgumentException, InvocationTargetException,
					NoSuchMethodException, SecurityException,
					ClassNotFoundException, NoSuchFieldException {
		// Arrange
		Class<?> clazz = Class.forName(type);
		Number fill = (Number) clazz.getConstructor(String.class)
				.newInstance(fillString);
		Field dataField = Matrix.class.getDeclaredField("data");
		dataField.setAccessible(true);

		// Act
		Matrix<Double> target = new Matrix<Double>(rows, columns, fill);

		// Access
		Object[][] targetDataField = (Object[][]) dataField.get(target);

		// Assert
		assertAll(
				() -> assertEquals(columns, targetDataField.length),
				() -> Arrays.spliterator(targetDataField)
				.forEachRemaining(new Consumer<Object[]>() {
					@Override
					public void accept(Object[] t) {
						fail();
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
