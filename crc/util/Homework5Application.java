package util;

import java.sql.SQLException;

public class Homework5Application {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Menu menu = new Menu();

        menu.showFirstMenu();
       int select= menu.customerSelect();
       int correctSelect = menu.cheekSelect(select);
       menu.enterMenu(correctSelect);

    }


}
