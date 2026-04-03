class DynamicArray {

    int[] myArray;
    int limit;
    int top ;

    public DynamicArray(int capacity) {
        myArray = new int[capacity];
        limit = capacity-1;
        top=0;
        
    }

    public int get(int i) {
        return myArray[i];
    }

    public void set(int i, int n) {
        myArray[i] = n;
    }

    public void pushback(int n) {
        if(top == limit+1){
            resize();
        }
        myArray[top++] = n;

    }

    public int popback() {
        if (top > 0) {
            top--;
        }
        
        return myArray[top];

    }

    private void resize() {
        int capacity = (limit+1) *2;
        int[] newArray = new int[capacity];
        for (int i=0; i<=limit; i++){
            newArray[i] = myArray[i];
        }
        myArray = newArray;
        limit = capacity-1;

    }

    public int getSize() {
        return top;
    }

    public int getCapacity() {
        return limit+1;

    }
}
