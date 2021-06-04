package co.com.sofka.crud.DAO;

import co.com.sofka.crud.entity.CategoryList;

public interface DaoCategory {
    Iterable<CategoryList> list();
    CategoryList save(CategoryList groupList);
    void delete(Long id);
    CategoryList get(Long id);
}
