CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL
)

CREATE TABLE IF NOT EXISTS students (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    subscription_expiry DATETIME IS NULL,
    user_id VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(username)
)

CREATE TABLE IF NOT EXISTS instructors (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    accept_anonymous_contact TINYINT NOT NULL DEFAULT 1,
    rate DOUBLE NOT NULL DEFAULT 0,
    rate_count INT NOT NULL DEFAULT 0,
    user_id VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(username)
)

CREATE TABLE IF NOT EXISTS instructor_qualifications (
    id VARCHAR(50) PRIMARY KEY,
    text VARCHAR(200) NOT NULL,
    instructor_id VARCHAR(50),
    FOREIGN KEY (instructor_id) REFERENCES instructors(id)
)

CREATE TABLE IF NOT EXISTS courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(200),
    prerequisites VARCHAR(200),
    price DECIMAL,
    rate DOUBLE NOT NULL DEFAULT 0,
    rate_count INT NOT NULL DEFAULT 0,
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_update_at DATETIME ON UPDATE CURRENT_TIMESTAMP,
    parent_course_id INT,
    FOREIGN KEY (parent_course_id) REFERENCES course(id)
)

CREATE TABLE IF NOT EXISTS students_courses (
    student_id VARCHAR(50) NOT NULL,
    course_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(id)
    FOREIGN KEY (course_id) REFERENCES courses(id)
)

CREATE TABLE IF NOT EXISTS instructors_courses (
    instructor_id VARCHAR(50) NOT NULL,
    course_id INT NOT NULL,
    FOREIGN KEY (instructor_id) REFERENCES instructors(id)
    FOREIGN KEY (course_id) REFERENCES courses(id)
)

CREATE TABLE IF NOT EXISTS instructors_course_contents (
    instructor_id VARCHAR(50) NOT NULL,
    course_content_id INT NOT NULL,
    FOREIGN KEY (instructor_id) REFERENCES instructors(id)
    FOREIGN KEY (course_content_id) REFERENCES course_contents(id)
)

CREATE TABLE IF NOT EXISTS reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(200),
    rate DOUBLE NOT NULL DEFAULT 0,
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    student_id VARCHAR(50) NOT NULL,
    course_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
)

CREATE TABLE IF NOT EXISTS course_contents (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(200),
    content VARCHAR(50) NOT NULL,
    is_free TINYINT NOT NULL DEFAULT 0,
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_update_at DATETIME ON UPDATE CURRENT_TIMESTAMP,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(id)
)

CREATE TABLE IF NOT EXISTS comments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    text VARCHAR(200),
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_update_at DATETIME ON UPDATE CURRENT_TIMESTAMP,
    parent_comment_id INT IS NULL,
    course_content_id INT NOT NULL,
    user_id VARCHAR(50) NOT NULL,
    FOREIGN KEY (course_content_id) REFERENCES course_contents(id),
    FOREIGN KEY (user_id) REFERENCES users(username)
    FOREIGN KEY (parent_comment_id) REFERENCES comments(id)
)

CREATE TABLE IF NOT EXISTS announcements (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    text VARCHAR(200),
    creation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(id),
)

CREATE TABLE IF NOT EXISTS announcements_instructors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    instructor_id VARCHAR(50) NOT NULL,
    announcement_id INT NOT NULL,
    FOREIGN KEY (instructor_id) REFERENCES instructors(id),
    FOREIGN KEY (announcement_id) REFERENCES announcements(id),
)