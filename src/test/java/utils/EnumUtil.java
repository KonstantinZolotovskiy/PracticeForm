package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;

public class EnumUtil {
    static Faker faker = new Faker();
    private static final SecureRandom random = new SecureRandom();

    public static <T extends Enum<?>> T getRandomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
