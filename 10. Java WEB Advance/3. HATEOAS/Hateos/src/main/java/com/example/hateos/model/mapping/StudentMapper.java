package com.example.hateos.model.mapping;

import com.example.hateos.model.dto.StudentDTO;
import com.example.hateos.model.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO mapEntityToDTO(StudentEntity student);
}
