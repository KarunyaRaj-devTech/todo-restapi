package in.umasuraj.restapi.todo;

import java.util.List;

public interface TodoService {

	public TodoResponse addTodo(TodoRequest todoRequest);

	public TodoResponse getTodoById(Long id);

	public List<TodoResponse> getAllTodos();

	public TodoResponse updateTodo(Long id, TodoRequest todoRequest);

	public void deleteTodo(Long id);

	public TodoResponse completeTodo(Long id);

	public TodoResponse incompleteTodo(Long id);

	public List<TodoResponse> getAllTodosByUsername(String username);

	public List<TodoResponse> getAllTodosByDescription(String username, String description);

}
