package ru.naboka.companyinfo.util;


/**
 * Класс для проверки переданных значений на null
 * */
public class IsNullCheckerProvider {
    /**
     * Метод получает список объектов и проверяет каждый на null.
     * <p>Если хотя бы один равен то выбрасывается исключение IllegalArgumentException
     * @param objects Объекты для проверки
     * @throws IllegalArgumentException Ошибка
     */
    public static void isNull(Object... objects) throws IllegalArgumentException {
        for (Object obj : objects) {
            if (obj == null) {
                throw new IllegalArgumentException("Проверяемый объект равен null");
            }
        }
    }
}