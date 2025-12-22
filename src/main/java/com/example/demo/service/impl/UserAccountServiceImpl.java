@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccount createUser(UserAccount user) {
        return repo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public UserAccount findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = repo.findById(id).orElseThrow();
        user.setStatus(status);
        return repo.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }
}
