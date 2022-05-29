package com.medicare.medserver.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.medicare.medserver.modules.Medicines;


@Repository
public interface MedRepo extends JpaRepository<Medicines, Integer> {
	public Medicines findByName(String name);
	public Page<Medicines> findAllByCategory(String category, Pageable pageable);
}
