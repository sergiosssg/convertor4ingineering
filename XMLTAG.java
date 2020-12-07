package XMLhandler;

public interface XMLTAG extends XMLContent {

    XMLTAG getParent();

    void setParent(XMLTAG tag);

    void addNewTag(XMLTAG tag);

    int howMuchChildrenIHave();

    XMLTAG getChildByName(String name);

    boolean hasSuchTagByName(String name);

}
