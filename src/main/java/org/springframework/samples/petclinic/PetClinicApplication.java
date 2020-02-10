/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.alumn.Alumno;
import org.springframework.samples.petclinic.alumn.AlumnoRepository;


/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PetClinicApplication.class, args);
        
       
    }
    @Bean
  public CommandLineRunner demoAlumRepository(AlumnoRepository alumnoRepository) {
		return (args) ->{
			System.out.println("*******************************");
			System.out.println("BOOTCAMP - Spring y Spring Data y Spring MVC and REST - alumnoRepository");
			System.out.println("*******************************");
			
			System.out.println("Creamos un objeto Alumno");
			Alumno alum = new Alumno();
			alum.setNombre("Antonio Carlos");
			alum.setApellidos("PR");
			alum.setFechaNacimiento(new SimpleDateFormat("yyyy/MM/dd").parse("1991/04/19"));
			alum.setNota(6);
			
			System.out.println("Persistimos en BBDD");
			alum = alumnoRepository.save(alum);
			System.out.println("Comprobamos que se ha creado correctamente");
			Alumno alAux = alumnoRepository.findOne(alum.getId());
			System.out.println(alAux.toString());

			
			
		};
    }
    
//    @Bean
//    public CommandLineRunner demoVetRepository(VetRepository vetRepository, VisitRepository visitRepository, SpecialityRepository specialityRepository, PetRepository petRepository) {
//		return (args) ->{
//			System.out.println("*******************************");
//			System.out.println("BOOTCAMP - Spring y Spring Data - vetRespository");
//			System.out.println("*******************************");
//			
//			System.out.println("Creamos un objeto Vet");
//			Vet vet = new Vet();
//			vet.setFirstName("Sergio");
//			vet.setLastName("Raposo Vargas");
//			
//			System.out.println("Persistimos en BBDD");
//			vet = vetRepository.save(vet);
//			
//			System.out.println("Comprobamos que se ha creado correctamente");
//			Vet vetAux = vetRepository.findOne(vet.getId());
//			System.out.println(vetAux.toString());
//			
//			System.out.println("Editamos el objeto y añadimos una Speciality");
//			Specialty s = specialityRepository.findOne(1);
//			vet.addSpecialty(s);
//			vet = vetRepository.save(vet);
//			System.out.println(vet.toString());
//			
//			System.out.println("Listamos todos los veterinarios");
//			for(Vet v:vetRepository.findAll()) {
//				System.out.println("Vet: " + v);
//			}
//			
//			System.out.println("******************************************");
//			System.out.println("Filtramos por lastName=Raposo Vargas");
//			for(Vet v:vetRepository.findByLastName("Raposo Vargas")) {
//				System.out.println(v.toString());
//			}
//			
//			System.out.println("Filtramos por lastName = Raposo Vargas y firstName = Sergio");
//			for(Vet v: vetRepository.findByFirstNameAndLastName("Sergio", "Raposo Vargas")) {
//				System.out.println(v.toString());
//			}
//			
//			System.out.println("Filtramos por Sergio en firstName o lastName");
//			for(Vet v: vetRepository.findByFirstNameOrLastName("Sergio", "Sergio")) {
//				System.out.println(v.toString());
//			}
//			
//			System.out.println("******************");
//			System.out.println("Filtramos por la Specialty");
//			for(Vet v: vetRepository.findBySpecialityName("dentistry")) {
//				System.out.println(v.toString());
//			}
//			
//			System.out.println("***********Reto*******************");
////			System.out.println("Obtener mascotas nacidas en 2010 por fecha de nacimiento ascendente");
////			Date fecha = new Date(2000);
////			for(Pet p: petRepository.findByDate(2000)) {
////				System.out.println(p.toString());
////			}
//////			System.out.println("Crear 3 visitas para diferentes mascotas");
//////			Date fechaActual = new Date();
//////			Bill bil = new Bill();
//////			for(Pet p: petRepository.findByName("Max")) {
//////				Visit vis = new Visit();
//////				vis.setDate(fechaActual);
//////				vis.setDescription("rabies shot");
//////				vis.setId(p.getId());
//////				vis.setBill(bil);
//////				System.out.println(vis.toString());
//////			}
////			System.out.println("Todas las visitas de una mascota");
////			System.out.println("Las 4 visitas más recientes del sistema");
//			
//		};
//    	
//    }

}
