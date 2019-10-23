package common.utils;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 密码校验
 */
public class PwdUtils {
    private static final int MIN = 8;
    private static final int MAX = 32;

    private static final int ZORE = 0;
    private static final int LENGTH_MIN = 1 << 0;
    private static final int LENGTH_MAX = 1 << 1;
    private static final int ALPHA = 1 << 2;
    private static final int NUMBER = 1 << 3;

    private static final int ALL = LENGTH_MIN | LENGTH_MAX | ALPHA | NUMBER;


    public static String checkPwd(String pwd) {
        int status = ZORE;
        if (StringUtils.isEmpty(pwd)) {
            return "";
        }
        if (pwd.length() >= MIN) {
            status = status | LENGTH_MIN;
        }
        if (pwd.length() <= MAX) {
            status = status | LENGTH_MAX;
        }

        for (char ch : pwd.toCharArray()) {
            if (CharUtils.isAsciiNumeric(ch)) {
                status = status | NUMBER;
                continue;
            }
            if (CharUtils.isAsciiAlpha(ch)) {
                status = status | ALPHA;
                continue;
            }

        }

        if (status == ALL) {
            return "";
        }
        return getMessage(status);
    }


    private static String getMessage(int code) {
        List<String> errors = new ArrayList<>();
        int miss = ALL ^ code;
        if ((miss & LENGTH_MIN) != 0) {
            errors.add("密码长度应大于：" + MIN);
        }

        if ((miss & LENGTH_MAX) != 0) {
            errors.add("密码长度应小于：" + MAX);
        }

        if ((miss & ALPHA) != 0) {
            errors.add("密码应包含字母");
        }

        if ((miss & NUMBER) != 0) {
            errors.add("密码应包含数字");
        }

        return errors.stream().collect(Collectors.joining("\n", "============\n", "\n============"));
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n请输入密码：");
            Scanner scanner = new Scanner(System.in);
            String pwd = scanner.nextLine();
            String message = checkPwd(pwd);
            if (StringUtils.isNotEmpty(message)) {
                System.out.println("密码格式不正确：\n\n" + message);
                continue;
            }
            System.out.println("密码输入正确：" + pwd);

        }
    }

}
