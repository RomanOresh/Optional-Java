import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public Optional<User> findUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    public Optional<List<User>> findAllUsers() {
        if(users.isEmpty()){
            return Optional.empty();
        } else{
            return Optional.of(users);}
    }
}
