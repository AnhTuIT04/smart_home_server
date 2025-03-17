package hcmut.smart_home.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "AuthResponse", accessMode = Schema.AccessMode.READ_ONLY)
public class AuthResponse extends UserResponse {
    private final TokenResponse token;

    public AuthResponse(CreateUserRequest user, String accessToken, String refreshToken) {
        super(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getAvatar());
        this.token = new TokenResponse(accessToken, refreshToken);
    }

    public AuthResponse(LoginUserRequest user, String firstName, String lastName, String phone, String avatar, String accessToken, String refreshToken) {
        super(firstName, lastName, user.getEmail(), phone, avatar);
        this.token = new TokenResponse(accessToken, refreshToken);
    }

    public String getAccessToken() {
        return token.getAccessToken();
    }

    public String getRefreshToken() {
        return token.getRefreshToken();
    }

    public void setAccessToken(String accessToken) {
        token.setAccessToken(accessToken);
    }

    public void setRefreshToken(String refreshToken) {
        token.setRefreshToken(refreshToken);
    }
}
