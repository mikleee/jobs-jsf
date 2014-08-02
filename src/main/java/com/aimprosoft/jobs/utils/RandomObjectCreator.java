package com.aimprosoft.jobs.utils;

import com.aimprosoft.jobs.model.PersistEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Mikhail Tkachenko
 */
public class RandomObjectCreator {


    public static <T> T createRandomObject(T t, Integer id) {

        for (Field field : t.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(Column.class)) {

                String setterName = "set" + Character.toUpperCase(field.getName().charAt(0)) + field.getName().substring(1);
                Class type = field.getType();

                Method setter = null;

                try {
                    setter = t.getClass().getMethod(setterName, type);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                setValue(field, t, setter, id);
            }
        }
        return t;
    }


//  ========================================= PRIVATE =========================================


    private static void setValue(Field field, Object o, Method setter, Integer id) {

        Object instance = null;

        try {
            instance = field.getType().newInstance();
        } catch (Exception e) {
            System.out.print("cant create instance for field type: " + field.getType() + " for field: " + field.getName() + ". Try plan B: ");
            try {
                instance = field.getType().getConstructor(int.class).newInstance(randomNumber());
                System.out.println(" SUCCESS");
            } catch (Exception e1) {
                try {
                    System.out.print(" FAIL. Try plan C: ");
                    instance = field.getType().getConstructor(long.class).newInstance(randomNumber());
                    System.out.println(" SUCCESS");
                } catch (Exception e2) {
                    System.out.println(" FAIL (value is set as null)");
                }
            }
        }

        try {

            if (field.isAnnotationPresent(Id.class)) {
                setter.invoke(o, id);
                return;
            }

            if (instance instanceof Number) {
                setter.invoke(o, instance);
            } else if (instance instanceof String) {
                String value;
                if (field.getName().contains("mail")) {
                    value = randomString(5) + '@' + randomString(4) + '.' + randomString(3);
                } else {
                    value = randomString(1).toUpperCase() + randomString(8);
                }
                setter.invoke(o, value);
            } else if (instance instanceof Date) {
                long time = Math.round(Math.random() * (new Date().getTime()));
                setter.invoke(o, new Date(time));
            } else if (instance instanceof PersistEntity) {
                setter.invoke(o, createRandomObject(instance, id));
            } else if (field.getType() == boolean.class) {
                setter.invoke(o, true);
            }
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            System.out.println("error with field:" + field.getName());
        }

    }


    public static String randomString(int c) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < c; j++) {
            sb.append((char) Math.round(97 + Math.random() * 25));
        }
        return sb.toString();
    }


    public static int randomNumber() {
        return (int) Math.round(Math.random() * 100);
    }

    public static int randomNumber(int max) {
        return (int) Math.round(Math.random() * max);
    }


}
