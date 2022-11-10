
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class SaniTests{

    GlobalController globalController;
    int id = 100000000;

    @Before
    public void setUp() throws Exception
    {
        globalController = new GlobalController();
    }

    //testing to see if adding a member and getting the same member works
    @Test
    public void member_success()
    {
        Member m;
        String name = "Test";
        String address = "Test";
        String city = "Test";
        String state = "Test";
        String zipcode = "Test";
        boolean status = false;

        m = new Member(id, name, address, city, state, zipcode, status);
        globalController.add(m);
        globalController.getMember(id);
    }

    //testing my verifyProviderID method
    //since it was set to true earlier
    @Test
    public void sanity()
    {
        Assert.assertEquals(globalController.verifyMemberID(id), false);
    }

    //testing Abbie's Provider constructor
    @Test
    public void provider_success()
    {
        Provider p;
        String name = "Test";
        String address = "Test";
        String city = "Test";
        String state = "Test";
        String zipcode = "Test";
        boolean status = false;

        p = new Provider(id, name, address, city, state, zipcode);
        globalController.add(p);
    }


}
