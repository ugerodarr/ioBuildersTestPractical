package com.ugerodarr.iobuilders.application.usecases.walletActivity;

import com.ugerodarr.iobuilders.domain.model.activityType.ActivityType;
import com.ugerodarr.iobuilders.domain.model.activityType.services.ActivityTypeDomainService;
import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.user.services.UserDomainService;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.domain.model.walletAccount.services.WalletAccountDomainService;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import com.ugerodarr.iobuilders.domain.model.walletActivity.repository.WalletActivityRepository;
import com.ugerodarr.iobuilders.domain.model.walletActivity.services.WalletActivityDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TransferUseCase {

    @Autowired
    WalletActivityRepository walletActivityRepository;

    @Autowired
    UserDomainService userDomainService;

    @Autowired
    WalletAccountDomainService walletAccountDomainService;

    @Autowired
    ActivityTypeDomainService activityTypeDomainService;

    @Autowired
    WalletActivityDomainService walletActivityDomainService;

    public TransferUseCase(WalletActivityRepository walletActivityRepository, UserDomainService userDomainService, WalletAccountDomainService walletAccountDomainService, ActivityTypeDomainService activityTypeDomainService, WalletActivityDomainService walletActivityDomainService) {
        this.walletActivityRepository = walletActivityRepository;
        this.userDomainService = userDomainService;
        this.walletAccountDomainService = walletAccountDomainService;
        this.activityTypeDomainService = activityTypeDomainService;
        this.walletActivityDomainService = walletActivityDomainService;
    }

    public List<WalletActivity> handle(BigInteger idUserSender, BigInteger idWalletAccountSender, BigInteger idUserReceiver, BigInteger idWalletAccountReceiver, String description, Float quantity) throws Exception {

        String exceptionText = "";
        List<WalletActivity> listActivities = new ArrayList<>();

        try
        {
            //Verificamos que existe el usuario que envia
            exceptionText = "Sender user not exist";
            User userSender = userDomainService.checkUserExist(idUserSender);
            //Verificamos que existe el usuario que recibe
            exceptionText = "Receiver user not exist";
            User userReceiver = userDomainService.checkUserExist(idUserReceiver);
            //Comprobamos que el walletAccount es valido para el usuario que envia
            exceptionText = "WalletAccount is not valid for sender user";
            WalletAccount walletAccountSender = walletAccountDomainService.checkUserInWallet(idWalletAccountSender, userSender);
            //Comprobamos que el walletAccount es valido para el usuario que recibe
            exceptionText = "WalletAccount is not valid for receiver user";
            WalletAccount walletAccountReceiver = walletAccountDomainService.checkUserInWallet(idWalletAccountReceiver, userReceiver);
            // Cambiar condcion por parámetros de entrada
            if(!idWalletAccountSender.equals(idWalletAccountReceiver))
            {
                //Obtenemos el total del walletAccount que envia
                Float total = walletActivityDomainService.totalWalletAccount(idWalletAccountSender);
                if(total != null)
                {
                    //Comprobamos que la walletAccount de envío tiene saldo suficiente
                    if(total >= quantity)
                    {
                        //Forzamos el activityType a 2 porque siempre es una retirada al ser la cuenta que envia
                        ActivityType activityTypeSender = activityTypeDomainService.checkActivityTypeExist(BigInteger.valueOf(2));
                        //Creamos un walletActivity restando la cantidad del walletAccount que envia
                        WalletActivity walletActivitySender = new WalletActivity(walletAccountSender, activityTypeSender, description, -quantity, new Date());
                        //Forzamos el activityType a 1 porque siempre es un deposito al ser la cuenta que recibe
                        ActivityType activityTypeReceiver = activityTypeDomainService.checkActivityTypeExist(BigInteger.valueOf(1));
                        //Creamos otro walletActivity sumando la cantidad al walletAccount que recibe
                        WalletActivity walletActivityReceiver = new WalletActivity(walletAccountReceiver, activityTypeReceiver, description, quantity, new Date());
                        walletActivityRepository.saveAndFlush(walletActivitySender);
                        walletActivityRepository.saveAndFlush(walletActivityReceiver);
                        listActivities.add(walletActivitySender);
                        listActivities.add(walletActivityReceiver);
                    }
                    else
                    {
                        exceptionText = "WalletAccount do not have enought balance";
                        throw new Exception();
                    }
                }
                else
                {
                    exceptionText = "WalletAccount do not have any activity";
                    throw new Exception();
                }
            }
            else
            {
                exceptionText = "WalletAccount cannot be the same";
                throw new Exception();
            }

        }
        catch(Exception e)
        {
            throw new Exception(exceptionText);
        }

        return listActivities;
    }


}
