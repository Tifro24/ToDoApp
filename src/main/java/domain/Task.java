package domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private final UUID id;
    private String title;
    private final LocalDateTime createdAt;
    private boolean completed;

    public Task(String title){
        this.id = UUID.randomUUID();
        this.title = title;
        this.createdAt = LocalDateTime.now();
        this.completed = false;

    }
    public void toggleCompleted(){this.completed = !this.completed;}
    public String getTitle(){return this.title;}
    public boolean isCompleted(){return this.completed;}
    public LocalDateTime getCreatedAt(){return this.createdAt;}
    public UUID getId(){return this.id;}
    public void setComplete(){this.completed = true;}
    public void setIncomplete(){this.completed = false;}
    public void setTitle(String newTitle) {this.title = newTitle;}
}
