package pe.tk.ne.negociategraphql.persistence;

import org.springframework.data.repository.CrudRepository;

import pe.tk.ne.negociategraphql.entities.Student;

public interface IStudentDAO extends CrudRepository<Student, Long> {

}
