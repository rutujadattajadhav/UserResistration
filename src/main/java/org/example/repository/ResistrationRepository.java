package org.example.repository;

import org.example.model.ResistrationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResistrationRepository extends CrudRepository<ResistrationModel,String> {
}
