package com.nttdata.bootcamp.project1.credits.infrastructure.repository;

import com.nttdata.bootcamp.project1.credits.infrastructure.model.dao.CreditDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICreditCrudRepository extends ReactiveCrudRepository<CreditDao, String>{
     
}
