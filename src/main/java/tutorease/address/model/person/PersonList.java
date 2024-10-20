package tutorease.address.model.person;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Represents a list of persons.
 * Guarantees: list of persons is managed, ensuring uniqueness and easy access.
 *
 * @param <T> the type of Person managed by this list
 */
public class PersonList<T extends Person> {
    private final List<T> persons; // List to store persons

    public PersonList() {
        this.persons = new ArrayList<>(); // Initialize the ArrayList
    }

    /**
     * Constructs a new PersonList using an existing list of people.
     *
     * @param existingPeople The list of people to initialize the PersonList with.
     *                       Must not be null.
     * @throws NullPointerException if the provided list is null.
     */
    public PersonList(ArrayList<T> existingPeople) {
        requireNonNull(existingPeople, "The list of existing people cannot be null");
        this.persons = new ArrayList<>(existingPeople);

    }

    /**
     * Adds a person to the list.
     * @param person The person to add.
     * @return true if the person was added, false if already exists.
     */
    public boolean addPerson(T person) {
        if (!persons.contains(person)) {
            return persons.add(person);
        }
        return false;
    }

    /**
     * Removes a person from the list.
     * @param person The person to remove.
     * @return true if the person was removed, false if not found.
     */
    public boolean removePerson(T person) {
        return persons.remove(person);
    }

    /**
     * Retrieves a person by name.
     * @param name The name of the person to search for.
     * @return Optional containing the person if found, empty otherwise.
     */
    public Optional<T> findPersonByName(Name name) {
        return persons.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst();
    }

    /**
     * Returns an unmodifiable view of the persons.
     */
    public List<T> getPersons() {
        return Collections.unmodifiableList(persons);
    }

    /**
     * Checks if the specified person exists in the list of persons.
     *
     * @param person The person to check for existence.
     * @return {@code true} if the person exists in the list, {@code false} otherwise.
     * @throws NullPointerException if the provided person is null.
     */
    boolean containPerson(Person person) {
        requireNonNull(person, "Person cannot be null");
        return persons.contains(person);
    }

}
