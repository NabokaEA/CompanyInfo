package ru.naboka.companyinfo.util;

import ru.naboka.companyinfo.exception.EntityToDtoConversionException;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ru.naboka.companyinfo.util.IsNullCheckerProvider.isNull;

/**
 * Класс-хелпер необходимый для конвертации списка сущностей в список транспорта сущности
 */
public class EntityToDtoConvertor {
    /**
     * Метод конвертирует список сущностей в список транспорта сущности
     * В классе транспорта должен быть объявлен конструктор принимающий тип сущности
     *
     * @param <T>         Тип входящей сущности
     * @param <R>         Тип входящей сущности транспорта
     * @param list        Список сущностей для конвертации
     * @param sourceClass Класс сущности которую конвертируем
     * @param targetClass Класс транспорта в который конвертируем
     * @return Список транспорта сущности
     */
    public static <T, R> List<R> getDtoList(List<T> list, Class<T> sourceClass, Class<R> targetClass) {
        isNull(list, sourceClass, targetClass);
        return list.stream()
                .map(wrap(item -> targetClass.getConstructor(sourceClass).newInstance(item)))
                .collect(Collectors.toList());
    }

    @FunctionalInterface
    private interface CheckedFunction<T, R> {
        R apply(T t) throws Exception;
    }

    private static <T, R> Function<T, R> wrap(CheckedFunction<T, R> checkedFunction) {
        return t -> {
            try {
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new EntityToDtoConversionException(e);
            }
        };
    }
}
