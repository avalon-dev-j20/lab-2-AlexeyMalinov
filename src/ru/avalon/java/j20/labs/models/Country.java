package ru.avalon.java.j20.labs.models;

import java.text.ParseException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Модель представления о стране.
 */
public class Country {
    /**
     * Код страны.
     */
    private final String code;
    /**
     * Название страны.
     */
    private final String name;

    /**
     * Основное конструктор класса.
     *
     * @param code код страны
     * @param name название страны
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Возвращает код страны.
     *
     * @return строковый код страны
     */
    public String getCode() {
        return code;
    }

    /**
     * Возвращает название страны.
     *
     * @return название страны
     */
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }

    /**
     * {@inheritDoc}
     *
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Country)) return false;
        Country otherCountry = (Country) other;
        return name.equals(otherCountry.name) && code.equals(otherCountry.code);
    }

    /**
     * Возвращает экземпляр страны созданный из переданного
     * текста в формате 'Код:Название'.
     *
     * @param text текст в формате 'Код:Название'
     * @return новый экземпляр типа {@Link Country}.
     * @throws ParseException в случае, если переданная строка
     *                        имеет неверный формат.
     */
    public static Country valueOf(String text) throws ParseException {
        Pattern pattern = Pattern.compile("([A-Z]{2}):([а-яА-Я\\s]*)");
        Matcher matcher = pattern.matcher(text);
        if (!matcher.find()) throw new ParseException("Text not valid", 0);
        return new Country(matcher.group(1), matcher.group(2));
    }
}
