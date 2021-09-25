package 高级数据结构与算法作业._0918.homework;


import java.util.Scanner;
import java.util.Stack;

public class problemC {
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n;
        String operation;
        char c;
        while (true) {
            n = scanner.nextDouble();
            operation = scanner.next();
            if (n == 0 && operation.length() == 0) {
                break;
            }
            Stack<Double> stack = new Stack<>();
            double ans = 0;
            while (!stack.isEmpty()) {
                stack.pop();
            }
            stack.push(n);
            while (true) {
                n = scanner.nextDouble();
                c = scanner.next().charAt(0);
                String other = String.valueOf(c);
                if (other.length() == 0) break;
                if (c == '*') {
                    double tmp = stack.peek() * n;
                    stack.pop();
                    stack.push(tmp);
                } else if (c == '/') {
                    double tmp = stack.peek() / n;
                    stack.pop();
                    stack.push(tmp);
                } else if (c == '+') {
                    stack.push(n);
                } else if (c == '-') {
                    stack.push(-n);
                }
            }
            while (!stack.isEmpty()) {
                ans += stack.peek();
                stack.pop();
            }
            System.out.printf("%.2f\n", ans);
        }
    }

//    #include <cstdio>
//#include <cstring>
//#include <algorithm>
//#include <stack>
//    using namespace std;
//    int main()
//    {
//        int i,j;
//        char c;
//        char s;
//        double n;
//        while(scanf("%lf%c",&n,&c)!=EOF)//开头特殊处理:0 +'\n'时结束;
//        {
//            if(n==0 && c=='\n')
//            {
//                break;
//            }
//            stack<double>st;
//            double ans=0;
//            while(!st.empty())
//            {
//                st.pop();
//            }
//            st.push(n);
//            while(scanf("%c %lf",&s,&n)!=EOF)
//            {
//                if(s=='+')
//                {
//                    st.push(n);
//                }
//                if(s=='-')
//                {
//                    st.push(-n);
//                }
//                if(s=='*')
//                {
//                    double temp=st.top()*n;
//                    st.pop();
//                    st.push(temp);
//                }
//                if(s=='/')
//                {
//                    double temp=st.top()*1.0/n;
//                    st.pop();
//                    st.push(temp);
//                }
//                c=getchar();
//                if(c=='\n')
//                {
//                    break;
//                }
//            }
//            while(!st.empty())
//            {
//                ans+=st.top();
//                st.pop();
//            }
//            printf("%.2lf\n",ans);
//        }
//        return 0;
//    }

}
