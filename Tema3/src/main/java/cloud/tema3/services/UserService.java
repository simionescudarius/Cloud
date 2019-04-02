package cloud.tema3.services;

import java.util.UUID;

import cloud.tema3.entities.User;
import cloud.tema3.services.common.CrudService;

public interface UserService extends CrudService <User, UUID> {
	
}
