/*import java.util.Arrays;



public class EA{
    int size = 5;
    int [] array;


    public EA(){
     this(size);
    }
    public EA(int size){
        int count = 0;
        array = new int[size];
    }
    public EA(int [] array){


    }


    public void put(int element){
        ensureCapacity(this.size+1);
        array[this.size++] = element;
    }
    public void ensureCapacity(int minCapacity){
        int oldCapacity=array.length;
        if(minCapacity > oldCapacity){
            int newCapacity = oldCapacity * 2;
            if(newCapacity < minCapacity){
                newCapacity = minCapacity;
            }
                    array = Arrays.copyOf(array, newCapacity);
        }
    }

/*
public class EA {
    int [] data;
    int size;
    public EA(){
        size = 1;
        data = new int[size];
    }

    public EA(int firstElement){
        EA newEA = new EA();
        newEA.put(firstElement);
    }

    public int getSize(){
        return data.length;
    }

    public int get(int index){
        return data[index];
    }

    public void put(int element){
         ensureCapacity(size+1);
         data[size++] = element;
    }

    public void ensureCapacity(int minCapacity){
        int oldCapacity=data.length;
        if(minCapacity > oldCapacity){
            int newCapacity = oldCapacity * 2;
            if(newCapacity < minCapacity){
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }
   /* public void searchElement(int index){
        for (int i = 0; i < ;i++)


}*/



import com.sun.istack.internal.NotNull;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * THis class emplements EndlessArray
 */
public class EA {
    /**
     * Field indexes start size if you use empty constructor
     */
    private static final int SIZE_ARRAY = 5;
    /**
     *Field implements size
     */
    private int size;
    /**
     *Field impelements array
     */
    private int[] array;

    /**
     * Empty constructor
     */
    public EA() {
        this(SIZE_ARRAY);
    }

    /**
     * Constructor with users size
     * @param sizeArray start size
     */
    public EA(int sizeArray){
        this.array = new int[sizeArray];
    }
    /*public EA(@NotNull int [] firstarray){
        for (int i = 0; i < firstarray.length; i++){
            EA.put(firstarray[i]);
        }
    }
*/

    /**
     * Constructor with array of first elements
     * @param firstElements array of first elements
     */
    public EA(@NotNull int[] firstElements) {
        arraycopy(firstElements,0, array, 0, firstElements.length);
    }

    /**
     * Add new element
     * @param a
     * @throws
     */
    public void put(int a) throws IndexOutOfSizeException {
        if (size == array.length - 1){
            this.extendArray(array.length*(2-1));
        }
        this.setElement(size, a);
        size++;
    }

    /**
     * extend field old array
     * @param l
     */
    public void extendArray(int l){
        array = Arrays.copyOf(array, l+array.length);
    }

    /**
     * set new element
     * @param index
     * @param a
     * @throws IndexOutOfSizeException
     */
    public void setElement(int index, int a) throws IndexOutOfSizeException{
        if(index <= size) {
            this.array[index] = a;
        } else {
            throw new IndexOutOfSizeException("number is larger than the size of the array");
        }
    }

    /**
     * remove element from array
     * @param index
     */
    public void removeElement(int index){
        for (int i = index; i < size-1; i++){
            this.array[i] = this.array[i + 1];
        }
        size--;
    }

    /**
     * get element witn this index
     * @param index
     * @return
     */
    public int getElement(int index){
        return this.array[index];
    }

    /**
     * Search element
     * @param a
     * @return
     */
    public int indexOf(int a){
        return this.indexOf(a,0);
    }

    /**
     *search for an item from a given position
     * @param a
     * @param firstIndex
     * @return
     */
    public int indexOf(int a, int firstIndex){
        for (int i = firstIndex; i < size; i++){
            if (this.array[i] == a) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Exception that trown if you adress to element that doesnt exist
     */
    private class IndexOutOfSizeException extends Exception {
        public IndexOutOfSizeException(String message) {
            super(message);
        }
    }

    /**
     * get size of array
     * @return
     */
    public int getSize(){
        return array.length;
    }

    /**
     * Compare two array
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EA)) return false;
        EA ea = (EA) o;
        return Arrays.equals(array, ea.array);
    }

    /**
     * Create Hashcode of this array
     * @return
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    /**
     * Create Array as to string
     * @return
     */
    @Override
    public String toString() {
        return "{" +
                "This array = " + Arrays.toString(array) +
                '}';
    }
}