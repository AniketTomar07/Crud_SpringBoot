package com.example.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
//    void deleteProjectById(Long id);


    Optional<Project> findProjectById(Long id);
}