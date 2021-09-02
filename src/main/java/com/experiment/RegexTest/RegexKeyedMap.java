package com.experiment.RegexTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexKeyedMap extends HashMap {

    public Object put(Object key, Object value) {
        if (key instanceof String)
            return super.put(key, value);
        else
            throw new RuntimeException("RegexpKeyedMap - only accepts Strings as keys.");
    }

    //TODO: TREE FORM
    public List<Object> getMatchedObjectsFromRegex(String regexString) {
        List<Object> valuesList = new ArrayList<>();
        System.out.println("regexString=" + regexString);
        Pattern pattern = Pattern.compile(regexString, Pattern.CASE_INSENSITIVE);
        Set<Object> objectSet = super.keySet();
        Matcher matcher = null;

        //TODO: LAMBDA EXPRESSIONS CAN BE USED
        for (Object keyFromMap : objectSet) {
            matcher = pattern.matcher(keyFromMap.toString());
            if (!matcher.find()) {
                continue;
            }
            Object o = super.get(keyFromMap);
            valuesList.add(o);
            System.out.println("<<<<matched key>>>>=" + keyFromMap);
            System.out.println("<<<<value>>>>=" + o);
        }
        return valuesList;
    }

}
