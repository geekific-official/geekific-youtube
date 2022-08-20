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

package com.youtube.geekific;

import java.util.regex.Pattern;

public class RunLengthEncoding {

    public static String compress(String text) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(([a-zA-Z])\\2*)");
        pattern.matcher(text).results().forEach(result -> {
            int repetitions = result.group(1).length();
            sb.append(result.group(2)).append(repetitions);
        });
        return sb.toString();
    }

    public static String decompress(String text) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("([a-zA-Z])([0-9]*)");
        pattern.matcher(text).results().forEach(result -> {
            int count = Integer.parseInt(result.group(2));
            sb.append(result.group(1).repeat(count));
        });
        return sb.toString();
    }

    public static String classicCompress(String text) {
        StringBuilder sb = new StringBuilder();
        for (int textIndex = 0; textIndex < text.length(); textIndex++) {
            int charCount = 1;
            while (textIndex < text.length() - 1 && text.charAt(textIndex) == text.charAt(textIndex + 1)) {
                charCount++;
                textIndex++;
            }
            sb.append(text.charAt(textIndex)).append(charCount);
        }
        return sb.toString();
    }

    public static String classicDecompress(String text) {
        StringBuilder sb = new StringBuilder();
        for (int textIndex = 0; textIndex < text.length(); textIndex++) {
            if (Character.isDigit(text.charAt(textIndex))) {
                int charCount = Character.getNumericValue(text.charAt(textIndex));
                while (charCount-- != 1) sb.append(text.charAt(textIndex - 1));
            } else {
                sb.append(text.charAt(textIndex));
            }
        }
        return sb.toString();
    }

}
