package com.dz_fs_dev.math.graph;

/**
 * Generic representation of a data node such as a vertex on a graph.
 *
 * @author DZFSDev
 * @since 16.0.1
 * @version 0.0.1
 *
 * @param <E> The type of data the node represents.
 */
public class Node<E> {
	private E data;

	/**
	 * Initializes the Node with specified data.
	 *
	 * @param data The data to be represented by the node.
	 */
	public Node(E data){
		this.setData(data);
	}

	/**
	 * Returns the data represented by the Node.
	 *
	 * @return The data represented by the Node.
	 */
	public E getData() {
		return data;
	}

	/**
	 * Sets the data represented by the Node.
	 *
	 * @param data The data represented by the Node.
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * @since 0.0.1
	 */
	@Override
	public int hashCode() {
		final int prime = 731;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	/**
	 * @since 0.0.1
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Node))
			return false;
		Node<?> other = (Node<?>)obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
}
