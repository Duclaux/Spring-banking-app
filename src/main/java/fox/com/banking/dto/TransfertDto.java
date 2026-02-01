package fox.com.banking.dto;

public record TransfertDto(
        Long fromAccountId,
        Long toAccountId,
        double amount
) {}
