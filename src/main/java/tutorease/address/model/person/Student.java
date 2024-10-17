package tutorease.address.model.person;

import static tutorease.address.model.person.Role.STUDENT;

import java.util.Set;

import tutorease.address.model.tag.Tag;
/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student extends Person {
    private final PersonList<Person> guardians;
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
    }

    public Role getRole() {
        return new Role(STUDENT);
    }

    public PersonList<Person> getRelated() {
        return this.guardians;
    }

    public void addGuardian(Guardian guardian) {
        this.guardians.addPerson(guardian);
    }
}
