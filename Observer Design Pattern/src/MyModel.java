import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class MyModel {

	public static final String FIRSTNAME = "firstName";
	public static final String LASTNAME = "secondName";

	List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();
	List<Person> persons = new ArrayList<Person>();

	public MyModel() {

		persons.add(new Person("Lars", "Vogel"));
		persons.add(new Person("Jim", "Knopf"));
	}

	class Person {

		private String firstName;
		private String lastName;

		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public void setFirstName(String firstName) {
			notifyListeners(this, FIRSTNAME, this.firstName, this.firstName = firstName);
		}

		public void setLastName(String lastName) {
			notifyListeners(this, LASTNAME, this.firstName, this.lastName = lastName);
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

	}

	public List<Person> getPersons() {
		return persons;
	}

	public void notifyListeners(Object object, String property, String oldValue, String newValue) {
		for (PropertyChangeListener name : listener) {
			name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
		}
	}

	public void addChangeListener(PropertyChangeListener newListener) {
		listener.add(newListener);
	}

}
