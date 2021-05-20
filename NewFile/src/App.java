public class App {
    
    public static int i =1;

    public void method1 (){
        System.out.println("method1");
        System.out.println(i);
    }

    public void method2 (){
        method1();
        System.out.println("method2");
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        App app = new App();
        app.method2();
        String array[][] = { {"A","B"},{null},{"C","D"}};
        for (String[] tmp : array) {
            System.out.println(tmp.length);

        }

        int total =0;
        a: for (int i=0; i<5; i++){
            b: for(int j=0; j<5; j++){
                if(i%2==0)continue a;
                if(3<j)break b;
                total +=j;
            }
        }
        System.out.println(total);
    }
}
