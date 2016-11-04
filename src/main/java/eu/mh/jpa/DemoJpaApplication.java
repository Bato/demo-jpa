package eu.mh.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}
	

// iteration2 	
// replaced with Component DummyDataCLR
//		@Bean
//		CommandLineRunner runner (ReservationRepository rr) {
//			return args ->  {
//				Arrays.asList("Les,Josh,Phil,Sasha,Peter".split(","))
//				.forEach(n -> rr.save(new Reservation(n)));
//				
//				rr.findAll().forEach(System.out::println);
//				rr.findByReservationName("Les").forEach(System.out::println);
//			};	
//		}

// iteration 1	
//	CommandLineRunner runner (CollectionTableExampleRepository repository) {
//	return new CommandLineRunner() {			
//		@Override
//		public void run(String... args) throws Exception {	
//			
//			importTestData();
//		}
//	};
//}	



}
