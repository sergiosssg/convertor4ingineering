package parser;

import XMLhandler.XMLLABELelementType;
import XMLhandler.XMLLABELelementTypeInTableJ1312002;

import java.util.*;

public class XLSrow{

    private Integer rowIndex;

    private int howMuch;

    private Map<XMLLABELelementType, XLScell> rowOfCells;



    public XLSrow() {
        this.rowIndex = -1;
        this.rowOfCells = new HashMap<>();
        this.howMuch = 0;
    }


    public XLSrow(Integer rowIndex) {
        this.rowIndex = rowIndex;
        this.rowOfCells = new HashMap<>();;
        this.howMuch = 0;
    }


    /**
     *
     * @return Returns true if both Rows contain same elements
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(!obj.getClass().getName().equals("XLSrow")){
            return false;
        }
        XLSrow row = (XLSrow) obj;
        if(row.isEmpty() || this.isEmpty()){
            return false;
        }
        boolean result = false;
        Set<XMLLABELelementType> keysObj = row.rowOfCells.keySet();

        for(XMLLABELelementType oneKeyObj : keysObj){
            if(this.rowOfCells.containsKey(oneKeyObj)){
                XLScell cellThis = this.rowOfCells.get(oneKeyObj);
                XLScell cellObj = row.rowOfCells.get(oneKeyObj);
                String cellStringValueThis = cellThis.getCellValue();
                String cellStringValueObj = cellObj.getCellValue();
                if(!cellStringValueThis.equals(cellStringValueObj)){
                    result = false;
                    return result;
                }else{
                    result = true;
                }
            }
        }
        return result;
    }


    /**
     * Returns the number of elements in this collection.  If this collection
     * contains more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this collection
     */
    public int size() {
        return this.howMuch;
    }

    /**
     * Returns {@code true} if this collection contains no elements.
     *
     * @return {@code true} if this collection contains no elements
     */
    public boolean isEmpty() {
        if(this.howMuch == 0)
            return true;
        return false;
    }

    /**
     * Returns {@code true} if this collection contains the specified element.
     * More formally, returns {@code true} if and only if this collection
     * contains at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param o element whose presence in this collection is to be tested
     * @return {@code true} if this collection contains the specified
     * element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this collection
     *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *                              collection does not permit null elements
     *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    public boolean contains(Object o) {
        if(o == null || !o.getClass().getName().equals("XLScell")){ return false; }
        XLScell objCell = (XLScell) o;

        XMLLABELelementType key = objCell.getCellKey();
        if(this.rowOfCells.containsKey(key)){
             XLScell thisCell = this.rowOfCells.get(key);

             return thisCell.equals(objCell);
        }
        return false;
    }

    /**
     * Returns an array containing all of the elements in this collection.
     * If this collection makes any guarantees as to what order its elements
     * are returned by its iterator, this method must return the elements in
     * the same order. The returned array's {@linkplain Class#getComponentType
     * runtime component type} is {@code Object}.
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this collection.  (In other words, this method must
     * allocate a new array even if this collection is backed by an array).
     * The caller is thus free to modify the returned array.
     *
     * @return an array, whose {@linkplain Class#getComponentType runtime component
     * type} is {@code Object}, containing all of the elements in this collection
     * @apiNote This method acts as a bridge between array-based and collection-based APIs.
     * It returns an array whose runtime type is {@code Object[]}.
     * Use {@link #toArray(Object[]) toArray(T[])} to reuse an existing
     * array, or use {@link #toArray(IntFunction)} to control the runtime type
     * of the array.
     */
    public Object[] toArray() {
        /*Object[] objectArray = new Object[this.howMuch];*/
        XLScell[] objectArray = new XLScell[this.howMuch];
        if(!this.isEmpty()){
            int iArrayIndex = 0;

            Set<XMLLABELelementType> keys = this.rowOfCells.keySet();
            for(XMLLABELelementType oneKey : keys){
                objectArray[iArrayIndex++] = this.rowOfCells.get(oneKey);
            }
        }
        return (Object[]) objectArray;
    }



    public boolean add(XLScell cell){
        if(cell != null){
            XMLLABELelementType elementType = cell.getCellKey();
            this.rowOfCells.put(elementType, cell);
            this.howMuch++;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Removes a single instance of the specified element from this
     * collection, if it is present (optional operation).  More formally,
     * removes an element {@code e} such that
     * {@code Objects.equals(o, e)}, if
     * this collection contains one or more such elements.  Returns
     * {@code true} if this collection contained the specified element (or
     * equivalently, if this collection changed as a result of the call).
     *
     * @param o element to be removed from this collection, if present
     * @return {@code true} if an element was removed as a result of this call
     * @throws ClassCastException            if the type of the specified element
     *                                       is incompatible with this collection
     *                                       (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if the specified element is null and this
     *                                       collection does not permit null elements
     *                                       (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws UnsupportedOperationException if the {@code remove} operation
     *                                       is not supported by this collection
     */
    public boolean remove(Object o) {
        if(o != null  && o.getClass().getName().equals("XLScell") && !this.isEmpty()){
            if(this.rowOfCells.containsKey(o)){
                    this.rowOfCells.remove(o);
                    this.howMuch--;
                    return true;
            }
        }
        return false;
    }



    /**
     * Removes all of the elements from this collection (optional operation).
     * The collection will be empty after this method returns.
     *
     * @throws UnsupportedOperationException if the {@code clear} operation
     *                                       is not supported by this collection
     */
    public void clear() {
        this.rowOfCells.clear();
        this.howMuch = 0;
    }

    public XLScell getCell(XMLLABELelementTypeInTableJ1312002 type){
        if(this.rowOfCells.containsKey(type)){
            XLScell cell = this.rowOfCells.get(type);
            return cell;
        }
        return null;
    }

    public String getStringValue(XMLLABELelementTypeInTableJ1312002 type){
        if(this.rowOfCells.containsKey(type)){
            XLScell cell = this.rowOfCells.get(type);
            String cellStringValue = cell.getCellValue();
            return cellStringValue;
        }
        return null;
    }

    public void setRowIndex(int rowIndex){
        this.rowIndex = rowIndex;
    }
    public int getRowIndex(){
        return this.rowIndex;
    }
}
