package augusto108.ces.datarestcorp.controller;

import augusto108.ces.datarestcorp.controller.assembler.EmployeeRepresentationModelAssembler;
import augusto108.ces.datarestcorp.model.Employee;
import augusto108.ces.datarestcorp.service.EmployeeService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService service;
    private final EmployeeRepresentationModelAssembler assembler;

    public EmployeeController(EmployeeService service, EmployeeRepresentationModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping("/registration/search")
    public CollectionModel<EntityModel<Employee>> findEmployeeByRegistration(@RequestParam(defaultValue = "") String registration) {
        return assembler.toCollectionModel(service.findEmployeeByRegistration(registration));
    }

    @GetMapping("/description/search")
    public CollectionModel<EntityModel<Employee>> findEmployeeByDescription(@RequestParam(defaultValue = "") String description) {
        return assembler.toCollectionModel(service.findEmployeeByDescription(description));
    }

    @GetMapping("/search")
    public CollectionModel<EntityModel<Employee>> findEmployees(@RequestParam(defaultValue = "") String search) {
        return assembler.toCollectionModel(service.findEmployees(search));
    }
}
