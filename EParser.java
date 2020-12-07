package parser;


import XMLhandler.NumberOfSchemaReport;
import XMLhandler.StorageInMemory;
import XMLhandler.XMLLABELelementTypeInTableJ0147105;
import XMLhandler.XMLLABELelementTypeInTableJ1312002;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

import static XMLhandler.NumberOfSchemaReport.J0147105;
import static XMLhandler.NumberOfSchemaReport.J1312002;


public final class EParser {

    private  EParser(){
    }

    enum TypesOfCell {
        BOOLEAN,
        LONG,
        DOUBLE,
        DATE,
        STRING
    }


    static class CellComplexValue {
        TypesOfCell typesOfCell;
        Double aDouble;
        Long aLong;
        String aString;
        Boolean aBoolean;
        Date aDate;
        boolean iamempty;

        TypesOfCell whichTypeStore() {
            return typesOfCell;
        }

        boolean isStringLong(String stringParameter) {
            try {
                Long.parseLong(stringParameter);
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        boolean isStringDouble(String stringParameter) {
            try {
                Double.parseDouble(stringParameter);
                return true;
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        boolean isStringDateOfFullFormat(String stringParameter) {
            try {
                DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.forLanguageTag("ua"));
                df.setLenient(false);
                df.parse(stringParameter);
                return true;
            } catch (ParseException nfe) {
                return false;
            }
        }
        boolean isStringDateOfLongFormat(String stringParameter) {
            try {
                DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.forLanguageTag("ua"));
                df.setLenient(false);
                df.parse(stringParameter);
                return true;
            } catch (ParseException nfe) {
                return false;
            }
        }
        boolean isStringDateOfMediumFormat(String stringParameter) {
            try {
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.forLanguageTag("ua"));
                df.setLenient(false);
                df.parse(stringParameter);
                return true;
            } catch (ParseException nfe) {
                return false;
            }
        }
        boolean isStringDateOfShortFormat(String stringParameter) {
            try {
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.forLanguageTag("ua"));
                df.setLenient(false);
                df.parse(stringParameter);
                return true;
            } catch (ParseException nfe) {
                return false;
            }
        }


        CellComplexValue(String stringParameter) {
            try {
                if (isStringLong(stringParameter)) {
                    aLong = Long.parseLong(stringParameter);
                    aString = stringParameter;
                    typesOfCell = TypesOfCell.LONG;
                } else if (isStringDouble(stringParameter)) {
                    aDouble = Double.parseDouble(stringParameter);
                    aString = stringParameter;
                    typesOfCell = TypesOfCell.DOUBLE;
                } else if (isStringDateOfFullFormat(stringParameter)) {
                    DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.forLanguageTag("ua"));
                    df.setLenient(false);
                    aDate = df.parse(stringParameter);
                    aString = stringParameter;
                    typesOfCell = TypesOfCell.DATE;
                } else if (isStringDateOfLongFormat(stringParameter)) {
                    DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.forLanguageTag("ua"));
                    df.setLenient(false);
                    aDate = df.parse(stringParameter);
                    aString = stringParameter;
                    typesOfCell = TypesOfCell.DATE;
                } else if (isStringDateOfMediumFormat(stringParameter)) {
                    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.forLanguageTag("ua"));
                    df.setLenient(false);
                    aDate = df.parse(stringParameter);
                    aString = stringParameter;
                    typesOfCell = TypesOfCell.DATE;
                } else if (isStringDateOfShortFormat(stringParameter)) {
                    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.forLanguageTag("ua"));
                    df.setLenient(false);
                    aDate = df.parse(stringParameter);
                    aString = stringParameter;
                    typesOfCell = TypesOfCell.DATE;
                } else {
                    aString = stringParameter;
                    typesOfCell = TypesOfCell.STRING;
                }
                if(stringParameter == null || stringParameter.isEmpty() || stringParameter.equals("")){
                    iamempty = true;
                }else{
                    iamempty = false;
                }

            } catch (ParseException nfe) {
                ;
            }
        }

        CellComplexValue(Long longParameter) {
            aLong = longParameter;
            typesOfCell = TypesOfCell.LONG;
        }

        CellComplexValue(Double doubleParameter) {
            aDouble = doubleParameter;
            typesOfCell = TypesOfCell.DOUBLE;
        }

        CellComplexValue(Boolean booleanParameter) {
            aBoolean = booleanParameter;
            typesOfCell = TypesOfCell.BOOLEAN;
        }

        CellComplexValue(Date dateParameter) {
            aDate = dateParameter;
            typesOfCell = TypesOfCell.DATE;
        }


        @Override
        public boolean equals(Object obj){
            if(obj == null) return false;
            if(!obj.getClass().getName().equals("CellComplexValue")) return false;

            CellComplexValue cellCVObject = (CellComplexValue) obj;
            if(iamempty || cellCVObject.iamempty){
                return false;
            }
            if(typesOfCell != cellCVObject.typesOfCell){
                return false;
            }

            switch (typesOfCell){
                case BOOLEAN:
                    return aBoolean.equals(cellCVObject.aBoolean);
                case LONG:
                    return aLong.equals(cellCVObject.aLong);
                case DOUBLE:
                    return aDouble.equals(cellCVObject.aDouble);
                case DATE:
                    return aDate.equals(cellCVObject.aDate);
                case STRING:
                    return aString.equals(cellCVObject.aString);
                default:
                    return ( aLong.equals(cellCVObject.aLong) ||
                             aDouble.equals(cellCVObject.aDouble) ||
                             aDate.equals(cellCVObject.aDate) ||
                             aString.equals(cellCVObject.aString));
            }
        }



        String getString() {
            return aString;
        }

        Double getDouble() {
            return aDouble;
        }

        Long getLong() {
            return aLong;
        }

        Boolean getBoolean() {
            return aBoolean;
        }

        Date getDate() {
            return aDate;
        }
        boolean AmIEmpty(){
            return iamempty;
         }
    }

