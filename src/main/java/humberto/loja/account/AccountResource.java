package humberto.loja.account;

// import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AccountResource implements AccountController{

    @GetMapping("/accounts/info")
    public String info(){
        return "Account Info";
    }

    @Autowired
    AccountService accountService;

    @Override
    public ResponseEntity<AccountOut> create(
            @RequestBody(required = true) AccountIn in){

            Account account = AccountParser.to(in);

            account = accountService.create(account);

            return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.id())
                .toUri())
            .body(AccountParser.to(account));

        // return new ResponseEntity<AccountOut>(AccountParser.to(account), HttpStatus.CREATED);
    };
    
    
    @Override
    public ResponseEntity<AccountOut> login(LoginIn in) {
        // TODO Auto-generated method stub
        Account account = accountService.login(in.email(), in.password());

        if(account == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            } 
        return ResponseEntity.ok(AccountParser.to(account));
    }
    ;
    

    @Override
    public ResponseEntity<AccountOut> update(
            @PathVariable(required = true) String id,
            @RequestBody(required = true) AccountIn in){
        return null;
    }

}
