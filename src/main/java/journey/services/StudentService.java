package journey.services;

import journey.model.Instructor;
import journey.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student student;

    public void contactInstructor(long instructorId) {
        Instructor instructor = new Instructor("Amer");
        if (!instructor.isAcceptAnonymousContact()) {
            // TODO: Throw an error
            return;
        }
        // TODO: Notify instructor
    }

    public void subscribe() {}

    public Student getStudent() {
        this.student.setName("Amer");
        return this.student;
    }
}
