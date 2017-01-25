package me.nichel.sportcenter.dao;

import java.util.List;

import me.nichel.sportcenter.model.Customer;

public interface CustomerDAO {
	public void add(Customer customer);

	public void delete(long id);

	public void update(Customer customer);

	public List<Customer> getAll();

	public Customer get(long id);
}
