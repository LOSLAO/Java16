import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

   public People() {
       System.out.println("LA");
        //this("LA", 18);
//        this.name = "LA";
//        this.age = 18;
   }
   //实例代码块
   {
       System.out.println("实例代码块");
   }
   //静态代码块
    static {

       System.out.println("静态代码块");
   }

   public void show() {
       System.out.println("name: " + name + " age: " + age);
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



public class TestDemo2 {
    public static void main(String[] args) {
        People people = new People();
        People people1 = new People();
    }
    public static void main2(String[] args) {
        People people = new People();
        people.show();
        People people1 = new People("james", 20);
        people1.show();
    }
    public static void main1(String[] args) {
        People people = new People("LA", 20);
        System.out.println(people);

    }


}
