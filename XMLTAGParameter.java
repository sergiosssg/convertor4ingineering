package XMLhandler;

public interface XMLTAGParameter extends XMLElement {
    String getName();

    void setName(String name);

    XMLElement getValue();

    void setValue(XMLElement value);

    boolean isValueAText();
}
