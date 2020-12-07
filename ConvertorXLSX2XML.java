import XMLhandler.DECLAR;
import XMLhandler.ExmlComposer;
import XMLhandler.NumberOfSchemaReport;
import XMLhandler.StorageInMemory;
import parser.EParser;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * point of start and UI functions and
 * store also what schema number will be performed
 */

public class ConvertorXLSX2XML implements WindowListener {
    private JFrame mainFrame;
    private boolean isAnyParameterChanged;
    private String[] orderedArrayOfKeys;      // array of keys for reading and writing DECLAR properties
    private Properties settingsForDeaclarStrings;
    private Map<String, String> headElements;
    private Map<String, String> bodyElements1;
    private Map<String, String> bodyElements2;
    private JFrame frame;
    private JFileChooser jfc;
    private JPanel pnlContainer;
    private JPanel pnlCenter;
    private JPanel pnlStatus;
    private JPanel pnlContent1;
    private JPanel pnlStatus01;
    private JPanel pnlStatus02;
    private JPanel pnlStatus03;
    private JPanel pnlContent12;
    private JLabel lbl01;
    private JButton btnExcelFileChooser;
    private JLabel lbl02;
    private JButton btnProcess4Excel;
    private JLabel lblStatus4ExcelReading;
    private JLabel lblStatus02;
    private JLabel lblStatus03;
    private JTabbedPane tabPane01;
    private JPanel pnl4XLSImport;
    private JPanel pnl4XMLParser;
    private JPanel pnlContent11;
    private JButton btnXMLFileChooser;
    private JButton btnParseXML;
    private JPanel pnl4HeaderDialog;
    private JPanel pnlContent3;
    private JTextField tfTIN;
    private JTextField tfC_DOC;
    private JTextField tfC_DOC_SUB;
    private JTextField tfPERIOD_MONTH;
    private JTextField tfPERIOD_YEAR;
    private JTextField tfD_FILL;
    private JTextField tfHSTI;
    private JTextField tfHTIN;
    private JTextField tfHNAME;
    private JTextField tfHBOS;
    private JTextField tfHFILL;
    private JComboBox cbPERIOD_TYPE;
    private JComboBox<NumberOfSchemaReport> cmbDocTypeNumber;

    private String _excelFileName;
    private String _XMLFileName;
    private boolean _excelFileChoosen;
    private boolean _XMLFileChoosen;

    private NumberOfSchemaReport _numberOfSchemaReport; // номер схемы для отчёта
    private StorageInMemory storageInMemory;

    public ConvertorXLSX2XML() {
        initClass();
    } // ConvertorXLSX2XML(...

    public ConvertorXLSX2XML(JFrame frame) {
        this.mainFrame = frame;
        mainFrame.addWindowListener(this);
        initClass();
    } // ConvertorXLSX2XML(...

    static public void main(String[] args) {
        JFrame frame_ = new JFrame("Excell file chooser");


        frame_.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame_.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        frame_.setContentPane(createContainer(frame_));
        //frame_.addWindowListener(this);
        frame_.pack();

        frame_.setVisible(true);
    } // main (...

    private static JPanel createContainer(JFrame frame) {
        ConvertorXLSX2XML convertorXLSX2XML__ = new ConvertorXLSX2XML(frame);
        return convertorXLSX2XML__.pnlContainer;
    }  // createContainer(...

