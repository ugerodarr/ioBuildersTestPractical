package com.ugerodarr.iobuilders;

import com.ugerodarr.iobuilders.application.usecases.walletAccount.CreateWalletAccountUseCase;
import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.user.services.UserDomainService;
import com.ugerodarr.iobuilders.domain.model.walletAccount.WalletAccount;
import com.ugerodarr.iobuilders.domain.model.walletAccount.repository.WalletAccountRepository;
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
public class CreateWalletAccountUseCaseTest {

    @Mock
    WalletAccountRepository walletAccountRepository;

    @Mock
    UserDomainService userDomainService;

    @InjectMocks
    CreateWalletAccountUseCase createWalletAccountUseCase;

    @Test
    public void testCreateWalletAccount() throws Exception {

        User user = new User("testName", "testLastName", "testPassword", "testEmail@test.com", new Date());
        WalletAccount walletAccount = new WalletAccount("testNameWalletAccount", null, new Date());

        when(userDomainService.checkUserExist(BigInteger.valueOf(1))).thenReturn(user);
        when(walletAccountRepository.saveAndFlush(any(WalletAccount.class))).thenReturn(walletAccount);

        WalletAccount walletAccountReturn = createWalletAccountUseCase.handle("testNameWalletAccount", BigInteger.valueOf(1));

        assertNotNull(walletAccountReturn);

    }
}
