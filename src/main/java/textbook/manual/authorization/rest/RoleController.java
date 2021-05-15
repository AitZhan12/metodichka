package textbook.manual.authorization.rest;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import textbook.manual.authorization.exceptions.ServiceException;
import textbook.manual.authorization.models.dtos.entities.Role;
import textbook.manual.authorization.models.mappers.RoleMapper;
import textbook.manual.authorization.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController extends BaseController{
    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return buildResponse(roleMapper.toDtoList(roleService.findAll()), HttpStatus.OK);
    }

    @PostMapping
    public Role saveRole(Role role) throws ServiceException {
        return roleService.save(role);
    }

    @GetMapping("{id}")
    @ApiOperation("Получение всех ролей в грязном виде")
    public ResponseEntity<?> getOne(@ApiParam("ID элемента") @PathVariable Long id) throws ServiceException {
        return buildResponse(roleMapper.toDto(roleService.findById(id)), HttpStatus.OK);
    }
}
