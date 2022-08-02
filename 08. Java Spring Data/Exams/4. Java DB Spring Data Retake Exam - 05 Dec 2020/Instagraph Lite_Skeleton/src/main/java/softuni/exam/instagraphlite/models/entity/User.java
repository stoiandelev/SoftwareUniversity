package softuni.exam.instagraphlite.models.entity;

import softuni.exam.instagraphlite.repository.UserRepository;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {



    @Column(nullable = false, unique = true, length = 19)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne(optional = false)
    private Picture profilePicture;



    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Post> posts;






    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Picture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Picture profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
