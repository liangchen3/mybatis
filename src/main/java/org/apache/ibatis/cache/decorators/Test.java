package org.apache.ibatis.cache.decorators;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test {


    public static void main(String[] args) {
        LinkedHashMap<String, String> testMap = new LinkedHashMap<String, String>(12, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                System.out.println("eldest:" + eldest.getKey());
                System.out.println("eldest:" + eldest.getValue());
                if (size() > 12) {
                    return true;
                }
                return false;
            }
        };
        for (int i = 0; i < 30; i++) {
            testMap.put("i:" + i, "i:" + i);
        }

        testMap.get("i:" + 27);
        testMap.get("i:" + 19);
        testMap.get("i:" + 26);
        testMap.get("i:" + 25);

        testMap.forEach((key, value) -> {
            System.out.println("key:" + key);
        });


    }
}
