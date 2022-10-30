import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class appss123 {
    private static List<User> users = new ArrayList<>();

    public static void main(String args[]) {
        boolean appIsRunning = true;
        while (appIsRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - register; 2 - find user; 3 - remove user; 4 - get all; 5 - exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("ВВЕДІТЬ ЮЗЕРНЕЙМ:");
                    String username = scanner.next();
                    for (User user : users) {
                        if (user.getUsername().compareTo(username) == 0) {
                            try {
                                int a = 0;
                                int b = 1;
                                int c = b / a;
                            } catch (RuntimeException ex) {
                                System.out.println("Даний username вже зарегестрований, СПРОБУЙТЕ ІНШИЙ!!!");
                            }
                            return;
                        }
                    }
                    System.out.println("ВВЕДІТЬ ПАРОЛЬ:");
                    String password = scanner.next();
                    System.out.println("ВВЕДІТЬ ІМЯ:");
                    String firstName = scanner.next();
                    System.out.println("ВВЕДІТЬ ПРІЗВИЩЕ:");
                    String lastName = scanner.next();
                    if (username.length() == 0 || username.isEmpty()) {
                        System.out.println("НЕ ПРАВИЛЬНО ВКАЗАНО USERNAME!!");
                        return;
                    }
                    if (password.length() == 0 || password.isEmpty()) {
                        System.out.println("НЕ ПРАВИЛЬНО ВКАЗАНО ПАРОЛЬ!!");
                        return;
                    }
                    if (firstName.length() == 0 || firstName.isEmpty()) {
                        System.out.println("НЕ ПРАВИЛЬНО ВКАЗАНО ІМ'Я!!");
                        return;
                    }
                    if (lastName.length() == 0 || lastName.isEmpty()) {
                        System.out.println("НЕ ПРАВИЛЬНО ВКАЗАНА ФАМІЛІЯ!!");
                        return;
                    }
                    User newUser = new User(username, password, firstName, lastName);
                    register(newUser);
                    break;
                case 2:
                    System.out.println("ВВЕДІТЬ ЮЗЕРНЕЙМ ДЛЯ ПОШУКУ:");
                    String findUsername = scanner.next();
                    findUser(findUsername);
                    break;
                case 3:
                    System.out.println("ВВЕДІТЬ ЮЗЕРНЕЙМ ДЛЯ ВИДАЛЕННЯ:");
                    String usernameToRemove = scanner.next();
                    removeUser(usernameToRemove);
                    break;
                case 4:
                    getAll();
                    break;
                default:
                    appIsRunning = false;
                    break;
            }
        }

    }

    private static void register(User user) {
        users.add(user);
        System.out.println("ЗАРЄГАЛИ ЮЗЕРА " + user);
    }

    private static void findUser(String username) {
        boolean userFound = false;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                userFound = true;
                System.out.println("ТАКОГО ЮЗЕРА ЗНАЙДЕНО: " + user);
            }
        }

        if (!userFound) {
            System.out.println("ТАКОГО ЮЗЕРА НЕМА");
        }
    }

    private static void removeUser(String username) {
        User userToRemove = null;

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                userToRemove = user;
            }
        }

        if (userToRemove != null) {
            users.remove(userToRemove);
            System.out.println("ВИДАЛЕНО!");
        } else {
            System.out.println("ТАКОГО ЮЗЕРА НЕМА");
        }
    }

    private static void getAll() {
        System.out.println("Усі існуючі юзери:");
        if (users.size() == 0) {
            System.out.println("Юзерів ще не було створено!");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

}