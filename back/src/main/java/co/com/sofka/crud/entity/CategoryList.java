package co.com.sofka.crud.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "Categorias")
public class CategoryList {
    @Id
    @GeneratedValue

    private Long id;
    private String groupname;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "groupListId")
    //Se instancia la entidad
    private Set<Todo> todo;

    public Set<Todo> getTodo() {

        return todo;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getGroupname() {

        return groupname;
    }

    public void setGroupname(String groupname) {

        this.groupname = groupname;
    }
}

