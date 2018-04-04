package at.refugeescode.mp9MyPersonalToDoList.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ToDo {

    @Id
    private String id;

    private String task;

    private boolean done;

    public ToDo() {
    }

    public ToDo(String title) {

        this.id = id;
        this.task = title;
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return task;
    }

    public void setTitle(String title) {
        this.task = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id='" + id + '\'' +
                ", title='" + task + '\'' +
                ", done=" + done +
                '}';
    }
}
