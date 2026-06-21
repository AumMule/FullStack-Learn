package com.learning.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    @Test
    void testUser() {
        // Create mock repository
        UserRepository repo = mock(UserRepository.class);

        // Stub getName() to return Aum instead of Real DB
        when(repo.getName()).thenReturn("Aum");

        // Inject mock into service
        UserService service = new UserService(repo);

        // Verify that the mocked response is retrieved
        assertEquals("Aum", service.getUserName());

        // Verify that the mock getName method was indeed called
        verify(repo).getName();
    }
}
