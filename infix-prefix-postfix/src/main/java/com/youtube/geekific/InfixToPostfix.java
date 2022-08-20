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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {

    public static String infixToPostfix(String infix) {
        Stack<String> operators = new Stack<>();
        List<String> postfix = new ArrayList<>();
        for (String current : infix.split(" ")) {
            if (isOperator(current)) {
                while (!operators.empty() && hasLowerPrecedence(current, operators.peek())) {
                    postfix.add(operators.pop());
                }
                operators.push(current);
            } else {
                postfix.add(current);
            }
        }
        while (!operators.empty()) {
            postfix.add(operators.pop());
        }
        return String.join(" ", postfix);
    }

    public static boolean isOperator(String operator) {
        return List.of("+", "-", "*", "/", "%").contains(operator);
    }

    public static boolean hasLowerPrecedence(String op1, String op2) {
        return precedence(op1) < precedence(op2);
    }

    public static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "/", "*" -> 2;
            case "%" -> 3;
            default -> 4;
        };
    }

}
