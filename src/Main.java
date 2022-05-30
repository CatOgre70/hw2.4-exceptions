public class Main {

    public static void main(String[] args) {

        // System.out.println(loginCheck("Vasily.Demin@gmail.com", "e3PC!@Xy", "e3PC!@Xy")); // WrongLoginException
        // System.out.println(loginCheck("Vasily.Demin", "e3PC!@Xy", "e3PC!@Xy_")); // WrongPasswordException
        System.out.println(loginCheck("Vasily.Demin", "e3PC!@Xy12ebo4v07k12", "e3PC!@Xy12ebo4v07k12"));
        System.out.println(loginCheck("VasilyDemin", "e3PC!@Xy12ebo4v07k1", "e3PC!@Xy12ebo4v07k1"));
        System.out.println(loginCheck("vasily", "e3PC!@Xy", "e3PC!@Xy"));
        System.out.println(loginCheck("vasily", "e3PCXy1_", "e3PCXy1_"));
        System.out.println(loginCheck("vasily.d", "e3PCXy1_", "e3PCXy1_"));

    }

    public static boolean loginCheck(String login, String password, String confirmPassword){

        boolean isPasswordCorrect;
        boolean isLoginCorrect;

        try {
            isPasswordCorrect = passwordCheck(password, confirmPassword);
            isLoginCorrect = nameCheck(login);
        } catch(WrongPasswordException | WrongLoginException e) {
            throw new RuntimeException(e);
        }

        return isPasswordCorrect & isLoginCorrect;
    }

    public static boolean nameCheck(String login){

        if(login.length() > 20) {
            throw new WrongLoginException("Имя пользователя не должно превышать 20 символов!");
        }

        return isStringContainsRightSymbols(login);

    }

    public static boolean passwordCheck(String password, String confirmPassword){

        if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("Поля пароль и подтверждение пароля должны совпадать!");
        }
        if(password.length() >= 20)
            return false;
        return isStringContainsRightSymbols(password);

    }

    public static boolean isStringContainsRightSymbols(String s){

        boolean correct = true;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9' || ch == '_')) {
                correct = false;
                break;
            }
        }
        return correct;
    }

}