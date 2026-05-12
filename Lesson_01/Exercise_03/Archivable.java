package Lesson_01.Exercise_03;

public interface Archivable {
    default boolean canArchive() {
        return false;
    }

    void archive();
}