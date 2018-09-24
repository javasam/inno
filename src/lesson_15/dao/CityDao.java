package lesson_15.dao;

import lesson_15.connection.ConnectionDb;
import lesson_15.connection.ConnectionDbInterface;
import lesson_15.pojo.City;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDao implements CityDaoInterface {
    private static ConnectionDbInterface connectionDb = ConnectionDb.getInstance();

    @Override
    public City getCityById(int id) {
        Connection connection = connectionDb.getConnection();
        City city = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * from cities WHERE id = ?")
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    city = new City(resultSet.getInt("id"),
                            resultSet.getString("city"),
                            resultSet.getInt("citizens"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return city;
    }
}
