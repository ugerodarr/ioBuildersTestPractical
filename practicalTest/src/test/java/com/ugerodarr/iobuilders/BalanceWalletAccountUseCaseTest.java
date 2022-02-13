package com.ugerodarr.iobuilders;

import com.ugerodarr.iobuilders.application.usecases.walletActivity.BalanceWalletAccountUseCase;
import com.ugerodarr.iobuilders.domain.model.activityType.ActivityType;
import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.user.services.UserDomainService;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.domain.model.walletAccount.services.WalletAccountDomainService;
import com.ugerodarr.iobuilders.domain.model.walletActivity.WalletActivity;
import com.ugerodarr.iobuilders.domain.model.walletActivity.repository.WalletActivityRepository;
import com.ugerodarr.iobuilders.domain.model.walletActivity.services.WalletActivityDomainService;
import com.ugerodarr.iobuilders.infrastructure.viewModels.BalanceWalletAccountViewModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BalanceWalletAccountUseCaseTest {

    @Mock
    WalletActivityRepository walletActivityRepository;

    @Mock
    UserDomainService userDomainService;

    @Mock
    WalletAccountDomainService walletAccountDomainService;

    @Mock
    WalletActivityDomainService walletActivityDomainService;

    @InjectMocks
    BalanceWalletAccountUseCase balanceWalletAccountUseCase;

    @Test
    public void testTransfer() throws Exception {

        User user = new User("testName", "testLastName", "testPassword", "testEmail@test.com", new Date());
        WalletAccount walletAccount = new WalletAccount("testNameWalletAccount", user, new Date());
        ActivityType activityType = new ActivityType("Deposit");

        WalletActivity walletActivityOne = new WalletActivity(walletAccount, activityType, "testDescriptionOne", 5F, new Date());
        WalletActivity walletActivityTwo = new WalletActivity(walletAccount, activityType, "testDescriptionTwo", 5F, new Date());
        List<WalletActivity> walletActivityList = new ArrayList<>();
        walletActivityList.add(walletActivityOne);
        walletActivityList.add(walletActivityTwo);

        when(walletAccountDomainService.checkUserInWallet(BigInteger.valueOf(1), user)).thenReturn(walletAccount);
        when(userDomainService.checkUserExist(BigInteger.valueOf(1))).thenReturn(user);
        when(walletActivityDomainService.totalWalletAccount(BigInteger.valueOf(1))).thenReturn(10F);

        when(walletActivityRepository.findByWalletAccount(walletAccount)).thenReturn(walletActivityList);

        BalanceWalletAccountViewModel balanceWalletAccountViewModel = balanceWalletAccountUseCase.handle(BigInteger.valueOf(1), BigInteger.valueOf(1));

        assertNotNull(balanceWalletAccountViewModel);

    }
}
