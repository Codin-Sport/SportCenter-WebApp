package me.nichel.sportcenter.dao;

import java.util.List;

import me.nichel.sportcenter.model.Customer;

public interface CustomerDAO {
	public void add(Customer customer);

	public void delete(int id);

	public void update(Customer customer);

	public List<Customer> getAll();

	public Customer get(int id);
}
