package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.registration.db.DbConnection;
import net.javaguides.registration.model.CharitableOrganization;

public class CharitableOrganizationDao {

    public void createCharitableOrganization(CharitableOrganization organization) {
        String sql = "INSERT INTO CharitableOrganizations (UserID, OrganizationName, Location) VALUES (?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, organization.getOrganizationID());
            statement.setString(2, organization.getOrganizationName());
            statement.setString(3, organization.getLocation());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public CharitableOrganization findCharitableOrganizationById(int organizationId) {
        CharitableOrganization organization = null;
        String sql = "SELECT * FROM CharitableOrganizations WHERE OrganizationID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, organizationId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    organization = new CharitableOrganization();
                    organization.setOrganizationID(resultSet.getInt("OrganizationID"));
                    organization.setOrganizationName(resultSet.getString("OrganizationName"));
                    organization.setLocation(resultSet.getString("Location"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return organization;
    }

    public void updateCharitableOrganization(CharitableOrganization organization) {
        String sql = "UPDATE CharitableOrganizations SET OrganizationName = ?, Location = ? WHERE OrganizationID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, organization.getOrganizationName());
            statement.setString(2, organization.getLocation());
            statement.setInt(3, organization.getOrganizationID());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteCharitableOrganization(int organizationId) {
        String sql = "DELETE FROM CharitableOrganizations WHERE OrganizationID = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, organizationId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}