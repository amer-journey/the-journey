package journey.services;

import journey.model.Course;
import journey.model.Instructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    public List<Course> search(String title) {
        //TODO: call repository action
        ArrayList<Course> courses = new ArrayList<>();
        Instructor instructor = new Instructor("Amer");
        courses.add(new Course("Amer's Java course", new BigDecimal(200), instructor));
        courses.add(new Course("Amer's DB course", new BigDecimal(850), instructor));
        return courses;
    }

    public Course getCourseById(long id) {
        //TODO: call repository action
        Instructor instructor = new Instructor("Amer");
        return new Course("Amer's Java course", new BigDecimal(200), instructor);
    }

    public void buyCourse(long id) {
        //TODO: check if student is subscribed already
        //TODO: check if student has purchased the course already
        //TODO: call repository action
        Instructor instructor = new Instructor("Amer");
        Course course = new Course("Amer's Java course", new BigDecimal(200), instructor);
        //TODO: validate payment info
        //TODO: create new record in mapper table (between course and student)
    }

    public double rate(long id, double newRate) {
        //TODO: call repository action
        Instructor instructor = new Instructor("Amer");
        Course course = new Course("Amer's Java course", new BigDecimal(200), instructor);
        // TODO: validate if the student participated in the course
        double currentCourseRate = course.getRate();
        int rateCount = course.getRateCount() + 1;
        double updatedRate = (currentCourseRate + newRate) / rateCount;
        // TODO: call repository action to update course rate
        return updatedRate;
    }

    public void creat(Course course) {

    }

    public void edit(Course course) {
        //TODO: call repository action
        if (!course.getStartDate().isBefore(LocalDate.now())) {
            return;
        }
        // TODO: Notify students
    }
}
