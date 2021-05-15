package textbook.manual.authorization.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import textbook.manual.authorization.exceptions.ServiceException;
import textbook.manual.authorization.models.dtos.UserDto;
import textbook.manual.authorization.models.dtos.entities.Role;
import textbook.manual.authorization.models.dtos.entities.User;
import textbook.manual.authorization.models.mappers.UserMapper;
import textbook.manual.authorization.service.UserService;
import textbook.manual.authorization.shared.codes.ErrorCode;
import textbook.manual.authorization.shared.responses.SuccessResponse;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController{

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return buildResponse(userMapper.toDtoList(userService.findAll()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) throws ServiceException {
        return buildResponse(userMapper.toDto(userService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody UserDto userDto) throws ServiceException {
        User user = userMapper.toEntity(userDto);
        Role role = new Role();
        role.setId(Role.ROLE_USER);
        user.setRole(role);
        user = userService.save(user);
        return buildResponse(userMapper.toDto(user), HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validate(@RequestParam String login) throws ServiceException {
        User user = userService.findByLogin(login);
        if (user != null) {
            throw ServiceException.builder().message("Login exists").errorCode(ErrorCode.ALREADY_EXISTS).build();
        } else {
            return buildResponse(SuccessResponse.builder().message("OK").build(), HttpStatus.OK);
        }

    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ServiceException {
        userService.deleteById(id);
        return buildResponse(SuccessResponse.builder().message("deleted").build(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody UserDto userDto) throws ServiceException {
        userService.delete(userMapper.toEntity(userDto));
        return buildResponse(SuccessResponse.builder().message("deleted").build(), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT})
    public ResponseEntity<?> update(@RequestBody UserDto userDto) throws ServiceException {
        User user = userService.update(userMapper.toEntity(userDto));
        return buildResponse(SuccessResponse.builder()
                .message("updated")
                .data(userMapper.toDto(user))
                .build(), HttpStatus.OK);
    }

    @PostMapping("/current")
    public ResponseEntity<?> getCurrentUser(Authentication authentication) throws ServiceException {
        String login = authentication.getName();
        User user = userService.findByLogin(login);
        return buildResponse(SuccessResponse.builder()
                .message("found")
                .data(userMapper.toDto(user))
                .build(), HttpStatus.OK);
    }
}
