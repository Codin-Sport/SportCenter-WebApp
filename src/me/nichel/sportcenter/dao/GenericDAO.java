package me.nichel.sportcenter.dao;

import java.util.List;

public interface GenericDAO<T> {
	public void add(T item);

	public void delete(long id);

	public void update(T item);

	public List<T> getAll();

	public T get(long id);
}
