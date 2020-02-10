package org.springframework.samples.petclinic.alumn;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class AlumnoService{
	@Autowired
	private AlumnoRepository alumnoRepository;
	public List<Alumno> findAll(){
		return this.alumnoRepository.findAll();
	}
	public Alumno findById(Integer id) {
		return this.alumnoRepository.findOne(id);
	}
	public Alumno save(Alumno a) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(a);
	}
	public void deleteAlum(Alumno fromDB) {
		// TODO Auto-generated method stub
		this.alumnoRepository.delete(fromDB);
	}
	public void deleteAll() {
		// TODO Auto-generated method stub
		this.alumnoRepository.deleteAll();
	}
	public List<Alumno> findByEdadMenor(Date edadMenor, Date edadMayor) {
		// TODO Auto-generated method stub
		return this.alumnoRepository.findByEdadMenor(edadMenor, edadMayor);
	}
}