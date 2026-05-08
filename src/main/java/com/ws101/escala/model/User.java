// Task 1.2: User Entity implementing UserDetails
@Entity @Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true) private String username;
    private String password;
    private String role; // e.g., ROLE_USER, ROLE_ADMIN

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }
    // Set all boolean returns (isAccountNonExpired, etc.) to true
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
