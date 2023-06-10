package journey.services;

import journey.model.Announcement;
import journey.model.Course;
import journey.model.Instructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AnnouncementService {
    public void create() {
        Instructor instructor = new Instructor("Amer");
        Course course = new Course("Amer's Java course", new BigDecimal(200), instructor);
        Announcement announcement = new Announcement(course, "Test", "Test text");
        // TODO: Notify students
    }
}
