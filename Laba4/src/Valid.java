public class Valid {
    public boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public boolean isAnyNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        boolean hasDecimalPoint = false;
        boolean hasDigit = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (i == 0 && c == '-') {
                continue;
            }
            else if (c == '.' && !hasDecimalPoint) {
                hasDecimalPoint = true;
            }
            else if (c >= '0' && c <= '9') {
                hasDigit = true;
            }
            else {
                return false;
            }
        }

        return hasDigit;
    }

    public boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        int startIndex = 0;
        if (str.charAt(0) == '-') {
            if (str.length() == 1) return false;
            startIndex = 1;
        }

        for (int i = startIndex; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
