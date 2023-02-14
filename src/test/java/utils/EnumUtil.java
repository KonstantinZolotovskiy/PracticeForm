package utils;

import com.github.javafaker.Faker;

import java.util.EnumSet;

public class EnumUtil {
    static Faker faker = new Faker();

    public static <T extends Enum<T>> T getRandomEnum(final Class<T> enumClass) {
        EnumSet<T> allEnums = EnumSet.allOf(enumClass);
        return allEnums.stream().toList().get(faker.random().nextInt(0, allEnums.size() - 1));
    }
}