    private void initClass() {
        isAnyParameterChanged = false;

        //  these strokes to be replaced by function initializeFieldsAtStarting

        settingsForDeaclarStrings = new Properties();

        headElements = new LinkedHashMap<String, String>();
        bodyElements1 = new LinkedHashMap<String, String>();
        bodyElements2 = new LinkedHashMap<String, String>();

        try {
            orderedArrayOfKeys = getSortedOrderedArrayOfKeys4Property("proto_config.ini"); // array of keys for reading and writing DECLAR properties
            _numberOfSchemaReport = prepareDeclarSettings("config.ini", settingsForDeaclarStrings);

            if (_numberOfSchemaReport != NumberOfSchemaReport.noschema) {
                for (String oneHeadString : orderedArrayOfKeys) {
                    String keyString = oneHeadString.substring(5);
                    if (oneHeadString.contains("HEAD")) {
                        headElements.put(keyString, settingsForDeaclarStrings.getProperty(oneHeadString));
                    } else if (oneHeadString.contains("BODY") && (oneHeadString.contains("HSTI") || oneHeadString.contains("HTIN") || oneHeadString.contains("HNAME"))) {
                        bodyElements1.put(keyString, settingsForDeaclarStrings.getProperty(oneHeadString));
                    } else if (oneHeadString.contains("BODY") && (oneHeadString.contains("HBOS") || oneHeadString.contains("HFILL"))) {
                        bodyElements2.put(keyString, settingsForDeaclarStrings.getProperty(oneHeadString));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Then I iterate on previous set order on arrayOfOrderOfStrings array

        /**
         *
         *
         * @// TODO: 28.02.2020
         */
        jfc = new JFileChooser();

        ////////////////////////
        btnExcelFileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File xlsxFilePath;

                jfc.setCurrentDirectory(new File("C;/"));

                jfc.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        return f.isDirectory() ||
                                f.getName().toLowerCase().endsWith(".xlsx");
                    }

                    @Override
                    public String getDescription() {
                        return "Excel Files";
                    }
                });

                int result = jfc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    xlsxFilePath = jfc.getSelectedFile();

                    if (xlsxFilePath.exists() && xlsxFilePath.canRead()) {
                        _excelFileChoosen = true;
                        _excelFileName = xlsxFilePath.getPath();
                        btnProcess4Excel.setEnabled(true);
                    }
                }
            }
        });
        ////////////////////////
        // proceed conversion from XLS file to XML file
        ////////////////////////
        btnProcess4Excel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isParsedOK = false;
                //storageInMemory = new XMLhandler.StorageInMemory();

                if (headElements.size() > 14 && bodyElements1.size() >= 2 && bodyElements2.size() > 1) {
                    storageInMemory = new StorageInMemory(_numberOfSchemaReport, headElements, bodyElements1, bodyElements2);
                } else if (headElements.size() > 14) {
                    storageInMemory = new StorageInMemory(_numberOfSchemaReport, headElements);
                } else {
                    storageInMemory = new StorageInMemory(_numberOfSchemaReport);
                }

                isParsedOK = EParser.ParseXLSXFile(_numberOfSchemaReport, _excelFileName, storageInMemory);
                if (isParsedOK) {
                    jfc.setCurrentDirectory(new File("C;/"));
                    jfc.setFileFilter(new FileFilter() {
                        @Override
                        public boolean accept(File f) {
                            return f.isDirectory() ||
                                    f.getName().toLowerCase().endsWith(".xml");
                        }

                        @Override
                        public String getDescription() {
                            return "XML Files";
                        }
                    });

                    switch (_numberOfSchemaReport) {
                        case J1312002:
                            StorageInMemory storage = storageInMemory;
                            int iRowCount = storage.getHowMuchRowsInBodyTable();
                            /**
                             *  пока временно, по умолчанию обрабатываем схему J1312002
                             */
                            DECLAR xmlDocument = ExmlComposer.make_all_document(_numberOfSchemaReport, storage);
                            String proposedFileName = DECLAR.makingFileName(storage.getHeadElements());
                            jfc.setSelectedFile(new File(proposedFileName));
                            int result = jfc.showSaveDialog(null);
                            if (result == JFileChooser.APPROVE_OPTION) {
                                File file = jfc.getCurrentDirectory();
                                String dirString = file.toString();
                                if (!dirString.endsWith(File.pathSeparator)) {
                                    dirString += File.separator;
                                }
                                xmlDocument = ExmlComposer.composeXMLFileName(xmlDocument, storage);
                                xmlDocument.setXMLDirectory(dirString);
                            }
                            ExmlComposer.writeDocumentIntoXMLFile(xmlDocument);
                            lblStatus4ExcelReading.setText("\"" + _excelFileName + "\"" + ", " + iRowCount + " rows in table added");
                            break;
                        case J0147105:
                            break;
                        case noschema:
                        default:
                    }
                }
            }
        });

        this.initializeFieldsForSettingsEditor();
        ////////////////////////
        tfTIN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                headElements.put("TIN", tfTIN.getText());

                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        tfTIN.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String changedValue = tfTIN.getText();
                String etalonValue = headElements.get("TIN");
                if (etalonValue.equals(changedValue)) {
                    headElements.put("TIN", tfTIN.getText());
                    isAnyParameterChanged = true;
                }
            }
        });
        ////////////////////////
        tfC_DOC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                headElements.put("C_DOC", tfC_DOC.getText());

                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        tfC_DOC.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String changedValue = tfC_DOC.getText();
                String etalonValue = headElements.get("C_DOC");
                if (!etalonValue.equals(changedValue)) {
                    headElements.put("C_DOC", tfC_DOC.getText());
                    isAnyParameterChanged = true;
                }
            }
        });
        ////////////////////////
        tfC_DOC_SUB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                headElements.put("C_DOC_SUB", tfC_DOC_SUB.getText());

                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        tfC_DOC_SUB.addFocusListener(new FocusAdapter() {
            /**
             * Invoked when a component loses the keyboard focus.
             *
             * @param e
             */
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String changedValue = tfC_DOC_SUB.getText();
                String etalonValue = headElements.get("C_DOC_SUB");
                if (!etalonValue.equals(changedValue)) {
                    headElements.put("C_DOC_SUB", tfC_DOC_SUB.getText());
                    isAnyParameterChanged = true;
                }
            }
        });
        ////////////////////////
        tfPERIOD_MONTH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                headElements.put("PERIOD_MONTH", tfPERIOD_MONTH.getText());

                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        tfPERIOD_MONTH.addFocusListener(new FocusAdapter() {
            /**
             * Invoked when a component loses the keyboard focus.
             *
             * @param e
             */
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String changedValue = tfPERIOD_MONTH.getText();
                String etalonValue = headElements.get("C_PERIOD_MONTH");
                if (!etalonValue.equals(changedValue)) {
                    headElements.put("C_PERIOD_MONTH", tfPERIOD_MONTH.getText());
                    isAnyParameterChanged = true;
                }
            }
        });
        ////////////////////////
        tfPERIOD_YEAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                headElements.put("PERIOD_YEAR", tfPERIOD_YEAR.getText());

                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        tfPERIOD_YEAR.addFocusListener(new FocusAdapter() {
            /**
             * Invoked when a component loses the keyboard focus.
             *
             * @param e
             */
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String changedValue = tfPERIOD_YEAR.getText();
                String etalonValue = headElements.get("PERIOD_YEAR");
                if (!etalonValue.equals(changedValue)) {
                    headElements.put("PERIOD_YEAR", tfPERIOD_YEAR.getText());
                    isAnyParameterChanged = true;
                }
            }
        });
        ////////////////////////
        tfD_FILL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                headElements.put("D_FILL", tfD_FILL.getText());

                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        tfD_FILL.addFocusListener(new FocusAdapter() {
            /**
             * Invoked when a component loses the keyboard focus.
             *
             * @param e
             */
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String changedValue = tfD_FILL.getText();
                String etalonValue = headElements.get("D_FILL");
                if (!etalonValue.equals(changedValue)) {
                    headElements.put("D_FILL", tfD_FILL.getText());
                    isAnyParameterChanged = true;
                }
            }
        });
        ////////////////////////
        tfHSTI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bodyElements1.put("HSTI", tfHSTI.getText());

                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        tfHSTI.addFocusListener(new FocusAdapter() {
            /**
             * Invoked when a component loses the keyboard focus.
             *
             * @param e
             */
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String changedValue = tfHSTI.getText();
                String etalonValue = bodyElements1.get("HSTI");
                if (!etalonValue.equals(changedValue)) {
                    bodyElements1.put("HSTI", tfHSTI.getText());
                    isAnyParameterChanged = true;
                }
            }
        });
        ////////////////////////
        tfHTIN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bodyElements1.put("HTIN", tfHTIN.getText());

                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        tfHTIN.addFocusListener(new FocusAdapter() {
            /**
             * Invoked when a component loses the keyboard focus.
             *
             * @param e
             */
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String changedValue = tfHTIN.getText();
                String etalonValue = bodyElements1.get("HTIN");
                if (!etalonValue.equals(changedValue)) {
                    bodyElements1.put("HTIN", tfHTIN.getText());
                    isAnyParameterChanged = true;
                }
            }
        });
        ////////////////////////
        tfHNAME.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                bodyElements1.put("HNAME", tfHNAME.getText());

                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        tfHNAME.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String changedValue = tfHNAME.getText();
                String etalonValue = bodyElements1.get("HNAME");
                if (!etalonValue.equals(changedValue)) {
                    bodyElements1.put("HNAME", tfHNAME.getText());
                    isAnyParameterChanged = true;
                }
            }
        });
        ////////////////////////
        tfHBOS.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                bodyElements2.put("HBOS", tfHBOS.getText());

                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        tfHBOS.addFocusListener(new FocusAdapter() {
            /**
             * Invoked when a component loses the keyboard focus.
             *
             * @param e
             */
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String changedValue = tfHBOS.getText();
                String etalonValue = bodyElements2.get("HBOS");
                if (!etalonValue.equals(changedValue)) {
                    bodyElements2.put("HBOS", tfHBOS.getText());
                    isAnyParameterChanged = true;
                }
            }
        });
        ////////////////////////
        tfHFILL.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                bodyElements2.put("HFILL", tfHFILL.getText());

                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        tfHFILL.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String changedValue = tfHFILL.getText();
                String etalonValue = bodyElements2.get("HFILL");
                if (!etalonValue.equals(changedValue)) {
                    bodyElements2.put("HFILL", tfHFILL.getText());
                    isAnyParameterChanged = true;
                }
            }
        });
        ////////////////////////
        cbPERIOD_TYPE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (cbPERIOD_TYPE.getSelectedIndex()) {
                    case 0:
                        headElements.put("PERIOD_TYPE", "1");
                        break;
                    case 1:
                        headElements.put("PERIOD_TYPE", "2");
                        break;
                    case 2:
                        headElements.put("PERIOD_TYPE", "3");
                        break;
                    case 3:
                        headElements.put("PERIOD_TYPE", "4");
                        break;
                    case 4:
                        headElements.put("PERIOD_TYPE", "5");
                        break;
                    default:
                }
                isAnyParameterChanged = true;
            }
        });
        ////////////////////////
        cmbDocTypeNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NumberOfSchemaReport choiceFromComboBox = (NumberOfSchemaReport) cmbDocTypeNumber.getSelectedItem();
                if (choiceFromComboBox != _numberOfSchemaReport) {
                    _numberOfSchemaReport = choiceFromComboBox;
                    isAnyParameterChanged = true;
                }
            }
        });
    } // initClass(...

    /**
     * @param fileNameProps
     * @param settingsForDeclarStrings
     * @return
     */
    private NumberOfSchemaReport prepareDeclarSettings(String fileNameProps, Properties settingsForDeclarStrings) throws IOException {
        NumberOfSchemaReport retNumberOfSchemaReport;

        settingsForDeclarStrings.load(new FileReader(fileNameProps));
        String strNumberOfSchemaReport = settingsForDeclarStrings.getProperty("TYPE.DOCNUMBER");
        if (strNumberOfSchemaReport.compareToIgnoreCase("J1312002") == 0) {
            retNumberOfSchemaReport = NumberOfSchemaReport.J1312002;
        } else if (strNumberOfSchemaReport.compareToIgnoreCase("J0147105") == 0) {
            retNumberOfSchemaReport = NumberOfSchemaReport.J0147105;
        } else {
            retNumberOfSchemaReport = NumberOfSchemaReport.noschema;
        }

        return retNumberOfSchemaReport;
    } // prepareDeclarSettings(...

    /**
     * @// TODO: 30.09.2020
     */
    private void initializeFieldsAtStarting() {

    }


    /**
     * fills all fields of GUI form according elements names
     * reading from heading elements, and from several body elements
     * in private class members
     */
    private void initializeFieldsForSettingsEditor() {

        Set<String> setOfSettingNames = headElements.keySet();

        cmbDocTypeNumber.addItem(NumberOfSchemaReport.noschema);
        cmbDocTypeNumber.addItem(NumberOfSchemaReport.J0147105);
        cmbDocTypeNumber.addItem(NumberOfSchemaReport.J1312002);


        if (_numberOfSchemaReport == NumberOfSchemaReport.J1312002) {
            cmbDocTypeNumber.setSelectedItem(NumberOfSchemaReport.J1312002);
        } else if (_numberOfSchemaReport == NumberOfSchemaReport.J0147105) {
            cmbDocTypeNumber.setSelectedItem(NumberOfSchemaReport.J0147105);
        } else {
            cmbDocTypeNumber.setSelectedItem(NumberOfSchemaReport.noschema);
        }

        for (String oneSettingName : setOfSettingNames) {
            switch (oneSettingName) {
                case "TIN":
                    tfTIN.setText(headElements.get(oneSettingName));
                    break;
                case "C_DOC":
                    tfC_DOC.setText(headElements.get(oneSettingName));
                    break;
                case "C_DOC_SUB":
                    tfC_DOC_SUB.setText(headElements.get(oneSettingName));
                    break;
                case "PERIOD_MONTH":
                    tfPERIOD_MONTH.setText(headElements.get(oneSettingName));
                    break;
                case "PERIOD_TYPE":

                    String str_PERIOD_TYPE_value = headElements.get(oneSettingName);

                    switch (str_PERIOD_TYPE_value) {
                        case "1":
                            cbPERIOD_TYPE.setSelectedIndex(0);
                            break;
                        case "2":
                            cbPERIOD_TYPE.setSelectedIndex(1);
                            break;
                        case "3":
                            cbPERIOD_TYPE.setSelectedIndex(2);
                            break;
                        case "4":
                            cbPERIOD_TYPE.setSelectedIndex(3);
                            break;
                        case "5":
                            cbPERIOD_TYPE.setSelectedIndex(4);
                            break;
                        default:
                    }

                    //.setText(oneSettingName);
                    break;
                case "PERIOD_YEAR":
                    tfPERIOD_YEAR.setText(headElements.get(oneSettingName));
                    break;
                case "D_FILL":
                    tfD_FILL.setText(headElements.get(oneSettingName));
                    break;
                default:
            }
        }

        setOfSettingNames = bodyElements1.keySet();
        for (String oneSettingName : setOfSettingNames) {
            switch (oneSettingName) {
                case "HSTI":
                    tfHSTI.setText(bodyElements1.get(oneSettingName));
                    break;
                case "HTIN":
                    tfHTIN.setText(bodyElements1.get(oneSettingName));
                    break;
                case "HNAME":
                    tfHNAME.setText(bodyElements1.get(oneSettingName));
                    break;
                default:
            }
        }

        setOfSettingNames = bodyElements2.keySet();
        for (String oneSettingName : setOfSettingNames) {
            switch (oneSettingName) {
                case "HBOS":
                    tfHBOS.setText(bodyElements2.get(oneSettingName));
                    break;
                case "HFILL":
                    tfHFILL.setText(bodyElements2.get(oneSettingName));
                    break;
                default:
            }
        }
    } // initializeFieldsForSettingsEditor(...


    /**
     * performs making properties map
     * before storing it in certain file
     *
     * @return
     */
    private Properties prepareMapForSavingSettingPropertiesToStoreInFile() {
        Properties propertiesToStoreInFile = new Properties();

        try {
            orderedArrayOfKeys = getSortedOrderedArrayOfKeys4Property("proto_config.ini");

            // at first I initialize array of keys by ascending on order, they were stored in property file
            //String _strTemporaryNumberOfSchemaReport =
            //_numberOfSchemaReport = NumberOfSchemaReport.noschema; // номер схемы для отчёта, временно для начала нет схемы
            if (_numberOfSchemaReport == NumberOfSchemaReport.J1312002) {
                propertiesToStoreInFile.setProperty("TYPE.DOCNUMBER", "J1312002");
            } else if (_numberOfSchemaReport == NumberOfSchemaReport.J0147105) {
                propertiesToStoreInFile.setProperty("TYPE.DOCNUMBER", "J0147105");
            } else if (_numberOfSchemaReport == NumberOfSchemaReport.noschema) {
                propertiesToStoreInFile.setProperty("TYPE.DOCNUMBER", "noschema");
                // do nothing and ask valid schema number
            }

            for (String oneHeadString : orderedArrayOfKeys) {
                String pureOneHeadString = oneHeadString.substring(5);
                if (pureOneHeadString.equals("HSTI") ||
                        pureOneHeadString.equals("HTIN") ||
                        pureOneHeadString.equals("HNAME")) {
                    String strValueFromBodyElements1 = bodyElements1.get(pureOneHeadString);
                    if (strValueFromBodyElements1 != null && !strValueFromBodyElements1.isEmpty()) {
                        propertiesToStoreInFile.setProperty(oneHeadString, strValueFromBodyElements1);
                    }
                } else if (pureOneHeadString.equals("HBOS") || pureOneHeadString.equals("HFILL")) {
                    String strValueFromBodyElements2 = bodyElements2.get(pureOneHeadString);
                    if (strValueFromBodyElements2 != null && !strValueFromBodyElements2.isEmpty()) {
                        propertiesToStoreInFile.setProperty(oneHeadString, strValueFromBodyElements2);
                    }
                } else if (!pureOneHeadString.equals("LINKED_DOCS") && !pureOneHeadString.equals("SOFTWARE")) {
                    String strValueFromHeadElements = headElements.get(pureOneHeadString);
                    if (strValueFromHeadElements != null && !strValueFromHeadElements.isEmpty()) {
                        propertiesToStoreInFile.setProperty(oneHeadString, strValueFromHeadElements);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return propertiesToStoreInFile;
    } // prepareMapForSavingSettingPropertiesToStoreInFile(...

    private void storePropertiesInFile(Properties propertiesToStore) throws IOException {
        Writer propWriter = null;
        File fileToWrite = new File("config.ini");
        if (fileToWrite.exists()) {
            fileToWrite.delete();
        }
        propWriter = new FileWriter(fileToWrite);
        //propertiesToStore.store(propWriter );
        propertiesToStore.store(propWriter, "");
    } // storePropertiesInFile(...

    private void storePropertiesOnExit() {
        if (isAnyParameterChanged) {
            try {
                Properties prop = prepareMapForSavingSettingPropertiesToStoreInFile();
                storePropertiesInFile(prop);
            } catch (IOException ex) {
                System.err.println(ex.getStackTrace());
                System.err.println("==============");
                System.err.println(ex.getCause());
            }
        }
    } // storePropertiesOnExit(...

    /**
     * Before fetch
     *
     * @param fileName
     * @return sorted array of key names
     */
    private String[] getSortedOrderedArrayOfKeys4Property(String fileName) throws IOException { //"proto_config.ini"  on default
        String[] arrayOfOrderOfStrings;

        int amountOfelements;

        Properties settingsForOrderOfStringsInSettings = new Properties();
        settingsForOrderOfStringsInSettings.load(new FileReader(fileName));
        amountOfelements = settingsForOrderOfStringsInSettings.size();
        arrayOfOrderOfStrings = new String[settingsForOrderOfStringsInSettings.size() - 1];

        for (int i = 1; i < amountOfelements; i++) {
            arrayOfOrderOfStrings[i - 1] = settingsForOrderOfStringsInSettings.getProperty("" + (i - 1));
        }
        return arrayOfOrderOfStrings;
    } // getSortedOrderedArrayOfKeys4Property(...

    @Override
    public void windowOpened(WindowEvent e) {
    } // windowOpened(...

    @Override
    public void windowClosing(WindowEvent e) {
        //System.out.println("  I exit from window --->" );
        storePropertiesOnExit();
    } // windowClosing(...

    @Override
    public void windowClosed(WindowEvent e) {
    } // windowClosed(...

    @Override
    public void windowIconified(WindowEvent e) {
    } // windowIconified(...

    @Override
    public void windowDeiconified(WindowEvent e) {
    } // windowDeiconified(...

    @Override
    public void windowActivated(WindowEvent e) {
    } // windowActivated(...

    @Override
    public void windowDeactivated(WindowEvent e) {
    } // windowDeactivated(...
} // class ConvertorXLSX2XML ...
