package com.fdmgroup.pojos;

import java.util.List;

public class Managers {
	
	private String id;
	private int salary;
	private String name;
	private int age;
	private List<Staff> staffs;
	
	public Managers() {}
	
	public Managers(String id,int salary,String name,int age,List<Staff> staffs) {
		
		
		this.id=id;
		this.salary=salary;
		this.name=name;
		this.age=age;
		this.staffs=staffs;
		
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}
	
	
	
	
	

}




/*[
    {
        "id": "1",
        "salary": 1000,
        "age": 35,
        "name": "Bell Pepper",
        "staffs": [
            {
                "id": 0,
                "name": "Ellison Diaz",
                "salary": 500
            },
            {
                "id": 1,
                "name": "Naomi Freeman",
                "salary": 200
            },
            {
                "id": 2,
                "name": "Kristina Wagner",
                "salary": 300
            }
        ]
    },
    {
        "id": "2",
        "salary": 1500,
        "age": 33,
        "name": "Fish Fillet",
        "staffs": [
            {
                "id": 0,
                "name": "Beatriz Wolfe",
                "salary": 500
            },
            {
                "id": 1,
                "name": "Rosemary Booth",
                "salary": 150
            },
            {
                "id": 2,
                "name": "Myrtle Lara",
                "salary": 300
            }
        ]
    }
]*/