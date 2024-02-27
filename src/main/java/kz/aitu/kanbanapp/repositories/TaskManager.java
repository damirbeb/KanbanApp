package kz.aitu.kanbanapp.repositories;
import kz.aitu.kanbanapp.models.Task;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static kz.aitu.kanbanapp.data.DBConnection.connect;

public class TaskManager {

    public static void addTask(Task task) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO tasks (title, description, status) VALUES (?, ?, ?) RETURNING id")) {

            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, task.getStatus());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                task.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> getTasksByStatus(String status) {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, title, description, status FROM tasks WHERE status = ?")) {

            preparedStatement.setString(1, status);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task(resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("status"));
                task.setId(resultSet.getInt("id"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    // Method: updateTaskStatus
    public static void updateTaskStatus(int taskId, String newStatus) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE tasks SET status = ? WHERE id = ?")) {

            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, taskId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}