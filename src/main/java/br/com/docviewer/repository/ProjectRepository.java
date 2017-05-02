package br.com.docviewer.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.docviewer.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Serializable> {

}
