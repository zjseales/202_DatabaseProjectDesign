package domain;

import java.util.Objects;
import net.sf.oval.constraint.*;

public class Student implements Comparable<Student> {
        
        @NotNull(message = "ID must be provided.")
        @Min(message = "ID must be greater than 100.", value = 100)
	private Integer id;
        
        @NotNull(message = "Name must be provided.")
        @NotBlank(message = "Name must be provided.")
        @Length(min=2, message="Name must contain at least two characters.")
	private String name;
	private String phoneNumber;
	private String address;
        private String major;

	public Student() {
	}

	public Student(Integer id, String name, String address, String phoneNumber, String major) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
                this.major = major;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        return Objects.equals(this.id, other.id);
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
        
        

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + '}';
	}

	@Override
	public int compareTo(Student other) {
		return this.getId().compareTo(other.getId());
	}

}
