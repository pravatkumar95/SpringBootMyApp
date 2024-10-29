package com.centroxy.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;

import com.centroxy.model.Employee;

@Repository
public interface AerospikeUserRepository extends AerospikeRepository<Employee, Integer>{
	
	List<Employee> findAllByJoinTimeStampBetween(long fromDate, long toDate);
	
	Employee findByEmail(String email);
	
	 List<Employee> findByAgeBetween(int startAge,int endAge);

}
