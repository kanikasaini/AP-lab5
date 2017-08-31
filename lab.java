//Kanika Saini 2016047
import java.util.*;
import java.lang.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;
import java.io.FileReader;

class Node<T>
{
      public T data;
      public Node<T> left;
      public Node<T> right;
      public Node(T data)
      {
         this.data= data;
         this.left= null;
         this.right= null;
      }
      @Override
      public String toString()
      {
         return data.toString();
      }
}
class student
{
    private int rollno;
    private ArrayList<String> answer;
    public int size=0;
    public student(int r)
    {
        this.rollno= r;
    }
    public int getRoll()
    {
        return rollno;
    }
    public void addAns(String a)
    {
        answer.add(a);
        size++;
    }
    public void printAns()
    {
        System.out.println("Roll no is" +rollno);
        for(String a: answer)
            System.out.print(a+" ");
    }
}

class BST <T extends Comparable<T>>
{
   public static void main(String[] args) throws Exception
   {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String[] input = inp.readLine().trim().split("\\s+");
        int x=Integer.parseInt(input[0]); //no of trees
        int n=Integer.parseInt(input[1]);  //no of nodes in a tree = no of children
        ArrayList<BST> list = new ArrayList<BST>();
        for(int i=1; i<=x; i++)
        {
            String filename = i+".txt"; 
            inp = new BufferedReader(new FileReader(filename));
            String c = inp.readLine();
            if(c.equals("Integer"))
            {
                n = Integer.parseInt(inp.readLine());
                BST<Integer> tempbst = new BST<Integer>();
                tempbst.type=c;
                input = inp.readLine().trim().split("\\s+");
                for(int j=0; j<n ; j++)
                {
                    tempbst.insert(new Integer(input[j]));
                }
                list.add(tempbst);
            }
            else if (c.equals("Float"))
            {
                n = Integer.parseInt(inp.readLine());
                BST<Float> tempbst = new BST<Float>();
                tempbst.type=c;
                input = inp.readLine().trim().split("\\s+");
                for(int j=0; j<n ; j++)
                {
                    tempbst.insert(new Float(input[j]));
                }
                list.add(tempbst);
            }
            else if(c.equals("String"))
            {
                n = Integer.parseInt(inp.readLine());
                BST<String> tempbst = new BST<String>();
                tempbst.type=c;
                input = inp.readLine().trim().split("\\s+");
                for(int j=0; j<n ; j++)
                {
                    tempbst.insert(new String(input[j]));
                }
                list.add(tempbst);
            }
        }
        int choc;
        choc=n;
        student[] stu = new student[n+1];
                        String plus;
                        plus="";
        for(BST it: list)
        {    
            if(it.type.equals("Integer"))
            {
                ArrayList<Integer> sum= new ArrayList<Integer>();
                it.traversal(sum);
            if(stu[it.index]==null)
            {
                    stu[it.index]= new student(it.index);
                    choc=choc-1;
            }
                plus="";
                int z=0;
                for(Integer a: sum)
                    z+=a;
                plus+=z;
            }
            else if(it.type.equals("Float"))
            {
                ArrayList<Float> sum= new ArrayList<Float>();
                it.traversal(sum);
            if(stu[it.index]==null)
            {
                    stu[it.index]= new student(it.index);
                    choc=choc-1;
            }
                plus="";
                float z=0;
                for(Float a: sum)
                    z+=a;
                plus+=z;
            }
            else  if(it.type.equals("String"))
            {
                ArrayList<String> sum= new ArrayList<String>();
                it.traversal(sum);
            if(stu[it.index]==null)
            {
                    stu[it.index]= new student(it.index);
                    choc=choc-1;
            }
                plus="";
                String z="";
                for(String a: sum)
                    z+=a;
                plus+=z;
            }
            stu[it.index].addAns(plus);
        }
        for(int i=1; i<=n; i++)
        {
            if(stu[i]!=null)
            {
                stu[i].printAns();
            }
        }
        System.out.println(choc);       
   }

   public String type;
   private Node<T> root;
   private int index;
   public BST()
   {
      root = null;
   }
   public void insert(T data)
   {
      root = add(root, data);
   }
   private Node<T> add(Node<T> p, T toInsert)
   {
      if (p == null)
         return new Node<T>(toInsert);

      if (toInsert.compareTo(p.data) < 0)
         p.left = add(p.left, toInsert);
      else
         p.right =add(p.right, toInsert);

      return p;
   }
   public void traversal(ArrayList<T> l)
   {
        //sum=null;
      inOrder(root, 0, root.data, l);
   }
   private void inOrder(Node<T> r, int count, T val, ArrayList<T> l)
   {
      if (r!= null)
      {
        inOrder(r.left, count, val, l); 
        count+=1;
        if(val.compareTo(r.data)==0)
            index=count;
        System.out.print(r+" ");
        l.add(r.data);
        inOrder(r.right, count, val, l);
      }
   }

   
}

