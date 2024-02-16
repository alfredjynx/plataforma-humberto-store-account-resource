package humberto.loja.account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountResource implements AccountController{

    @GetMapping("/accounts/info")
    public String info(){
        return "Account Info";
    }

    @Override
    public ResponseEntity<AccountOut> create(
            @RequestBody(required = true) AccountIn in){
        return null;
    };

    @Override
    public ResponseEntity<AccountOut> update(
            @PathVariable(required = true) String id,
            @RequestBody(required = true) AccountIn in){
        return null;
    };

}
