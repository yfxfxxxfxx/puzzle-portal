package pl.puzzleportal.springjpabackend.controller;

public class RestPreconditions {
    public static <T> T checkFound(T resource) {
        if (resource == null) {
            throw new NullPointerException();
        }

        return resource;
    }
}
