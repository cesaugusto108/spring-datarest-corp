package augusto108.ces.datarestcorp.controller.assembler;

import augusto108.ces.datarestcorp.controller.EmployeeController;
import augusto108.ces.datarestcorp.model.Employee;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EmployeeRepresentationModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {
    @Override
    public EntityModel<Employee> toModel(Employee entity) {
        return EntityModel.of(entity);
    }

    @Override
    public CollectionModel<EntityModel<Employee>> toCollectionModel(Iterable<? extends Employee> entities) {
        List<EntityModel<Employee>> employeeEntityModels = new ArrayList<>();

        for (Employee entity : entities) {
            employeeEntityModels.add(toModel(entity));
        }

        final Link search = linkTo(methodOn(EmployeeController.class).findEmployees("", 0, 5)).withRel("search");
        final Link registration = linkTo(methodOn(EmployeeController.class).findEmployeeByRegistration("", 0, 5)).withRel("search by registration");
        final Link description = linkTo(methodOn(EmployeeController.class).findEmployeeByDescription("", 0, 5)).withRel("search by description");

        return CollectionModel.of(employeeEntityModels, search, registration, description);
    }
}
