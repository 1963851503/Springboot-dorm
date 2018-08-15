package com.jsjx.dorm.baseutils;

/**
 * @program: dorm
 * @description:
 * @author: 高峰
 * @create: 2018-08-12 18:02
 **/
public class CamelCaseUtil {
    private static final char SEPARATOR = '_';

    public CamelCaseUtil() {
    }

    public static String toUnderscoreName(String s) {
        if (s == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            boolean upperCase = false;

            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                boolean nextUpperCase = true;
                if (i < s.length() - 1) {
                    nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
                }

                if (i >= 0 && Character.isUpperCase(c)) {
                    if ((!upperCase || !nextUpperCase) && i > 0) {
                        sb.append('_');
                    }

                    upperCase = true;
                } else {
                    upperCase = false;
                }

                sb.append(Character.toLowerCase(c));
            }

            return sb.toString();
        }
    }

    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        } else {
            s = s.toLowerCase();
            StringBuilder sb = new StringBuilder(s.length());
            boolean upperCase = false;

            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '_') {
                    upperCase = true;
                } else if (upperCase) {
                    sb.append(Character.toUpperCase(c));
                    upperCase = false;
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }
    }

    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        } else {
            s = toCamelCase(s);
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        }
    }

    public static void main(String[] args) {
        System.out.println(toUnderscoreName("ISOCertifiedStaff"));
        System.out.println(toUnderscoreName("CertifiedStaff"));
        System.out.println(toUnderscoreName("UserID"));
        System.out.println(toCamelCase("iso_certified_staff"));
        System.out.println(toCamelCase("certified_staff"));
        System.out.println(toCamelCase("user_id"));
    }
}
