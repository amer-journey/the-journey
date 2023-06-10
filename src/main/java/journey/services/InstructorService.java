package journey.services;

import journey.model.Course;
import journey.model.Instructor;
import journey.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorService {
    final StudentService studentService;

    @Autowired
    public InstructorService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Instructor> search(String name) {
        //TODO: call repository action
        ArrayList<Instructor> instructors = new ArrayList<>();
        instructors.add(new Instructor("Amer"));
        instructors.add(new Instructor("Omar"));
        return instructors;
    }

    public Instructor getInstructorById(long id) {
        //TODO: call repository action
        return new Instructor("Amer");
    }

    public boolean acceptStudent() {
        Student student = this.studentService.getStudent();
        return student.getName().equals("Amer");
    }

    public double rate(long id, double newRate) {
        //TODO: call repository action
        Instructor instructor = new Instructor("Amer");
        // TODO: validate if the student participated with instructor's courses
        double instructorRate = instructor.getRate();
        int rateCount = instructor.getRateCount() + 1;
        double updatedRate = (instructorRate + newRate) / rateCount;
        // TODO: call repository action to update instructor rate
        return updatedRate;
    }
}
