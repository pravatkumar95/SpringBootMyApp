package com.topup.repository;

import com.topup.model.Topup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCTSRepository extends CrudRepository<Topup,Double> {
    List<Topup> findByDisplayName(String displayName);


        List<Topup> findByDisplayNameAndValidity(String displayName, Integer validity);


}