//    static public String parse(String name) {
//        String result = "";
//        InputStream in = null;
//        HSSFWorkbook wb = null;
//        try {
//            in = new FileInputStream(name);
//            wb = new HSSFWorkbook(in);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Sheet sheet = wb.getSheetAt(0);
//        Iterator<Row> it = sheet.iterator();
//        while (it.hasNext()) {
//            Row row = it.next();
//            Iterator<Cell> cells = row.iterator();
//            while (cells.hasNext()) {
//                Cell cell = cells.next();
//                String cellType = cell.getCellType().toString();
//
//                //int cellType = cell.getCellType();
//                switch (cellType) {
//                    case "STRING":
//                        String stringValue = cell.getStringCellValue();
//                        result += stringValue + "=";
//                        break;
//                    case "NUMERIC":
//                        double doubleValue = cell.getNumericCellValue();
//                        int intValue = (int)doubleValue;
//                        result += "[" + intValue + "]";
//                        break;
//                    case "FORMULA":
//                        result += "[" + cell.getNumericCellValue() + "]";
//                        break;
//                    default:
//                        result += "|";
//                        break;
//                }
//            }
//            result += "\n";
//        }
//        return result;
//    }

    /**
     * check whether or not raw data are valid for storing
     * @param mapChainParam this is a raw chain of data from cells
     * @return true when data are need to store
     */
     static private boolean predicateIsChainValid(NumberOfSchemaReport numberOfSchemaReport, Map<Integer, CellComplexValue> mapChainParam){
         if(mapChainParam == null){
             return false;
         }else{
             SortedSet<Integer> keys = new TreeSet<Integer>(mapChainParam.keySet());
             boolean result = false;

             int i = 0;

             String aStringCurrent, aStringPrevious = "0";
             long   aLongCurrent, aLongPrevious = 0;
             double aDoubleCurrent, aDoublePrevious = 0;
             int aIntegerCurrent, aIntegerPrevious = 0;

             for(Integer iKey : keys){

                 switch (mapChainParam.get(i).typesOfCell){
                     case STRING:
                         if(mapChainParam.get(i).iamempty){
                             result = false;
                         }else {
                             try {
                                 aIntegerCurrent = Integer.parseInt(mapChainParam.get(i).aString);
                                 if(i == 0){
                                     result = aIntegerCurrent == 1? true: false;
                                 }else{
                                     result = aIntegerCurrent == aIntegerPrevious + 1? true: false;
                                 }
                                 aIntegerPrevious = aIntegerCurrent;
                             }catch (NumberFormatException nfe){
                                 result = false; // if there is no digit, predicate should return false
                             };
                         }
                         break;
                     case LONG:
                         aLongCurrent = mapChainParam.get(i).aLong;
                         if(i == 0){
                             result = aLongCurrent == 1? true: false;
                         }else{
                             if(numberOfSchemaReport == J1312002 && i < 12 ){
                                 System.out.print(i);
                                 System.out.print("; ");
                             }else if(numberOfSchemaReport == J0147105){
/*
                                 System.out.print(i);
                                 System.out.print("; ");
*/
                             }
                             result = aLongCurrent == aLongPrevious + 1? true: false;
                         }
                         aLongPrevious = aLongCurrent;
                         break;
                     case DOUBLE:
                         aDoubleCurrent = mapChainParam.get(i).aDouble;
                         if(i == 0){
                             result = aDoubleCurrent == 1? true: false;
                         }else{
                             result = aDoubleCurrent == aDoublePrevious + 1? true: false;
                         }
                         aDoublePrevious = aDoubleCurrent;
                         break;
                     default:
                         result = false;
                 }
                 if( !result) return result;
                 i++;
             }
             System.out.println();
             return result;
         }
    }

    /**
     *  Store cells in raw chain in XLSrow
     * @param mapChainParam raw chain of data, we have to store
     * @param emptyRaw structure where all cell will be stored in
     * @return true, when successful
     */
    static private boolean storeChainOfRawData(
            NumberOfSchemaReport numberOfSchemaReport,
            Map<Integer, CellComplexValue> mapChainParam,
            XLSrow emptyRaw){
        if(mapChainParam == null || emptyRaw == null){
            return false;
        }else{
            boolean result = false;

            SortedSet<Integer> keys;

            keys = new TreeSet<Integer>( mapChainParam.keySet());

            int i = 0;
            for(Integer iKey : keys){
                if(i > 0){
                    XLScell cell;
                    if(numberOfSchemaReport == J1312002){
                        switch (i){
                            case 1:
                                cell = new XLScell( XMLLABELelementTypeInTableJ1312002.T1RXXXXG2);
                                break;
                            case 2:
                                cell = new XLScell(XMLLABELelementTypeInTableJ1312002.T1RXXXXG3);
                                break;
                            case 3:
                                cell = new XLScell(XMLLABELelementTypeInTableJ1312002.T1RXXXXG4S);
                                break;
                            case 4:
                                cell = new XLScell(XMLLABELelementTypeInTableJ1312002.T1RXXXXG5);
                                break;
                            case 5:
                                cell = new XLScell(XMLLABELelementTypeInTableJ1312002.T1RXXXXG6);
                                break;
                            case 6:
                                cell = new XLScell(XMLLABELelementTypeInTableJ1312002.T1RXXXXG7S);
                                break;
                            case 7:
                                cell = new XLScell(XMLLABELelementTypeInTableJ1312002.T1RXXXXG8S);
                                break;
                            case 8:
                                cell = new XLScell(XMLLABELelementTypeInTableJ1312002.T1RXXXXG9);
                                break;
                            case 9:
                                cell = new XLScell(XMLLABELelementTypeInTableJ1312002.T1RXXXXG10);
                                break;
                            case 10:
                                cell = new XLScell(XMLLABELelementTypeInTableJ1312002.T1RXXXXG11);
                                break;
                            case 11:
                                cell = new XLScell(XMLLABELelementTypeInTableJ1312002.T1RXXXXG12S);
                                break;
                            default:
                                cell = new XLScell();
                        }
                    } else if(numberOfSchemaReport == J0147105){
                        switch (i){
                            case 1:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG2S);
                                break;
                            case 2:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG3S);
                                break;
                            case 3:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG4S);
                                break;
                            case 4:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG5S);
                                break;
                            case 5:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG6S);
                                break;
                            case 6:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG7D);
                                break;
                            case 7:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG8S);
                                break;
                            case 8:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG9S);
                                break;
                            case 9:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG10S);
                                break;
                            case 10:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG11S);
                                break;
                            case 11:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG12S);
                                break;
                            case 12:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG13S);
                                break;
                            case 13:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG14D);
                                break;
                            case 14:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG15D);
                                break;
                            case 15:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG16);
                                break;
                            case 16:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG17);
                                break;
                            case 17:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG18S);
                                break;
                            case 18:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG19S);
                                break;
                            case 19:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG20);
                                break;
                            case 20:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG21S);
                                break;
                            case 21:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG22S);
                                break;
                            case 22:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG23);
                                break;
                            case 23:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG24);
                                break;
                            case 24:
                                cell = new XLScell( XMLLABELelementTypeInTableJ0147105.T1RXXXXG25);
                                break;
                            default:
                                cell = new XLScell();
                        }
                    } else { // noschema
                        cell = new XLScell();
                    }
                    //if(!mapChainParam.get(iKey).AmIEmpty())
                    if(!mapChainParam.get(iKey).AmIEmpty() && (mapChainParam.get(iKey).typesOfCell == TypesOfCell.STRING)){
                            cell.setCellValue(mapChainParam.get(iKey).aString);
                    }else if(!mapChainParam.get(iKey).AmIEmpty() && (mapChainParam.get(iKey).typesOfCell == TypesOfCell.DOUBLE)){
                            cell.setCellValue(mapChainParam.get(iKey).aDouble.toString());
                    }else if(!mapChainParam.get(iKey).AmIEmpty() && (mapChainParam.get(iKey).typesOfCell == TypesOfCell.LONG)){
                            cell.setCellValue(mapChainParam.get(iKey).aLong.toString());
                    }else if(!mapChainParam.get(iKey).AmIEmpty() && (mapChainParam.get(iKey).typesOfCell == TypesOfCell.BOOLEAN)){
                            cell.setCellValue(mapChainParam.get(iKey).aBoolean.toString());
                    }else if(!mapChainParam.get(iKey).AmIEmpty() && (mapChainParam.get(iKey).typesOfCell == TypesOfCell.DATE)){
                            cell.setCellValue(mapChainParam.get(iKey).aDate.toString());
                    }else if(mapChainParam.get(iKey).AmIEmpty()){
                        cell.setCellValue(" ");
                    }
                        // adding new, right away created cell to row, inbound parameter of function
                    if(i == 1){
                            result = emptyRaw.add(cell);
                    }else{
                            result &=  emptyRaw.add(cell);
                    }
                }
                i++;
            }
            return result;
        }
    }

    /**
     * @param fileName
     * @param storage
     * @return
     */
    public static boolean ParseXLSXFile(NumberOfSchemaReport numberOfSchemaReport, String fileName, StorageInMemory storage) {
        boolean result = false;
        InputStream in = null;
        //HSSFWorkbook wbXLSX = null;
        XSSFWorkbook  wbXLSX = null;

        try {
            in = new FileInputStream(fileName);
            wbXLSX = new XSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }


        if (storage == null) {
            storage = new StorageInMemory(numberOfSchemaReport);
        }

        //Sheet sheet = wbXLSX.getSheetAt(0);
        Sheet sheet = wbXLSX.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();

        boolean isRawChainValid = false;

        int i = 0; // rows counter
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            XLSrow xlsRow;

            Map<Integer, CellComplexValue> rawCellsValues = new Hashtable<Integer, CellComplexValue>();

            int j = 0; // cells counter
            while (cells.hasNext()) {

                Cell cellOfRow = cells.next();
                CellComplexValue cellComplexValue;

                //int cellType = cellOfRow.getCellType();
                String cellType = cellOfRow.getCellType().toString();

                switch (cellType){
                    case "STRING":
                        String stringValue = cellOfRow.getStringCellValue();
                        cellComplexValue = new CellComplexValue(stringValue);
                        break;
                    case "DATE":
                        stringValue = cellOfRow.getStringCellValue();
                        cellComplexValue = new CellComplexValue(stringValue);
                        break;
                    case "FORMULA":
                    case "NUMERIC":
                        if(
                                (numberOfSchemaReport == J0147105 && (
                                  j == 15 || j == 16 || j == 19 || j == 22 || j == 23 || j == 24 )) ||
                                (numberOfSchemaReport == J1312002 &&
                                  (
                                     j <= 3 || j == 4 || j == 5 || j == 8 || j == 9 || j == 10  ))

                        )
                        { // strictly NUMERIC
                            double doubleValue = cellOfRow.getNumericCellValue();
                            long intValue = (long)doubleValue;
                            cellComplexValue = new CellComplexValue(intValue);
                        } else if(numberOfSchemaReport == J0147105 && ( j == 6 || j == 13 || j == 14)){
                            double doubleValue = cellOfRow.getNumericCellValue();
                            long intValue = (long)doubleValue;
                            Date dt = new Date(intValue);
                            String strV = dt.toString();
                            cellComplexValue = new CellComplexValue(strV);
                        }
                        else { // patch when false recognize as NUMERIC, however should be STRING
                            double doubleValue = cellOfRow.getNumericCellValue();
                            long intValue = (long)doubleValue;
                            Long lVal = intValue;
                            String strV = lVal.toString();
                            cellComplexValue = new CellComplexValue(strV);
                        }

                        break;
                    case "ERROR":
                    case "BLANK":
                        cellComplexValue = new CellComplexValue(new String());
                        break;
                    case "BOOLEAN":
                        cellComplexValue = new CellComplexValue(cellOfRow.getBooleanCellValue());
                        break;
                    default:
                        cellComplexValue = new CellComplexValue(cellOfRow.getDateCellValue());
                }

                rawCellsValues.put(j, cellComplexValue);
                j++; // cells counter
            }
            if(isRawChainValid){
                XLSrow newXLSRow = new XLSrow(i);
                if(i == 0){ // if there is the first row of xls file
                    result = storeChainOfRawData( numberOfSchemaReport,rawCellsValues, (newXLSRow ));
                }else{
                    result &= storeChainOfRawData( numberOfSchemaReport,rawCellsValues, (newXLSRow ));
                }
                result &= storage.storeBodyTableElement(i, newXLSRow);
                i++;
            }else{
                isRawChainValid = predicateIsChainValid(numberOfSchemaReport, rawCellsValues);
            }

        }
        return result;
    }



