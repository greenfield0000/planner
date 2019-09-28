package greenfield.group.com.gateway.gates;

import greenfield.group.com.model.Account;
import greenfield.group.com.model.Role;
import greenfield.group.com.gatecommon.SimpleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthGate extends Gate {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/auth-gate/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResult<Account> login(@RequestBody Account account) {
        return ((SimpleResult<Account>) this.restTemplate
                .postForEntity(serviceRegistry.get(AUTH_SERVICE) + "/login", account, SimpleResult.class)
                .getBody());
    }

    @RequestMapping(path = "/auth-gate/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResult<Account> logout(@RequestBody Account account) {
        return ((SimpleResult<Account>) this.restTemplate
                .postForEntity(serviceRegistry.get(AUTH_SERVICE) + "/logout", account, SimpleResult.class)
                .getBody());
    }

    @RequestMapping(path = "/auth-gate/registry", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResult<Account> registry(@RequestBody Account account) {
        return ((SimpleResult<Account>) this.restTemplate
                .postForEntity(serviceRegistry.get(AUTH_SERVICE) + "/registry", account, SimpleResult.class)
                .getBody());
    }

    /**
     * Метод получает список ролей у аккаунта
     *
     * @param uuid уникальный идентификатор аккаунта
     * @return
     */
    @RequestMapping(path = "/auth-gate/getAccountRoleSysNameByUUID", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Role getAccountRoleSysNameByUUID(@RequestBody String uuid) {
        return this.restTemplate
                .postForEntity(serviceRegistry.get(AUTH_SERVICE) + "/getAccountRoleSysNameByUUID", uuid, Role.class)
                .getBody();
    }
}