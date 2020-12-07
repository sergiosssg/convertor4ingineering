import XMLhandler.XMLLABELelementType;
import XMLhandler.XMLLABELelementTypeInTableJ0147105;
import XMLhandler.XMLLABELelementTypeInTableJ1312002;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//import org.junit.*;

public class QTA_level_zero extends Assert {
    static final private Map<String, XMLLABELelementType> mapOFxmlLabelelEmentType01 = new HashMap<>(1000);
    static final private Map<String, XMLLABELelementType> mapOFxmlLabelelEmentType02 = new HashMap<>(1000);
    static final private Map<String, XMLLABELelementType> mapOFxmlLabelelElementType05 = new HashMap<>(1000);
    //final private XMLLABELelementType mapOFxmlLabelelEmentTypeInTable;// = new XMLLABELelementType();


    private void setupArrayOfXMLLABELelementType() {
        final XMLLABELelementType[] aXMLLabelelEmentTypeInTableJ1312002 =
                new XMLLABELelementTypeInTableJ1312002[]{
                        XMLLABELelementTypeInTableJ1312002.T1RXXXXG2,  // 0
                        XMLLABELelementTypeInTableJ1312002.T1RXXXXG3,  // 1
                        XMLLABELelementTypeInTableJ1312002.T1RXXXXG4S, // 2
                        XMLLABELelementTypeInTableJ1312002.T1RXXXXG5,  // 3
                        XMLLABELelementTypeInTableJ1312002.T1RXXXXG6,  // 4
                        XMLLABELelementTypeInTableJ1312002.T1RXXXXG7S, // 5
                        XMLLABELelementTypeInTableJ1312002.T1RXXXXG8S, // 6
                        XMLLABELelementTypeInTableJ1312002.T1RXXXXG9,  // 7
                        XMLLABELelementTypeInTableJ1312002.T1RXXXXG10, // 8
                        XMLLABELelementTypeInTableJ1312002.T1RXXXXG11, // 9
                        XMLLABELelementTypeInTableJ1312002.T1RXXXXG12S, // 10
                };


        final XMLLABELelementType[] aXMLLabelelEmentTypeInTableJ0147105 =
                new XMLLABELelementTypeInTableJ0147105[]{
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG2S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG3S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG4S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG5S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG6S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG7D,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG8S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG9S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG10S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG11S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG12S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG13S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG14D,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG15D,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG16,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG17,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG18S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG19S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG20,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG21S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG22S,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG23,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG24,
                        XMLLABELelementTypeInTableJ0147105.T1RXXXXG25,
                };

        final XMLLABELelementType[] aXMLLabelelTAGConstant =
                new TAGConstant[]{
                        TAGConstant.HEAD,
                        TAGConstant.BODY,
                        TAGConstant.BEFORETABLE,
                        TAGConstant.AFTERTABLE,
                        TAGConstant.TIN,
                        TAGConstant.C_DOC,
                        TAGConstant.C_DOC_SUB,
                        TAGConstant.C_DOC_VER,
                        TAGConstant.C_DOC_TYPE,
                        TAGConstant.C_DOC_CNT,
                        TAGConstant.C_REG,
                        TAGConstant.C_RAJ,
                        TAGConstant.PERIOD_MONTH,
                        TAGConstant.PERIOD_TYPE,
                        TAGConstant.PERIOD_YEAR,
                        TAGConstant.C_STI_ORIG,
                        TAGConstant.C_DOC_STAN,
                        TAGConstant.LINKED_DOCS,
                        TAGConstant.DOC,
                        TAGConstant.FILENAME,
                        TAGConstant.D_FILL,
                        TAGConstant.SOFTWARE,
                        TAGConstant.HSTI,
                        TAGConstant.HTIN,
                        TAGConstant.HNAME,
                        TAGConstant.HBOS,
                        TAGConstant.HFILL,
                        TAGConstant.HZ,
                        TAGConstant.HNUM,
                        TAGConstant.HZY,
                        TAGConstant.R00G1,
                        TAGConstant.R01G1S,
                        TAGConstant.R01G2S,
                        TAGConstant.R01G3S,
                        TAGConstant.R01G4S,
                        TAGConstant.R01G5S,
                        TAGConstant.R03G1S,
                        TAGConstant.R03G2S,
                        TAGConstant.R03G3S,
                        TAGConstant.R03G4S,
                        TAGConstant.R04G1S,
                        TAGConstant.R04G2S,
                        TAGConstant.R04G3S,
                        TAGConstant.R04G4S,
                        TAGConstant.R01G20
                };


        int indx = 0;
        for (XMLLABELelementType el : aXMLLabelelEmentTypeInTableJ1312002) {
//                System.out.print(indx);
            mapOFxmlLabelelEmentType01.put(el.toString(), aXMLLabelelEmentTypeInTableJ1312002[indx++]);
/*
                System.out.print(" - ");
                System.out.print(el.toString());
                System.out.print(" -> ");
                System.out.println(aXMLLabelelEmentTypeInTableJ1312002[indx-1]);
*/
        }
        indx = 0;
        for (XMLLABELelementType el : aXMLLabelelEmentTypeInTableJ0147105) {
            mapOFxmlLabelelEmentType02.put(el.toString(), aXMLLabelelEmentTypeInTableJ0147105[indx++]);
        }


        indx = 0;
        for (XMLLABELelementType el : aXMLLabelelTAGConstant) {
            mapOFxmlLabelelElementType05.put(el.toString(), aXMLLabelelTAGConstant[indx++]);
        }


    } // preparing for test


