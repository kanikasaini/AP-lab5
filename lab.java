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
class student<T>
{
    private int rollno;
    private ArrayList<T> answer;
    public student(int r)
    {
        this.rollno= r;
    }
    public int getRoll()
    {
        return rollno;
    }
    public void addAns(T a)
    {
        answer.add(a);
    }
    public void printAns()
    {
        for(T a: answer)
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
        int n=Integer.parseInt(input[1]);  //no of nodes in a tree
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
                input = inp.readLine().trim().split("\\s+");
                for(int j=0; j<n ; j++)
                {
                    tempbst.insert(new String(input[j]));
                }
                list.add(tempbst);
            }
        }
        for(BST it: list)
            it.traversal();
        System.out.println();       
   }

   private Node<T> root;
   private int index;
  // private ArrayList<T> sum= new ArrayList<T>;
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
   public void traversal()
   {
        //sum=null;
      inOrder(root, 1);
   }
   private void inOrder(Node r, int count)
   {
      if (r!= null)
      {
        inOrder(r.left, count+1); 
        System.out.print(r+" ");
        inOrder(r.right, count+1);
      }
   }

   
}

