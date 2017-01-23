package me.nichel.sportcenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.nichel.sportcenter.model.Customer;
import me.nichel.sportcenter.utils.DBUtil;

public class CustomerDAOImpl implements CustomerDAO {
	private Connection connection;

	public CustomerDAOImpl() {
		connection = DBUtil.getConnection();
	}

	@Override
	public void add(final Customer customer) {
		try {
			final String query = "insert into customer (firstname, lastname, email) values (?,?,?)";
			final PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, customer.getFirstname());
			preparedStatement.setString(2, customer.getLastname());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(final int id) {
		try {
			final String query = "delete from customer where id = ?";

			final PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(final Customer customer) {
		try {
			final String query = "update customer set firstname=?, lastname=?, email=? where id=?";
			final PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, customer.getFirstname());
			preparedStatement.setString(2, customer.getLastname());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setInt(4, customer.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> getAll() {
		final List<Customer> customers = new ArrayList<Customer>();
		try {			
            final String query = "select * from customer";            
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			final ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				final Customer customer = new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstname(resultSet.getString("firstname"));
				customer.setLastname(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));

				customers.add(customer);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer get(int id) {
		final Customer customer = new Customer();
		
        try {
            final String query = "select * from customer where id=?";           
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
				customer.setId(resultSet.getInt("id"));
				customer.setFirstname(resultSet.getString("firstname"));
				customer.setLastname(resultSet.getString("lastname"));
				customer.setEmail(resultSet.getString("email"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return customer;
	}

}