package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dto.TeacherSubjectsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherBL {
    @Autowired
    private UserBL userBL;

    public Iterable<TeacherSubjectsDTO> findTeacherSubjects(Integer teacherUserId) {
        return userBL.findMateriasDocente(teacherUserId);
    }
}
