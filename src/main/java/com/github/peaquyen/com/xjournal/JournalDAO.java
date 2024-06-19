package com.github.peaquyen.com.xjournal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JournalDAO {
    private final Connection connection;

    public JournalDAO() {
        connection = DBConnection.getConnection();
    }

    public void create(Journal journal) {
        String sql = "INSERT INTO journals (title, description, feeling, images, date, ownerId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, journal.getTitle());
            statement.setString(2, journal.getDescription());
            statement.setString(3, journal.getFeeling());
            statement.setString(4, journal.getImages());
            statement.setString(5, Utils.convertDateToUTC(journal.getDate()));
            statement.setInt(6, journal.getOwnerId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        journal.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Journal> getMultiple(int ownerId) {
        List<Journal> journals = new ArrayList<>();
        String sql = "SELECT * FROM journals WHERE ownerId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ownerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Journal journal = new Journal(
                            resultSet.getString("title"),
                            resultSet.getString("description"),
                            resultSet.getString("feeling"),
                            resultSet.getString("images"),
                            Utils.convertDateFromUTC(resultSet.getString("date")),
                            resultSet.getInt("ownerId")
                    );
                    journal.setId(resultSet.getInt("id"));
                    journals.add(journal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return journals;
    }

    public void update(int id, Journal journal, int ownerId) {
        String sql = "UPDATE journals SET title = ?, description = ?, feeling = ?, images = ?, date = ?, ownerId = ? WHERE id = ? AND ownerId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, journal.getTitle());
            statement.setString(2, journal.getDescription());
            statement.setString(3, journal.getFeeling());
            statement.setString(4, journal.getImages());
            statement.setString(5, Utils.convertDateToUTC(journal.getDate()));
            statement.setInt(6, journal.getOwnerId());
            statement.setInt(7, id);
            statement.setInt(8, ownerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(int id, int ownerId) {
        String sql = "DELETE FROM journals WHERE id = ? AND ownerId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setInt(2, ownerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
