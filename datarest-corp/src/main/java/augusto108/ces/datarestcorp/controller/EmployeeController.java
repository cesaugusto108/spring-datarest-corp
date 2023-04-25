package augusto108.ces.datarestcorp.controller;

import augusto108.ces.datarestcorp.controller.assembler.EmployeeRepresentationModelAssembler;
import augusto108.ces.datarestcorp.model.Employee;
import augusto108.ces.datarestcorp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;
    private final EmployeeRepresentationModelAssembler modelAssembler;
    private final PagedResourcesAssembler<Employee> resourcesAssembler;


    @GetMapping("/registration/search")
    public PagedModel<EntityModel<Employee>> findEmployeeByRegistration(
            @RequestParam(defaultValue = "") String registration,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return resourcesAssembler.toModel(service.findEmployeeByRegistration(registration, page, size), modelAssembler);
    }

    @GetMapping("/description/search")
    public PagedModel<EntityModel<Employee>> findEmployeeByDescription(
            @RequestParam(defaultValue = "") String description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return resourcesAssembler.toModel(service.findEmployeeByDescription(description, page, size), modelAssembler);
    }

    @GetMapping("/search")
    public PagedModel<EntityModel<Employee>> findEmployees(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return resourcesAssembler.toModel(service.findEmployees(search, page, size), modelAssembler);
    }
}
