
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
//junit tests for provider class and one for member
public class ReaghanDoughertyTests{

    GlobalController globalController;
    int id = 100000000;
    String name = "Jane Doe";
    String address = "500 Capstone Dr";
    String city = "Tuscaloosa";
    String state = "Alabama";
    String zipcode = "35406";

    Provider p;

    @Before
    public void setUp() throws Exception
    {
        globalController = new GlobalController();
        p = new Provider(id, name, address, city, state, zipcode);
    }

    //my test for create a provider
    @Test
    public void provider_success()
    {
        globalController.add(p);
        Assert.assertEquals(globalController.getProvider(id).name, "Jane Doe");
    }
    // my test for deletion of provider
    @Test
    public void delete_success()
    {
        globalController.add(p);
        Assert.assertEquals(globalController.deleteProvider(id), true);
    }

    //test for invalid member id delete, it should return false
    @Test
    public void test_failure()
    {
        Assert.assertEquals(globalController.deleteMember(100000001), false);
    }


}
