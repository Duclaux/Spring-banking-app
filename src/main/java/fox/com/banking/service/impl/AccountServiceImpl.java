package fox.com.banking.service.impl;

import fox.com.banking.dto.AccountDto;
import fox.com.banking.entity.Account;
import fox.com.banking.exception.AccountException;
import fox.com.banking.mapper.AccountMapper;
import fox.com.banking.repository.AccountRepository;
import fox.com.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAcountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                            .findById(id)
                            .orElseThrow(() -> new AccountException("Account doesn't exist"));
        return AccountMapper.mapToAcountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account doesn't exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccound = accountRepository.save(account);
        return AccountMapper.mapToAcountDto(account);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account doesn't exist"));
        if(account.getBalance() < amount){
            throw new RuntimeException("Insuffisient amount");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccound = accountRepository.save(account);
        return AccountMapper.mapToAcountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map((account) -> AccountMapper.mapToAcountDto(account))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account doesn't exist"));

        accountRepository.deleteById(id);
    }
}
