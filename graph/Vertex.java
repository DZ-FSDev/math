package com.dz_fs_dev.math.graph;

/**
 * Represents labeled data that exists on a graph.
 * 
 * @author DZ_FSDev
 * @since 16.0.1
 * @version 0.0.1
 */
public class Vertex<E> extends Node<E> {
	private String label;
	
	/**
	 * Initializes a new Vertex with a specified label and optional data.
	 * 
	 * @param label The label for this vertex to be identified as.
	 * @param data Data that should be contained in this vertex.
	 */
	public Vertex(String label, E data) {
		super(data);
		this.setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		if(label == null)throw new IllegalArgumentException("Vertex cannot have a null label!");
		this.label = label;
	}

	/**
	 * @since 0.0.1
	 */
	@Override
	public int hashCode() {
		final int prime = 189651;
		int result = super.hashCode();
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	/**
	 * @since 0.0.1
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Vertex))
			return false;
		Vertex<?> other = (Vertex<?>) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
}
