package pro.learnup.api;

import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pro.learnup.api.dto.UserDto;
import pro.learnup.api.endpoints.ApiAuthRegisterEndpoint;
import pro.learnup.api.endpoints.ApiUserEndpoint;
import pro.learnup.api.ext.ApiTestExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("/api/user")
@ExtendWith({ApiTestExtension.class, AllureJunit5.class})
public class ApiUserTest {
    UserDto userDto;

    @BeforeEach
    void setUp() {
        userDto = new ApiAuthRegisterEndpoint().registerNewUser(ApiAuthRegisterTest.successfulCreateUserRequests().findFirst().orElseThrow());
    }

    @Test
    @DisplayName("/api/user: 200: получение информации о юзере авторизованным пользователем")
    void successfulGetUserTest() {
        assertThat(new ApiUserEndpoint().getUser(userDto))
                .usingRecursiveComparison()
                .isEqualTo(userDto);
    }
}
