package ru.naboka.companyinfo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Класс для установки значений по умолчанию из конфигурации для pageSize
 * */
@Component
public class PageSizeValueProvider {
    @Value("${company-info-config.get-page-config.default-size}")
    private Integer defaultPageSize;
    @Value("${company-info-config.get-page-config.max-size}")
    private Integer maxPageSize;

    /**
     * Метод вернет значения указанные в конфигурации приложения если:
     * <p>Переданное значение pageSize будет больше максимального значения в конфигурации
     * <p>Переданное значение pageSize будет не задано или равно 0
     * <p>Иначе будет возвращено переданное значение pageSize без изменений
     * @param pageSize значение которое проверяем
     * @return вернет pageSize с устанвленными значениями из конфигурации если
     * это было необходимо
     */
    public Integer getPageSize(Integer pageSize) {
        if(pageSize == null || pageSize == 0) {
            pageSize = defaultPageSize;
        }

        if(pageSize > maxPageSize) {
            pageSize = maxPageSize;
        }

        return pageSize;
    }

}