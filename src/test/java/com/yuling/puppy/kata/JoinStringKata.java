package com.yuling.puppy.kata;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by yangyongli on 16/12/2016.
 * //Join items
 */
@RunWith(JUnit4.class)
public class JoinStringKata {

    @Test
    public void testJoinString() {
        List<String> items = Lists.newArrayList("a", "b", "c", "d", "e", "f", "g");
        String guavaJoiner = Joiner.on(",").skipNulls().join(items);
        assertEquals("a,b,c,d,e,f,g", guavaJoiner);
        assertEquals("a,b,c,d,e,f,g", StringUtils.join(items, ","));

        LinkedHashMap<Object, Object> map = Maps.newLinkedHashMap();
        map.put("a", 1); map.put("b", 2); map.put("c", 3);
        Joiner.MapJoiner mapJoiner = Joiner.on("#").withKeyValueSeparator("=");
        String mapJoined = mapJoiner.join(map);
        assertEquals("a=1#b=2#c=3", mapJoined);
        
    }

    @Test
    public void testSplitterString() {
        String joined = "a, b, c, d, e, f , g";
        String[] split1 = joined.split(",");
        System.out.println(Arrays.asList(split1));

        Iterable<String> split2 = Splitter.on(",").trimResults().split(joined);

        System.out.println(split2);

        String[] split3 = StringUtils.split(joined, ",");
        System.out.println(Arrays.asList(split3));

        String mapJoined = "a=1#b=2#c=3";
        Splitter.MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");
        Map<String, String> map = mapSplitter.split(mapJoined);
        System.out.println(map);
    }


    @Test
    public void testStrings(){
        System.out.println(Strings.padEnd("foo", 100, 'x'));

        boolean numeric = StringUtils.isNumeric("123232321232312312");
        boolean numeric1 = CharMatcher.DIGIT.matchesAllOf("232323232");

        System.out.println(numeric);
        System.out.println(numeric1);
    }


    public String pureJoin(List<String> stringList, String delimiter) {
        StringBuilder builder = new StringBuilder();
        for (String s : stringList) {
            if (s != null) {
                builder.append(s).append(delimiter);
            }
        }
        builder.setLength(builder.length() - delimiter.length());
        return builder.toString();
    }

    public String foreachJoin(List<String> stringList, String delimiter) {
        StringBuilder builder = new StringBuilder();
        stringList.forEach(s -> {
            builder.append(s).append(delimiter);
        });
        builder.setLength(builder.length() - delimiter.length());
        return builder.toString();
    }

}
