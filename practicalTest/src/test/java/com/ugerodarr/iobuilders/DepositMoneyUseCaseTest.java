package com.ugerodarr.iobuilders;

import com.ugerodarr.iobuilders.application.usecases.walletActivity.DepositMoneyUseCase;
import com.ugerodarr.iobuilders.domain.model.activityType.ActivityType;
import com.ugerodarr.iobuilders.domain.model.activityType.services.ActivityTypeDomainService;
import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.user.services.UserDomainService;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.domain.model.walletAccount.services.WalletAccountDomainService;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import com.ugerodarr.iobuilders.domain.model.walletActivity.repository.WalletActivityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DepositMoneyUseCaseTest {

    @Mock
    WalletActivityRepository walletActivityRepository;

    @Mock
    private UserDomainService userDomainService;

    @Mock
    WalletAccountDomainService walletAccountDomainService;

    @Mock
    ActivityTypeDomainService activityTypeDomainService;

    @InjectMocks
    DepositMoneyUseCase depositMoneyUseCase;

    @Test
    public void testDepositMoney() throws Exception {

        User user = new User("testName", "testLastName", "testPassword", "testEmail@test.com", new Date());
        WalletAccount walletAccount = new WalletAccount("testNameWalletAccount", user, new Date());
        ActivityType activityType = new ActivityType("Deposit");
        WalletActivity walletActivity = new WalletActivity(walletAccount, activityType, "testDescription", 0F, new Date());

        when(userDomainService.checkUserExist(BigInteger.valueOf(1))).thenReturn(user);
        when(walletAccountDomainService.checkUserInWallet(BigInteger.valueOf(1), user)).thenReturn(walletAccount);
        when(activityTypeDomainService.checkActivityTypeExist(BigInteger.valueOf(1))).thenReturn(activityType);
        when(walletActivityRepository.saveAndFlush(any(WalletActivity.class))).thenReturn(walletActivity);

        WalletActivity walletActivityReturn = depositMoneyUseCase.handle(BigInteger.valueOf(1), BigInteger.valueOf(1), "testDescription", 0F);

        assertNotNull(walletActivityReturn);
    }

}
