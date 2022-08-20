/*
 * MIT License
 *
 * Copyright (c) 2022 Geekific (https://www.youtube.com/c/Geekific)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice, Geekific's channel link and this permission notice
 * shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.youtube.geekific;/*
 * MIT License
 *
 * Copyright (c) 2022 Geekific (https://www.youtube.com/c/Geekific)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice, Geekific's channel link and this permission notice
 * shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;
import static javax.lang.model.element.ElementKind.FIELD;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@SupportedAnnotationTypes("com.youtube.geekific.Builder")
public class BuilderProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        annotations.forEach(annotation ->
                roundEnv.getElementsAnnotatedWith(annotation)
                        .forEach(this::generateBuilderFile)
        );
        return true;
    }

    private void generateBuilderFile(Element element) {
        String className = element.getSimpleName().toString();
        String packageName = element.getEnclosingElement().toString();
        String builderName = className + "com.youtube.geekific.Builder";
        String builderFullName = packageName + "." + builderName;
        List<? extends Element> fields = element.getEnclosedElements()
                .stream().filter(e -> FIELD.equals(e.getKind())).toList();

        try (PrintWriter writer = new PrintWriter(
                processingEnv.getFiler().createSourceFile(builderFullName).openWriter())) {
            writer.println("""
                    package %s;
                         
                    public class %s {
                    """
                    .formatted(packageName, builderName)
            );

            fields.forEach(field ->
                    writer.print("""
                                private %s %s;
                            """.formatted(field.asType().toString(), field.getSimpleName())
                    )
            );

            writer.println();
            fields.forEach(field ->
                    writer.println("""
                                public %s %s(%s value) {
                                    %s = value;
                                    return this;
                                }
                            """.formatted(builderName, field.getSimpleName(),
                            field.asType().toString(), field.getSimpleName())
                    )
            );

            writer.println("""
                        public %s build() {
                            return new %s(%s);
                        }
                    """.formatted(className, className,
                    fields.stream().map(Element::getSimpleName).collect(joining(", ")))
            );
            writer.println("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
