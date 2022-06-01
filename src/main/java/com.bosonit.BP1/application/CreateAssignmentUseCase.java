package com.bosonit.BP1.application;

import com.bosonit.BP1.domain.Assignment;
import com.bosonit.BP1.domain.repository.AssignmentRepositoryJPA;
import com.bosonit.BP1.exceptions.exception404.CustomErrorRequest404;
import com.bosonit.BP1.exceptions.exception422.CustomErrorRequest422;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentInputDTO;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateAssignmentUseCase implements CreateAssignmentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AssignmentRepositoryJPA repository;

    public AssignmentOutputDTO addAssignment(AssignmentInputDTO assignmentDTO){

        Assignment assignment = modelMapper.map(assignmentDTO, Assignment.class);

        if (assignment.getUsuario() == null || assignment.getPassword() == null || assignment.getName() == null || assignment.getCompany_email() == null
        || assignment.getPersonal_email() == null || assignment.getCity() == null || assignment.getActive() == null || assignment.getCreated_date() == null
        || assignment.getUsuario().length() > 10) throw new CustomErrorRequest422("UNPROCCESABLE_ENTITY");
        repository.save(assignment);

        return modelMapper.map(assignment, AssignmentOutputDTO.class);
    }
}
