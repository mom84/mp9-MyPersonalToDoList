package at.refugeescode.mp9MyPersonalToDoList.persistence.repository;

import at.refugeescode.mp9MyPersonalToDoList.persistence.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ToDoRepository extends MongoRepository<ToDo, String> {

   public Optional<ToDo> findByTask(String task);
}
