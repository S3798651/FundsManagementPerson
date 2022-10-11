package com.fundsperson.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
    @Column(name = "postcode")
    private int postcode;
    @Column(name = "age")
    private int age;
    @Column(name = "job")
    private String job;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneno")
    private String phoneno;
	public Person() {

	}

	public Person(String name, String address,int postcode, int  age, String job, String email, String phoneno) {
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.age = age;
        this.job = job;
        this.email = email;
        this.phoneno = phoneno;
	}

	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String adr) {
		this.name = adr;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String adr) {
		this.address = adr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int a) {
		this.age = a;
	}
	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int a) {
		this.postcode = a;
	}
	public String getJob() {
		return job;
	}

	public void setJob(String j) {
		this.job = j;
	}

	public String geteEmail() {
		return email;
	}

	public void setEmail(String e) {
		this.email = e;
	}

	public String getePhoneno() {
		return phoneno;
	}

	public void setPhoneno(String p) {
		this.phoneno = p;
	}



	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", postcode=" + postcode + ", age=" + age + ", job" + job + ", email" + email + "phoneno" + phoneno +  "]";
	}

}
