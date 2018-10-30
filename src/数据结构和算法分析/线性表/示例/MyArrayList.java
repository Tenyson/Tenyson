package 数据结构和算法分析.线性表.示例;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 类的定义：自定义的ArrayList的实现类
 * 类的内容：实现了一些基本功能如 size、doClear、isEmpty、trimToSize、get、set、add、ensureCapacity、MyArrayListIterator
 * User: Tenyson
 * Date: 2018-09-25
 * Time: 下午3:17
 */
public class MyArrayList<E> implements Iterable<E> {

    private ArrayList lsit;

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;

    private E[] theItems;

    public MyArrayList(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    private void doClear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void trimToSize(){
        ensureCapacity( size() );
    }

    public E get(int idx){
        if(idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public E set(int idx, E newVal){
        if(idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        E oldItem = theItems[idx];
        theItems[idx] = newVal;
        return  oldItem;
    }

    /**
     * 方法功能：对ArrayList集合中的数组进行扩容
     * 程序步骤：1、如果指定扩容大小小于目前的数组容量大小，则不扩容
     *         2、如果指定扩容大小大于目前数组大小，则扩容
     *         3、按照扩展大小，新生成一个数组
     *         4、把旧数组元素放入新数组中
     */
    public void ensureCapacity(int newCapacity){
        if(newCapacity < theSize){
            return;
        }
        E[] oldItems = theItems;
        theItems = (E[]) new Object[newCapacity];
        for(int i = 0; i < size(); i++){
            theItems[i] = oldItems[i];
        }
    }

    /**
     * 方法功能：根据指定位置，向集合中增加一个元素
     * 程序步骤：1、判断ArrayList集合中，Array空间是否够用，如果不够用需要扩容，+1是防止size为0
     *         2、要将指定位置后面的数据统一往后移动一位
     *         3、在指定位置放入数据
     *         4、数组大小加1.
     */
     public void add(int idx, E newVal){
         if(theItems.length == size()){
             ensureCapacity( size() * 2 + 1);
         }
         for(int i = theSize; i > idx ; i--){
             theItems[i] = theItems[i-1];
         }
         theItems[idx] = newVal;
         theSize ++;
     }

    /**
     * 方法功能：不指定位置，向集合中添加一个元素，默认是在数组末尾添加此元素
     * 程序步骤：调用重载方法add(int idx, E newVal),idx设置成当前数组大小值
     */
     public boolean add(E newVal){
         add(size(), newVal);
         return true;
     }

    /**
     * 方法功能：根据指定位置，从集合中移除一个元素
     * 程序步骤：1、将指定位置后面的数据统一向前移动一位
     *         2、集合中数组大小减1
     */
     public E remove(int idx){
         E removeItem = theItems[idx];
         for(int i = idx; i < size() - 1; i ++){
                theItems[i] = theItems[i+1];
         }
         theSize --;
         return removeItem;
     }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * 类的定义：ArrayList的内部迭代器类
     */
    private class ArrayListIterator implements Iterator<E>{

        // current position代表能被看见的下一个元素数组下标，所以从0开始
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove(){
            MyArrayList.this.remove( --current);
        }
    }
}
