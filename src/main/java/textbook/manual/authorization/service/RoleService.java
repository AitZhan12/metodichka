package textbook.manual.authorization.service;

import textbook.manual.authorization.exceptions.ServiceException;
import textbook.manual.authorization.models.dtos.entities.Role;

import java.util.List;

public interface RoleService {
    Role findById(Long id) throws ServiceException;
    List<Role> findAll();
    List<Role> findAllWithDeleted();
    Role update(Role role) throws ServiceException ;
    Role save(Role role) throws ServiceException ;
    void delete(Role role) throws ServiceException ;
    void deleteById(Long id) throws ServiceException;
}
