package org.azalio.em_project.repository;

import org.azalio.em_project.entity.EmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmRepo extends JpaRepository<EmEntity,Long> {

}
