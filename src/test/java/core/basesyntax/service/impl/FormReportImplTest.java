package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FormReport;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormReportImplTest {
    private static final String REPORT_HEAD = "fruit,quantity";
    private static final String RESULT_BANANA = "banana,152";
    private static final String RESULT_APPLE = "apple,90";
    private static final String VALID_RESULT = "fruit,quantity\r\nbanana,152\r\napple,90";
    FormReport formReport = new FormReportImpl();

    @Before
    public void initialize() {
        Storage.storage.put(new Fruit("banana"), 152);
        Storage.storage.put(new Fruit("apple"), 90);
    }

    @Test
    public void checkReport() {
        assertEquals(formReport.reportFromStorage(), VALID_RESULT);
    }
}