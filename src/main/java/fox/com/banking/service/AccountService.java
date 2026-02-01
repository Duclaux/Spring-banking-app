    package fox.com.banking.service;

    import fox.com.banking.dto.AccountDto;
    import fox.com.banking.dto.TransfertDto;

    import java.util.List;

    public interface AccountService {

        AccountDto createAccount(AccountDto account);

        AccountDto getAccountById(Long id);

        AccountDto deposit(Long id, double amount);

        AccountDto withdraw(Long id, double amount);

        List<AccountDto> getAllAccounts();

        void deleteAccount(Long id);

        void transferFounds(TransfertDto transfertDto);
    }
