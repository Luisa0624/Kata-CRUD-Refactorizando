package co.com.sofka.crud.services;

import co.com.sofka.crud.DAO.DaoCategory;
import co.com.sofka.crud.entity.CategoryList;
import co.com.sofka.crud.repository.CategoryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryListService implements DaoCategory{

    @Autowired
    private CategoryListRepository repository;

    @Override
    public Iterable<CategoryList> list(){
        return repository.findAll();
    }

    @Override
    public CategoryList save(CategoryList groupList){
        return repository.save(groupList);
    }

    @Override
    public void delete(Long id){
        repository.delete(get(id));
    }

    @Override
    public CategoryList get(Long id){
        return repository.findById(id).orElseThrow();
    }
}