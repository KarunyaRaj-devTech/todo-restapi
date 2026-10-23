package in.umasuraj.restapi.todo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TodoController {

	private final TodoService todoService;

	// Fetches all todos
	// GET REQUEST
	// http://localhost:5000/users/{username}/todos
	@GetMapping("/users/{username}/todos")
	public ResponseEntity<List<TodoResponse>> retrieveTodos(@PathVariable String username) {
		List<TodoResponse> todoResponseList = todoService.getAllTodosByUsername(username);
		return new ResponseEntity<>(todoResponseList, HttpStatus.OK);
	}

	// Fetches a todo by id
	// GET REQUEST
	// http://localhost:5000/users/{username}/todos/id/{id}
	@GetMapping("/users/{username}/todos/id/{id}")
	public ResponseEntity<TodoResponse> retrieveTodo(@PathVariable String username, @PathVariable Long id) {
		TodoResponse todoResponse = todoService.getTodoById(id);
		return new ResponseEntity<>(todoResponse, HttpStatus.OK);
	}

	// Adds a new todo
	// POST REQUEST
	// http://localhost:5000/users/{username}/todos
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<TodoResponse> createTodo(@PathVariable String username,
			@RequestBody TodoRequest todoRequest) {
		TodoResponse todoResponse = todoService.addTodo(todoRequest);
		return new ResponseEntity<>(todoResponse, HttpStatus.CREATED);
	}

	// Updates an existing todo by id
	// PUT REQUEST
	// http://localhost:5000/users/{username}/todos/{id}
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<TodoResponse> updateTodo(@PathVariable String username, @PathVariable Long id,
			@RequestBody TodoRequest todoRequest) {
		TodoResponse todoResponse = todoService.updateTodo(id, todoRequest);
		return new ResponseEntity<>(todoResponse, HttpStatus.CREATED);
	}

	// Deletes an existing todo by id
	// DELETE REQUEST
	// http://localhost:5000/users/{username}/todos/{id}
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id) {
		todoService.deleteTodo(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// Marks an existing todo completed => TRUE
	// PATCH REQUEST
	// http://localhost:5000/users/{username}/todos/{id}/completed
	@PatchMapping("/users/{username}/todos/{id}/completed")
	public ResponseEntity<TodoResponse> completeTodo(@PathVariable String username, @PathVariable Long id) {
		TodoResponse todoResponse = todoService.completeTodo(id);
		return new ResponseEntity<>(todoResponse, HttpStatus.OK);
	}

	// Marks an existing todo incomplete => FALSE
	// PATCH REQUEST
	// http://localhost:5000/users/{username}/todos/{id}/in-complete
	@PatchMapping("/users/{username}/todos/{id}/in-complete")
	public ResponseEntity<TodoResponse> incompleteTodo(@PathVariable String username, @PathVariable Long id) {
		TodoResponse todoResponse = todoService.incompleteTodo(id);
		return new ResponseEntity<>(todoResponse, HttpStatus.OK);
	}

	// Fetch todo by description
	// GET REQUEST
	// http://localhost:5000/users/{username}/todos/description/{description}
	@GetMapping("/users/{username}/todos/description/{description}")
	public ResponseEntity<List<TodoResponse>> getTodoByDescription(@PathVariable String username,
			@PathVariable String description) {
		List<TodoResponse> todoResponseList = todoService.getAllTodosByDescription(username, description);
		return new ResponseEntity<>(todoResponseList, HttpStatus.OK);
	}

}
