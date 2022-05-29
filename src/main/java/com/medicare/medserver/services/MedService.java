package com.medicare.medserver.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.medicare.medserver.modules.Medicines;


public interface MedService {
	
	public Medicines AddMedicine(Medicines medicine) throws Exception ;
	public Medicines getMedicines(String name) ;
	public Page<Medicines> getAllMedicines(int offset,int pagesize);
	public Page<Medicines> getAllMedicines(int offset,int pagesize,String category);
	public Medicines UpdateMedicine(Medicines medicine) throws Exception;
	public void deleteMedicine(int  id) ;

}
