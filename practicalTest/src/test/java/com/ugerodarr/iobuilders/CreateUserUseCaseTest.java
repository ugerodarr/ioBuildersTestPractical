package com.ugerodarr.iobuilders;

import com.ugerodarr.iobuilders.application.usecases.user.CreateUserUseCase;
import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.domain.model.user.repository.UserRepository;
import com.ugerodarr.iobuilders.domain.model.user.services.UserDomainService;
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
public class CreateUserUseCaseTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserDomainService userDomainService;

    @InjectMocks
    CreateUserUseCase createUserUseCase;

    @Test
    public void testCreateUser() throws Exception {

       User user = new User("testName", "testLastName", "testPassword", "testEmail@test.com", new Date());
       
       when(userRepository.saveAndFlush(any(User.class))).thenReturn(user);

       User userReturn = createUserUseCase.handle("testName", "testLastName", "testPassword", "testEmail@test.com");

       assertNotNull(userReturn);
    }

}
