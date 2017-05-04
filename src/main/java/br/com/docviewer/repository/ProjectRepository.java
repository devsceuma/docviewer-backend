package br.com.docviewer.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.docviewer.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Serializable> {

}
