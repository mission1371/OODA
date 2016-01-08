package domain.utility;

/**
 * @author umut.taherzadeh
 *
 */
public class DataUtility {

    public static boolean isNull(Object obj, boolean throwException) throws Exception {

        boolean returnCase = false;
        if (obj == null) {
            if (throwException) {
                throw new IllegalArgumentException(" argument is required; it must not be null");
            }
            returnCase = true;

        }

        return returnCase;

    }

    public static boolean isNull(Object obj) throws Exception {
        return isNull(obj, true);
    }

    public static boolean isEmpty(String str, boolean throwException) throws Exception {

        boolean returnCase = false;
        if ("".equals(str)) {
            if (throwException) {
                throw new IllegalArgumentException(" argument is required; it must not be empty");
            }
            returnCase = true;

        }

        return returnCase;

    }

    public static boolean isEmpty(String str) throws Exception {
        return isEmpty(str, true);
    }

}
