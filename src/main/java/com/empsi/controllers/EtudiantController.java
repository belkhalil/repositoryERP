//package com.empsi.controllers;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.empsi.entities.Etudiant;
//import com.empsi.metier.EtudiantMetierImpl;
//
//
//
//
//@RestController
//public class EtudiantController {
//	
//@Autowired
// private EtudiantMetierImpl etudiantMetierImpl;
//
///**
// * 
// * @param e
// * @return
// */
//@RequestMapping("/save")
//public Etudiant addStudent(Etudiant e)
//{
//	
//	etudiantMetierImpl.save(e);
//	return e; 
//	
//	}
///**
// * 
// * @param id
// * @return
// */
//@RequestMapping("/getOneStudent")
//public Etudiant getEtudiant(Long id)
//{
//	if(etudiantMetierImpl.get(id)!= null)
//	return etudiantMetierImpl.get(id);
//	else return null;
//	}
//
///**
// * 
// * @return
// */
//@RequestMapping("/students")
//public List<Etudiant> getAllstudent()
//{
//	
//	return etudiantMetierImpl.getAll();
//	}
///**
// * 
// * @param id
// * @return
// */
//@RequestMapping("/deleteStudent")
//public boolean deleteEtudiant(Long id)
//{
//     etudiantMetierImpl.delete(id);
//     return true;
//}
//
//@RequestMapping("/updateStudent")
//public Etudiant updateStudent(Long id, String email,String adresse,String telgsm, String telfix)
//{
//	Etudiant e= etudiantMetierImpl.get(id);
//	e.setEmailUtilisateur(email);
//	e.setAdresseUtilisateur(adresse);
//	e.setTelUtilisateur(telgsm);
//	e.setTelFixUtilisateur(telfix);
//	
//	etudiantMetierImpl.Update(e);
//	return e;
//	}
//
//}
