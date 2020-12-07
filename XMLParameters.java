package XMLhandler;

import java.util.LinkedHashMap;
import java.util.Map;

public class XMLParameters implements XMLTAGParameter {
    private final Map<String, XMLTAGParameter> parameters;


    public XMLParameters() {
        parameters = new LinkedHashMap<>();
    }


    public XMLParameters(XMLTAGParameter parameter) {
        parameters = new LinkedHashMap<>();
        this.addNewParameter(parameter);
    }

    public XMLParameters(XMLTAGParameter[] arrayOfParameters) {
        this.parameters = new LinkedHashMap<>();
        for (XMLTAGParameter param : arrayOfParameters) {
            this.addNewParameter(param);
        }
    }

    public void addNewParameter(XMLTAGParameter parameter) {
        if (parameter != null && parameter.getClass().getName().equals("XMLSimpleParameter")) {
            parameters.put(parameter.getName(), parameter);
        } else if (parameter != null && parameter.getClass().getName().equals("XMLParameters")) {
            /**
             *
             *
             * @// TODO: 24.02.2020  
             */
        }
    }

    public void addNewParameter(String parameterName, String parameterValue) {
        this.addNewParameter(new XMLSimpleParameter(parameterName, parameterValue));
    }

    public boolean isExistsSuchParameter(String name) {
        return parameters.containsKey(name);
    }

    public String[] getNamesOfAllParameters() {

        return (String[]) parameters.keySet().toArray();
    }


    public String getValueOfParameter(String name) {
        if (this.isExistsSuchParameter(name)) {
            return parameters.get(name).getValue().toString();
        } else {
            return "";
        }
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public XMLElement getContent() {
        return this;
    }

    @Override
    public XMLElement getValue() {
        return null;
    }

    @Override
    public void setValue(XMLElement value) {

    }

    @Override
    public boolean isValueAText() {
        return false;
    }
}
