public class draw {
    public static void main(String[] args) {
        int size = 5;
        int row = 1;
        int col = 1;
        while (row <= size) { 
           while (col < row) {
              System.out.print('*');
              col = col + 1;
           }
           System.out.println('*');
           row = row + 1;
           col = 1;
        }
    }
}