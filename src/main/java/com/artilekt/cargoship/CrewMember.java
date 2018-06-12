package com.artilekt.cargoship;

public class CrewMember implements Comparable<CrewMember> {
	private String id;
	private int age;
	private String name;
	private String status = "not defined";


	public CrewMember(String id, String name, int age) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrewMember other = (CrewMember) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(CrewMember o) {
		return id.compareTo(o.id);
	}	
	
	@Override
	public String toString() {
		return "CrewMember [id=" + id + ", age=" + age + ", name=" + name + ", status=" + status + "]";
	}
	
	

	
}
