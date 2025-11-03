package com.fdmgroup.pojos;

public class Comments {
	
	private String id;
	private int userid;
	private String body;
	private int foodId;
	
	public Comments() {
		super();
		
	}
	
	public Comments(String id,int userid,String body,int foodId) {
		this.id=id;
		this.userid=userid;
		this.body=body;
		this.foodId=foodId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	
	
}


/*
 * [
    {
        "id": "1",
        "userid": 1,
        "body": "delicious",
        "foodId": 1
    },
    {
        "id": "2",
        "userid": 2,
        "body": "well done",
        "foodId": 1
    },
    {
        "id": "3",
        "userid": 3,
        "body": "it is okay",
        "foodId": 3
    },
    {
        "id": "4",
        "userid": 1,
        "body": "amazing",
        "foodId": 4
    }
]

 * */
