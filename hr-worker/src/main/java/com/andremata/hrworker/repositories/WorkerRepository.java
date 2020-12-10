package com.andremata.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andremata.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
