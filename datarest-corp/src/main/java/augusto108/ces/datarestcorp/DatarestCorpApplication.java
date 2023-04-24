package augusto108.ces.datarestcorp;

import augusto108.ces.datarestcorp.model.Employee;
import augusto108.ces.datarestcorp.model.Name;
import augusto108.ces.datarestcorp.model.enums.Gender;
import augusto108.ces.datarestcorp.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class DatarestCorpApplication {
    private final static Logger LOGGER = Logger.getLogger(DatarestCorpApplication.class.getName());

    private final EmployeeRepository repository;

    public DatarestCorpApplication(EmployeeRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DatarestCorpApplication.class, args);
    }

    @Bean
    CommandLineRunner loadData() {
        return args -> {
            loadSampleData();
            System.out.println("Loaded.");
        };
    }

    @PostConstruct
    private void logDatabaseEntry() {
        repository.findAll().forEach(employee -> LOGGER.info("Initial database load sample: " + employee));
    }

    private void loadSampleData() {
        Employee e = new Employee();
        e.setId(1);
        e.setName(new Name("Ingrid", "Ferreira"));
        e.setAge(25);
        e.setGender(Gender.FEMALE);
        e.setDescription("CASHIER");
        e.setRegistration("000200178988");

        repository.save(e);
    }
}
