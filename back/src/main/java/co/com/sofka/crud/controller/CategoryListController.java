package co.com.sofka.crud.controller;

import co.com.sofka.crud.entity.CategoryList;
import co.com.sofka.crud.services.CategoryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")

public class CategoryListController {

    @Autowired
    private CategoryListService service;

    @GetMapping(value = "api/categorylists")
    public Iterable<CategoryList> list(){

        return service.list();
    }

    @PostMapping(value = "api/categorylists")
    public CategoryList save(@RequestBody CategoryList categoryList) {

        return service.save(categoryList);
    }

    @PutMapping(value = "api/categorylists")
    public CategoryList update(@RequestBody CategoryList categoryList){
        if (categoryList.getId()!= null){
            return service.save(categoryList);
        }throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/categorylists")
    public void delete(@PathVariable("id") Long id) {

        service.delete(id);
    }

    @GetMapping(value = "api/{id}/categorylists")
    public CategoryList get(@PathVariable("id")Long id){

        return  service.get(id);
    }
}