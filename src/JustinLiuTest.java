import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing ProviderDirectory methods.
 * @author justinliu
 */
public class JustinLiuTest {

    ProviderDirectory directory;

    @BeforeEach
    void setUp() {
        System.out.println("Setting up");
        directory = new ProviderDirectory();
    }

    @Test
    void addService_Success() {
        System.out.println("Running: addService_Success");
        Service service = new Service("Consultation", 100000, 100);
        directory.addService(service);
        assertEquals("Consultation", directory.services.get(0).getName());
    }

    @Test
    void addService_Sanity() {
        System.out.println("Running: addService_Sanity");
        Service service = new Service("Spa", 100000, 100);
        directory.addService(service);
        assertEquals(service, directory.services.get(0));
    }

    @Test
    void searchByCode_Success() {
        System.out.println("Running: searchByCode_Success");
        Service service = new Service("Spa", 100000, 100);
        directory.addService(service);
        assertEquals(service, directory.searchByCode(100000));
    }

    @Test
    void searchByCode_Failure() {
        System.out.println("Running: searchByCode_Failure");
        Service service = new Service("Spa", 100000, 100);
        directory.addService(service);
        Service wrongService = new Service("Salon", 100001, 50);
        directory.addService(wrongService);
        assertNotEquals(wrongService, directory.searchByCode(100000));
    }

    /**
     * Testing Service class by Abbie
     */
    @Test
    void getFee_Success() {
        System.out.println("Running: getFee_Success");
        String serviceName = "TestName";
        Float serviceFee = 100.00f;
        int serviceCode = 123456789;
        Service s = new Service(serviceName, serviceCode, serviceFee);
        assertEquals(s.getFee(), 100.00);
    }

    @Test
    void getFee_Failure() {
        System.out.println("Running: getFee_Failure");
        String serviceName = "TestName";
        Float serviceFee = 100.00f;
        int serviceCode = 123456789;
        Service s = new Service(serviceName, serviceCode, serviceFee);
        assertNotEquals(s.getFee(), 105.00);
    }
}