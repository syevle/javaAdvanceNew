package javaPractice.javaCollection;

/**
 * Created by Santosh on 5/22/17.
 */
class MyList {


    public Object ob;
    public MyList next;

    public MyList(Object ob){
        this.ob=ob;
    }
}



public class MyLinkedList {

    private MyList first=null;
    private MyList last=null;

    public MyLinkedList (){

    }
    public void add(Object o){
        if(first == null){
            first = last= new MyList(o);
        }else{
            last.next = new MyList(o);
            last= last.next;
        }
    }
    private void getData(){
        MyList temp =first;
        do{
            System.out.println(temp.ob + " ");
            temp=temp.next;
        }while(temp != null);

    }
    private void delete(Object o){
        MyList temp =first;
        MyList prev =null;

        do{
            if(temp.ob.equals(o)){
                prev.next=temp.next;
                break;
            }
            prev = temp;
            temp=temp.next;
        }while(temp != null);

    }

    public static void main(String args[]){
        MyLinkedList lst = new MyLinkedList();
        lst.add(6);
        lst.add(62);
        lst.add(16);
        lst.add(65);
        lst.add(26);
        lst.add(25);
        System.out.println("After Insert");
        lst.getData();
        lst.delete(16);
        System.out.println("After Delete");
        lst.getData();

    }
}