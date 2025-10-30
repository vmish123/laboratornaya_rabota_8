package EighthTask;

public class Student {

    private long id;
    private String lastName;
    private String firstName;
    private String patronymic; // Отчество
    private String birthDate;  // Дата рождения в формате "dd.MM.yyyy"
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    // Конструкторы
    public Student(long id, String lastName, String firstName, String faculty, int course, String group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public Student(long id, String lastName, String firstName, String patronymic, String birthDate, String address, String phone, String faculty, int course, String group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    // Геттеры и сеттеры
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    // Парсинг года рождения
    public int getBirthYear() {
        return Integer.parseInt(birthDate.substring(6));
    }

    // Метод toString
    public String toString() {
        return "Студент " + lastName + " " + firstName + " " + patronymic + '\n' +
                " ID = " + id + '\n' +
                " Дата рождения = " + birthDate + '\n' +
                " Адрес = " + address + '\n' +
                " Телефон = " + phone + '\n' +
                " Факультет = " + faculty + '\n' +
                " Курс = " + course + '\n' +
                " Группа = " + group + '\n';
    }
}
