package com.example.springcrud.repository;


import com.example.springcrud.model.Apartment;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
@NoArgsConstructor
public class ApartmentDAO implements DAO<Apartment> {


	private static final String ADD_APARTMENT = "INSERT INTO apartments (city,price,room) VALUES (?,?,?);";
	private static final String SELECT_ALL_APARTMENT = "SELECT * FROM apartments;";
	private static final String SELECT_APARTMENT_BY_ID = "SELECT * FROM apartments WHERE ID= ? ;";
	private static final String UPDATE_APARTMENT = "UPDATE apartments SET city = ?, price = ?, room = ? WHERE id=?;";
	private static final String DELETE_APARTMENT = "DELETE FROM apartments WHERE ID= ?;";

	public static Connection getConnection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apartment", "root", "762541234");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cn;
	}

	@Override
	public Apartment create(Apartment apartment) {
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(ADD_APARTMENT)) {
			preparedStatement.setString(1, apartment.getCity());
			preparedStatement.setInt(2, apartment.getPrice());
			preparedStatement.setInt(3, apartment.getCountOfRoom());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apartment;
	}

	@Override
	public Apartment update(Apartment apartment, int id) {
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_APARTMENT)) {
			preparedStatement.setString(1, apartment.getCity());
			preparedStatement.setInt(2, apartment.getPrice());
			preparedStatement.setInt(3, apartment.getCountOfRoom());
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apartment;
	}

	@Override
	public Apartment delete(int id) {
		Apartment apartment = getByID(id);
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(DELETE_APARTMENT)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apartment;
	}

	@Override
	public Apartment getByID(int id) {
		Apartment apartment = null;
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APARTMENT_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String city = resultSet.getString("city");
				int price = resultSet.getInt("price");
				int room = resultSet.getInt("room");
				apartment = new Apartment(id,city, price, room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apartment;
	}

	@Override
	public List<Apartment> getAll() {
		List<Apartment> list = new LinkedList<>();
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APARTMENT)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String city = resultSet.getString("city");
				int price = resultSet.getInt("price");
				int room = resultSet.getInt("room");
				list.add(new Apartment(id, city, price, room));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

