package edu.kpi.java.contentheap.utils;

import java.util.function.Function;

public class TransformationUtils {
    public static <T, R> R transformNullable(Function<T,R> function, T value){
        if(value == null) return null;
        return function.apply(value);
    }
}
