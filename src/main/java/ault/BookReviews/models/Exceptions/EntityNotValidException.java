package ault.BookReviews.models.Exceptions;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class EntityNotValidException extends RuntimeException {

    public EntityNotValidException(Class clazz, String badField) {
        super(EntityNotValidException.generateMessage(clazz.getSimpleName(), badField));
    }

    private static String generateMessage(String clazz, String badField) {
        return "Error in class " + clazz +
                " - Entity was not valid for the entityType given. Field found in Entity but not in EntityType schema: " + badField;
    }

    

}