package com.xwoder;

public class MyArrayList<E> {

	/**
	 * 长度
	 */
	private int size = 0;

	/**
	 * 获取长度
	 * 
	 * @return 长度
	 */
	public int size() {
		return size;
	}
	
	public int capacity() {
		return elements.length;
	}

	private E[] elements;

	/**
	 * 默认容量
	 */
	private static final int DEFAULT_CAPACITY = 5;
	
	/**
	 * 查找失败
	 */
	private static final int ELEMENT_NOT_FIND = -1;

	/**
	 * 构造方法
	 * 
	 * @param capacity 容量
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList(int capacity) {
		if (capacity < DEFAULT_CAPACITY) {
			capacity = DEFAULT_CAPACITY;
		}
		E[] es = (E[]) new Object[capacity];
		this.elements = es;
	}

	/**
	 * 构造方法
	 */
	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * 是否为空
	 * 
	 * @return 是否为空
	 */
	public boolean isEmpty() {
		return this.size() == 0;
	}

	public boolean isFull() {
		return this.size() == elements.length;
	}

	/**
	 * 获取元素
	 * 
	 * @param index 索引
	 * @return 值
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}

		return elements[index];
	}

	/**
	 * 设置元素
	 * 
	 * @param index 索引
	 * @param value 新值
	 * @return 旧值
	 */
	public E set(int index, E value) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}

		E old = elements[index];
		elements[index] = value;
		return old;
	}

	/**
	 * 查找元素
	 * 
	 * @param element 元素值
	 * @return 下标
	 * @throws Exception 未找到异常
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elements[i].equals(element)) {
					return i;
				}
			}
		}	
	
		return ELEMENT_NOT_FIND;
	}

	/**
	 * 是否包含元素
	 * 
	 * @param elements 元素
	 * @return 是否包含
	 */
	public boolean contains(E elements) {
		return indexOf(elements) != ELEMENT_NOT_FIND;
	}

	/**
	 * 清空元素
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		
		size = 0;
	}

	/**
	 * 添加元素
	 * 
	 * @param element 元素
	 * @return 是否添加成功
	 */
	public boolean add(E element) {
		boolean result = add(element, size);
		return result;
	}

	public boolean add(E element, int index) {

		rangeCheckForAdd(index);

		ensureCapacity(size() + 1);

		for (int i = size - 1; i >= index; --i) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;

		++size;

		return true;
	}

	/**
	 * 确保容量
	 * 
	 * @param capacity 容量
	 */
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int capacity) {

		if (capacity() >= capacity) {
			return;
		}

		int oldCapcity = elements.length;
		int newCapacity = oldCapcity + (oldCapcity >> 1);

		E[] es = (E[]) new Object[newCapacity];
		E[] newElements = es;

		for (int i = 0; i < size(); i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;

		return;
	}

	/**
	 * 删除元素
	 * 
	 * @param index 索引
	 * @return 被删除的元素
	 */
	public E remove(int index) {

		rangeCheckForRemove(index);

		E old = get(index);
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		--size;
		
		elements[size] = null;

		return old;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("size = ").append(size);
		sb.append(", capacity = ").append(elements.length);
		sb.append(", [");
		for (int i = 0; i < size; i++) {

			if (i != 0) {
				sb.append(", ");
			}

			E ele = elements[i];
			sb.append(ele);
		}
		sb.append("]");

		return sb.toString();
	}

	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException(index);
		}
	}

	private void rangeCheckForRemove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
	}

}
