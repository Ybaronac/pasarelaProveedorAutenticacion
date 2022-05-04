package co.gov.icfes.appGate.Controller;

import co.gov.icfes.appGate.Services.ADAzure.Implement.IAccountService;
import co.gov.icfes.appGate.dto.ADAzure.UserAccount;
import co.gov.icfes.appGate.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController()
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/Account/GetInformationAccount",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ApiResponse<UserAccount> GetInformationAccount(@RequestParam String idUserAccount) {
        return accountService.GetInformationAccount(idUserAccount);
    }

    @PostMapping(path = "/Account/CreateUserAccount",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<String> GetInformationAccount(@RequestBody UserAccount userAccount) {
        return accountService.CreateUserAccount(userAccount);
    }

    @RequestMapping(value = "/Account/DeleteUserAccount",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Boolean> DeleteUserAccount(@RequestParam String idUserAccount) {
        return accountService.DeleteUserAccount(idUserAccount);
    }
}
