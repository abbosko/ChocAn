import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sydney Pierce
 */
public class SydneyPierceTests {

    /**
     * Testing my MemberReport class functions.
     */

    MemberReport mem;
    PersonData pd;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mem = new MemberReport();
        pd = new PersonData();
    }

    @org.junit.jupiter.api.Test
    void generateMemberRptSuccess() {
        assertTrue(mem.generateMemberRpt(pd) == "Member report generated");
    }

    @org.junit.jupiter.api.Test
    void generateMemberRptFail() {
        assertNotEquals(mem.generateMemberRpt(pd), "cow");
    }

    @org.junit.jupiter.api.Test
    void exportMemberReportSuccess() {
        assertEquals("Member report exported.", mem.exportMemberReport());
    }

    @org.junit.jupiter.api.Test
    void exportMemberReportFail() {
        assertNotEquals("chicken.", mem.exportMemberReport());
    }


    /**
     * Testing Brandon's EftReport class functions.
     */
    @org.junit.jupiter.api.Test
    void generateEftReportSuccess() {
        EftReport eft = new EftReport();
        assertEquals("EFT Report generated", eft.generateEftTReport());
    }

    @org.junit.jupiter.api.Test
    void generateEftReportFail() {
        EftReport eft = new EftReport();
        assertNotEquals("cow mow chicken bawk", eft.generateEftTReport());
    }

}