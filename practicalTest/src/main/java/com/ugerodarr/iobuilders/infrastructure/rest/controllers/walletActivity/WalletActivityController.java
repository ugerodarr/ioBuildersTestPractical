package com.ugerodarr.iobuilders.infrastructure.rest.controllers.walletActivity;

import com.ugerodarr.iobuilders.application.services.walletActivity.BalanceWalletAccountService;
import com.ugerodarr.iobuilders.application.services.walletActivity.DepositMoneyService;
import com.ugerodarr.iobuilders.application.services.walletActivity.TransferService;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import com.ugerodarr.iobuilders.infrastructure.dtos.walletActivity.DepositMoneyDTO;
import com.ugerodarr.iobuilders.infrastructure.dtos.walletActivity.TransferDTO;
import com.ugerodarr.iobuilders.infrastructure.viewModels.BalanceWalletAccountViewModel;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/walletActivity")
public class WalletActivityController {

    @Autowired
    DepositMoneyService depositMoneyService;

    @Autowired
    TransferService transferService;

    @Autowired
    BalanceWalletAccountService balanceWalletAccountService;

    @PostMapping("/depositMoney")
    @Operation(
            summary = "Deposit Money",
            description = "Deposit Money for the specific userId and walletAccountId, with description and quantity. Check if user exists and if walletAccount is valid for this user.",
            tags = { "WalletActivity" }
    )
    public WalletActivity depositMoney(@Valid @RequestBody DepositMoneyDTO depositMoneyDTO) throws Exception  {
        return depositMoneyService.depositMoney(depositMoneyDTO);
    }

    @PostMapping("/transfer")
    @Operation(
            summary = "Transfer Money",
            description = "Transfer money between two walletAccounts specific their userId and walletAccountId, with description and quantity. Check users exists, users have valid walletAccount, walletAccounts are not the same, and sender have enough money.",
            tags = { "WalletActivity" }
    )
    public List<WalletActivity> transfer(@Valid @RequestBody TransferDTO transferDTO) throws Exception  {
        return transferService.transfer(transferDTO);
    }


    @GetMapping("/balanceWalletAccount/{idUser}/{idWalletAccount}/")
    @Operation(
            summary = "View WalletAccount Activity",
            description = "Get the activity of walletAccount with userId and walletAccountId. Check if user exists and if walletAccount is valid for this user.",
            tags = { "WalletActivity" }
    )
    public BalanceWalletAccountViewModel balanceWalletAccount(@PathVariable("idUser") BigInteger idUser, @PathVariable("idWalletAccount") BigInteger idWalletAccount) throws Exception {
        return balanceWalletAccountService.balanceWalletAccount(idUser, idWalletAccount);
    }
}
