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
