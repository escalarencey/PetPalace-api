// Task 1.2: Repository for User
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
