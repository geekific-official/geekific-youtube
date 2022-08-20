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

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Dialog implements Mediator {

    private final JTextField userTextBox = new JTextField();
    private final JTextField passTextBox = new JTextField();
    private final LoginButton loginButton = new LoginButton();
    private final ForgotPasswordButton passwordButton = new ForgotPasswordButton();

    public Dialog() {
        loginButton.setMediator(this);
        passwordButton.setMediator(this);
    }

    @Override
    public void login() {
        System.out.println("Logging in...");
        String username = userTextBox.getText();
        String password = passTextBox.getText();
        // validate username and password
        // logs in the user or pops error message
    }

    @Override
    public void forgotPass() {
        System.out.println("Generating new Password...");
        String username = userTextBox.getText();
        // generate new pass for the user
        // send mail to this username with new pass
    }

    public void enterUsername(String username) {
        userTextBox.setText(username);
    }

    public void enterPassword(String password) {
        passTextBox.setText(password);
    }

    public void simulateLoginClicked() {
        loginButton.fireActionPerformed(new ActionEvent(this, 0, "login"));
    }

    public void simulateForgotPassClicked() {
        passwordButton.fireActionPerformed(new ActionEvent(this, 0, "forgot pass"));
    }

}

