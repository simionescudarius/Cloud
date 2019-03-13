package repository;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

import store.Resource;

public class ResourceRepository {

	public List<Resource> retrieveAllResources() {
		return Resource.resources;
	}

	public Resource createResource(Resource resource) {
		int randomId = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);

		while (!idIsValid(randomId)) {
			randomId = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
		}

		resource.setId(randomId);
		Resource.resources.add(resource);

		return resource;
	}

	public Resource retrieveResourceById(int resourceId) {
		for (Resource resource : Resource.resources) {
			if (resource.getId() == resourceId) {
				return resource;
			}
		}
		return null;
	}

	public boolean deleteResource(int resourceId) {
		for (ListIterator<Resource> iterator = Resource.resources.listIterator(); iterator.hasNext();) {
			Resource resource = iterator.next();
			if (resource.getId() == resourceId) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}
	
	public void deleteAllResources() {
		Resource.resources.clear();
	}

	private boolean idIsValid(int id) {
		for (Resource resource : Resource.resources) {
			if (resource.getId() == id) {
				return false;
			}
		}
		return true;
	}
}
