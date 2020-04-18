import java.util.Arrays;

public class SortedArraySet<T extends Comparable<? super T>> {
    // There is a fair amount of code being provided for this class. Most of this is stuff that you would already had
    // access to from class slides or code posted with the slides. Some of it is updated/upgraded from what we saw in
    // class and a tiny amount of it is the consequence of code interactions we havn't been able to discuss.

    private T[] data;
    private int size;

    public SortedArraySet(int initialMax) {
        // Provided -- this one can be a bit tricky due to the silly type casting thing again
        // Because of the T extends Comparable<? super T> we have to use Comparable here not Object.
        data = (T[]) new Comparable[initialMax];
        size=0;
    }

    /**
     * Shift the elements of the array starting at a point to the left
     * The element in position endingAt will be deleted overwritten by what used to be left of it
     * This will run through size (not the end of the array)
     * This will set the old "end of array" to be null.
     * This will update size.
     * @param endingAt
     */
    private void shiftLeft(int endingAt) {
        // This is an updated version that definitely won't out-of-bounds access
        // so long as size <= data.length(which should be true anyways)
        for(int i = endingAt+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size = size - 1;
        data[size] = null;
    }

    /**
     * Shift the elements of the array starting at a point to the right
     * The element in position startingAt will be copied appearing both at startingAt and one to the right.
     * This will run through size (not the end of the array)
     * This will update size.
     * @param startingAt
     */
    private void shiftRight(int startingAt) {
        // This is an updated version that definitely won't out-of-bounds access
        // so long as size <= data.length(which should be true anyways)
        for (int i = size-1; i >= startingAt; i--) {
            data[i+1] = data[i];
        }
        // this just effectively added something... better fix size.
        size = size + 1;
    }

    // This one is provided because It's pretty specific and just for testing right now.
    @Override
    public String toString() {
        return Arrays.toString(data)+": "+size;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty(){
        if (this.getSize() == 0){
            return true;
        }
        return false;
    }

    public boolean contains(T elem){
        if (this.find(elem) != -1){
            return true;
        }
        return false;
    }

//    public int scann(T elem){
//        for (int i = 0; i < this.getSize(); i++){
//            if (i != this.getSize() - 1){
//                if ((this.data[i].compareTo(elem) > 0) && (this.data[i + 1].compareTo(elem) < 0)){
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    public void add(T elem){
//        if (this.find(elem) == -1){
//            if (this.getSize() == this.data.length){
//                T[] temp = (T[]) new Comparable[this.data.length * 2];
//                for (int i = 0; i < this.data.length; i++){
//                    temp[i] = this.data[i];
//                }
//                this.data = temp;
//            }
//            int scanned = this.scann(elem);
//            if (scanned != -1){
//                this.shiftRight(scanned);
//                this.data[scanned] = elem;
//            } else {
//                this.shiftRight(this.getSize());
//                this.data[this.getSize() - 1] = elem;
//            }
//        }
//    }

    public void add(T elem){
        if (this.find(elem) == -1){
            if (this.getSize() > this.data.length){

                T[] temp = (T[]) new Comparable[this.data.length * 2];
                for (int i = 0; i < this.getSize(); i++){
                    temp[i] = this.data[i];
                }
                this.data = temp;
            }
            if (this.getSize() <= this.data.length ) {

                System.out.println(this.toString());
                if (this.getSize() == 0){
                    this.data[0] = elem;
                    size ++;
                }else if (this.getSize() == 1){
                    System.out.println("size = " + this.getSize());
                    if (this.data[0].compareTo(elem) > 0) {
                        System.out.println("made it!");
                        this.shiftRight(0);
                        this.data[0] = elem;
                    } else {
                        System.out.println("just chilling here");
                        this.data[1] = elem;
                        size ++;
//we made it here with debugging!!!!!!
                        System.out.println("before our toString");
                        System.out.println(this.data.toString());
                        System.out.println("after our tostring");
                    }
                } else {

                    for (int i = 0; i < this.getSize(); i++) {
                        if (this.data[i].compareTo(elem) > 0) {
                            this.shiftRight(i);
                            this.data[i] = elem;
                        }
                    }
                }
            }


        }
    }


    public void remove(T elem){
        int index = this.find(elem);
        this.shiftLeft(index);
    }


    // and I've given you this template because not writing this function will make this program SUCK
//    private int find(T elem) {
////        int front = 0;
////        int back = this.getSize();
////        int checker = 0;
////        int tooFar = this.getSize();
////        while (front != back){
//////            System.out.println("Front: \n");
//////            System.out.println(front);
//////            System.out.println("Back: \n");
//////            System.out.println(back);
//////            System.out.println("checker: \n");
//////            System.out.println(checker);
////            checker = (int) Math.floor((double) (back - front) / 2) + front;
////            if ( this.data[checker].compareTo(elem) == 0){
////                return checker;
////
////            }
////            if ((back - front) == 1) {
////                return front;
////            }
////            else if (this.data[checker].compareTo(elem) > 0){
////                   back = checker;
////            }else {
////                   front = checker;
////            }
////        }
////        return -1;
////    }

    private int find(T elem) {
        int front = 0;
        int back = this.getSize() - 1;

        while (front <= back) {
            int midpoint = (back - front)/2;
            if (this.data[midpoint].compareTo(elem) > 0) back = midpoint - 1;
            else if (this.data[midpoint].compareTo(elem) < 0) front = midpoint + 1;
            else return midpoint;
        }
        return -1;
    }

    public T getBiggest() {
        int front = 0;
        int back = this.getSize() - 1;
        T biggest = this.data[0];
        int i = 0;
        if (back == 0){
            return this.data[0];
        }
        while (front <= back) {
            if(biggest.compareTo(this.data[i]) > 0 ){
                biggest = this.data[i];
            }
            i++;
        }
        return biggest;
    }
    public T getSmallest() {
        int front = 0;
        int back = this.getSize() - 1;
        T smallest = this.data[0];
        int i = 0;
        if (back == 0){
            return this.data[0];
        }
        while (front <= back) {
            if(smallest.compareTo(this.data[i]) < 0 ){
                smallest = this.data[i];
            }
            i++;
        }
        return smallest;
    }

}
