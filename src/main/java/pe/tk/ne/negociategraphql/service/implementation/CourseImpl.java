package pe.tk.ne.negociategraphql.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pe.tk.ne.negociategraphql.entities.Course;
import pe.tk.ne.negociategraphql.persistence.ICourseDAO;
import pe.tk.ne.negociategraphql.service.ICourseService;

@RequiredArgsConstructor
@Service
public class CourseImpl implements ICourseService {

    private final ICourseDAO courseDAO;

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return courseDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) courseDAO.findAll();
    }

    @Override
    @Transactional
    public void createObjectClass(Course t) {
        courseDAO.save(t);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        courseDAO.deleteById(id);
    }
    
}
