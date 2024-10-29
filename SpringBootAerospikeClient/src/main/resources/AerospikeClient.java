import org.springframework.web.bind.annotation.GetMapping;

import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.Policy;
import com.centroxy.controller.AerospikeClient;
@Controller
public class AerospikeClient {
	
	
	public void  getData() {
	// Configure connection parameters
    ClientPolicy clientPolicy = new ClientPolicy();
    clientPolicy.timeout = 3000; // Timeout in milliseconds
    String hostname = "10.14.147.75";
    int port = 3000;
    String namespace = "test";
    String setName = "users";
    String key = "user123"; // Key of the record to retrieve

    // Initialize the client
    AerospikeClient client = new AerospikeClient(clientPolicy,hostname,port);

    try {
        // Define the policy for record retrieval (optional)
        Policy policy = new Policy();
        policy.timeout = 100; // Timeout in milliseconds

        // Retrieve the record from the database
        Record record = client.get(policy, new com.aerospike.client.Key(namespace, setName, key));

        // Check if the record exists
        if (record != null) {
            // Extract data from the record
            String username = record.getString("username");
            int age = record.getInt("age");

            // Output retrieved data
            System.out.println("Username: " + username);
            System.out.println("Age: " + age);
        } else {
            System.out.println("Record not found");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close the client connection
        client.close();
    }
	

}
