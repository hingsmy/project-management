package com.hingsmy.projectmanagement.dao;

import com.hingsmy.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
