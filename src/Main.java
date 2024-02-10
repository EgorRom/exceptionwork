import exception.WrongLongException;
import exception.WrongPasswordException;

public class Main {

    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9_]+$";

    public static void main(String[] args)  {
        check("123asD","123_123", "123_123");
        check("123asD!","123_123", "123_123");
        check("123asD","123_123", "123_12");
        check("123asD","123_123 ddы", "123_12");
        check("123asDasssssssssssssssssssssssssssasssssssssss","123_123", "123_123");
        check("123asD","123_123aafrqwefgehgewrfwefwqefgwgwdwqegqgqg", "123_12");

    }

    private static void check(String login, String password, String confiPassword){
        try {
            checkLogin(login);
            checkPassord(password,confiPassword);
        } catch (WrongLongException e) {
//            throw new WrongLongException(e.getMessage());
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void checkLogin(String login) throws WrongLongException {
        if (!login.matches(VALIDATE_PATTERN)) {
            throw new WrongLongException("Login может содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }
        if (login.length() > 20) {
            throw new WrongLongException("Login может содержать в себе не более 20 символов");
        }
    }

    private static void checkPassord(String password, String confiPassword) throws WrongPasswordException {
        if (!password.matches(VALIDATE_PATTERN)) {
            throw new WrongPasswordException("пароль может содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("пароль может содержать в себе не более 20 символов");
        }
        if (!password.equals(confiPassword)) {
            throw new WrongPasswordException("пароли не совпадают");
        }

    }

}