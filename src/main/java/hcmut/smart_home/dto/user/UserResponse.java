package hcmut.smart_home.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "UserResponse", accessMode = Schema.AccessMode.READ_ONLY)
public class UserResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String avatar;

    public UserResponse() {}

    public UserResponse(String firstName, String lastName, String email, String phone, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
