package pe.tk.ne.negociategraphql.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pe.tk.ne.negociategraphql.entities.Student;
import pe.tk.ne.negociategraphql.persistence.IStudentDAO;
import pe.tk.ne.negociategraphql.service.IStudentService;

@RequiredArgsConstructor
@Service
public class StudentImpl implements IStudentService {

    private final IStudentDAO studentDAO;

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) studentDAO.findAll();
    }

    @Override
    @Transactional
    public void createObjectClass(Student t) {
        studentDAO.save(t);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        studentDAO.deleteById(id);
    }

}