    private void tearArrayOfXMLLABELelementType() {
        mapOFxmlLabelelEmentType01.clear();
        mapOFxmlLabelelEmentType02.clear();
        mapOFxmlLabelelElementType05.clear();
    }


    private void testArrayOfXMLLABELelementType() {
//            for (Map.Entry<String, byte[]> entry : toHexStringData.entrySet()) {
//                final byte[] testData = entry.getValue();
//                final String expected = entry.getKey();
//                final String actual = StringUtils.toHexString(testData);
//                assertEquals(expected, actual);
//            }
        final String[] strArrOfXMLLABEL_template02 = {
                "",               // 0
                "T1RXXXXG2",      // 1
                "T1RXXXXG3",      // 2
                "T1RXXXXG4S",     // 3
                "T1RXXXXG5",      // 4
                "T1RXXXXG6",      // 5
                "T1RXXXXG7S",     // 6
                "T1RXXXXG8S",     // 7
                "T1RXXXXG9",      // 8
                "T1RXXXXG10",     // 9
                "T1RXXXXG11",     // 10
                "T1RXXXXG12S",    // 11
                "WRONGTAG"        // 12
        };  // строки

        XMLLABELelementType[] XMLLLETArrayLABELs_template01 = new XMLLABELelementType[]{
                null,
                XMLLABELelementTypeInTableJ1312002.T1RXXXXG2,
                XMLLABELelementTypeInTableJ1312002.T1RXXXXG3,
                XMLLABELelementTypeInTableJ1312002.T1RXXXXG4S,
                XMLLABELelementTypeInTableJ1312002.T1RXXXXG5,
                XMLLABELelementTypeInTableJ1312002.T1RXXXXG6,
                XMLLABELelementTypeInTableJ1312002.T1RXXXXG7S,
                XMLLABELelementTypeInTableJ1312002.T1RXXXXG8S,
                XMLLABELelementTypeInTableJ1312002.T1RXXXXG9,
                XMLLABELelementTypeInTableJ1312002.T1RXXXXG10,
                XMLLABELelementTypeInTableJ1312002.T1RXXXXG11,
                XMLLABELelementTypeInTableJ1312002.T1RXXXXG12S,
        };  // константы


        XMLLABELelementType[] XMLLLETArrayLABELs_template03 = new XMLLABELelementType[]{
                null,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG2S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG3S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG4S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG5S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG6S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG7D,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG8S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG9S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG10S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG11S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG12S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG13S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG14D,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG15D,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG16,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG17,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG18S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG19S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG20,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG21S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG22S,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG23,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG24,
                XMLLABELelementTypeInTableJ0147105.T1RXXXXG25
        };  // константы


        XMLLABELelementType[] XMLTAGConstants_template05 = new TAGConstant[]{
                TAGConstant.HEAD,
                TAGConstant.BODY,
                TAGConstant.BEFORETABLE,
                TAGConstant.AFTERTABLE,
                TAGConstant.TIN,
                TAGConstant.C_DOC,
                TAGConstant.C_DOC_SUB,
                TAGConstant.C_DOC_VER,
                TAGConstant.C_DOC_TYPE,
                TAGConstant.C_DOC_CNT,
                TAGConstant.C_REG,
                TAGConstant.C_RAJ,
                TAGConstant.PERIOD_MONTH,
                TAGConstant.PERIOD_TYPE,
                TAGConstant.PERIOD_YEAR,
                TAGConstant.C_STI_ORIG,
                TAGConstant.C_DOC_STAN,
                TAGConstant.LINKED_DOCS,
                TAGConstant.DOC,
                TAGConstant.FILENAME,
                TAGConstant.D_FILL,
                TAGConstant.SOFTWARE,
                TAGConstant.HSTI,
                TAGConstant.HTIN,
                TAGConstant.HNAME,
                TAGConstant.HBOS,
                TAGConstant.HFILL,
                TAGConstant.HZ,
                TAGConstant.HNUM,
                TAGConstant.HZY,
                TAGConstant.R00G1,
                TAGConstant.R01G1S,
                TAGConstant.R01G2S,
                TAGConstant.R01G3S,
                TAGConstant.R01G4S,
                TAGConstant.R01G5S,
                TAGConstant.R03G1S,
                TAGConstant.R03G2S,
                TAGConstant.R03G3S,
                TAGConstant.R03G4S,
                TAGConstant.R04G1S,
                TAGConstant.R04G2S,
                TAGConstant.R04G3S,
                TAGConstant.R04G4S,
                TAGConstant.R01G20
        };  // константы


        String[] strArrOfXMLLABELelementType;
        final int lengthOfMapOFxmlLabelelEmentType01 = mapOFxmlLabelelEmentType01.keySet().toArray().length;
        strArrOfXMLLABELelementType = new String[lengthOfMapOFxmlLabelelEmentType01];
        for (int ii = 1; ii <= lengthOfMapOFxmlLabelelEmentType01; ii++) {
            if (mapOFxmlLabelelEmentType01.containsKey(strArrOfXMLLABEL_template02[ii])) {
                strArrOfXMLLABELelementType[(ii - 1)] = strArrOfXMLLABEL_template02[ii];
            }
        }


        Assert.assertEquals(mapOFxmlLabelelEmentType01.containsKey(strArrOfXMLLABEL_template02[0]), false);

        for (int indx = 1; indx < strArrOfXMLLABEL_template02.length - 1; indx++) {
            Assert.assertNotNull(mapOFxmlLabelelEmentType01.get(strArrOfXMLLABEL_template02[indx]));
            Assert.assertEquals(mapOFxmlLabelelEmentType01.containsKey(strArrOfXMLLABEL_template02[indx]), true);
            Assert.assertEquals(mapOFxmlLabelelEmentType01.get(strArrOfXMLLABEL_template02[indx]), XMLLLETArrayLABELs_template01[indx]);
            Assert.assertEquals(mapOFxmlLabelelEmentType01.get(strArrOfXMLLABEL_template02[indx]).getCode(), indx - 1);
            Assert.assertEquals(mapOFxmlLabelelEmentType01.get(strArrOfXMLLABEL_template02[indx]).compareTo(
                    mapOFxmlLabelelEmentType01.get(strArrOfXMLLABEL_template02[indx])
            ), 0);
            Assert.assertEquals(mapOFxmlLabelelEmentType01.get(strArrOfXMLLABEL_template02[indx]).toString(), strArrOfXMLLABEL_template02[indx]);
        }

        final String[] strArrOfXMLLABEL_template03 = {
                "",                 // 0
                "T1RXXXXG2S",       // 1
                "T1RXXXXG3S",       // 2
                "T1RXXXXG4S",       // 3
                "T1RXXXXG5S",       // 4
                "T1RXXXXG6S",       // 5
                "T1RXXXXG7D",       // 6
                "T1RXXXXG8S",       // 7
                "T1RXXXXG9S",       // 8
                "T1RXXXXG10S",      // 9
                "T1RXXXXG11S",      // 10
                "T1RXXXXG12S",      // 11
                "T1RXXXXG13S",      // 12
                "T1RXXXXG14D",      // 13
                "T1RXXXXG15D",      // 14
                "T1RXXXXG16",       // 15
                "T1RXXXXG17",       // 16
                "T1RXXXXG18S",      // 17
                "T1RXXXXG19S",      // 18
                "T1RXXXXG20",       // 19
                "T1RXXXXG21S",      // 20
                "T1RXXXXG22S",      // 21
                "T1RXXXXG23",       // 22
                "T1RXXXXG24",       // 23
                "T1RXXXXG25",       // 24
                "WRONGTAG"          // 25
        };  // строки

        final String[] strArrOfTAGConstant_template05 = {
                "HEAD",
                "BODY",
                "BEFORETABLE",
                "AFTERTABLE",
                "TIN",
                "C_DOC",
                "C_DOC_SUB",
                "C_DOC_VER",
                "C_DOC_TYPE",
                "C_DOC_CNT",
                "C_REG",
                "C_RAJ",
                "PERIOD_MONTH",
                "PERIOD_TYPE",
                "PERIOD_YEAR",
                "C_STI_ORIG",
                "C_DOC_STAN",
                "LINKED_DOCS",
                "DOC",
                "FILENAME",
                "D_FILL",
                "SOFTWARE",
                "HSTI",
                "HTIN",
                "HNAME",
                "HBOS",
                "HFILL",
                "HZ",
                "HNUM",
                "HZY",
                "R00G1",
                "R01G1S",
                "R01G2S",
                "R01G3S",
                "R01G4S",
                "R01G5S",
                "R03G1S",
                "R03G2S",
                "R03G3S",
                "R03G4S",
                "R04G1S",
                "R04G2S",
                "R04G3S",
                "R04G4S",
                "R01G20"
        };  // строки


        final int lengthOfMapOFxmlLabelelEmentType03 = mapOFxmlLabelelEmentType02.keySet().toArray().length;
        strArrOfXMLLABELelementType = new String[lengthOfMapOFxmlLabelelEmentType03];
        for (int ii = 1; ii <= lengthOfMapOFxmlLabelelEmentType03; ii++) {
            if (mapOFxmlLabelelEmentType02.containsKey(strArrOfXMLLABEL_template03[ii])) {
                strArrOfXMLLABELelementType[(ii - 1)] = strArrOfXMLLABEL_template03[ii];
            }
        }


        Assert.assertEquals(mapOFxmlLabelelEmentType02.containsKey(strArrOfXMLLABEL_template03[0]), false);

        for (int indx = 1; indx < strArrOfXMLLABEL_template03.length - 1; indx++) {
            Assert.assertNotNull(mapOFxmlLabelelEmentType02.get(strArrOfXMLLABEL_template03[indx]));
            Assert.assertEquals(mapOFxmlLabelelEmentType02.containsKey(strArrOfXMLLABEL_template03[indx]), true);
            Assert.assertEquals(mapOFxmlLabelelEmentType02.get(strArrOfXMLLABEL_template03[indx]), XMLLLETArrayLABELs_template03[indx]);
            Assert.assertEquals(mapOFxmlLabelelEmentType02.get(strArrOfXMLLABEL_template03[indx]).getCode(), indx - 1);
            Assert.assertEquals(mapOFxmlLabelelEmentType02.get(strArrOfXMLLABEL_template03[indx]).compareTo(
                    mapOFxmlLabelelEmentType02.get(strArrOfXMLLABEL_template03[indx])
            ), 0);
            Assert.assertEquals(mapOFxmlLabelelEmentType02.get(strArrOfXMLLABEL_template03[indx]).toString(), strArrOfXMLLABEL_template03[indx]);
        }

        Assert.assertEquals(mapOFxmlLabelelEmentType02.containsKey(strArrOfXMLLABEL_template03[(strArrOfXMLLABEL_template03.length - 1)]), false);


        for (int indx = 0; indx < strArrOfTAGConstant_template05.length - 1; indx++) {
            XMLLABELelementType xmlEl = mapOFxmlLabelelElementType05.get(strArrOfTAGConstant_template05[indx]);
/*                System.out.print(" - ");
                System.out.print(xmlEl.toString());
                System.out.print(" -> ");
                System.out.println(xmlEl.getCode());*/
            /*System.out.println(strArrOfTAGConstant_template05[indx]);*/
        }
    }


    @Before
    public void prepareSetup() {
        setupArrayOfXMLLABELelementType();
    }

    @After
    public void clearAll() {
        tearArrayOfXMLLABELelementType();
    }


    @Test
    public void performAllTests() {
        testArrayOfXMLLABELelementType();
    }


    //...
}





