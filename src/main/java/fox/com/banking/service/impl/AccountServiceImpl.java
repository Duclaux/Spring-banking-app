package fox.com.banking.service.impl;

import fox.com.banking.dto.AccountDto;
import fox.com.banking.entity.Account;
import fox.com.banking.mapper.AccountMapper;
import fox.com.banking.repository.AccountRepository;
import fox.com.banking.service.AccountService;
import org.springframework.stereotype.Service;

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
}
