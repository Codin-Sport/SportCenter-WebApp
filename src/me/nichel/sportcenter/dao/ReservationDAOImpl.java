package me.nichel.sportcenter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import me.nichel.sportcenter.model.Reservation;
import me.nichel.sportcenter.utils.DBUtil;

public class ReservationDAOImpl implements GenericDAO<Reservation> {

	private Connection connection;
	
	public ReservationDAOImpl() {
		this.connection = DBUtil.getConnection();
	}

	@Override
	public void add(Reservation reservation) {
		// TODO Auto-generated method stub
		try {
			final String query = "insert into reservation (customer_id, field_id, start_time, end_time, ctime, utime, info) values (?,?,?,?,?,?,?)";
			final PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			
			reservation.setCtime(LocalDateTime.now());
			reservation.setUtime(LocalDateTime.now());

			preparedStatement.setLong(1, reservation.getCustomer_id());
			preparedStatement.setLong(2, reservation.getField_id());
			preparedStatement.setString(3, reservation.getStart_time().toString());
			preparedStatement.setString(4, reservation.getEnd_time().toString());
			preparedStatement.setString(5, reservation.getCtime().toString());
			preparedStatement.setString(6, reservation.getUtime().toString());
			preparedStatement.setString(7, reservation.getInfo());
			
			preparedStatement.executeUpdate();
			final ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()){
				reservation.setId(resultSet.getLong(1));
			}
			
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new DAOException(e);
		}
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		try {
			
			final String query = "delete from reservation where id = ?";
			final PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			
			preparedStatement.setLong(1, id);

			preparedStatement.executeUpdate();
			
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Reservation reservation) {
		// TODO Auto-generated method stub
		try {
			
			final String query = "update reservation set field_id = ?, start_time = ?, end_time = ?, info = ? where id = ?)";
			final PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			reservation.setUtime(LocalDateTime.now());

			preparedStatement.setLong(1, reservation.getCustomer_id());
			preparedStatement.setLong(2, reservation.getField_id());
			preparedStatement.setString(3, reservation.getStart_time().toString());
			preparedStatement.setString(4, reservation.getEnd_time().toString());
			preparedStatement.setString(5, reservation.getCtime().toString());
			preparedStatement.setString(6, reservation.getUtime().toString());
			preparedStatement.setString(7, reservation.getInfo());

			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		final List<Reservation> reservations = new ArrayList<Reservation>();
		try {
			
			final String query = "select * from reservation";
			final PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);

			final ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				final Reservation reservation = new Reservation();
				reservation.setId(resultSet.getLong("id"));
				reservation.setCustomer_id(resultSet.getLong("customer_id"));
				reservation.setField_id(resultSet.getLong("field_id"));
				reservation.setStart_time(LocalDateTime.parse(resultSet.getString("start_time")));
				reservation.setEnd_time(LocalDateTime.parse(resultSet.getString("end_time")));
				reservation.setInfo(resultSet.getString("info"));

				reservations.add(reservation);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}

	@Override
	public Reservation get(long id) {
		final Reservation reservation = new Reservation();
		try {
			
			final String query = "select * from reservation where id = ?";
			final PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
				reservation.setId(resultSet.getLong("id"));
				reservation.setCustomer_id(resultSet.getLong("customer_id"));
				reservation.setField_id(resultSet.getLong("field_id"));

				reservation.setStart_time(LocalDateTime.parse(resultSet.getString("start_time")));
				reservation.setEnd_time(LocalDateTime.parse(resultSet.getString("end_time")));
				
				reservation.setCtime(LocalDateTime.parse(resultSet.getString("ctime")));
				reservation.setUtime(LocalDateTime.parse(resultSet.getString("utime")));

				reservation.setInfo(resultSet.getString("info"));
            }
            resultSet.close();
            preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservation;
	}

}
