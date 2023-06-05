package br.com.nicestocks.nicestocks;

import Model.Stock;
import View.LoginCreate;
import View.LoginScreen;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.UIManager;

public class NiceStocks {

    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
}
