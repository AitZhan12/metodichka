package textbook.manual.authorization.service;

import textbook.manual.authorization.exceptions.ServiceException;
import textbook.manual.authorization.models.dtos.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService{
    User findById(Long id) throws ServiceException;
    List<User> findAll();
    List<User> findAllWithDeleted();
    User update(User user) throws ServiceException ;
    User save(User user) throws ServiceException ;
    void delete(User user) throws ServiceException ;
    void deleteById(Long id) throws ServiceException ;
    Set getAuthority(User user);
    User findByLogin(String login);
}
