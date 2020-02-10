package org.springframework.samples.petclinic.alumn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/alumnos")
@Api(value="alumnos", description="Alumnos de la petclinic")
public class AlumnoController{
	@Autowired
	private AlumnoService alumnoService;
	
	@ApiOperation(value="View a list of Alumnos", response = Iterable.class)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Succesfully retrieved list"),
			@ApiResponse(code=404, message="Not found alumnos")
	})
	@RequestMapping(value="/alumnos", method=RequestMethod.GET)
	public List<Alumno> findAll(){
		return this.alumnoService.findAll();
	}
	
	@RequestMapping(value="/alumnos/{idAlumno}", method=RequestMethod.GET)
	public ResponseEntity<Alumno> findById(@PathVariable("idAlumno") Integer id) {
		Alumno a = this.alumnoService.findById(id);
		if(a!=null)
			return ResponseEntity.status(HttpStatus.OK).body(a);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
//	@RequestMapping(value="/alumnos/edad/{max}", method=RequestMethod.GET)
//	public ResponseEntity<List<Alumno>> findByAgeLessThan(@PathVariable("max") Integer edad) {
//		List<Alumno> a = this.alumnoService.findByAgeLessThan(edad);
//		if(a!=null)
//			return ResponseEntity.status(HttpStatus.OK).body(a);
//		else
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	}
//	
	@RequestMapping(value="/alumnos", method=RequestMethod.POST)
	public Alumno saveAlumno(@RequestBody Alumno a) {
		if(a != null) {
			return alumnoService.save(a);
		}
		return null;
	}
	
	@RequestMapping(value="/alumnos/{idAlumno}", method=RequestMethod.DELETE)
	public ResponseEntity<Alumno> deleteAlumno (@PathVariable("idAlumno") Integer id) {
		Alumno fromDB = this.alumnoService.findById(id);
		if(fromDB!=null) {
			this.alumnoService.deleteAlum(fromDB);
			return ResponseEntity.status(HttpStatus.OK).body(fromDB);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@RequestMapping(value="/alumnos", method=RequestMethod.DELETE)
	public void deleteAllAlumno() {
		this.alumnoService.deleteAll();
	}
}