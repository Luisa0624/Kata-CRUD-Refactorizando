package co.com.sofka.crud.DAO;

import co.com.sofka.crud.entity.Todo;

public interface DAO {
    Iterable<Todo> list();
    Todo save(Todo todo);
    void delete(Long id);
    Todo get(Long id);
}
