package at.refugeescode.mp9MyPersonalToDoList.controller;
import at.refugeescode.mp9MyPersonalToDoList.persistence.model.ToDo;
import at.refugeescode.mp9MyPersonalToDoList.persistence.repository.ToDoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/todos")
public class Endpoint {

    private ToDoRepository toDoRepository;

    public Endpoint(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping
    List<ToDo> getAllToDo(){
        return toDoRepository.findAll();
    }

    @PostMapping
    void addTodo(@RequestBody ToDo todo){
        toDoRepository.save(todo);
    }

    @GetMapping("/{id}")
    ToDo getOneToDo(@PathVariable String id){
        ToDo toDo = toDoRepository.findById(id).orElse(null);
        return toDo;
    }

    @PutMapping("/{id}/done")
    ToDo updateToDo(@PathVariable String id){
        Optional<ToDo> toDo = toDoRepository.findById(id);
        if(toDo.isPresent()){
            toDo.get().setDone(true);
            toDoRepository.save(toDo.get());
        }

        return toDo.get();
    }
}