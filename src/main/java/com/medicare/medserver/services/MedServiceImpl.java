package com.medicare.medserver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medicare.medserver.modules.Medicines;
import com.medicare.medserver.repo.MedRepo;
@Service
public class MedServiceImpl implements MedService {
	
	@Autowired
	MedRepo medrepo;
	
	@Override
	public Medicines AddMedicine(Medicines medicine) throws Exception {
		// TODO Auto-generated method stub
		if(medrepo.findByName(medicine.getName())==null)
		{
			medrepo.save(medicine);
		}
		else
		{
			throw new Exception("Medicine Already Available");
		}
		return medicine;
	}
	@Override
	public Medicines UpdateMedicine(Medicines medicine) throws Exception {
		// TODO Auto-generated method stub
		
		return medrepo.save(medicine);
		
		
	}

	@Override
	public Medicines getMedicines(String name) {
		// TODO Auto-generated method stub
		Medicines med=medrepo.findByName(name);
		return med;
	}
	
	public Optional<Medicines> getMedicines(int id) {
		// TODO Auto-generated method stub
		Optional<Medicines> med=medrepo.findById(id);
		return med;
	}


	@Override
	public void deleteMedicine(int id) {
		// TODO Auto-generated method stub
		medrepo.deleteById(id);
		
	}
	@Override
	public Page<Medicines> getAllMedicines(int offset,int pagesize) {
		return medrepo.findAll(PageRequest.of(offset,pagesize));

		
	}
	@Override
	public Page<Medicines> getAllMedicines(int offset,int pagesize,String field) {
		Pageable p=PageRequest.of(offset, pagesize);
		return medrepo.findAllByCategory(field,p);
		

		
	}
	

//	@Override
//	public Medicines UpdateMedicine(Medicines medicine) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println(medicine);
//		Medicines upmed=new Medicines();
//		try {
//		 upmed=medrepo.getById(medicine.getId());
//		 System.out.println(upmed);
//		 if(medicine.getBrand()!=null)
//				upmed.setBrand(medicine.getBrand());
//				if(medicine.getCategory()!=null)
//				upmed.setCategory(medicine.getCategory());
//				if(medicine.getName()!=null)
//					upmed.setName(medicine.getName());
//				if(medicine.getDescription()!=null)
//					upmed.setDescription(medicine.getDescription());
//				if(medicine.getImage()!=null)
//					upmed.setImage(medicine.getImage());
		 //upmed.setDescription(medicine.getDescription());
				//medrepo.save(upmed);
		// }
//		catch(Exception e) {
//			e.printStackTrace();
//			throw new Exception("NOT FOUND "+medicine.getId());
//			
//		}
//		
//		return upmed;
//	}

}
