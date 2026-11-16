import java.util.Arrays;

public class List<T> {
    private T[] arr;
    private int n;

    @SuppressWarnings("unchecked")
    public List() {
        arr = (T[])new Object[4];
        n = 0;
    }

    public int size() {
        return n;
    }

    public T get(int i) {
        return arr[i];
    }
    
    public void add(T val) {
        if (n == arr.length) {
            arr = Arrays.copyOf(arr, arr.length*2);
        }
        arr[n++] = val;
    }

    public T remove(int i) {
        T val = arr[i];
        for (int j = i; j < n-1; j++) {
            arr[j] = arr[j+1];
        }
        n--;
        if (4*n < arr.length) {
            arr = Arrays.copyOf(arr, arr.length/2);
        }
        return val;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < n; i++) {
            if (i > 0) s += ", ";
            s += arr[i];
        }
        return s + "]";
    }

    public static void main(String[] args) {
        List<Integer> primes = new List<Integer>();

        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        System.out.println(primes);

        List<String> alphabet = new List<String>();
        alphabet.add("Alpha");
        alphabet.add("Bravo");
        alphabet.add("Charlie");
        System.out.println(alphabet);
    }
}
