package examples.users;

import com.intuit.karate.junit5.Karate;

class UsersRunner {
    
    @Karate.Test
    Karate testActivities() {
        return Karate.run("users").relativeTo(getClass());
    }    

}
