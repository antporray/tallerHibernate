package org.springframework.samples.petclinic.alumn;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	@Query(value= "from Alumno a where yourDate BETWEEN :startDate AND :endDate")
	List<Alumno> findByEdadMenor(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
}