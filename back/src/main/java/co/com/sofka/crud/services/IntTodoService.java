package co.com.sofka.crud.services;

import co.com.sofka.crud.dto.TodoDto;
import co.com.sofka.crud.entity.Todo;

public interface IntTodoService {
    Iterable<TodoDto> list();

    TodoDto save(TodoDto todoDto);

    void delete(Long id);

    TodoDto get(Long id);
}
