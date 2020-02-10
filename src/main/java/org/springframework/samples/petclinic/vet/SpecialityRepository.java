package org.springframework.samples.petclinic.vet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.vet.Vet;

public interface SpecialityRepository extends JpaRepository<Specialty, Integer> {
	
}
