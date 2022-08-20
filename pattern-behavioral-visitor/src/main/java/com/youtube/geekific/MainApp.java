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

import com.youtube.geekific.models.*;

import java.util.List;

public class MainApp {

    /*
     * Video Reference: https://youtu.be/UQP5XqMqtqQ
     */
    public static void main(String[] args) {

        List<Client> clients = List.of(
                new Bank("bank_name", "bank_address", "bank_number", 10),
                new Resident("resident_name", "resident_address", "resident_number", "A"),
                new Company("company_name", "company_address", "company_number", 1000),
                new Restaurant("resto_name", "resto_address", "resto_number", true)
        );

        InsuranceMessagingVisitor visitor = new InsuranceMessagingVisitor();
        visitor.sendInsuranceMails(clients);

    }

}
