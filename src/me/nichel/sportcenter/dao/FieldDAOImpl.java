package me.nichel.sportcenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import me.nichel.sportcenter.model.Field;
import me.nichel.sportcenter.utils.DBUtil;

public class FieldDAOImpl implements GenericDAO<Field> {
	private Connection connection;

	public FieldDAOImpl() {
		this.connection = DBUtil.getConnection();
	}

	@Override
	public void add(final Field field) {
		try {
			final String query = "insert into field (name, type, sport_000, sport_001, sport_002, sport_003) values (?, ?, ?, ?, ?, ?)";
			final PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, field.getName());
			preparedStatement.setInt(2, field.getType());
			
			for (int i = 0 ; i < 4; ++i) {
				if (i > field.getSports().size()) {
					preparedStatement.setString((3 + i), null);
				} else {
					preparedStatement.setString((3 + i), field.getSports().get(i));
				}
			}
			
			preparedStatement.executeUpdate();
				
			final ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				field.setId(resultSet.getLong(1));
			}
			
			preparedStatement.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(final long id) {
		try {
			final String query = "delete from field where id = ?";
			final PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(final Field field) {
		try {			
			final String query = "update field set name=?, type=?, sport_000=?, sport_001=?, sport_002=?, sport_003=? where id=?";
			final PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, field.getName());
			preparedStatement.setInt(2, field.getType());
			
			for (int i = 0 ; i < 4; ++i) {
				if (i > field.getSports().size()) {
					preparedStatement.setString((3 + i), null);
				} else {
					preparedStatement.setString((3 + i), field.getSports().get(i));
				}
			}
			preparedStatement.setLong(7, field.getId());

			preparedStatement.executeUpdate();
				
			final ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				field.setId(resultSet.getLong(1));
			}
			
			preparedStatement.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Field> getAll() {
		final List<Field> fields = new ArrayList<Field>();
		try {			
            final String query = "select * from field";            
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			final ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				final Field field = new Field();
				field.setId(resultSet.getLong("id"));
				field.setName(resultSet.getString("name"));
				field.setType(resultSet.getInt("type"));
				
				final List<String> sports = new ArrayList<>();
				sports.add(resultSet.getString("sport_000"));
				sports.add(resultSet.getString("sport_001"));
				sports.add(resultSet.getString("sport_002"));
				sports.add(resultSet.getString("sport_003"));			
				field.setSports(sports);
				
				fields.add(field);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fields;
	}

	@Override
	public Field get(final long id) {
		final Field field = new Field();
		
        try {
            final String query = "select * from field where id=?";           
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
				field.setId(resultSet.getLong("id"));
				field.setName(resultSet.getString("name"));
				field.setType(resultSet.getInt("type"));
				
				final List<String> sports = new ArrayList<>();
				sports.add(resultSet.getString("sport_000"));
				sports.add(resultSet.getString("sport_001"));
				sports.add(resultSet.getString("sport_002"));
				sports.add(resultSet.getString("sport_003"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return field;
	}
}