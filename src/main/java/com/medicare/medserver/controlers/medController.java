package com.medicare.medserver.controlers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.medserver.modules.Medicines;
import com.medicare.medserver.services.MedServiceImpl;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class medController {
	@Autowired
	MedServiceImpl medimpl;
	
	@PostMapping("/addMed")
	@CrossOrigin("*")
	public Medicines AddMed(@RequestBody Medicines med) throws Exception {
		Medicines medi=medimpl.AddMedicine(med);
		return medi;
		}
	@PutMapping("/updateMed")
	@CrossOrigin("*")
	public Medicines updateMed(@RequestBody Medicines med) throws Exception {
		System.out.println(med.getId());
		Medicines medi=medimpl.UpdateMedicine(med);
		return medi;
	}
	@DeleteMapping("/deleteMed/{id}")
	@CrossOrigin("*")
	public void deleteMed(@PathVariable("id") int id) throws Exception {
		medimpl.deleteMedicine(id);
		
	}
	@GetMapping("/getAll/{offset}/{size}")
	@CrossOrigin
	public Page<Medicines> getAll(@PathVariable("offset") int o,@PathVariable("size") int s){
		return medimpl.getAllMedicines(o, s);
	}
	@GetMapping("/getAllByField/{offset}/{size}/{field}")
	@CrossOrigin
	public Page<Medicines> getAll(@PathVariable("offset") int o,@PathVariable("size") int s,@PathVariable("field") String f){
		return medimpl.getAllMedicines(o, s,f);
	}
	@GetMapping("/getByid/{id}")
	@CrossOrigin
	public Optional<Medicines> getByid(@PathVariable("id") int id){
		return medimpl.getMedicines(id);
	}

}
