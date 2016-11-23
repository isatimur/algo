package com.learning.princeton.algo.client;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * // create a FileFinder instance with a naming pattern
 * FileFinder finder = new FileFinder("*.png");
 * <p>
 * // pass the initial directory and the finder to the file tree walker
 * Files.walkFileTree(Paths.get("/Users/userXYZ/icons"), finder);
 * <p>
 * // get the matched paths
 * Collection<Path> matchedFiles = finder.getMatchedPaths();
 * <p>
 * // print the matched paths
 * for (Path path : matchedFiles) {
 * System.out.println(path.getFileName());
 * }
 */
public class FileFinder extends SimpleFileVisitor<Path> {

    private final PathMatcher matcher;
    private List<Path> matchedPaths = new ArrayList<Path>();

    FileFinder(String pattern) {
        matcher = FileSystems.getDefault()
                .getPathMatcher("glob:" + pattern);
    }

    // Compares the glob pattern against
    // the file or directory name.
    void match(Path file) {
        Path name = file.getFileName();

        if (name != null && matcher.matches(name)) {
            matchedPaths.add(name);
        }
    }

    // Invoke the pattern matching
    // method on each file.
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        match(file);
        return CONTINUE;
    }

    // Invoke the pattern matching
    // method on each directory.
    @Override
    public FileVisitResult preVisitDirectory(Path dir,
                                             BasicFileAttributes attrs) {
        match(dir);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println(exc);
        return CONTINUE;
    }

    public int getTotalMatches() {
        return matchedPaths.size();
    }

    public Collection<Path> getMatchedPaths() {
        return matchedPaths;
    }

} 