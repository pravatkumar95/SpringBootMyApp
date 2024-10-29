package com.topup.repository;

import com.topup.model.ServicePlan;
import com.topup.model.Topup;
import org.springframework.data.repository.CrudRepository;

import java.security.Provider;

public interface ServicePlanRepository extends CrudRepository<ServicePlan,String> {


}
