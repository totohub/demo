
public class Demo {

	public static void main(String[] args) {
		MyModel model = new MyModel();
		MyObserver observer = new MyObserver(model);
		model.getPersons().get(0).setLastName("wrong");
		model.getPersons().get(1).setFirstName("wrong");
		//this is wrong

	}

}
