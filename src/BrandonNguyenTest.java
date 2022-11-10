import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BrandonNguyenTest {
    SummaryReport sum;
    PersonData per;
    int numProv;

    @BeforeEach
    void setUp() {
        sum = new SummaryReport();
        per = new PersonData();
        numProv = per.getNumProviders();
    }

    @Test
    void generateSummaryReportSuccess() {
        assertEquals(sum.generateSummaryReport(per,numProv),"Summary Report Generated.");
    }

    @Test
    void generateSummaryReportFa() {
        assertFalse(sum.generateSummaryReport(per,numProv) == "summary report generated");
    }

    @Test
    void exportSumSuccess() {
        assertEquals("Summary Report Exported.", sum.exportSumRpt());
    }

    @Test
    void exportSumRptFail() {
        assertNotEquals(sum.exportSumRpt(), "summary report exported.");
    }

    //Test Justin classes
    @Test
    void exportMemberReportSuccess() {
        MemberReport member = new MemberReport();
        assertTrue(member.exportMemberReport() != "Member Report Exported.");
    }
    @Test
    void exportMemberReportFail() {
        MemberReport failReport = new MemberReport();
        assertFalse("member report exported" == failReport.exportMemberReport());
    }
}