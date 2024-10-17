package tutorease.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static tutorease.address.testutil.Assert.assertThrows;
import static tutorease.address.testutil.TypicalStudents.ALICE;
import static tutorease.address.testutil.TypicalStudents.BOB;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonListTest {
    private PersonList<Person> personList; // Use Person instead of TestPerson
    private Person person1;
    private Person person2;

    @BeforeEach
    public void setUp() {
        personList = new PersonList<>();
        person1 = ALICE;
        person2 = BOB;
    }

    @Test
    public void addPerson_personNotExists_returnsTrue() {
        assertTrue(personList.addPerson(person1)); // Person added successfully
        assertTrue(personList.addPerson(person2)); // Another person added successfully
    }

    @Test
    public void addPerson_personAlreadyExists_returnsFalse() {
        personList.addPerson(person1);
        assertFalse(personList.addPerson(person1)); // Duplicate person should not be added
    }

    @Test
    public void removePerson_personExists_returnsTrue() {
        personList.addPerson(person1);
        assertTrue(personList.removePerson(person1)); // Person should be removed successfully
    }

    @Test
    public void removePerson_personNotFound_returnsFalse() {
        assertFalse(personList.removePerson(person1)); // Person not in the list, should return false
    }

    @Test
    public void getPersons_returnsUnmodifiableList() {
        personList.addPerson(person1);
        personList.addPerson(person2);

        List<Person> persons = personList.getPersons();

        assertThrows(UnsupportedOperationException.class, () -> {
            persons.add(person1); // Should throw exception as the list is unmodifiable
        });

        assertEquals(2, persons.size()); // Ensure size is still 2
    }
}
