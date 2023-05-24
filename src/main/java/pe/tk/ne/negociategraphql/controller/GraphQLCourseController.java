package pe.tk.ne.negociategraphql.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import pe.tk.ne.negociategraphql.entities.Course;
import pe.tk.ne.negociategraphql.graphql.InputCourse;
import pe.tk.ne.negociategraphql.service.ICourseService;

@RequiredArgsConstructor
@Controller
public class GraphQLCourseController {
    
    private final ICourseService courseService;

    @QueryMapping(name = "findCourseById")
    public Course findById(@Argument(name = "courseId") String id){
        return courseService.findById(Long.parseLong(id));
    }

    @QueryMapping(name = "findAllCourses")
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @MutationMapping(name = "createCourse")
    public Course createCourse(@Argument(name = "inputCourse") InputCourse inputCourse){

        Course course = new Course();
        course.setName(inputCourse.getName());
        course.setTeacher(inputCourse.getTeacher());
        course.setCategory(inputCourse.getCategory());

        courseService.createObjectClass(course);
        return course;
    }

    @MutationMapping
    public String deleteCourse(@Argument(name = "courseId") String id){
        courseService.deleteById(Long.parseLong(id));

        return String.format("El curso %s fue eliminado", id);
    }

}
