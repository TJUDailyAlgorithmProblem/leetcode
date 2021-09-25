package 高级数据结构与算法作业._0918.exercise;

public class problemC {
/*
#include<iostream>
using namespace std;
const int maxn=201;
int main()
{
    double temp,ans[maxn];
    char ch;
    while(cin>>temp&&temp)
    {
        int num=0;
        double sum=0;
        ans[num]=temp;
        while(cin>>ch>>temp)
        {
            switch(ch)  //只对乘号和除号进行数值运算
            {
            case '+':ans[++num]=temp;  //若遇加号，则把值存入数组
                break;
            case '-':ans[++num]=-temp;  //若遇加号，则把值的相反数存入数组
                break;
            case '*':ans[num]*=temp;  //若遇乘号，则与前一个数值相乘后存入数组
                break;
            case '/':ans[num]/=temp;  ////若遇除号，则与前一个数值相除后存入数组
                break;
            }
            char c=cin.get();
            if(c=='')
                break;
        }
        for(int i=0;i<=num;i++)  //对已经进行完的乘号和除号数值运算的值累加
            sum+=ans[i];
        printf("%0.2f",sum);
    }
    return 0;
}
    * */
}
