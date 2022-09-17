package activities;

import com.intuit.karate.junit5.Karate;

class ActivitiesRunner {
    
    @Karate.Test
    Karate testUsers() {
        return Karate.run("activities").relativeTo(getClass());
    }    

}
