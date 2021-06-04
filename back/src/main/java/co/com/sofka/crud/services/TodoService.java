package co.com.sofka.crud.services;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.entity.Todo;
import co.com.sofka.crud.repository.TodoRepository;
import co.com.sofka.crud.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService implements IntTodoService{

    @Autowired
    private TodoRepository repository;

    @Autowired
    private TodoMapper mapper;

    public Iterable<TodoDto> list(){
        Iterable<Todo> todos = repository.findAll();
        return mapper.toTodoDto(todos);
    }

    public TodoDto save(TodoDto todoDto){
        Todo todo = mapper.toTodo(todoDto);
        return mapper.toTodoDto(repository.save(todo));
    }


    public void delete(Long id){
        repository.delete(mapper.toTodo(get(id)));
    }


    public TodoDto get(Long id){
        Todo todo = repository.findById(id).orElseThrow();
        return mapper.toTodoDto(todo);
    }
}