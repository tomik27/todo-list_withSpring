package cz.upce.todoList.backend;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Item {
    @NotBlank(message = "Description is mandatory")
    private String value;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
}
