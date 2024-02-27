package kz.aitu.kanbanapp.services.interfaces;

import kz.aitu.kanbanapp.models.Task;
import java.util.List;
public interface TaskManagerInterface {
    List<Task> getAll();
}
