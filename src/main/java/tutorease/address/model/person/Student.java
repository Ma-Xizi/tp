package tutorease.address.model.person;

import static java.util.Objects.requireNonNull;
import static tutorease.address.model.person.Role.STUDENT;

import java.util.HashSet;
import java.util.Set;

import tutorease.address.model.tag.Tag;
/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student extends Person {
    private final PersonList<Person> guardians;
    private String zoomLink;
    private final Set<String> subjects;
    private final String gradeLevel;
    private final double fees;
    private final String examDetails;
    /**
     * Every field must be present and not null.
     *
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param role
     * @param tags
     */

    public Student(Name name, Phone phone, Email email, Address address, Role role, Set<Tag> tags) {
        super(name, phone, email, address, role, tags);
        this.guardians = new PersonList<Person>();
        this.zoomLink = "";
        this.subjects = new HashSet<>();
        this.gradeLevel = "";
        this.fees = 0;
        this.examDetails = "";

    }

    public Role getRole() {
        return new Role(STUDENT);
    }

    public PersonList<Person> getRelated() {
        return this.guardians;
    }

    /**
     * Adds a guardian to the list of guardians if it does not already exist.
     *
     * @param guardian The guardian to add.
     * @throws NullPointerException if the provided guardian is null.
     */
    public void addGuardian(Guardian guardian) {
        requireNonNull(guardian, "Guardian cannot be null");

        if (!this.guardians.containPerson(guardian)) {
            this.guardians.addPerson(guardian);
        }
    }

    public String getZoomLink() {
        return zoomLink;
    }

    public void setZoomLink(String zoomLink) {
        this.zoomLink = zoomLink;
    }

    public Set<String> getSubjects() {
        return subjects;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public double getFees() {
        return fees;
    }

    public String getExamDetails() {
        return examDetails;
    }
}
