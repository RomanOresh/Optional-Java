import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(new User("Roman", "mail1@mail.com", 1));
        userRepository.addUser(new User("Vlad", "mail2@mail.com", 2));
        userRepository.addUser(new User("Vitaliy", "mail3@mail.com", 3));
        userRepository.addUser(new User("Ivan", "mail4@mail.com", 4));

        Optional<User> userById = userRepository.findUserById(4);
        if (userById.isPresent()){
            System.out.println("Ваш пользователь за ID: " + userById.get());
        }else {
            System.out.println("Пользователя с таким ID не найдено");
        }

        Optional<User> userByEmail = userRepository.findUserByEmail("mail3@mail.com");
        userByEmail.ifPresentOrElse(
                user -> System.out.println("Ваш пользователь с таким email: " + user),
                () -> System.out.println("Пользователя с таким email не найдено")
        );
        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(
                users -> {
                    System.out.println("Количетсво пользователей: " + users.size());
                    users.forEach(System.out::println);
                },
                () -> System.out.println("Список пользователей пустой")
        );

    }
}
