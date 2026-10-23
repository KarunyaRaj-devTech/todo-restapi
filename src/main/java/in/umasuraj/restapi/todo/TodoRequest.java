package in.umasuraj.restapi.todo;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
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
public class TodoRequest {

	@NotBlank(message = "Username cannot be empty")
	private String username;

	@NotBlank(message = "Todo title cannot be empty")
	@Size(min = 3, message = "Todo title should have atleast 3 characters.")
	private String title;

	@NotBlank(message = "Todo description cannot be empty")
	@Size(min = 5, message = "Todo description should have atleast 5 characters.")
	private String description;

	@Future(message = "Todo target date must be a future date.")
	private LocalDate targetDate;

	private Boolean completed;

}
