    package fox.com.banking.service;

    import fox.com.banking.dto.AccountDto;

    public interface AccountService {

        AccountDto createAccount(AccountDto account);

        AccountDto getAccountById(Long id);

        AccountDto deposit(Long id, double amount);
    }
