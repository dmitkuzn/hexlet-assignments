package exercise;

import exercise.demo.RandomNumber;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) {
        List<String> fields = new ArrayList<>();
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object fValue = field.get(obj);
                NotNull notNull = field.getAnnotation(NotNull.class);
                if (notNull != null && fValue == null) {
                    fields.add(field.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fields;
    }

   public static Map<String, List<String>> advancedValidate(Object obj) {
       HashMap<String, List<String>> fieldsMap = new HashMap<>();

       for (Field field: obj.getClass().getDeclaredFields()) {
           NotNull notNullValue = field.getAnnotation(NotNull.class);
           if (notNullValue != null) {
               try {
                   field.setAccessible(true);
                   Object fieldValue = field.get(obj);
                   if (fieldValue == null) {
                       List<String> lists = new ArrayList<>();
                       lists.add("can not be null");
                       fieldsMap.put(field.getName(), lists);
                   }
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               }
           }

           MinLength minLengthValue = field.getAnnotation(MinLength.class);
           if (minLengthValue != null) {
               try {
                   field.setAccessible(true);
                   String strValue = (String )field.get(obj);
                   if (strValue != null && strValue.length() < minLengthValue.minLength()) {
                       if (fieldsMap.containsKey(field.getName())) {
                           fieldsMap.get(field.getName()).add("length less than 4");
                       } else {
                           List<String> lists = new ArrayList<>();
                           lists.add("length less than 4");
                           fieldsMap.put(field.getName(), lists);
                       }
                   }
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               }
           }

       }

       return fieldsMap;
   }
}
// END
