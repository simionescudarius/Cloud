package store;

import java.util.ArrayList;
import java.util.List;

public class Resource {
	private String name;
	private String description;
	private int id;
	private int size;
	public static List<Resource> resources = new ArrayList<Resource>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", description=" + description + ", size=" + size + "]";
	}
}
