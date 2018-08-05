package common.utils;

import java.util.ArrayList;

public class ConstansInfo {
    static ArrayList<ParseFile> parses = new ArrayList<>();

    static {
        parses.add(new ParseProties());
    }

    public static void addParse(ParseFile parseFile) {
        parses.add(parseFile);
    }
    public static String getRedisHost() {
        return getValue("redis.host");
    }

    public static String getRedisPort() {
        return getValue("redis.port");
    }

    public static String getRedisPasswd() {
        return getValue("redis.passwd");
    }


    public static String getValue(String key) {
        String value = null;
        for (ParseFile parse : parses) {
            value = parse.getValue(key);
            if (value != null) {
                return value;
            }
        }

        return null;
    }
}
