package com.crud.repository;

//import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.StudentEntity;

@Repository
public interface RepoStudent extends JpaRepository<StudentEntity, Integer> {

}
