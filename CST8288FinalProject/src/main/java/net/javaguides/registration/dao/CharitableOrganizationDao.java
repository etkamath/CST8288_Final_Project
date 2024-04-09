package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.registration.db.DbConnection;
import net.javaguides.registration.model.CharitableOrganization;

/**
 * Data access object for CharitableOrganization model.
 */
public class CharitableOrganizationDao {

    /**
     * Creates a new charitable organization in the database.
     * @param organization The charitable organization to be created
     */
    public void createCharitableOrganization(CharitableOrganization organization) {
        String sql = "INSERT INTO CharitableOrganizations (OrganizationID, OrganizationName, Location) VALUES (?, ?, ?)";
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

    /**
     * Finds a charitable organization by its ID.
     * @param organizationId The ID of the charitable organization
     * @return The charitable organization if found, otherwise null
     */
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

    /**
     * Updates information of a charitable organization in the database.
     * @param organization The charitable organization to be updated
     */
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

    /**
     * Deletes a charitable organization from the database by its ID.
     * @param organizationId The ID of the charitable organization to be deleted
     */
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
