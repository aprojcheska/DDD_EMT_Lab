package mk.ukim.finki.emt.usermanagement.domain.modules;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shop_users")
@Getter
public class User extends AbstractEntity<UserId> {

    private String username;
    private String password;

    public User(){
        super(UserId.randomId(UserId.class));
    }
    public static User build(String username, String password){
        User user = new User();
        user.username = username;
        user.password = password;
        return user;
    }

}
