package com.github.javaparser.generator.visitor;

import com.github.javaparser.JavaParser;
import com.github.javaparser.generator.utils.GeneratorUtils;
import com.github.javaparser.generator.utils.SourceRoot;
import com.github.javaparser.metamodel.JavaParserMetaModel;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Generates all generated visitors in the javaparser-core module.
 */
public class CoreVisitorsGenerator {
    public static void main(String[] args) throws IOException {
        Path root = GeneratorUtils.getJavaParserBasePath().resolve(Paths.get("javaparser-core", "src", "main", "java"));

        final JavaParser javaParser = new JavaParser();

        final SourceRoot sourceRoot = new SourceRoot(root);

        new GenericVisitorAdapterGenerator(javaParser, sourceRoot).generate();
        new EqualsVisitorGenerator(javaParser, sourceRoot).generate();
        new VoidVisitorAdapterGenerator(javaParser, sourceRoot).generate();
        new VoidVisitorGenerator(javaParser, sourceRoot).generate();
        new GenericVisitorGenerator(javaParser, sourceRoot).generate();
        new HashCodeVisitorGenerator(javaParser, sourceRoot).generate();
        new CloneVisitorGenerator(javaParser, sourceRoot).generate();

        sourceRoot.saveAll();
    }
}