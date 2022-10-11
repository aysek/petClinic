import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.package1.entity.Owner;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PetClinicRestControllerTest {

		private RestTemplate restTemplate;

		@Before
		public void setUp(){
			restTemplate=new RestTemplate();
		}
		@Test
		public void testCreateOwner(){
			Owner owner = new Owner();
			owner.setId(34L);
			owner.setFirstName("ayse");
			owner.setLastName("soyad");


			URI location = restTemplate.postForLocation("http://localhost:9081/rest/owner",owner);
			Owner owner2 = restTemplate.getForObject(location,Owner.class);

			MatcherAssert.assertThat(owner2.getFirstName(),Matchers.equalTo(owner.getFirstName()));
			MatcherAssert.assertThat(owner2.getLastName(),Matchers.equalTo(owner.getLastName()));
		}

		@Test
		public void testGetOwnerById(){
			ResponseEntity<Owner> response = restTemplate.getForEntity("http://localhost:9081/rest/owner/1", Owner.class);
			MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
			MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("ayse"));
		}
		@Test
		public void testGetByLastName(){
			ResponseEntity<List> response =restTemplate.getForEntity("http://localhost:9081/rest/owners",List.class);
			MatcherAssert.assertThat(response.getStatusCodeValue(),Matchers.equalTo(200));
			List<Map<String,String>> body = response.getBody();
			List<String> firstNames = body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
			MatcherAssert.assertThat(firstNames,Matchers.containsInAnyOrder("ayse","ayse4"));
		}


}
