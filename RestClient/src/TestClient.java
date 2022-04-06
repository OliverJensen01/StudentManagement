import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		Student ben = new Student();
		ben.setFirstName("Pär");
		ben.setLastName("Annans");
		ben.setSchoolClass("A");
		ben.setAge(21);

		Entity benEntity = Entity.entity(ben, "application/JSON");

		Response response = client.target("http://localhost:8080/StudentManagement/webservice/students").request()
				.buildPost(benEntity).invoke();

		System.out.println(response.readEntity(Student.class).getId());
		response.close();

		response = client.target("http://localhost:8080/StudentManagement/webservice/students").request().buildGet()
				.invoke();
		List<Student> Students = response.readEntity(new GenericType<List<Student>>() {
		});

		for (Student e : Students) {
			System.out.println(e);
		}
		response.close();
	}

}
