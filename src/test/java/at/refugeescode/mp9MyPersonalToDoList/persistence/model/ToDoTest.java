package at.refugeescode.mp9MyPersonalToDoList.persistence.model;
import at.refugeescode.mp9MyPersonalToDoList.persistence.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class ToDoTest {

    @Autowired
    private ToDoRepository toDoRepository;

    @BeforeEach
    void beforeEach() {
        toDoRepository.deleteAll();
        toDoRepository.saveAll(createToDoList());
    }

    @Test
    void testNumberOfToDos() {
        List<ToDo> toDos = toDoRepository.findAll();
        assertEquals(3, toDos.size());
    }

    @Test
    void testIsDone(){
        Optional<ToDo> clean_clothes = toDoRepository.findByTask("Clean Clothes");

        assertTrue(clean_clothes.isPresent());
        ToDo toDo_clean_clothes = clean_clothes.get();
        toDo_clean_clothes.setDone(true);
        toDoRepository.save(toDo_clean_clothes);

        assertTrue(toDoRepository.
                findByTask("Clean Clothes").stream().allMatch(toDo -> toDo.isDone()));
    }

    private List<ToDo> createToDoList() {
        return Stream.of(new ToDo("Wish Dishes"),
                new ToDo("Clean Clothes"),
                new ToDo("Read Book"))
                .collect(Collectors.toList());
    }
}