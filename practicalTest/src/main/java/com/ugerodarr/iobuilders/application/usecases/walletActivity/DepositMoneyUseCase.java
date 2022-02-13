package com.ugerodarr.iobuilders.application.usecases.walletActivity;

import com.ugerodarr.iobuilders.domain.model.activityType.ActivityType;
import com.ugerodarr.iobuilders.domain.model.activityType.services.ActivityTypeDomainService;
import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.user.services.UserDomainService;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.domain.model.walletAccount.services.WalletAccountDomainService;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import com.ugerodarr.iobuilders.domain.model.walletActivity.repository.WalletActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Date;

@Component
public class DepositMoneyUseCase {

    @Autowired
    WalletActivityRepository walletActivityRepository;

    @Autowired
    UserDomainService userDomainService;

    @Autowired
    WalletAccountDomainService walletAccountDomainService;

    @Autowired
    ActivityTypeDomainService activityTypeDomainService;

    public DepositMoneyUseCase(WalletActivityRepository walletActivityRepository, UserDomainService userDomainService, WalletAccountDomainService walletAccountDomainService, ActivityTypeDomainService activityTypeDomainService) {
        this.walletActivityRepository = walletActivityRepository;
        this.userDomainService = userDomainService;
        this.walletAccountDomainService = walletAccountDomainService;
        this.activityTypeDomainService = activityTypeDomainService;
    }

    public WalletActivity handle(BigInteger idUser, BigInteger idWalletAccount, String description, Float quantity) throws Exception {
        //Comprobamos que el usuario existe
        User user = userDomainService.checkUserExist(idUser);
        //Comprobamos que el walletAccount es valido para ese usuario
        WalletAccount walletAccount = walletAccountDomainService.checkUserInWallet(idWalletAccount, user);
        //Forzamos el activityType a 1 porque siempre es un deposito
        ActivityType activityType = activityTypeDomainService.checkActivityTypeExist(BigInteger.valueOf(1));
        WalletActivity walletActivity = new WalletActivity(walletAccount, activityType, description, quantity, new Date());
        //Guardamos el usuario
        return walletActivityRepository.saveAndFlush(walletActivity);
    }
}
