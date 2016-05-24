package com.se.database.dao.model.users;


public class LoginUserVo extends UserVO {

    /**
     * Enum for setting the user's type
     */
    public enum UserType {

        STUDENT("student"),

        TEACHER("teacher"),

        TEACHER_CHIEF("teacher_chief"),

        ADMIN("admin");

        private String value;

        UserType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


    /**
     * The type of the user
     */
    private UserType userType = UserType.TEACHER;

    public LoginUserVo(){

    }

    public LoginUserVo(UserVO userVO, UserType userType) {
        super(userVO);
        this.userType = userType;
    }

    public LoginUserVo(String username, String password, UserType userType) {
        super(username, password);
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
