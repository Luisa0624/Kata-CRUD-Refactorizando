package co.com.sofka.crud.services;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.entity.Todo;
import co.com.sofka.crud.mapper.TodoMapper;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService  {

    @Autowired
    private TodoRepository repository;
    @Autowired
    private TodoMapper mapper;
    public Iterable<TodoDto> list(){
        Iterable<Todo> todos = repository.findAll();
        return mapper.toTodoDto(todos);
    }

    public TodoDto save(TodoDto todoDTO){
        Todo todo = mapper.toTodo(todoDTO);
        return mapper.toTodoDto(repository.save(todo));
    }

    public void delete(Long id){
        repository.delete(mapper.toTodo(get(id)));
    }

    public TodoDto get(Long id){
        return mapper.toTodoDto(repository.findById(id).orElseThrow());
    }

}
