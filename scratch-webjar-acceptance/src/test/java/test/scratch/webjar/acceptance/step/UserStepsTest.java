package test.scratch.webjar.acceptance.step;

import org.junit.Test;
import scratch.webjar.acceptance.domain.ExistingUserFactory;
import scratch.webjar.acceptance.domain.User;
import scratch.webjar.acceptance.step.UserHolder;
import scratch.webjar.acceptance.step.UserSteps;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class UserStepsTest {

    @Test
    public void Can_create_an_existing_user() {

        final ExistingUserFactory existingUserFactory = mock(ExistingUserFactory.class);
        final UserHolder userHolder = mock(UserHolder.class);

        final User user = mock(User.class);

        // Given
        given(existingUserFactory.createExitingUser()).willReturn(user);

        // When
        new UserSteps(existingUserFactory, userHolder).iAmAnExistingUser();

        // Then
        then(userHolder).should().set(user);
    }
}