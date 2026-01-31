package fox.com.banking.repository;

import fox.com.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccoutRepository extends JpaRepository<Account, Long> {
}
