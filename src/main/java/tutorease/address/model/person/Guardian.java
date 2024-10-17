package tutorease.address.model.person;

import java.util.Set;

import tutorease.address.model.tag.Tag;
/**
 * Represents a Guardian in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Guardian extends Person {
    private final PersonList<Person> students;

    /**
     * Constructs a {@code Guardian} with the specified details.
     *
     * Every field must be present and not null.
     *
     * @param name The name of the guardian.
     * @param phone The phone number of the guardian.
     * @param email The email address of the guardian.
     * @param address The physical address of the guardian.
     * @param role The role of the guardian.
     * @param tags A set of tags associated with the person, may be empty but must not be null.
     */
    public Guardian(Name name, Phone phone, Email email, Address address, Role role, Set<Tag> tags) {
        super(name, phone, email, address, role, tags);
        this.students = new PersonList<Person>();
    }

    public Role getRole() {
        return new Role(Role.GUARDIAN);
    }

    public PersonList<Person> getRelated() {
        return this.students;
    }
    public void overseeStudent(Student student) {
        this.students.addPerson(student);
    }
}
