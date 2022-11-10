/**
 * Test Cases.
 *
 * @author Abbie Bosko
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

public class AbbieBoskoTest {

    Service s;

    @Before
    public void setUp()  {
        String serviceName = "TestName";
        Float serviceFee = 100.00f;
        int serviceCode = 123456789;
        s = new Service(serviceName,serviceCode,serviceFee);
    }
    // testing getName method
    @Test
    public void getName_success() {
        Assert.assertEquals(s.getName(), "TestName");
    }
    @Test
    public void getName_failure() {
        Assert.assertNotEquals(s.getName(), "Failure");
    }

    // Testing getCode method
    @Test
    public void getCode_success() {
        Assert.assertEquals(s.getCode(), 123456789);
    }
    @Test
    public void getCode_failure() { Assert.assertNotEquals(s.getCode(), 238904);}

    // Testing Sydney's generate Provider Report method
    @Test
    public void generateProviderReport_success() {
        ProviderReport prvR = new ProviderReport();
        PersonData per = new PersonData();
        assertEquals("Provider report generated.", prvR.generateProviderRpt(per));
    }

    @Test
    public void generateProviderReport_fail() {
        ProviderReport prvR = new ProviderReport();
        PersonData per = new PersonData();
        assertNotEquals("Failure Case", prvR.generateProviderRpt(per));
    }
}