学习笔记
一、数组
    一段有序的元素序列(同一类型的数据)
    数据类型：byte short int long double flout char String

                        时间复杂度
        add :               O1              首尾插入
        delete:             On              需要遍历，做需要复制移动的操作
        insert:             On              需要遍历，做需要复制移动的操作
        lookup：            O1              拿到索引，直接可以查看任何一个元素

二、LinkedList （链表）
    一段首尾相连的元素序列，有next指针和prev指针,分别是指向下一个元素和上一个

                        时间复杂度
        add :               O1              首尾插入
        delete:             O1              把链表需要删除元素的上一个元素指针指向删除的元素的后一个元素上，当前元素删除
        insert:             O1              把链表对应元素的指针指向插入的元素，插入的元素指针指向链接的元素
        lookup：            On              需要遍历，指针去一步一步移动，获取元素

三、Skip LinkedList(跳表）
    专门针对连续的链表结构做数据查询处理，弥补链表的缺陷,优化查询On
    原理：
        1、升维度 ：增加多级索引   所以高度logn 时间复杂度O(logn)
        2、空间换时间 空间复杂度On

四、栈 Stack
    
原理：先进后出（first-in-last-out）
    继承Vector，本质就是一个集合
   
     方法：

        empty() 是否为空
        peek() 在不将其从堆栈中移除的情况下，查看该堆栈顶部的对象。
        pop()删除此堆栈顶部的对象，并将该对象作为此函数的值返回
        push(E item) 将项目推入此堆栈的顶部
        search(Object o) 返回对象在此堆栈上的从1开始的位置。

    代码：
        Stack<String> stack = new Stack<>();
        stack.push("1");     
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        System.out.println(stack.empty());  //false
        System.out.println(stack.peek());  //5
        System.out.println(stack.size());  //5
        System.out.println(stack.pop());  //5
        System.out.println(stack.size());  //4
        System.out.println(stack.search(2));  //2

五、队列 
    
1)普通队列 Queue
        原理：先进先出（first-in-first-out）
        继承Collection，本质就是一个集合

        方法：

                    Throws exception        Returns special value
            Insert        add(e)                    offer(e)         
            Remove        remove()                  poll()
            Examine       element()                 peek()         //检查 查看对象
        代码：
                Queue<String> queue = new LinkedList<>();
                queue.offer("1");
                queue.offer("2");
                queue.offer("3");
                queue.offer("4");
                queue.offer("5");
        
        
                System.out.println(queue.size());  //5
                System.out.println(queue.poll());  //5
                System.out.println(queue.size());  //4
                System.out.println(queue.peek());  //4
                System.out.println(queue);      //2345

2）双端队列 Deque
    原理：两边都可以添加和删除
    继承Queue，本质就是一个集合
  
      方法：
        
                       Throws exception        Returns special value
            从头插入
            Insert        addFirst(e)               offerFirst(e)       
            Remove        removeFirst()             pollFirst()
            Examine       getFirst()                peekFirst()  //检查 查看对象
            从尾部插入
            Insert        addLast(e)                offerLast(e)       
            Remove        removeLast()              pollLast()
            Examine       getLast()                 peekLast()  //检查 查看对象
        
        该接口扩展了Queue接口。当双端队列用作队列时，将导致FIFO（先进先出）行为。元素在双端队列的末尾添加，并从开头删除。从Queue接口继承的方法与Deque方法完全等效
        双端队列也可以用作LIFO（后进先出）堆栈。该接口应优先于旧Stack类使用。当双端队列用作堆栈时，元素从双端队列的开始处被压入并弹出。堆栈方法完全等同于 Deque方法

2）优先队列 PriorityQueue        插入O1  取出O(logN)
    原理：底层实现的数据结构较为多样和复杂：heap,bst ，红黑数
    继承AbstractQueue，底层增删改查是数组操作
        
    方法：
        
        boolean	                    add(E e)		    将指定的元素插入此优先级队列。
        void	                    clear()		        从此优先级队列中删除所有元素。
        Comparator<? super E>	    comparator()		返回用于对队列中的元素进行排序的比较器，或者返回null根据该队列的自然顺序对队列进行排序的比较器。
        boolean	                    contains(Object o)	返回true此队列是否包含指定的元素。
        Iterator<E>	                iterator()		    返回对该队列中的元素进行迭代的迭代器。
       
        boolean	                    offer(E e)		    将指定的元素插入此优先级队列。
        boolean	                    remove(Object o)	从该队列中删除指定元素的单个实例（如果存在）。
        Spliterator<E>	            spliterator()		在此队列中的元素上创建后期绑定 和故障 Spliterator转移。
        Object[]	                toArray()		    返回一个包含此队列中所有元素的数组。
        <T> T[]	                    toArray(T[] a)		返回一个包含此队列中所有元素的数组；返回数组的运行时类型是指定数组的运行时类型。
    


















