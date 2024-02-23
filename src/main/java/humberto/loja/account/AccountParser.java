package humberto.loja.account;

public class AccountParser {

    public static Account to(AccountIn in){
        return Account.builder()
        .email(in.email())
        .name(in.name())
        .password(in.password())
        .build();
    }

    public static AccountOut to(Account in){
        return AccountOut.builder()
        .email(in.email())
        .name(in.name())
        .id(in.id())
        .build();
    }
}
