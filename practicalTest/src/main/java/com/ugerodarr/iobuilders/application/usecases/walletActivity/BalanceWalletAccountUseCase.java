package com.ugerodarr.iobuilders.application.usecases.walletActivity;

import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.user.services.UserDomainService;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.domain.model.walletAccount.services.WalletAccountDomainService;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import com.ugerodarr.iobuilders.domain.model.walletActivity.repository.WalletActivityRepository;
import com.ugerodarr.iobuilders.domain.model.walletActivity.services.WalletActivityDomainService;
import com.ugerodarr.iobuilders.infrastructure.viewModels.BalanceWalletAccountViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class BalanceWalletAccountUseCase {

    @Autowired
    WalletActivityRepository walletActivityRepository;

    @Autowired
    UserDomainService userDomainService;

    @Autowired
    WalletAccountDomainService walletAccountDomainService;

    @Autowired
    WalletActivityDomainService walletActivityDomainService;

    public BalanceWalletAccountUseCase(WalletActivityRepository walletActivityRepository, UserDomainService userDomainService, WalletAccountDomainService walletAccountDomainService, WalletActivityDomainService walletActivityDomainService) {
        this.walletActivityRepository = walletActivityRepository;
        this.userDomainService = userDomainService;
        this.walletAccountDomainService = walletAccountDomainService;
        this.walletActivityDomainService = walletActivityDomainService;
    }

    public BalanceWalletAccountViewModel handle(BigInteger idUser, BigInteger idWalletAccount) throws Exception {
        //Comprobamos que el usuario existe
        User user = userDomainService.checkUserExist(idUser);
        //Comprobamos que el walletAccount es valido para ese usuario
        WalletAccount walletAccount = walletAccountDomainService.checkUserInWallet(idWalletAccount, user);
        //Nos traemos la lista de actividades para ese walletAccount
        List<WalletActivity> listWalletActivity = walletActivityRepository.findByWalletAccount(walletAccount);
        BalanceWalletAccountViewModel balanceWalletAccountViewModel = new BalanceWalletAccountViewModel();
        if(!listWalletActivity.isEmpty())
        {
            balanceWalletAccountViewModel.setListWalletActivity(listWalletActivity);
            //Obtenemos el total del walletAccount
            Float total = walletActivityDomainService.totalWalletAccount(idWalletAccount);
            balanceWalletAccountViewModel.setTotal(total);
        }
        else
        {
            throw new Exception("WalletAccount do not have any activity");
        }

        return balanceWalletAccountViewModel;
    }
}
