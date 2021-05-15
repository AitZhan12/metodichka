package textbook.manual.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import textbook.manual.authorization.exceptions.ServiceException;
import textbook.manual.authorization.models.dtos.entities.Role;
import textbook.manual.authorization.repository.RoleRepository;
import textbook.manual.authorization.service.RoleService;
import textbook.manual.authorization.shared.codes.ErrorCode;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoleImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(Long id) throws ServiceException {
        Optional<Role> roleOptional = roleRepository.findById(id);
        return roleOptional.orElseThrow(() -> ServiceException.builder()
                .errorCode(ErrorCode.RESOURCE_NOT_FOUND)
                .message("role not found")
                .build());
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAllByDeletedAtIsNull();
    }

    @Override
    public List<Role> findAllWithDeleted() {
        return roleRepository.findAll();
    }

    @Override
    public Role update(Role role) throws ServiceException {
        if(role.getId() == null){
            throw ServiceException.builder()
                    .errorCode(ErrorCode.SYSTEM_ERROR)
                    .message("role is null")
                    .build();
        }
        return  roleRepository.save(role);
    }

    @Override
    public Role save(Role role) throws ServiceException {
        if(role.getId() != null){
            throw ServiceException.builder()
                    .errorCode(ErrorCode.ALREADY_EXISTS)
                    .message("role already exists")
                    .build();
        }
        return  roleRepository.save(role);
    }

    @Override
    public void delete(Role role) throws ServiceException {
        if(role.getId() == null){
            throw ServiceException.builder()
                    .errorCode(ErrorCode.SYSTEM_ERROR)
                    .message("role is null")
                    .build();
        }
        role = findById(role.getId());
        role.setDeletedAt(new Date());
        roleRepository.save(role);
    }

    @Override
    public void deleteById(Long id) throws ServiceException {
        if(id == null){
            throw ServiceException.builder()
                    .errorCode(ErrorCode.SYSTEM_ERROR)
                    .message("id is null")
                    .build();
        }
        Role role = findById(id);
        role.setDeletedAt(new Date());
        roleRepository.save(role);
    }
}
