package in.umasuraj.restapi.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TodoResponse {

	private Long id;

	private String username;

	private String title;

	private String description;

	private LocalDate targetDate;

	private Boolean completed;
}
