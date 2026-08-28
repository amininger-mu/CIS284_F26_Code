public class Arguments {
   
    public static void main(String[] args) {
        System.out.println("There are " + args.length + " arguments");
        int i = 0;
        while (i < args.length) {
            System.out.println("args[" + i + "] = " + args[i]);
            i++;
        }
    }
}
