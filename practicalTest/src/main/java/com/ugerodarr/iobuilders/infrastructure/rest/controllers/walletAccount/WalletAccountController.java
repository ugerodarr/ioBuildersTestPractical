package com.ugerodarr.iobuilders.infrastructure.rest.controllers.walletAccount;

import com.ugerodarr.iobuilders.application.services.walletAccount.CreateWalletAccountService;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.infrastructure.dtos.walletAccount.WalletAccountDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/walletAccount")
public class WalletAccountController {

    @Autowired
    CreateWalletAccountService createWalletAccountService;

    @PostMapping("/createWalletAccount")
    @Operation(
            summary = "Create WalletAccount",
            description = "Create WalletAccount for the specific userId with a name. Check if user exists",
            tags = { "WalletAccount" }
    )
    public WalletAccount createWalletAccount(@Valid @RequestBody WalletAccountDTO walletAccountDTO) throws Exception  {
        return createWalletAccountService.createWalletAccount(walletAccountDTO);
    }
}
