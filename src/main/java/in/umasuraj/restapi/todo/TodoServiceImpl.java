package in.umasuraj.restapi.todo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;

	private Todo convertToTodo(TodoRequest request) {
		Todo todo = new Todo();
		todo.setUsername(request.getUsername());

		todo.setDescription(request.getDescription());
		todo.setTargetDate(request.getTargetDate());
		todo.setCompleted(request.getCompleted());
		return todo;
	}

	private TodoResponse convertToResponse(Todo todo) {
		TodoResponse response = new TodoResponse();
		response.setId(todo.getId());
		response.setUsername(todo.getUsername());

		response.setDescription(todo.getDescription());
		response.setTargetDate(todo.getTargetDate());
		response.setCompleted(todo.getCompleted());
		return response;
	}

	@Override
	public TodoResponse addTodo(TodoRequest todoRequest) {
		Todo todo = convertToTodo(todoRequest);
		Todo savedTodo = todoRepository.save(todo);
		return convertToResponse(savedTodo);
	}

	@Override
	public TodoResponse getTodoById(Long id) {
		Todo todo = todoRepository.findById(id).orElseThrow(

				() -> new TodoNotFoundException("Todo not found with id: " + id)

		);
		return convertToResponse(todo);
	}

	@Override
	public List<TodoResponse> getAllTodos() {
		List<Todo> todoList = todoRepository.findAll();
		List<TodoResponse> todoResponseList = todoList.stream().map(todo -> convertToResponse(todo))
				.collect(Collectors.toList());

		return todoResponseList;
	}

	@Override
	public TodoResponse updateTodo(Long id, TodoRequest todoRequest) {
		// Check if Todo exists
		Todo todo = todoRepository.findById(id).orElseThrow(

				() -> new TodoNotFoundException("Todo not found with id: " + id)

		);

		todo.setDescription(todoRequest.getDescription());
		todo.setTargetDate(todoRequest.getTargetDate());
		todo.setCompleted(todoRequest.getCompleted());

		Todo savedTodo = todoRepository.save(todo);
		return convertToResponse(savedTodo);
	}

	@Override
	public void deleteTodo(Long id) {
		// Check if Todo exists
		Todo todo = todoRepository.findById(id).orElseThrow(

				() -> new TodoNotFoundException("Todo not found with id: " + id)

		);
		todoRepository.delete(todo);
	}

	@Override
	public TodoResponse completeTodo(Long id) {
		// Check if Todo exists
		Todo todo = todoRepository.findById(id).orElseThrow(

				() -> new TodoNotFoundException("Todo not found with id: " + id)

		);
		todo.setCompleted(Boolean.TRUE);
		Todo savedTodo = todoRepository.save(todo);
		return convertToResponse(savedTodo);
	}

	@Override
	public TodoResponse incompleteTodo(Long id) {
		// Check if Todo exists
		Todo todo = todoRepository.findById(id).orElseThrow(

				() -> new TodoNotFoundException("Todo not found with id: " + id)

		);
		todo.setCompleted(Boolean.FALSE);
		Todo savedTodo = todoRepository.save(todo);
		return convertToResponse(savedTodo);
	}

	@Override
	public List<TodoResponse> getAllTodosByUsername(String username) {
		List<Todo> todoList = todoRepository.findByUsernameContaining(username);
		List<TodoResponse> todoResponseList = todoList.stream()

				.map(todo -> convertToResponse(todo))

				.collect(Collectors.toList());

		return todoResponseList;
	}

	@Override
	public List<TodoResponse> getAllTodosByDescription(String username, String description) {
		List<Todo> todoList = todoRepository.findByUsernameContaining(username);
		List<TodoResponse> todoResponseList = todoList.stream()

				.filter(todo -> todo.getDescription().contains(description))

				.map(todo -> convertToResponse(todo))

				.collect(Collectors.toList());

		return todoResponseList;
	}

}
