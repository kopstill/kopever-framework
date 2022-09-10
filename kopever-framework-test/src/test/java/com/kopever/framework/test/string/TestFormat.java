package com.kopever.framework.test.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestFormat {

    @Test
    public void formatString() {
//        String format = "My name is {{ name }} and I am forever {{ age }}.";
//        Map<String, Object> args = new HashMap<>() {{
//            put("name", "Jackson");
//            put("age", 23);
//        }};
//        String format = "Say hello to {{ name }}. He is {{ age }}.";
//        Map<String, Object> args = new HashMap<>() {{
//            put("name", "Bill");
//            put("age", 21);
//            put("male", true);
//        }};
//        String format = "Tommy is a good friend of {{ name}}. He lives in {{city }}.";
//        Map<String, Object> args = new HashMap<>() {{
//            put("name", "Bill");
//            put("city", "Boston");
//        }};
//        Assert.assertEquals("Tommy is a good friend of Bill. He lives in Boston.", formatString(format, args));
//        String format = "{{{{aaa}}{{{{bbb}}";
//        String format = "{{aaa}}{{bbb}}";
//        String format = "{{}{{{aaa}}{}{{{bbb}}}{{aaa}}{{}{{aaa}}}}{{}{{bbb}}";
        String format = " {{{           aaa    }} {{   bbb     } }. ";
        Map<String, Object> args = new HashMap<>() {{
            put("aaa", "AA");
            put("bbb", "BBBBBB");
        }};
        System.out.println(formatString(format, args));
    }

    public String formatString(String format, Map<String, Object> args) {
        if (format == null || format.trim().length() == 0 || args == null || args.isEmpty()) {
            throw new RuntimeException("Required parameters missing.");
        }

        int left = -1, right = -1;
        for (int i = 0; i < format.length() - 1; i++) {
            if ('{' == format.charAt(i) && '{' == format.charAt(i + 1)) {
                left = i;
            }
            if ('}' == format.charAt(i) && '}' == format.charAt(i + 1)) {
                right = i;
            }

            if (left != -1 && right != -1 && left < right) {
                String key = format.substring(left + 2, right).trim();
                if (key.length() == 0) {
                    throw new RuntimeException("Match key must not be empty.");
                }
                Object value = args.get(key);
                if (Objects.isNull(value)) {
                    throw new RuntimeException("Matched replacement missing.");
                }

                format = format.substring(0, left).
                        concat(value.toString()).
                        concat(format.substring(right + 2));

                i = left + value.toString().length() - 1;
                left = -1;
                right = -1;
            }
        }

        return format;
    }

}
