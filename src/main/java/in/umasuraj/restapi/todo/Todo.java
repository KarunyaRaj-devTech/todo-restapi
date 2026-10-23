package in.umasuraj.restapi.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "todos")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "todo_id")
	private Long id;

	@Column(name = "todo_username", nullable = false)
	private String username;

	@Column(name = "todo_description", nullable = false)
	private String description;

	@Column(name = "todo_target_date", nullable = false)
	private LocalDate targetDate;

	@Column(name = "todo_completed", nullable = false)
	private Boolean completed;

}
