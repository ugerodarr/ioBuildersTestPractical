package com.ugerodarr.iobuilders;

import com.ugerodarr.iobuilders.application.usecases.walletActivity.TransferUseCase;
import com.ugerodarr.iobuilders.domain.model.activityType.ActivityType;
import com.ugerodarr.iobuilders.domain.model.activityType.services.ActivityTypeDomainService;
import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.user.services.UserDomainService;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.domain.model.walletAccount.services.WalletAccountDomainService;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import com.ugerodarr.iobuilders.domain.model.walletActivity.repository.WalletActivityRepository;
import com.ugerodarr.iobuilders.domain.model.walletActivity.services.WalletActivityDomainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransferUseCaseTest {

    @Mock
    WalletActivityRepository walletActivityRepository;

    @Mock
    UserDomainService userDomainService;

    @Mock
    WalletAccountDomainService walletAccountDomainService;

    @Mock
    ActivityTypeDomainService activityTypeDomainService;

    @Mock
    WalletActivityDomainService walletActivityDomainService;

    @InjectMocks
    TransferUseCase transferUseCase;

    @Test
    public void testTransfer() throws Exception {

        User userSender = new User("testNameSender", "testLastNameSender", "testPasswordSender", "testEmailSender@test.com", new Date());
        WalletAccount walletAccountSender = new WalletAccount("testNameWalletAccountSender", userSender, new Date());
        ActivityType activityTypeWithdraw = new ActivityType("Withdraw");

        User userReceiver = new User("testNameReceiver", "testLastNameReceiver", "testPasswordReceiver", "testEmailReceiver@test.com", new Date());
        WalletAccount walletAccountReceiver = new WalletAccount("testNameWalletAccountReceiver", userReceiver, new Date());
        ActivityType activityTypeDeposit = new ActivityType("Deposit");

        WalletActivity walletActivity = new WalletActivity(walletAccountSender, activityTypeDeposit, "testDescription", 0F, new Date());

        when(userDomainService.checkUserExist(BigInteger.valueOf(1))).thenReturn(userSender);
        when(userDomainService.checkUserExist(BigInteger.valueOf(2))).thenReturn(userReceiver);
        when(walletAccountDomainService.checkUserInWallet(BigInteger.valueOf(1), userSender)).thenReturn(walletAccountSender);
        when(walletAccountDomainService.checkUserInWallet(BigInteger.valueOf(2), userReceiver)).thenReturn(walletAccountReceiver);
        when(walletActivityDomainService.totalWalletAccount(BigInteger.valueOf(1))).thenReturn(10F);
        when(activityTypeDomainService.checkActivityTypeExist(BigInteger.valueOf(1))).thenReturn(activityTypeDeposit);
        when(activityTypeDomainService.checkActivityTypeExist(BigInteger.valueOf(2))).thenReturn(activityTypeWithdraw);

        when(walletActivityRepository.saveAndFlush(any(WalletActivity.class))).thenReturn(walletActivity);
        List<WalletActivity> walletActivityListReturn = transferUseCase.handle( BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(2), "testDescription", 5F);

        assertNotNull(walletActivityListReturn);
    }




}
