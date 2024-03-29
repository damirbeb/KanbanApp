package kz.aitu.kanbanapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String status;

    //Constructor with title, description, status
    public Task(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }
    public Task() {}

    //Getter to title
    public String getTitle() {
        return title;
    }

    //Getter to description
    public String getDescription() {
        return description;
    }

    //Getter to status
    public String getStatus() {
        return status;
    }

    //Setter to id
    public void setId(int id) {
        this.id = id;
    }

    //Setter to title
    public void setTitle(String title) {
        this.title = title;
    }

    //Setter to description
    public void setDescription(String description) {
        this.description = description;
    }

    //Setter to status
    public void setStatus(String status) {
        this.status = status;
    }

    //String representation of the task
    @Override
    public String toString() {
        return String.format("ID: %d | Title: %s | Description: %s | Status: %s", id, title, description, status);
    }
}