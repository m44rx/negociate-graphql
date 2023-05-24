package pe.tk.ne.negociategraphql.persistence;

import org.springframework.data.repository.CrudRepository;

import pe.tk.ne.negociategraphql.entities.Course;

public interface ICourseDAO extends CrudRepository<Course, Long>{
    
}
