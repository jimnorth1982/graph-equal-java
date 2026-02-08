package org.jimmycodes.graphequaljava.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.jimmycodes.graphequaljava.codegen.types.User;

import java.util.List;

@DgsComponent
public class UserDatafetcher {
    private final List<User> users = List.of(
            new User("1", "Jimmy", "Joseph", "jimmygoboom@mailinator.com"),
            new User("2", "Karl", "Bratanalanalewski", "karlBratanalanalewski@mailinator.com"),
            new User("3", "Master", "Shake", "mastershake@mailinator.com")
    );

    @DgsQuery
    public List<User> users(@InputArgument String emailFilter) {
        return this.users.stream().filter((user) -> user.getEmail().contains(emailFilter)).toList();
    }
}
