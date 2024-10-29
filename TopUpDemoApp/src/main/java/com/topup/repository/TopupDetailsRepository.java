package com.topup.repository;

import com.topup.model.TopupDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopupDetailsRepository  extends CrudRepository<TopupDetails,Integer> {

    public List<TopupDetails> findAllByServiceId(String serviceId);
}
