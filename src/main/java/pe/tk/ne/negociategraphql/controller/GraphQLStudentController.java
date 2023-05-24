package pe.tk.ne.negociategraphql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import pe.tk.ne.negociategraphql.entities.Course;
import pe.tk.ne.negociategraphql.entities.Student;
import pe.tk.ne.negociategraphql.graphql.InputStudent;
import pe.tk.ne.negociategraphql.service.ICourseService;
import pe.tk.ne.negociategraphql.service.IStudentService;

@RequiredArgsConstructor
@Controller
public class GraphQLStudentController {

    private final IStudentService studentService;
    private final ICourseService courseService;

    // TODO: sí el nombre del query(graphqls) es distinto a esta funcion, debemos
    // especificar el name de la query en graphql, sí son iguales podemos dejarlo
    // por default
    // para este caso son distintos
    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id) {
        Long studentId = Long.parseLong(id);
        return studentService.findById(studentId);
    }

    @QueryMapping(name = "findAllStudents")
    public List<Student> findAllStudents() {
        return studentService.findAll();
    }

    // TODO: omitimos el nombre del metodo de graphql, porque es el mismo, para los
    // casos de arriba fueron diferentes
    @MutationMapping
    public Student createStudent(@Argument InputStudent inputStudent) {

        Course course = courseService.findById(Long.parseLong(inputStudent.getCourseId()));

        Student student = new Student();
        student.setName(inputStudent.getName());
        student.setLastName(inputStudent.getLastName());
        student.setAge(inputStudent.getAge());
        student.setCourse(course);

        studentService.createObjectClass(student);
        return student;
    }

    @MutationMapping(name = "deleteStudent")
    public String deleteById(@Argument(name = "studentId") String id) {
        studentService.deleteById(Long.parseLong(id));

        return String.format("El estudiante con %s fue eliminado.", id);
    }

}
