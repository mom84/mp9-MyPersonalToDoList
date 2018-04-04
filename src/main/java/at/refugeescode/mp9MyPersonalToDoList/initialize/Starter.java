package at.refugeescode.mp9MyPersonalToDoList.initialize;

import at.refugeescode.mp9MyPersonalToDoList.persistence.model.ToDo;
import at.refugeescode.mp9MyPersonalToDoList.persistence.repository.ToDoRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class Starter {

    private ToDoRepository toDoRepository;

    @Bean
    ApplicationRunner applicationRunner(ToDoRepository toDoRepository) {
        return args -> {
            toDoRepository.deleteAll();
            List<ToDo> toDoList = createToDoList();

            toDoRepository.saveAll(toDoList);

            toDoRepository.findAll().forEach(System.out::println);
            System.out.println("--------------------------------");

        };
    }

    private List<ToDo> createToDoList() {
        return Stream.of(new ToDo("Wish Dishes"),
                new ToDo("Clean Clothes"),
                new ToDo("Read Book"))
                .collect(Collectors.toList());
    }

}
