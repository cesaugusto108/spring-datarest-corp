package augusto108.ces.datarestcorp.controller;

import augusto108.ces.datarestcorp.model.Employee;
import augusto108.ces.datarestcorp.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public List<Employee> findEmployeeByRegistration(@RequestParam(defaultValue = "") String registration) {
        return service.findEmployeeByRegistration(registration);
    }
}
