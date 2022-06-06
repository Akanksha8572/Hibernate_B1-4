package com.tns.client;

import java.time.LocalDate;
import com.tns.entities.Admin;
import com.tns.entities.Certificate;
import com.tns.entities.College;
import com.tns.entities.Placement;
import com.tns.entities.Student;
import com.tns.entities.User;
import com.tns.service.AdminServiceImp;
import com.tns.service.CertificateServiceImp;
import com.tns.service.CollegeServiceImp;
import com.tns.service.IAdminService;
import com.tns.service.ICertificateService;
import com.tns.service.ICollegeService;
import com.tns.service.IPlacementService;
import com.tns.service.IStudentService;
import com.tns.service.IUserService;
import com.tns.service.PlacementServiceImp;
import com.tns.service.StudentServiceImp;
import com.tns.service.UserServiceImp;

public class Client {

	public static void main(String[] args) {
		Student student = new Student();
		IStudentService service = new StudentServiceImp();
		
	    student.setId(101);
		student.setName("Akanksha");
		student.setRoll(2);
		student.setQualification("b.tech");
		student.setCourse("Techno");
		student.setYear(2022);
		Certificate c=new Certificate();
		c.setId(1001);
		c.setYear(2022);
		College col=new College();
		col.setId(501);
		col.setCollegeName("Ashoka Institute Of Technology ");
		col.setLocation("Varanasi");
		User u=new User();
		u.setId(201);
		u.setName("Sunil ");
		u.setPassword("11111111");
		IUserService user=new UserServiceImp();
		user.addNewUser(u);
		col.setCollegeAdmin(u);
		ICollegeService college=new CollegeServiceImp();
		college.addCollege(col);
		c.setCollege(col);
		ICertificateService certificate=new CertificateServiceImp();
		certificate.addCertificate(c);
        student.setCollege(col);
		student.setRoll(150);
		student.setQualification("BE");
		student.setCourse("CSE");
	    student.setCertificate(c);
		student.setHallTicketNo(701);
		
		Admin a=new Admin();
		a.setId(301);
		a.setName(" kumar ");
		a.setPassword("00000000");
	    IAdminService ad=new AdminServiceImp();
	    ad.addNewAdmin(a);
		
		
		System.out.println("date is added");
		Placement p=new Placement();
		p.setId(901);
		LocalDate date=LocalDate.now();
		p.setDate(date);
		p.setQualification("BE");
		p.setCollege(col);
		p.setName("creaters placement group");
		p.setYear(2022);
		IPlacementService placement =new PlacementServiceImp();
		placement.addPlacement(p);
		service.addStudent(student);
	
	
	
		
	   System.out.println("data is added");
		
		
	student = service.searchStudentById(101);
		System.out.println("Id is: "+student.getId());
		System.out.println("Roll is: "+student.getRoll());
		System.out.println("college is: "+student.getCollege());
		
		student = service.searchStudentById(101);
		student.setCollege(col);
		service.updateStudent(student);
		System.out.println("Updated successfully");
	
		
		/*student= service.searchStudentById(100);
		service.deleteStudent(100);
		System.out.println("delete is sucessful");
	*/
	}

}
