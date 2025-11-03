package com.fdmgroup.pojos;

public class Foods {
	
	private String id;
	private String name;
	private double price;
	
	public Foods() {
		super();
	}
	
	public Foods(String id,String name,double price ) {
		this.id=id;
		this.name=name;
		this.price=price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}	
	
	
}








/*
[
    {
        "id": "1",
        "name": "cucumber salad",
        "price": 2.5
    },
    {
        "id": "2",
        "name": "french fries",
        "price": 5.5
    },
    {
        "id": "3",
        "name": "soft drink",
        "price": 5.5
    },
    {
        "id": "4",
        "name": "burgers",
        "price": 9.55
    }
]
*/