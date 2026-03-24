public class StudentValidator {

    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) return false;
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) return false;
        }
        return true;
    }

    public static boolean isValidAge(int age) {
        return age >= 0;
    }
}
