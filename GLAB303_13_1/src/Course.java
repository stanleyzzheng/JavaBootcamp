public class Course {
    private String code, course_name, instructor_name;
    public Course(String code, String course_name, String instructor_name){
        this.code=code;
        this.course_name=course_name;
        this.instructor_name=instructor_name;
    }

    public Course() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }
}
