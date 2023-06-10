package journey.model;

public class Announcement {
    private Course course;
    private String title;
    private String text;

    public Announcement(Course course, String title, String text) {
        this.course = course;
        this.title = title;
        this.text = text;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
