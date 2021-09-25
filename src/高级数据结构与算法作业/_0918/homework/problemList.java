package 高级数据结构与算法作业._0918.homework;

public class problemList {
//问题 A: Windows Message Queue
//Message queue is the basic fundamental of windows system. For each process, the system maintains a message queue.
//If something happens to this process, such as mouse click, text change, the system will add a message to the queue.
//Meanwhile, the process will do a loop for getting message from the queue according to the priority value if it is not empty.
//Note that the less priority value means the higher priority.
//In this problem, you are asked to simulate the message queue for putting messages to and getting message from the message queue.


//问题 B: Scaena Felix
//Given a parentheses sequence consist of '(' and ')', a modify can filp a parentheses, changing '(' to ')' or ')' to '('.
//If we want every not empty <b>substring</b> of this parentheses sequence not to be "paren-matching", how many times at least to modify this parentheses sequence?
//For example, "()","(())","()()" are "paren-matching" strings, but "((", ")(", "((()" are not.

//问题 C: 简单计算器
//读入一个只包含 +, -, *, / 的非负整数计算表达式，计算该表达式的值。


//问题 D: 队列和栈
//队列和栈是两种重要的数据结构，它们具有push k和pop操作。push k是将数字k加入到队列或栈中，pop则是从队列和栈取一个数出来。队列和栈的区别在于取数的位置是不同的。
//队列是先进先出的：把队列看成横向的一个通道，则push k是将k放到队列的最右边，而pop则是从队列的最左边取出一个数。
//栈是后进先出的：把栈也看成横向的一个通道，则push k是将k放到栈的最右边，而pop也是从栈的最右边取出一个数。
//假设队列和栈当前从左至右都含有1和2两个数，则执行push 5和pop操作示例图如下：
//push 5  pop
//队列 1 2  ------->  1 2 5 ------>  2 5
//push 5  pop
//栈   1 2  ------->  1 2 5 ------>  1 2
//现在，假设队列和栈都是空的。给定一系列push k和pop操作之后，输出队列和栈中存的数字。若队列或栈已经空了，仍然接收到pop操作，则输出error。


//问题 E: 栈
//栈是计算机中经典的数据结构，简单的说，栈就是限制在一端进行插入删除操作的线性表。
//栈有两种最重要的操作，即pop（从栈顶弹出一个元素）和push（将一个元素进栈）。
//栈的重要性不言自明，任何一门数据结构的课程都会介绍栈。宁宁同学在复习栈的基本概念时，想到了一个书上没有讲过的问题，而他自己无法给出答案，所以需要你的帮忙。
//宁宁考虑的是这样一个问题：一个操作数序列，从1，2，一直到n（图示为1到3的情况），栈A的深度大于n。
//现在可以进行两种操作：
//1. 将一个数，从操作数序列的头端移到栈的头端（对应数据结构栈的push操作）
//2. 将一个数，从栈的头端移到输出序列的尾端（对应数据结构栈的pop操作）
//使用这两种操作，由一个操作数序列就可以得到一系列的输出序列，下图所示为由1 2 3生成序列2 3 1的过程。（原始状态如上图所示）
//你的程序将对给定的n，计算并输出由操作数序列1，2，...，n经过操作可能得到的输出序列的总数。
}

