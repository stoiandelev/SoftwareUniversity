package com.example.hateos.web;


import com.example.hateos.model.dto.OrderDTO;
import com.example.hateos.model.dto.StudentDTO;
import com.example.hateos.model.entity.OrderEntity;
import com.example.hateos.model.entity.StudentEntity;
import com.example.hateos.model.mapping.StudentMapper;
import com.example.hateos.repository.StudentRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("students")
public class StudentsController {

    //ТОВА НЕ СЕ ПРАВИ!!!!!
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentsController(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<StudentDTO>>> getStudents() {
        List<EntityModel<StudentDTO>> allStudents = studentRepository
                .findAll()
                .stream()
                .map(studentMapper::mapEntityToDTO)
                .map(dto -> EntityModel.of(dto, createStudentsLinks(dto)))
                .toList();

        return ResponseEntity.ok(CollectionModel.of(allStudents));
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<CollectionModel<EntityModel<OrderDTO>>> getOrders(@PathVariable Long id) {
        StudentEntity student = studentRepository.findById(id).orElseThrow();

        List<EntityModel<OrderDTO>> orders = student
                .getOrders()
                .stream()
                .map(this::map)
                .map(EntityModel::of)
                .toList();

        return ResponseEntity.ok(CollectionModel.of(orders));
    }

    private OrderDTO map(OrderEntity orderEntity) {
        return new OrderDTO()
                .setId(orderEntity.getId())
                .setStudentId(orderEntity.getStudent().getId())
                .setCourseId(orderEntity.getCourse().getId());
    }


    @GetMapping("{id}")
    public ResponseEntity<EntityModel<StudentDTO>> getStudentsByID(@PathVariable Long id) {
        StudentDTO student = studentRepository
                .findById(id)
                .map(studentMapper::mapEntityToDTO)
                .orElseThrow();

        return ResponseEntity.ok(EntityModel.of(student, createStudentsLinks(student)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> update(@PathVariable Long id,
                                                          StudentDTO studentDTO) {
        //implementation not important for the demo
        return ResponseEntity.ok().build();
    }

    private Link[] createStudentsLinks(StudentDTO studentDTO) {
        List<Link> result = new ArrayList<>();

        Link selfLink = linkTo(methodOn(StudentsController.class)
                .getStudentsByID(studentDTO.getId())).withSelfRel();
        result.add(selfLink);

        Link updateLink = linkTo(methodOn(StudentsController.class)
                .update(studentDTO.getId(), studentDTO)).withRel("update");
        result.add(updateLink);

        Link orderLink = linkTo(methodOn(StudentsController.class)
                .getOrders(studentDTO.getId())).withRel("orders");
        result.add(orderLink);

        return result.toArray(new Link[0]);
    }
}