/*    public static boolean ParseXLSFile(String fileName, StorageInMemory storage){

        boolean result = false;
        InputStream in = null;
        HSSFWorkbook wb = null;
        try {
            in = new FileInputStream(fileName);
            wb = new HSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }


        if (storage == null) {
            storage = new StorageInMemory();
        }

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();

        boolean isRawChainValid = false;

        int i = 0; // rows counter
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            XLSrow xlsRow;

            Map<Integer, CellComplexValue> rawCellsValues = new Hashtable<Integer, CellComplexValue>();

            int j = 0; // cells counter
            while (cells.hasNext()) {

                Cell cellOfRow = cells.next();
                CellComplexValue cellComplexValue;

                //int cellType = cellOfRow.getCellType();
                String cellType = cellOfRow.getCellType().toString();

                switch (cellType){
                    case "STRING":
                        String stringValue = cellOfRow.getStringCellValue();
                        cellComplexValue = new CellComplexValue(stringValue);
                        break;
                    case "FORMULA":
                    case "NUMERIC":
                        double doubleValue = cellOfRow.getNumericCellValue();
                        long intValue = (int)doubleValue;
                        cellComplexValue = new CellComplexValue(intValue);
                        break;
                    case "ERROR":
                    case "BLANK":
                        cellComplexValue = new CellComplexValue(new String());
                        break;
                    case "BOOLEAN":
                        cellComplexValue = new CellComplexValue(cellOfRow.getBooleanCellValue());
                        break;
                    default:
                        cellComplexValue = new CellComplexValue(cellOfRow.getDateCellValue());
                }


                rawCellsValues.put(j, cellComplexValue);
                j++; // cells counter
            }
            if(isRawChainValid){
                XLSrow newXLSRow = new XLSrow(i);
                if(i == 0){
                    result = storeChainOfRawData(rawCellsValues, (newXLSRow ));
                }else{
                    result &= storeChainOfRawData(rawCellsValues, (newXLSRow ));
                }
                result &= storage.storeBodyTableElement(i, newXLSRow);
                i++;
            }else{
                isRawChainValid = predicateIsChainValid(rawCellsValues);
            }

        }
        return result;

    }*/


}
