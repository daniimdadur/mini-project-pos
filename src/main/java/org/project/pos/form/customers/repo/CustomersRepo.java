package org.project.pos.form.customers.repo;

import org.project.pos.form.customers.model.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepo extends JpaRepository<CustomersEntity, String> {

}
