package com.mycompany.a3;

/**
 * Class for iiterator for has/get next
 * @author green
 *
 */
public interface IIterator {
	public boolean hasNext();
	public Object getNext();
	IIterator getIterator();
	void add(Object object);

}
